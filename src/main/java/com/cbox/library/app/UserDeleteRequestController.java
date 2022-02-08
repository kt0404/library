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

import com.cbox.library.domain.form.RegisterForm;
import com.cbox.library.domain.form.UserDeleteRequestForm;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.service.RequestService;
import com.cbox.library.domain.service.UserDeleteRequestService;
import com.cbox.library.domain.service.UserService;

@Controller
public class UserDeleteRequestController {
    @Autowired
    UserService userService;
    
    @Autowired
    UserDeleteRequestService userDeleteRequestService;
    
    @Autowired
    RequestService requestService;
    
    @GetMapping("/delete/{id}")
    public String deleteRequestCreate(@PathVariable int id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("userDeleteRequestForm", new UserDeleteRequestForm());
        return "delete";
    }
    
    @PostMapping("/delete")
    public String deleteRequestExecute(@Validated UserDeleteRequestForm form, BindingResult result,
            @RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest request) {
        if(result.hasErrors()) return "redirect:/delete/" + form.getUserId();
        String ipAddress = requestService.getClientIp(request);
        userDeleteRequestService.create(form, userAgent, ipAddress);
        return "redirect:/show";
    }
}
