package controller.principale;

import model.common.*;
import view.principale.JGraphicMainServer;
import controller.principale.*;

/**
 * Class which manage the check of the employee
 */
public class CheckInOutController {

	/**
	 * Method which add a check to an employee
	 * @param check CheckInOut : the check to add to an employee's planning
	 * @throws Exception 
	 */
	public static void addCheckToEmployee(CheckInOut check) throws Exception
	{
		//Check if the check correspond to an existing employee
		CompanyController cont = new CompanyController();
		Employee emp = cont.SearchEmployee(check.getEmployeeCheck().getIdEmployee());
		if (emp == null)
		{
			throw new Exception("employe not found");
		}
	
		for(Planning plan : emp.getPlanningList())
		{
			//If there is already a check at this date
			if(check.getDate().equals(plan.getToday()))
			{
				//Put the check as the end of work for the employee
				plan.setEndTime(check.getRoundedHour());
				return;
			}
		}
		
		Planning plan = new Planning(null,check.getRoundedHour(),null,null,check.getDate());
		emp.addPlanning(plan);
		return;
		
	}
}
