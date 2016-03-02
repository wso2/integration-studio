/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Store Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getMessageStore <em>Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getOnStoreSequence <em>On Store Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getAvailableMessageStores <em>Available Message Stores</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator()
 * @model
 * @generated
 */
public interface StoreMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Message Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Store</em>' attribute.
	 * @see #setMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator_MessageStore()
	 * @model
	 * @generated
	 */
	String getMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getMessageStore <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Store</em>' attribute.
	 * @see #getMessageStore()
	 * @generated
	 */
	void setMessageStore(String value);

	/**
	 * Returns the value of the '<em><b>On Store Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Store Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Store Sequence</em>' containment reference.
	 * @see #setOnStoreSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator_OnStoreSequence()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getOnStoreSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getOnStoreSequence <em>On Store Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Store Sequence</em>' containment reference.
	 * @see #getOnStoreSequence()
	 * @generated
	 */
	void setOnStoreSequence(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(StoreMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	StoreMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(StoreMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(StoreMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	StoreMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(StoreMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Available Message Stores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Message Stores</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Message Stores</em>' attribute.
	 * @see #setAvailableMessageStores(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getStoreMediator_AvailableMessageStores()
	 * @model
	 * @generated
	 */
	String getAvailableMessageStores();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator#getAvailableMessageStores <em>Available Message Stores</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Message Stores</em>' attribute.
	 * @see #getAvailableMessageStores()
	 * @generated
	 */
	void setAvailableMessageStores(String value);

} // StoreMediator
