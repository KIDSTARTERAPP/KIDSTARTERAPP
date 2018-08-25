package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.User;

import java.util.List;

public interface OrganiztionDao extends GenericDao<Long,Organization> {
    List<User> getAllKidThisOrganization();
}
