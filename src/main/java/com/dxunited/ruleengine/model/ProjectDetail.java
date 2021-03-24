package com.dxunited.ruleengine.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectDetail {
    private long projectId;
    private String projectName;
}
