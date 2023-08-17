package com.trip.api.chat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long chatRoomId;

    String name;

    @Column(name = "is_active")
    @ColumnDefault("true")
    boolean isActive;

    public ChatRoom(String name) {
        this.name = name;
    }
}
