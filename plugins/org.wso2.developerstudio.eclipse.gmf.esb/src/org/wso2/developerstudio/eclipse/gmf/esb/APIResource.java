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
 * A representation of the model object '<em><b>API Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceInputConnectors <em>In Sequence Input Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultInputConnector <em>Fault Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUrlStyle <em>Url Style</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUrlMapping <em>Url Mapping</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowGet <em>Allow Get</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPost <em>Allow Post</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPut <em>Allow Put</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowDelete <em>Allow Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowOptions <em>Allow Options</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowHead <em>Allow Head</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPatch <em>Allow Patch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceType <em>In Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceKey <em>In Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceName <em>In Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceType <em>Out Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceKey <em>Out Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceName <em>Out Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceType <em>Fault Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceKey <em>Fault Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource()
 * @model
 * @generated
 */
public interface APIResource extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(APIResourceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	APIResourceInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(APIResourceInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(APIResourceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	APIResourceOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(APIResourceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Output Connector</em>' containment reference.
	 * @see #setOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_OutSequenceOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	APIResourceOutSequenceOutputConnector getOutSequenceOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Output Connector</em>' containment reference.
	 * @see #getOutSequenceOutputConnector()
	 * @generated
	 */
	void setOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector value);

	/**
	 * Returns the value of the '<em><b>In Sequence Input Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Input Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Input Connectors</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_InSequenceInputConnectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<APIResourceInSequenceInputConnector> getInSequenceInputConnectors();

	/**
	 * Returns the value of the '<em><b>Fault Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Input Connector</em>' containment reference.
	 * @see #setFaultInputConnector(APIResourceFaultInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_FaultInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	APIResourceFaultInputConnector getFaultInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultInputConnector <em>Fault Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Input Connector</em>' containment reference.
	 * @see #getFaultInputConnector()
	 * @generated
	 */
	void setFaultInputConnector(APIResourceFaultInputConnector value);

	/**
	 * Returns the value of the '<em><b>Url Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Style</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle
	 * @see #setUrlStyle(ApiResourceUrlStyle)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_UrlStyle()
	 * @model
	 * @generated
	 */
	ApiResourceUrlStyle getUrlStyle();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUrlStyle <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Style</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle
	 * @see #getUrlStyle()
	 * @generated
	 */
	void setUrlStyle(ApiResourceUrlStyle value);

	/**
	 * Returns the value of the '<em><b>Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Template</em>' attribute.
	 * @see #setUriTemplate(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_UriTemplate()
	 * @model
	 * @generated
	 */
	String getUriTemplate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUriTemplate <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Template</em>' attribute.
	 * @see #getUriTemplate()
	 * @generated
	 */
	void setUriTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Url Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Mapping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Mapping</em>' attribute.
	 * @see #setUrlMapping(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_UrlMapping()
	 * @model
	 * @generated
	 */
	String getUrlMapping();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getUrlMapping <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Mapping</em>' attribute.
	 * @see #getUrlMapping()
	 * @generated
	 */
	void setUrlMapping(String value);

	/**
	 * Returns the value of the '<em><b>Allow Get</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Get</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Get</em>' attribute.
	 * @see #setAllowGet(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowGet()
	 * @model
	 * @generated
	 */
	boolean isAllowGet();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowGet <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Get</em>' attribute.
	 * @see #isAllowGet()
	 * @generated
	 */
	void setAllowGet(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Post</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Post</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Post</em>' attribute.
	 * @see #setAllowPost(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowPost()
	 * @model
	 * @generated
	 */
	boolean isAllowPost();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPost <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Post</em>' attribute.
	 * @see #isAllowPost()
	 * @generated
	 */
	void setAllowPost(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Put</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Put</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Put</em>' attribute.
	 * @see #setAllowPut(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowPut()
	 * @model
	 * @generated
	 */
	boolean isAllowPut();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPut <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Put</em>' attribute.
	 * @see #isAllowPut()
	 * @generated
	 */
	void setAllowPut(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Delete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Delete</em>' attribute.
	 * @see #setAllowDelete(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowDelete()
	 * @model
	 * @generated
	 */
	boolean isAllowDelete();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowDelete <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Delete</em>' attribute.
	 * @see #isAllowDelete()
	 * @generated
	 */
	void setAllowDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Options</em>' attribute.
	 * @see #setAllowOptions(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowOptions()
	 * @model
	 * @generated
	 */
	boolean isAllowOptions();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowOptions <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Options</em>' attribute.
	 * @see #isAllowOptions()
	 * @generated
	 */
	void setAllowOptions(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Head</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Head</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Head</em>' attribute.
	 * @see #setAllowHead(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowHead()
	 * @model
	 * @generated
	 */
	boolean isAllowHead();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowHead <em>Allow Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Head</em>' attribute.
	 * @see #isAllowHead()
	 * @generated
	 */
	void setAllowHead(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Patch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Patch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Patch</em>' attribute.
	 * @see #setAllowPatch(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_AllowPatch()
	 * @model
	 * @generated
	 */
	boolean isAllowPatch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#isAllowPatch <em>Allow Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Patch</em>' attribute.
	 * @see #isAllowPatch()
	 * @generated
	 */
	void setAllowPatch(boolean value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' containment reference.
	 * @see #setContainer(ProxyServiceContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_Container()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceContainer getContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getContainer <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' containment reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ProxyServiceContainer value);

	/**
	 * Returns the value of the '<em><b>In Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setInSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_InSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getInSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceType <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getInSequenceType()
	 * @generated
	 */
	void setInSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>In Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Key</em>' containment reference.
	 * @see #setInSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_InSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getInSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceKey <em>In Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Key</em>' containment reference.
	 * @see #getInSequenceKey()
	 * @generated
	 */
	void setInSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>In Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Name</em>' attribute.
	 * @see #setInSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_InSequenceName()
	 * @model
	 * @generated
	 */
	String getInSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getInSequenceName <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Name</em>' attribute.
	 * @see #getInSequenceName()
	 * @generated
	 */
	void setInSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setOutSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_OutSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getOutSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceType <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getOutSequenceType()
	 * @generated
	 */
	void setOutSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Key</em>' containment reference.
	 * @see #setOutSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_OutSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOutSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceKey <em>Out Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Key</em>' containment reference.
	 * @see #getOutSequenceKey()
	 * @generated
	 */
	void setOutSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Name</em>' attribute.
	 * @see #setOutSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_OutSequenceName()
	 * @model
	 * @generated
	 */
	String getOutSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getOutSequenceName <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Name</em>' attribute.
	 * @see #getOutSequenceName()
	 * @generated
	 */
	void setOutSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #setFaultSequenceType(SequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_FaultSequenceType()
	 * @model
	 * @generated
	 */
	SequenceType getFaultSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceType <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SequenceType
	 * @see #getFaultSequenceType()
	 * @generated
	 */
	void setFaultSequenceType(SequenceType value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Key</em>' containment reference.
	 * @see #setFaultSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_FaultSequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getFaultSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceKey <em>Fault Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Key</em>' containment reference.
	 * @see #getFaultSequenceKey()
	 * @generated
	 */
	void setFaultSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Name</em>' attribute.
	 * @see #setFaultSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_FaultSequenceName()
	 * @model
	 * @generated
	 */
	String getFaultSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getFaultSequenceName <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Name</em>' attribute.
	 * @see #getFaultSequenceName()
	 * @generated
	 */
	void setFaultSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.Protocol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.Protocol
	 * @see #setProtocol(Protocol)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAPIResource_Protocol()
	 * @model
	 * @generated
	 */
	Protocol getProtocol();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource#getProtocol <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.Protocol
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(Protocol value);

} // APIResource
