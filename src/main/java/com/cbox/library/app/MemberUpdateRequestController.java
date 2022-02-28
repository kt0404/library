package com.cbox.library.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.service.BoardService;
import com.cbox.library.domain.service.RequestService;
import com.cbox.library.domain.service.MemberService;
import com.cbox.library.domain.service.MemberUpdateRequestService;

@Controller
public class MemberUpdateRequestController {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    BoardService boardService;
    
    @Autowired
    RequestService requestService;
    
    @Autowired
    MemberUpdateRequestService memberUpdateRequestService;
    
    @GetMapping("/update/{memberId}")
    public String memberUpdateRequestForm(@PathVariable int memberId, Model model) {
        Member member = memberService.findByMemberId(memberId);
        List<Board> boardList = boardService.getAll();
        model.addAttribute("member", member);
        model.addAttribute("boardList", boardList);
        model.addAttribute("memberUpdateRequestForm", new MemberUpdateRequestForm());
        return "update";
    }
    
    @PostMapping("/update")
    public String memberUpdateRequestExecute(@Validated MemberUpdateRequestForm form, BindingResult result,
            @RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest request) {
        String ipAddress = requestService.getClientIp(request);
        memberUpdateRequestService.create(form, userAgent, ipAddress);
        return "redirect:/show";
    }
    
}
