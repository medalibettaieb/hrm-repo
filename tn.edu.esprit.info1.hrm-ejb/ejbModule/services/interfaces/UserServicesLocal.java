package services.interfaces;

import javax.ejb.Local;

import domain.User;

@Local
public interface UserServicesLocal {
	Boolean addUser(User user);

	User findUserById(Integer id);
}
