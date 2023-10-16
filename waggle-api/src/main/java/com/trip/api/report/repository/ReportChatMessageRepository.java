package com.trip.api.report.repository;

import com.trip.api.report.entity.ReportChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportChatMessageRepository extends JpaRepository<ReportChatMessage, Long> {
}
