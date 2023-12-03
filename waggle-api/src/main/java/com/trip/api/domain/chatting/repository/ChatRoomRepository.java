package com.trip.api.domain.chatting.repository;

import com.trip.api.domain.chatting.entity.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query(
        value = "SELECT id " +
                "FROM ChatRoom " +
                "WHERE id = :chatRoomId AND isDeleted = false"
    )
    Optional<Long> findChatRoomById(Long chatRoomId);

    @Query(
        value = "SELECT creator " +
                "FROM ChatRoom " +
                "WHERE id = :chatRoomId AND isDeleted = false"
    )
    Optional<Long> findCreatorById(Long chatRoomId);
}