package com.cbox.library.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDeleteRequestRepository {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Autowired
    NamedParameterJdbcTemplate namedJdbc;
    
    public int create(int memberId, String deleteReason, String userAgent, String ipAddress) {
        String sql = "INSERT INTO delete_request(member_id, delete_reason, user_agent, ip_address, created_at, delete_flag)"
                + "VALUES(:memberId, :deleteReason, :userAgent, :ipAddress, now(), 0)";
        return namedJdbc.update(sql, new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("deleteReason", deleteReason)
                .addValue("userAgent", userAgent)
                .addValue("ipAddress", ipAddress));
    }
    
    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM delete_request";
        return jdbc.queryForList(sql);
    }
    
    public List<Map<String, Object>> findAllByDeleteFlag(int deleteFlag) {
        String sql = "SELECT * FROM delete_request WHERE delete_flag = ?";
        return jdbc.queryForList(sql, deleteFlag);
    }
    
}
