package com.trip.api.chatting.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chat_message")
@DynamicInsert
@SQLDelete(sql = "UPDATE chat_message SET is_deleted = true WHERE id = ?")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "chat_room_id", nullable = false)
    private Long chatRoomId;

    @NotBlank
    private String message;

    @Column(name = "message_type", nullable = false)
    private String messageType;

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    private Boolean isDeleted;

    @Builder
    public ChatMessage(Long memberId, Long chatRoomId, String message, String messageType) {
        this.memberId = memberId;
        this.chatRoomId = chatRoomId;
        this.message = message;
        this.messageType = messageType;
    }
}
