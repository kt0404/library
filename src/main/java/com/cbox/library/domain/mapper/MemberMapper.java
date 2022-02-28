package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cbox.library.domain.model.Member;

@Mapper
public interface MemberMapper {
    
    @Delete("DELETE FROM member WHERE member_id = #{memberId}")
    public boolean deleteByMemberId(int memberId);
    
    public List<Member> find(@Param("memberId") Integer memberId);
    
    public boolean create(@Param("name") String name, @Param("furigana") String furigana, @Param("boardId") Integer boardId, @Param("discription") String discription);
    
    public boolean update(@Param("name") String name, @Param("furigana") String furigana,
            @Param("boardId") Integer boardId, @Param("discription") String discription, @Param("memberId") Integer memberId);
    
}
