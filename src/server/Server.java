package server;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import xmlrmi.XMLParser;


/**
 * Classe correspondant au serveur
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class Server {
	private ServerSocket socket = null;
	private Socket connection = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String methodCall;


	public void receive() {
		ArrayList<Object> arrayParams = new ArrayList<Object>(); 
		String methodName;
		MethodCaller methodCaller = new MethodCaller();
		XMLParser xmlParser = new XMLParser();
		
		try
		{
			socket = new ServerSocket(2004, 10);
			System.out.println("Je suis le serveur. J'attends qu'un client se conecte");
			connection = socket.accept();
			System.out.println("Quelqu'un s'est connecté : " + connection.getInetAddress().getHostName());
			
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			try
			{
				methodCall = (String)in.readObject();
				methodName = xmlParser.parseCall(methodCall, arrayParams);
				String response = methodCaller.callMethod(methodName, arrayParams, this);
				send(response);
				
			}catch(ClassNotFoundException classnot){
				System.err.println("format not recognized");
			}
		}catch (IOException e) {
			System.err.println(e + "error in/out");
		}finally {
			//Fermer la connection
			try{
				in.close();
				out.close();
				socket.close();
			}catch(IOException ioException) {
				ioException.printStackTrace();
			}
		}	
	}

	public void send(String message){
		try{
			out.writeObject(message);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	public void changeRectangle(Object o, double d){
		Method method;
		try {
			method = o.getClass().getDeclaredMethod("doubleTaille");
			method.invoke(o, (Object[])null);
		} catch (NoSuchMethodException e) {
			System.err.println(e + "error the methode does not exist");
		} catch (SecurityException e) {
			System.err.println(e + "security violation");
		} catch (IllegalAccessException e) {
			System.err.println(e + "error accessing the argument");
		} catch (IllegalArgumentException e) {
			System.err.println(e + "error in the argument");
		} catch (InvocationTargetException e) {
			System.err.println(e + "error invoke methode");
		}
	}
	
	public void movePoint(Object o){
		Method method;
		try {
			method = o.getClass().getDeclaredMethod("getFurther");
			method.invoke(o,(Object[])null );
		} catch (NoSuchMethodException e) {
			System.err.println(e + "error the methode does not exist");
		} catch (SecurityException e) {
			System.err.println(e + "security violation");
		} catch (IllegalAccessException e) {
			System.err.println(e + "error accessing the argument");
		} catch (IllegalArgumentException e) {
			System.err.println(e + "error in the argument");
		} catch (InvocationTargetException e) {
			System.err.println(e + "error invoke methode");
		}
	}


}
