package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.TagDao;
import com.javamentor.kidstarter.model.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TagDaoImpl extends AbstractDao<Long, Tag> implements TagDao {

    @Override
    public List<Tag> getTagsByNameList(List<String> tags) {
        return entityManager.createQuery("SELECT t FROM Tag t WHERE t.name IN :names", Tag.class)
                .setParameter("names", tags)
                .getResultList();
    }
}
