package com.trip.api.chat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ChatRoomMemberDao {

    private final JdbcTemplate jdbcTemplate;

    public void saveAllChatMembers(List<Long> joinUsers, Long chatRoomId) {
        jdbcTemplate.batchUpdate(
            "INSERT INTO chat_room_member (chat_room_id, member_id, is_exited) VALUES (?, ?, ?)",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setLong(1, chatRoomId);
                    ps.setLong(2, joinUsers.get(i));
                    ps.setBoolean(3, false);
                }

                @Override
                public int getBatchSize() {
                    return joinUsers.size();
                }
            }
        );
    }
}
