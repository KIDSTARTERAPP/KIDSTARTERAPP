package com.javamentor.kidstarter.dao.interfaces;


import com.javamentor.kidstarter.model.user.Role;

public interface RoleDao extends GenericDao<Long,Role> {

    Role getByName(String name);
}
