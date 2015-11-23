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
 * A representation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer#getChildren <em>Children</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer#getMessageMediator <em>Message Mediator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbServer()
 * @model
 * @generated
 */
public interface EsbServer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.EsbElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbServer_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<EsbElement> getChildren();

	/**
	 * Returns the value of the '<em><b>Message Mediator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Mediator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Mediator</em>' containment reference.
	 * @see #setMessageMediator(MessageMediator)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbServer_MessageMediator()
	 * @model containment="true"
	 * @generated
	 */
	MessageMediator getMessageMediator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer#getMessageMediator <em>Message Mediator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Mediator</em>' containment reference.
	 * @see #getMessageMediator()
	 * @generated
	 */
	void setMessageMediator(MessageMediator value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType
	 * @see #setType(ArtifactType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEsbServer_Type()
	 * @model
	 * @generated
	 */
	ArtifactType getType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbServer#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType
	 * @see #getType()
	 * @generated
	 */
	void setType(ArtifactType value);
	
	/**
	 * Sets the status of the lock attribute.
	 * @param editmode
	 */
	void setLockmode(boolean lockmode);

	/**
	 * Returns the status of the lock attribute.
	 * @return
	 */
	boolean isLockmode();

} // EsbServer
