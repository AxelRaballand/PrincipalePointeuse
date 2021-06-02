package model.common;

import java.io.Serializable;

public class CheckInOut extends Time{
	
	private Employee EmployeeCheck;

	public CheckInOut(Employee employeeCheck) {
		super();
		EmployeeCheck = employeeCheck;
	}

	public CheckInOut() {
		super();
	}

	public Employee getEmployeeCheck() {
		return EmployeeCheck;
	}

	public void setEmployeeCheck(Employee employeeCheck) {
		EmployeeCheck = employeeCheck;
	}

	@Override
	public String toString() {
		return "CheckInOut : Employee = " + getEmployeeCheck().toString() + super.toString();
	}

}
