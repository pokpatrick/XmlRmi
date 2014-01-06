package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import test.Point;
import test.Rectangle;
import xmlrmi.XMLParser;

/**
 * Classe correspondant au client
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class Client {
	private Socket socket = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	/**
	 * methode pour l'execution du client
	 * @param message le message à envoyer au server
	 */
	public void start(String message) {
		XMLParser xmlParser = new XMLParser();
		try {
			socket = new Socket("localhost", 2004);
			
			System.out.println(" : " + socket.getInetAddress().getHostName());
			System.out.println("Je suis le client. Je me connecte au server");
			
			//Envoyer le method call
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
			send(message);
			System.out.println("client> " + message);
			//Recuperer la method response
			message = (String)in.readObject();
			System.out.println("client> " + message);
			ArrayList<Object> paramsList = new ArrayList<Object>();
			paramsList = xmlParser.parseResponse(message);

			for(Object o : paramsList) {
				if(o.getClass().getName() == "test.Point")
				System.out.println(((Point)o).getA());
				if(o.getClass().getName() == "test.Rectangle")
					System.out.println(((Rectangle)o).getLongueur());
			}
		}catch(UnknownHostException e) {
			System.err.println(e + "from client : Host not found");
		}catch(IOException e) {
			System.err.println(e + "error with socket");
		}catch(ClassNotFoundException e) {
			System.err.println(e + "class is not found");
		}finally {
			//4: Closing connection
			try {
				in.close();
				out.close();
				socket.close();
			}catch(IOException ioException) {
				System.err.println(ioException + "error with socket");
			}
		}
	}

	/**
	 * Prend un message en entrée et l'envoye au server.
	 * @param message le message à envoyer vers le server 
	 */
	public void send(String message) {
		try {
			out.writeObject(message);
			out.flush();
		}catch(IOException ioException) {
			System.out.println(ioException + "error in/out with file");
		}
	}
}
