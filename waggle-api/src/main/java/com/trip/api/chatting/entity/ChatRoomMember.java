package com.trip.api.chatting.entity;

import com.trip.api.chatting.dto.entitykey.ChatRoomMemberKey;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "chat_room_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
