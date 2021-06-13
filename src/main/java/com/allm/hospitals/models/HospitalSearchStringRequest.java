package com.allm.hospitals.models;

import lombok.Data;

@Data
public class HospitalSearchStringRequest {
    private String query;
    private String filter;
}
