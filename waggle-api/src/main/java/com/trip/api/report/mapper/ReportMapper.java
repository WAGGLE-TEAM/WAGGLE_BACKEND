package com.trip.api.report.mapper;

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

    public ReportChatMessage createReportRequestToReportChatMessageEntity(
        Long messageId,
        Long reporterId,
        Long writerId,
        String reason
    ) {
        return ReportChatMessage.builder()
            .messageId(messageId)
            .reporterId(reporterId)
            .writerId(writerId)
            .reason(reason)
            .build();
    }
}
