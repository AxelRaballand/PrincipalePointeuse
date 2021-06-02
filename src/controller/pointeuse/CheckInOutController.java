package controller.pointeuse;

import java.util.Iterator;

import model.common.*;

public class CheckInOutController {
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
	    			System.out.println(check);
	    			return check;
	    		}
	    	}
	    }
	    throw new Exception("employe not found");
	}
}
