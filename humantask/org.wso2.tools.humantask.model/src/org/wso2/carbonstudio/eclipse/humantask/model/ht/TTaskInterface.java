/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTask Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponseOperation <em>Response Operation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponsePortType <em>Response Port Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTaskInterface()
 * @model extendedMetaData="name='tTaskInterface' kind='elementOnly'"
 * @generated
 */
public interface TTaskInterface extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTaskInterface_Operation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='operation'"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' attribute.
	 * @see #setPortType(QName)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTaskInterface_PortType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='portType'"
	 * @generated
	 */
	QName getPortType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getPortType <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' attribute.
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(QName value);

	/**
	 * Returns the value of the '<em><b>Response Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Operation</em>' attribute.
	 * @see #setResponseOperation(String)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTaskInterface_ResponseOperation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='responseOperation'"
	 * @generated
	 */
	String getResponseOperation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponseOperation <em>Response Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Operation</em>' attribute.
	 * @see #getResponseOperation()
	 * @generated
	 */
	void setResponseOperation(String value);

	/**
	 * Returns the value of the '<em><b>Response Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Port Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Port Type</em>' attribute.
	 * @see #setResponsePortType(QName)
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTTaskInterface_ResponsePortType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='responsePortType'"
	 * @generated
	 */
	QName getResponsePortType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponsePortType <em>Response Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Port Type</em>' attribute.
	 * @see #getResponsePortType()
	 * @generated
	 */
	void setResponsePortType(QName value);

} // TTaskInterface
