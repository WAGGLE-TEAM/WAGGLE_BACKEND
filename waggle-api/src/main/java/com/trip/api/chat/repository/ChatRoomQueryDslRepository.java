package com.trip.api.chat.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.api.chat.entity.QChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ChatRoomQueryDslRepository {

    private final JPAQueryFactory queryDslFactory;
    private QChatRoom qChatRoom = QChatRoom.chatRoom;

}
