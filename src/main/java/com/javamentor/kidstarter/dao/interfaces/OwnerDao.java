package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.user.Owner;

public interface OwnerDao extends GenericDao<Long, Owner> {

	Owner getUserOwner(Long id);
}
