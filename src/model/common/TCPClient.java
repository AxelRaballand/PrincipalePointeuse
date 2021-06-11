package model.common;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
/**
 * Class which create the client part of a TCP communication
 */
public class TCPClient extends TCPClientBuilder implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7818827221127223706L;
	/**
	 * Check which is send to the server
	 * <p>
	 * @see run()
	 * @see getCheck()
	 * @see setCheck(CheckInOut check)
	 * @see delSendError(CheckInOut check)
	 * @see addSendError(CheckInOut check)
	 */
	private CheckInOut check;
	
	/**
	 * Checks which couldn't be sent 
	 * <p>
	 * @see getSendError()
	 * @see addSendError(CheckInOut check)
	 * @see delSendError(CheckInOut check)
	 * @see delSendError(int indice)
	 * @see setSendError(ArrayList<CheckInOut> sendError)
	 */
	private static ArrayList<CheckInOut> sendError = new ArrayList<CheckInOut>();
	
	/**
	 * Boolean value which allow us to know if the packet is send
	 * <p>
	 * @see isSend()
	 * @see setSend(boolean isSend)
	 */
	private boolean isSend;
	
	/**
	 * Constructor of the client 
	 * @throws SocketException
	 */
	public TCPClient() throws SocketException
	{
		super();
		setSend(false);
	}
	
	/**
	 * Constructor of client which include the network settings
	 * @param ip
	 * @param port
	 * @throws SocketException
	 */
	public TCPClient(String ip, int port) throws SocketException
	{
		super(ip,port);
		setSend(false);
	}
	
	/**
	 * Method which send a check to the server
	 */
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
			setSend(true);
			
			closeSocket();
			System.out.println("...Connection closed.");
		}
		catch (IOException e)
		{
			System.out.println("Erreur lors de l'envoie des donn�es. Stockage en cours...");
			addSendError(getCheck());
			System.out.println("Pointage enregistr� ! Il sera envoy� au prochain d�marage.");
			
		} 
		
	}
	
	/**
	 * Getter of check
	 * @return check 
	 */
	public CheckInOut getCheck() {
		return check;
	}
	
	/**
	 * Setter of check 
	 * @param check
	 */
	public void setCheck(CheckInOut check) {
		this.check = check;
	}

	/**
	 * Getter of send error
	 * @return sendError
	 */
	public static ArrayList<CheckInOut> getSendError() {
		return sendError;
	}
	
	/**
	 * Method which add a check to the sendError list
	 * @param check
	 */
	public static void addSendError(CheckInOut check)
	{
		sendError.add(check);
	}
	
	/**
	 * Method which remove a check from the sendError list
	 * @param check
	 */
	public void delSendError(CheckInOut check)
	{
		if (sendError.contains(check))
			sendError.remove(check);
	}

	/**
	 * Method which remove a check from the sendError list at an accurate index
	 * @param indice
	 * @throws Exception
	 */
	public void delSendError(int indice) throws Exception
	{
		if (indice < sendError.size() && indice >= 0)
			sendError.remove(indice);
		else
			throw new Exception("indice is out of bound!");
	}

	/**
	 * Setter of sendError
	 * @param sendError
	 */
	public void setSendError(ArrayList<CheckInOut> sendError) {
		TCPClient.sendError = sendError;
	}

	/**
	 * Getter of isSEnd
	 * @return isSend
	 */
	public boolean isSend() {
		return isSend;
	}

	/**
	 * Setter of isSend
	 * @param isSend
	 */
	public void setSend(boolean isSend) {
		this.isSend = isSend;
	}

	/**
	 * Method which create a file 
	 * @return true
	 * @return false 
	 */
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
