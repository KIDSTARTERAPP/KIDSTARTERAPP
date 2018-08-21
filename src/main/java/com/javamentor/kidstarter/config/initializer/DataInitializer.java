package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.dao.interfaces.AccountDao;
import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.model.user.Account;
import com.javamentor.kidstarter.model.user.Organization;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DataInitializer {

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private JobService jobService;

    @Autowired
    private RoleService roleService;

    @Autowired
	private AccountService accountService;

    @Autowired
    private OrganizationService organizationService;

    public void init(){

        Role role0 = new Role("USER");
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("TEACHER");
        Role role3 = new Role("SPONSOR");
        Role role4 = new Role("OWNER");
        Role role5 = new Role("MENTOR");
        Role role6 = new Role("MODERATOR");
        Role role7 = new Role("KID");

        roleService.addRole(role0);
        roleService.addRole(role1);
        roleService.addRole(role2);
        roleService.addRole(role3);
        roleService.addRole(role4);
        roleService.addRole(role5);
        roleService.addRole(role6);
        roleService.addRole(role7);

        Role roleUser = roleService.getByName("USER");
        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleTeacher = roleService.getByName("TEACHER");
        Role roleSponsor = roleService.getByName("SPONSOR");
        Role roleOwner = roleService.getByName("OWNER");
        Role roleMentor = roleService.getByName("MENTOR");
        Role roleModerator = roleService.getByName("MODERATOR");
        Role roleKid = roleService.getByName("KID");
        List<Role> roles = new ArrayList<>();
        Collections.addAll (roles, roleAdmin,roleTeacher,roleSponsor, roleOwner,
                roleMentor, roleModerator, roleKid, roleUser);

        User user1  = new User("Ivan","Ivanov","Ivanovich","qwer","1234",
                roles, 23, "MALE",23-12-34,"admin@mail.ru","RUSSIA","house 8");

	    User user2  = new User("Vovan","Vovanov","Huevich","1234","qwer",
			    roles,28, "MALE",23-12-34,"user@mail.ru","Ukraine","house 15");

        user1 = userService.addUser(user1);
	    user2 = userService.addUser(user2);

	    Tag tag1 = tagService.addTag(new Tag("Программирование", new HashSet<>()));
	    Tag tag2 = tagService.addTag(new Tag("Фронтенд", new HashSet<>()));
	    Tag tag3 = tagService.addTag(new Tag("Бэкаенд", new HashSet<>()));

	    Account acc1 = new Account();
	    Account acc2 = new Account();
	    Account acc3 = new Account();
	    Account acc4 = new Account();

	    acc1 = accountService.addAccount(acc1);
	    acc2 = accountService.addAccount(acc2);
	    acc3 = accountService.addAccount(acc3);
	    acc4 = accountService.addAccount(acc4);

        Organization org1 = new Organization("Name1","adress1","Мавродия", "mak@l2ff.ru", 8944,LocalDateTime.now(), acc1);
        Organization org2 = new Organization("Name2","adress2","Мавродия", "mak@lf4f.ru", 8944,LocalDateTime.now(), acc2);
        Organization org3 = new Organization("Name3","adress3","Мавродия", "mak@lf5f.ru", 8944,LocalDateTime.now(), acc3);
        Organization org4 = new Organization("Name4","adress4","Мавродия", "mak@lf6f.ru", 8944,LocalDateTime.now(), acc4);

        org1 = organizationService.addOrganization(org1);
        org2 = organizationService.addOrganization(org2);
        org3 = organizationService.addOrganization(org3);
        org4 = organizationService.addOrganization(org4);


//	    Job job1 = jobService.addJob(new Job("Java", "Топовый язык", new HashSet<>(), new HashSet<>(Collections.singletonList(user1))));
//	    Job job2 = jobService.addJob(new Job("JavaScript", "Какашка", new HashSet<>(), new HashSet<>(Collections.singletonList(user2))));
//
//
//        tag1.setJobs(new HashSet<>(Arrays.asList(job1, job2)));
//	    tag2.setJobs(new HashSet<>(Arrays.asList(job2)));
//	    tag3.setJobs(new HashSet<>(Arrays.asList(job1)));
//
//        tagService.updateTag(tag1);
//        tagService.updateTag(tag2);
//        tagService.updateTag(tag3);

    }
}
