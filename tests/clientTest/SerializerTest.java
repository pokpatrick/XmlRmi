package clientTest;

import java.util.Vector;

import org.junit.*;

import client.Serializer;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class SerializerTest {
	private Serializer serializer;
	
	@Before
	public void setUp(){
		 serializer= new Serializer();
	}
	
	@Test
	public void testSerialize1() {
		String result = "<value><int>3</int></value>";
		Integer obj = new Integer(3);

		Assert.assertEquals(result, serializer.serialize(obj));
	}
	
	@Test
	public void testSerialize2() {
		String result = "<value><boolean>1</boolean></value>";
		Boolean obj = true;
		
		Assert.assertEquals(result, serializer.serialize(obj));
	}
	
	@Test
	public void testSerialize3() {
		String result = "<value><array><data><value><double>3.4</double></value><value><double>3.14</double></value></array></data></value>";
		Vector<Double> obj = new Vector<Double>();
		obj.add(3.4);
		obj.add(3.14);

		Assert.assertEquals(result, serializer.serialize(obj));
	}
	
	@Test
	public void testGetCommonSuperClassFromArray() {
		String result = Number.class.getName();
		Number[] objs = {new Integer(3), new Double(3.14)};
		
		Assert.assertEquals(result, serializer.getCommonSuperClassFromArray(objs));
	}
}
