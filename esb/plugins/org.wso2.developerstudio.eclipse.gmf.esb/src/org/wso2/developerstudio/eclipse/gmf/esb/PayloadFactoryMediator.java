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
 * A representation of the model object '<em><b>Payload Factory Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayload <em>Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayloadKey <em>Payload Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getArgs <em>Args</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getMediaType <em>Media Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayloadFormat <em>Payload Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator()
 * @model
 * @generated
 */
public interface PayloadFactoryMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' attribute.
	 * @see #setPayload(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_Payload()
	 * @model
	 * @generated
	 */
	String getPayload();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayload <em>Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' attribute.
	 * @see #getPayload()
	 * @generated
	 */
	void setPayload(String value);

	/**
	 * Returns the value of the '<em><b>Payload Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Key</em>' containment reference.
	 * @see #setPayloadKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_PayloadKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPayloadKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayloadKey <em>Payload Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Key</em>' containment reference.
	 * @see #getPayloadKey()
	 * @generated
	 */
	void setPayloadKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<PayloadFactoryArgument> getArgs();

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(PayloadFactoryMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	PayloadFactoryMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(PayloadFactoryMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(PayloadFactoryMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	PayloadFactoryMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(PayloadFactoryMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Media Type</b></em>' attribute.
	 * The default value is <code>"xml"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Media Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
	 * @see #setMediaType(MediaType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_MediaType()
	 * @model default="xml"
	 * @generated
	 */
	MediaType getMediaType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getMediaType <em>Media Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Media Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
	 * @see #getMediaType()
	 * @generated
	 */
	void setMediaType(MediaType value);

	/**
	 * Returns the value of the '<em><b>Payload Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType
	 * @see #setPayloadFormat(PayloadFormatType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryMediator_PayloadFormat()
	 * @model
	 * @generated
	 */
	PayloadFormatType getPayloadFormat();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator#getPayloadFormat <em>Payload Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType
	 * @see #getPayloadFormat()
	 * @generated
	 */
	void setPayloadFormat(PayloadFormatType value);

} // PayloadFactoryMediator
