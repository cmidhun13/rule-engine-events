package com.syzegee.ruleengine.adopter;

import com.syzegee.ruleengine.model.*;
import com.syzegee.ruleengine.entity.SzProjectRules;
import com.syzegee.ruleengine.entity.SzRuleDetails;
import com.syzegee.ruleengine.entity.SzRuleProject;
import com.syzegee.ruleengine.repository.SZProjectRulesRepository;
import com.syzegee.ruleengine.repository.SZRuleDetailsRepository;
import com.syzegee.ruleengine.repository.SZRuleProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.syzegee.ruleengine.repository.SZRuleRepository;
import com.syzegee.ruleengine.entity.SzRule;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;


/**
 * Ram Prasad
 */
@Slf4j
@Component
public class RuleEngineConnector {

    private static final Logger logger = LogManager.getLogger(RuleEngineConnector.class);

    @Autowired
    private SZRuleRepository szRuleRepository;

    @Autowired
    private SZRuleDetailsRepository szRuleDetailsRepository;

    @Autowired
    private SZRuleProjectRepository szRuleProjectRepository;

    @Autowired
    private SZProjectRulesRepository szProjectRulesRepository;

    /**
     * This method is used to create SyzegeeRule
     * @param ruleDetail
     * @return
     */
    public SzRule createSyzegeeRule(SyzegeeRuleDetail ruleDetail){
        SzRule szRule=SzRule.builder().ruleCode(ruleDetail.getRuleCode()).ruleName(ruleDetail.getRuleName())
        .ruleDesc(ruleDetail.getRuleDesc()).isActive(Boolean.TRUE).createdBy(ruleDetail.getCreatedBy())
        .createdDate(ruleDetail.getCreatedDate()).build();
        log.info("SyzegeeRule name is "+ ruleDetail.getRuleName());
        SzRule ruleEntity = szRuleRepository.save(szRule);

        return ruleEntity;
    }

    /**
     * This method is used to update SyzegeeRule
     * @param ruleDetail
     * @return
     */
    public SzRule updateSyzegeeRule(SyzegeeRuleDetail ruleDetail){
        SzRule szRule=SzRule.builder().ruleCode(ruleDetail.getRuleCode()).ruleName(ruleDetail.getRuleName())
                .ruleDesc(ruleDetail.getRuleDesc()).isActive(Boolean.TRUE).createdBy(ruleDetail.getCreatedBy())
                .createdDate(ruleDetail.getCreatedDate()).build();
        log.info("Update SyzegeeRule name is "+ ruleDetail.getRuleName());
        SzRule ruleEntity = szRuleRepository.save(szRule);
        return ruleEntity;
    }

    /**
     * This method is used to get SyzegeeRule by szruleId
     * @param szRuleId
     * @return
     */
    public SzRule getSyzegeeRuleBySzRuleId(long szRuleId){
        SzRule ruleEntity = szRuleRepository.getSzRuleById(szRuleId);
        log.info("SyzegeeRule By Id "+ szRuleId);
        return ruleEntity;
    }

    /**
     * This method is used to delete SyzegeeRule by szruleId
     * @param szRuleId
     * @return
     */
    public int deleteSzRuleBySzRuleId(long szRuleId){
        int i = szRuleRepository.deleteSzRuleById(szRuleId);
        log.info("Delete SyzegeeRule By Id "+ szRuleId);
        return i;
    }

    /**
     * This method is used to create SyzegeeRuleDetail
     * @param szRuleDetails
     * @param szRule
     * @return
     */
    public SzRuleDetails createSyzegeeRuleDetail(SyzegeeRuleDtlDetail szRuleDetails, SzRule szRule){
        SzRuleDetails ruleDetail = SzRuleDetails.builder().ruleId(szRule).ruleDetailCode(szRuleDetails.getRuleDetailCode())
                .ruleDetailValue(szRuleDetails.getRuleDetailValue()).isActive(Boolean.TRUE)
                .createdBy(szRuleDetails.getCreatedBy()).createdDate(szRuleDetails.getCreatedDate()).build();
        log.info(" SyzegeeRuleDetail Value Is "+ szRuleDetails.getRuleDetailValue());
        SzRuleDetails ruleDetailEntity= szRuleDetailsRepository.save(ruleDetail);
        return ruleDetailEntity;
    }

