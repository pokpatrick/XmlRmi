package serverTest;

import org.junit.*;

import server.BuildObject;
import test.Point;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class BuildObjectTest {
	private BuildObject myBuildObject;
	
	@Before
	public void setUp() {
		myBuildObject = new BuildObject("tests.Point");
	}
	
	@Test
	public void testBuildParams() {
		Class<Point> result = Point.class; 
		
		Assert.assertEquals(result.getName(), myBuildObject.getMyClass().getName());
	}

}
