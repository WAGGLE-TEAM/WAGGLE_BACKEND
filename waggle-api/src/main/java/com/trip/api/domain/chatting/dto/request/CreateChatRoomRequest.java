package com.trip.api.domain.chatting.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;

@Getter
public class CreateChatRoomRequest {

    private ArrayList<Long> joinUsers;

    @NotNull(message = "방장은 필수 값입니다.")
    private Long chatRoomMaker;

    private String chatRoomName;
}
