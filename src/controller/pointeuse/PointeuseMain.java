package controller.pointeuse;

import java.awt.EventQueue;
import java.util.ArrayList;

import controller.principale.TCPServerControler;
import model.common.*;
import view.pointeuse.*;

/**
 * Main class which manage the interaction with the "pointeuse"
 */
public class PointeuseMain {
	
	public static Company company;
	public static ArrayList<CheckInOut> checkList;

	/**
	 * Main method which :
	 * 	- get the information on the company
	 * 	- send waiting checks if they exist
	 * 	- Save the check in the file SaveCheck.dat
	 * 	- open the HMI 
	 * <p>
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//try to recover the company from the main app
					TCPServerControler.setServer(TCPServerControler.getConfig());
					TCPServerControler.receivedCompany();
					
					//show graphics
					JGraphicMainServer window = new JGraphicMainServer();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * Method which create a check in/out and send it to the server
	 * @param idEmp
	 */
	public static boolean CheckInOut(String idEmp) {
		CheckInOut check = new CheckInOut(); 
		try {
			//check if the id used is in the company
			check = CheckInOutController.createCheckInOut(idEmp, company);
			
			//then send the check
			TCPClientControler client = new TCPClientControler();
			client.getClient().setCheck(check);
			client.sendCheckInOut();

			return true;
		}
		catch(Exception e) 
		{
			//if there is an error when sending
			if (e.getClass().getName() != "java.lang.Exception")
			{
				TCPClient.addSendError(check);
				return true;
			}
			
			return false;
		}
	}
	
	/**
	 * Method which serialize the company and the and the check which are made made when the window was open
	 * This method is called when we closed the window
	 */
	public static void CloseWindow() {
		/*Serialize ser = new Serialize("company.dat");
		try {
			ser.SerializeCompany(company);
		}
		catch(Exception e){
			System.out.println(e);
		}*/
	}
}
