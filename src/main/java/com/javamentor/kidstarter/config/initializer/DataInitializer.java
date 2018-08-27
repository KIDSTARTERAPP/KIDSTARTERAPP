package com.javamentor.kidstarter.config.initializer;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.Request;
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

    @Autowired
    private RequestService requestService;

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
        Collections.addAll(roles, roleAdmin, roleTeacher, roleSponsor, roleOwner,
                roleMentor, roleModerator, roleKid, roleUser);
        List<Role> kidRoles = new ArrayList<>(Arrays.asList(roleUser, roleKid, roleSponsor));
        List<Role> teacherRoles = new ArrayList<>(Arrays.asList(roleUser, roleTeacher, roleSponsor));
        List<Role> mentorRoles = new ArrayList<>(Arrays.asList(roleUser, roleMentor, roleSponsor));
        List<Role> ownerRoles = new ArrayList<>(Arrays.asList(roleUser, roleOwner, roleSponsor));

        User user1  = new User("Ivan","Ivanov","Ivanovich","qwer","1234",
                roles, 23, "MALE","23-12-34","admin@mail.ru","RUSSIA","house 8");

        User user2  = new User("Vovan","Vovanov","Huevich","user2","qwer",
                Collections.singletonList(roleUser),28, "MALE","23-12-34","user@mail.ru","Ukraine","house 15");

        User kidUser1  = new User("Kid","Kid","Kid","kid","qwer",
                kidRoles,28, "MALE","23-12-34","Kid@mail.ru","RUSSIA","house 15");

        User kidUser2  = new User("Kid2","Kid2","Kid2","kid2","qwer2",
                kidRoles,32, "MALE","23-12-34","Kid2@mail.ru","RUSSIA","house 15");


        User teacherUser1  = new User("Teacher","Teacher","Teacher","teacher","qwer",
                teacherRoles,28, "MALE","23-12-34","Teacher@mail.ru","RUSSIA","house 15");

        User teacherUser2  = new User("Teacher2","Teacher2","Teacher","teacher2","qwer",
                teacherRoles,28, "MALE","23-12-34","Teacher@mail.ru","RUSSIA","house 15");

        User mentorUser  = new User("Mentor","Mentor","Mentor","mentor","qwer",
                mentorRoles,28, "MALE","23-12-34","Mentor@mail.ru","RUSSIA","house 15");

        User mentorUser2  = new User("Mentor","Mentor","Mentor","mentor2","qwer",
                mentorRoles,28, "MALE","23-12-34","Mentor@mail.ru","RUSSIA","house 15");

        User ownerUser  = new User("Owner","Owner","Owner","owner","qwer",
                ownerRoles,28, "MALE","23-12-34","Mentor@mail.ru","RUSSIA","house 15");


        user1 = userService.addUser(user1);
        user2 = userService.addUser(user2);
        kidUser1 = userService.addUser(kidUser1);
        kidUser2 = userService.addUser(kidUser2);
        teacherUser1 = userService.addUser(teacherUser1);
        teacherUser2 = userService.addUser(teacherUser2);
        mentorUser = userService.addUser(mentorUser);
        mentorUser2 = userService.addUser(mentorUser2);
        ownerUser = userService.addUser(ownerUser);

        Tag tag1 = tagService.addTag(new Tag("Программирование", new HashSet<>()));
        Tag tag2 = tagService.addTag(new Tag("Фронтенд", new HashSet<>()));
        Tag tag3 = tagService.addTag(new Tag("Бэкаенд", new HashSet<>()));

        Account acc1 = new Account(0L);
        Account acc2 = new Account(0L);
        Account acc3 = new Account(0L);
        Account acc4 = new Account(0L);

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

        Owner owner1 = new Owner(org1, ownerUser);
        Owner owner2 = new Owner(null, user2);

        ownerService.addOwner(owner1);
        ownerService.addOwner(owner2);

        Job job1 = jobService.addJob(new Job("Java", "Топовый язык"));
        Job job2 = jobService.addJob(new Job("JavaScript", "Какашка"));

        Kid kid1 = kidService.addKid(new Kid(kidUser1, new HashSet<>(Collections.singletonList(job1))));
        Kid kid2 = kidService.addKid(new Kid(kidUser2, new HashSet<>(Collections.singletonList(job2))));

        Teacher teacher1 = teacherService.addTeacher(new Teacher(teacherUser1, new HashSet<>(Collections.singletonList(job1))));
        Teacher teacher2 = teacherService.addTeacher(new Teacher(teacherUser2, new HashSet<>(Collections.singletonList(job2))));

        Mentor mentor1 = mentorService.addMentor(new Mentor(mentorUser, new HashSet<>(Collections.singletonList(job1)), 3, "Description", 1, 1));
        Mentor mentor2 = mentorService.addMentor(new Mentor(mentorUser2, new HashSet<>(Collections.singletonList(job2)), 7, "Pergription", 1, 1));

        Request request1 = new Request("Обучение детей детского дома №1 Java", job1, new HashSet<>(Collections.singletonList(kid1)),
                1500L, new HashSet<>(Collections.singletonList(user1)), null, acc1, owner1, Request.RequestStatus.NEW);

        Request request2 = new Request("Обучение детей детского дома №3 JavaScript", job2, new HashSet<>(Collections.singletonList(kid2)),
                400L, new HashSet<>(Collections.singletonList(user2)), mentor2, acc2, owner2, Request.RequestStatus.IN_PROGRESS);

        requestService.addRequest(request1);
        requestService.addRequest(request2);

        createDemoObjects();
    }

    private void createDemoObjects() {

        Role roleUser = roleService.getByName("USER");
        Role roleAdmin = roleService.getByName("ADMIN");
        Role roleTeacher = roleService.getByName("TEACHER");
        Role roleOwner = roleService.getByName("OWNER");
        Role roleMentor = roleService.getByName("MENTOR");
        Role roleKid = roleService.getByName("KID");

        List<Role> adminRoles = new ArrayList<>(Arrays.asList(roleUser, roleAdmin));
        List<Role> kidRoles = new ArrayList<>(Arrays.asList(roleUser, roleKid));
        List<Role> teacherRoles = new ArrayList<>(Arrays.asList(roleUser, roleTeacher));
        List<Role> mentorRoles = new ArrayList<>(Arrays.asList(roleUser, roleMentor));
        List<Role> ownerRoles = new ArrayList<>(Arrays.asList(roleUser, roleOwner));

        User demoAdminUser  = new User("demoAdminUser","demoAdminUser","demoAdminUser","adm1","1234",
                adminRoles, 23, "MALE","23-12-34","Admin@mail.ru","RUSSIA","house 8");
        User demoOwnerUser  = new User("demoOwnerUser","demoOwnerUser","demoOwnerUser","owner1","1234",
                ownerRoles, 23, "MALE","23-12-34","Owner@mail.ru","RUSSIA","house 8");
        User demoMentorUser  = new User("demoMentorUser","demoMentorUser","demoMentorUser","mentor1","1234",
                mentorRoles, 23, "MALE","23-12-34","Owner@mail.ru","RUSSIA","house 8");

        User demoKidUser1  = new User("","demoKidUser1","","kid11","1234",
                kidRoles,28, "MALE","23-12-34","Kid@mail.ru","RUSSIA","house 15");
        User demoKidUser2  = new User("","demoKidUser2","","kid21","1234",
                kidRoles,32, "MALE","23-12-34","Kid2@mail.ru","RUSSIA","house 15");


        User demoTeacherUser1  = new User("","demoTeacherUser1","","teacher11","1234",
                teacherRoles,28, "MALE","23-12-34","Teacher@mail.ru","RUSSIA","house 15");
        User demoTeacherUser2  = new User("","demoTeacherUser2","","teacher21","1234",
                teacherRoles,28, "MALE","23-12-34","Teacher@mail.ru","RUSSIA","house 15");

        demoAdminUser = userService.addUser(demoAdminUser);
        demoOwnerUser = userService.addUser(demoOwnerUser);
        demoMentorUser = userService.addUser(demoMentorUser);

        demoKidUser1 = userService.addUser(demoKidUser1);
        demoKidUser2 = userService.addUser(demoKidUser2);

        demoTeacherUser1 = userService.addUser(demoTeacherUser1);
        demoTeacherUser2 = userService.addUser(demoTeacherUser2);

        Account demoOrgAccount = accountService.addAccount(new Account());
        Organization demoOrg = new Organization("demoOrg","adress1","Россия", "demoOrg@l2ff.ru", 8944,LocalDateTime.now(), demoOrgAccount);
        demoOrg = organizationService.addOrganization(demoOrg);
        Owner demoOwner = ownerService.addOwner(new Owner(demoOrg, demoOwnerUser));

        Job demoJob1 = jobService.addJob(new Job("Java(DEMO)", "Бэкенд язык программирования "));
        Job demoJob2 = jobService.addJob(new Job("JavaScript(DEMO)", "Фронтенд язык программирования JavaScript"));
        Job demoJob3 = jobService.addJob(new Job("Рисование(DEMO)", "Рисование"));

        Kid demoKid1 = kidService.addKid(new Kid(demoKidUser1, new HashSet<>(Collections.singletonList(demoJob1))));
        Kid demoKid2 = kidService.addKid(new Kid(demoKidUser2, new HashSet<>(Collections.singletonList(demoJob3))));

        Teacher teacher1 = teacherService.addTeacher(new Teacher(demoTeacherUser1, new HashSet<>(Collections.singletonList(demoJob1))));
        Teacher teacher2 = teacherService.addTeacher(new Teacher(demoTeacherUser2, new HashSet<>(Collections.singletonList(demoJob2))));

        demoOrg.setKids(new HashSet<>(Arrays.asList(demoKid1, demoKid2)));
//        demoOrg.setTeachers(new HashSet<>(Arrays.asList(teacher1, teacher2)));
        organizationService.updateOrganization(demoOrg);

        Mentor demoMentor = mentorService.addMentor(new Mentor(demoMentorUser, new HashSet<>(Collections.singletonList(demoJob1)), 3, "Description", 1, 1));

        Account newRequestAccount = accountService.addAccount(new Account(500L));
        Account activeRequestAccount = accountService.addAccount(new Account( 400L));
        Account progressRequestAccount = accountService.addAccount(new Account( 500L));

        Request demoNewRequest = new Request("Новая заявка на обучение", demoJob1, new HashSet<>(Collections.singletonList(demoKid1)),
                1000L, new HashSet<>(), null, newRequestAccount, demoOwner, Request.RequestStatus.NEW);

        Request demoActiveRequest = new Request("Готовая к одобрению заявка на обучение", demoJob2, new HashSet<>(Collections.singletonList(demoKid2)),
                2000L, new HashSet<>(), demoMentor, activeRequestAccount, demoOwner, Request.RequestStatus.READY);

        Request demoProgressRequest = new Request("Текущая заявка на обучение", demoJob3, new HashSet<>(Collections.singletonList(demoKid1)),
                3000L, new HashSet<>(), demoMentor, progressRequestAccount, demoOwner, Request.RequestStatus.IN_PROGRESS);

        demoNewRequest = requestService.addRequest(demoNewRequest);
        demoActiveRequest = requestService.addRequest(demoActiveRequest);
        demoProgressRequest = requestService.addRequest(demoProgressRequest);
    }
}

