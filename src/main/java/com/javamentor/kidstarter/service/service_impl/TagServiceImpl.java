package com.javamentor.kidstarter.service.service_impl;

import com.javamentor.kidstarter.dao_abstract.TagDao;
import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.service.service_abstract.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	public Tag getTagId(Long id) {
		return tagDao.getByKey(id);
	}

	public void addTag(Tag tag) {
		tagDao.persist(tag);
	}

	public List<Tag> getAllTag() {
		return tagDao.getAll();
	}

	public void deleteTagById(Long id) {
		tagDao.deleteByKey(id);
	}

	public void updateTag(Tag tag) {
		tagDao.update(tag);
	}
}
