package com.trip.api.report.dto.param;

import com.trip.api.report.dto.request.CreateReportRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatMessageReportParameter {

    private CreateReportRequest reportRequest;
    private Long chatRoomId;
    private Long messageId;
    private Long reporterId;
}
