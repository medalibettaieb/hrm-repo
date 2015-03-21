package services.interfaces;

import javax.ejb.Remote;

import domain.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user);

	User findUserById(Integer id);

}
