package xmlrmi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation des champs de l objet a serialiser
 * 
* @author      Gurline Jean-Baptsite
* @author      Patrick Pok
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XMLRMIField {
    
	String serializationName(); // nom à utiliser dans la sérialisation XML-RMI
    String serializationType(); // type XML-RMI à utiliser dans la sérialisation
}
