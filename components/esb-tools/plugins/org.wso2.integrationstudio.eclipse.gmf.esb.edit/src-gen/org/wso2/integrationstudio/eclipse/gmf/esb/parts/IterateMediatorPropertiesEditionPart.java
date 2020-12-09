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
public interface IterateMediatorPropertiesEditionPart {

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
	 * @return the iterateID
	 * 
	 */
	public String getIterateID();

	/**
	 * Defines a new iterateID
	 * @param newValue the new iterateID to set
	 * 
	 */
	public void setIterateID(String newValue);


	/**
	 * @return the sequentialMediation
	 * 
	 */
	public Boolean getSequentialMediation();

	/**
	 * Defines a new sequentialMediation
	 * @param newValue the new sequentialMediation to set
	 * 
	 */
	public void setSequentialMediation(Boolean newValue);


	/**
	 * @return the continueParent
	 * 
	 */
	public Boolean getContinueParent();

	/**
	 * Defines a new continueParent
	 * @param newValue the new continueParent to set
	 * 
	 */
	public void setContinueParent(Boolean newValue);


	/**
	 * @return the preservePayload
	 * 
	 */
	public Boolean getPreservePayload();

	/**
	 * Defines a new preservePayload
	 * @param newValue the new preservePayload to set
	 * 
	 */
	public void setPreservePayload(Boolean newValue);


	/**
	 * @return the sequenceType
	 * 
	 */
	public Enumerator getSequenceType();

	/**
	 * Init the sequenceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new sequenceType
	 * @param newValue the new sequenceType to set
	 * 
	 */
	public void setSequenceType(Enumerator newValue);


	/**
	 * @return the sequenceName
	 * 
	 */
	public String getSequenceName();

	/**
	 * Defines a new sequenceName
	 * @param newValue the new sequenceName to set
	 * 
	 */
	public void setSequenceName(String newValue);




	// Start of user code for iterateExpression specific getters and setters declaration
    public NamespacedProperty getIterateExpression();

    public void setIterateExpression(NamespacedProperty nameSpacedProperty);
    // End of user code
	// Start of user code for sequenceKey specific getters and setters declaration
    public RegistryKeyProperty getSequenceKey();

    public void setSequenceKey(RegistryKeyProperty registryKeyProperty);
    // End of user code
	// Start of user code for attachPath specific getters and setters declaration
    public NamespacedProperty getAttachPath();

    public void setAttachPath(NamespacedProperty nameSpacedProperty);
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
