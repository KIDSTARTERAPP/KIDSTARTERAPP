package com.javamentor.kidstarter.dao_impl;

import com.javamentor.kidstarter.dao_abstract.TagDao;
import com.javamentor.kidstarter.model.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TagDaoImpl extends AbstractDao<Long, Tag> implements TagDao {
}
