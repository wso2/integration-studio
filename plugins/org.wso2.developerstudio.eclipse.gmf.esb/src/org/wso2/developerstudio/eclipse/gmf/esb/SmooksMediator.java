/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smooks Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getConfigurationKey <em>Configuration Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputType <em>Input Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputExpression <em>Input Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputType <em>Output Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputExpression <em>Output Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputProperty <em>Output Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputAction <em>Output Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputMethod <em>Output Method</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator()
 * @model
 * @generated
 */
public interface SmooksMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Configuration Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Key</em>' containment reference.
	 * @see #setConfigurationKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_ConfigurationKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getConfigurationKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getConfigurationKey <em>Configuration Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Key</em>' containment reference.
	 * @see #getConfigurationKey()
	 * @generated
	 */
	void setConfigurationKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType
	 * @see #setInputType(SmooksIODataType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_InputType()
	 * @model
	 * @generated
	 */
	SmooksIODataType getInputType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputType <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType
	 * @see #getInputType()
	 * @generated
	 */
	void setInputType(SmooksIODataType value);

	/**
	 * Returns the value of the '<em><b>Input Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Expression</em>' containment reference.
	 * @see #setInputExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_InputExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getInputExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputExpression <em>Input Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Expression</em>' containment reference.
	 * @see #getInputExpression()
	 * @generated
	 */
	void setInputExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Output Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType
	 * @see #setOutputType(SmooksOutputDataType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputType()
	 * @model
	 * @generated
	 */
	SmooksOutputDataType getOutputType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputType <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType
	 * @see #getOutputType()
	 * @generated
	 */
	void setOutputType(SmooksOutputDataType value);

	/**
	 * Returns the value of the '<em><b>Output Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Expression</em>' containment reference.
	 * @see #setOutputExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getOutputExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputExpression <em>Output Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Expression</em>' containment reference.
	 * @see #getOutputExpression()
	 * @generated
	 */
	void setOutputExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Output Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Property</em>' attribute.
	 * @see #setOutputProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputProperty()
	 * @model
	 * @generated
	 */
	String getOutputProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputProperty <em>Output Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Property</em>' attribute.
	 * @see #getOutputProperty()
	 * @generated
	 */
	void setOutputProperty(String value);

	/**
	 * Returns the value of the '<em><b>Output Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction
	 * @see #setOutputAction(ExpressionAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputAction()
	 * @model
	 * @generated
	 */
	ExpressionAction getOutputAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputAction <em>Output Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction
	 * @see #getOutputAction()
	 * @generated
	 */
	void setOutputAction(ExpressionAction value);

	/**
	 * Returns the value of the '<em><b>Output Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod
	 * @see #setOutputMethod(OutputMethod)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputMethod()
	 * @model
	 * @generated
	 */
	OutputMethod getOutputMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputMethod <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod
	 * @see #getOutputMethod()
	 * @generated
	 */
	void setOutputMethod(OutputMethod value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(SmooksMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SmooksMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(SmooksMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(SmooksMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SmooksMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(SmooksMediatorOutputConnector value);

} // SmooksMediator
