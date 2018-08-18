package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.RoleDao;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getByKey(id);
    }

    @Override
    public void addRole(Role role) {
        roleDao.persist(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAll();
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteByKey(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.update(role);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }
}
