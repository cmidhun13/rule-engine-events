package com.syzegee.ruleengine.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Builder
@Data
public class ResponseDetails {
    private long projectId;
    private String correlationId;
    private String message;

}
