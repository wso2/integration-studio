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
public interface OAuthMediatorPropertiesEditionPart {

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
	 * @return the remoteServiceUrl
	 * 
	 */
	public String getRemoteServiceUrl();

	/**
	 * Defines a new remoteServiceUrl
	 * @param newValue the new remoteServiceUrl to set
	 * 
	 */
	public void setRemoteServiceUrl(String newValue);


	/**
	 * @return the username
	 * 
	 */
	public String getUsername();

	/**
	 * Defines a new username
	 * @param newValue the new username to set
	 * 
	 */
	public void setUsername(String newValue);


	/**
	 * @return the password
	 * 
	 */
	public String getPassword();

	/**
	 * Defines a new password
	 * @param newValue the new password to set
	 * 
	 */
	public void setPassword(String newValue);





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
