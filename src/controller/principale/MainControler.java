package controller.principale;

import java.awt.EventQueue;

import view.principale.*;
import controller.principale.*;
import model.common.*;

public class MainControler {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Serialize ser = new Serialize("company.dat");
					Company company = ser.deserializeCompany();
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

}
