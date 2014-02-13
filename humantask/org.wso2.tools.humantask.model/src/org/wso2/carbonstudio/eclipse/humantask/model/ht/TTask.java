/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTask</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getInterface <em>Interface</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPresentationElements <em>Presentation Elements</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getOutcome <em>Outcome</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getSearchBy <em>Search By</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getRenderings <em>Renderings</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDeadlines <em>Deadlines</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask()
 * @model extendedMetaData="name='tTask' kind='elementOnly'"
 * @generated
 */
public interface TTask extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(TTaskInterface)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Interface()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='interface' namespace='##targetNamespace'"
	 * @generated
	 */
	TTaskInterface getInterface();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getInterface <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(TTaskInterface value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Priority()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='priority' namespace='##targetNamespace'"
	 * @generated
	 */
	TPriority getPriority();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPriority <em>Priority</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_PeopleAssignments()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='peopleAssignments' namespace='##targetNamespace'"
	 * @generated
	 */
	TPeopleAssignments getPeopleAssignments();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPeopleAssignments <em>People Assignments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People Assignments</em>' containment reference.
	 * @see #getPeopleAssignments()
	 * @generated
	 */
	void setPeopleAssignments(TPeopleAssignments value);

	/**
	 * Returns the value of the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegation</em>' containment reference.
	 * @see #setDelegation(TDelegation)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Delegation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='delegation' namespace='##targetNamespace'"
	 * @generated
	 */
	TDelegation getDelegation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDelegation <em>Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegation</em>' containment reference.
	 * @see #getDelegation()
	 * @generated
	 */
	void setDelegation(TDelegation value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_PresentationElements()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='presentationElements' namespace='##targetNamespace'"
	 * @generated
	 */
	TPresentationElements getPresentationElements();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPresentationElements <em>Presentation Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation Elements</em>' containment reference.
	 * @see #getPresentationElements()
	 * @generated
	 */
	void setPresentationElements(TPresentationElements value);

	/**
	 * Returns the value of the '<em><b>Outcome</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outcome</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcome</em>' containment reference.
	 * @see #setOutcome(TQuery)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Outcome()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='outcome' namespace='##targetNamespace'"
	 * @generated
	 */
	TQuery getOutcome();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getOutcome <em>Outcome</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outcome</em>' containment reference.
	 * @see #getOutcome()
	 * @generated
	 */
	void setOutcome(TQuery value);

	/**
	 * Returns the value of the '<em><b>Search By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search By</em>' containment reference.
	 * @see #setSearchBy(TExpression)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_SearchBy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='searchBy' namespace='##targetNamespace'"
	 * @generated
	 */
	TExpression getSearchBy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getSearchBy <em>Search By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search By</em>' containment reference.
	 * @see #getSearchBy()
	 * @generated
	 */
	void setSearchBy(TExpression value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Renderings()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='renderings' namespace='##targetNamespace'"
	 * @generated
	 */
	TRenderings getRenderings();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getRenderings <em>Renderings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renderings</em>' containment reference.
	 * @see #getRenderings()
	 * @generated
	 */
	void setRenderings(TRenderings value);

	/**
	 * Returns the value of the '<em><b>Deadlines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadlines</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadlines</em>' containment reference.
	 * @see #setDeadlines(TDeadlines)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Deadlines()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='deadlines' namespace='##targetNamespace'"
	 * @generated
	 */
	TDeadlines getDeadlines();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDeadlines <em>Deadlines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadlines</em>' containment reference.
	 * @see #getDeadlines()
	 * @generated
	 */
	void setDeadlines(TDeadlines value);

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
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTask_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TTask
