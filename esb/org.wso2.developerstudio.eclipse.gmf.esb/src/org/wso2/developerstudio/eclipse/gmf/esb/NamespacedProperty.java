/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespaced Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#isSupportsDynamicXPaths <em>Supports Dynamic XPaths</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty()
 * @model
 * @generated
 */
public interface NamespacedProperty extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Pretty Name</b></em>' attribute.
	 * The default value is <code>"Namespaced Property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pretty Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pretty Name</em>' attribute.
	 * @see #setPrettyName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_PrettyName()
	 * @model default="Namespaced Property"
	 * @generated
	 */
	String getPrettyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPrettyName <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pretty Name</em>' attribute.
	 * @see #getPrettyName()
	 * @generated
	 */
	void setPrettyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * The default value is <code>"propertyName"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_PropertyName()
	 * @model default="propertyName"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value</em>' attribute.
	 * @see #setPropertyValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_PropertyValue()
	 * @model
	 * @generated
	 */
	String getPropertyValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getPropertyValue <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value</em>' attribute.
	 * @see #getPropertyValue()
	 * @generated
	 */
	void setPropertyValue(String value);

	/**
	 * Returns the value of the '<em><b>Namespaces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespaces</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespaces</em>' attribute.
	 * @see #setNamespaces(Map)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_Namespaces()
	 * @model dataType="org.wso2.developerstudio.eclipse.gmf.esb.Map<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	Map<String, String> getNamespaces();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#getNamespaces <em>Namespaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespaces</em>' attribute.
	 * @see #getNamespaces()
	 * @generated
	 */
	void setNamespaces(Map<String, String> value);

	/**
	 * Returns the value of the '<em><b>Supports Dynamic XPaths</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports Dynamic XPaths</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports Dynamic XPaths</em>' attribute.
	 * @see #setSupportsDynamicXPaths(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_SupportsDynamicXPaths()
	 * @model
	 * @generated
	 */
	boolean isSupportsDynamicXPaths();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#isSupportsDynamicXPaths <em>Supports Dynamic XPaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supports Dynamic XPaths</em>' attribute.
	 * @see #isSupportsDynamicXPaths()
	 * @generated
	 */
	void setSupportsDynamicXPaths(boolean value);

	/**
	 * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic</em>' attribute.
	 * @see #setDynamic(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNamespacedProperty_Dynamic()
	 * @model
	 * @generated
	 */
	boolean isDynamic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty#isDynamic <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic</em>' attribute.
	 * @see #isDynamic()
	 * @generated
	 */
	void setDynamic(boolean value);

} // NamespacedProperty
