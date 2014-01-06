package serverTest;

import org.junit.*;

import server.MethodCaller;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class MethodCallerTest {
	private MethodCaller myMethodCaller;
	
	@Before
	public void setUp() {
		myMethodCaller = new MethodCaller();
	}

	@Test
	public void testCallMethod() {

		myMethodCaller.callMethod("display", null, null);
		System.out.println(myMethodCaller.callMethod("display", null, null));
		Assert.assertEquals(1, 2);
	}
}
