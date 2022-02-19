package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbox.library.domain.common.Constants;
import com.cbox.library.domain.mapper.MemberDeleteRequestMapper;
import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.mapper.MemberUpdateRequestMapper;

@Service
@Transactional
public class ProcessMemberDeleteRequestService {
    @Autowired
    MemberMapper memberMapper;
    
    @Autowired
    MemberDeleteRequestMapper memberDeleteRequestMapper;
    
    @Autowired
    MemberUpdateRequestMapper memberUpdateRequestMapper;
    
    public boolean execute(int memberId, int deleteRequestId) {
        memberDeleteRequestMapper.updateDeleteFlagById(deleteRequestId, Constants.Request.FLAG_PROCESSED);
        memberUpdateRequestMapper.updateDeleteFlagByMemberId(memberId, Constants.Request.FLAG_PROCESSED);
        return memberMapper.deleteById(memberId);
    }
    
    public void refuseMemberDeleteRequest(int requestId) {
        memberDeleteRequestMapper.updateDeleteFlagById(requestId, Constants.Request.FLAG_PROCESSED);
    }
}
