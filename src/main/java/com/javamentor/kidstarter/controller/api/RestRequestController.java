package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.Request;
import com.javamentor.kidstarter.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestRequestController {

	@Autowired
	private RequestService requestService;

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
		requestService.addRequest(request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}

	@PutMapping("/request")
	public ResponseEntity<?>  updateRequest(@ModelAttribute("kid") Request request) {
		requestService.updateRequest(request);
		return new ResponseEntity<>(request, HttpStatus.OK);
	}
}
