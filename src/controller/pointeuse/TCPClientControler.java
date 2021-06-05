package controller.pointeuse;

import java.io.*;

import model.common.*;

public class TCPClientControler 
{
	private TCPClient client;
	
	public TCPClientControler() throws IOException, ClassNotFoundException
	{
		setClient(getConfig());
	}

	public TCPClientControler(String host, int port) throws ClassNotFoundException, IOException
	{
		SaveConfig(host,port);
		setClient(getConfig());
	}
	
	public void SaveConfig(String host, int port) throws IOException 
	{
		new Serialize("SaveConfigClient.dat").SerializeTCPClient(new TCPClient(host, port));
	}
	
	public TCPClient getConfig() throws IOException, ClassNotFoundException
	{
		return (new Serialize("SaveConfigClient.dat").deserializeTCPClient());
	}
	
	public void sendCheckInOut() 
	{
		new Thread(getClient()).start();
	}
	
	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}
}
