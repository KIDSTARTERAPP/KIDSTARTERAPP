package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.user.Kid;

public interface KidDao extends GenericDao<Long, Kid> {

    Kid getUserKidbyId(Long id);
}
