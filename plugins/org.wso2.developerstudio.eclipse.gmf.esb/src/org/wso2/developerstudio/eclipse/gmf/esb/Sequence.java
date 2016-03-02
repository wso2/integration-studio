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
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getKey <em>Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getIncludedMediators <em>Included Mediators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#isReceiveSequence <em>Receive Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#isDuplicate <em>Duplicate</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getReferringSequenceType <em>Referring Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getDynamicReferenceKey <em>Dynamic Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getStaticReferenceKey <em>Static Reference Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Mediator {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * The default value is <code>"<inline/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_Key()
	 * @model default="<inline/>"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(SequenceInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SequenceInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(SequenceInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceOutputConnector> getOutputConnector();

	/**
	 * Returns the value of the '<em><b>Included Mediators</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.Mediator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Mediators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Mediators</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_IncludedMediators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mediator> getIncludedMediators();

	/**
	 * Returns the value of the '<em><b>Receive Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive Sequence</em>' attribute.
	 * @see #setReceiveSequence(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_ReceiveSequence()
	 * @model
	 * @generated
	 */
	boolean isReceiveSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#isReceiveSequence <em>Receive Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive Sequence</em>' attribute.
	 * @see #isReceiveSequence()
	 * @generated
	 */
	void setReceiveSequence(boolean value);

	/**
	 * Returns the value of the '<em><b>Duplicate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duplicate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate</em>' attribute.
	 * @see #setDuplicate(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_Duplicate()
	 * @model
	 * @generated
	 */
	boolean isDuplicate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#isDuplicate <em>Duplicate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duplicate</em>' attribute.
	 * @see #isDuplicate()
	 * @generated
	 */
	void setDuplicate(boolean value);

	/**
	 * Returns the value of the '<em><b>Referring Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referring Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #setReferringSequenceType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_ReferringSequenceType()
	 * @model
	 * @generated
	 */
	KeyType getReferringSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getReferringSequenceType <em>Referring Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referring Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #getReferringSequenceType()
	 * @generated
	 */
	void setReferringSequenceType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Dynamic Reference Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Reference Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Reference Key</em>' containment reference.
	 * @see #setDynamicReferenceKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_DynamicReferenceKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getDynamicReferenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getDynamicReferenceKey <em>Dynamic Reference Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Reference Key</em>' containment reference.
	 * @see #getDynamicReferenceKey()
	 * @generated
	 */
	void setDynamicReferenceKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Static Reference Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Reference Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Reference Key</em>' containment reference.
	 * @see #setStaticReferenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSequence_StaticReferenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getStaticReferenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Sequence#getStaticReferenceKey <em>Static Reference Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Reference Key</em>' containment reference.
	 * @see #getStaticReferenceKey()
	 * @generated
	 */
	void setStaticReferenceKey(RegistryKeyProperty value);

} // Sequence
