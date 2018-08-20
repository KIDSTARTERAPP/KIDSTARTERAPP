package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.service.Impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {

	@Autowired
	private TagServiceImpl tagService;

	public TagController(TagServiceImpl tagService) {
		this.tagService = tagService;
	}


	@GetMapping("/tagPage")
	public String getAllUsers(Model model) {
		model.addAttribute("tags", tagService.getAllTag());
		return "/tagPage";
	}
}
