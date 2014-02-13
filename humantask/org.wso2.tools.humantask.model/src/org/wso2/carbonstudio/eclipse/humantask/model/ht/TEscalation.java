/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TEscalation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getNotification <em>Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getLocalNotification <em>Local Notification</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getReassignment <em>Reassignment</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation()
 * @model extendedMetaData="name='tEscalation' kind='elementOnly'"
 * @generated
 */
public interface TEscalation extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(TBooleanExpr)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_Condition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace'"
	 * @generated
	 */
	TBooleanExpr getCondition();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(TBooleanExpr value);

	/**
	 * Returns the value of the '<em><b>To Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Parts</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_ToParts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='toParts' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TToParts> getToParts();

	/**
	 * Returns the value of the '<em><b>Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification</em>' containment reference.
	 * @see #setNotification(TNotification)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_Notification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='notification' namespace='##targetNamespace'"
	 * @generated
	 */
	TNotification getNotification();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getNotification <em>Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification</em>' containment reference.
	 * @see #getNotification()
	 * @generated
	 */
	void setNotification(TNotification value);

	/**
	 * Returns the value of the '<em><b>Local Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Notification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Notification</em>' containment reference.
	 * @see #setLocalNotification(TLocalNotification)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_LocalNotification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='localNotification' namespace='##targetNamespace'"
	 * @generated
	 */
	TLocalNotification getLocalNotification();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getLocalNotification <em>Local Notification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Notification</em>' containment reference.
	 * @see #getLocalNotification()
	 * @generated
	 */
	void setLocalNotification(TLocalNotification value);

	/**
	 * Returns the value of the '<em><b>Reassignment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reassignment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reassignment</em>' containment reference.
	 * @see #setReassignment(TReassignment)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_Reassignment()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='reassignment' namespace='##targetNamespace'"
	 * @generated
	 */
	TReassignment getReassignment();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getReassignment <em>Reassignment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reassignment</em>' containment reference.
	 * @see #getReassignment()
	 * @generated
	 */
	void setReassignment(TReassignment value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTEscalation_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TEscalation
