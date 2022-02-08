package com.cbox.library.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Map<String, Object>> getAllOrderById() {
		String sql = "SELECT * FROM board ORDER BY id";
		return jdbc.queryForList(sql);
	}
}
