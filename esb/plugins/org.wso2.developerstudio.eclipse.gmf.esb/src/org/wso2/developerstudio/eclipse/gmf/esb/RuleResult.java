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
 * A representation of the model object '<em><b>Rule Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultCustomType <em>Result Custom Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultName <em>Result Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult()
 * @model
 * @generated
 */
public interface RuleResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * The default value is <code>"CUSTOM"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType
	 * @see #setResultType(RuleResultType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ResultType()
	 * @model default="CUSTOM"
	 * @generated
	 */
	RuleResultType getResultType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(RuleResultType value);

	/**
	 * Returns the value of the '<em><b>Result Custom Type</b></em>' attribute.
	 * The default value is <code>"custom_type"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Custom Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Custom Type</em>' attribute.
	 * @see #setResultCustomType(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ResultCustomType()
	 * @model default="custom_type"
	 * @generated
	 */
	String getResultCustomType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultCustomType <em>Result Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Custom Type</em>' attribute.
	 * @see #getResultCustomType()
	 * @generated
	 */
	void setResultCustomType(String value);

	/**
	 * Returns the value of the '<em><b>Result Name</b></em>' attribute.
	 * The default value is <code>"result_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Name</em>' attribute.
	 * @see #setResultName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ResultName()
	 * @model default="result_name"
	 * @generated
	 */
	String getResultName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getResultName <em>Result Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Name</em>' attribute.
	 * @see #getResultName()
	 * @generated
	 */
	void setResultName(String value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType
	 * @see #setValueType(RuleResultValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	RuleResultValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(RuleResultValueType value);

	/**
	 * Returns the value of the '<em><b>Value Literal</b></em>' attribute.
	 * The default value is <code>"value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Literal</em>' attribute.
	 * @see #setValueLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ValueLiteral()
	 * @model default="value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueLiteral <em>Value Literal</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueExpression <em>Value Expression</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleResult_ValueKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getValueKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleResult#getValueKey <em>Value Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Key</em>' containment reference.
	 * @see #getValueKey()
	 * @generated
	 */
	void setValueKey(RegistryKeyProperty value);

} // RuleResult
