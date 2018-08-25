package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.RequestDao;
import com.javamentor.kidstarter.model.Request;
import com.javamentor.kidstarter.service.interfaces.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {


	private RequestDao requestDao;

	@Autowired
	public RequestServiceImpl(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	@Override
	public Request getRequestById(Long id) {
		return requestDao.getByKey(id);
	}

	@Override
	public Request addRequest(Request request) {
		return requestDao.persist(request);
	}

	@Override
	public List<Request> getAllRequest() {
		return requestDao.getAll();
	}

	@Override
	public void deleteRequestById(Long id) {
		requestDao.deleteByKey(id);
	}

	@Override
	public void updateRequest(Request request) {
		requestDao.update(request);
	}
}
