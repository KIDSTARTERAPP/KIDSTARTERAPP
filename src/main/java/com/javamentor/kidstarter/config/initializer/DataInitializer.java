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

    public void init() {

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

        User user1 = new User("Иван", "Иванов", "Владимирович", "ivan", "ivan1",
                roles, 23, "MALE", "23-12-34", "ivanov-ivan@mail.ru", "Россия", "Выборг улица Мира 10");

        User user2 = new User("Сергей", "Сидоров", "Валерьевич", "sergey", "sergey1",
                Collections.singletonList(roleUser), 28, "MALE", "23-12-34", "sidorov-sergey@mail.ru", "Россия", "Выборг улица Некрасова, 22");

        User kidUser1 = new User("Федор", "Абрамов", "Сергеевич", "fabramov", "fabramov1",
                kidRoles, 20, "MALE", "23-12-34", "fedor-abramov@mail.ru", "RUSSIA", "Санкт-Петербург Большая Разночинная улица 9А");

        User kidUser2 = new User("Алиса", "Фокина", "Петровна", "falisa", "falisa1",
                kidRoles, 22, "FIMALE", "23-12-34", "falisa@mail.ru", "RUSSIA", "Санкт-Петербург Гороховая улица 20");


        User teacherUser1 = new User("Геннадий", "Фокин", "Ривальдович", "fgennadiy", "fgennadiy1",
                teacherRoles, 39, "MALE", "23-12-34", "Teacher@mail.ru", "RUSSIA", "Санкт-Петербург улица Труда 8");

        User teacherUser2 = new User("Тамара", "Лев", "Борисовна", "lev-tamara", "lev-tamara1",
                teacherRoles, 35, "FIMALE", "23-12-34", "lev-tamara@mail.ru", "RUSSIA", "Санкт-Петербург Съезжинская улица, 19");


        User mentorUser = new User("Алексей", "Петров", "Николаевич", "p-alex", "p-alex1",
                mentorRoles, 27, "MALE", "23-12-34", "alex-petrov@mail.ru", "RUSSIA", "Санкт-Петербург Ждановская улица 25");

        User mentorUser2 = new User("Денис", "Кабанов", "Николаевич", "denis-kabanov", "denis1",
                mentorRoles, 29, "MALE", "23-12-34", "denis-kabanov@mail.ru", "RUSSIA", "Санкт-Петербург Диагональная улица 10");


        User ownerUser = new User("Руслан", "Прокофьев", "Арнольдович", "rusarn", "rusarn1",
                ownerRoles, 28, "MALE", "23-12-34", "rusarn@mail.ru", "RUSSIA", "Санкт-Петербург Гражданский проспект 9к7");


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

        Organization org1 = new Organization("ГБОУ школа-интернат № 576", "Санкт-Петербург пер. Каховского, 2Б", "Россия", "internat576@yandex.ru", 3507882, LocalDateTime.now(), acc1);
        Organization org2 = new Organization("ГБОУ Школа-интернат № 357", "Санкт-Петербург ул Аккуратова 7А", "Россия", "school-357@mail.ru", 3453367, LocalDateTime.now(), acc2);
        Organization org3 = new Organization("ГБОУ школа-интернат № 33", "Санкт-Петербург 2-й Муринский просп 24", "Россия", "033@shko.la", 2412543, LocalDateTime.now(), acc3);
        Organization org4 = new Organization("ГБОУ школа-интернат № 6", "Санкт-Петербург Большая Пороховская ул 52", "Россия", "int6@mail.ru", 2271930, LocalDateTime.now(), acc4);

        org1 = organizationService.addOrganization(org1);
        org2 = organizationService.addOrganization(org2);
        org3 = organizationService.addOrganization(org3);
        org4 = organizationService.addOrganization(org4);

        Owner owner1 = new Owner(org1, ownerUser);
        Owner owner2 = new Owner(null, user2);

        ownerService.addOwner(owner1);
        ownerService.addOwner(owner2);

        Job job1 = jobService.addJob(new Job("Java", "Back end"));
        Job job2 = jobService.addJob(new Job("JavaScript", "Front end"));

        Kid kid1 = kidService.addKid(new Kid(kidUser1, new HashSet<>(Collections.singletonList(job1))));
        Kid kid2 = kidService.addKid(new Kid(kidUser2, new HashSet<>(Collections.singletonList(job2))));

        Teacher teacher1 = teacherService.addTeacher(new Teacher(teacherUser1, new HashSet<>(Collections.singletonList(job1))));
        Teacher teacher2 = teacherService.addTeacher(new Teacher(teacherUser2, new HashSet<>(Collections.singletonList(job2))));

        Mentor mentor1 = mentorService.addMentor(new Mentor(mentorUser, new HashSet<>(Collections.singletonList(job1)), 3, "Description", 1, 1));
        Mentor mentor2 = mentorService.addMentor(new Mentor(mentorUser2, new HashSet<>(Collections.singletonList(job2)), 7, "Pergription", 1, 1));

        Request request1 = new Request("Обучение детей Школа-интернат № 357 Java", job1, new HashSet<>(Collections.singletonList(kid1)),
                1500L, new HashSet<>(Collections.singletonList(user1)), null, acc1, owner1, Request.RequestStatus.NEW);

        Request request2 = new Request("Обучение детей школа-интернат № 6 JavaScript", job2, new HashSet<>(Collections.singletonList(kid2)),
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

        User demoAdminUser = new User("Вадим", "Денисов", "Николаевич", "admin", "1234",
                adminRoles, 24, "MALE", "423-88-44", "dvadik@mail.ru", "RUSSIA", "Санкт-Петербург Ленина улица 1");
        User demoOwnerUser = new User("Володя", "Никитин", "Николаевич", "owner", "1234",
                ownerRoles, 22, "MALE", "345-35-74", "nvovka@mail.ru", "RUSSIA", "house 8");
        User demoMentorUser = new User("Николай", "Иванов", "Николаевич", "mentor", "1234",
                mentorRoles, 26, "MALE", "754-12-65", "nikivonov@mail.ru", "RUSSIA", "Санкт-Петербург Пражская улица 11");

        User demoKidUser1 = new User("Петр", "Архипов", "Васильевич", "kid", "1234",
                kidRoles, 14, "MALE", "586-28-34", "a-petryha@mail.ru", "RUSSIA", "Санкт-Петербур Гороховая улица 30");
        User demoKidUser2 = new User("Вася", "Левакин", "Сергеевич", "vasya-sergeevich", "vasya-sergeevich1",
                kidRoles, 16, "MALE", "526-58-34", "vasya-sergeevich@mail.ru", "RUSSIA", "Санкт-Петербур Казанская улица 44");

        User demoTeacherUser1 = new User("Роман", "Гафонов", "Николаевич", "teacher", "1234",
                teacherRoles, 36, "MALE", "647-17-84", "pom1k@mail.ru", "RUSSIA", "Санкт-Петербур Вознесенский проспект 38");
        User demoTeacherUser2 = new User("Никита", "Васткин", "Львович", "nikitos", "nikitos1",
                teacherRoles, 39, "MALE", "563-62-32", "nikitos@mail.ru", "RUSSIA", "Санкт-Петербур Измайловский проспект 1");

        demoAdminUser = userService.addUser(demoAdminUser);
        demoOwnerUser = userService.addUser(demoOwnerUser);
        demoMentorUser = userService.addUser(demoMentorUser);

        demoKidUser1 = userService.addUser(demoKidUser1);
        demoKidUser2 = userService.addUser(demoKidUser2);

        demoTeacherUser1 = userService.addUser(demoTeacherUser1);
        demoTeacherUser2 = userService.addUser(demoTeacherUser2);

        Account demoOrgAccount = accountService.addAccount(new Account());
        Organization demoOrg = new Organization("demoOrg", "adress1", "Россия", "demoOrg@l2ff.ru", 8944, LocalDateTime.now(), demoOrgAccount);
        demoOrg = organizationService.addOrganization(demoOrg);
        Owner demoOwner = ownerService.addOwner(new Owner(demoOrg, demoOwnerUser));

        Job demoJob1 = jobService.addJob(new Job("Рисование", "Рисование масляными красками"));
        Job demoJob2 = jobService.addJob(new Job("Танцы", "Занятия с хареографом в зале"));
        Job demoJob3 = jobService.addJob(new Job("Английский язык", "Разговорная практика и грамматика"));

        Kid demoKid1 = kidService.addKid(new Kid(demoKidUser1, new HashSet<>(Collections.singletonList(demoJob1))));
        Kid demoKid2 = kidService.addKid(new Kid(demoKidUser2, new HashSet<>(Collections.singletonList(demoJob3))));

        Teacher teacher1 = teacherService.addTeacher(new Teacher(demoTeacherUser1, new HashSet<>(Collections.singletonList(demoJob1))));
        Teacher teacher2 = teacherService.addTeacher(new Teacher(demoTeacherUser2, new HashSet<>(Collections.singletonList(demoJob2))));

        demoOrg.setKids(new HashSet<>(Arrays.asList(demoKid1, demoKid2)));
//        demoOrg.setTeachers(new HashSet<>(Arrays.asList(teacher1, teacher2)));
        organizationService.updateOrganization(demoOrg);

        Mentor demoMentor = mentorService.addMentor(new Mentor(demoMentorUser, new HashSet<>(Collections.singletonList(demoJob1)), 3, "Description", 1, 1));

        Account newRequestAccount = accountService.addAccount(new Account(500L));
        Account activeRequestAccount = accountService.addAccount(new Account(400L));
        Account progressRequestAccount = accountService.addAccount(new Account(500L));

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

