package model.common;

import java.io.*;
import java.net.*;

/**
 * Class which build the client and set client setting
 */
public class TCPClientBuilder implements Serializable
{
	/**
	 * ID of the client 
	 */
	private static final long serialVersionUID = -9208229795639514428L;
	
	/**
	 * Socket object
	 */
	protected Socket s; 
	
	
	protected InetSocketAddress isA;
	
	/**
	 * number of the port of the client 
	 */
	protected int port;
	
	/**
	 * IP of the client 
	 */
	protected String ip;

	/**
	 * Constructor of the client builder
	 */
	TCPClientBuilder() 
	{ 
		s = null; 
		isA = null; 
	}
	
	/**
	 * Constructor of the client builder which set the IP and the port
	 * <p>
	 * @param ip
	 * @param port
	 * @throws SocketException
	 */
	TCPClientBuilder(String ip, int port) throws SocketException
	{ 
		setIp(ip);
		setPort(port);
		setS(null);
		setisA(null);
	}
	
	/**
	 * Setter of the socket
	 * <p>
	 * @throws IOException
	 */
	public void setSocket() throws IOException
	{
		setisA(new InetSocketAddress(getHost(),getPort()));  
		setS(new Socket(isA.getHostName(), isA.getPort()));
	}
	
	/**
	 * Method wich close the socket
	 * <p>
	 * @throws IOException
	 */
	public void closeSocket() throws IOException
	{
		s.close();
	}
	
	/**
	 * Setter of the socket s
	 * <p>
	 * @param socket
	 * @throws SocketException
	 */
	public void setS(Socket socket) throws SocketException
	{
		s = socket;
		if(s != null)
		{
			s.setSoTimeout(3000);
		}
	}
	
	/**
	 * Setter of the inetSocketAdress
	 * <p>
	 * @param address
	 */
	public void setisA(InetSocketAddress address)
	{
		isA = address;
	}
	
	/**
	 * Getter of the port 
	 * @return port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Setter of the port 
	 * <p>
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * Getter of the host
	 * <p>
	 * @return ip
	 */
	public String getHost() {
		return ip;
	}
	
	/**
	 * Setter of the IP address
	 * <p>
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Getter of the socket s
	 * <p>
	 * @return s
	 */
	public Socket getS()
	{
		return s;
	}
	
	/**
	 * Getter of the InetSocketAdress
	 * <p>
	 * @return isA
	 */
	public InetSocketAddress getisA()
	{
		return isA;
	}
}
