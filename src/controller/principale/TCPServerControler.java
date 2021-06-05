package controller.principale;

import java.io.*;

import model.common.*;

public class TCPServerControler 
{
	private static TCPServer server;
	
	public TCPServerControler() throws ClassNotFoundException, IOException
	{
		setServer(getConfig());
	}
	
	public TCPServerControler(String host, int port) throws ClassNotFoundException, IOException
	{
		SaveConfig(host, port);
		setServer(getConfig());
	}
	
	public static void SaveConfig(String host, int port) throws IOException 
	{
		new Serialize("SaveConfigServer.dat").SerializeTCPServer(new TCPServer(host, port));
	}
	
	public static TCPServer getConfig() throws IOException, ClassNotFoundException 
	{
		return (new Serialize("SaveConfigServer.dat").deserializeTCPServer());
	}
	
	public static void receivedCheckInOut() 
	{
		new Thread(getServer()).start();
	}

	public static TCPServer getServer() {
		return server;
	}

	public static void setServer(TCPServer server) {
		TCPServerControler.server = server;
	}
	
	public static void closeServer() throws IOException
	{
		if (getServer().getS() != null)
		{
			getServer().closeSockets();	
		}
	}
}
