/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Payload Factory Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentType <em>Argument Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentValue <em>Argument Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentExpression <em>Argument Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getEvaluator <em>Evaluator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryArgument()
 * @model
 * @generated
 */
public interface PayloadFactoryArgument extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Argument Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType
	 * @see #setArgumentType(PayloadFactoryArgumentType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryArgument_ArgumentType()
	 * @model
	 * @generated
	 */
	PayloadFactoryArgumentType getArgumentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentType <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType
	 * @see #getArgumentType()
	 * @generated
	 */
	void setArgumentType(PayloadFactoryArgumentType value);

	/**
	 * Returns the value of the '<em><b>Argument Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Value</em>' attribute.
	 * @see #setArgumentValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryArgument_ArgumentValue()
	 * @model
	 * @generated
	 */
	String getArgumentValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentValue <em>Argument Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Value</em>' attribute.
	 * @see #getArgumentValue()
	 * @generated
	 */
	void setArgumentValue(String value);

	/**
	 * Returns the value of the '<em><b>Argument Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Expression</em>' containment reference.
	 * @see #setArgumentExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryArgument_ArgumentExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getArgumentExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getArgumentExpression <em>Argument Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Expression</em>' containment reference.
	 * @see #getArgumentExpression()
	 * @generated
	 */
	void setArgumentExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Evaluator</b></em>' attribute.
	 * The default value is <code>"xml"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluator</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
	 * @see #setEvaluator(MediaType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPayloadFactoryArgument_Evaluator()
	 * @model default="xml"
	 * @generated
	 */
	MediaType getEvaluator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument#getEvaluator <em>Evaluator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluator</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
	 * @see #getEvaluator()
	 * @generated
	 */
	void setEvaluator(MediaType value);

} // PayloadFactoryArgument
