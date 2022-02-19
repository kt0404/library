package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.mapper.MemberUpdateRequestMapper;

@Service
@Transactional
public class ProcessMemberUpdateRequestService {
    @Autowired
    MemberMapper memberMapper;
    
    @Autowired
    MemberUpdateRequestMapper memberUpdateRequestMapper;
}
