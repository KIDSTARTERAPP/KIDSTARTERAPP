package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganiztionController {

	@Autowired
	OrganizationService organizationService;

	@GetMapping("/createOrganization")
	public String getAllOrganization(Model model) {
		model.addAttribute("organizations", organizationService.getAllOrganization());
		return "/createOrganization";
	}
}
