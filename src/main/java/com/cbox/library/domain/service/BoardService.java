package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.mapper.BoardMapper;
import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.repository.BoardRepository;

@Service
public class BoardService {
    
    @Autowired
    private BoardMapper boardMapper;

	@Autowired
	private BoardRepository boardRepository;
	
	public Board findByBoardId(int boardId) {
	    return boardMapper.findByBoardId(boardId);
	}

	public List<Board> getAll() {
		List<Map<String, Object>> tmpList = boardRepository.getAllOrderByBoardId();
		List<Board> result = new ArrayList<>();
		for (Map<String, Object> map : tmpList) {
			Board board = new Board();
			board.setBoardId((Integer) map.get("board_id"));
			board.setName((String) map.get("name"));
			board.setCreatedAt((Timestamp) map.get("created_at"));
			board.setUpdatedAt((Timestamp) map.get("updated_at"));
			result.add(board);
		}
		return result;
	}
	
}
