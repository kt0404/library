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

import com.cbox.library.domain.form.UserUpdateRequestForm;
import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.service.BoardService;
import com.cbox.library.domain.service.RequestService;
import com.cbox.library.domain.service.UserService;
import com.cbox.library.domain.service.UserUpdateRequestService;

@Controller
public class UseUpdateRequestController {
    @Autowired
    UserService userService;
    
    @Autowired
    BoardService boardService;
    
    @Autowired
    RequestService requestService;
    
    @Autowired
    UserUpdateRequestService userUpdateRequestService;
    
    @GetMapping("/update/{id}")
    public String userUpdateRequest(@PathVariable int id, Model model) {
        User user = userService.findOne(id);
        List<Board> boardList = boardService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("boardList", boardList);
        model.addAttribute("userUpdateRequestForm", new UserUpdateRequestForm());
        return "update";
    }
    
    @PostMapping("/update")
    public String userUpdateRequestExecute(@Validated UserUpdateRequestForm form, BindingResult result,
            @RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest request) {
        String ipAddress = requestService.getClientIp(request);
        userUpdateRequestService.create(form, userAgent, ipAddress);
        return "redirect:/show";
    }
}
