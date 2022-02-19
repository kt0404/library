package com.cbox.library.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberUpdateRequestRepository {
    @Autowired
    private JdbcTemplate jdbc;
    
    @Autowired
    private NamedParameterJdbcTemplate namedJdbc;
    
    public int create(int memberId, String name, String furigana, int boardId, String discription, String userAgent, String ipAddress) {
        String sql = "INSERT INTO update_request(member_id, name, furigana, board_id, discription, user_agent, ip_address, created_at, delete_flag)"
                + "VALUES(:memberId, :name, :furigana, :boardId, :discription, :userAgent, :ipAddress, now(), 0)";
        return namedJdbc.update(sql, new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("name", name)
                .addValue("furigana", furigana)
                .addValue("boardId", boardId)
                .addValue("discription", discription)
                .addValue("userAgent", userAgent)
                .addValue("ipAddress", ipAddress));
    }
    
    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM update_request";
        return jdbc.queryForList(sql);
    }
    
    public List<Map<String, Object>> findAllByDeleteFlag(int flag) {
        String sql = "SELECT * FROM update_request WHERE delete_flag = ?";
        return jdbc.queryForList(sql, flag);
    }
}
