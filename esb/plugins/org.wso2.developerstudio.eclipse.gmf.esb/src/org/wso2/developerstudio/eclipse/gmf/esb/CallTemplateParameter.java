/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getTemplateParameterType <em>Template Parameter Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterExpression <em>Parameter Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallTemplateParameter()
 * @model
 * @generated
 */
public interface CallTemplateParameter extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Name</em>' attribute.
	 * @see #setParameterName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallTemplateParameter_ParameterName()
	 * @model
	 * @generated
	 */
	String getParameterName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterName <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Name</em>' attribute.
	 * @see #getParameterName()
	 * @generated
	 */
	void setParameterName(String value);

	/**
	 * Returns the value of the '<em><b>Template Parameter Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameter Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Parameter Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType
	 * @see #setTemplateParameterType(RuleOptionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallTemplateParameter_TemplateParameterType()
	 * @model
	 * @generated
	 */
	RuleOptionType getTemplateParameterType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getTemplateParameterType <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Parameter Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	void setTemplateParameterType(RuleOptionType value);

	/**
	 * Returns the value of the '<em><b>Parameter Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Value</em>' attribute.
	 * @see #setParameterValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallTemplateParameter_ParameterValue()
	 * @model
	 * @generated
	 */
	String getParameterValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterValue <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Value</em>' attribute.
	 * @see #getParameterValue()
	 * @generated
	 */
	void setParameterValue(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Expression</em>' containment reference.
	 * @see #setParameterExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallTemplateParameter_ParameterExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getParameterExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter#getParameterExpression <em>Parameter Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Expression</em>' containment reference.
	 * @see #getParameterExpression()
	 * @generated
	 */
	void setParameterExpression(NamespacedProperty value);

} // CallTemplateParameter
