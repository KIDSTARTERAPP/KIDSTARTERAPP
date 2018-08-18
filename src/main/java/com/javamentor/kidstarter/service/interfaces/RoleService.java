package com.javamentor.kidstarter.service.interfaces;


import javax.management.relation.Role;
import java.util.List;


public interface RoleService {

    Role getRoleById(Long id);
    void addRole(Role role);
    List<Role> getAllRoles();
    void deleteRoleById(Long id);
    void updateRole(Role role);
    Role getByName(String name);
}
