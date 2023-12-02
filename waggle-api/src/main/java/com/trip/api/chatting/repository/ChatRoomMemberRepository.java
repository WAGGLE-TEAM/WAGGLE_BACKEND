package com.trip.api.chatting.repository;

import com.trip.api.chatting.entity.ChatRoomMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long> {

    @Modifying(clearAutomatically = true)
    @Query(
            nativeQuery = true,
            value = "UPDATE chat_room_member " +
                    "SET is_exited = true " +
                    "WHERE chat_room_id = :chatRoomId AND member_id = :memberId"
    )
    void deleteChatRoomMember(Long chatRoomId, Long memberId);

    @Modifying(clearAutomatically = true)
    @Query(
        nativeQuery = true,
        value = "UPDATE chat_room_member " +
                "SET is_exited = true " +
                "WHERE chat_room_id = :chatRoomId"
    )
    void deleteAllByChatRoomId(Long chatRoomId);

    @Query(
        nativeQuery = true,
        value = "SELECT * " +
                "FROM chat_room_member " +
                "WHERE member_id = :memberId AND chat_room_id = :chatRoomId"
    )
    Optional<ChatRoomMember> findChatRoomMemberByMemberId(Long chatRoomId, Long memberId);
}
