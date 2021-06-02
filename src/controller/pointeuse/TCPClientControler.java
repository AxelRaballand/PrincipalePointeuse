package controller.pointeuse;

import java.io.*;

import model.common.*;

public class TCPClientControler 
{
	private TCPClient client;
	
	public TCPClientControler() throws ClassNotFoundException, IOException
	{
		SetUpClient config = new SetUpClient();
		setClient(config.getConfig());
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
