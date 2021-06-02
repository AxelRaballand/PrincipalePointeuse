package controller.principale;

import java.io.*;

import model.common.*;

public class TCPControler 
{
	private TCPClient client;
	
	public TCPControler() throws ClassNotFoundException, IOException
	{
		SetUp config = new SetUp();
		setServer(config.getConfig());
	}
	
	public void sendCheckInOut(CheckInOut check) 
	{
		new Thread(getServer()).start();
		//dégager client pour faire communiquer les deux app
	}

	public TCPClient getClient() {
		return client;
	}

	public void setClient(TCPClient client) {
		this.client = client;
	}
}
