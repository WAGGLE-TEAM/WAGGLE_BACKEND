package com.trip.api.domain.chatting.repository;

import com.trip.api.domain.chatting.entity.ChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query(
        value = "SELECT id " +
                "FROM ChatMessage " +
                "WHERE id = :chatMessageId AND isDeleted = false"
    )
    Optional<Long> findChatMessageById(Long chatMessageId);

    @Modifying(clearAutomatically = true)
    @Query(
        value = "UPDATE ChatMessage " +
                "SET isDeleted = true " +
                "WHERE id = :chatRoomId"
    )
    void deleteAllByChatRoomId(Long chatRoomId);
}
