/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;

// End of user code

/**
 * 
 * 
 */
public interface EntitlementMediatorPropertiesEditionPart {

	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * 
	 * @param newValue
	 *            the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * 
	 * @param newValue
	 *            the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * 
	 * @param newValue
	 *            the value to remove
	 */
	public void removeToCommentsList(Object newValue);

	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * 
	 * @param newValue
	 *            the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);

	/**
	 * @return the entitlementServerURL
	 * 
	 */
	public String getEntitlementServerURL();

	/**
	 * Defines a new entitlementServerURL
	 * 
	 * @param newValue
	 *            the new entitlementServerURL to set
	 * 
	 */
	public void setEntitlementServerURL(String newValue);

	/**
	 * @return the username
	 * 
	 */
	public String getUsername();

	/**
	 * Defines a new username
	 * 
	 * @param newValue
	 *            the new username to set
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
	 * 
	 * @param newValue
	 *            the new password to set
	 * 
	 */
	public void setPassword(String newValue);

	/**
	 * @return the callbackHandler
	 * 
	 */
	public Enumerator getCallbackHandler();

	/**
	 * Init the callbackHandler
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initCallbackHandler(Object input, Enumerator current);

	/**
	 * Defines a new callbackHandler
	 * 
	 * @param newValue
	 *            the new callbackHandler to set
	 * 
	 */
	public void setCallbackHandler(Enumerator newValue);

	/**
	 * @return the callbackClassName
	 * 
	 */
	public String getCallbackClassName();

	/**
	 * Defines a new callbackClassName
	 * 
	 * @param newValue
	 *            the new callbackClassName to set
	 * 
	 */
	public void setCallbackClassName(String newValue);

	/**
	 * @return the thriftHost
	 * 
	 */
	public String getThriftHost();

	/**
	 * Defines a new thriftHost
	 * 
	 * @param newValue
	 *            the new thriftHost to set
	 * 
	 */
	public void setThriftHost(String newValue);

	/**
	 * @return the thriftPort
	 * 
	 */
	public String getThriftPort();

	/**
	 * Defines a new thriftPort
	 * 
	 * @param newValue
	 *            the new thriftPort to set
	 * 
	 */
	public void setThriftPort(String newValue);

	/**
	 * @return the entitlementClientType
	 * 
	 */
	public Enumerator getEntitlementClientType();

	/**
	 * Init the entitlementClientType
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initEntitlementClientType(Object input, Enumerator current);

	/**
	 * Defines a new entitlementClientType
	 * 
	 * @param newValue
	 *            the new entitlementClientType to set
	 * 
	 */
	public void setEntitlementClientType(Enumerator newValue);

	/**
	 * @return the onRejectSequenceType
	 * 
	 */
	public Enumerator getOnRejectSequenceType();

	/**
	 * Init the onRejectSequenceType
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initOnRejectSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new onRejectSequenceType
	 * 
	 * @param newValue
	 *            the new onRejectSequenceType to set
	 * 
	 */
	public void setOnRejectSequenceType(Enumerator newValue);

	/**
	 * @return the onAcceptSequenceType
	 * 
	 */
	public Enumerator getOnAcceptSequenceType();

	/**
	 * Init the onAcceptSequenceType
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initOnAcceptSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new onAcceptSequenceType
	 * 
	 * @param newValue
	 *            the new onAcceptSequenceType to set
	 * 
	 */
	public void setOnAcceptSequenceType(Enumerator newValue);

	/**
	 * @return the adviceSequenceType
	 * 
	 */
	public Enumerator getAdviceSequenceType();

	/**
	 * Init the adviceSequenceType
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initAdviceSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new adviceSequenceType
	 * 
	 * @param newValue
	 *            the new adviceSequenceType to set
	 * 
	 */
	public void setAdviceSequenceType(Enumerator newValue);

	/**
	 * @return the obligationsSequenceType
	 * 
	 */
	public Enumerator getObligationsSequenceType();

	/**
	 * Init the obligationsSequenceType
	 * 
	 * @param input
	 *            the viewer input
	 * @param current
	 *            the current value
	 */
	public void initObligationsSequenceType(Object input, Enumerator current);

	/**
	 * Defines a new obligationsSequenceType
	 * 
	 * @param newValue
	 *            the new obligationsSequenceType to set
	 * 
	 */
	public void setObligationsSequenceType(Enumerator newValue);

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * 
	 * @param newValue
	 *            the new description to set
	 * 
	 */
	public void setDescription(String newValue);

	// Start of user code for onRejectSequenceKey specific getters and setters
	// declaration
	public RegistryKeyProperty getOnRejectSequenceKey();

	public void setOnRejectSequenceKey(RegistryKeyProperty onRejectSequenceKey);
	// End of user code

	// Start of user code for onAcceptSequenceKey specific getters and setters
	// declaration
	public RegistryKeyProperty getOnAcceptSequenceKey();

	public void setOnAcceptSequenceKey(RegistryKeyProperty onAcceptSequenceKey);
	// End of user code

	// Start of user code for adviceSequenceKey specific getters and setters
	// declaration
	public RegistryKeyProperty getAdviceSequenceKey();

	public void setAdviceSequenceKey(RegistryKeyProperty adviceSequenceKey);
	// End of user code

	// Start of user code for obligationsSequenceKey specific getters and setters
	// declaration
	public RegistryKeyProperty getObligationsSequenceKey();

	public void getObligationsSequenceKey(RegistryKeyProperty obligationsSequenceKey);
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
