package ru.javamentor.dao_impl;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.dao_abstract.UserDao;
import ru.javamentor.models.User;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	public User getUserByUsername(String username) {
		User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.login =:username").setParameter("username", username).getSingleResult();
		return user;
	}
}
