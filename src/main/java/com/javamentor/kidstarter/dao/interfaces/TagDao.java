package com.javamentor.kidstarter.dao.interfaces;

import com.javamentor.kidstarter.model.Tag;
import java.util.List;

public interface TagDao extends GenericDao<Long, Tag> {

    List<Tag> getTagsByNameList(List<String> tags);
}
