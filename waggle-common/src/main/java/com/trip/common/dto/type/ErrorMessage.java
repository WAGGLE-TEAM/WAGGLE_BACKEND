package com.trip.common.dto.type;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    NOT_FOUND(404, "해당 요소를 찾을 수 없습니다.");

    private final int code;
    private final String message;

    ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
