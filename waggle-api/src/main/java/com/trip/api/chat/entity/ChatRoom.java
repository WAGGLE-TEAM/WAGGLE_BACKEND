package com.trip.api.chat.entity;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "chat_room")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE chat_room SET is_deleted = true WHERE id = ?")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long creator;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    public ChatRoom(CreateChatRoomRequest chatRoomRequest) {
        this.name = chatRoomRequest.getChatRoomName();
        this.creator = chatRoomRequest.getChatRoomMaker();
        this.isDeleted = false;
    }
}
