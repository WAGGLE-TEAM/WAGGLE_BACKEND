package com.trip.api.chat.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.api.chat.dto.response.GetMyChatRoomResponse;
import com.trip.api.chat.entity.ChatRoom;
import com.trip.api.chat.entity.QChatRoom;
import com.trip.api.chat.entity.QChatRoomMember;
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
                .select(Projections.constructor(
                        GetMyChatRoomResponse.class,
                        qChatRoom.id.as("chatRoomId"),
                        qChatRoom.name.as("title")
                ))
                .from(qChatRoom)
                .join(qChatRoomMember).on(qChatRoom.id.eq(qChatRoomMember.id.chatRoomId))
                .where(qChatRoomMember.id.memberId.eq(memberId), qChatRoomMember.isExited.eq(false))
                .fetch();
    }
}
