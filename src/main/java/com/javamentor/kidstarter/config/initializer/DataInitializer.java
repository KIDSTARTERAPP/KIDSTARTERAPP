//package com.javamentor.kidstarter.config.initializer;
//
//import com.javamentor.kidstarter.model.Job;
//import com.javamentor.kidstarter.model.Tag;
//import com.javamentor.kidstarter.model.user.*;
//import com.javamentor.kidstarter.service.interfaces.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class DataInitializer {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private TagService tagService;
//    @Autowired
//    private JobService jobService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private OrganizationService organizationService;
//    @Autowired
//    private OwnerService ownerService;
//    @Autowired
//    private KidService kidService;
//    @Autowired
//    private TeacherService teacherService;
//    @Autowired
//    private MentorService mentorService;
//    @Autowired
//    private RequestService requestService;
//
//    public void init() {
//        addRoleInService();
//        addTagInService();
//
//        Role roleUser = roleService.getByName("USER");
//        Role roleAdmin = roleService.getByName("ADMIN");
//        Role roleTeacher = roleService.getByName("TEACHER");
//        Role roleMentor = roleService.getByName("MENTOR");
//        Role roleKid = roleService.getByName("KID");
//        Role roleOwner = roleService.getByName("OWNER");
//
//        List<Role> adminRole = new ArrayList<>(Arrays.asList(roleUser, roleAdmin));
//        List<Role> kidRoles = new ArrayList<>(Arrays.asList(roleUser, roleKid));
//        List<Role> teacherRoles = new ArrayList<>(Arrays.asList(roleUser, roleTeacher));
//        List<Role> mentorRoles = new ArrayList<>(Arrays.asList(roleUser, roleMentor));
//        List<Role> ownerRoles = new ArrayList<>(Arrays.asList(roleUser, roleOwner));
//
//        User adminUser = new User("Ivan", "Ivanov", "Ivanovich", "123", "123", adminRole, 23, "MALE", "23-12-34", "admin@mail.ru", "RUSSIA", "house 8");
//        User userUser2 = new User("Mentor", "Mentor", "Mentor", "owner", "123", ownerRoles, 28, "MALE", "23-12-34", "Mentor2@mail.ru", "RUSSIA", "house 15");
//        User kidUser = new User("Kid", "Kid", "Kid", "kid", "123", kidRoles, 28, "MALE", "23-12-34", "Kid@mail.ru", "RUSSIA", "house 15");
//        User mentorUser = new User("Vovan", "Vovanov", "Huevich", "mentor", "123", mentorRoles, 28, "MALE", "23-12-34", "user@mail.ru", "Ukraine", "house 15");
//        User teacherUser = new User("Teacher", "Teacher", "Teacher", "teacher", "123", teacherRoles, 28, "MALE", "23-12-34", "Teacher@mail.ru", "RUSSIA", "house 15");
//
//        adminUser = userService.addUser(adminUser);
//        mentorUser = userService.addUser(mentorUser);
//        kidUser = userService.addUser(kidUser);
//        teacherUser = userService.addUser(teacherUser);
//        userUser2 = userService.addUser(userUser2);
//
//        Account acc1 = accountService.addAccount(new Account());
//        Account acc2 = accountService.addAccount(new Account());
//
//        Organization org1 = new Organization("Name1", "adress1", "Мавродия", "mak@l2ff.ru", 8944, LocalDateTime.now(), acc1);
//        Organization org2 = new Organization("Name2", "adress2", "Мавродия", "mak@lf4f.ru", 8944, LocalDateTime.now(), acc2);
//
//        org1 = organizationService.addOrganization(org1);
//        org2 = organizationService.addOrganization(org2);
//
//        Owner owner1 = new Owner(org1, adminUser);
//        Owner owner2 = new Owner(org2, userUser2);
//
//        ownerService.addOwner(owner1);
//        ownerService.addOwner(owner2);
//
//        Job job1 = jobService.addJob(new Job("Java", "Топовый язык"));
//        Job job2 = jobService.addJob(new Job("JavaScript", "ugly toad"));
//
//        Kid kid1 = kidService.addKid(new Kid(kidUser, org1, new HashSet<>(Collections.singletonList(job1))));
//        Kid kid2 = kidService.addKid(new Kid(kidUser, org2, new HashSet<>(Collections.singletonList(job2))));
//
//        Teacher teacher1 = teacherService.addTeacher(new Teacher(teacherUser, new HashSet<>(Collections.singletonList(job1))));
//        Teacher teacher2 = teacherService.addTeacher(new Teacher(teacherUser, new HashSet<>(Collections.singletonList(job2))));
//
//        Mentor mentor11 = new Mentor(mentorUser, new HashSet<>(Collections.singletonList(job1)), 3, "Description", 55.76, 37.64);
//        Mentor mentor22 = new Mentor(mentorUser, new HashSet<>(Collections.singletonList(job2)), 7, "Pergription", 55.76, 37.64);
//
//        Mentor mentor1 = mentorService.addMentor(mentor11);
//        Mentor mentor2 = mentorService.addMentor(mentor22);
//
////        Request request1 = new Request("Заявка на обучеие", job1, new HashSet<>(Collections.singletonList(kid1)), new HashSet<>(Collections.singletonList(teacher1)), 1500L, new HashSet<>(Collections.singletonList(userUser)), mentor1, acc1, owner1);
////        Request request2 = new Request("Заявка на обучеие2", job2, new HashSet<>(Collections.singletonList(kid2)), new HashSet<>(Collections.singletonList(teacher2)), 1501L, new HashSet<>(Collections.singletonList(userUser2)), mentor2, acc2, owner2);
////
////        requestService.addRequest(request1);
////        requestService.addRequest(request2);
//
//        kid1.setOrganization(org1);
//        kidService.updateKid(kid1);
//        kid2.setOrganization(org2);
//        kidService.updateKid(kid2);
//
//    }
//
//    private void addTagInService() {
//        Tag tag1 = tagService.addTag(new Tag("Программирование", new HashSet<>()));
//        Tag tag2 = tagService.addTag(new Tag("Фронтенд", new HashSet<>()));
//        Tag tag3 = tagService.addTag(new Tag("Бэкаенд", new HashSet<>()));
//    }
//
//    private void addRoleInService() {
//        roleService.addRole(new Role("USER"));
//        roleService.addRole(new Role("ADMIN"));
//        roleService.addRole(new Role("TEACHER"));
////        roleService.addRole(new Role("SPONSOR"));
//        roleService.addRole(new Role("OWNER"));
//        roleService.addRole(new Role("MENTOR"));
////        roleService.addRole(new Role("MODERATOR"));
//        roleService.addRole(new Role("KID"));
//    }
//}
