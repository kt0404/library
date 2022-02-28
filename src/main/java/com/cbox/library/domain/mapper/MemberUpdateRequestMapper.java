package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbox.library.domain.model.UpdateRequest;

@Mapper
public interface MemberUpdateRequestMapper {
    
    @Select("SELECT update_request_id AS updateRequestId, member_id AS memberId, name, furigana, board_id AS boardId, discription, user_agent AS userAgent, ip_address AS ipAddress, created_at AS createdAt, delete_flag AS deleteFlag FROM update_request WHERE update_request_id = #{updateRequestId}")
    public UpdateRequest findByUpdateRequestId(int updateRequestId);
    
    @Update("UPDATE update_request SET delete_flag = #{deleteFlag} WHERE member_id = #{memberId}")
    public boolean updateDeleteFlagByMemberId(int memberId, int deleteFlag);
    
    public List<UpdateRequest> find(@Param("updateRequestId") Integer updateRequestId, @Param("deleteFlag") Integer deleteFlag);
    
    public boolean updateDeleteFlagByUpdateRequestId(@Param("deleteFlag") int deleteFlag, @Param("updateRequestId") int updateRequestId);
    
}
