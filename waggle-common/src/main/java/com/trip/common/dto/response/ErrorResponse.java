package com.trip.common.dto.response;

import com.trip.common.dto.type.ErrorMessage;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private int code;
    private String message;

    public ErrorResponse(int code, ErrorMessage message) {
        this.code = code;
        this.message = message.getMessage();
    }
}
