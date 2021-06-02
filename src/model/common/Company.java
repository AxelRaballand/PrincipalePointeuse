package model.common;


import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {

	private String nameCompany;

	private ArrayList<Department> DepartmentList;

	public Company(String nameCompany) {
		setNameCompany(nameCompany);
		setDepartmentList(new ArrayList<Department>());
	}
	
	public Company(String nameCompany, ArrayList<Department> departmentList) {
		this.nameCompany = nameCompany;
		DepartmentList = departmentList;
	}
	
	public Company() {
		super();
		DepartmentList = new ArrayList<Department>();
	}

	/**
	 * 
	 * @return nameCompany
	 */
	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * 
	 * @param nameCompany
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	/**
	 * 
	 * @return DepartmentList
	 */
	public ArrayList<Department> getDepartmentList() {
		return DepartmentList;
	}
	
	/**
	 * 
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
	 * 
	 * @param dpt
	 */
	public void removeDepartement(Department dpt) {
		this.DepartmentList.remove(dpt);
	}

}
