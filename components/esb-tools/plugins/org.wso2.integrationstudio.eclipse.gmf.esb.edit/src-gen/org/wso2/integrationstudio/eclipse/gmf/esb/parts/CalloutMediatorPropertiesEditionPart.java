/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;

// End of user code

/**
 * 
 * 
 */
public interface CalloutMediatorPropertiesEditionPart {

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
	 * @return the passHeaders
	 * 
	 */
	public Boolean getPassHeaders();

	/**
	 * Defines a new passHeaders
	 * @param newValue the new passHeaders to set
	 * 
	 */
	public void setPassHeaders(Boolean newValue);


	/**
	 * @return the EndpointType
	 * 
	 */
	public Enumerator getEndpointType();

	/**
	 * Init the EndpointType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initEndpointType(Object input, Enumerator current);

	/**
	 * Defines a new EndpointType
	 * @param newValue the new EndpointType to set
	 * 
	 */
	public void setEndpointType(Enumerator newValue);


	/**
	 * @return the soapAction
	 * 
	 */
	public String getSoapAction();

	/**
	 * Defines a new soapAction
	 * @param newValue the new soapAction to set
	 * 
	 */
	public void setSoapAction(String newValue);


	/**
	 * @return the pathToAxis2Repository
	 * 
	 */
	public String getPathToAxis2Repository();

	/**
	 * Defines a new pathToAxis2Repository
	 * @param newValue the new pathToAxis2Repository to set
	 * 
	 */
	public void setPathToAxis2Repository(String newValue);


	/**
	 * @return the pathToAxis2xml
	 * 
	 */
	public String getPathToAxis2xml();

	/**
	 * Defines a new pathToAxis2xml
	 * @param newValue the new pathToAxis2xml to set
	 * 
	 */
	public void setPathToAxis2xml(String newValue);


	/**
	 * @return the initAxis2ClientOptions
	 * 
	 */
	public Boolean getInitAxis2ClientOptions();

	/**
	 * Defines a new initAxis2ClientOptions
	 * @param newValue the new initAxis2ClientOptions to set
	 * 
	 */
	public void setInitAxis2ClientOptions(Boolean newValue);


	/**
	 * @return the serviceURL
	 * 
	 */
	public String getServiceURL();

	/**
	 * Defines a new serviceURL
	 * @param newValue the new serviceURL to set
	 * 
	 */
	public void setServiceURL(String newValue);


	/**
	 * @return the payloadType
	 * 
	 */
	public Enumerator getPayloadType();

	/**
	 * Init the payloadType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPayloadType(Object input, Enumerator current);

	/**
	 * Defines a new payloadType
	 * @param newValue the new payloadType to set
	 * 
	 */
	public void setPayloadType(Enumerator newValue);


	/**
	 * @return the payloadProperty
	 * 
	 */
	public String getPayloadProperty();

	/**
	 * Defines a new payloadProperty
	 * @param newValue the new payloadProperty to set
	 * 
	 */
	public void setPayloadProperty(String newValue);


	/**
	 * @return the resultType
	 * 
	 */
	public Enumerator getResultType();

	/**
	 * Init the resultType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initResultType(Object input, Enumerator current);

	/**
	 * Defines a new resultType
	 * @param newValue the new resultType to set
	 * 
	 */
	public void setResultType(Enumerator newValue);


	/**
	 * @return the resultContextProperty
	 * 
	 */
	public String getResultContextProperty();

	/**
	 * Defines a new resultContextProperty
	 * @param newValue the new resultContextProperty to set
	 * 
	 */
	public void setResultContextProperty(String newValue);


	/**
	 * @return the policies
	 * 
	 */
	public Enumerator getPolicies();

	/**
	 * Init the policies
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initPolicies(Object input, Enumerator current);

	/**
	 * Defines a new policies
	 * @param newValue the new policies to set
	 * 
	 */
	public void setPolicies(Enumerator newValue);


	/**
	 * @return the securityType
	 * 
	 */
	public Enumerator getSecurityType();

	/**
	 * Init the securityType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initSecurityType(Object input, Enumerator current);

	/**
	 * Defines a new securityType
	 * @param newValue the new securityType to set
	 * 
	 */
	public void setSecurityType(Enumerator newValue);




	// Start of user code for Address Endpoint specific getters and setters declaration
    public RegistryKeyProperty getAddressEndpoint();
    
    public void setAddressEndpoint(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for Payload Message Xpath specific getters and setters declaration
    public NamespacedProperty getPayloadMessageXpath();
    
    public void setPayloadMessageXpath(NamespacedProperty namespacedProperty);
	// End of user code
	// Start of user code for Result Message Xpath specific getters and setters declaration
    public NamespacedProperty getResultMessageXpath();
    
    public void setResultMessageXpath(NamespacedProperty namespacedProperty);
	// End of user code
	// Start of user code for Policy Key specific getters and setters declaration
    public RegistryKeyProperty getPolicyKey();
    
    public void setPolicyKey(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for Outbound Policy Key specific getters and setters declaration
    public RegistryKeyProperty getOutboundPolicyKey();
    
    public void setOutboundPolicyKey(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for Inbound Policy Key specific getters and setters declaration
    public RegistryKeyProperty getInboundPolicyKey();
    
    public void setInboundPolicyKey(RegistryKeyProperty registryKeyProperty);
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
