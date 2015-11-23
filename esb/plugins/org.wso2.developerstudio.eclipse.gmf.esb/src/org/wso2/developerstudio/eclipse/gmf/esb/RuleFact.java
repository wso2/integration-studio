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
 * A representation of the model object '<em><b>Rule Fact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactType <em>Fact Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactCustomType <em>Fact Custom Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactName <em>Fact Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact()
 * @model
 * @generated
 */
public interface RuleFact extends EObject {
	/**
	 * Returns the value of the '<em><b>Fact Type</b></em>' attribute.
	 * The default value is <code>"CUSTOM"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fact Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType
	 * @see #setFactType(RuleFactType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_FactType()
	 * @model default="CUSTOM"
	 * @generated
	 */
	RuleFactType getFactType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactType <em>Fact Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fact Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType
	 * @see #getFactType()
	 * @generated
	 */
	void setFactType(RuleFactType value);

	/**
	 * Returns the value of the '<em><b>Fact Custom Type</b></em>' attribute.
	 * The default value is <code>"custom_type"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact Custom Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fact Custom Type</em>' attribute.
	 * @see #setFactCustomType(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_FactCustomType()
	 * @model default="custom_type"
	 * @generated
	 */
	String getFactCustomType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactCustomType <em>Fact Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fact Custom Type</em>' attribute.
	 * @see #getFactCustomType()
	 * @generated
	 */
	void setFactCustomType(String value);

	/**
	 * Returns the value of the '<em><b>Fact Name</b></em>' attribute.
	 * The default value is <code>"fact_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fact Name</em>' attribute.
	 * @see #setFactName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_FactName()
	 * @model default="fact_name"
	 * @generated
	 */
	String getFactName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getFactName <em>Fact Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fact Name</em>' attribute.
	 * @see #getFactName()
	 * @generated
	 */
	void setFactName(String value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType
	 * @see #setValueType(RuleFactValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	RuleFactValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(RuleFactValueType value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_ValueLiteral()
	 * @model default="value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueLiteral <em>Value Literal</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueExpression <em>Value Expression</em>}' containment reference.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFact_ValueKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getValueKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact#getValueKey <em>Value Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Key</em>' containment reference.
	 * @see #getValueKey()
	 * @generated
	 */
	void setValueKey(RegistryKeyProperty value);

} // RuleFact
