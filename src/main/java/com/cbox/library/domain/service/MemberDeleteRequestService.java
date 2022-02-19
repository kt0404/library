package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbox.library.domain.form.MemberDeleteRequestForm;
import com.cbox.library.domain.mapper.MemberDeleteRequestMapper;
import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.model.DeleteRequest;
import com.cbox.library.domain.repository.MemberDeleteRequestRepository;

@Service
@Transactional
public class MemberDeleteRequestService {
    @Autowired
    MemberDeleteRequestRepository memberDeleteRequestRepository;
    
    @Autowired
    MemberDeleteRequestMapper memberDeleteRequestMapper;
    
    @Autowired
    MemberMapper memberMapper;
    
    public int create(MemberDeleteRequestForm form, String userAgent, String ipAddress) {
        int memberId = form.getMemberId();
        String deleteReason = form.getDeleteReason();
        return memberDeleteRequestRepository.create(memberId, deleteReason, userAgent, ipAddress);
    }
    
    public DeleteRequest findById(int id) {
        return memberDeleteRequestMapper.findById(id);
    }
    
    public DeleteRequest findByIdWithMemberName(int id) {
        return memberDeleteRequestMapper.findByIdWithMemberName(id);
    }
    
    public List<DeleteRequest> findAllByDeleteFlag(int deleteFlag) {
        List<Map<String, Object>> tmpList = memberDeleteRequestRepository.findAllByDeleteFlag(deleteFlag);
        List<DeleteRequest> result = new ArrayList<>();
        for (Map<String, Object> map : tmpList) {
            DeleteRequest request = new DeleteRequest();
            request.setId((Integer) map.get("id"));
            request.setMemberId((Integer) map.get("member_id"));
            request.setDeleteReason((String) map.get("delete_reason"));
            request.setUserAgent((String) map.get("user_agent"));
            request.setIpAddress((String) map.get("ip_address"));
            request.setCreatedAt((Timestamp) map.get("created_at"));
            request.setDeleteFlag((Integer) map.get("delete_flag"));
            result.add(request);
        }
        return result;
    }
    
    public List<DeleteRequest> findAllByDeleteFlagWithMemberName(int deleteFlag) {
        return memberDeleteRequestMapper.findAllByDeleteFlagWithMemberName(deleteFlag);
    }
}
