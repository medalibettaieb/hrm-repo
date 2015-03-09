package services.impl;

import javax.ejb.Stateless;
import services.interfaces.LeaveManagementLocal;
import services.interfaces.LeaveManagementRemote;

/**
 * Session Bean implementation class LeaveManagement
 */
@Stateless
public class LeaveManagement implements LeaveManagementRemote, LeaveManagementLocal {

    /**
     * Default constructor. 
     */
    public LeaveManagement() {
        // TODO Auto-generated constructor stub
    }

}
