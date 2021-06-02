package controller.principale;

import java.io.*;

import model.common.*;

public class TCPServerControler 
{
	private TCPServer server;
	
	public TCPServerControler() throws ClassNotFoundException, IOException
	{
		SetUpServer config = new SetUpServer();
		setServer(config.getConfig());
	}
	
	public void receivedCheckInOut() 
	{
		new Thread(getServer()).start();
		//dégager client pour faire communiquer les deux app
	}

	public TCPServer getServer() {
		return server;
	}

	public void setServer(TCPServer server) {
		this.server = server;
	}
}
