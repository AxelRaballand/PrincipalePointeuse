package model.common;

import java.io.*;
import java.net.*;

/**
 * Class which build the server
 */
public class TCPServerBuilder implements Serializable
{
	/**
	 * ID used for serialization
	 */
	private static final long serialVersionUID = -3842333163105144014L;
	
	/**
	 * Socket of the server which is passive
	 */
	protected ServerSocket ss;

	/**
	 * The active socket
	 */
	protected Socket s;
	
	/**
	 * Address of the socket
	 */
	protected InetSocketAddress isA; 
	
	/**
	 * Port of the server
	 */
	protected int port;
	
	/**
	 * IP address of the server
	 */
	protected String ip;

	/**
	 * Constructor of the server builder
	 * <p>
	 * @throws SocketException
	 */
	public TCPServerBuilder() throws SocketException 
	{ 
		setSS(null);
		setS(null);
		setisA(null);
	}
	
	/**
	 * Constructor of the server builder which set the IP and port parameter
	 * <p>
	 * @param ip
	 * @param port
	 * @throws SocketException
	 */
	public TCPServerBuilder(String ip, int port) throws SocketException 
	{ 
		setIp(ip);
		setPort(port);
		setSS(null);
		setS(null);
		setisA(null);
	}
	
	/**
	 * Setter of isA and SS (server socket)
	 * <p>
	 * @throws IOException
	 */
	public void setSockets() throws IOException
	{
		setisA(new InetSocketAddress(ip,port));
		setSS(new ServerSocket(getisA().getPort()));
	}
	
	/**
	 * Method which close the 2 sockets (socket and server socket)
	 * @throws IOException
	 */
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
	
	/**
	 * Setter of the server socket
	 * <p>
	 * @param serverSocket
	 */
	public void setSS(ServerSocket serverSocket)
	{
		ss = serverSocket;
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
			s.setSoTimeout(0);
		}
	}
	
	/**
	 * Setter of the socket address
	 * <p>
	 * @param adress
	 */
	public void setisA(InetSocketAddress adress)
	{
		isA = adress;
	}
	
	/**
	 * Getter of the server socket
	 * <p>
	 * @return ss
	 */
	public ServerSocket getSS()
	{
		return ss;
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
	 * Getter of the socket address
	 * <p>
	 * @return isA
	 */
	public InetSocketAddress getisA()
	{
		return isA;
	}
	
	/**
	 * Getter of the port 
	 * <p>
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
	 * Getter of the IP address
	 * @return ip
	 */
	public String getIp() {
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
}
