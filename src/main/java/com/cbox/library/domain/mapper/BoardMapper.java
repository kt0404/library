package com.cbox.library.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cbox.library.domain.model.Board;

@Mapper
public interface BoardMapper {
    
    @Select("SELECT * FROM board WHERE board_id = #{boardId}")
    public Board findByBoardId(int boardId);
    
}
