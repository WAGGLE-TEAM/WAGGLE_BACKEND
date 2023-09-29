package com.trip.api.chatting.dto.request;

import com.trip.api.config.ValidateType;
import com.trip.api.dto.MessageType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateChatMessageRequest {

    @NotBlank
    private String message;

    @ValidateType(enumClass = MessageType.class)
    private String messageType;
}
