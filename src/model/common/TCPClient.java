package model.common;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;

public class TCPClient extends TCPClientBuilder implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7818827221127223706L;
	private CheckInOut check; //check to send to server
	private static ArrayList<CheckInOut> sendError = new ArrayList<CheckInOut>(); //checks that couldn't be sent
		
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
			System.out.println("Erreur lors de l'envoie des données. Stockage en cours...");
			addSendError(getCheck());
			System.out.println("Pointage enregistré ! Il sera envoyé au prochain démarage.");
			
		} 
		
	}
	
	public CheckInOut getCheck() {
		return check;
	}
	
	public void setCheck(CheckInOut check) {
		this.check = check;
	}

	public static ArrayList<CheckInOut> getSendError() {
		return sendError;
	}
	
	public static void addSendError(CheckInOut check)
	{
		sendError.add(check);
	}
	
	public void delSendError(CheckInOut check)
	{
		if (sendError.contains(check))
			sendError.remove(check);
	}

	public void delSendError(int indice) throws Exception
	{
		if (indice < sendError.size() && indice >= 0)
			sendError.remove(indice);
		else
			throw new Exception("indice is out of bound!");
	}

	public void setSendError(ArrayList<CheckInOut> sendError) {
		TCPClient.sendError = sendError;
	}

	public static boolean isWaitingSend() {
		File file = new File("SaveCheck.dat");
		if(file.exists())
		{
			if (file.length() != 0)
			{
				return true;
			}
		}
		return false;
	}
}
