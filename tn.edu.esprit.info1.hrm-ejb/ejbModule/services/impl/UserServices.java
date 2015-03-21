package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import domain.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
			System.out.println("insertion errors ...");
		}
		return b;
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u")
				.getResultList();
	}

	@Override
	public Boolean deleteUser(User user) {
		Boolean b = false;
		try {
			entityManager.remove(user);
			b = true;
		} catch (Exception e) {
			System.out.println("remove errors ...");
		}
		return b;
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		String jpql = "select u from User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user=(User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found");
		}
		
		return user;
	}

}
