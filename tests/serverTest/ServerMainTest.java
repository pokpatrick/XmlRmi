package serverTest;

import server.Server;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class ServerMainTest {
	public static void main(String[] args) {
		Server s = new Server();
		
		s.receive();
	}
}
