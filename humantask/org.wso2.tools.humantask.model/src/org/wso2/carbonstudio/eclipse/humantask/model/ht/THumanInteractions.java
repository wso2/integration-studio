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
 * A representation of the model object '<em><b>THuman Interactions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getImport <em>Import</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getLogicalPeopleGroups <em>Logical People Groups</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTargetNamespace <em>Target Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions()
 * @model extendedMetaData="name='tHumanInteractions' kind='elementOnly'"
 * @generated
 */
public interface THumanInteractions extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference.
	 * @see #setExtensions(TExtensions)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_Extensions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='extensions' namespace='##targetNamespace'"
	 * @generated
	 */
	TExtensions getExtensions();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExtensions <em>Extensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extensions</em>' containment reference.
	 * @see #getExtensions()
	 * @generated
	 */
	void setExtensions(TExtensions value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_Import()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TImport> getImport();

	/**
	 * Returns the value of the '<em><b>Logical People Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical People Groups</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical People Groups</em>' containment reference.
	 * @see #setLogicalPeopleGroups(TLogicalPeopleGroups)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_LogicalPeopleGroups()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='logicalPeopleGroups' namespace='##targetNamespace'"
	 * @generated
	 */
	TLogicalPeopleGroups getLogicalPeopleGroups();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getLogicalPeopleGroups <em>Logical People Groups</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical People Groups</em>' containment reference.
	 * @see #getLogicalPeopleGroups()
	 * @generated
	 */
	void setLogicalPeopleGroups(TLogicalPeopleGroups value);

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference.
	 * @see #setTasks(TTasks)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_Tasks()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='tasks' namespace='##targetNamespace'"
	 * @generated
	 */
	TTasks getTasks();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTasks <em>Tasks</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tasks</em>' containment reference.
	 * @see #getTasks()
	 * @generated
	 */
	void setTasks(TTasks value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference.
	 * @see #setNotifications(TNotifications)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_Notifications()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='notifications' namespace='##targetNamespace'"
	 * @generated
	 */
	TNotifications getNotifications();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getNotifications <em>Notifications</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notifications</em>' containment reference.
	 * @see #getNotifications()
	 * @generated
	 */
	void setNotifications(TNotifications value);

	/**
	 * Returns the value of the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Language</em>' attribute.
	 * @see #setExpressionLanguage(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_ExpressionLanguage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='expressionLanguage'"
	 * @generated
	 */
	String getExpressionLanguage();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Language</em>' attribute.
	 * @see #getExpressionLanguage()
	 * @generated
	 */
	void setExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Language</em>' attribute.
	 * @see #setQueryLanguage(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_QueryLanguage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='queryLanguage'"
	 * @generated
	 */
	String getQueryLanguage();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getQueryLanguage <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Language</em>' attribute.
	 * @see #getQueryLanguage()
	 * @generated
	 */
	void setQueryLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Namespace</em>' attribute.
	 * @see #setTargetNamespace(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTHumanInteractions_TargetNamespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='attribute' name='targetNamespace'"
	 * @generated
	 */
	String getTargetNamespace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTargetNamespace <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Namespace</em>' attribute.
	 * @see #getTargetNamespace()
	 * @generated
	 */
	void setTargetNamespace(String value);

} // THumanInteractions
