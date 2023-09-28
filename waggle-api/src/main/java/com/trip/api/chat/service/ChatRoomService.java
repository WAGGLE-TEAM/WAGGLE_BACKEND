package com.trip.api.chat.service;

import com.querydsl.core.Tuple;
import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.dto.response.GetMyChatRoomResponse;
import com.trip.api.chat.entity.ChatRoom;
import com.trip.api.chat.entity.ChatRoomMember;
import com.trip.api.chat.mapper.ChatRoomMapper;
import com.trip.api.chat.repository.ChatRoomMemberDao;
import com.trip.api.chat.repository.ChatRoomMemberRepository;
import com.trip.api.chat.repository.ChatRoomQueryDslRepository;
import com.trip.api.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;
    private final ChatRoomQueryDslRepository chatRoomQueryDslRepository;
    private final ChatRoomMemberDao chatRoomMemberDao;
    private final ChatRoomMapper chatRoomMapper;

    @Transactional
    public Long createChatRoom(CreateChatRoomRequest chatRoomRequest) {
        ChatRoom chatRoom = chatRoomMapper.convertCreateChatRoomRequestDtoToEntity(chatRoomRequest);
        List<Long> joinUsers = chatRoomRequest.getJoinUsers();
        Long chatRoomId = chatRoomRepository.save(chatRoom).getId();
        chatRoomMemberDao.saveAllChatMembers(joinUsers, chatRoomId);

        return chatRoomId;
    }

    public void deleteChatRoom(Long chatRoomId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(chatRoomId);
        chatRoomRepository.deleteById(chatRoom.get().getId());
    }

    @Transactional
    public void exitChatRoom(Long chatRoomId, Long memberId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(chatRoomId);
        chatRoomMemberRepository.deleteChatRoomMember(chatRoom.get().getId(), memberId);
    }

    public List<GetMyChatRoomResponse> getMyChatRooms(Long memberId) {
        return chatRoomQueryDslRepository.findAllMyChatRoom(memberId);
    }

    // TODO: 예외 처리
    public void enterToChatRoom(Long memberId, Long chatRoomId) {
        Long chatRoom = chatRoomRepository.findChatRoomById(chatRoomId);

        if (chatRoom != null) {
            chatRoomMemberRepository.save(new ChatRoomMember(memberId, chatRoomId));
        }
    }
}