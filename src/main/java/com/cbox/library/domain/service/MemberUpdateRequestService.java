package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbox.library.domain.common.Constants;
import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.mapper.MemberUpdateRequestMapper;
import com.cbox.library.domain.model.UpdateRequest;
import com.cbox.library.domain.repository.MemberUpdateRequestRepository;

@Service
@Transactional
public class MemberUpdateRequestService {
    
    @Autowired
    MemberUpdateRequestRepository memberUpdateRequestRepository;
    
    @Autowired
    MemberUpdateRequestMapper memberUpdateRequestMapper;
    
    @Autowired
    MemberMapper memberMapper;
    
    public int create(MemberUpdateRequestForm form, String userAgent, String ipAdress) {
        int memberId = form.getMemberId();
        String name = form.getName();
        String furigana = form.getFurigana();
        int boardId = form.getBoardId();
        String discription = form.getDiscription();
        return memberUpdateRequestRepository.create(memberId, name, furigana, boardId, discription, userAgent, ipAdress);
    }
    
    public UpdateRequest findByUpdateRequestId(int updateRequestId) {
        return memberUpdateRequestMapper.findByUpdateRequestId(updateRequestId);
    }
    
    public List<UpdateRequest> findAllByDeleteFlag(int deleteFlag) {
        List<Map<String, Object>> tmpList = memberUpdateRequestRepository.findAllByDeleteFlag(deleteFlag);
        List<UpdateRequest> result = new ArrayList<>();
        for (Map<String, Object> map : tmpList) {
            UpdateRequest request = new UpdateRequest();
            request.setUpdateRequestId((Integer) map.get("update_request_id"));
            request.setMemberId((Integer) map.get("member_id"));
            request.setName((String) map.get("name"));
            request.setFurigana((String) map.get("furigana"));
            request.setBoardId((Integer) map.get("board_id"));
            request.setDiscription((String) map.get("discription"));
            request.setUserAgent((String) map.get("user_agent"));
            request.setIpAddress((String) map.get("ip_address"));
            request.setCreatedAt((Timestamp) map.get("created_at"));
            request.setDeleteFlag((Integer) map.get("delete_flag"));
            result.add(request);
        }
        return result;
    }
    
    public List<UpdateRequest> findByDeleteFlag(int deleteFlag) {
        return memberUpdateRequestMapper.find(null, deleteFlag);
    }
    
    public List<UpdateRequest> findByIdAndDeleteFlag(int id, int deleteFlag) {
        return memberUpdateRequestMapper.find(id, deleteFlag);
    }
    
    public boolean acceptUpdateRequest(int updateRequestId) {
        UpdateRequest updateRequet = memberUpdateRequestMapper.findByUpdateRequestId(updateRequestId);
        String name = updateRequet.getName();
        String furigana = updateRequet.getFurigana();
        int boardId = updateRequet.getBoardId();
        String discription = updateRequet.getDiscription();
        int memberId = updateRequet.getMemberId();
        memberMapper.update(name, furigana, boardId, discription, memberId);
        return memberUpdateRequestMapper.updateDeleteFlagByUpdateRequestId(Constants.Request.FLAG_PROCESSED, updateRequestId);
    }
    
    public boolean refuseUpdateRequest(int updateRequestId) {
        return memberUpdateRequestMapper.updateDeleteFlagByUpdateRequestId(Constants.Request.FLAG_PROCESSED, updateRequestId);
    }
    
}
