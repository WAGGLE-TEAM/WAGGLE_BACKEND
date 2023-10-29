package com.trip.api.chatting.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetAllChatRoomMemberResponse {

    private Long creator;
    private List<GetAllChatMember> members;
}
