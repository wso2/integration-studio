/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyDataType <em>Property Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyAction <em>Property Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyScope <em>Property Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNamespacePrefix <em>Namespace Prefix</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#isBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getOM <em>OM</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueStringPattern <em>Value String Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueStringCapturingGroup <em>Value String Capturing Group</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNewPropertyName <em>New Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator()
 * @model
 * @generated
 */
public interface PropertyMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * The default value is <code>"New Property..."</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyName
	 * @see #setPropertyName(PropertyName)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_PropertyName()
	 * @model default="New Property..."
	 * @generated
	 */
	PropertyName getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyName
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(PropertyName value);

	/**
	 * Returns the value of the '<em><b>Property Data Type</b></em>' attribute.
	 * The default value is <code>"STRING"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType
	 * @see #setPropertyDataType(PropertyDataType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_PropertyDataType()
	 * @model default="STRING"
	 * @generated
	 */
	PropertyDataType getPropertyDataType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyDataType <em>Property Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType
	 * @see #getPropertyDataType()
	 * @generated
	 */
	void setPropertyDataType(PropertyDataType value);

	/**
	 * Returns the value of the '<em><b>Property Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction
	 * @see #setPropertyAction(PropertyAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_PropertyAction()
	 * @model
	 * @generated
	 */
	PropertyAction getPropertyAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyAction <em>Property Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction
	 * @see #getPropertyAction()
	 * @generated
	 */
	void setPropertyAction(PropertyAction value);

	/**
	 * Returns the value of the '<em><b>Property Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope
	 * @see #setPropertyScope(PropertyScope)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_PropertyScope()
	 * @model
	 * @generated
	 */
	PropertyScope getPropertyScope();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getPropertyScope <em>Property Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope
	 * @see #getPropertyScope()
	 * @generated
	 */
	void setPropertyScope(PropertyScope value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
	 * @see #setValueType(PropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	PropertyValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(PropertyValueType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_Value()
	 * @model default="value"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Namespace Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Prefix</em>' attribute.
	 * @see #setNamespacePrefix(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_NamespacePrefix()
	 * @model
	 * @generated
	 */
	String getNamespacePrefix();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNamespacePrefix <em>Namespace Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Prefix</em>' attribute.
	 * @see #getNamespacePrefix()
	 * @generated
	 */
	void setNamespacePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean</em>' attribute.
	 * @see #setBoolean(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_Boolean()
	 * @model
	 * @generated
	 */
	boolean isBoolean();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#isBoolean <em>Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean</em>' attribute.
	 * @see #isBoolean()
	 * @generated
	 */
	void setBoolean(boolean value);

	/**
	 * Returns the value of the '<em><b>OM</b></em>' attribute.
	 * The default value is <code>"<value/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OM</em>' attribute.
	 * @see #setOM(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_OM()
	 * @model default="<value/>"
	 * @generated
	 */
	String getOM();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getOM <em>OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OM</em>' attribute.
	 * @see #getOM()
	 * @generated
	 */
	void setOM(String value);

	/**
	 * Returns the value of the '<em><b>Value String Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value String Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value String Pattern</em>' attribute.
	 * @see #setValueStringPattern(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_ValueStringPattern()
	 * @model
	 * @generated
	 */
	String getValueStringPattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueStringPattern <em>Value String Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value String Pattern</em>' attribute.
	 * @see #getValueStringPattern()
	 * @generated
	 */
	void setValueStringPattern(String value);

	/**
	 * Returns the value of the '<em><b>Value String Capturing Group</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value String Capturing Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value String Capturing Group</em>' attribute.
	 * @see #setValueStringCapturingGroup(int)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_ValueStringCapturingGroup()
	 * @model default="0"
	 * @generated
	 */
	int getValueStringCapturingGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getValueStringCapturingGroup <em>Value String Capturing Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value String Capturing Group</em>' attribute.
	 * @see #getValueStringCapturingGroup()
	 * @generated
	 */
	void setValueStringCapturingGroup(int value);

	/**
	 * Returns the value of the '<em><b>New Property Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Property Name</em>' attribute.
	 * @see #setNewPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_NewPropertyName()
	 * @model default=""
	 * @generated
	 */
	String getNewPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getNewPropertyName <em>New Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Property Name</em>' attribute.
	 * @see #getNewPropertyName()
	 * @generated
	 */
	void setNewPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(PropertyMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	PropertyMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(PropertyMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(PropertyMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	PropertyMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(PropertyMediatorOutputConnector value);

} // PropertyMediator
