package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.OwnerDao;
import com.javamentor.kidstarter.model.user.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OwnerDaoImpl extends AbstractDao<Long, Owner> implements OwnerDao {

    public Owner getUserOwner(Long id) {
        Owner owner;
        try {
            owner = (Owner) entityManager.createQuery("SELECT o from Owner o WHERE o.user.id = :id", Owner.class).setParameter("id", id);
        } catch (Exception e) {
            return null;
        }
        return owner;
    }
}
