package com.cbox.library.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cbox.library.domain.model.Comment;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.service.CommentService;
import com.cbox.library.domain.service.MemberService;

@Controller
public class DetailController {

    @Autowired
    MemberService memberService;

    @Autowired
    CommentService commentService;

    @GetMapping("/detail/{memberId}")
    public String detailForm(@PathVariable int memberId, Model model) {
        Member member = memberService.findByMemberId(memberId);
        if (member == null)
            return "redirect:/show";
        List<Comment> commentList = commentService.getComments(memberId);
        model.addAttribute("member", member);
        model.addAttribute("commentList", commentList);
        return "detail";
    }
    
}
