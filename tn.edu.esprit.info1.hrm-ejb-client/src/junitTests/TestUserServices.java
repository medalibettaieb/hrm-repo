package junitTests;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.interfaces.UserServicesRemote;
import domain.Employee;

public class TestUserServices {
	private Context context;
	private UserServicesRemote userServicesRemote;

	@Before
	public void setUp() throws Exception {
		context = new InitialContext();
		userServicesRemote = (UserServicesRemote) context
				.lookup("ejb:/tn.edu.esprit.info1.hrm-ejb/UserServices!"
						+ UserServicesRemote.class.getCanonicalName());
	}

	@Test
	public void testAddUser() {
		Employee employee = new Employee("foulen", "foulen", "foulen");
		Employee employee2 = new Employee("foulena", "foulena", "foulena");

		Assert.assertTrue(userServicesRemote.addUser(employee));
		Assert.assertTrue(userServicesRemote.addUser(employee2));
	}

}
