package test;

import tools.ObjectSerializable;
import xmlrmi.XMLRMIField;

/** Test
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class Rectangle  extends ObjectSerializable {
	@XMLRMIField(serializationName="longueur",serializationType="double")
	protected float longueur ;
	@XMLRMIField(serializationName="largeur",serializationType="double")
	protected float largeur ;
	@XMLRMIField(serializationName="perimetre",serializationType="double")
	protected double perimetre ;
	
	public Rectangle(float longueur, float largeur){
		this.largeur=largeur;
		this.longueur=longueur;
	}
	
	public float getLongueur()
	{
		return longueur; 	
	}
	public float getLargeur(){
		return largeur;
	}
	
	public void doubleTaille() {
		longueur = longueur *2;
		largeur = largeur *2;
	}
	
	public String getMethodsToSerialize() {
		return "<methods><method language=\"java\">public void doubleTaille() { longueur = longueur *2; largeur = largeur *2; }</method></methods>";
	}

		

}
