package com.trip.api.chat.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE chat_message SET is_deleted = true WHERE id = ?")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public ChatRoom(String name) {
        this.name = name;
        this.isDeleted = false;
    }
}
