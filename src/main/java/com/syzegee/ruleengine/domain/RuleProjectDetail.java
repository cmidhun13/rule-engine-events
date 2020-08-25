package com.syzegee.ruleengine.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleProjectDetail implements Serializable {
    private long projectId;
    private String customerId;
    private String projectCode;
    private  String projectName;
    private String projectDesc;
    private String defaultRuleName;
    private Boolean isActive;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private RuleDetails ruleDetails;


}
