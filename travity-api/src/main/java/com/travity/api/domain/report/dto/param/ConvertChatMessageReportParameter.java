package com.travity.api.domain.report.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConvertChatMessageReportParameter {

    private Long messageId;
    private Long reporterId;
    private Long writerId;
    private String reason;
}