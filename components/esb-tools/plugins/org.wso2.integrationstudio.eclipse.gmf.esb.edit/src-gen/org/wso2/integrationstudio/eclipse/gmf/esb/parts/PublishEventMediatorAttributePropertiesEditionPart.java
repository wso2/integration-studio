/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface PublishEventMediatorAttributePropertiesEditionPart {

	/**
	 * @return the attributeName
	 * 
	 */
	public String getAttributeName();

	/**
	 * Defines a new attributeName
	 * @param newValue the new attributeName to set
	 * 
	 */
	public void setAttributeName(String newValue);


	/**
	 * @return the attributeValueType
	 * 
	 */
	public Enumerator getAttributeValueType();

	/**
	 * Init the attributeValueType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initAttributeValueType(Object input, Enumerator current);

	/**
	 * Defines a new attributeValueType
	 * @param newValue the new attributeValueType to set
	 * 
	 */
	public void setAttributeValueType(Enumerator newValue);


	/**
	 * @return the attributeValue
	 * 
	 */
	public String getAttributeValue();

	/**
	 * Defines a new attributeValue
	 * @param newValue the new attributeValue to set
	 * 
	 */
	public void setAttributeValue(String newValue);


	/**
	 * @return the attributeType
	 * 
	 */
	public Enumerator getAttributeType();

	/**
	 * Init the attributeType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initAttributeType(Object input, Enumerator current);

	/**
	 * Defines a new attributeType
	 * @param newValue the new attributeType to set
	 * 
	 */
	public void setAttributeType(Enumerator newValue);


	/**
	 * @return the defaultValue
	 * 
	 */
	public String getDefaultValue();

	/**
	 * Defines a new defaultValue
	 * @param newValue the new defaultValue to set
	 * 
	 */
	public void setDefaultValue(String newValue);




	// Start of user code for attributeExpression specific getters and setters declaration
    public NamespacedProperty getAttributeExpression();

    public void setAttributeExpression(NamespacedProperty nameSpacedProperty);
	// End of user code

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
