/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface FilterMediatorPropertiesEditionPart {

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
	 * @return the conditionType
	 * 
	 */
	public Enumerator getConditionType();

	/**
	 * Init the conditionType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initConditionType(Object input, Enumerator current);

	/**
	 * Defines a new conditionType
	 * @param newValue the new conditionType to set
	 * 
	 */
	public void setConditionType(Enumerator newValue);


	/**
	 * @return the regex
	 * 
	 */
	public String getRegex();

	/**
	 * Defines a new regex
	 * @param newValue the new regex to set
	 * 
	 */
	public void setRegex(String newValue);




	// Start of user code for XPath specific getters and setters declaration
	public NamespacedProperty getXPath();
    
    public void setXPath(NamespacedProperty nameSpacedProperty);
    // End of user code
	// Start of user code for Source specific getters and setters declaration
    public NamespacedProperty getSource();
    
    public void setSource(NamespacedProperty nameSpacedProperty);    
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
