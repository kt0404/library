package com.cbox.library.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbc;

	public List<Map<String, Object>> getComments(int memberId) {
		String sql = "SELECT * FROM comment WHERE member_id = :memberId ORDER BY created_at DESC";
		return namedJdbc.queryForList(sql, new MapSqlParameterSource().addValue("memberId", memberId));
	}
	
	public void create(int memberId, String comment, String userAgent, String ipAddress) {
		String sql = "INSERT INTO comment(member_id, comment, user_agent, ip_address, created_at)"
				+ " VALUES(:memberId, :comment, :userAgent, :ipAddress, now())";
		namedJdbc.update(sql, new MapSqlParameterSource()
		        .addValue("memberId", memberId)
		        .addValue("comment", comment)
				.addValue("userAgent", userAgent)
				.addValue("ipAddress", ipAddress));
	}
}
