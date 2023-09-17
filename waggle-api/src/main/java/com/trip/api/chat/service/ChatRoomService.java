package com.trip.api.chat.service;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.entity.ChatRoom;
import com.trip.api.chat.mapper.ChatRoomMapper;
import com.trip.api.chat.repository.ChatRoomMemberRepository;
import com.trip.api.chat.repository.ChatRoomQueryDslRepository;
import com.trip.api.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomQueryDslRepository chatRoomQueryDslRepository;
    private final ChatRoomMemberRepository chatRoomMemberRepository;
    private final ChatRoomMapper chatRoomMapper;
    private final JdbcTemplate jdbcTemplate;

    public Long createChatRoom(CreateChatRoomRequest chatRoomRequest) {
        ChatRoom chatRoom = chatRoomMapper.convertRequestDtoToEntity(chatRoomRequest);
        List<Integer> joinUsers = chatRoomRequest.getJoinUsers();

        Long chatRoomId = chatRoomRepository.save(chatRoom).getId();
        jdbcTemplate.batchUpdate("INSERT INTO chat_room_member (chat_room_id, member_id, is_exited) VALUES(" + chatRoomId + ", CAST(? AS bigint), true)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, String.valueOf(joinUsers.get(i)));
                    }

                    @Override
                    public int getBatchSize() {
                        return joinUsers.size();
                    }
                }
        );

        return chatRoomId;
    }

    public void deleteChatRoom(Long chatRoomId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(chatRoomId);
        chatRoomRepository.deleteById(chatRoom.get().getId());
    }
}
