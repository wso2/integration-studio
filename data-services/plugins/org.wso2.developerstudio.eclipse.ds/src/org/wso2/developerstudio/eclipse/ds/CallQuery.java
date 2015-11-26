/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getWithParam <em>With Param</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getHref <em>Href</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getCallQuery()
 * @model extendedMetaData="name='call-query_._type' kind='mixed'"
 * @generated
 */
public interface CallQuery extends EObject {
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
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getCallQuery_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>With Param</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.ds.ParameterMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Param</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Param</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getCallQuery_WithParam()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='with-param' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ParameterMapping> getWithParam();

	/**
	 * Returns the value of the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Href</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Href</em>' attribute.
	 * @see #setHref(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getCallQuery_Href()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='href' namespace='##targetNamespace'"
	 * @generated
	 */
	String getHref();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(String value);

} // CallQuery
