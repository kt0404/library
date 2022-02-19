package com.cbox.library.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbox.library.domain.form.MemberDeleteRequestForm;
import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.model.DeleteRequest;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.service.BoardService;
import com.cbox.library.domain.service.MemberDeleteRequestService;
import com.cbox.library.domain.service.MemberService;
import com.cbox.library.domain.service.ProcessMemberDeleteRequestService;

@Controller
public class ProcessMemberDeleteRequestController {
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberDeleteRequestService memberDeleteRequestService;
    
    @Autowired
    ProcessMemberDeleteRequestService processMemberDeleteRequestService;
    
    @Autowired
    BoardService boardService;
    
    @GetMapping("/delete/request/process/{deleteRequestId}")
    public String index(@PathVariable int deleteRequestId, Model model) {
        DeleteRequest deleteRequest = memberDeleteRequestService.findById(deleteRequestId);
        Member member = memberService.findById(deleteRequest.getMemberId());
        Board board = boardService.findById(member.getBoardId());
        model.addAttribute("deleteRequest", deleteRequest);
        model.addAttribute("member", member);
        model.addAttribute("board", board);
        model.addAttribute("memberDeleteRequestForm", new MemberDeleteRequestForm());
        return "delete_request_detail";
    }
    
    @PostMapping("/delete/request/accept")
    public String acceptDeleteRequest(@Validated MemberDeleteRequestForm form) {
        processMemberDeleteRequestService.execute(form.getMemberId(), form.getId());
        return "redirect:/show";
    }
    
    @PostMapping("/delete/request/refuse")
    public String refuseDeleteRequest(@Validated MemberDeleteRequestForm form) {
        processMemberDeleteRequestService.refuseMemberDeleteRequest(form.getId());
        return "redirect:/show";
    }
}