package domain;

import domain.User;
import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee extends User implements Serializable {

	
	private Float balance;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
   
}
