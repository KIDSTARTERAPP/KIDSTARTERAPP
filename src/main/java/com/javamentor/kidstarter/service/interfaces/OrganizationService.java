package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrganizationService {

	Organization getOrganizationById(Long id);
	Organization addOrganization(Organization organization);
	List<Organization> getAllOrganization();
	void deleteOrganizationById(Long id);
	void updateOrganization(Organization organization);
	List<User> getAllKidThisOrganization(long id);
	Organization getOrganizationByUserId(Long id);

}
