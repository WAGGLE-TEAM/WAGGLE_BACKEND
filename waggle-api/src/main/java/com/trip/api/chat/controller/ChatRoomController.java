package com.trip.api.chat.controller;

import com.querydsl.core.Tuple;
import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

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
    public ResponseEntity<List<Tuple>> getMyChatRooms() {
        List<Tuple> result = chatRoomService.getMyChatRooms(71L);
        return ResponseEntity.ok().body(result);
    }
}
