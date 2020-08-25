package com.syzegee.ruleengine.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectDetail {
    private long projectId;
    private String projectName;
}
