package com.dxunited.ruleengine.service;

import com.dxunited.ruleengine.entity.SzProjectRules;
import com.dxunited.ruleengine.entity.SzRuleDetails;
import com.dxunited.ruleengine.entity.SzRuleProject;
import com.dxunited.ruleengine.model.*;
import com.dxunited.ruleengine.adopter.RuleEngineConnector;
import com.dxunited.ruleengine.entity.SzRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Ram Prasad
 */
@Service
@Slf4j
public class CustomerRuleService {

    @Autowired
    RuleEngineConnector ruleEngineConnector;

    /**
     * This method is used to create Rule.
     * @param ruleDetails
     * @param ruleProject
     * @return
     */
    @Transactional
    public ResponseDetails createSyzegeeRule(RuleDetails ruleDetails, SzRuleProject ruleProject ){

        log.info("Entered into the create SyzegeeRule. ");

//        SzRuleProject syzegeeRuleProject = getSyzegeeProjectByProjectId(ruleDetails.getProjectDetail().getProjectId());

        System.out.println("calling createSyzegeeRule details....1");

       //calling createSyzegeeRule method to save ruledetails.
        SzRule syzegeeRule = ruleEngineConnector.createSyzegeeRule(ruleDetails.getRuleNameDetails());

        System.out.println("calling ruleEngineConnector  details....2");

        //calling createSyzegeeRuleDetails to save attributes
        createSyzegeeRuleDetails(ruleDetails.getRuleAttributeDetails(),syzegeeRule);

        System.out.println("calling ruleEngineConnector  details....3");

        //calling createSyzegeeProjectRule to save rulevalues.
        createSyzegeeProjectRule( ruleDetails.getRuleValueDetails(),ruleProject,syzegeeRule);

        System.out.println("calling ruleEngineConnector  details....4");

        ResponseDetails responseDetail =ResponseDetails.builder().projectId(syzegeeRule.getRuleId()).
                correlationId("100"+syzegeeRule.getRuleId()).message("Rule Created successfully").build();
        return responseDetail;
    }

    /**
     * This method is used to update Rule.
     * @param customerRuleDetails
     * @return
     */
    @Transactional
    public ResponseDetails updateSyzegeeRule(RuleDetails customerRuleDetails){
        log.info("Entered into the update SyzegeeRule. ");
        SyzegeeRuleDetail syzegeeRuleDetail = customerRuleDetails.getRuleNameDetails();
        SzRule szRule = ruleEngineConnector.updateSyzegeeRule(syzegeeRuleDetail);
        List<SyzegeeRuleDtlDetail> syzegeeRuleDtlDetails = customerRuleDetails.getRuleAttributeDetails();
        for (SyzegeeRuleDtlDetail ruleDetails: syzegeeRuleDtlDetails  ) {
            SzRule SzRuleId = ruleEngineConnector.getSyzegeeRuleBySzRuleId(ruleDetails.getRuleId());
            updateSyzegeeRuleDetail(ruleDetails,SzRuleId);
        }
        List<SyzegeeProjectRulesDetail> syzegeeProjectRulesDetails = customerRuleDetails.getRuleValueDetails();
        for (SyzegeeProjectRulesDetail syzegeeProjectRulesDetail: syzegeeProjectRulesDetails) {
            SzRuleProject ruleProjectByProjectId = ruleEngineConnector.getRuleProjectByProjectId(syzegeeProjectRulesDetail.getProjectId());
            SzRule syzegeeRuleBySzRuleId = ruleEngineConnector.getSyzegeeRuleBySzRuleId(syzegeeProjectRulesDetail.getRuleId());
            updateSyzegeeProjectRules(syzegeeProjectRulesDetail,ruleProjectByProjectId,szRule);
        }
        ResponseDetails responseDetail =ResponseDetails.builder().projectId(1).correlationId("1003").message("successfull").build();
    return responseDetail;
    }

    /**
     * This method is used to update Rule Attribute.
     * @param ruleDetails
     * @param SzRuleId
     */
    @Transactional
    public void updateSyzegeeRuleDetail(SyzegeeRuleDtlDetail ruleDetails,SzRule SzRuleId){
        log.info("Entered into the update SyzegeeRuleDetai. ");
        SzRuleDetails ruleDetails1 = ruleEngineConnector.updateSyzegeeRuleDetail(ruleDetails, SzRuleId);
    }

    /**
     * This method is used to update Rule Project.
     * @param ruleProjectDetail
     * @return
     */
    @Transactional
    public ResponseDetails updateSyzegeeRuleProject(RuleProjectDetail ruleProjectDetail){
        log.info("Entered into the update SyzegeeRuleProject. ");
        SzRuleProject ruleProject = ruleEngineConnector.updateRuleProject(ruleProjectDetail);
        System.out.println("calling  CreateSyzegeeRule Method to add rules.");
        if(ruleProjectDetail.getRuleDetails()!=null){
            createSyzegeeRule(ruleProjectDetail.getRuleDetails(),ruleProject);
        }
        ResponseDetails responseDetails=ResponseDetails.builder().projectId(ruleProject.getProjectId()).correlationId("100")
                .message("Updated Rule Project Name : "+ruleProject.getProjectName()+" Successfully").build();
        return responseDetails;
    }

