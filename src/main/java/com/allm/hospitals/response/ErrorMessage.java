package com.allm.hospitals.response;


import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorMessage implements Serializable {

    private String shortMessage;
    private String longMessage;

    public ErrorMessage(){}

    public ErrorMessage(String shortMessage, String longMessage) {
        this.shortMessage = shortMessage;
        this.longMessage = longMessage;
    }
}
