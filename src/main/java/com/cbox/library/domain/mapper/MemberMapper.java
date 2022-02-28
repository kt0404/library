package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cbox.library.domain.model.Member;

@Mapper
public interface MemberMapper {
    
    @Delete("DELETE FROM member WHERE id = #{memberId}")
    public boolean deleteById(int memberId);
    
    public List<Member> find(@Param("id") Integer id);
    
    public boolean create(@Param("name") String name, @Param("furigana") String furigana, @Param("boardId") Integer boardId, @Param("discription") String discription);
    
    public boolean update(@Param("name") String name, @Param("furigana") String furigana,
            @Param("boardId") Integer boardId, @Param("discription") String discription, @Param("id") Integer id);
    
}
