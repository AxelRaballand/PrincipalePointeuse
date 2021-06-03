package controller.principale;

import java.io.*;

import model.common.*;

public class TCPServerControler 
{
	private TCPServer server;
	
	public TCPServerControler() throws ClassNotFoundException, IOException
	{
		setServer(getConfig());
	}
	
	public TCPServerControler(String host, int port) throws ClassNotFoundException, IOException
	{
		SaveConfig(host, port);
		setServer(getConfig());
	}
	
	public void SaveConfig(String host, int port) throws IOException 
	{
		new Serialize("SaveConfigServer.dat").SerializeTCPServer(new TCPServer(host, port));
	}
	
	public TCPServer getConfig() throws IOException, ClassNotFoundException 
	{
		return (new Serialize("SaveConfigServer.dat").deserializeTCPServer());
	}
	
	public void receivedCheckInOut() 
	{
		new Thread(getServer()).start();
	}

	public TCPServer getServer() {
		return server;
	}

	public void setServer(TCPServer server) {
		this.server = server;
	}
	
}
