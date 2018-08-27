package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.User;

import java.util.List;

public interface OrganiztionDao extends GenericDao<Long,Organization> {
    List<Kid> getAllKidThisOrganization(long id);

    Organization getOrganizationByUserId(Long id);
}
