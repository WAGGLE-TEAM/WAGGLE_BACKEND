package com.trip.api.chat.entity;

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

    @Id
    @Column(name = "chat_room_id", nullable = false)
    private Long chatRoomId;

    @Id
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "is_exited", nullable = false)
    private Boolean isExited;
}
