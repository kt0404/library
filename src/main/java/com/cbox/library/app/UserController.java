package com.cbox.library.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbox.library.domain.form.RegisterForm;
import com.cbox.library.domain.model.Board;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.service.BoardService;
import com.cbox.library.domain.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @GetMapping("/show")
    public String show(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        List<Board> boardList = boardService.getAll();
        model.addAttribute("boardList", boardList);
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Validated RegisterForm form, BindingResult result, Model model) {
        if (result.hasErrors())
            return "register";
        userService.create(form);
        model.addAttribute("registerForm", new RegisterForm());
        List<Board> boardList = boardService.getAll();
        model.addAttribute("boardList", boardList);
        return "redirect:/show";
    }
}
