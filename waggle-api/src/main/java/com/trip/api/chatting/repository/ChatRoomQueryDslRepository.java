package com.trip.api.chatting.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.trip.api.chatting.dto.response.GetMyChatRoomResponse;
import com.trip.api.chatting.entity.QChatRoom;
import com.trip.api.chatting.entity.QChatRoomMember;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ChatRoomQueryDslRepository<T> {

    private final JPAQueryFactory jpaQueryFactory;
    private QChatRoom qChatRoom = QChatRoom.chatRoom;
    private QChatRoomMember qChatRoomMember = QChatRoomMember.chatRoomMember;

    // TODO: 페이지네이션 적용 여부 확인
    public List<GetMyChatRoomResponse> findAllMyChatRoom(Long memberId) {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    GetMyChatRoomResponse.class,
                    qChatRoom.id.as("chatRoomId"),
                    qChatRoom.name.as("title")
                )
            )
            .from(qChatRoom)
            .join(qChatRoomMember).on(qChatRoom.id.eq(qChatRoomMember.id.chatRoomId))
            .where(
                qChatRoomMember.id.memberId.eq(memberId),
                qChatRoomMember.isExited.eq(false),
                qChatRoom.isDeleted.eq(false)
            )
            .fetch();
    }
}
