package model.common;

import java.io.*;
import java.net.*;


public class TCPServerBuilder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3842333163105144014L;
	protected ServerSocket ss; //the passive 
	protected Socket s; //and active sockets 
	
	protected InetSocketAddress isA; // the address 
	
	protected int port;
	protected String ip;

	public TCPServerBuilder() throws SocketException 
	{ 
		setSS(null);
		setS(null);
		setisA(null);
	}
	
	public TCPServerBuilder(String ip, int port) throws SocketException 
	{ 
		setIp(ip);
		setPort(port);
		setSS(null);
		setS(null);
		setisA(null);
	}
	
	public void setSockets() throws IOException
	{
		setisA(new InetSocketAddress(ip,port));
		setSS(new ServerSocket(getisA().getPort()));
	}
	
	public void closeSockets() throws IOException
	{
		if (getS() != null)
		{
			getS().close();			
		}
		if (getSS() != null)
		{
			getSS().close();			
		}
	}
	
	public void setSS(ServerSocket serverSocket)
	{
		ss = serverSocket;
	}
	
	public void setS(Socket socket) throws SocketException
	{
		s = socket;
		if(s != null)
		{
			s.setSoTimeout(0);
		}
	}
	
	public void setisA(InetSocketAddress adress)
	{
		isA = adress;
	}
	
	public ServerSocket getSS()
	{
		return ss;
	}
	
	public Socket getS()
	{
		return s;
	}
	
	public InetSocketAddress getisA()
	{
		return isA;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
