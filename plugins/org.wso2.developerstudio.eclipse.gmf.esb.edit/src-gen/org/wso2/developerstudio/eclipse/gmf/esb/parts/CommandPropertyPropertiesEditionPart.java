/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface CommandPropertyPropertiesEditionPart {

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
	 * @return the valueType
	 * 
	 */
	public Enumerator getValueType();

	/**
	 * Init the valueType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initValueType(Object input, Enumerator current);

	/**
	 * Defines a new valueType
	 * @param newValue the new valueType to set
	 * 
	 */
	public void setValueType(Enumerator newValue);


	/**
	 * @return the valueLiteral
	 * 
	 */
	public String getValueLiteral();

	/**
	 * Defines a new valueLiteral
	 * @param newValue the new valueLiteral to set
	 * 
	 */
	public void setValueLiteral(String newValue);


	/**
	 * @return the valueContextPropertyName
	 * 
	 */
	public String getValueContextPropertyName();

	/**
	 * Defines a new valueContextPropertyName
	 * @param newValue the new valueContextPropertyName to set
	 * 
	 */
	public void setValueContextPropertyName(String newValue);


	/**
	 * @return the contextAction
	 * 
	 */
	public Enumerator getContextAction();

	/**
	 * Init the contextAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initContextAction(Object input, Enumerator current);

	/**
	 * Defines a new contextAction
	 * @param newValue the new contextAction to set
	 * 
	 */
	public void setContextAction(Enumerator newValue);


	/**
	 * @return the messageAction
	 * 
	 */
	public Enumerator getMessageAction();

	/**
	 * Init the messageAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initMessageAction(Object input, Enumerator current);

	/**
	 * Defines a new messageAction
	 * @param newValue the new messageAction to set
	 * 
	 */
	public void setMessageAction(Enumerator newValue);




	// Start of user code for valueMessageElementXpath specific getters and setters declaration
	public NamespacedProperty getValueMessageElementXpath();
	
	public void setValueMessageElementXpath(NamespacedProperty nameSpacedProperty);
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
