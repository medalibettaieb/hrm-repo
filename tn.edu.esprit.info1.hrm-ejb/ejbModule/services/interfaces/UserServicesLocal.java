package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.User;

@Local
public interface UserServicesLocal {
	Boolean addUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
}
