package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbox.library.domain.model.DeleteRequest;

@Mapper
public interface MemberDeleteRequestMapper {
    
    @Select("SELECT delete_request_id, member_id AS memberId, delete_reason AS deleteReason, user_agent AS userAgent, ip_address AS ipAddress, created_at AS createdAt, delete_flag AS deleteFlag FROM delete_request WHERE delete_request_id = #{deleteRequestId}")
    public DeleteRequest findByDeleteRequestId(int deleteRequestId);
    
    @Select("SELECT d.delete_request_id AS deleteRequestId, d.member_id AS memberId, m.name AS memberName, d.delete_reason AS deleteReason, d.user_agent AS userAgent, d.ip_address AS ipAddress, d.created_at AS createdAt, d.delete_flag AS deleteFlag FROM delete_request AS d LEFT JOIN member AS m ON d.member_id = m.member_id WHERE d.delete_flag = #{deleteFlag}")
    public List<DeleteRequest> findAllByDeleteFlagWithMemberName(int deleteFlag);
    
    @Select("SELECT d.delete_request_id AS deleteRequestId, d.member_id AS memberId, m.name AS memberName, d.delete_reason AS deleteReason, d.user_agent AS userAgent, d.ip_address AS ipAddress, d.created_at AS createdAt, d.delete_flag AS deleteFlag FROM delete_request AS d LEFT JOIN member AS m ON d.member_id = m.member_id WHERE d.delete_request_id = #{deleteRequestId}")
    public DeleteRequest findByDeleteRequestIdWithMemberName(int deleteRequestId);
    
    @Update("UPDATE delete_request SET delete_flag = #{deleteFlag} WHERE delete_request_id = #{deleteRequestId}")
    public boolean updateDeleteFlagByDeleteRequestId(int deleteRequestId, int deleteFlag);
    
    @Update("UPDATE delete_request SET delete_flag = #{deleteFlag} WHERE member_id = #{memberId}")
    public boolean updateDeleteFlagByMemberId(int memberId, int deleteFlag);
    
}
