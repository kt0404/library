package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.CommentForm;
import com.cbox.library.domain.model.Comment;
import com.cbox.library.domain.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	public List<Comment> getComments(Integer memberId) {
		List<Map<String, Object>> tmpList = commentRepository.getComments(memberId);
		List<Comment> result = new ArrayList<>();
		for (Map<String, Object> map : tmpList) {
			Comment comment = new Comment();
			comment.setCommentId((Integer) map.get("comment_id"));
			comment.setMemberId((Integer) map.get("member_Id"));
			comment.setComment((String) map.get("comment"));
			comment.setUserAgent((String) map.get("user_agent"));
			comment.setIpAddress((String) map.get("ip_address"));
			comment.setCreatedAt(((Timestamp) map.get("created_at")).toLocalDateTime().toLocalDate());
			result.add(comment);
		}
		return result;
	}

	public void create(CommentForm form, String userAgent, String ipAddress) {
		int memberId = form.getMemberId();
		String comment = form.getComment();
		commentRepository.create(memberId, comment, userAgent, ipAddress);
	}
	
}
