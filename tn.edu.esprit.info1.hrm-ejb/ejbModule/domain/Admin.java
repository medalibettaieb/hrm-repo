package domain;

import domain.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends User implements Serializable {

	
	private String privilege;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}   
	
	public Admin(String name, String login, String password,String privilege) {
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
		this.privilege = privilege;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
   
}
