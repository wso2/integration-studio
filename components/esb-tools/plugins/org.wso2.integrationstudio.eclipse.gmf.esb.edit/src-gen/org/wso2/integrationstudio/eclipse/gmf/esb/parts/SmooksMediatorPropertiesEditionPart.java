/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface SmooksMediatorPropertiesEditionPart {

	/**
	 * @return the inputType
	 * 
	 */
	public Enumerator getInputType();

	/**
	 * Init the inputType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInputType(Object input, Enumerator current);

	/**
	 * Defines a new inputType
	 * @param newValue the new inputType to set
	 * 
	 */
	public void setInputType(Enumerator newValue);


	/**
	 * @return the outputType
	 * 
	 */
	public Enumerator getOutputType();

	/**
	 * Init the outputType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOutputType(Object input, Enumerator current);

	/**
	 * Defines a new outputType
	 * @param newValue the new outputType to set
	 * 
	 */
	public void setOutputType(Enumerator newValue);


	/**
	 * @return the outputProperty
	 * 
	 */
	public String getOutputProperty();

	/**
	 * Defines a new outputProperty
	 * @param newValue the new outputProperty to set
	 * 
	 */
	public void setOutputProperty(String newValue);


	/**
	 * @return the outputAction
	 * 
	 */
	public Enumerator getOutputAction();

	/**
	 * Init the outputAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOutputAction(Object input, Enumerator current);

	/**
	 * Defines a new outputAction
	 * @param newValue the new outputAction to set
	 * 
	 */
	public void setOutputAction(Enumerator newValue);


	/**
	 * @return the outputMethod
	 * 
	 */
	public Enumerator getOutputMethod();

	/**
	 * Init the outputMethod
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initOutputMethod(Object input, Enumerator current);

	/**
	 * Defines a new outputMethod
	 * @param newValue the new outputMethod to set
	 * 
	 */
	public void setOutputMethod(Enumerator newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);




	// Start of user code for inputExpresssion specific getters and setters declaration
	public void setInputExpression(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getInputExpression();
	
	// End of user code
	// Start of user code for outputExpression specific getters and setters declaration
	public void setOutputExpression(NamespacedProperty namespacedProperty);
    
    public NamespacedProperty getOutputExpression();
	// End of user code
	// Start of user code for configurationKey specific getters and setters declaration
	public void setConfigurationKey(RegistryKeyProperty registryKeyProperty);
	
	public RegistryKeyProperty getConfigurationKey();
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
