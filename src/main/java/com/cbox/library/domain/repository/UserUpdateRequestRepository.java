package com.cbox.library.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserUpdateRequestRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedJdbc;
    
    public int create(int userId, String name, String furigana, int boardId, String discription, String userAgent, String ipAddress) {
        String sql = "INSERT INTO update_request(user_id, name, furigana, board_id, discription, user_agent, ip_address, created_at, delete_flag)"
                + "VALUES(:userId, :name, :furigana, :boardId, :discription, :userAgent, :ipAddress, now(), 0)";
        return namedJdbc.update(sql, new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("name", name)
                .addValue("furigana", furigana)
                .addValue("boardId", boardId)
                .addValue("discription", discription)
                .addValue("userAgent", userAgent)
                .addValue("ipAddress", ipAddress));
    }
}
