package com.dxunited.ruleengine.controller;

import com.dxunited.ruleengine.model.CustomerDeleteResponseDetails;
import com.dxunited.ruleengine.model.ResponseDetails;
import com.dxunited.ruleengine.model.RuleProjectDetail;
import lombok.extern.slf4j.Slf4j;
import com.dxunited.ruleengine.service.CustomerRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Ram Prasad
 */
@RestController
@RequestMapping("/dxunited/v1/ruleengine/")
@Slf4j
public class CustomerRuleController {

    @Autowired
    private CustomerRuleService customerRuleService;


    @PostMapping()
    public ResponseDetails createProject(@RequestBody RuleProjectDetail projectDetails){
        ResponseDetails ruleProjectResponse = customerRuleService.createSyzegeeRuleProject(projectDetails);
        return ruleProjectResponse;
    }

    @PutMapping()
    public ResponseDetails updateProject(@RequestBody RuleProjectDetail projectDetails){
        ResponseDetails ruleProjectResponse = customerRuleService.updateSyzegeeRuleProject(projectDetails);
        return ruleProjectResponse;
    }

    @DeleteMapping(path="{customerId}")
    public CustomerDeleteResponseDetails deleteCustomerRules(@PathVariable("customerId") String customerId){
        log.info(" Entered into the rest method for delete customer Rules. "+customerId);
        return customerRuleService.deleteCustomerRules(customerId);
    }

 }
