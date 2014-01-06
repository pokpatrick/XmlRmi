package clientTest;

import client.BuildCall;
import org.junit.*;

import test.Point;

/** Test
 * 
* @author      Guerline Jean-Baptiste
* @author      Patrick Pok
 */
public class BuildCallTest {
	private BuildCall myBuildCall;
	
	@Before
	public void setUp() {
		myBuildCall = new BuildCall();
	}

	@Test
	public void testBuildParams1() {
		String result = "<params>\n<param>\n<value><int>2</int></value></param>\n<param>\n<value><double>1.3</double></value></param>\n</params>\n";
		Object[] myTab = {2, 1.3};
		
		Assert.assertEquals(result, myBuildCall.buildParams(myTab));
	}
	
	@Test
	public void testBuildParams2() {
		String result = "<params>\n<param>\n<value><boolean>1</boolean></value></param>\n<param>\n<value><dateTime.iso8601>20121118T18:11:01</dateTime.iso8601></value></param>\n</params>";
		Object[] myTab = {true, new Point(1.0, 2.0, "test")};
		
		System.out.println(result);
		System.out.println("--------------");
		System.out.println(myBuildCall.buildParams(myTab));
		
		Assert.assertEquals(result, myBuildCall.buildParams(myTab));
	}
	
	@Test
	public void testBuildMethod() {
		String result = "<methodName>display</methodName>\n";
		
		Assert.assertEquals(result, myBuildCall.buildMethod("display"));
	}
	
	@Test
	public void testBuildMethodCall() {
		String result = "<?xml version=\"1.0\"?>\n<methodCall>\n<methodName>display</methodName>\n<params>\n<param>\n<value><double>4.3</double></value></param>\n<param>\n<value><boolean>1</boolean></value></param>\n</params>\n</methodCall>";
		Object[] myTab= {4.3, true};

		Assert.assertEquals(result, myBuildCall.buildMethodCall("display", myTab));
	}
}
