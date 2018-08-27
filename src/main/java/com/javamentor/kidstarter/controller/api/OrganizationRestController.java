package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.user.*;
import com.javamentor.kidstarter.service.Impl.UserServiceImpl;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import com.javamentor.kidstarter.service.interfaces.OwnerService;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class OrganizationRestController {

	static final Logger logger = LoggerFactory.getLogger(OrganizationRestController.class);


	private OrganizationService organizationService;

	private OwnerService ownerService;

	private final UserService userService;

	private final RoleService roleService;

	@Autowired
	public OrganizationRestController(OrganizationService organizationService, OwnerService ownerService, UserService userService, RoleService roleService) {
		this.organizationService = organizationService;
		this.ownerService = ownerService;
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping ("/organization//kids")
	public ResponseEntity<Set<Kid>> getKidsByOrganizationId() {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return new ResponseEntity<>(organizationService.getOrganizationByUserId(user.getId()).getKids(),HttpStatus.OK);
	}

	@GetMapping ("/organization/{id}/teachers")
	public ResponseEntity<Set<Teacher>> getTeachersByOrganizationId(@PathVariable("id") long id) {
		return new ResponseEntity<>(HttpStatus.OK);
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
			User user = userService.getUserById(principal.getId());
			currentOwner.setUser(user);
			ownerService.updateOwner(currentOwner);
			Role role = roleService.getByName("OWNER");
			user.getRoles().add(role);
			List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<>((Collection<? extends SimpleGrantedAuthority>) user.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(
							user,
							SecurityContextHolder.getContext().getAuthentication().getCredentials(),
							updatedAuthorities));

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

	@PutMapping("/organization/kids")
	public ResponseEntity<List<Kid>> getAllOrganizationKids() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Kid> kids = organizationService.getAllKidThisOrganization(organizationService.getOrganizationByUserId(user.getId()).getId());
		return new ResponseEntity<>(kids, HttpStatus.OK);
	}

	@PostMapping("/organization/add_map")
	public ResponseEntity<Organization> addMapThisOrganization(@RequestParam(value="myArray[]") Double[] myArray) {
	    Organization organization = organizationService.getOrganizationById(2L);
		organization.setPointX(myArray[0]);
		organization.setPointY(myArray[1]);
		organizationService.updateOrganization(organization);
		return new ResponseEntity<>(organization, HttpStatus.OK);
	}

}
