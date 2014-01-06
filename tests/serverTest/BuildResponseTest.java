package serverTest;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
import java.util.ArrayList;

import org.junit.*;

import server.BuildResponse;

public class BuildResponseTest {
	private BuildResponse myBuildResponse;
	
	@Before
	public void setUp() {
		myBuildResponse = new BuildResponse();
	}
	
	@Test
	public void testBuildParams() {
		String result = "<param><value><double>1.2</double></value></param><param><value><int>2</int></value></param><param><value><boolean>1</boolean></value></param>";
		ArrayList<Object> tab = new ArrayList<Object>();
		StringBuilder xmlResponse = new StringBuilder("");
		
		tab.add(1.2);
		tab.add(2);
		tab.add(true);
		Assert.assertEquals(result, myBuildResponse.buildParams(tab, xmlResponse));
	}
	
	@Test
	public void testBuildXmlResponse() {
		String result = "<methodResponse><params><param><value><double>1.2</double></value></param><param><value><int>2</int></value></param><param><value><boolean>1</boolean></value></param></params></methodResponse>";
		ArrayList<Object> tab = new ArrayList<Object>();
		
		tab.add(1.2);
		tab.add(2);
		tab.add(true);
		
		Assert.assertEquals(result, myBuildResponse.buildXmlResponse(tab));
	}
	
	@Test
	public void testBuildXmlFaultResponse() {
		String result = "";
		ArrayList<Object> tab = new ArrayList<Object>();
		System.out.println(myBuildResponse.buildXmlResponse(tab));
		
		Assert.assertEquals(result, false);
	}
}
