package controller.principale;

import model.common.*;
import view.principale.JGraphicMainClient;
import controller.principale.*;

public class CheckInOutController {

	public static void addCheckToEmployee(CheckInOut check)
	{
		CompanyController cont = new CompanyController();
		Employee emp = cont.SearchEmployee(check.getEmployeeCheck().getIdEmployee());
		if (emp == null)
		{
			//lever exception
		}
		
		for(Planning plan : emp.getPlanningList())
		{
			if(check.getDate().equals(plan.getToday()))
			{
				plan.setHeure_Fin(check.getRoundedHour());
				return;
			}
		}
		
		Planning plan = new Planning("lundi",check.getRoundedHour(),null,null,check.getDate());
		emp.addPlanning(plan);
		return;
		
	}
}
