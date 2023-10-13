package com.trip.api.report.controller;

import com.trip.api.report.dto.param.CreateChatMessageReportParameter;
import com.trip.api.report.dto.param.CreateChatRoomReportParameter;
import com.trip.api.report.dto.request.CreateReportRequest;
import com.trip.api.report.service.ReportService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/chat/{chatRoomId}")
    public ResponseEntity<Void> createChatRoomReport(
        @Valid @RequestBody CreateReportRequest reportRequest,
        @PathVariable Long chatRoomId
    ) {
        Long reportId = reportService.createChatRoomReport(
            new CreateChatRoomReportParameter(
                reportRequest,
                71L,
                chatRoomId
            )
        );
        return ResponseEntity.created(URI.create("/report/chat/" + reportId)).build();
    }

    @PostMapping("/chat/{chatRoomId}/message/{messageId}")
    public ResponseEntity<Void> createChatMessageUserReport(
        @PathVariable Long chatRoomId,
        @PathVariable Long messageId,
        @Valid @RequestBody CreateReportRequest reportRequest
    ) {
        Long reportId = reportService.createChatMessageUserReport(
            new CreateChatMessageReportParameter(
                reportRequest,
                chatRoomId,
                messageId,
                71L
            )
        );

        return ResponseEntity.created(URI.create("/report/chat/" + chatRoomId + "/message/" + messageId + "/" + reportId)).build();
    }
}
