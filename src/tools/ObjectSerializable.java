package tools;

import java.lang.reflect.Field;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import client.Serializer;
import client.Updater;

import xmlrmi.XMLRMISerializable;

/** Classe concrete representant un objet serializable
 * 
* @author      Guerline Jean-Baptiste
* @author      Patrick Pok
 */

public abstract class ObjectSerializable implements XMLRMISerializable {
	
	/**
	 * traduit ubn objet vers un format XML
	 * @return l'XML corespondant à un objet
	 */
	
	@Override
	public String toXML() {
		String resFields = "", res = "", intR, serializedValue = "";
		Class<?> innerClass = this.getClass();
		Field[] interFields = innerClass.getDeclaredFields();
		Serializer serializer = new Serializer();
		
		for(Field field : interFields) {
			field.setAccessible(true);
			intR = "";
			
			if(field.getName() != "oid"){
				try {
					serializedValue = serializer.serialize(field.get(this));
					intR = "\t<field name=\"" + field.getName() + "\">" + serializedValue + "</field>\n";
				}catch (IllegalAccessException e) {
					System.err.println(e + "error accessing field");
				}catch (IllegalArgumentException e) {
					System.err.println(e + "error in the argument");
				}
			}
			resFields += intR;
		}
		resFields = "<fields>\n" + resFields + "</fields>\n";
		res += resFields;
		res += getMethodsToSerialize();
		return "<object oid=\"" + ObjectsMap.getKey(this) + "\" type=\""+ this.getClass().getName() + "\">\n" + res + "</object>";
	}
	
	

	/**
	 *Met à jour les champs de l'objet
	 * @param l'XML corespondant à un objet
	 */
	@Override
	public void updateFromXML(Element theXML) {
		Updater updater= new Updater();
		NodeList fields = theXML.getElementsByTagName("fields");

		Element fields_element = (Element) fields.item(0);
		NodeList fieldNodes = fields_element.getElementsByTagName("field");

		for (int i = 0; i < fieldNodes.getLength(); i++) {

			Element elementField = (Element) fieldNodes.item(i);
			NamedNodeMap attributes= elementField.getAttributes();
			Attr nodeAttr = (Attr)attributes.item(0);

			// Get the new value of the object
			Element  elementValue = (Element)elementField.getElementsByTagName("value").item(0);
			NodeList valueChilds = elementValue.getChildNodes();
			Element valueTypeElement = (Element)valueChilds.item(0);
			
			
			//Update the fields
			try 
			{
				Field f1 = this.getClass().getDeclaredField(nodeAttr.getValue().toString());
				Object paramValue = updater.getValueFromElementAs(valueTypeElement, f1.getType());
				f1.setAccessible(true);
				updater.setValue(f1, this, paramValue);
			}
			catch (NoSuchFieldException e)
			{
				System.err.println(e + "error field doesn't exist");
			}
		}
	}
	
	
	/**
	 *Met à jour les champs de l'objet
	 * @return donne la version sérialisée des méthodes à ajouter à la sérialisation
	 */
	public String getMethodsToSerialize(){
		return "";
	}
}
