package com.cbox.library.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbc;

    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM member ORDER BY furigana";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> findOne(int memberId) {
        String sql = "SELECT * FROM member WHERE member_id = ?";
        Map<String, Object> result;
        try {
            result = jdbc.queryForMap(sql, memberId);
        } catch (IncorrectResultSizeDataAccessException e) {
            result = null;
        }
        return result;
    }

    public int updateDiscription(int memberId, String discription) {
        String sql = "UPDATE member SET discription = :discription WHERE member_id = :memberId";
        return namedJdbc.update(sql, new MapSqlParameterSource()
                .addValue("discription", discription)
                .addValue("memberId", memberId));
    }
    
}
