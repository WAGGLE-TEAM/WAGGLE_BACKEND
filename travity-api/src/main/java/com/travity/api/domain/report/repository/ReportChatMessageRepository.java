package com.travity.api.domain.report.repository;

import com.travity.api.domain.report.entity.ReportChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportChatMessageRepository extends JpaRepository<ReportChatMessage, Long> {
}
