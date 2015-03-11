package domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Employee
 * 
 */
@Entity
public class Employee extends User implements Serializable {

	private Float balance = 0.0F;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}

	public Employee(String name, String login, String password) {
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
	}

	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
