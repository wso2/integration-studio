/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface NameValueTypePropertyPropertiesEditionPart {

	/**
	 * @return the propertyName
	 * 
	 */
	public String getPropertyName();

	/**
	 * Defines a new propertyName
	 * @param newValue the new propertyName to set
	 * 
	 */
	public void setPropertyName(String newValue);


	/**
	 * @return the propertyValue
	 * 
	 */
	public String getPropertyValue();

	/**
	 * Defines a new propertyValue
	 * @param newValue the new propertyValue to set
	 * 
	 */
	public void setPropertyValue(String newValue);


	/**
	 * @return the propertyType
	 * 
	 */
	public Enumerator getPropertyType();

	/**
	 * Init the propertyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPropertyType(Object input, Enumerator current);

	/**
	 * Defines a new propertyType
	 * @param newValue the new propertyType to set
	 * 
	 */
	public void setPropertyType(Enumerator newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
