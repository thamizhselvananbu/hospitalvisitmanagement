package com.allm.hospitals.service.impl;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.models.Patients;
import com.allm.hospitals.models.ScheduleVisitRequest;
import com.allm.hospitals.models.Visits;
import com.allm.hospitals.repository.HospitalRespository;
import com.allm.hospitals.repository.PatientRepository;
import com.allm.hospitals.repository.VisitsRepository;
import com.allm.hospitals.response.CancelVisitResponse;
import com.allm.hospitals.response.ErrorMessages;
import com.allm.hospitals.models.ScheduleVisit;
import com.allm.hospitals.response.ScheduleVisitResponse;
import com.allm.hospitals.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@Slf4j
public class PatientsServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalRespository hospitalRespository;

    @Autowired
    private VisitsRepository visitsRepository;

    @Override
    public Patients findByName(String name) {
        return patientRepository.findByName(name);
    }

    @Override
    public ScheduleVisitResponse scheduleVisit(ScheduleVisitRequest scheduleVisit) throws HospitalApiException {
        Patients patient = patientRepository.findByName(scheduleVisit.getPatientName());
        Hospital hospital = hospitalRespository.findByName(scheduleVisit.getHospitalName());
        if (patient != null && hospital != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date date = null;
            try {
                date = df.parse(scheduleVisit.getDateTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date parsedDate = new Date(date.getTime());
            Visits visit = new Visits(hospital.getId(),patient.getId(),parsedDate);
            visitsRepository.saveAndFlush(visit);
            log.info("Schedule visit for patient successfully!");
            String res = String.valueOf(visit.getId());
            ScheduleVisitResponse response = new ScheduleVisitResponse(res);
            return response;
        } else {
            throw new HospitalApiException(ErrorMessages.SCHEDULE_ERROR.getErrorMessage());
        }
    }

    @Override
    public CancelVisitResponse cancelScheduledVisit(ScheduleVisit cancelVisit) throws HospitalApiException {
        int scheduledId = Integer.valueOf(cancelVisit.getScheduledVisitId());
        Visits cancelScheduleVisit = visitsRepository.getOne(scheduledId);
        visitsRepository.delete(cancelScheduleVisit);
        log.info("Scheduled visit for patient Cancelled successfully!");
        CancelVisitResponse canceledVisit = new CancelVisitResponse("Schedule canceled Cancelled");
        return canceledVisit;
    }

    @Override
    public Patients findByNameAndPassword(String username, String password) {
        return patientRepository.findByNameAndPassword(username, password);
    }


}
