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
public interface FastXSLTMediatorPropertiesEditionPart {

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
	 * @return the fastXsltSchemaKeyType
	 * 
	 */
	public Enumerator getFastXsltSchemaKeyType();

	/**
	 * Init the fastXsltSchemaKeyType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initFastXsltSchemaKeyType(Object input, Enumerator current);

	/**
	 * Defines a new fastXsltSchemaKeyType
	 * @param newValue the new fastXsltSchemaKeyType to set
	 * 
	 */
	public void setFastXsltSchemaKeyType(Enumerator newValue);


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

	// Start of user code for fastXsltStaticSchemaKey specific getters and setters declaration
	public RegistryKeyProperty getFastXsltStaticSchemaKey();

    public void setFastXsltStaticSchemaKey (RegistryKeyProperty fastXsltStaticSchemaKey);
	// End of user code
    
	// Start of user code for fastXsltDynamicSchemaKey specific getters and setters declaration
    public NamespacedProperty getFastXsltDynamicSchemaKey();

    public void setFastXsltDynamicSchemaKey (NamespacedProperty fastXsltDynamicSchemaKey);
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
