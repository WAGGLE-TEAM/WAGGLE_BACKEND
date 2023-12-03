package com.trip.api.domain.report.repository;

import com.trip.api.domain.report.entity.ReportChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportChatRoomRepository extends JpaRepository<ReportChatRoom, Long> {
}
