/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface XQueryVariablePropertiesEditionPart {

	/**
	 * @return the variableName
	 * 
	 */
	public String getVariableName();

	/**
	 * Defines a new variableName
	 * @param newValue the new variableName to set
	 * 
	 */
	public void setVariableName(String newValue);


	/**
	 * @return the variableType
	 * 
	 */
	public Enumerator getVariableType();

	/**
	 * Init the variableType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initVariableType(Object input, Enumerator current);

	/**
	 * Defines a new variableType
	 * @param newValue the new variableType to set
	 * 
	 */
	public void setVariableType(Enumerator newValue);


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




	// Start of user code for valueExpression specific getters and setters declaration
	public void setValueExpression(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getValueExpression();
	// End of user code
	// Start of user code for valueKey specific getters and setters declaration
	public void setValueKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getValueKey();
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
