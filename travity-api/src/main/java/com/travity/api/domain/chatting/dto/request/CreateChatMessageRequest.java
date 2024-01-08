package com.travity.api.domain.chatting.dto.request;

import com.travity.common.annotation.ValidateType;
import com.travity.common.dto.type.MessageType;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateChatMessageRequest {

    @NotBlank(message = "빈 메세지를 보낼 수 없습니다.")
    private String message;

    @ValidateType(enumClass = MessageType.class, message = "올바른 메세지 타입이 아닙니다.")
    private String messageType;
}
