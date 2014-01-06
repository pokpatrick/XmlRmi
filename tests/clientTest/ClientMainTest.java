package clientTest;

import org.junit.Assert;
import org.junit.Test;
import test.Rectangle;
import tools.ObjectsMap;
import client.BuildCall;
import client.Client;


/** Test
 * 
* @author      Guerline Jean-Baptiste
* @author      Patrick Pok
 */
public class ClientMainTest {
	
	@Test
	public void testClient1() {
		Rectangle r1= new Rectangle(1, 3);
		ObjectsMap.addObject(r1, "http://localhost/" );
		Object[] objects = { r1, 1.3};
		
		BuildCall buildCall = new BuildCall();
		String callXml = buildCall.buildMethodCall("changeRectangle", objects);
		Client c = new Client();
		
		c.start(callXml);
		float result = r1.getLargeur();
		
		Assert.assertTrue(result == 6);
	}
	
	
}
