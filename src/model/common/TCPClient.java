package model.common;

import java.io.*;
import java.net.SocketException;

public class TCPClient extends TCPClientBuilder implements Runnable
{
	private CheckInOut check; //company to received from server
	
	public TCPClient() throws SocketException
	{
		super();
	}
	
	public TCPClient(String ip, int port) throws SocketException
	{
		super(ip,port);
	}
	
	public void run()
	{
		try
		{
			System.out.println("TCPClient started ...");
			setSocket();
			System.out.println("Client is connected.");
			
			System.out.println("...data reception...");
			
			InputStream in = getS().getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			setCheck((CheckInOut) objIn.readObject());
			System.out.println("data received!");
			
			closeSocket();
			System.out.println("...Connection closed.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
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
