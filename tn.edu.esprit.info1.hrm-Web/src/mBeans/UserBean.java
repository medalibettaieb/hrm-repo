package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import domain.Employee;
import domain.User;

@ManagedBean
@SessionScoped
public class UserBean {
	// model
	private Employee employee = new Employee();
	private List<User> users = new ArrayList<>();
	private User userLoggedIn = new User();
	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	public String doAddEmployee() {
		userServicesLocal.addUser(employee);
		return "";
	}

	public String doLogin() {
		userLoggedIn = userServicesLocal.login(userLoggedIn.getLogin(),
				userLoggedIn.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Employee) {
				return "/pages/welcomeEmployee?faces-redirect=true";
			} else {
				return "/pages/listUsers?faces-redirect=true";
			}
		} else {
			return "/error";
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<User> getUsers() {
		users = userServicesLocal.findAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(User userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

}
