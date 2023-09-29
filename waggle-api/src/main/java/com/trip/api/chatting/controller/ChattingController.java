package com.trip.api.chatting.controller;

import com.trip.api.chatting.dto.request.CreateChatMessageRequest;
import com.trip.api.chatting.dto.request.CreateChatRoomRequest;
import com.trip.api.chatting.dto.response.GetMyChatRoomResponse;
import com.trip.api.chatting.service.ChattingService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;

import java.util.List;

@RequestMapping("/chat")
@RequiredArgsConstructor
@RestController
public class ChattingController {

    private final ChattingService chatRoomService;

    @PostMapping
    public ResponseEntity<Void> createChatRoom(@Valid @RequestBody CreateChatRoomRequest chatRoomRequest) {
        Long chatRoomId = chatRoomService.createChatRoom(chatRoomRequest);
        return ResponseEntity.created(URI.create("/chat/" + chatRoomId)).build();
    }

    @DeleteMapping("/{chatRoomId}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long chatRoomId) {
        chatRoomService.deleteChatRoom(chatRoomId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/exit-room/{chatRoomId}")
    public ResponseEntity<Void> exitChatRoom(@PathVariable Long chatRoomId) {
        // TODO: get userId from jwt
        chatRoomService.exitChatRoom(chatRoomId, 71L);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetMyChatRoomResponse>> getMyChatRooms() {
        List<GetMyChatRoomResponse> result = chatRoomService.getMyChatRooms(71L);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/{chatRoomId}")
    public ResponseEntity<Void> enterToChatRoom(@PathVariable Long chatRoomId) {
        chatRoomService.enterToChatRoom(71L, chatRoomId);
        return ResponseEntity.created(URI.create("/chat/" + chatRoomId)).build();
    }

    // TODO: 이미지 전송 처리
    @PostMapping("/message/{chatRoomId}")
    public ResponseEntity<Void> sendMessage(
        @PathVariable Long chatRoomId,
        @Valid @RequestBody CreateChatMessageRequest chatMessageRequest
    ) {
        Long messageId = chatRoomService.sendMessage(71L, chatRoomId, chatMessageRequest);
        return ResponseEntity.created(URI.create("/chat/message/" + chatRoomId + "/" + messageId)).build();
    }
}
