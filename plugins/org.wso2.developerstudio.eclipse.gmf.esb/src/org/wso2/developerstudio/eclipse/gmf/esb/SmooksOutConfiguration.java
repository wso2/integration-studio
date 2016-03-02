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
 * A representation of the model object '<em><b>Smooks Out Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getAction <em>Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getOutputMethod <em>Output Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration()
 * @model
 * @generated
 */
public interface SmooksOutConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType
	 * @see #setType(SmooksIODataType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration_Type()
	 * @model
	 * @generated
	 */
	SmooksIODataType getType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType
	 * @see #getType()
	 * @generated
	 */
	void setType(SmooksIODataType value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration_Expression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration_Property()
	 * @model
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction
	 * @see #setAction(ExpressionAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration_Action()
	 * @model
	 * @generated
	 */
	ExpressionAction getAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ExpressionAction value);

	/**
	 * Returns the value of the '<em><b>Output Method</b></em>' attribute.
	 * The default value is <code>""</code>.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSmooksOutConfiguration_OutputMethod()
	 * @model default=""
	 * @generated
	 */
	OutputMethod getOutputMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutConfiguration#getOutputMethod <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod
	 * @see #getOutputMethod()
	 * @generated
	 */
	void setOutputMethod(OutputMethod value);

} // SmooksOutConfiguration
