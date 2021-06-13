package com.allm.hospitals.validator;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.Patients;
import com.allm.hospitals.models.ScheduleVisit;
import com.allm.hospitals.models.ScheduleVisitRequest;
import com.allm.hospitals.response.ErrorMessages;
import com.allm.hospitals.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

import static com.allm.hospitals.ValidatorUtils.notEmpty;
import static com.allm.hospitals.ValidatorUtils.notNull;

@Service
@Slf4j
public class PatientValidator {

    @Autowired
    PatientService patientService;

    public void validatePatientSchedule(ScheduleVisitRequest request) throws HospitalApiException {
        if(notNull(request)) {
            if (!notEmpty(request.getPatientName()) &&
                    !notEmpty(request.getHospitalName()) &&
                    !notEmpty(request.getDateTime()) )
            throw new HospitalApiException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }
    }

    public void validatePatientCancelSchedule(ScheduleVisit cancelRequest) throws HospitalApiException {
        if (notNull(cancelRequest)) {
            if(!notEmpty(cancelRequest.getScheduledVisitId())) {
                throw new HospitalApiException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
            }
        }
    }

    public void validatePatient(String patient) throws HospitalApiException {
        if (patient == null) {
            throw new HospitalApiException(ErrorMessages.INVALID_PATIENT.getErrorMessage());
        }
        byte[] bytes = null;
        String decodePatient = patient.substring(patient.indexOf(" ") + 1);
        bytes = Base64.getDecoder().decode(decodePatient);
        String authString = new String(bytes);
        String[] authValues = authString.split(":");
        String encodepassword = DigestUtils.sha256Hex(authValues[1]);
        Patients patientAutheticated = patientService.findByNameAndPassword(authValues[0], encodepassword);

        if (patientAutheticated == null) {
            throw new HospitalApiException(ErrorMessages.INVALID_PATIENT.getErrorMessage());
        }

    }
}
