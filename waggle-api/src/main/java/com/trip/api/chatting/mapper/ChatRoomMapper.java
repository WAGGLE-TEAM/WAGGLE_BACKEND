package com.trip.api.chatting.mapper;

import com.trip.api.chatting.dto.request.CreateChatMessageRequest;
import com.trip.api.chatting.dto.request.CreateChatRoomRequest;
import com.trip.api.chatting.entity.ChatMessage;
import com.trip.api.chatting.entity.ChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ChatRoomMapper {

    public ChatRoom convertCreateChatRoomReqDtoToEntity(CreateChatRoomRequest request) {
        return new ChatRoom(request.getChatRoomName(), request.getChatRoomMaker());
    }

    public ChatMessage convertCreateChatMessageReqDtoToEntity(
        Long memberId,
        Long chatRoomId,
        CreateChatMessageRequest request
    ) {
        return new ChatMessage(memberId, chatRoomId, request.getMessage(), request.getMessageType());
    }
}
