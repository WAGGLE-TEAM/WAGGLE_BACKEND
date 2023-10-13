package com.trip.api.report.mapper;

import com.trip.api.report.dto.param.ConvertChatMessageReportParameter;
import com.trip.api.report.dto.param.ConvertChatRoomReportParameter;
import com.trip.api.report.entity.ReportChatMessage;
import com.trip.api.report.entity.ReportChatRoom;

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
