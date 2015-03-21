package services.interfaces;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface LeaveManagementRemote {
	Boolean requestLeave(Integer idUser, Date fromDate, Date toDate,
			String subject);

}