    /**
     * This method is used to update SyzegeeRuleDetail
     * @param szRuleDetails
     * @param szRule
     * @return
     */
    public SzRuleDetails updateSyzegeeRuleDetail(SyzegeeRuleDtlDetail szRuleDetails, SzRule szRule){
        SzRuleDetails ruleDetail = SzRuleDetails.builder().ruleId(szRule).ruleDetailCode(szRuleDetails.getRuleDetailCode())
                .ruleDetailValue(szRuleDetails.getRuleDetailValue()).isActive(Boolean.TRUE)
                .createdBy(szRuleDetails.getCreatedBy()).createdDate(szRuleDetails.getCreatedDate()).build();
        log.info("Update SyzegeeRuleDetail Value Is "+ szRuleDetails.getRuleDetailValue());
        SzRuleDetails ruleDetailEntity= szRuleDetailsRepository.save(ruleDetail);
        return ruleDetailEntity;
    }

    /**
     * This method is used to get SyzegeeRuleDetail by szRuleDetailId
     * @param szRuleDetailId
     * @return
     */
    public SzRuleDetails getSyzegeeRuleDetailBySzRuleDetailId(long szRuleDetailId){
        SzRuleDetails ruleDetailEntity= szRuleDetailsRepository.getSzRuleDetailsById(szRuleDetailId);
        log.info("SzRuleDetails By szRuleDetailId "+ szRuleDetailId);
        return ruleDetailEntity;
    }

    /**
     * This method is used to get all SyzegeeRuleDetail by szRuleId
     * @param szRuleId
     * @return
     */
    public List<SzRuleDetails> getAllSyzegeeRuleDetailsByRuleId(long szRuleId){
       return szRuleDetailsRepository.getAllSzRuledetailsByRuleId(szRuleId);
    }

    /**
     * This method is used to get all SyzegeeRuleDetail by szRuleDetailId
     * @param szRuleDetailId
     * @return
     */
    public int deleteSyzegeeRuleDetailBySzRuleDetailId(long szRuleDetailId){
        int i = szRuleRepository.deleteSzRuleById(szRuleDetailId);
        log.info("Delete SzRuleDetails By szRuleDetailId "+ szRuleDetailId);
        return i;
    }

    /**
     * This method is used to create ruleProject
     * @param szRuleProject
     * @return
     */
    public SzRuleProject createRuleProject(RuleProjectDetail szRuleProject){
        SzRuleProject ruleProjectEntity=null;
        SzRuleProject ruleProject =  SzRuleProject.builder().customerId(szRuleProject.getCustomerId()).
                    projectCode(szRuleProject.getProjectCode()).projectName(szRuleProject.getProjectName())
                   .isActive(Boolean.TRUE).projectDesc(szRuleProject.getProjectDesc()).createdBy(szRuleProject.getCreatedBy())
                   .createdDate(szRuleProject.getCreatedDate()).build();
             log.info("SyzegeeRuleProject Name Is "+ szRuleProject.getProjectName());
             ruleProjectEntity = szRuleProjectRepository.save(ruleProject);
             if(szRuleProject.getDefaultRuleName()!=null){
                 copyDefaultRules(ruleProjectEntity,szRuleProject.getDefaultRuleName());
             }
        return ruleProjectEntity;
    }

    /**
     * This method is user to copy default rule .
     * @param ruleProjectEntity
     * @param defaultRuleName
     */
    public void copyDefaultRules(SzRuleProject ruleProjectEntity,String defaultRuleName){

        SzRuleProject szRuleProjectName = szRuleProjectRepository.getSzRuleProjectByProjectName(defaultRuleName);
        List<SzProjectRules> allSzProjectRules = szProjectRulesRepository.getAllSzProjectRulesByProjectId(
                szRuleProjectName.getProjectId());
        for (SzProjectRules projectRules:allSzProjectRules) {

            SzProjectRules projectRulesEntity=SzProjectRules.builder().projectId(ruleProjectEntity)
                    .ruleId(projectRules.getRuleId()).
                    ruleValue(projectRules.getRuleValue()).isActive(Boolean.TRUE).createdBy(projectRules.getCreatedBy())
                    .createdDate(new Date()).build();
            SzProjectRules szProjectRuleEntity = szProjectRulesRepository.save(projectRulesEntity);

        }
    }

    /**
     * This method is used to update ruleProject
     * @param szRuleProject
     * @return
     */
    public SzRuleProject updateRuleProject(RuleProjectDetail szRuleProject){
        SzRuleProject ruleProjectEntity=null;
        SzRuleProject szRuleProjectById = szRuleProjectRepository.getSzRuleProjectById(szRuleProject.getProjectId());
        if(szRuleProjectById!=null){
            SzRuleProject ruleProject =  SzRuleProject.builder().customerId(szRuleProject.getCustomerId()).
                    projectCode(szRuleProject.getProjectCode()).projectName(szRuleProject.getProjectName())
                    .projectDesc(szRuleProject.getProjectDesc()).isActive(Boolean.TRUE)
                    .createdBy(szRuleProject.getCreatedBy())
                    .createdDate(szRuleProject.getCreatedDate()).build();
            log.info("updated SyzegeeRuleProject Name Is "+ szRuleProject.getProjectName());
            ruleProjectEntity = szRuleProjectRepository.save(ruleProject);
        }else{
            log.info("exception invalid project id record not found.");
        }

        return ruleProjectEntity;
    }

