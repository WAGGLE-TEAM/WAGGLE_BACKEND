package com.trip.api.chat.entity;

import com.trip.api.chat.dto.embedded.ChatRoomMemberKey;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "chat_room_member")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE chat_room_member SET is_deleted = true WHERE id = ?")
public class ChatRoomMember {

    @EmbeddedId
    private ChatRoomMemberKey id;

    @Column(name = "is_exited", nullable = false)
    private Boolean isExited;

    public ChatRoomMember(Long memberId, Long chatRoomId) {
        this.id = new ChatRoomMemberKey(chatRoomId, memberId);
        this.isExited = false;
    }
}
