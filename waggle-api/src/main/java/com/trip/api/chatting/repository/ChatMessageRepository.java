package com.trip.api.chatting.repository;

import com.trip.api.chatting.entity.ChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "SELECT id " +
                "FROM chat_message " +
                "WHERE id = :chatMessageId AND is_deleted = false"
    )
    Optional<Long> findChatMessageById(Long chatMessageId);

    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "UPDATE chat_message " +
                "SET is_deleted = true " +
                "WHERE id = :chatRoomId"
    )
    void deleteAllByChatRoomId(Long chatRoomId);
}
