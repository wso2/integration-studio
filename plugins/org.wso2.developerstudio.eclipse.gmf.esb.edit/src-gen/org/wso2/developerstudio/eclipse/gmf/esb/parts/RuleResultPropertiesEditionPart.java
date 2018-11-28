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
public interface RuleResultPropertiesEditionPart {

	/**
	 * @return the resultType
	 * 
	 */
	public Enumerator getResultType();

	/**
	 * Init the resultType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initResultType(Object input, Enumerator current);

	/**
	 * Defines a new resultType
	 * @param newValue the new resultType to set
	 * 
	 */
	public void setResultType(Enumerator newValue);


	/**
	 * @return the resultCustomType
	 * 
	 */
	public String getResultCustomType();

	/**
	 * Defines a new resultCustomType
	 * @param newValue the new resultCustomType to set
	 * 
	 */
	public void setResultCustomType(String newValue);


	/**
	 * @return the resultName
	 * 
	 */
	public String getResultName();

	/**
	 * Defines a new resultName
	 * @param newValue the new resultName to set
	 * 
	 */
	public void setResultName(String newValue);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
