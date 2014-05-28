/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getColumn <em>Column</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getRequiredRoles <em>Required Roles</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping()
 * @model extendedMetaData="name='attribute_._type' kind='empty'"
 * @generated
 */
public interface AttributeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping_Column()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='column' namespace='##targetNamespace'"
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Required Roles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Roles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Roles</em>' attribute.
	 * @see #setRequiredRoles(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping_RequiredRoles()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='requiredRoles' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRequiredRoles();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getRequiredRoles <em>Required Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Roles</em>' attribute.
	 * @see #getRequiredRoles()
	 * @generated
	 */
	void setRequiredRoles(String value);

	/**
	 * Returns the value of the '<em><b>Xsd Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xsd Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xsd Type</em>' attribute.
	 * @see #setXsdType(String)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping_XsdType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='xsdType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getXsdType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getXsdType <em>Xsd Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xsd Type</em>' attribute.
	 * @see #getXsdType()
	 * @generated
	 */
	void setXsdType(String value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getAttributeMapping_Optional()
	 * @model default="false"
	 *        extendedMetaData="kind='attribute' name='optional' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

} // AttributeMapping
