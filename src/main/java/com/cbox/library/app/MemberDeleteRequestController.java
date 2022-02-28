package com.cbox.library.app;

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

import com.cbox.library.domain.form.MemberDeleteRequestForm;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.service.RequestService;
import com.cbox.library.domain.service.MemberDeleteRequestService;
import com.cbox.library.domain.service.MemberService;

@Controller
public class MemberDeleteRequestController {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberDeleteRequestService memberDeleteRequestService;
    
    @Autowired
    RequestService requestService;
    
    @GetMapping("/delete/{memberId}")
    public String deleteRequestForm(@PathVariable int memberId, Model model) {
        Member member = memberService.findByMemberId(memberId);
        model.addAttribute("member", member);
        model.addAttribute("memberDeleteRequestForm", new MemberDeleteRequestForm());
        return "delete";
    }
    
    @PostMapping("/delete")
    public String deleteRequestExecute(@Validated MemberDeleteRequestForm form, BindingResult result,
            @RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest request) {
        if(result.hasErrors()) return "redirect:/delete/" + form.getMemberId();
        String ipAddress = requestService.getClientIp(request);
        memberDeleteRequestService.create(form, userAgent, ipAddress);
        return "redirect:/show";
    }
    
}
