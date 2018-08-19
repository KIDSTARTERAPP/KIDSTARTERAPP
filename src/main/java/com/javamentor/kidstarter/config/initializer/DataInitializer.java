package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.TagService;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;

public class DataInitializer {

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private JobService jobService;

    @Autowired
    private RoleService roleService;

    public void init(){

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("TEACHER");
        Role role3 = new Role("SPONSOR");
        Role role4 = new Role("OWNER");
        Role role5 = new Role("MENTOR");
        Role role6 = new Role("MODERATOR");
        Role role7 = new Role("KID");

        roleService.addRole(role1);
        roleService.addRole(role2);
        roleService.addRole(role3);
        roleService.addRole(role4);
        roleService.addRole(role5);
        roleService.addRole(role6);
        roleService.addRole(role7);

        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleTeacher = roleService.getByName("TEACHER");
        Role roleSponsor = roleService.getByName("SPONSOR");
        Role roleOwner = roleService.getByName("OWNER");
        Role roleMentor = roleService.getByName("MENTOR");
        Role roleModerator = roleService.getByName("MODERATOR");
        Role roleKid = roleService.getByName("KID");
        List<Role> roles = new ArrayList<>();
        Collections.addAll (roles, roleAdmin,roleTeacher,roleSponsor, roleOwner, roleMentor, roleModerator, roleKid);

        User user1  = new User("Ivan","Ivanov","Ivanovich","qwer","1234",
                roles,
                LocalDateTime.now(), 23, "MALE",23-12-34,
                "admin@mail.ru","RUSSIA","house 8");


	    User user2  = new User("Vovan","Vovanov","Huevich","qwer22","12345",
			    roles,
			    LocalDateTime.now(), 28, "MALE",23-12-34,
			    "admin@mail.ru","Moscow","house 8");

        User user3 = userService.addUser(user1);
	    User user4 = userService.addUser(user2);

	    Tag tag1 = tagService.addTag(new Tag("Программирование", new HashSet<>()));
	    Tag tag2 = tagService.addTag(new Tag("Фронтенд", new HashSet<>()));
	    Tag tag3 = tagService.addTag(new Tag("Бэкаенд", new HashSet<>()));

	    Job job1 = jobService.addJob(new Job("Java", "Топовый язык", new HashSet<>(), new HashSet<>()));
	    Job job2 = jobService.addJob(new Job("JavaScript", "Какашка", new HashSet<>(), new HashSet<>()));

	    tag1.setJob(new HashSet<>(Arrays.asList(job1, job2)));
	    tag2.setJob(new HashSet<>(Arrays.asList(job2)));
	    tag3.setJob(new HashSet<>(Arrays.asList(job1)));

	    tagService.updateTag(tag1);
	    tagService.updateTag(tag2);
	    tagService.updateTag(tag3);

	    job1.setTag(new HashSet<>(Arrays.asList(tag1, tag3)));
	    job2.setTag(new HashSet<>(Arrays.asList(tag1, tag2)));

//	    job1.setWiller(new HashSet<>(Arrays.asList(user3, user4)));
//	    job2.setWiller(new HashSet<>(Arrays.asList(user3, user4)));

	    System.out.println(job1);
	    System.out.println(job2);
//	    jobService.updateJob(job1);
//	    jobService.updateJob(job2);
    }
}
