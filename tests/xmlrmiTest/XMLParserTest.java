package xmlrmiTest;

import java.util.ArrayList;

import org.junit.*;

import xmlrmi.XMLParser;


/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class XMLParserTest {
	private XMLParser xmlParser;
	
	@Before
	public void setUp(){
		xmlParser = new XMLParser();
	}
	
	@Test
	public void testParseResponse() {
		String response = "<?xml version=\"1.0\"?><methodResponse><params><param><value>void</value></param><param><value><object oid=\"http://localhost/2\" type=\"Objecttest.Point\">" + 
						"<fields><field name=\"a\"><value><double>3.8</double></value></field><field name=\"b\"><value><double>6.4</double></value></field><field name=\"marque\"><value><string>Point1</string></value></field>"+
						"</fields></object></value></param></params></methodResponse>";
		
		ArrayList<Object> array = xmlParser.parseResponse(response);
		
		Assert.assertEquals(2, array.size());
	}

}
