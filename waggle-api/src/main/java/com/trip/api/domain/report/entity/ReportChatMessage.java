package com.trip.api.domain.report.entity;

import com.trip.api.config.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportChatMessage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_message_id", nullable = false)
    private Long messageId;

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Column(name = "reporter_id", nullable = false)
    private Long reporterId;

    @NotNull
    private String reason;

    @Column(name = "is_solved")
    @ColumnDefault("false")
    private Boolean isSolved;

    @Builder
    public ReportChatMessage(Long messageId, Long writerId, Long reporterId, String reason) {
        this.messageId = messageId;
        this.writerId = writerId;
        this.reporterId = reporterId;
        this.reason = reason;
    }
}
