package com.trip.api.chatting.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllChatRoomResponse {

    private Long chatRoomId;
    private String title;
}