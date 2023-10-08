package com.trip.api.report.mapper;

import com.trip.api.report.dto.param.ConvertChatRoomReportParameter;
import com.trip.api.report.entity.ReportChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportChatRoom CreateChatRoomReportRequestToEntity(ConvertChatRoomReportParameter parameter) {
        return ReportChatRoom.builder()
            .chatRoomId(parameter.getChatRoomId())
            .writerId(parameter.getWriterId())
            .reporterId(parameter.getReporterId())
            .reason(parameter.getReason())
            .build();
    }
}
