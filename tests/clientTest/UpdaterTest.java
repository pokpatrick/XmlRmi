package clientTest;

import java.lang.reflect.Field;

import org.junit.*;

import client.Updater;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class UpdaterTest {
	private Updater updater;
	
	@Before
	public void setUp(){
		updater = new Updater();
	}
	
	
	@Test
	public void testSetValue() {
		try {
			Class<?> colorClass = Class.forName("test.Point");
			Field redField = colorClass.getField("a");
			updater.setValue(redField, null, 4.0);
		} catch(ClassNotFoundException e) {
			System.err.println(e + "error finding the class");
		} catch (NoSuchFieldException e) {
			System.err.println(e + "error in the class field");
		} catch (SecurityException e) {
			System.err.println(e + "security violation");
		}
	}
	
	@Test
	public void testGetValueFromElement() {
		updater.getValueFromElement(null);
	}
	
	@Test
	public void testGetValueFromElementAs() {
		updater.getValueFromElementAs(null, null);
	}
}
