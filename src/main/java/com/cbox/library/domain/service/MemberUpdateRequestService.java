package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.mapper.MemberUpdateRequestMapper;
import com.cbox.library.domain.model.UpdateRequest;
import com.cbox.library.domain.repository.MemberUpdateRequestRepository;

@Service
public class MemberUpdateRequestService {
    @Autowired
    MemberUpdateRequestRepository memberUpdateRequestRepository;
    
    @Autowired
    MemberUpdateRequestMapper memberUpdateRequestMapper;
    
    public int create(MemberUpdateRequestForm form, String userAgent, String ipAdress) {
        int memberId = form.getMemberId();
        String name = form.getName();
        String furigana = form.getFurigana();
        int boardId = form.getBoardId();
        String discription = form.getDiscription();
        return memberUpdateRequestRepository.create(memberId, name, furigana, boardId, discription, userAgent, ipAdress);
    }
    
    public UpdateRequest findById(int updateRequestId) {
        return memberUpdateRequestMapper.findByid(updateRequestId);
    }
    
    public List<UpdateRequest> findAllByDeleteFlag(int deleteFlag) {
        List<Map<String, Object>> tmpList = memberUpdateRequestRepository.findAllByDeleteFlag(deleteFlag);
        List<UpdateRequest> result = new ArrayList<>();
        for (Map<String, Object> map : tmpList) {
            UpdateRequest request = new UpdateRequest();
            request.setId((Integer) map.get("id"));
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
}
