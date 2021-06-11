package controller.pointeuse;

import java.awt.EventQueue;
import java.util.ArrayList;
import model.common.*;
import view.pointeuse.*;

public class ControllerMain {
	public static Company company;
	public static ArrayList<CheckInOut> checkList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//récup company
					Serialize ser = new Serialize("company.dat");
					company = ser.deserializeCompany();
					
					//If there are, wainting checks are send
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
