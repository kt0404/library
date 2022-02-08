package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.RegisterForm;
import com.cbox.library.domain.form.UserUpdateForm;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User findOne(int id) {
		Map<String, Object> map = userRepository.findOne(id);
		if (map == null)
			return null;
		User user = new User();
		user.setId((Integer) map.get("id"));
		user.setName((String) map.get("name"));
		user.setFurigana((String) map.get("furigana"));
		user.setBoardId((Integer) map.get("board_id"));
		user.setDiscription((String) map.get("discription"));
		user.setCreatedAt((Timestamp) map.get("created_at"));
		user.setUpdatedAt((Timestamp) map.get("updated_at"));
		return user;
	}

	public List<User> findAll() {
		List<User> result = new ArrayList<>();
		List<Map<String, Object>> tmpList = userRepository.findAll();
		for (Map<String, Object> map : tmpList) {
			User user = new User();
			user.setId((Integer) map.get("id"));
			user.setName((String) map.get("name"));
			user.setFurigana((String) map.get("furigana"));
			user.setBoardId((Integer) map.get("board_id"));
			user.setDiscription((String) map.get("discription"));
			user.setCreatedAt((Timestamp) map.get("created_at"));
			user.setUpdatedAt((Timestamp) map.get("updated_at"));
			result.add(user);
		}
		return result;
	}

	public int create(RegisterForm form) {
		String name = form.getName();
		String furigana = form.getFurigana();
		int boardId = form.getBoardId();
		String discription = form.getDiscription();
		return userRepository.create(name, furigana, boardId, discription);
	}
	
	public int updateDiscription(UserUpdateForm form) {
	    int id = form.getUserId();
	    String discription = form.getDiscription();
	    return userRepository.updateDiscription(id, discription);
	}
}
