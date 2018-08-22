package com.javamentor.kidstarter.service.interfaces;



import com.javamentor.kidstarter.model.user.Role;

import java.util.List;


public interface RoleService {

    Role getRoleById(Long id);
    Role addRole(Role role);
    List<Role> getAllRoles();
    void deleteRoleById(Long id);
    void updateRole(Role role);
    Role getByName(String name);
    List<Role> getRolesByNameList(List<String> names);
}
