package controller.principale;

import java.awt.EventQueue;
import java.io.IOException;

import view.principale.*;
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
					CompanyController.departments = company.getDepartmentList();
					
					
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

}
