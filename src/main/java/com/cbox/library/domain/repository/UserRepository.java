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
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbc;

    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM usr ORDER BY furigana";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> findOne(int id) {
        String sql = "SELECT * FROM usr WHERE id = ?";
        Map<String, Object> result;
        try {
            result = jdbc.queryForMap(sql, id);
        } catch (IncorrectResultSizeDataAccessException e) {
            result = null;
        }
        return result;
    }

    public int create(String name, String furigana, int boardId, String discription) {
        String sql = "INSERT INTO usr(name, furigana, board_id, discription, created_at, updated_at)"
                + "VALUES(:name, :furigana, :boardId, :discription, now(), now())";
        return namedJdbc.update(sql, new MapSqlParameterSource().addValue("name", name).addValue("furigana", furigana)
                .addValue("boardId", boardId).addValue("discription", discription));
    }

    public int updateDiscription(int userId, String discription) {
        String sql = "UPDATE usr SET discription = :discription WHERE id = :userId";
        return namedJdbc.update(sql,
                new MapSqlParameterSource().addValue("discription", discription).addValue("userId", userId));
    }
}
