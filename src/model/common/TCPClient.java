package model.common;

import java.io.*;
import java.net.SocketException;

public class TCPClient extends TCPClientBuilder implements Runnable
{
	private CheckInOut check; //company to send to server
	
	public TCPClient() throws SocketException
	{
		super();
	}
	
	public TCPClient(String ip, int port) throws SocketException
	{
		super(ip,port);
	}
	
	public void run()
	{
		try
		{
			System.out.println("TCPClient started ...");
			setSocket();
			System.out.println("Client is connected.");
			
			System.out.println("...Sending data...");
			OutputStream out = getS().getOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(check);
			System.out.println("Data send !");
			
			closeSocket();
			System.out.println("...Connection closed.");
		}
		catch (IOException e)
		{
			System.out.println("Erreur lors de l'envoie des donn�es. Stockage en cours...");
			Serialize serializer = new Serialize("SaveCheck.dat");
			try 
			{
				serializer.serializeCheck(getCheck());
				System.out.println("Pointage enregistr� ! Il sera envoy� au prochain d�marage.");
			} 
			catch (IOException e1) 
			{
				System.out.println("Erreurs de sauvegarder des donn�es, veuillez recommencez l'op�ration.");
			}
		} 
		
	}
	
	public CheckInOut getCheck() {
		return check;
	}
	
	public void setCheck(CheckInOut check) {
		this.check = check;
	}
}
