package com.travity.api.domain.chatting.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteMessageParameter {

    private final Long chatRoomId;
    private final Long messageId;
    private final Long memberId;
}
