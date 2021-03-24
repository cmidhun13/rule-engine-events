package com.dxunited.ruleengine.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDeleteResponseDetails {
    private String customerID;
    private Boolean result;
    private String message;
}
