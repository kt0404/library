package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbox.library.domain.model.Member;

@Mapper
public interface MemberMapper {
    @Select("SELECT id, name, furigana, board_id AS boardId, discription, created_at AS createdAt, updated_at AS updatedAt FROM member WHERE id = #{id}")
    public Member findById(int id);
    
    @Select("SELECT "
            + "id, "
            + "name, "
            + "furigana, "
            + "board_id AS boardId, "
            + "discription, "
            + "created_at AS createdAt, "
            + "updated_at AS updatedAt "
            + "FROM member")
    public List<Member> findAll();
    
    @Update("UPDATE update_request SET name = #{name}, furigana = #{furigana}, board_id = #{boardId}, discription = #{discription}, updated_at = now() WHERE id = #{memberId}")
    public boolean updateNameAndFuriganaAndBoardIdAndDiscriptionById(String name, String furigana, int boardId, String discription, int memberId);
    
    @Delete("DELETE FROM member WHERE id = #{memberId}")
    public boolean deleteById(int memberId);
}
