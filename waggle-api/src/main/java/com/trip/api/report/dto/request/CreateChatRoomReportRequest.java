package com.trip.api.report.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateChatRoomReportRequest {

    @NotBlank
    private String reason;
}
