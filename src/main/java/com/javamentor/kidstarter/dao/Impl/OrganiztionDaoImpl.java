package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.OrganiztionDao;
import com.javamentor.kidstarter.model.user.Organization;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OrganiztionDaoImpl extends AbstractDao<Long,Organization> implements OrganiztionDao {

	public Organization getByName (String name){
		return entityManager.createQuery("SELECT org from  Organization org WHERE org.name = :name", Organization.class).setParameter("name",name).getResultList().stream().findAny().orElse(null);
	}
}
