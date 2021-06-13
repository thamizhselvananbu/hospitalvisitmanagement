package com.allm.hospitals.response;

import lombok.Data;

@Data
public class ScheduleVisitResponse {

    private String scheduledVisitId;

    public ScheduleVisitResponse(String scheduledVisitId) {
        this.scheduledVisitId = scheduledVisitId;
    }
}
