package com.javamentor.kidstarter.dao.interfaces;


import com.javamentor.kidstarter.model.user.Role;

import java.util.List;

public interface RoleDao extends GenericDao<Long,Role> {

    Role getByName(String name);
    List<Role> getRolesByNameList(List<String> names);
}
