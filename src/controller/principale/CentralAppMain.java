package controller.principale;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Iterator;

import view.principale.*;
import controller.pointeuse.TCPClientControler;
import controller.principale.*;
import model.common.*;

public class CentralAppMain {
	public static Company company;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//Recover the company from company.dat file
					Serialize ser = new Serialize("company.dat");
					company = ser.deserializeCompany();
					CentralAppMain.updateEmployeeCounter();
					CompanyController.departments = company.getDepartmentList();
					
					//try to send the company to the "pointeuse" 
					TCPClientControler client = new TCPClientControler();
					client.getClient().setCompany(company);
					client.sendCompany();
					
					//show graphics
					JGraphicMainServer window = new JGraphicMainServer();
					window.frame.setVisible(true);

					//Setup the server to received check
					TCPServerControler.setServer(TCPServerControler.getConfig());
					TCPServerControler.receivedCheckInOut();
					
				} catch (Exception e) {
					System.exit(0);
				}
			}
		});
	}
	
	/**
	 * Method which save the company when the process end.
	 */
	public static void CloseAppli()
	{
		
		Serialize ser = new Serialize("company.dat");
		try {
			ser.SerializeCompany(company);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Method which update the id to use to create new employee at the start of the application
	 */
	public static void updateEmployeeCounter()
	{
		
		Iterator<Department> iterDep = company.getDepartmentList().iterator();
		Iterator<Employee> iterEmp;
		Employee emp;
		int maxCounter = 0;
		
		while (iterDep.hasNext()) {
	    	iterEmp = iterDep.next().getEmployeeList().iterator();
	    	while (iterEmp.hasNext()) {
	    		emp = iterEmp.next();
	    		if(emp.getIdEmployee() >= maxCounter) {
	    			maxCounter = emp.getIdEmployee();
	    		}
	    	}
	    }
		
		Employee.setCounter(maxCounter);
	}

}
