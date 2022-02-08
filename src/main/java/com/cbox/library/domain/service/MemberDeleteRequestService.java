package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.MemberDeleteRequestForm;
import com.cbox.library.domain.repository.MemberDeleteRequestRepository;

@Service
public class MemberDeleteRequestService {
    @Autowired
    MemberDeleteRequestRepository memberDeleteRequestRepository;
    
    public int create(MemberDeleteRequestForm form, String userAgent, String ipAddress) {
        int memberId = form.getMemberId();
        String deleteReason = form.getDeleteReason();
        return memberDeleteRequestRepository.create(memberId, deleteReason, userAgent, ipAddress);
    }
}
