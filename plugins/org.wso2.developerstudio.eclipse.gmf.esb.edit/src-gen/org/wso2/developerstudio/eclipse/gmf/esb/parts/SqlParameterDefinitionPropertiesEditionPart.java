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
public interface SqlParameterDefinitionPropertiesEditionPart {

	/**
	 * @return the dataType
	 * 
	 */
	public Enumerator getDataType();

	/**
	 * Init the dataType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initDataType(Object input, Enumerator current);

	/**
	 * Defines a new dataType
	 * @param newValue the new dataType to set
	 * 
	 */
	public void setDataType(Enumerator newValue);


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
	public void setValueExpression(NamespacedProperty nsp);
	
	public NamespacedProperty getValueExpression();
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
