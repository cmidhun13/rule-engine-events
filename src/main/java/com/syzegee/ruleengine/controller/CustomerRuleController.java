package com.syzegee.ruleengine.controller;

import com.syzegee.ruleengine.domain.*;
import lombok.extern.slf4j.Slf4j;
import com.syzegee.ruleengine.service.CustomerRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * Ram Prasad
 */
@RestController
@RequestMapping("/syzegee/v1/ruleengine")
@Slf4j
public class CustomerRuleController {

    @Autowired
    private CustomerRuleService customerRuleService;


    @PostMapping("/createproject")
    public ResponseDetails createProject(@RequestBody RuleProjectDetail projectDetails){
        ResponseDetails ruleProjectResponse = customerRuleService.createSyzegeeRuleProject(projectDetails);
        return ruleProjectResponse;
    }

    @PutMapping("/updateproject")
    public ResponseDetails updateProject(@RequestBody RuleProjectDetail projectDetails){
        ResponseDetails ruleProjectResponse = customerRuleService.updateSyzegeeRuleProject(projectDetails);
        return ruleProjectResponse;
    }

    @DeleteMapping(path="/{customerId}")
    public CustomerDeleteResponseDetails deleteCustomerRules(@PathVariable("customerId") String customerId){
        log.info(" Entered into the rest method for delete customer Rules. "+customerId);
        return customerRuleService.deleteCustomerRules(customerId);
    }

 }
