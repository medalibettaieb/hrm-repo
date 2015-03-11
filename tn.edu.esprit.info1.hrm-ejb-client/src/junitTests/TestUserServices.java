package junitTests;

import locator.ServicesLocator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.interfaces.UserServicesRemote;
import domain.Employee;

public class TestUserServices {
	private UserServicesRemote userServicesRemote;

	@Before
	public void setUp() {
		String jndiName = "ejb:/tn.edu.esprit.info1.hrm-ejb/UserServices!"
				+ UserServicesRemote.class.getCanonicalName();
		userServicesRemote = (UserServicesRemote) ServicesLocator.getInstance()
				.getProxy(jndiName);
	}

	@Test
	public void testAddUser() {
		Employee employee = new Employee("foulen", "foulen", "foulen");
		Employee employee2 = new Employee("foulena", "foulena", "foulena");

		Assert.assertTrue(userServicesRemote.addUser(employee));
		Assert.assertTrue(userServicesRemote.addUser(employee2));
	}

}
