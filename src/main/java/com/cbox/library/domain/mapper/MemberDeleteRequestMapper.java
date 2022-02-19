package com.cbox.library.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cbox.library.domain.model.DeleteRequest;

@Mapper
public interface MemberDeleteRequestMapper {
    @Select("SELECT id, member_id AS memberId, delete_reason AS deleteReason, user_agent AS userAgent, ip_address AS ipAddress, created_at AS createdAt, delete_flag AS deleteFlag FROM delete_request WHERE id = #{id}")
    public DeleteRequest findById(int id);
    
    @Select("SELECT d.id AS id, d.member_id AS memberId, m.name AS memberName, d.delete_reason AS deleteReason, d.user_agent AS userAgent, d.ip_address AS ipAddress, d.created_at AS createdAt, d.delete_flag AS deleteFlag FROM delete_request AS d LEFT JOIN member AS m ON d.member_id = m.id WHERE d.delete_flag = #{deleteFlag}")
    public List<DeleteRequest> findAllByDeleteFlagWithMemberName(int deleteFlag);
    
    @Select("SELECT d.id AS id, d.member_id AS memberId, m.name AS memberName, d.delete_reason AS deleteReason, d.user_agent AS userAgent, d.ip_address AS ipAddress, d.created_at AS createdAt, d.delete_flag AS deleteFlag FROM delete_request AS d LEFT JOIN member AS m ON d.member_id = m.id WHERE d.id = #{id}")
    public DeleteRequest findByIdWithMemberName(int id);
    
    @Update("UPDATE delete_request SET delete_flag = #{deleteFlag} WHERE id = #{id}")
    public boolean updateDeleteFlagById(int id, int deleteFlag);
    
    @Update("UPDATE delete_request SET delete_flag = #{deleteFlag} WHERE member_id = #{memberId}")
    public boolean updateDeleteFlagByMemberId(int memberId, int deleteFlag);
}
