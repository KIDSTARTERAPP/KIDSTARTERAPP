package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.Owner;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationRestController {

	static final Logger logger = LoggerFactory.getLogger(OrganizationRestController.class);


	private OrganizationService organizationService;

	private OwnerService ownerService;

	@Autowired
	public OrganizationRestController(OrganizationService organizationService, OwnerService ownerService) {
		this.organizationService = organizationService;
		this.ownerService = ownerService;
	}

	@GetMapping("/organization/{id}")
	public ResponseEntity<?> getOrganizationId(@PathVariable("id") long id) {
		Organization organization = organizationService.getOrganizationById(id);
		return new ResponseEntity<>(organization, HttpStatus.OK);
	}

	@GetMapping("/organizations")
	public ResponseEntity<List<Organization>> listAllUser() {
		List<Organization>tag = organizationService.getAllOrganization();
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@DeleteMapping("/organization/{id}")
	public ResponseEntity<?> deleteOrganization(@PathVariable("id") long id) {
		organizationService.deleteOrganizationById(id);
		return new ResponseEntity<Organization>(HttpStatus.OK);
	}

	@PostMapping("/organization")
	public ResponseEntity<?> addOrganization(@RequestBody Organization currentOrganization) {
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Owner currentOwner = ownerService.getUserOwner(principal.getId());
		if (currentOwner == null) {
			currentOwner = ownerService.addOwner(new Owner());
			currentOwner.setUser(principal);
			ownerService.updateOwner(currentOwner);
		}
		currentOrganization.setCreateDate(LocalDateTime.now());
		Organization organization = organizationService.addOrganization(currentOrganization);
		currentOwner.setOrganization(organization);
		ownerService.updateOwner(currentOwner);
		return new ResponseEntity<>(organization, HttpStatus.OK);
	}

	@PutMapping("/organization")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization newOrganization) {
		organizationService.updateOrganization(newOrganization);
		return new ResponseEntity<>(newOrganization, HttpStatus.OK);
	}
}
