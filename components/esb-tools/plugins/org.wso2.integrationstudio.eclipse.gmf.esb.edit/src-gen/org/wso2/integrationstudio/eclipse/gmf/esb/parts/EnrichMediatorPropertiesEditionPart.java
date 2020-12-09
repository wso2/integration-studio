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
public interface EnrichMediatorPropertiesEditionPart {

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
	 * @return the cloneSource
	 * 
	 */
	public Boolean getCloneSource();

	/**
	 * Defines a new cloneSource
	 * @param newValue the new cloneSource to set
	 * 
	 */
	public void setCloneSource(Boolean newValue);


	/**
	 * @return the sourceType
	 * 
	 */
	public Enumerator getSourceType();

	/**
	 * Init the sourceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSourceType(Object input, Enumerator current);

	/**
	 * Defines a new sourceType
	 * @param newValue the new sourceType to set
	 * 
	 */
	public void setSourceType(Enumerator newValue);


	/**
	 * @return the inlineType
	 * 
	 */
	public Enumerator getInlineType();

	/**
	 * Init the inlineType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initInlineType(Object input, Enumerator current);

	/**
	 * Defines a new inlineType
	 * @param newValue the new inlineType to set
	 * 
	 */
	public void setInlineType(Enumerator newValue);


	/**
	 * @return the sourceXML
	 * 
	 */
	public String getSourceXML();

	/**
	 * Defines a new sourceXML
	 * @param newValue the new sourceXML to set
	 * 
	 */
	public void setSourceXML(String newValue);


	/**
	 * @return the sourceProperty
	 * 
	 */
	public String getSourceProperty();

	/**
	 * Defines a new sourceProperty
	 * @param newValue the new sourceProperty to set
	 * 
	 */
	public void setSourceProperty(String newValue);


	/**
	 * @return the targetAction
	 * 
	 */
	public Enumerator getTargetAction();

	/**
	 * Init the targetAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTargetAction(Object input, Enumerator current);

	/**
	 * Defines a new targetAction
	 * @param newValue the new targetAction to set
	 * 
	 */
	public void setTargetAction(Enumerator newValue);


	/**
	 * @return the targetType
	 * 
	 */
	public Enumerator getTargetType();

	/**
	 * Init the targetType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTargetType(Object input, Enumerator current);

	/**
	 * Defines a new targetType
	 * @param newValue the new targetType to set
	 * 
	 */
	public void setTargetType(Enumerator newValue);


	/**
	 * @return the targetProperty
	 * 
	 */
	public String getTargetProperty();

	/**
	 * Defines a new targetProperty
	 * @param newValue the new targetProperty to set
	 * 
	 */
	public void setTargetProperty(String newValue);




	// Start of user code for sourceXPath specific getters and setters declaration
	public NamespacedProperty getSourceXPath();
    
    public void setSourceXPath(NamespacedProperty nameSpacedProperty);
	// End of user code
	// Start of user code for inlineRegistryKey specific getters and setters declaration
    public RegistryKeyProperty getInlineRegistryKey();
    
    public void setInlineRegistryKey(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for targetXPath specific getters and setters declaration
    public NamespacedProperty getTargetXPath();
    
    public void setTargetXPath(NamespacedProperty nameSpacedProperty);

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
