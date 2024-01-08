package com.travity.api.domain.chatting.dto.entitykey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChatRoomMemberKey implements Serializable {

    private Long chatRoomId;

    private Long memberId;
}
