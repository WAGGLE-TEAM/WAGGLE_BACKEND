package com.travity.api.domain.chatting.entity;

import com.travity.api.config.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@DynamicInsert
@Table(name = "chat_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE chat_room SET is_deleted = true WHERE id = ?")
public class ChatRoom extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long creator;

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    private Boolean isDeleted;

    public ChatRoom(String name, Long creator) {
        this.name = name;
        this.creator = creator;
    }
}
