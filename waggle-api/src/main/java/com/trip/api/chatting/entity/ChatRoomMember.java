package com.trip.api.chatting.entity;

import com.trip.api.chatting.dto.entitykey.ChatRoomMemberKey;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Getter
@Table(name = "chat_room_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@SQLDelete(sql = "UPDATE chat_room_member SET is_deleted = true WHERE id = ?")
@Entity
public class ChatRoomMember {

    @EmbeddedId
    private ChatRoomMemberKey id;

    @Column(name = "is_exited")
    @ColumnDefault("false")
    private Boolean isExited;

    public ChatRoomMember(Long memberId, Long chatRoomId) {
        this.id = new ChatRoomMemberKey(chatRoomId, memberId);
    }

    public void updateStatus() {
        if (this.isExited == null) {
            this.isExited = false;
        } else {
            this.isExited = !this.isExited;
        }
    }
}
