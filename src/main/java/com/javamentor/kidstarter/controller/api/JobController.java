package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.service.interfaces.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {


	@Autowired
	JobService jobService;

	@GetMapping("/jobPage")
	public String getAllUsers(Model model) {
		model.addAttribute("tags", jobService.getAllJob());
		return "/jobPage";
	}
}
