package com.trip.api.chat.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
public class CreateChatRoomRequest {

    @NotEmpty
    private ArrayList<Integer> joinUsers;

    @NotNull
    private Long chatRoomMaker;

    private String chatRoomName;
}
