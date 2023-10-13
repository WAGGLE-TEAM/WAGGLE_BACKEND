package com.trip.api.report.dto.param;

import com.trip.api.report.dto.request.CreateReportRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatRoomReportParameter {

    private CreateReportRequest reportRequest;
    private Long reporterId;
    private Long chatRoomId;
}