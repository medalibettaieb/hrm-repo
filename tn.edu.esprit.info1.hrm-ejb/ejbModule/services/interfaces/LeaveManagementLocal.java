package services.interfaces;

import java.util.Date;

import javax.ejb.Local;

import domain.Leave;

@Local
public interface LeaveManagementLocal {
	Boolean requestLeave(Integer idUser, Date fromDate, Date toDate,
			String subject);

	Boolean addLeave(Leave leave);

}
