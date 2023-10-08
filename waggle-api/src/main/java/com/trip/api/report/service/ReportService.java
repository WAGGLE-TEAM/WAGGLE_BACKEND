package com.trip.api.report.service;

import com.trip.api.report.dto.param.ConvertChatRoomReportParameter;
import com.trip.api.report.dto.request.CreateReportRequest;
import com.trip.api.report.entity.ReportChatMessage;
import com.trip.api.report.entity.ReportChatRoom;
import com.trip.api.report.mapper.ReportMapper;
import com.trip.api.report.repository.ReportChatMessageRepository;
import com.trip.api.report.repository.ReportChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// TODO: writerId 탐색 기능 추가
// TODO: admin에서 해당 신고 내용 조회 기능 추가
@RequiredArgsConstructor
@Service
public class ReportService {

    private final ReportChatRoomRepository reportChatRoomRepository;
    private final ReportChatMessageRepository reportChatMessageRepository;
    private final ReportMapper reportMapper;

    public Long createChatRoomReport(
        CreateReportRequest reportRequest,
        Long reporterId,
        Long chatRoomId
    ) {
        Long writerId = 10L;
        ReportChatRoom reportChatRoom = reportMapper.createReportRequestToReportChatRoomEntity(
            new ConvertChatRoomReportParameter(chatRoomId, writerId, reporterId, reportRequest.getReason())
        );

        return reportChatRoomRepository.save(reportChatRoom).getId();
    }

    public Long createChatMessageUserReport(
        CreateReportRequest reportRequest,
        Long chatRoomId,
        Long messageId,
        Long reporterId
    ) {
        Long writerId = 55L;
        ReportChatMessage reportChatMessage = reportMapper.createReportRequestToReportChatMessageEntity(
            messageId, reporterId, writerId, reportRequest.getReason()
        );

        return reportChatMessageRepository.save(reportChatMessage).getId();
    }
}
