/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;


// End of user code

/**
 * 
 * 
 */
public interface BAMMediatorPropertiesEditionPart {

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
	 * @return the serverProfile
	 * 
	 */
	public String getServerProfile();

	/**
	 * Defines a new serverProfile
	 * @param newValue the new serverProfile to set
	 * 
	 */
	public void setServerProfile(String newValue);


	/**
	 * @return the streamName
	 * 
	 */
	public String getStreamName();

	/**
	 * Defines a new streamName
	 * @param newValue the new streamName to set
	 * 
	 */
	public void setStreamName(String newValue);


	/**
	 * @return the streamVersion
	 * 
	 */
	public String getStreamVersion();

	/**
	 * Defines a new streamVersion
	 * @param newValue the new streamVersion to set
	 * 
	 */
	public void setStreamVersion(String newValue);





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
