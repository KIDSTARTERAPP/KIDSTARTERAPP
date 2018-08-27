package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.model.Request;
import com.javamentor.kidstarter.model.user.Account;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.AccountService;
import com.javamentor.kidstarter.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class DonateController {

	private final RequestService requestService;
	private final AccountService accountService;


	@Autowired
	public DonateController(RequestService requestService, AccountService accountService) {
		this.requestService = requestService;
		this.accountService = accountService;
	}

	@RequestMapping(value = "/donate/{requestId}", method = RequestMethod.GET)
	public String donate(Model model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String requestId = request.getRequestURI().substring(8);
		Request requestJob = requestService.getRequestById(Long.parseLong(requestId));
		model.addAttribute("user", user);
		model.addAttribute("request", requestJob);
		return "donate-page";
	}

	@RequestMapping(value = "/donate", method = RequestMethod.POST)
	public ResponseEntity donateAccept(@RequestParam(value = "amount") String amount,
	                                   @RequestParam(value = "operation_id") String operationId,
	                                   @RequestParam(value = "sha1_hash") String sha,
	                                   @RequestParam(value = "sender") String sender,
	                                   @RequestParam(value = "notification_type") String notification_type,
	                                   @RequestParam(value = "datetime") String datetime,
	                                   @RequestParam(value = "label") String label) {

		Request program = requestService.getRequestById(Long.parseLong(label));
		Account programAccount = program.getAccount();
		amount = amount.replace(".", "");
		Long newCurrentAmount = programAccount.getCurrentAmount() + Long.parseLong(amount);
		programAccount.setCurrentAmount(newCurrentAmount);
		if (programAccount.getCurrentAmount() >= program.getPrice()) {
			program.setStatus(Request.RequestStatus.PAID);
			requestService.updateRequest(program);
		}
		accountService.updateAccount(programAccount);
		return new ResponseEntity(HttpStatus.OK);
	}

	/*
	протестировать sha1
	 */
	static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
