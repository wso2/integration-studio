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
public interface HeaderMediatorPropertiesEditionPart {

	/**
	 * @return the headerAction
	 * 
	 */
	public Enumerator getHeaderAction();

	/**
	 * Init the headerAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initHeaderAction(Object input, Enumerator current);

	/**
	 * Defines a new headerAction
	 * @param newValue the new headerAction to set
	 * 
	 */
	public void setHeaderAction(Enumerator newValue);


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
	 * @return the scope
	 * 
	 */
	public Enumerator getScope();

	/**
	 * Init the scope
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initScope(Object input, Enumerator current);

	/**
	 * Defines a new scope
	 * @param newValue the new scope to set
	 * 
	 */
	public void setScope(Enumerator newValue);


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
	 * @return the value Inline
	 * 
	 */
	public String getValueInline();

	/**
	 * Defines a new value Inline
	 * @param newValue the new value Inline to set
	 * 
	 */
	public void setValueInline(String newValue);


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




	// Start of user code for header Name specific getters and setters declaration
	public NamespacedProperty getHeaderName();
	       
	public void setHeaderName(NamespacedProperty namespacedProperty);

	// End of user code
	// Start of user code for value Expression specific getters and setters declaration
	public NamespacedProperty getValueExpression();
	       
	public void setValueExpression(NamespacedProperty namespacedProperty);
	
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
