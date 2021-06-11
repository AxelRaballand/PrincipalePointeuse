package model.common;


import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1980531193222822287L;

	/**
	 * Name of the company 
	 * <p>
	 * @see Company(String nameCompany, ArrayList<Department> departmentList)
	 * @see getNameCompany()
	 * @see setNameCompany(String nameCompany)
	 */
	private String nameCompany;

	/**
	 * List of the department
	 * <p>
	 * @see Company(String nameCompany, ArrayList<Department> departmentList)
	 * @see ArrayList<Department>{@link #getDepartmentList()}
	 * @see setDepartmentList(ArrayList<Department> departmentList)
	 * @see addDepartement(Department newDpt)
	 * @see removeDepartement(Department dpt)
	 */
	private ArrayList<Department> DepartmentList;

	/**
	 * Constructor of the class Company
	 * <p>
	 * @param nameCompany
	 */
	public Company(String nameCompany) {
		setNameCompany(nameCompany);
		setDepartmentList(new ArrayList<Department>());
	}
	
	/**
	 * Constructor of the class Company
	 * <p>
	 * @param nameCompany
	 * @param departmentList
	 */
	public Company(String nameCompany, ArrayList<Department> departmentList) {
		setNameCompany(nameCompany);
		setDepartmentList(departmentList);
	}
	
	/**
	 * Constructor of the class Company
	 * <p>
	 */
	public Company() {
		super();
		setDepartmentList(new ArrayList<Department>());
	}

	/**
	 * Getter of nameCompany
	 * <p>
	 * @return nameCompany
	 */
	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * Setter of nameCompany
	 * <p>
	 * @param nameCompany
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	
	/**
	 * Getter of the department list
	 * <p>
	 * @return DepartmentList
	 */
	public ArrayList<Department> getDepartmentList() {
		return DepartmentList;
	}
	
	/**
	 * Setter of the department list
	 * <p>
	 * @param departmentList
	 */
	public void setDepartmentList(ArrayList<Department> departmentList) {
		DepartmentList = departmentList;
	}
	
	/**
	 * 
	 * @param newDpt
	 */
	public void addDepartement(Department newDpt) {
		this.DepartmentList.add(newDpt);
	}
	
	/**
	 * Method which add a department to the DepartmentList
	 * <p>
	 * @param newDpt
	 */
	public void removeDepartement(Department dpt) {
		this.DepartmentList.remove(dpt);
	}

}
