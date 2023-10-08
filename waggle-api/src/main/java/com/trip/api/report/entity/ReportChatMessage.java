package com.trip.api.report.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(name = "is_solved")
    @ColumnDefault("false")
    private Boolean isSolved;

    public ReportChatMessage(Long chatMessageId, Long memberId, String reason) {
        this.chatMessageId = chatMessageId;
        this.memberId = memberId;
        this.reason = reason;
    }
}
