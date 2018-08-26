package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.model.user.*;
import com.javamentor.kidstarter.service.interfaces.*;
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

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private KidService kidService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MentorService mentorService;

    public void init() {
        roleService.addRole(new Role("USER"));
        roleService.addRole(new Role("ADMIN"));
        roleService.addRole(new Role("TEACHER"));
//        roleService.addRole(new Role("SPONSOR"));
        roleService.addRole(new Role("OWNER"));
        roleService.addRole(new Role("MENTOR"));
//        roleService.addRole(new Role("MODERATOR"));
        roleService.addRole(new Role("KID"));

        Role roleUser = roleService.getByName("USER");
        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleTeacher = roleService.getByName("TEACHER");
//        Role roleSponsor = roleService.getByName("SPONSOR");
        Role roleOwner = roleService.getByName("OWNER");
        Role roleMentor = roleService.getByName("MENTOR");
//        Role roleModerator = roleService.getByName("MODERATOR");
        Role roleKid = roleService.getByName("KID");

        List<Role> adminRole = new ArrayList<>(Arrays.asList(roleAdmin));
        //Collections.addAll(roles, roleAdmin, roleSponsor, roleModerator, roleUser, roleOwner);
        List<Role> kidRoles = new ArrayList<>(Arrays.asList(roleKid));
        List<Role> teacherRoles = new ArrayList<>(Arrays.asList(roleTeacher));
        List<Role> mentorRoles = new ArrayList<>(Arrays.asList(roleUser, roleMentor));
        List<Role> userRoles = new ArrayList<>(Arrays.asList(roleUser));
        List<Role> ownerRoles = new ArrayList<>(Arrays.asList(roleOwner));
//        List<Role> moderatorRoles = new ArrayList<>(Arrays.asList(roleModerator));

        User adminUser = new User("Ivan", "Ivanov", "Ivanovich", "ADMIN", "123",
                adminRole, 23, "MALE", "23 - 12 - 34", "admin@mail.ru", "RUSSIA", "house 8");

        User mentorUser = new User("Vovan", "Vovanov", "Huevich", "mentor", "123",
                mentorRoles, 28, "MALE", "23 - 12 - 34", "user@mail.ru", "Ukraine", "house 15");

        User kidUser = new User("Kid", "Kid", "Kid", "kid", "123",
                kidRoles, 28, "MALE", "23 - 12 - 34", "Kid@mail.ru", "RUSSIA", "house 15");

        User teacherUser = new User("Teacher", "Teacher", "Teacher", "teacher", "123",
                teacherRoles, 28, "MALE", "23 - 12 - 34", "Teacher@mail.ru", "RUSSIA", "house 15");

        User userUser = new User("Mentor", "Mentor", "Mentor", "user", "123",
                userRoles, 28, "MALE", "23 - 12 - 34", "Mentor@mail.ru", "RUSSIA", "house 15");

        User ownerUser = new User("Mentor", "Mentor", "Mentor", "owner", "123",
                ownerRoles, 28, "MALE", "23 - 12 - 34", "Mentor@mail.ru", "RUSSIA", "house 15");

//        User moderatorUser = new User("Mentor", "Mentor", "Mentor", "moderator", "123",
//                moderatorRoles, 28, "MALE", 23 - 12 - 34, "Mentor@mail.ru", "RUSSIA", "house 15");


        adminUser = userService.addUser(adminUser);
        mentorUser = userService.addUser(mentorUser);
        kidUser = userService.addUser(kidUser);
        teacherUser = userService.addUser(teacherUser);
        userUser = userService.addUser(userUser);
        ownerUser = userService.addUser(ownerUser);
//        moderatorUser = userService.addUser(moderatorUser);

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

        Organization org1 = new Organization("Name1", "adress1", "Мавродия", "mak@l2ff.ru", 8944, LocalDateTime.now(), acc1);
        Organization org2 = new Organization("Name2", "adress2", "Мавродия", "mak@lf4f.ru", 8944, LocalDateTime.now(), acc2);
        Organization org3 = new Organization("Name3", "adress3", "Мавродия", "mak@lf5f.ru", 8944, LocalDateTime.now(), acc3);
        Organization org4 = new Organization("Name4", "adress4", "Мавродия", "mak@lf6f.ru", 8944, LocalDateTime.now(), acc4);

        org1 = organizationService.addOrganization(org1);
        org2 = organizationService.addOrganization(org2);
        org3 = organizationService.addOrganization(org3);
        org4 = organizationService.addOrganization(org4);

        Owner owner1 = new Owner(null, adminUser);
        Owner owner2 = new Owner(null, userUser);

        ownerService.addOwner(owner1);
        ownerService.addOwner(owner2);


        Job job1 = jobService.addJob(new Job("Java", "Топовый язык"));
        Job job2 = jobService.addJob(new Job("JavaScript", "ugly toad"));

        Kid kid1 = kidService.addKid(new Kid(kidUser, new HashSet<>(Collections.singletonList(job1))));

        Teacher teacher1 = teacherService.addTeacher(new Teacher(teacherUser, new HashSet<>(Collections.singletonList(job1))));

        Mentor mentor1 = mentorService.addMentor(new Mentor(userUser, new HashSet<>(Collections.singletonList(job2)), 3, "Description"));

    }

}
