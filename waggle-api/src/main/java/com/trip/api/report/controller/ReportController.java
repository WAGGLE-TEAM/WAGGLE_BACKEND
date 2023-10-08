package com.trip.api.report.controller;

import com.trip.api.report.dto.request.CreateChatRoomReportRequest;
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
        @Valid @RequestBody CreateChatRoomReportRequest chatRoomReportRequest,
        @PathVariable Long chatRoomId
    ) {
        Long reportId = reportService.createChatRoomReport(chatRoomReportRequest, 71L, chatRoomId);
        return ResponseEntity.created(URI.create("/report/chat/" + reportId)).build();
    }
}
