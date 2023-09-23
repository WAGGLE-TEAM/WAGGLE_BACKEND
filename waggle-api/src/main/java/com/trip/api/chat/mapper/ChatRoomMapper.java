package com.trip.api.chat.mapper;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.entity.ChatRoom;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomMapper {

    public ChatRoom convertCreateChatRoomRequestDtoToEntity(CreateChatRoomRequest request) {
        ChatRoom chatRoom = new ChatRoom(request);
        return chatRoom;
    }
}
