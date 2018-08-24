package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.KidDao;
import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.service.interfaces.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KidServiceImpl implements KidService {

    private KidDao kidDao;

    @Autowired
    public KidServiceImpl(KidDao kidDao) {
        this.kidDao = kidDao;
    }

    public Kid getKidById(Long id) {
        return kidDao.getByKey(id);
    }

    public Kid addKid(Kid job) {
        kidDao.persist(job);
        return job;
    }

    public List<Kid> getAllKids() {
        return kidDao.getAll();
    }

    public void deleteKidById(Long id) {
        kidDao.deleteByKey(id);
    }

    public void updateKid(Kid job) {
        kidDao.update(job);
    }

    @Override
    public Kid getUserKidById(Long id) {
        return kidDao.getUserKidbyId(id);
    }
}
