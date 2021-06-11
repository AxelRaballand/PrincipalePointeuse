package controller.principale;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.common.Department;
import model.common.Employee;
import model.common.Planning;
import view.principale.JGraphicMainClient;

/**
 * Class which manage the company
 */
public class CompanyController {

	public static ArrayList<Department> departments= new ArrayList<Department>();
	

	/**
	 * Method which search a department by his name in the company 
	 * <p>
	 * @param nomDepart
	 * @return null
	 */
    public Department SearchDepartment(String nomDepart)
	{
		for(Department depart : departments)
		{
			if(depart.getNameDepartment().equals(nomDepart)) return depart;
		}
		return null;
	}
	
    /**
     * Method which search a department by his ID in the company
     * <p>
     * @param nomDepart
     * @return
     */
    public int SearchDepartmentId(String nomDepart)
	{
		for(Department depart : departments)
		{
			if(depart.getNameDepartment().equals(nomDepart)) return depart.getIdDepartment();
		}
		return -1;
	}
    
    /**
     * Method which search a department by is ID and change his name
     * <p>
     * @param idDepart
     * @param newName
     * @return -1
     */
    public int ModifyDepartment(int idDepart , String newName)
	{
		for(Department depart : departments)
		{
			if(depart.getIdDepartment()==idDepart)  depart.setNameDepartment(newName);
		}
		return -1;
	}
    
    /**
     * Method which give the ID of a department
     * <p>
     * @param idDepart
     * @return
     */
    public int getDepartmentIndex(int idDepart)
    {
    	int i = 0;
		for(Department depart : departments)
		{
			if(depart.getIdDepartment()==idDepart)  return i;
			i++;
		}
		return -1;
		
    }
    
    /**
     * Method which remove a department by his ID from the department list
     * <p>
     * @param idDepart
     * @return
     */
    public boolean DeleteDepartment(int idDepart)
	{
    	int index = getDepartmentIndex(idDepart);
    	if(index>-1)
    	{
    		departments.remove(index);
    		return true;
    	}
    	else return false;
	}
    
    /**
     * Method which add a department to the department list
     * <p>
     * @param nomDepart
     */
	public void AddDepartment(String nomDepart)
	{ 
		Department depart = new Department();
		depart.setNameDepartment(nomDepart);
		departments.add(depart);
	}
	
	/**
	 * Method which return the list of employee of a department
	 * <p>
	 * @param nameDepartment
	 * @return EmployeeList
	 */
	public ArrayList<Employee> getEmployees(String nameDepartment)
	{
		for(Department depart : departments)
		{
			if(depart.getNameDepartment().equals(nameDepartment)) return depart.getEmployeeList();
		}
		return null;
	}
	
	/**
	 * Method which create an employee and add him to the Employee list of a department
	 * <p>
	 * @param firstName
	 * @param lastName
	 * @param name_department
	 */
	public void AddEmployee(String firstName ,String lastName , String name_department)
	{
		Employee emp = new Employee();
		emp.setName(firstName);
		emp.setSurname(lastName);
		emp.setDepartment(SearchDepartment(name_department));
		AddEmployeeToDepartement(name_department,emp);
	}
	
	/**
	 * Method which add an employee to a department
	 * <p>
	 * @param nameDepartement
	 * @param emp
	 */
	public void AddEmployeeToDepartement(String nameDepartement , Employee emp)
	{
		for(Department depart : departments)
		{
			if(depart.getNameDepartment().equals(nameDepartement)) 
			{
				depart.addEmployee(emp);
			}
		}
	}
	
	/**
	 * Method which change the information of an employee in an accurate department
	 * <p>
	 * @param idEmployee
	 * @param firstName
	 * @param lastName
	 * @param name_department
	 */
	public void ModifyEmployee(int idEmployee , String firstName , String lastName, String name_department)
	{
		for(int i = 0; i < departments.size() ; i++)
		{
			for(Employee emp  : departments.get(i).getEmployeeList())
			{
				if(emp.getIdEmployee()==idEmployee) 
				{
					emp.setName(firstName);
					emp.setSurname(lastName);
					//emp.setStartOfShift(startOfShift);, LocalTime startOfShift,  LocalTime endOfShift
					//emp.setEndOfShift(endOfShift);
					emp.setDepartment(SearchDepartment(name_department));
				}
			}
		}
	}
	
	/**
	 * Method which delete an employee from a department
	 * <p>
	 * @param idEmployee
	 */
	public void DeleteEmployee(int idEmployee)
	{
		for(int i = 0; i < departments.size() ; i++)
			for(Employee emp  : departments.get(i).getEmployeeList())
			{
				if(emp.getIdEmployee()==idEmployee) 
				{
					departments.get(i).delEmployee(emp);break;
				}
			}
	}
	
	/**
	 * Method which search an employee in all the company 
	 * <p> 
	 * @param idEmployee
	 * @return
	 */
	public Employee SearchEmployee(int idEmployee)
	{
		for(int i = 0; i < departments.size() ; i++)
		{
			for(Employee emp  : departments.get(i).getEmployeeList())
			{
				if(emp.getIdEmployee()==idEmployee) return emp;
			}
		}
		return null;
	}
	
	/**
	 * Method which add a planning to an employee 
	 * <p>
	 * @param idEmployee
	 * @param jour_planning
	 * @param heure_Debut
	 * @param heure_Fin
	 * @param type_travail
	 * @param day
	 */
	public void AddEmployeePlanning(int idEmployee ,  String jour_planning, LocalTime heure_Debut, LocalTime heure_Fin, String type_travail,LocalDate day)
	{
		Employee emp = SearchEmployee(idEmployee);
		if(emp!=null)
		{
			Planning plan = new Planning(jour_planning, heure_Debut, heure_Fin, type_travail,day);
			emp.addPlanning(plan);
		}
	}
	
	/**
	 * Method which change the planning of an employee 
	 * <p>
	 * @param idEmployee
	 * @param idPlanning
	 * @param jour_planning
	 * @param heure_Debut
	 * @param heure_Fin
	 * @param type_travail
	 */
	public void ModifEmployeePlanning(int idEmployee ,int idPlanning,String jour_planning, LocalTime heure_Debut, LocalTime heure_Fin, String type_travail )
	{
		for(Department depart : CompanyController.departments)
		{System.out.println("m0");
			for(Employee emp : depart.getEmployeeList())
			{System.out.println("m1  --> "+emp.getIdEmployee()+" == "+idEmployee);
				if(emp.getIdEmployee()==idEmployee)
				{System.out.println("m2");
					for(Planning pl : emp.getPlanningList())
					{System.out.println("m3");
					   if(pl.getIdPlanning()==idPlanning)
					   {System.out.println("m4");
						   pl.setJour_planning(jour_planning);
						   pl.setHeure_Debut(heure_Fin);
						   pl.setHeure_Fin(heure_Fin);
						   pl.setType_travail(type_travail);
					   }
					}
				}
			}
		}
	}
	
	/**
	 * Method which delete the planning of an employee 
	 * <p>
	 * @param idEmployee
	 * @param idPlanning
	 */
	public void DeleteEmployeePlanning(int idEmployee ,int idPlanning)
	{
		for(Department depart : CompanyController.departments)
			
			for(Employee emp : depart.getEmployeeList())
			{
				if(emp.getIdEmployee()==idEmployee)
				{
					for(Planning pl : emp.getPlanningList())
					{
						if(pl.getIdPlanning()==idPlanning)  
						{
							System.out.println("olo");
							emp.removePlanning(pl);break;
						}
					}
				}
			}
	}
}

