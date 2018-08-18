package com.javamentor.kidstarter.service.service_abstract;

import com.javamentor.kidstarter.model.Tag;

import java.util.List;

public interface TagService {

	Tag getTagId(Long id);
	void addTag(Tag tag);
	List<Tag> getAllTag();
	void deleteTagById(Long id);
	void updateTag(Tag tag);
}
