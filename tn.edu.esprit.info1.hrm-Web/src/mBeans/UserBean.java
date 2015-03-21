package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import domain.Employee;

@ManagedBean
@SessionScoped
public class UserBean {
	// model
	private Employee employee = new Employee();
	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	public String doAddEmployee() {
		userServicesLocal.addUser(employee);
		return "";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
