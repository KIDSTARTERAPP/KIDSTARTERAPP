package com.javamentor.kidstarter.dao_abstract;

import java.util.List;

public interface GenericDao<PK, T> {

	void persist(T entity);

	T getByKey(PK id);

	List<T> getAll();

	void update(T group);

	void deleteByKey(PK id);
}
