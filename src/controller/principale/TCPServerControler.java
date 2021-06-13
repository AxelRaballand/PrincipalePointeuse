package controller.principale;

import java.io.*;
import java.net.SocketException;

import model.common.*;

/**
 * Class which set the TCP communication 
 */
public class TCPServerControler 
{
	private static TCPServer server;
	
	/**
	 * Constructor which set the server settings
	 * <p>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TCPServerControler() throws ClassNotFoundException, IOException
	{
		setServer(getConfig());
	}
	
	/**
	 * Constructor which set the server settings and save them in the file SaveConfigServer.dat
	 * <p>
	 * @param host
	 * @param port
	 * </p><p>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public TCPServerControler(String host, int port) throws ClassNotFoundException, IOException
	{
		SaveConfig(host, port);
		setServer(getConfig());
	}
	
	/**
	 * Method which save the configuration of the server in  the file SaveConfigServer.dat
	 * <p>
	 * @param host
	 * @param port
	 * </p><p>
	 * @throws IOException
	 */
	public static void SaveConfig(String host, int port) throws IOException 
	{
		new Serialize("SaveConfigServer.dat").SerializeTCPServer(new TCPServer(host, port));
	}
	
	/**
	 * Method which get the configuration of the server in the file SaveConfigServer.dat
	 * <p>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static TCPServer getConfig() throws IOException, ClassNotFoundException 
	{
		return (new Serialize("SaveConfigServer.dat").deserializeTCPServer());
	}
	
	/**
	 * Method which start the thread to received the check
	 */
	public static void receivedCheckInOut() 
	{
		getServer().setReceivedCompany(false);
		new Thread(getServer()).start();
	}
	
	/**
	 * Method which start the thread to received the company
	 */
	public static void receivedCompany() 
	{
		getServer().setReceivedCompany(true);
		new Thread(getServer()).start();
	}

	/**
	 * Getter of the server 
	 * <p>
	 * @return server
	 */
	public static TCPServer getServer() {
		return server;
	}

	/**
	 * Setter of the server 
	 * <p>
	 * @param server
	 */
	public static void setServer(TCPServer server) {
		TCPServerControler.server = server;
	}
	
	/**
	 * Method which close the server connection
	 * @throws IOException
	 */
	public static void closeServer() throws IOException
	{
		if (getServer().getS() != null)
		{
			getServer().closeSockets();	
		}
	}
}
