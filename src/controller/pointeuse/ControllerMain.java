package controller.pointeuse;

import java.awt.EventQueue;
import java.util.ArrayList;
import model.common.*;
import view.pointeuse.*;

/**
 * Main class which manage the interaction with the "pointeuse"
 */
public class ControllerMain {
	
	public static Company company;
	public static ArrayList<CheckInOut> checkList;

	/**
	 * Main method which :
	 * 	- get the information on the company in the file company.dat
	 * 	- send checks if they exist
	 * 	- Save the check in the file SaveCheck.dat
	 * 	- open the HMI 
	 * <p>
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//recuperation of the  company
					Serialize ser = new Serialize("company.dat");
					company = ser.deserializeCompany();
					
					//If there are, waiting checks are send
					if (TCPClient.isWaitingSend())
					{
						ArrayList<CheckInOut> checkToSend = CheckInOutController.getChecks();
						for (CheckInOut check : checkToSend)
						{
							TCPClientControler client = new TCPClientControler();
							client.getClient().setCheck(check);
							client.sendCheckInOut();
							while(client.getClient().isSend() == false)
							{
								
							}
						}		
						new Serialize("SaveCheck.dat").clearFile();
					}
					
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
			check = CheckInOutController.createCheckInOut(idEmp, company);
			TCPClientControler client = new TCPClientControler();
			client.getClient().setCheck(check);
			client.sendCheckInOut();
			
			//checkList.add(check);
			return true;
		}catch(Exception e) {
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
		Serialize ser = new Serialize("test.txt");
		Serialize serCheck = new Serialize("checkinout.txt");
		try {
			ser.SerializeCompany(company);
			serCheck.serializeCheckList(checkList);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
