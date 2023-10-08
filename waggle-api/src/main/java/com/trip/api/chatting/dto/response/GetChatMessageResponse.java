package com.trip.api.chatting.dto.response;

import com.trip.common.type.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetChatMessageResponse {

    private Long messageId;
    private Long memberId;
    private String message;
    private String messageType;
}
