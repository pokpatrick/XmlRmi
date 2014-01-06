package client;

/**
 * Classe pour la contruction de l'appel de methode.
 * 
 * @author      Guerline Jean-Baptiste
 * @author      Patrick Pok
 */
public class BuildCall {
	
	/**
	 * Construit le xml des paramètres de l'objet
	 * @param objects la liste des objets à sérialiser
	 * @return les paramètres de l'objets sous forme sérialisés
	 */
	public String buildParams(Object[] objects) {
		String s = "";
		Serializer serializer = new Serializer();
		
		for(Object object : objects) {
			s += "<param>\n" + serializer.serialize(object) + "</param>\n";
		}
		return "<params>\n" + s + "</params>\n";
	}
	
	/**
	 * Construit le xml des methodes de l'objet
	 * @param method le nom de la methode
	 * @return la methode de l'objets sous forme sérialisés
	 */
	public String buildMethod(String method) {
		return "<methodName>" + method + "</methodName>\n";
	}
	
	/**
	* Construit le xml de la methode avec les parametres correspondants
	* @param method la chaine represantant la methode
	* @param objects les differents parametres de la methode
	* @return le format XML de l'appel de la methods
	*/
	public String buildMethodCall(String method, Object[] objects) {
		String s = "";
		
		s += buildMethod(method);
		s += buildParams(objects);
		return "<?xml version=\"1.0\"?>\n<methodCall>\n" + s + "</methodCall>";
	}
}