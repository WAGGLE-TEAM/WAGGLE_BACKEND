package com.travity.api.domain.report.dto.param;

import com.travity.api.domain.report.dto.request.CreateReportRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatRoomReportParameter {

    private CreateReportRequest reportRequest;
    private Long reporterId;
    private Long chatRoomId;
}