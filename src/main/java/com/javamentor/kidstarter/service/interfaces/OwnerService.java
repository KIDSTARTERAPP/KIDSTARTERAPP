package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Owner;
import com.javamentor.kidstarter.model.user.User;

import java.util.List;

public interface OwnerService {

	Owner getOwnerById(Long id);
	Owner addOwner(Owner owner);
	List<Owner> getAllOwner();
	void deleteOwnerById(Long id);
	void updateOwner(Owner owner);
	Owner getUserOwner(Long id);
}
