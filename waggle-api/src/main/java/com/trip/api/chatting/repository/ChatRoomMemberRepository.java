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
        value = "UPDATE ChatRoomMember " +
                "SET isExited = true " +
                "WHERE id.chatRoomId = :chatRoomId AND id.memberId = :memberId"
    )
    void deleteChatRoomMember(Long chatRoomId, Long memberId);

    @Modifying(clearAutomatically = true)
    @Query(
        value = "UPDATE ChatRoomMember " +
                "SET isExited = true " +
                "WHERE id.chatRoomId = :chatRoomId"
    )
    void deleteAllByChatRoomId(Long chatRoomId);

    @Query(
        value = "SELECT c " +
                "FROM ChatRoomMember c " +
                "WHERE c.id.memberId = :memberId AND c.id.chatRoomId = :chatRoomId"
    )
    Optional<ChatRoomMember> findChatRoomMemberByMemberId(Long chatRoomId, Long memberId);
}
