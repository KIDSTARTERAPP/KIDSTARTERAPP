package com.javamentor.kidstarter.service.Impl;

import com.javamentor.kidstarter.dao.interfaces.TagDao;
import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.service.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {


	private TagDao tagDao;

	@Autowired
	public TagServiceImpl(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public Tag getTagId(Long id) {
		return tagDao.getByKey(id);
	}

	public Tag addTag(Tag tag) {
		tagDao.persist(tag);
		return tag;
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

	public List<Tag> getTagsByNameList(List<String> names) {
		return tagDao.getTagsByNameList(names);
	}
}
