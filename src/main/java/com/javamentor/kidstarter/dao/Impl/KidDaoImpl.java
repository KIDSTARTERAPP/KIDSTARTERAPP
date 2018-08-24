package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.KidDao;
import com.javamentor.kidstarter.model.user.Kid;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class KidDaoImpl extends AbstractDao<Long, Kid> implements KidDao {

    @Override
    public Kid getUserKidbyId(Long id) {
        return entityManager.createQuery("SELECT k from Kid k WHERE k.user.id = :id", Kid.class).setParameter("id",id).getSingleResult();
    }
}
