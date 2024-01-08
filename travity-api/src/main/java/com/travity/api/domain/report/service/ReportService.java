package com.travity.api.domain.report.service;

import com.travity.api.domain.chatting.repository.ChatMessageRepository;
import com.travity.api.domain.chatting.repository.ChatRoomRepository;
import com.travity.api.domain.report.dto.param.ConvertChatMessageReportParameter;
import com.travity.api.domain.report.dto.param.ConvertChatRoomReportParameter;
import com.travity.api.domain.report.dto.param.CreateChatMessageReportParameter;
import com.travity.api.domain.report.dto.param.CreateChatRoomReportParameter;
import com.travity.api.domain.report.entity.ReportChatMessage;
import com.travity.api.domain.report.entity.ReportChatRoom;
import com.travity.api.domain.report.repository.ReportChatMessageRepository;
import com.travity.api.domain.report.repository.ReportChatRoomRepository;
import com.travity.api.domain.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: writerId 탐색 기능 추가
// TODO: admin에서 해당 신고 내용 조회 기능 추가
@RequiredArgsConstructor
@Service
@Transactional
public class ReportService {

    private final ReportChatRoomRepository reportChatRoomRepository;
    private final ReportChatMessageRepository reportChatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ReportMapper reportMapper;

    public Long createChatRoomReport(CreateChatRoomReportParameter parameter) {
        Long creatorId = 10L;
        chatRoomRepository.findChatRoomById(parameter.getChatRoomId()).orElseThrow();

        ReportChatRoom reportChatRoom = reportMapper.createReportRequestToReportChatRoomEntity(
            new ConvertChatRoomReportParameter(
                parameter.getChatRoomId(),
                creatorId,
                parameter.getReporterId(),
                parameter.getReportRequest().getReason()
            )
        );

        return reportChatRoomRepository.save(reportChatRoom).getId();
    }

    public Long createChatMessageUserReport(CreateChatMessageReportParameter parameter) {
        Long writerId = 55L;
        chatRoomRepository.findChatRoomById(parameter.getChatRoomId()).orElseThrow();
        chatMessageRepository.findChatMessageById(parameter.getMessageId()).orElseThrow();

        ReportChatMessage reportChatMessage = reportMapper.createReportRequestToReportChatMessageEntity(
            new ConvertChatMessageReportParameter(
                parameter.getMessageId(),
                parameter.getReporterId(),
                writerId,
                parameter.getReportRequest().getReason()
            )
        );

        return reportChatMessageRepository.save(reportChatMessage).getId();
    }
}
