package com.cbox.library.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cbox.library.domain.form.CommentForm;
import com.cbox.library.domain.service.CommentService;
import com.cbox.library.domain.service.RequestService;

@Controller
public class CommentsController {
//conto
    @Autowired
    CommentService commentService;

    @Autowired
    RequestService requestService;

    @PostMapping("/comment")
    public String comment(@Validated CommentForm form, BindingResult result,
            @RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest request) {
        if (result.hasErrors())
            return "redirect:/detail/" + form.getMemberId();
        String ipAddress = requestService.getClientIp(request);
        commentService.create(form, userAgent, ipAddress);
        return "redirect:/detail/" + form.getMemberId();
    }
}
