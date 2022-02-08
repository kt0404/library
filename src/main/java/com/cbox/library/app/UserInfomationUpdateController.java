package com.cbox.library.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbox.library.domain.form.UserUpdateForm;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.service.UserService;

@Controller
public class UserInfomationUpdateController {
    @Autowired
    UserService userService;
    
    @GetMapping("/update/{id}")
    public String userInfomationUpdate(@PathVariable int id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("userUpdateForm", new UserUpdateForm());
        return "update";
    }
    
    @PostMapping("/update")
    public String userInfomationUpdateExecute(@Validated UserUpdateForm form) {
        userService.updateDiscription(form);
        return "redirect:/show";
    }
}
