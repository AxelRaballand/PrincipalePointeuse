package model.common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class department
 * <p>
 * 	A department is characterized by :
 * <ul>
 * <li> An unique ID
 * <li> A name
 * <li> A list of Employee
 * <li> A number of employee
 * </ul>
 * </p>
 * 
 */
public class Department implements Serializable{

	/**
	 * id used for serialization
	 */
	private static final long serialVersionUID = -4150491621973467523L;

	/**
	 * ID of the department
	 * <p>
	 * @see getIdDepartment()
	 * @see setIdDepartment(int id)
	 * </p>
	 */
	private int idDepartment;

	/**
	 * Name of the department
	 * <p>
	 * @see Department(String nameDepartment)
	 * @see getNameDepartment()
	 * @see setNameDepartment(String nameDepartment)
	 * </p>
	 */
	private String nameDepartment;

	/**
	 * List of employee from a department
	 * <p>
	 * @see Department()
	 * @see Department(ArrayList<Employee> employeeList)
	 * @see getEmployeeList()
	 * @see setEmployeeList(ArrayList<Employee> employeeList)
	 * @see addEmployee(Employee newEmployee)
	 * @see delEmployee(Employee employeeToDelete)
	 * <p>
	 */
	private ArrayList<Employee> EmployeeList;

	/**
	 * Number of department in the company, use to give an ID to a department
	 * <p>
	 * @see Department()
	 * @see getCounter()
	 * @see setCounter(int newcounter)
	 */
	private static int counter;
	
	/**
	 * Constructor of the class department 
	 */
	public  Department() {
		counter ++;
		setEmployeeList(new ArrayList<Employee>());
		setIdDepartment(counter);
		setNameDepartment(null);
	}

	/**
	 * Constructor 
	 * <p>
	 * @param employeeList
	 * @param naemDepartment
	 * </p>
	 */
	public Department(ArrayList<Employee> employeeList, String nameDepartment) {
		super();
		setEmployeeList(employeeList);
		setNameDepartment(nameDepartment);
	}
	
	/**
	 * Getter of the department ID
	 * <p>
	 * @return idDepartment
	 * <p/>
	 */
	public int getIdDepartment() {
		return idDepartment;
	}
	
	/**
	 * Setter of the department ID
	 * <p>
	 * @param id
	 * @throws id must be a positive integer 
	 */
	public void setIdDepartment(int id) {
		if (id > 0)
		{
			idDepartment = id;
		}
		else
		{
			throw new ArithmeticException("id must be a postive integer !");
		}
	}
	
	/**
	 * Getter of the list of employee
	 * <p>
	 * @return EmployeeList
	 */
	public ArrayList<Employee> getEmployeeList() {
		return EmployeeList;
	}
	
	/**
	 * Setter of the list of employee
	 * <p>
	 * @param employeeList
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		EmployeeList = employeeList;
	}
	
	/**
	 * Getter of the department name
	 * <p>
	 * @return nameDepartment
	 */
	public String getNameDepartment() {
		return nameDepartment;
	}

	/**
	 * Setter of the department name 
	 * <p>
	 * @param nameDepartment
	 */
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	/**
	 * Getter of the number of department
	 * <p>
	 * @return counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * Setter of the number of department 
	 * <p>
	 * @param newcounter
	 */
	public static void setCounter(int newcounter) {
		Department.counter = newcounter;
	}

	
	/**
	 * Method which add an Employee to the Employee List of a department
	 * <p>
	 * @param newEmployee
	 */
	public void addEmployee(Employee newEmployee) {
		EmployeeList.add(newEmployee);
		newEmployee.setDepartment(this);
	}

	/**
	 * Method which delete an Employee from the Employee list of a department
	 * @param employeeToDelete
	 */
	public void delEmployee(Employee employeeToDelete) {
		if (!EmployeeList.remove(employeeToDelete))
		{
			System.err.println("This employee is not in the department");
		}
		else {
			EmployeeList.remove(employeeToDelete);
		}
	}
	
	/**
	 * @return msg
	 */
	public String toString() {
		String msg = getNameDepartment() + " " + getIdDepartment() + " ";
		return msg;
	}

}
