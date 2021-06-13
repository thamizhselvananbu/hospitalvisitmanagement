package com.allm.hospitals.service;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.Patients;
import com.allm.hospitals.models.ScheduleVisitRequest;
import com.allm.hospitals.models.ScheduleVisit;
import com.allm.hospitals.response.CancelVisitResponse;
import com.allm.hospitals.response.ScheduleVisitResponse;

public interface PatientService {

    //Get patient by name
    Patients findByName(String name);

    //schedule visit to a hospital
    ScheduleVisitResponse scheduleVisit(ScheduleVisitRequest scheduleVisit) throws HospitalApiException;

    CancelVisitResponse cancelScheduledVisit(ScheduleVisit cancelVisit) throws HospitalApiException;

    //get patient by username and password to authenticate
    Patients findByNameAndPassword(String username, String password);

}
