package com.trip.api.report.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ReportChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_message_id", nullable = false)
    private Long chatMessageId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @NotNull
    private String reason;

    @Column(name = "is_solved", nullable = false)
    private Boolean isSolved;

    public ReportChatMessage(Long chatMessageId, Long memberId, String reason) {
        this.chatMessageId = chatMessageId;
        this.memberId = memberId;
        this.reason = reason;
        this.isSolved = false;
    }
}
