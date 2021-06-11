package model.common;

import java.io.*;
import java.net.*;
import controller.principale.TCPServerControler;
import controller.pointeuse.ControllerMain;
import controller.principale.CheckInOutController;

public class TCPServer extends TCPServerBuilder implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1104532718907344688L;
	private CheckInOut check; 
	private Company company;
	
	private boolean receivedCompany;
	
	public TCPServer() throws SocketException
	{
		super();
		setCheck(null);
	}
	
	public TCPServer(String ip, int port) throws SocketException
	{
		super(ip, port);
		setCheck(null);
	}
	

	public TCPServer(CheckInOut check) throws SocketException
	{
		super();
		setCheck(check);
	}
	
	public void run()
	{
		try
		{
			setSockets();
			System.out.println("TCPServer launched ..."); 
			if (isReceivedCompany())
			{
				getSS().setSoTimeout(5000);
			}
			/*	
			{
				System.out.println("Connection lost, the company will be readed in company.dat.");
				Serialize ser = new Serialize("company.dat");
				try 
				{
					ControllerMain.company = ser.deserializeCompany();
				} 
				catch (ClassNotFoundException | IOException e1) 
				{
					e1.printStackTrace();
				}
			}*/
			setS(getSS().accept());
			System.out.println("Server accepts the connection.");
			System.out.println("...data reception...");
			
			InputStream in = getS().getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			if (isReceivedCompany())
			{
					setCompany((Company) objIn.readObject());					
					System.out.println("data received!");
					ControllerMain.company = getCompany();
			}
			else
			{
				setCheck((CheckInOut) objIn.readObject());				
				System.out.println("data received!");
				//System.out.println(getCheck());
				CheckInOutController.addCheckToEmployee(check);
			}
			
			TCPServerControler.closeServer();
			if (!isReceivedCompany())
			{
				run();
			}
			
			
		}
		catch (IOException e)
		{
			if (isReceivedCompany())
			{
				try {
					closeSockets();
				} catch (IOException e1)
				{
				}
				System.out.println("Connection lost, the company will be readed in company.dat.");
				Serialize ser = new Serialize("company.dat");
				try 
				{
					ControllerMain.company = ser.deserializeCompany();
				} 
				catch (ClassNotFoundException | IOException e1) 
				{
					e1.printStackTrace();
				}
			}
			else
			{
				//e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) 
		{
			// a changer
			//e.printStackTrace();
		}
	}
	
	public CheckInOut getCheck() {
		return check;
	}
	
	public void setCheck(CheckInOut check) {
		this.check = check;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isReceivedCompany() {
		return receivedCompany;
	}

	public void setReceivedCompany(boolean receivedCompany) {
		this.receivedCompany = receivedCompany;
	}
}