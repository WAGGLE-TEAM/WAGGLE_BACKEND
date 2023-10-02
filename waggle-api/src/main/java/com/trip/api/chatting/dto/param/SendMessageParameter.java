package com.trip.api.chatting.dto.param;

import com.trip.api.chatting.dto.request.CreateChatMessageRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SendMessageParameter {

    private Long memberId;
    private Long chatRoomId;
    private CreateChatMessageRequest chatMessageRequest;
}
