package com.allm.hospitals.response;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELDS("Please check required fields!"),
    SCHEDULE_ERROR("Schedule visit failed!"),
    SCHEDULE_CANCEL_ERROR("Schedule visit failed!"),
    INVALID_PATIENT("This patient is not valid");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
