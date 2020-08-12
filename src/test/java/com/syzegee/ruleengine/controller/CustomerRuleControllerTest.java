//package com.syzegee.ruleengine.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.syzegee.ruleengine.domain.*;
//import com.syzegee.ruleengine.service.CustomerRuleService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerRuleControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerRuleService customerRuleService;
//
//    private String mapToJson(Object object) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(object);
//    }
//
//    @Test
//    public void createRules() throws Exception {
//       System.out.println("CreatCustomerRules");
//        String url = "/syzegee/v1/ruleengine";
//
//        SyzegeeRuleDetail syzegeeRuleDetail=SyzegeeRuleDetail.builder().ruleId(1l).ruleCode("1001").ruleName("customer rule")
//                .ruleDesc("customer rule desc").ruleType("text").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date())
//                .build();
//
//        List<SyzegeeRuleDtlDetail> syzegeeRuleDtlDetails = new ArrayList<>();
//        SyzegeeRuleDtlDetail ruleDtlDetail= SyzegeeRuleDtlDetail.builder().ruleDetailId(1l).ruleId(1l).ruleDetailCode("1002")
//                .ruleDetailValue("text value 10").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date()).build();
//        syzegeeRuleDtlDetails.add(ruleDtlDetail);
//
//        SyzegeeRuleProjectDetail syzegeeRuleProjectDetail= SyzegeeRuleProjectDetail.builder().projectId(1l).customerId("12sz3")
//                .projectCode("1001").projectName("syzegee Amezon").projectDesc("syzegee amezon desc").isActive(Boolean.TRUE)
//                 .createdBy("sadmin").createdDate(new Date()).build();
//
//        List<SyzegeeProjectRulesDetail> syzegeeProjectRulesDetails= new ArrayList<>();
//        SyzegeeProjectRulesDetail projectRulesDetail=SyzegeeProjectRulesDetail.builder().projectRuleId(1l).
//                projectId(1l).ruleId(1l).ruleValue("a-zA-Z0-9").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date())
//                .build();
//        syzegeeProjectRulesDetails.add(projectRulesDetail);
//
//        CustomerRuleDetails customerRuleDetails= CustomerRuleDetails.builder().ruleNameDetails(syzegeeRuleDetail)
//                .ruleAttributeDetails(syzegeeRuleDtlDetails).projectDetails(syzegeeRuleProjectDetail)
//        .ruleValueDetails(syzegeeProjectRulesDetails).build();
//
//        String payload=mapToJson(customerRuleDetails);
//
//        System.out.println("payload>>>  "+payload);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post(url)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(payload)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result1 = mockMvc.perform(request)
//                .andExpect(status().isOk()).andReturn();
//
//
//    }
//
//    @Test
//    public void updateSyzegeeRules() throws Exception {
//        System.out.println("updateCustomerRule");
//        String url = "/syzegee/v1/ruleengine";
//
//        SyzegeeRuleDetail syzegeeRuleDetail=SyzegeeRuleDetail.builder().ruleId(1l).ruleCode("1001").ruleName("customer syzegee rule")
//                .ruleDesc("customer rule desc").ruleType("text").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date())
//                .build();
//
//        List<SyzegeeRuleDtlDetail> syzegeeRuleDtlDetails = new ArrayList<>();
//        SyzegeeRuleDtlDetail ruleDtlDetail= SyzegeeRuleDtlDetail.builder().ruleDetailId(1l).ruleId(1l).ruleDetailCode("1002")
//                .ruleDetailValue("text value 10").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date()).build();
//        syzegeeRuleDtlDetails.add(ruleDtlDetail);
//
//        SyzegeeRuleProjectDetail syzegeeRuleProjectDetail= SyzegeeRuleProjectDetail.builder().projectId(1l).customerId("12sz3")
//                .projectCode("1001").projectName("syzegee Amezon").projectDesc("syzegee amezon desc").isActive(Boolean.TRUE)
//                .createdBy("sadmin").createdDate(new Date()).build();
//
//        List<SyzegeeProjectRulesDetail> syzegeeProjectRulesDetails= new ArrayList<>();
//        SyzegeeProjectRulesDetail projectRulesDetail=SyzegeeProjectRulesDetail.builder().projectRuleId(1l).
//                projectId(1l).ruleId(1l).ruleValue("a-zA-Z0-9").isActive(Boolean.TRUE).createdBy("sadmin").createdDate(new Date())
//                .build();
//        syzegeeProjectRulesDetails.add(projectRulesDetail);
//
//        CustomerRuleDetails customerRuleDetails= CustomerRuleDetails.builder().ruleNameDetails(syzegeeRuleDetail)
//                .ruleAttributeDetails(syzegeeRuleDtlDetails).projectDetails(syzegeeRuleProjectDetail)
//                .ruleValueDetails(syzegeeProjectRulesDetails).build();
//
//        String payload=mapToJson(customerRuleDetails);
//
//        System.out.println("payload>>>  "+payload);
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post(url)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(payload)
//
//                .contentType(MediaType.APPLICATION_JSON);
//        MvcResult result1 = mockMvc.perform(request)
//                .andExpect(status().isOk()).andReturn();
//    }
//
//    @Test
//    public void deleteCustomerRules() throws Exception {
//        System.out.println("deleteCustomerRules");
//        String url="/syzegee/v1/ruleengine/1110cust";
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .delete(url)
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk()).andReturn();
//    }
//}