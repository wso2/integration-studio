/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XQuery Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getVariableType <em>Variable Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable()
 * @model
 * @generated
 */
public interface XQueryVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * The default value is <code>"variable_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_VariableName()
	 * @model default="variable_name"
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Variable Type</b></em>' attribute.
	 * The default value is <code>"STRING"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType
	 * @see #setVariableType(XQueryVariableType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_VariableType()
	 * @model default="STRING"
	 * @generated
	 */
	XQueryVariableType getVariableType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getVariableType <em>Variable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType
	 * @see #getVariableType()
	 * @generated
	 */
	void setVariableType(XQueryVariableType value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType
	 * @see #setValueType(XQueryVariableValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	XQueryVariableValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(XQueryVariableValueType value);

	/**
	 * Returns the value of the '<em><b>Value Literal</b></em>' attribute.
	 * The default value is <code>"literal_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Literal</em>' attribute.
	 * @see #setValueLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_ValueLiteral()
	 * @model default="literal_value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueLiteral <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Literal</em>' attribute.
	 * @see #getValueLiteral()
	 * @generated
	 */
	void setValueLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression</em>' containment reference.
	 * @see #setValueExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Value Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Key</em>' containment reference.
	 * @see #setValueKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryVariable_ValueKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getValueKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable#getValueKey <em>Value Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Key</em>' containment reference.
	 * @see #getValueKey()
	 * @generated
	 */
	void setValueKey(RegistryKeyProperty value);

} // XQueryVariable
