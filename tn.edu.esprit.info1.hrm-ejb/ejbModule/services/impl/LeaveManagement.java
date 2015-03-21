package services.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.LeaveManagementLocal;
import services.interfaces.LeaveManagementRemote;
import services.interfaces.UserServicesLocal;
import domain.Leave;
import domain.User;

/**
 * Session Bean implementation class LeaveManagement
 */
@Stateless
public class LeaveManagement implements LeaveManagementRemote,
		LeaveManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userServicesLocal;

	/**
	 * Default constructor.
	 */
	public LeaveManagement() {
	}

	@Override
	public Boolean requestLeave(Integer idUser, Date fromDate, Date toDate,
			String subject) {
		Boolean b = false;
		try {
			User userFounded = userServicesLocal.findUserById(idUser);
			Leave leave = new Leave(fromDate, toDate, subject, userFounded);
			entityManager.persist(leave);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
