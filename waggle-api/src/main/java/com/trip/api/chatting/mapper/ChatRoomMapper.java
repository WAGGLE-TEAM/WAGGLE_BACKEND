package com.trip.api.chatting.mapper;

import com.trip.api.chatting.dto.request.CreateChatRoomRequest;
import com.trip.api.chatting.entity.ChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ChatRoomMapper {

    public ChatRoom convertCreateChatRoomRequestDtoToEntity(CreateChatRoomRequest request) {
        return new ChatRoom(request.getChatRoomName(), request.getChatRoomMaker());
    }
}
