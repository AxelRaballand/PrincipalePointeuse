package controller.principale;

import java.io.IOException;

import model.common.*;

public class SetUp {
	
	private Serialize serializer;
	
	public SetUp()
	{
		serializer = new Serialize("SaveConfig.dat");
	}
	
	/**
	 * To serialize the current config 
	 * @param server : the TCPserver object which contain IP and host
	 * @throws IOException
	 */
	public void SaveConfig(String host, int port) throws IOException 
	{
		TCPClient client = new TCPClient(host, port);
		serializer.SerializeTCPClient(client);
	}
	
	public TCPClient getConfig() throws IOException, ClassNotFoundException
	{
		return (serializer.deserializeTCPClient());
	}
}
