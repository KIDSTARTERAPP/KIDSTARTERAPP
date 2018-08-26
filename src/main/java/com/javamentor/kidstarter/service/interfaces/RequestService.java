package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.Request;

import java.util.List;

public interface RequestService {

	Request getRequestById(Long id);
	Request addRequest(Request owner);
	List<Request> getAllRequest();
	void deleteRequestById(Long id);
	void updateRequest(Request request);
}
