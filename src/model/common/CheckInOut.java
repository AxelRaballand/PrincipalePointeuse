package model.common;

import java.io.Serializable;

/**
 * Class checkInout which "save" when an employee come in the company and when he goes out 
 * 
 *
 */
public class CheckInOut extends Time{
	
	/**
	 * Creation of an employee object when user click on check in/out
	 * <p>
	 * @see CheckInOut(Employee employeeCheck)
	 * @see Employee getEmployeeCheck()
	 * @see setEmployeeCheck(Employee employeeCheck)
	 */
	private Employee EmployeeCheck;

	/**
	 * Constructor of a Check in/out
	 * <p>
	 * @param employeeCheck
	 */
	public CheckInOut(Employee employeeCheck) {
		super();
		EmployeeCheck = employeeCheck;
	}

	/**
	 * Constructor
	 */
	public CheckInOut() {
		super();
	}

	/**
	 * Getter
	 * @return EmployeeCheck
	 */
	public Employee getEmployeeCheck() {
		return EmployeeCheck;
	}

	/**
	 * Setter
	 * @param employeeCheck
	 */
	public void setEmployeeCheck(Employee employeeCheck) {
		EmployeeCheck = employeeCheck;
	}

	@Override
	public String toString() {
		return "CheckInOut : Employee = " + getEmployeeCheck().toString() + super.toString();
	}

}
