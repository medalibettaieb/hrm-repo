package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import services.interfaces.LeaveManagementLocal;
import domain.Leave;

@ManagedBean
@RequestScoped
public class LeaveBean {
	private Leave leave = new Leave();

	@ManagedProperty(value = "#{beanOne}")
	private UserBean userBean;
	@EJB
	private LeaveManagementLocal leaveManagementLocal;

	public String doAddLeave() {
		leave.setUser(userBean.getEmployee());
		leaveManagementLocal.addLeave(leave);
		return "";
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
