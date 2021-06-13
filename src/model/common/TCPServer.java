package model.common;

import java.io.*;
import java.net.*;
import controller.principale.TCPServerControler;
import controller.pointeuse.PointeuseMain;
import controller.principale.CheckInOutController;

/**
 * Class of the server
 */
public class TCPServer extends TCPServerBuilder implements Runnable
{
	/**
	 * ID of the server 
	 */
	private static final long serialVersionUID = 1104532718907344688L;
	private CheckInOut check; 
	private Company company;
	
	private boolean receivedCompany;
	
	/**
	 * Constructor of the server
	 * <p>
	 * @throws SocketException
	 */
	public TCPServer() throws SocketException
	{
		super();
		setCheck(null);
	}
	
	/**
	 * Constructor of the server which set the IP and port
	 * <p>
	 * @param ip
	 * @param port
	 * @throws SocketException
	 */
	public TCPServer(String ip, int port) throws SocketException
	{
		super(ip, port);
		setCheck(null);
	}
	

	/**
	 * Constructor of the server which set the check to send 
	 * @param check
	 * @throws SocketException
	 */
	public TCPServer(CheckInOut check) throws SocketException
	{
		super();
		setCheck(check);
	}
	
	/**
	 * Method which make the server receive and read the packet send by the client
	 */
	public void run()
	{
		try
		{
			setSockets();
			System.out.println("TCPServer launched ..."); 
			if (isReceivedCompany())
			{
				getSS().setSoTimeout(10000);
			}
			setS(getSS().accept());
			System.out.println("Server accepts the connection.");
			System.out.println("...data reception...");
			
			InputStream in = getS().getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			if (isReceivedCompany())
			{
					setCompany((Company) objIn.readObject());					
					System.out.println("Company received!");
					PointeuseMain.company = getCompany();
			}
			else
			{
				setCheck((CheckInOut) objIn.readObject());				
				System.out.println("Check received!");
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
					PointeuseMain.company = ser.deserializeCompany();
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
			//e.printStackTrace();
		} catch (Exception e) {
			
			//e.printStackTrace();
		}
	}
	
	/**
	 * Getter of the check
	 * <p>
	 * @return check 
	 */
	public CheckInOut getCheck() {
		return check;
	}
	
	/**
	 * Setter of the check 
	 * @param check
	 */
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