package com.trip.api.chatting.service;

import com.trip.api.chatting.dto.param.ConvertChatMessageParameter;
import com.trip.api.chatting.dto.param.DeleteMessageParameter;
import com.trip.api.chatting.dto.param.SendMessageParameter;
import com.trip.api.chatting.dto.request.CreateChatRoomRequest;
import com.trip.api.chatting.dto.response.GetChatMessageResponse;
import com.trip.api.chatting.dto.response.GetMyChatRoomResponse;
import com.trip.api.chatting.entity.ChatMessage;
import com.trip.api.chatting.entity.ChatRoom;
import com.trip.api.chatting.entity.ChatRoomMember;
import com.trip.api.chatting.mapper.ChattingMapper;
import com.trip.api.chatting.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChattingService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;
    private final ChattingQueryDslRepository chattingQueryDslRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomMemberDao chatRoomMemberDao;
    private final ChattingMapper chattingMapper;

    @Transactional
    public Long createChatRoom(CreateChatRoomRequest chatRoomRequest) {
        ChatRoom chatRoom = chattingMapper.createChatRoomRequestToEntity(chatRoomRequest);
        List<Long> joinUsers = chatRoomRequest.getJoinUsers();
        Long chatRoomId = chatRoomRepository.save(chatRoom).getId();
        chatRoomMemberDao.saveAllChatMembers(joinUsers, chatRoomId);

        return chatRoomId;
    }

    @Transactional
    public void deleteChatRoom(Long chatRoomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow();
        chatRoomRepository.deleteById(chatRoom.getId());
        chatMessageRepository.deleteAllByChatRoomId(chatRoom.getId());
        chatRoomMemberRepository.deleteAllByChatRoomId(chatRoom.getId());
    }

    @Transactional
    public void exitChatRoom(Long chatRoomId, Long memberId) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow();
        chatRoomMemberRepository.deleteChatRoomMember(chatRoom.getId(), memberId);
    }

    @Transactional(readOnly = true)
    public List<GetMyChatRoomResponse> getMyChatRooms(Long memberId) {
        return chattingQueryDslRepository.findAllMyChatRoom(memberId);
    }

    public void enterToChatRoom(Long memberId, Long chatRoomId) {
        Long roomId = chatRoomRepository.findChatRoomById(chatRoomId).orElseThrow();
        ChatRoomMember chatRoomMember = chatRoomMemberRepository.findChatRoomMemberByMemberId(roomId, memberId)
            .orElseGet(() -> new ChatRoomMember(memberId, chatRoomId));
        chatRoomMember.updateStatus();
        chatRoomMemberRepository.save(chatRoomMember);
    }

    public Long sendMessage(SendMessageParameter parameter) {
        ChatRoom chatRoom = chatRoomRepository.findById(parameter.getChatRoomId()).orElseThrow();
        ChatMessage chatMessage = chattingMapper.createChatMessageRequestToEntity(
            new ConvertChatMessageParameter(
                parameter.getMemberId(),
                chatRoom.getId(),
                parameter.getChatMessageRequest()
            )
        );

        return chatMessageRepository.save(chatMessage).getId();
    }

    public void deleteMessage(DeleteMessageParameter parameter) {
        chatRoomRepository.findChatRoomById(parameter.getChatRoomId()).orElseThrow();
        Long messageId = chatMessageRepository.findChatMessageById(parameter.getMessageId()).orElseThrow();

        chatMessageRepository.deleteById(messageId);
    }

    @Transactional(readOnly = true)
    public List<GetChatMessageResponse> getChatMessages(Long chatRoomId) {
        Long roomId = chatRoomRepository.findChatRoomById(chatRoomId).orElseThrow();
        return chattingQueryDslRepository.findAllChatMessage(roomId);
    }
}