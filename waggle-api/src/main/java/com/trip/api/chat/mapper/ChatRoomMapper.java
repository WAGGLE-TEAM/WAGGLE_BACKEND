package com.trip.api.chat.mapper;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;

import com.trip.api.chat.entity.ChatRoom;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomMapper {

    public ChatRoom convertCreateChatRoomRequestDtoToEntity(CreateChatRoomRequest request) {
        return new ChatRoom(request.getChatRoomName(), request.getChatRoomMaker());
    }
}
