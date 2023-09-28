package com.trip.api.chat.repository;

import com.trip.api.chat.entity.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query(
        nativeQuery = true,
        value = "SELECT id " +
                "FROM chat_room " +
                "WHERE id = :chatRoomId AND is_deleted = false"
    )
    Long findChatRoomById(Long chatRoomId);
}