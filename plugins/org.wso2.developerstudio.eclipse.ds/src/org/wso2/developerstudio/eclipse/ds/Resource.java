/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.Resource#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.Resource#getCallQuery <em>Call Query</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.Resource#getMethod <em>Method</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.Resource#getPath <em>Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.Resource#isReturnRequestStatus <em>Return Request Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource()
 * @model extendedMetaData="name='resource_._type' kind='mixed'"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Call Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Query</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Query</em>' containment reference.
	 * @see #setCallQuery(CallQuery)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource_CallQuery()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='call-query' namespace='##targetNamespace'"
	 * @generated
	 */
	CallQuery getCallQuery();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.Resource#getCallQuery <em>Call Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Query</em>' containment reference.
	 * @see #getCallQuery()
	 * @generated
	 */
	void setCallQuery(CallQuery value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource_Method()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='method' namespace='##targetNamespace'"
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.Resource#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='path' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.Resource#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Return Request Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Request Status</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Request Status</em>' attribute.
	 * @see #setReturnRequestStatus(boolean)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getResource_ReturnRequestStatus()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 *        extendedMetaData="kind='attribute' name='returnRequestStatus' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isReturnRequestStatus();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.Resource#isReturnRequestStatus <em>Return Request Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Request Status</em>' attribute.
	 * @see #isReturnRequestStatus()
	 * @generated
	 */
	void setReturnRequestStatus(boolean value);

} // Resource
