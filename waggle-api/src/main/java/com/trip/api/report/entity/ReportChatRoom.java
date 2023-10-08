package com.trip.api.report.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "report_chat_room")
public class ReportChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_room_id", nullable = false)
    private Long chatRoomId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @NotNull
    private String reason;

    @Column(name = "is_solved", nullable = false)
    private Boolean isSolved;

    public ReportChatRoom(Long chatRoomId, Long memberId, String reason) {
        this.chatRoomId = chatRoomId;
        this.memberId = memberId;
        this.reason = reason;
        this.isSolved = false;
    }
}
