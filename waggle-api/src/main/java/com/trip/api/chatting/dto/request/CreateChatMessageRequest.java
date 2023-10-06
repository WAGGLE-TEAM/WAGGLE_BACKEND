package com.trip.api.chatting.dto.request;

import com.trip.common.annotation.ValidateType;
import com.trip.common.type.MessageType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateChatMessageRequest {

    @NotBlank
    private String message;

    @ValidateType(enumClass = MessageType.class)
    private String messageType;
}
