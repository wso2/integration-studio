/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbElement#getCommentsList <em>Comments List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbElement()
 * @model abstract="true"
 * @generated
 */
public interface EsbElement extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbElement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Comments List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments List</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbElement_CommentsList()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getCommentsList();

	/**
	 * Default synapse namespace.
	 */
	String DEFAULT_SYNAPSE_NAMESPACE_URI = "http://synapse.apache.org/ns/2010/04/configuration";
	
	/**
	 * Whether synapse namespace prefix should be used or not.
	 */
	Boolean USE_SYNAPSE_NAMESPACE_PREFIX = false;
	
	/**
	 * Default synapse namespace prefix.
	 */
	String DEFAULT_SYNAPSE_NAMESPACE_PREFIX = "syn";
	
	/**
	 * Soap 1.1 envelope namespace uri.
	 */
	String SOAP_1_1_ENVELOPE_NAMESPACE_URI = "http://schemas.xmlsoap.org/soap/envelope/";
	
	/**
	 * Soap 1.1 envelope namespace prefix.
	 */
	String SOAP_1_1_ENVELOPE_NAMESPACE_PREFIX = "soap11Env";
	
	/**
	 * Soap 1.2 envelope namespace uri.
	 */
	String SOAP_1_2_ENVELOPE_NAMESPACE_URI = "http://www.w3.org/2003/05/soap-envelope";
	
	/**
	 * Soap 1.2 envelope namespace prefix.
	 */
	String SOAP_1_2_ENVELOPE_NAMESPACE_PREFIX = "soap12Env";
	
	/**
	 * Policy namespace URI.
	 */
	String WS_POLICY_NAMESPACE_URI = "http://schemas.xmlsoap.org/ws/2004/09/policy";
	
	/**
	 * Policy namespace prefix.
	 */
	String WS_POLICY_NAMESAPCE_PREFIX = "wsp";
	
	/**
	 * Throttle namespace URI.
	 */
	String WSO2_THROTTLE_NAMESPACE_URI = "http://www.wso2.org/products/wso2commons/throttle";
	
	/**
	 * Throttle namespace prefix.
	 */
	String WSO2_THROTTLE_NAMESPACE_PREFIX = "throttle";
	
	/**
	 * WS security utility namespace URI.
	 */
	String WSS_UTILITY_NAMESPACE_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
	
	/**
	 * WS security utility namespace prefix.
	 */
	String WSS_UTILITY_NAMESPACE_PREFIX = "wsu";
	
	/**
	 * Default property value used for xpath expressions.
	 */
	String DEFAULT_XPATH_PROPERTY_VALUE = "/default/xpath";
	
	/**
	 * Default property value used for namespaced expressions.
	 */
	String DEFAULT_EXPRESSION_PROPERTY_VALUE = "/default/expression";
	
	/**
	 * Default property value used for string literals.
	 */
	String DEFAULT_STRING_PROPERTY_VALUE = "default";
	
	/**
	 * Default property value used for registry keys.
	 */
	String DEFAULT_REGISTRY_KEY = "/default/key";
	
	/**
	 * Default property value used for sequence reference registry keys.
	 */
	String DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY = "/default/sequence";
	
	/**
	 * Default property value used for endpoint reference registry keys.
	 */
	String DEFAULT_ENDPOINT_REFERENCE_REGISTRY_KEY = "/default/endpoint";
	
	/**
	 * Default property value used for resource reference registry keys.
	 */
	String DEFAULT_RESOURCE_REFERENCE_REGISTRY_KEY = "/default/resource";
	
	/**
	 * Default property value used for on error registry keys. 
	 */
	String DEFAULT_ON_ERROR_REGISTRY_KEY = "";
	
} // EsbElement
