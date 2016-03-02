/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Header Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getHeaderName <em>Header Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getHeaderAction <em>Header Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getScope <em>Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueInline <em>Value Inline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator()
 * @model
 * @generated
 */
public interface HeaderMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Header Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Name</em>' containment reference.
	 * @see #setHeaderName(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_HeaderName()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getHeaderName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getHeaderName <em>Header Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Name</em>' containment reference.
	 * @see #getHeaderName()
	 * @generated
	 */
	void setHeaderName(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Header Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction
	 * @see #setHeaderAction(HeaderAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_HeaderAction()
	 * @model
	 * @generated
	 */
	HeaderAction getHeaderAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getHeaderAction <em>Header Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction
	 * @see #getHeaderAction()
	 * @generated
	 */
	void setHeaderAction(HeaderAction value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType
	 * @see #setValueType(HeaderValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_ValueType()
	 * @model
	 * @generated
	 */
	HeaderValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(HeaderValueType value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ScopeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScopeType
	 * @see #setScope(ScopeType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_Scope()
	 * @model
	 * @generated
	 */
	ScopeType getScope();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScopeType
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeType value);

	/**
	 * Returns the value of the '<em><b>Value Literal</b></em>' attribute.
	 * The default value is <code>"header_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Literal</em>' attribute.
	 * @see #setValueLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_ValueLiteral()
	 * @model default="header_value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueLiteral <em>Value Literal</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(HeaderMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	HeaderMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(HeaderMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(HeaderMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	HeaderMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(HeaderMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Value Inline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Inline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Inline</em>' attribute.
	 * @see #setValueInline(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHeaderMediator_ValueInline()
	 * @model
	 * @generated
	 */
	String getValueInline();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator#getValueInline <em>Value Inline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Inline</em>' attribute.
	 * @see #getValueInline()
	 * @generated
	 */
	void setValueInline(String value);

} // HeaderMediator
