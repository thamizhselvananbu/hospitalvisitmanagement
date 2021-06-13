package com.allm.hospitals.models;

import lombok.Data;

@Data
public class ScheduleVisitRequest {
    private String patientName;
    private String hospitalName;
    private String dateTime;
}
