package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.OrganiztionDao;
import com.javamentor.kidstarter.dao.interfaces.RoleDao;
import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.service.interfaces.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServeImpl implements OrganizationService {

	private final OrganiztionDao organiztionDao;

	@Autowired
	public OrganizationServeImpl(OrganiztionDao organiztionDao) {
		this.organiztionDao = organiztionDao;
	}

	@Override
	public Organization getOrganizationById(Long id) {
		return organiztionDao.getByKey(id);
	}

	@Override
	public Organization addOrganization(Organization organization) {
		organiztionDao.persist(organization);
		return organization;
	}

	@Override
	public List<Organization> getAllOrganization() {
		return organiztionDao.getAll();
	}

	@Override
	public void deleteOrganizationById(Long id) {
		organiztionDao.deleteByKey(id);
	}

	@Override
	public void updateOrganization(Organization organization) {
		organiztionDao.update(organization);
	}
}
