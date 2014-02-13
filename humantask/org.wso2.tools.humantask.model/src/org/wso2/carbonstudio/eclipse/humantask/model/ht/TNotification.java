/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNotification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getInterface <em>Interface</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPresentationElements <em>Presentation Elements</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getRenderings <em>Renderings</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification()
 * @model extendedMetaData="name='tNotification' kind='elementOnly'"
 * @generated
 */
public interface TNotification extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(TNotificationInterface)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_Interface()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='interface' namespace='##targetNamespace'"
	 * @generated
	 */
	TNotificationInterface getInterface();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getInterface <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(TNotificationInterface value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' containment reference.
	 * @see #setPriority(TPriority)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_Priority()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='priority' namespace='##targetNamespace'"
	 * @generated
	 */
	TPriority getPriority();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPriority <em>Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' containment reference.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(TPriority value);

	/**
	 * Returns the value of the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>People Assignments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>People Assignments</em>' containment reference.
	 * @see #setPeopleAssignments(TPeopleAssignments)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_PeopleAssignments()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='peopleAssignments' namespace='##targetNamespace'"
	 * @generated
	 */
	TPeopleAssignments getPeopleAssignments();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPeopleAssignments <em>People Assignments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People Assignments</em>' containment reference.
	 * @see #getPeopleAssignments()
	 * @generated
	 */
	void setPeopleAssignments(TPeopleAssignments value);

	/**
	 * Returns the value of the '<em><b>Presentation Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presentation Elements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation Elements</em>' containment reference.
	 * @see #setPresentationElements(TPresentationElements)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_PresentationElements()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='presentationElements' namespace='##targetNamespace'"
	 * @generated
	 */
	TPresentationElements getPresentationElements();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPresentationElements <em>Presentation Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Elements</em>' containment reference.
	 * @see #getPresentationElements()
	 * @generated
	 */
	void setPresentationElements(TPresentationElements value);

	/**
	 * Returns the value of the '<em><b>Renderings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderings</em>' containment reference.
	 * @see #setRenderings(TRenderings)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_Renderings()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='renderings' namespace='##targetNamespace'"
	 * @generated
	 */
	TRenderings getRenderings();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getRenderings <em>Renderings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renderings</em>' containment reference.
	 * @see #getRenderings()
	 * @generated
	 */
	void setRenderings(TRenderings value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTNotification_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TNotification
