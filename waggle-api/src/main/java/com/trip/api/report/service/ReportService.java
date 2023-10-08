package com.trip.api.report.service;

import com.trip.api.report.dto.request.CreateChatRoomReportRequest;
import com.trip.api.report.entity.ReportChatRoom;
import com.trip.api.report.repository.ReportChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportService {

    private final ReportChatRoomRepository reportChatRoomRepository;

    public Long createChatRoomReport(
        CreateChatRoomReportRequest chatRoomReportRequest,
        Long reporterId,
        Long chatRoomId
    ) {
        // TODO: writerId 탐색 기능 추가
        // TODO: Mapper 추가
        ReportChatRoom reportChatRoom = new ReportChatRoom(
            chatRoomId,
            55L,
            reporterId,
            chatRoomReportRequest.getReason()
        );

        return reportChatRoomRepository.save(reportChatRoom).getId();
    }
}
