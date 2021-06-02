package model.common;

import java.io.*;
import java.net.*;

public class TCPClientBuilder implements Serializable
{
	protected Socket s; 
	protected InetSocketAddress isA;
	
	protected int port;
	protected String ip;

	TCPClientBuilder() 
	{ 
		s = null; 
		isA = null; 
	}
	
	TCPClientBuilder(String ip, int port) throws SocketException
	{ 
		setIp(ip);
		setPort(port);
		setS(null);
		setisA(null);
	}
	
	public void setSocket() throws IOException
	{
		setisA(new InetSocketAddress(getHost(),getPort()));  
		setS(new Socket(isA.getHostName(), isA.getPort()));
	}
	
	public void closeSocket() throws IOException
	{
		s.close();
	}
	
	public void setS(Socket socket) throws SocketException
	{
		s = socket;
		if(s != null)
		{
			s.setSoTimeout(3000);
		}
	}
	
	public void setisA(InetSocketAddress address)
	{
		isA = address;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getHost() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Socket getS()
	{
		return s;
	}
	
	public InetSocketAddress getisA()
	{
		return isA;
	}
}
