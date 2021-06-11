package controller.principale;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Iterator;

import view.principale.*;
import controller.pointeuse.TCPClientControler;
import controller.principale.*;
import model.common.*;

public class MainControler {
	public static Company company;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Serialize ser = new Serialize("company.dat");
					company = ser.deserializeCompany();
					MainControler.updateEmployeeCounter();
					
					CompanyController.departments = company.getDepartmentList();
					
					TCPClientControler client = new TCPClientControler();
					client.getClient().setCompany(company);
					client.sendCompany();
					
					
					JGraphicMainClient window = new JGraphicMainClient();
					window.frame.setVisible(true);

					TCPServerControler.setServer(TCPServerControler.getConfig());
					TCPServerControler.receivedCheckInOut();
					
				} catch (Exception e) {
					System.exit(0);
				}
			}
		});
	}
	
	public static void CloseAppli()
	{
		Serialize ser = new Serialize("company.dat");
		try {
			ser.SerializeCompany(company);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
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
