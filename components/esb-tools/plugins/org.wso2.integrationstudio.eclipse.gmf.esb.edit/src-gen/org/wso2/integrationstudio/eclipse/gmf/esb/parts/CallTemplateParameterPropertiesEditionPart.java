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
public interface CallTemplateParameterPropertiesEditionPart {

	/**
	 * @return the parameterName
	 * 
	 */
	public String getParameterName();

	/**
	 * Defines a new parameterName
	 * @param newValue the new parameterName to set
	 * 
	 */
	public void setParameterName(String newValue);


	/**
	 * @return the templateParameterType
	 * 
	 */
	public Enumerator getTemplateParameterType();

	/**
	 * Init the templateParameterType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTemplateParameterType(Object input, Enumerator current);

	/**
	 * Defines a new templateParameterType
	 * @param newValue the new templateParameterType to set
	 * 
	 */
	public void setTemplateParameterType(Enumerator newValue);


	/**
	 * @return the parameterValue
	 * 
	 */
	public String getParameterValue();

	/**
	 * Defines a new parameterValue
	 * @param newValue the new parameterValue to set
	 * 
	 */
	public void setParameterValue(String newValue);




	// Start of user code for parameterExpression specific getters and setters declaration
    public NamespacedProperty getParameterExpression();

    public void setParameterExpression(NamespacedProperty nameSpacedProperty);
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
