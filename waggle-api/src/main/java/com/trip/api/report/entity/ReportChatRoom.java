package com.trip.api.report.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@DynamicInsert
@Table(name = "report_chat_room")
public class ReportChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_room_id", nullable = false)
    private Long chatRoomId;

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "reporter_id", nullable = false)
    private Long reporterId;

    @NotNull
    private String reason;

    @Column(name = "is_solved")
    @ColumnDefault("false")
    private Boolean isSolved;

    @Builder
    public ReportChatRoom(Long chatRoomId, Long creatorId, Long reporterId, String reason) {
        this.chatRoomId = chatRoomId;
        this.creatorId = creatorId;
        this.reporterId = reporterId;
        this.reason = reason;
    }
}
