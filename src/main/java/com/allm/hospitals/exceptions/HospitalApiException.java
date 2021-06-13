package com.allm.hospitals.exceptions;

import java.io.Serializable;

public class HospitalApiException extends Exception implements Serializable {

    public HospitalApiException(String message) {
        super(message);
    }
}
