package com.javamentor.kidstarter.service.Impl;


import com.javamentor.kidstarter.dao.interfaces.*;
import com.javamentor.kidstarter.model.user.Role;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.security.config.PassEncode;
import com.javamentor.kidstarter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    private final PassEncode passwordEncoder;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private KidDao kidDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private MentorDao mentorDao;

    @Autowired
    private OwnerDao ownerDao;

    @Autowired
    public UserServiceImpl(UserDao userDAO, PassEncode passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getByKey(id);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
        userDAO.persist(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAll();
    }

    @Override
    public void deleteUserById(Long id) {
        List<Role> roles = userDAO.getByKey(id).getRoles();
        if (roles.contains(roleDao.getByName("KID"))) {
            kidDao.deleteByKey(kidDao.getUserKidbyId(id).getId());
        }
        if (roles.contains(roleDao.getByName("TEACHER"))) {
            teacherDao.deleteByKey(teacherDao.getUserTeacherById(id).getId());
        }
        if (roles.contains(roleDao.getByName("MENTOR"))) {
            mentorDao.deleteByKey(mentorDao.getUserMentorById(id).getId());
        }
        if (roles.contains(roleDao.getByName("OWNER"))) {
            ownerDao.deleteByKey(ownerDao.getUserOwner(id).getId());
        }
        userDAO.deleteByKey(id);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
        userDAO.update(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public void deleteKidByUserId(long id) {
        userDAO.deleteKidByUserId(id);
    }
}
