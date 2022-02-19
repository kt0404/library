package com.cbox.library.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbox.library.domain.model.UpdateRequest;
import com.cbox.library.domain.service.MemberService;
import com.cbox.library.domain.service.MemberUpdateRequestService;

@Controller
public class ProcessMemberUpdateRequestController {
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberUpdateRequestService memberUpdateRequestService;
    
    @GetMapping("/update/request/process/{updateRequestId}")
    public String index(@PathVariable int updateRequestId, Model model) {
        UpdateRequest updateRequest = memberUpdateRequestService.findById(updateRequestId);
        model.addAttribute("updateRequest", updateRequest);
        return "update_request_datail";
    }
    
    @PostMapping("/update/request/process/{updateRequestId}")
    public String acceptUpdateRequest(@PathVariable int updateRequestId) {
        UpdateRequest updateRequest = memberUpdateRequestService.findById(updateRequestId);
        memberService.updateNameAndFuriganaAndBoardIdAndDiscriptionById(
                updateRequest.getName(),
                updateRequest.getFurigana(),
                updateRequest.getBoardId(),
                updateRequest.getDiscription(),
                updateRequest.getMemberId());
        
        return null;
    }
}
