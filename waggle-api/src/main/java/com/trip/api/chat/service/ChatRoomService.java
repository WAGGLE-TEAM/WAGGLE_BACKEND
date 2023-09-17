package com.trip.api.chat.service;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.entity.ChatRoom;
import com.trip.api.chat.mapper.ChatRoomMapper;
import com.trip.api.chat.repository.ChatRoomMemberRepository;
import com.trip.api.chat.repository.ChatRoomQueryDslRepository;
import com.trip.api.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomQueryDslRepository chatRoomQueryDslRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;
    private final ChatRoomMapper chatRoomMapper;

    public Long createChatRoom(CreateChatRoomRequest chatRoomRequest) {
        ChatRoom chatRoom = chatRoomMapper.convertRequestDtoToEntity(chatRoomRequest);
        Long chatRoomId = chatRoomRepository.save(chatRoom).getId();
        return chatRoomId;
    }

    public void deleteChatRoom(Long chatRoomId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(chatRoomId);
        chatRoomRepository.deleteById(chatRoom.get().getId());
    }
}
