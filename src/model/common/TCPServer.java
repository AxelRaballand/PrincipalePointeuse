package model.common;

import java.io.*;
import java.net.*;
import controller.principale.TCPServerControler;
import controller.principale.CheckInOutController;

public class TCPServer extends TCPServerBuilder implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1104532718907344688L;
	private CheckInOut check; //the company to send
	
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
	
	public CheckInOut getCheck() {
		return check;
	}
	
	public void setCheck(CheckInOut check) {
		this.check = check;
	}
}