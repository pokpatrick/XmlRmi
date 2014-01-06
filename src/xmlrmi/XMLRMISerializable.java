package xmlrmi;


/**
 * Interface des objets serialisable
 * 
* @author      Gurline Jean-Baptsite
* @author      Patrick Pok
 */

public interface XMLRMISerializable {
	
	public String toXML();
	public void updateFromXML(org.w3c.dom.Element theXML);
}
