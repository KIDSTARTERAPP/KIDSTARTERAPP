package com.javamentor.kidstarter.dao.Impl;

import com.javamentor.kidstarter.dao.interfaces.TagDao;
import com.javamentor.kidstarter.model.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TagDaoImpl extends AbstractDao<Long, Tag> implements TagDao {
}
