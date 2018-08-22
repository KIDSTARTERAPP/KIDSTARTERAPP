package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.Tag;
import java.util.List;

public interface TagService {

	Tag getTagId(Long id);
	Tag addTag(Tag tag);
	List<Tag> getAllTag();
	void deleteTagById(Long id);
	void updateTag(Tag tag);
	List<Tag> getTagsByNameList(List<String> names);
}
