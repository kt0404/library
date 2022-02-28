package com.cbox.library.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.model.UpdateRequest;
import com.cbox.library.domain.service.BoardService;
import com.cbox.library.domain.service.MemberService;
import com.cbox.library.domain.service.MemberUpdateRequestService;

@Controller
public class ProcessMemberUpdateRequestController {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberUpdateRequestService memberUpdateRequestService;
    
    @Autowired
    BoardService boardService;
    
    @GetMapping("/process/update/request/{updateRequestId}")
    public String processMemberUpdateRequestForm(@PathVariable int updateRequestId, Model model) {
        UpdateRequest updateRequest = memberUpdateRequestService.findById(updateRequestId);
        Member member = memberService.findById(updateRequest.getMemberId());
        Board beforeBoard = boardService.findById(member.getBoardId());
        Board afterBoard = boardService.findById(updateRequest.getBoardId());
        model.addAttribute("updateRequest", updateRequest);
        model.addAttribute("member", member);
        model.addAttribute("beforeBoard", beforeBoard);
        model.addAttribute("afterBoard", afterBoard);
        return "update_request_detail";
    }
    
    @PostMapping("/accept/update/request/{updateRequestId}")
    public String acceptUpdateRequest(@PathVariable int updateRequestId) {
        memberUpdateRequestService.acceptUpdateRequest(updateRequestId);
        return "redirect:/show";
    }
    
    @PostMapping("/refuse/update/request/{updateRequestId}")
    public String refuseUpdateRequest(@PathVariable int updateRequestId) {
        memberUpdateRequestService.refuseUpdateRequest(updateRequestId);
        return "redirect:/show";
    }
    
}
