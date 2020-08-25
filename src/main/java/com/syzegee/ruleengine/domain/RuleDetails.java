package com.syzegee.ruleengine.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.List;

/**
 * Ram Prasad
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleDetails implements Serializable {

    private ProjectDetail projectDetail;
    private SyzegeeRuleDetail ruleNameDetails;
    private List<SyzegeeRuleDtlDetail> ruleAttributeDetails;
    private List<SyzegeeProjectRulesDetail> ruleValueDetails;


}
