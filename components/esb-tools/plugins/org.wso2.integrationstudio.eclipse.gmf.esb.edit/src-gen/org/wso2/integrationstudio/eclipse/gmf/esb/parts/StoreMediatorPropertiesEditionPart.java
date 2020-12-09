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
public interface StoreMediatorPropertiesEditionPart {

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
	 * @return the messageStore
	 * 
	 */
	public String getMessageStore();

	/**
	 * Defines a new messageStore
	 * @param newValue the new messageStore to set
	 * 
	 */
	public void setMessageStore(String newValue);


	/**
	 * @return the availableMessageStores
	 * 
	 */
	public String getAvailableMessageStores();

	/**
	 * Defines a new availableMessageStores
	 * @param newValue the new availableMessageStores to set
	 * 
	 */
	public void setAvailableMessageStores(String newValue);


	/**
	 * @return the SpecifyAs
	 * 
	 */
	public Enumerator getSpecifyAs();

	/**
	 * Init the SpecifyAs
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSpecifyAs(Object input, Enumerator current);

	/**
	 * Defines a new SpecifyAs
	 * @param newValue the new SpecifyAs to set
	 * 
	 */
	public void setSpecifyAs(Enumerator newValue);




	// Start of user code for onStoreSequence specific getters and setters declaration
    public RegistryKeyProperty getOnStoreSequence();

    public void setOnStoreSequence(RegistryKeyProperty registryKeyProperty);
	// End of user code
    
	// Start of user code for expression specific getters and setters declaration
    public NamespacedProperty getExpression();

    public void setExpression(NamespacedProperty nameSpacedProperty);
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
