package com.trip.api.chatting.mapper;

import com.trip.api.chatting.dto.param.ConvertChatMessageParameter;
import com.trip.api.chatting.dto.request.CreateChatRoomRequest;
import com.trip.api.chatting.entity.ChatMessage;
import com.trip.api.chatting.entity.ChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ChattingMapper {

    public ChatRoom createChatRoomRequestToEntity(CreateChatRoomRequest request) {
        return new ChatRoom(request.getChatRoomName(), request.getChatRoomMaker());
    }

    public ChatMessage createChatMessageRequestToEntity(ConvertChatMessageParameter parameter) {
        return ChatMessage.builder()
            .memberId(parameter.getMemberId())
            .chatRoomId(parameter.getChatRoomId())
            .message(parameter.getRequest().getMessage())
            .messageType(parameter.getRequest().getMessageType())
            .build();
    }
}
