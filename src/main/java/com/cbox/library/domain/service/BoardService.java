package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public List<Board> getAll() {
		List<Map<String, Object>> tmpList = boardRepository.getAllOrderById();
		List<Board> result = new ArrayList<>();
		for (Map<String, Object> map : tmpList) {
			Board board = new Board();
			board.setId((Integer) map.get("id"));
			board.setName((String) map.get("name"));
			board.setCreatedAt((Timestamp) map.get("created_at"));
			board.setUpdatedAt((Timestamp) map.get("updated_at"));
			result.add(board);
		}
		return result;
	}
}
