package com.trip.api.report.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConvertChatRoomReportParameter {

    private final Long chatRoomId;
    private final Long writerId;
    private final Long reporterId;
    private final String reason;
}
