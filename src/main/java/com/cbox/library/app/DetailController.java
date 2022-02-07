package com.cbox.library.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cbox.library.domain.model.Comment;
import com.cbox.library.domain.model.User;
import com.cbox.library.domain.service.CommentService;
import com.cbox.library.domain.service.UserService;

@Controller
public class DetailController {

	@Autowired
	UserService userService;

	@Autowired
	CommentService commentService;

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		User user = userService.findOne(id);
		if (user == null)
			return "redirect:/show";
		List<Comment> commentList = commentService.getComments(id);
		model.addAttribute("user", user);
		model.addAttribute("commentList", commentList);
		return "detail";
	}
}
