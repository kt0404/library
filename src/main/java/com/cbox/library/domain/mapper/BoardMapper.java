package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cbox.library.domain.model.Board;

@Mapper
public interface BoardMapper {
    
    @Select("SELECT * FROM board WHERE board_id = #{boardId}")
    public Board findByBoardId(int boardId);
    
    public List<Board> find(@Param("boardId") Integer boardId);
    
}
