package com.javamentor.kidstarter.dao.interfaces;


import javax.management.relation.Role;

public interface RoleDao extends GenericDao<Long,Role> {

    Role getByName(String name);
}
