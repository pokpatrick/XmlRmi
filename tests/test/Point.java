package test;

import tools.ObjectSerializable;
import xmlrmi.XMLRMIField;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class Point extends ObjectSerializable {
	@XMLRMIField(serializationName="a",serializationType="double")
	public double a ;
	@XMLRMIField(serializationName="b",serializationType="double")
	protected double b ;
	@XMLRMIField(serializationName="marque",serializationType="string")
	protected String marque ;

	public Point(double a, double b, String marque){
		this.a=a;
		this.b=b;
		this.marque=marque;
		//this.next=next;
	}

	public double getA(){
		return a;
	}

	@Override
	public String getMethodsToSerialize() {
		return "<methods><method language=\"java\">public void getFurther(){ a= a*2;	b= b*2;}</method></methods>";
	}

}
