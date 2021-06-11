package model.common;

import java.time.LocalTime;
import java.util.ArrayList;

public class Employee extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2717976069822070696L;

	private int idEmployee;
	
	private Department department;

	private static int counter = 0;
	
	private ArrayList<Planning> PlanningList;

	/**
	 * Constructor
	 */
	public  Employee() 
	{
		super();
		counter++;
		setIdEmployee(counter);
		setDepartment(null);
		setPlanningList(new ArrayList<Planning>());
	}

	/**
	 * Constructor
	 * @param employee
	 */
	public  Employee(Employee employee) 
	{
		super(employee.getName(),employee.getSurname());
		counter++;
		setIdEmployee(counter);
		setDepartment(employee.getDepartment());
		setPlanningList(new ArrayList<Planning>());
	}

	/**
	 * 
	 * @return idEmployee
	 */
	public int getIdEmployee() 
	{
		return idEmployee;
	}

	/**
	 * 
	 * @param id
	 */
	public void setIdEmployee(int id)
	{
		if (id > 0)
		{
			idEmployee = id;
		}
		else
		{
			throw new ArithmeticException("id must be a postive integer !");
		}
	}

	/**
	 * 
	 * @return department
	 */
	public Department getDepartment()
	{
		return department;
	}
	
	/**
	 * 
	 * @param dpt
	 */
	public void setDepartment(Department dpt)
	{
		department = dpt;
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
	 * @param newCounter
	 */
	public static void setCounter(int newCounter) 
	{
		counter = newCounter;
	}
	
	/**
	 * 
	 * @return Planninglist
	 */
	public ArrayList<Planning> getPlanningList() {
		return PlanningList;
	}

	/**
	 * 
	 * @param planningList
	 */
	public void setPlanningList(ArrayList<Planning> planningList) {
		PlanningList = planningList;
	}

	/**
	 * 
	 * @param p
	 */
	public void addPlanning(Planning p) {
		this.PlanningList.add(p);
	}
	
	/**
	 * 
	 * @param p
	 */
	public void removePlanning(Planning p) {
		this.PlanningList.remove(p);
	}

	/**
	 * @return msg
	 */
	public String toString()
	{
		String msg = super.toString() + getIdEmployee() + getDepartment();
		return msg;
	}

}
