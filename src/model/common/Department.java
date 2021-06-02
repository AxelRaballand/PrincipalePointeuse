package model.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{

	private int idDepartment;

	private String nameDepartment;

	private ArrayList<Employee> EmployeeList;

	private static int counter;
	
	/**
	 * Constructor
	 */
	public  Department() {
		counter ++;
		EmployeeList = new ArrayList<Employee>();
		setIdDepartment(counter);
		setNameDepartment(null);
	}

	/**
	 * 
	 * @param employeeList
	 */
	public Department(ArrayList<Employee> employeeList) {
		super();
		EmployeeList = employeeList;
	}
	/**
	 * 
	 * @param nameDepartment	
	 */
	public Department(String nameDepartment) {
		super();
		this.nameDepartment = nameDepartment;
	}
	
	/**
	 * 
	 * @return idDepartment
	 */
	public int getIdDepartment() {
		return idDepartment;
	}
	
	/**
	 * 
	 * @param id
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
	 * 
	 * @return EmployeeList
	 */
	public ArrayList<Employee> getEmployeeList() {
		return EmployeeList;
	}
	
	/**
	 * 
	 * @param employeeList
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		EmployeeList = employeeList;
	}
	
	/**
	 * 
	 * @return nameDepartment
	 */
	public String getNameDepartment() {
		return nameDepartment;
	}

	/**
	 * 
	 * @param nameDepartment
	 */
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	/**
	 * 
	 * @return counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * 
	 * @param newcounter
	 */
	public static void setCounter(int newcounter) {
		Department.counter = newcounter;
	}

	
	/**
	 * 
	 * @param newEmployee
	 */
	public void addEmployee(Employee newEmployee) {
		EmployeeList.add(newEmployee);
		newEmployee.setDepartment(this);
	}

	/**
	 * 
	 * @param employeeToDelete
	 */
	public void delEmployee(Employee employeeToDelete) {
		if (!EmployeeList.remove(employeeToDelete))
		{
			System.err.println("Tentative de retirer un Employee non contenu dans la liste");
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
