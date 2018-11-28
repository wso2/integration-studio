/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface AggregateMediatorPropertiesEditionPart {

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
	 * @return the aggregateID
	 * 
	 */
	public String getAggregateID();

	/**
	 * Defines a new aggregateID
	 * @param newValue the new aggregateID to set
	 * 
	 */
	public void setAggregateID(String newValue);


	/**
	 * @return the completionTimeout
	 * 
	 */
	public String getCompletionTimeout();

	/**
	 * Defines a new completionTimeout
	 * @param newValue the new completionTimeout to set
	 * 
	 */
	public void setCompletionTimeout(String newValue);


	/**
	 * @return the completionMinMessagesType
	 * 
	 */
	public Enumerator getCompletionMinMessagesType();

	/**
	 * Init the completionMinMessagesType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initCompletionMinMessagesType(Object input, Enumerator current);

	/**
	 * Defines a new completionMinMessagesType
	 * @param newValue the new completionMinMessagesType to set
	 * 
	 */
	public void setCompletionMinMessagesType(Enumerator newValue);


	/**
	 * @return the completionMaxMessagesType
	 * 
	 */
	public Enumerator getCompletionMaxMessagesType();

	/**
	 * Init the completionMaxMessagesType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initCompletionMaxMessagesType(Object input, Enumerator current);

	/**
	 * Defines a new completionMaxMessagesType
	 * @param newValue the new completionMaxMessagesType to set
	 * 
	 */
	public void setCompletionMaxMessagesType(Enumerator newValue);


	/**
	 * @return the completionMinMessagesValue
	 * 
	 */
	public String getCompletionMinMessagesValue();

	/**
	 * Defines a new completionMinMessagesValue
	 * @param newValue the new completionMinMessagesValue to set
	 * 
	 */
	public void setCompletionMinMessagesValue(String newValue);


	/**
	 * @return the completionMaxMessagesValue
	 * 
	 */
	public String getCompletionMaxMessagesValue();

	/**
	 * Defines a new completionMaxMessagesValue
	 * @param newValue the new completionMaxMessagesValue to set
	 * 
	 */
	public void setCompletionMaxMessagesValue(String newValue);


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
	 * @return the enclosingElementProperty
	 * 
	 */
	public String getEnclosingElementProperty();

	/**
	 * Defines a new enclosingElementProperty
	 * @param newValue the new enclosingElementProperty to set
	 * 
	 */
	public void setEnclosingElementProperty(String newValue);





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
