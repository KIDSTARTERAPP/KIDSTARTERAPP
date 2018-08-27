package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.OrganiztionDao;
import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class OrganiztionDaoImpl extends AbstractDao<Long,Organization> implements OrganiztionDao {

	public Organization getByName (String name){
		return entityManager.createQuery("SELECT org from  Organization org WHERE org.name = :name", Organization.class).setParameter("name",name).getResultList().stream().findAny().orElse(null);
	}

	@Override
	public List<Kid> getAllKidThisOrganization(long id) {
		return entityManager.createQuery("SELECT k FROM Kid k WHERE k.organization.id = :id", Kid.class).setParameter("id", id).getResultList();
	}

	@Override
	public Organization getOrganizationByUserId(Long id) {
		return entityManager.createQuery("SELECT o.organization FROM Owner o WHERE o.user.id = :id",Organization.class).setParameter("id", id).getSingleResult();
	}
}
