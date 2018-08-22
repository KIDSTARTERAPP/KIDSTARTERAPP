package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.RoleDao;
import com.javamentor.kidstarter.model.user.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Long,Role> implements RoleDao {

    public Role getByName (String name){
        return entityManager.createQuery("SELECT r from Role r WHERE r.name = :name", Role.class).setParameter("name",name).getSingleResult();
    }

    public List<Role> getRolesByNameList(List<String> names) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.name IN :names", Role.class)
                .setParameter("names", names)
                .getResultList();
    }
}