    /**
     * This method is used to update ProjectRules.
     * @param syzegeeProjectRulesDetail
     * @param ruleProjectId
     * @param SzRuleId
     */
    @Transactional
    public void updateSyzegeeProjectRules(SyzegeeProjectRulesDetail syzegeeProjectRulesDetail, SzRuleProject ruleProjectId,SzRule SzRuleId ){
        log.info("Entered into the update SyzegeeProjectRules. ");
        SzProjectRules projectRules = ruleEngineConnector.updateProjectRule(syzegeeProjectRulesDetail, ruleProjectId, SzRuleId);
    }

    /**
     * This method is used to create Rule Attributes.
     * @param syzegeeRuleDtlDetails
     * @param szRule
     */
    @Transactional
    public void createSyzegeeRuleDetails( List<SyzegeeRuleDtlDetail> syzegeeRuleDtlDetails,SzRule szRule){
        SzRuleDetails syzegeeRuleDetail =null;
        log.info("Entered into the create SyzegeeRulesdetails. ");
                for (SyzegeeRuleDtlDetail syzegeeRuleDtlDetail : syzegeeRuleDtlDetails) {
            syzegeeRuleDetail = ruleEngineConnector.createSyzegeeRuleDetail(syzegeeRuleDtlDetail, szRule);
        }
    }

    /**
     * This method is used to create Rule Project.
     * @param ruleProjectDetail
     * @return
     */
    @Transactional
    public ResponseDetails createSyzegeeRuleProject(RuleProjectDetail ruleProjectDetail){
        log.info("Entered into the create SyzegeeRuleProject.");
        SzRuleProject ruleProject = ruleEngineConnector.createRuleProject(ruleProjectDetail);

        System.out.println("calling  CreateSyzegeeRule Method to add rules.");
        if(ruleProjectDetail.getRuleDetails()!=null){
            createSyzegeeRule(ruleProjectDetail.getRuleDetails(),ruleProject);
        }

        ResponseDetails responseDetails=ResponseDetails.builder().projectId(ruleProject.getProjectId()).
                correlationId("100"+ruleProject.getProjectId()).message(ruleProject.getProjectName()+" : Created Successfully").build();
        return responseDetails;
    }

    /**
     * This method is used to create Rules.
     * @param syzegeeProjectRulesDetails
     * @param szRuleProject
     * @param szRule
     */
    @Transactional
    public void createSyzegeeProjectRule( List<SyzegeeProjectRulesDetail> syzegeeProjectRulesDetails, SzRuleProject szRuleProject,SzRule szRule) {
        SzProjectRules projectRule=null;
        log.info("Entered into the create SyzegeeProjectRule. ");
        for (int i = 0; i < syzegeeProjectRulesDetails.size(); i++) {
             projectRule = ruleEngineConnector.createProjectRule(syzegeeProjectRulesDetails.get(i), szRuleProject, szRule);
        }
   }

    /**
     * This method is used to get Rule Project by customerId.
     * @param customerId
     * @return
     */
    @Transactional
   public SzRuleProject getCustomerRules(String customerId){
       SzRuleProject ruleProjectByCustomerId = ruleEngineConnector.getRuleProjectByCustomerId(customerId);
                     return  ruleProjectByCustomerId;
   }

    /**
     * This method is used to delete Rule Project by customerId
     * @param customerId
     * @return
     */
    @Transactional
   public CustomerDeleteResponseDetails deleteCustomerRules(String customerId){
       log.info("Entered into the  delete CustomerRules By customerId. ");
       SzRuleProject ruleProjectByCustomerId = ruleEngineConnector.getRuleProjectByCustomerId(customerId);

       List<SzProjectRules> allSzProjectRulesByProjectId = ruleEngineConnector
               .getAllSzProjectRulesByProjectId(ruleProjectByCustomerId.getProjectId());

       for (SzProjectRules projectRules:allSzProjectRulesByProjectId){
           int i = ruleEngineConnector.deleteProjectRuleByProRuleId(projectRules.getProjectRulesId());
       }
       ruleEngineConnector.deleteRuleProjectByProjectId(ruleProjectByCustomerId.getProjectId());
       CustomerDeleteResponseDetails responseDetails=CustomerDeleteResponseDetails.builder().customerID(customerId)
               .result(Boolean.TRUE).message("Customer Deleted Successfully ").build();
       return responseDetails;
   }

    /**
     * This method is used to get ProjectId.
     * @param projectId
     * @return
     */
    @Transactional
   public SzRuleProject getSyzegeeProjectByProjectId(long projectId){
       SzRuleProject ruleProject = ruleEngineConnector.getRuleProjectByProjectId(projectId);
       return ruleProject;
   }

    @Transactional
   public ResponseDetails addrulesToProject(RuleProjectDetail ruleProjectDetail){
       SzRuleProject ruleProject = getSyzegeeProjectByProjectId(ruleProjectDetail.getProjectId());
       SzRule syzegeeRule = ruleEngineConnector.createSyzegeeRule(ruleProjectDetail.getRuleDetails().getRuleNameDetails());
       createSyzegeeRuleDetails(ruleProjectDetail.getRuleDetails().getRuleAttributeDetails(),syzegeeRule);
       createSyzegeeProjectRule( ruleProjectDetail.getRuleDetails().getRuleValueDetails(),ruleProject,syzegeeRule);

       ResponseDetails responseDetail =ResponseDetails.builder().projectId(syzegeeRule.getRuleId()).
               correlationId("100"+syzegeeRule.getRuleId()).message("Rule added successfully").build();
       return responseDetail;

   }



}
