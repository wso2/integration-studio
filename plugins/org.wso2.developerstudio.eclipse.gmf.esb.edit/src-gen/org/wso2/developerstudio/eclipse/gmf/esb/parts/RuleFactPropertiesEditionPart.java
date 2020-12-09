/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface RuleFactPropertiesEditionPart {

	/**
	 * @return the factType
	 * 
	 */
	public Enumerator getFactType();

	/**
	 * Init the factType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initFactType(Object input, Enumerator current);

	/**
	 * Defines a new factType
	 * @param newValue the new factType to set
	 * 
	 */
	public void setFactType(Enumerator newValue);


	/**
	 * @return the factCustomType
	 * 
	 */
	public String getFactCustomType();

	/**
	 * Defines a new factCustomType
	 * @param newValue the new factCustomType to set
	 * 
	 */
	public void setFactCustomType(String newValue);


	/**
	 * @return the factName
	 * 
	 */
	public String getFactName();

	/**
	 * Defines a new factName
	 * @param newValue the new factName to set
	 * 
	 */
	public void setFactName(String newValue);


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




	// Start of user code for propertyExpression specific getters and setters declaration
	NamespacedProperty getPropertyExpression();

	void setPropertyExpression(NamespacedProperty nameSpacedProperty);
	// End of user code

	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

        // Start of user code for valueReferenceKey specific getters and setters declaration
        RegistryKeyProperty getValueReferenceKey();

        void setValueReferenceKey(RegistryKeyProperty registryKeyProperty);
        // End of user code

	// Start of user code for additional methods
	
	// End of user code

}
