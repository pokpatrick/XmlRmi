package toolsTest;

import org.junit.*;

import test.Point;
import tools.ObjectsMap;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class ObjectMapTest {
	
	@Test
	public void testAddObject(){
		Point p1 = new Point (3,3, "a");
		ObjectsMap.addObject(p1, "http://localhost/");
		
		Assert.assertEquals(p1, ObjectsMap.getObject(ObjectsMap.getKey(p1)));
	}

}
