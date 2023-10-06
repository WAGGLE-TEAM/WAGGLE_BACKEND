package com.trip.api.chatting.repository;

import com.trip.api.chatting.entity.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query(
        nativeQuery = true,
        value = "SELECT id " +
                "FROM chat_room " +
                "WHERE id = :chatRoomId AND is_deleted = false"
    )
    Optional<Long> findChatRoomById(Long chatRoomId);
}