    /**
     * This method is used to get ruleProject by ruleProjectId
     * @param ruleProjectId
     * @return
     */
    public SzRuleProject getRuleProjectByProjectId(long ruleProjectId){
        SzRuleProject ruleProject  = szRuleProjectRepository.getSzRuleProjectById(ruleProjectId);
        log.info("SyzegeeRuleProject By ruleProjectId "+ruleProjectId);
        return ruleProject;
    }

    /**
     * This method is used to get ruleProject by customerId
     * @param customerId
     * @return
     */
    public SzRuleProject getRuleProjectByCustomerId(String customerId){
        return szRuleProjectRepository.getSzRuleProjectByCustomerId(customerId);
    }

    /**
     * This method is used to delete ruleProject by ruleProjectId
     * @param ruleProjectId
     * @return
     */
    public int deleteRuleProjectByProjectId(long ruleProjectId){
        int i = szRuleProjectRepository.deleteSzRuleProjectById(ruleProjectId);
        log.info("Delete SyzegeeRuleProject By ruleProjectId "+ruleProjectId);
        return i;
    }

    /**
     * This method is used to get ruleProject by customerId
     * @param customerId
     * @return
     */
    public int deleteRuleProjectByCustomerId(String customerId){
        int i = szRuleProjectRepository.deleteSzRuleProjectByCustomerId(customerId);
        return i;
    }

    /**
     * This method is used to create projectRule
     * @param szProjectRules
     * @param szRuleProject
     * @param szRule
     * @return
     */
    public SzProjectRules createProjectRule(SyzegeeProjectRulesDetail szProjectRules, SzRuleProject szRuleProject, SzRule szRule){
       System.out.println("szRuleProject "+szRuleProject.getProjectId());
        SzProjectRules projectRule=  SzProjectRules.builder().projectId(szRuleProject).ruleId(szRule)
                .ruleValue(szProjectRules.getRuleValue()).isActive(Boolean.TRUE).createdBy(szProjectRules.getCreatedBy())
                .createdDate(szProjectRules.getCreatedDate()).build();
        log.info("SyzegeeProjectRules Value Is "+szProjectRules.getRuleValue());
         SzProjectRules projectRuleEntity = szProjectRulesRepository.save(projectRule);
        return projectRuleEntity;
    }

    /**
     * This method is used to update projectRule
     * @param szProjectRules
     * @param szRuleProject
     * @param szRule
     * @return
     */
    public SzProjectRules updateProjectRule(SyzegeeProjectRulesDetail szProjectRules, SzRuleProject szRuleProject, SzRule szRule){
        SzProjectRules projectRule=  SzProjectRules.builder().projectId(szRuleProject).ruleId(szRule).
                ruleValue(szProjectRules.getRuleValue()).isActive(Boolean.TRUE).
                createdBy(szProjectRules.getCreatedBy())
                .createdDate(szProjectRules.getCreatedDate()).build();
                 SzProjectRules projectRules = szProjectRulesRepository.save(projectRule);
        log.info("Updated SyzegeeProjectRules Value Is "+szProjectRules.getRuleValue());
        return projectRules;
    }

    /**
     * This method is used to get projectRule by projectRuleId
     * @param projectRuleId
     * @return
     */
    public SzProjectRules getProjectRuleByProRuleId(long projectRuleId){
        SzProjectRules projectRules = szProjectRulesRepository.getSzProjectRulesById(projectRuleId);
        log.info("SyzegeeProjectRules By projectRuleId "+projectRuleId);
        return projectRules;
    }

    /**
     * This method is used to get all projectRule by projectId
     * @param projectId
     * @return
     */
    public  List<SzProjectRules>  getAllSzProjectRulesByProjectId(long projectId){
        List<SzProjectRules> allSzProjectRulesByProjectId = szProjectRulesRepository.getAllSzProjectRulesByProjectId(projectId);
   return allSzProjectRulesByProjectId;
    }

    /**
     *This method is used to delete projectRule by projectRuleId
     * @param projectRuleId
     * @return
     */
    public int deleteProjectRuleByProRuleId(long projectRuleId) {
        int i = szProjectRulesRepository.deleteSzProjectRulesById(projectRuleId);
        log.info("Delete SyzegeeProjectRules By projectRuleId "+projectRuleId);
        return i;
    }

    

}
