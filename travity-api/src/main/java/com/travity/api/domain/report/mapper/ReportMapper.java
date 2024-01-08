package com.travity.api.domain.report.mapper;

import com.travity.api.domain.report.dto.param.ConvertChatMessageReportParameter;
import com.travity.api.domain.report.dto.param.ConvertChatRoomReportParameter;
import com.travity.api.domain.report.entity.ReportChatMessage;
import com.travity.api.domain.report.entity.ReportChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportChatRoom createReportRequestToReportChatRoomEntity(ConvertChatRoomReportParameter parameter) {
        return ReportChatRoom.builder()
            .chatRoomId(parameter.getChatRoomId())
            .creatorId(parameter.getCreatorId())
            .reporterId(parameter.getReporterId())
            .reason(parameter.getReason())
            .build();
    }

    public ReportChatMessage createReportRequestToReportChatMessageEntity(ConvertChatMessageReportParameter parameter) {
        return ReportChatMessage.builder()
            .messageId(parameter.getMessageId())
            .reporterId(parameter.getReporterId())
            .writerId(parameter.getWriterId())
            .reason(parameter.getReason())
            .build();
    }
}
