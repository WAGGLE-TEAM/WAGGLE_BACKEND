package com.trip.api.domain.report.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateReportRequest {

    @NotBlank
    private String reason;
}
