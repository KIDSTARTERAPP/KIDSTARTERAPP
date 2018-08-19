package com.javamentor.kidstarter.dao.Impl;



import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class AbstractDao<PK, T> {

	@PersistenceContext
	 EntityManager entityManager;

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return entityManager.find(persistentClass, key);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public List<T> getAll() {
		String genericClassName = persistentClass.toGenericString();
		genericClassName = genericClassName.substring(genericClassName.lastIndexOf('.') + 1);
		String hql = "FROM " + genericClassName;
		return entityManager.createQuery(hql).getResultList();
	}

	public void persist(T entity) {

		entityManager.persist(entity);
	}

	public void deleteByKey(PK pk) {
		T entity =  entityManager.find(persistentClass, pk);
		entityManager.remove(entity);
	}


	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}
}