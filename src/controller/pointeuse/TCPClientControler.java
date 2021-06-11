package controller.pointeuse;

import java.io.*;

import model.common.*;

/**
 * Class which set the TCP communication 
 */
public class TCPClientControler 
{
	private TCPClient client;
	
	/**
	 * Constructor which set the client settings
	 * <p>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TCPClientControler() throws IOException, ClassNotFoundException
	{
		setClient(getConfig());
	}

	/**
	 * Constructor which set the client settings and save them in the file SaveConfig.dat
	 * <p>
	 * @param host
	 * @param port
	 * </p><p>
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public TCPClientControler(String host, int port) throws ClassNotFoundException, IOException
	{
		SaveConfig(host,port);
		setClient(getConfig());
	}
	
	/**
	 * Method which save the configuration of the client in  the file SaveConfig.dat
	 * <p>
	 * @param host
	 * @param port
	 * </p><p>
	 * @throws IOException
	 */
	public void SaveConfig(String host, int port) throws IOException 
	{
		new Serialize("SaveConfigClient.dat").SerializeTCPClient(new TCPClient(host, port));
	}
	
	/**
	 * Method which get the configuration of the client in the file SaveConfigClient.dat
	 * <p>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TCPClient getConfig() throws IOException, ClassNotFoundException
	{
		return (new Serialize("SaveConfigClient.dat").deserializeTCPClient());
	}
	
	/**
	 * Method which start the thread to send the check
	 */
	public void sendCheckInOut() 
	{
		getClient().setSendCompany(false);
		new Thread(getClient()).start();
	}
	
	public void sendCompany() 
	{
		getClient().setSendCompany(true);
		new Thread(getClient()).start();
	}
	
	/**
	 * Getter of the client 
	 * <p>
	 * @return client
	 */
	public TCPClient getClient() {
		return client;
	}

	/**
	 * Setter of the client 
	 * <p>
	 * @param client
	 */
	public void setClient(TCPClient client) {
		this.client = client;
	}
}
