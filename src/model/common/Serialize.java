package model.common;

import java.io.*;
import java.util.ArrayList;

public class Serialize implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1947373594072570846L;

	/**
	 * Name of the file to serialize
	 */
	private String fileName;

	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	
	/**
	 * Constructor which create a 
	 * @param newFileName
	 */
	public Serialize(String newFileName) 
	{
		setFileName(newFileName);
	}
	
	public String getFileName()
	{
		return fileName;
	}
	
	public void setFileName(String newFileName)
	{
		fileName = newFileName;
	}
	
	/**
	 * Method which clear the file
	 * @throws IOException
	 */
	public void clearFile() throws IOException
	{
		fos = new FileOutputStream(getFileName());
		fos.close();
	}
	
	/**
	 * Method which serialize a check
	 * @param check
	 * @throws IOException
	 */
	public void serializeCheck(CheckInOut check) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(check);
		
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a check list
	 * @param CheckInOutList
	 * @throws Exception
	 */
	public void serializeCheckList(ArrayList<CheckInOut> CheckInOutList) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(getFileName());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(CheckInOutList);
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a employee
	 * @param emp
	 * @throws IOException
	 */
	public void serializeEmployee(Employee emp) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(emp);
		
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize an employee list
	 * @param Employees
	 * @throws Exception
	 */
	public void SerializeEmployeesList(ArrayList<Employee> Employees) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(getFileName());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Employees);
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a Department
	 * @param dpt
	 * @throws IOException
	 */
	public void SerializeDepartment(Department dpt) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(dpt);
		
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a department list 
	 * @param DepartmentList
	 * @throws Exception
	 */
	public void SerializeDepartmentList(ArrayList<Department> DepartmentList) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(getFileName());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DepartmentList);
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a company
	 * @param cmpy
	 * @throws IOException
	 */
	public void SerializeCompany(Company cmpy) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(cmpy);
		
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a TCPServer
	 * @param server
	 * @throws IOException
	 */
	public void SerializeTCPServer(TCPServer server) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(server);
		
		oos.close();
		fos.close();
	}
	
	/**
	 * Method which serialize a TCPClient
	 * @param server
	 * @throws IOException
	 */
	public void SerializeTCPClient(TCPClient client) throws IOException
	{
		// File initialize
		fos = new FileOutputStream(getFileName());
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(client);
		
		oos.close();
		fos.close();
	}
	
	//to serialize Planning
//	public void SerializePlanning(Planning planning) throws IOException
//	{
//		// File initialize
//		fos = new FileOutputStream(getFileName());
//		oos = new ObjectOutputStream(fos);
//		
//		oos.writeObject(planning);
//		
//		oos.close();
//		fos.close();
//	}
	
	/**
	 * Method which deserialize check
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public CheckInOut deserializeCheck() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		CheckInOut check = new CheckInOut();
		check = (CheckInOut) ois.readObject();
		ois.close();
		fis.close();
		
		return check;
	}
	
	/**
	 * Method which deserialize check list
	 * @return
	 * @throws Exception
	 */
	public ArrayList<CheckInOut> DeserializeCheckInOutList() throws Exception
	{
		ArrayList<CheckInOut> CheckInOutList;
		
		FileInputStream fis = new FileInputStream(getFileName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		CheckInOutList = (ArrayList<CheckInOut>)ois.readObject();
		ois.close();
		
		return CheckInOutList;
	}
	
	/**
	 * Method which deserialize employee
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Employee deserializeEmployee() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		Employee emp = new Employee();
		emp = (Employee) ois.readObject();
		ois.close();
		fis.close();
		
		return emp;
	}
	
	/**
	 * Method which deserialize employee list
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Employee> DeserializeEmployeesList() throws Exception
	{
		ArrayList<Employee> Employees;
		
		FileInputStream fis = new FileInputStream(getFileName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employees = (ArrayList<Employee>)ois.readObject();
		ois.close();
		
		return Employees;
	}
	
	/**
	 * Method which deserialize department
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Department deserializeDepartment() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		Department dpt = new Department();
		dpt = (Department) ois.readObject();
		ois.close();
		fis.close();
		
		return dpt;
	}

	/**
	 * Method which deserialize department list
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Department> DeserializeDepartmentList() throws Exception
	{
		ArrayList<Department> DepartmentList;
		
		FileInputStream fis = new FileInputStream(getFileName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		DepartmentList = (ArrayList<Department>)ois.readObject();
		ois.close();
		
		return DepartmentList;
	}
	
	/**
	 * Method which deserialize company
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Company deserializeCompany() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		Company cmpy;
		cmpy = (Company) ois.readObject();
		ois.close();
		fis.close();
		
		return cmpy;
	}
	
	/**
	 * Method which deserialize TCPServer
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TCPServer deserializeTCPServer() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		TCPServer server;
		server = (TCPServer) ois.readObject();
		ois.close();
		fis.close();
		
		return server;
	}
	
	/**
	 * Method which deserialize TCPClient
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TCPClient deserializeTCPClient() throws IOException, ClassNotFoundException
	{
		fis = new FileInputStream(getFileName());
		ois = new ObjectInputStream(fis);
		
		TCPClient client;
		client = (TCPClient) ois.readObject();
		ois.close();
		fis.close();
		
		return client;
	}
	
	//to deserialize Planning
//	public Planning deserializePlanning() throws IOException, ClassNotFoundException
//	{
//		fis = new FileInputStream(getFileName());
//		ois = new ObjectInputStream(fis);
//		
//		Planning plan;
//		plan = (Planning) ois.readObject();
//		ois.close();
//		fis.close();
//		
//		return plan;
//	}
}
