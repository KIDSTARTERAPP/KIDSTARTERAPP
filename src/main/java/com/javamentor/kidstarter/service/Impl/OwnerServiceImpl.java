package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.OwnerDao;
import com.javamentor.kidstarter.model.user.Owner;
import com.javamentor.kidstarter.service.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

	private OwnerDao ownerDao;

	@Autowired
	public OwnerServiceImpl(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}

	@Override
	public Owner getOwnerById(Long id) {
		return ownerDao.getByKey(id);
	}

	@Override
	public Owner addOwner(Owner owner) {
		ownerDao.persist(owner);
		return owner;
	}

	@Override
	public List<Owner> getAllOwner() {
		return ownerDao.getAll();
	}

	@Override
	public void deleteOwnerById(Long id) {
		ownerDao.deleteByKey(id);

	}

	@Override
	public void updateOwner(Owner owner) {
		ownerDao.update(owner);
	}

	@Override
	public Owner getUserOwner(Long id) {
		return ownerDao.getUserOwner(id);
	}
}
