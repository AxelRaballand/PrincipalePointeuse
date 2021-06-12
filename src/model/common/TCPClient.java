package model.common;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;

import controller.pointeuse.CheckInOutController;
import controller.pointeuse.TCPClientControler;
import controller.principale.CentralAppMain;
/**
 * Class which create the client part of a TCP communication
 */
public class TCPClient extends TCPClientBuilder implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7818827221127223706L;
	/**
	 * Check which is send to the server
	 * <p>
	 * @see run()
	 * @see getCheck()
	 * @see setCheck(CheckInOut check)
	 * @see delSendError(CheckInOut check)
	 * @see addSendError(CheckInOut check)
	 */
	private CheckInOut check;
	
	private Company company;
	
	private boolean SendCompany;
	
	/**
	 * Checks which couldn't be sent 
	 * <p>
	 * @see getSendError()
	 * @see addSendError(CheckInOut check)
	 * @see delSendError(CheckInOut check)
	 * @see delSendError(int indice)
	 * @see setSendError(ArrayList<CheckInOut> sendError)
	 */
	private static ArrayList<CheckInOut> sendError = new ArrayList<CheckInOut>();
	
	/**
	 * Boolean value which allow us to know if the packet is send
	 * <p>
	 * @see isSend()
	 * @see setSend(boolean isSend)
	 */
	private static boolean isSend;
	
	/**
	 * Constructor of the client 
	 * @throws SocketException
	 */
	public TCPClient() throws SocketException
	{
		super();
		setSend(false);
	}
	
	/**
	 * Constructor of client which include the network settings
	 * @param ip
	 * @param port
	 * @throws SocketException
	 */
	public TCPClient(String ip, int port) throws SocketException
	{
		super(ip,port);
		setSend(false);
	}
	
	/**
	 * Method which send a check to the server
	 */
	public void run()
	{
		try
		{
			System.out.println("TCPClient started ...");
			setSocket();
			System.out.println("Client is connected.");
			
			System.out.println("...Sending data...");
			OutputStream out = getS().getOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			if (isSendCompany())
			{
				objOut.writeObject(company);
			}
			else
			{				
				objOut.writeObject(check);
			}
			
			System.out.println("Data send !");
			setSend(true);
			
			closeSocket();
			System.out.println("...Connection closed.");
			
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
			
			if (!TCPClient.getSendError().isEmpty())
			{
				ArrayList<CheckInOut> checkToSend = TCPClient.getSendError();
				for (CheckInOut check : checkToSend)
				{
					TCPClientControler client = new TCPClientControler();
					client.getClient().setCheck(check);
					client.sendCheckInOut();
					while(client.getClient().isSend() == false)
					{
						
					}
				}	
				TCPClient.getSendError().clear();
			}
		}
		catch (Exception e)
		{
			if (isSendCompany())
			{
				System.out.println("Company not send. Saved in company.dat");
				Serialize ser = new Serialize("company.dat");
				try {
					ser.SerializeCompany(company);
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
			else
			{
				System.out.println("Error sending data. Storage in progress ...");
				addSendError(getCheck());
				System.out.println("Check recorded! It will be sent at the next start.");				
			}
			
		} 
		
	}
	
	/**
	 * Getter of check
	 * @return check 
	 */
	public CheckInOut getCheck() {
		return check;
	}
	
	/**
	 * Setter of check 
	 * @param check
	 */
	public void setCheck(CheckInOut check) {
		this.check = check;
	}

	/**
	 * Getter of send error
	 * @return sendError
	 */
	public static ArrayList<CheckInOut> getSendError() {
		return sendError;
	}
	
	/**
	 * Method which add a check to the sendError list
	 * @param check
	 */
	public static void addSendError(CheckInOut check)
	{
		sendError.add(check);
	}
	
	/**
	 * Method which remove a check from the sendError list
	 * @param check
	 */
	public void delSendError(CheckInOut check)
	{
		if (sendError.contains(check))
			sendError.remove(check);
	}

	/**
	 * Method which remove a check from the sendError list at an accurate index
	 * @param indice
	 * @throws Exception
	 */
	public void delSendError(int indice) throws Exception
	{
		if (indice < sendError.size() && indice >= 0)
			sendError.remove(indice);
		else
			throw new Exception("indice is out of bound!");
	}

	/**
	 * Setter of sendError
	 * @param sendError
	 */
	public void setSendError(ArrayList<CheckInOut> sendError) {
		TCPClient.sendError = sendError;
	}

	/**
	 * Getter of isSEnd
	 * @return isSend
	 */
	public boolean isSend() {
		return isSend;
	}

	/**
	 * Setter of isSend
	 * @param isSend
	 */
	public static void setSend(boolean isSend) {
		TCPClient.isSend = isSend;
	}

	/**
	 * Method which create a file 
	 * @return true
	 * @return false 
	 */
	public static boolean isWaitingSend() {
		File file = new File("SaveCheck.dat");
		if(file.exists())
		{
			if (file.length() != 0)
			{
				return true;
			}
		}
		return false;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isSendCompany() {
		return SendCompany;
	}

	public void setSendCompany(boolean sendCompany) {
		SendCompany = sendCompany;
	}
}
