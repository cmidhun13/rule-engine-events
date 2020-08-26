package com.syzegee.ruleengine.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDetails {
    private long projectId;
    private String correlationId;
    private String message;

}
