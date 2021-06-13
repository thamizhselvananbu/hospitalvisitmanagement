package com.allm.hospitals.validator;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.HospitalSearchStringRequest;
import com.allm.hospitals.response.ErrorMessages;
import org.springframework.stereotype.Service;

@Service
public class HospitalValidator {

    public void validateHospitalSearch(HospitalSearchStringRequest searchRequest) throws HospitalApiException {
        if (searchRequest == null || searchRequest.getQuery() == null){
            throw new HospitalApiException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }
    }
}
