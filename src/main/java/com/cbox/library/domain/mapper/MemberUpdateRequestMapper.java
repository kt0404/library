package com.cbox.library.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbox.library.domain.model.UpdateRequest;

@Mapper
public interface MemberUpdateRequestMapper {
    @Select("SELECT id, member_id AS memberId, name, furigana, board_id AS boardId, discription, user_agent AS userAgent, ip_address AS ipAddress, created_at AS createdAt, delete_flag AS deleteFlag FROM update_request WHERE id = #{updateRequestId}")
    public UpdateRequest findByid(int updateRequestId);
    
    @Update("UPDATE update_request SET delete_flag = #{deleteFlag} WHERE member_id = #{memberId}")
    public boolean updateDeleteFlagByMemberId(int memberId, int deleteFlag);
}
