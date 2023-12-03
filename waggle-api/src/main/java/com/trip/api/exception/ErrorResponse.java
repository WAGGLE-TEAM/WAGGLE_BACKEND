package com.trip.api.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private int code;
    private String message;

    ErrorResponse(int code, ErrorMessage message) {
        this.code = code;
        this.message = message.getMessage();
    }
}
