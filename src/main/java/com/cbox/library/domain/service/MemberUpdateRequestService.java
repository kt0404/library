package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.repository.MemberUpdateRequestRepository;

@Service
public class MemberUpdateRequestService {
    @Autowired
    MemberUpdateRequestRepository memberUpdateRequestRepository;
    
    public int create(MemberUpdateRequestForm form, String userAgent, String ipAdress) {
        int memberId = form.getMemberId();
        String name = form.getName();
        String furigana = form.getFurigana();
        int boardId = form.getBoardId();
        String discription = form.getDiscription();
        return memberUpdateRequestRepository.create(memberId, name, furigana, boardId, discription, userAgent, ipAdress);
    }
}
