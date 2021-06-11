package model.common;

import java.io.*;
import java.net.*;
import controller.principale.TCPServerControler;
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
	
	/**
	 * Check which include the company to send
	 */
	private CheckInOut check; //the company to send
	
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
			setS(getSS().accept());
			System.out.println("Server accepts the connection.");
			
			System.out.println("...data reception...");
			
			InputStream in = getS().getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);
			setCheck((CheckInOut) objIn.readObject());
			
			System.out.println("data received!");
			System.out.println(getCheck());
			CheckInOutController.addCheckToEmployee(check);
			TCPServerControler.closeServer();
			run();
			
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// a changer
			e.printStackTrace();
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
}