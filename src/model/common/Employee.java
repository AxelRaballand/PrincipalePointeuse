package model.common;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.Serializable;

public class Employee extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2717976069822070696L;

	private int idEmployee;

	private LocalTime startOfShift;

	private LocalTime endOfShift;
	
	private Department department;

	private static int counter = 0;
	
	private ArrayList<Planning> PlanningList;

	/**
	 * Constructor
	 */
	public  Employee() 
	{
		counter++;
		setIdEmployee(counter);
		setName(null);
		setSurname(null);
		setStartOfShift(null);
		setEndOfShift(null);
		setDepartment(null);
		PlanningList = new ArrayList<Planning>();
	}

	/**
	 * Constructor
	 * @param employee
	 */
	public  Employee(Employee employee) 
	{
		counter++;
		setIdEmployee(counter);
		setName(employee.getName());
		setSurname(employee.getSurname());
		setStartOfShift(employee.getStartOfShift());
		setEndOfShift(employee.getEndOfShift());
		setDepartment(employee.getDepartment());
		PlanningList = new ArrayList<Planning>();
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
	 * @return startOfShift
	 */
	public LocalTime getStartOfShift() 
	{
		return startOfShift;
	}

	/**
	 * 
	 * @param actualTime
	 */
	public void setStartOfShift(LocalTime actualTime) 
	{
		startOfShift = actualTime;
	}

	/**
	 * 
	 * @return endOfShift
	 */
	public LocalTime getEndOfShift() {
		return endOfShift;
	}

	/**
	 * 
	 * @param actualTime
	 */
	public void setEndOfShift(LocalTime actualTime) {
		endOfShift = actualTime;
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
	public void setCounter(int newCounter) 
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
		String msg = super.toString() + getDepartment();
		msg +=  System.lineSeparator() + "start at " + getStartOfShift().getHour() + ":" + getStartOfShift().getMinute();
		msg += " , end at " + getEndOfShift().getHour() + ":" + getEndOfShift().getMinute() + System.lineSeparator();
		return msg;
	}

}
