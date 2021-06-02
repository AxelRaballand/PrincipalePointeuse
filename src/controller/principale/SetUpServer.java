package controller.principale;

import java.io.IOException;

import model.common.*;

public class SetUpServer {
	
	private Serialize serializer;
	
	public SetUpServer()
	{
		serializer = new Serialize("SaveConfigServer.dat");
	}
	
	/**
	 * To serialize the current config 
	 * @param server : the TCPserver object which contain IP and host
	 * @throws IOException
	 */
	public void SaveConfig(String host, int port) throws IOException 
	{
		TCPServer server = new TCPServer(host, port);
		serializer.SerializeTCPServer(server);
	}
	
	public TCPServer getConfig() throws IOException, ClassNotFoundException
	{
		return (serializer.deserializeTCPServer());
	}
}
