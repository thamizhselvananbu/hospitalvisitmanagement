package com.allm.hospitals.response;

import lombok.Data;

@Data
public class CancelVisitResponse {

    private String cancelVisitStatus;

    public CancelVisitResponse(String cancelVisitStatus) {
        this.cancelVisitStatus = cancelVisitStatus;
    }
}
