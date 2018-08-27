package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.Request;
import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.MentorService;
import com.javamentor.kidstarter.model.user.Account;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.AccountService;
import com.javamentor.kidstarter.service.interfaces.OwnerService;
import com.javamentor.kidstarter.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestRequestController {

	@Autowired
	private RequestService requestService;

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private MentorService mentorService;

	@GetMapping("/request/{id}")
	public ResponseEntity<?> getRequestId(@PathVariable("id") long id) {
		Request request = requestService.getRequestById(id);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@GetMapping("/requests")
	public ResponseEntity<List<Request>> listAllRequest() {
		List<Request> requests = requestService.getAllRequest();
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}

	@DeleteMapping("/request/{id}")
	public HttpStatus deleteKidByRequest(@PathVariable("id") long id) {
		requestService.deleteRequestById(id);
		return HttpStatus.OK;
	}

	@PostMapping("/request")
	public ResponseEntity<?> addRequest(@RequestBody Request request) {
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setCreator(ownerService.getUserOwner(principal.getId()));
		request.setPrice(request.getPrice() * 100L);
		Account account = accountService.addAccount(new Account());
		request.setAccount(account);
		requestService.addRequest(request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@PutMapping("/request")
	public ResponseEntity<?>  updateRequest(@RequestBody Request request) {
		requestService.updateRequest(request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@PostMapping("/request/{id}/mentor")
	public ResponseEntity<?>  addMentorToRequest(@PathVariable("id") long id) {
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Request request = requestService.getRequestById(id);
		request.setMentor(mentorService.getUserMentorById(principal.getId()));
		request.setStatus(Request.RequestStatus.READY);
		requestService.updateRequest(request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}
}
