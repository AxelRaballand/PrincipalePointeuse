package controller.pointeuse;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;

import model.common.*;

/**
 * Class which manage the check in/out of the company
 */
public class CheckInOutController {
	/**
	 * Method which create a check in/out for an employee,
	 * This method is called when we pressed the button checkinout
	 * <p>
	 * @param idEmp
	 * @param cmpy
	 * @return check
	 * @throws Exception
	 */
	public static CheckInOut createCheckInOut(String idEmp, Company cmpy) throws Exception {
		
		Iterator<Department> iterDep = cmpy.getDepartmentList().iterator();
		Iterator<Employee> iterEmp;
		Employee emp;
		
	    while (iterDep.hasNext()) {
	    	iterEmp = iterDep.next().getEmployeeList().iterator();
	    	while (iterEmp.hasNext()) {
	    		emp = iterEmp.next();
	    		if(emp.getIdEmployee() == Integer.parseInt(idEmp)) {
	    			CheckInOut check = new CheckInOut(emp);
	    			System.out.println("check cree");
	    			//System.out.println(check);
	    			return check;
	    		}
	    	}
	    }
	    throw new Exception("employe not found");
	}
	
	/**
	 * Method which serialize the check and save it in the file SaveCheck.dat
	 * <p>
	 * @throws SocketException
	 * @throws Exception
	 */
	public static void SaveChecks() throws SocketException, Exception
	{
		new Serialize("SaveCheck.dat").serializeCheckList(TCPClient.getSendError());
		TCPClient.getSendError().clear();
	}
	
	/**
	 * Method which get the check in the file SaveCheck.dat
	 * <p>
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<CheckInOut> getChecks() throws Exception
	{
		return (new Serialize("SaveCheck.dat").DeserializeCheckInOutList());
		
	}
}
