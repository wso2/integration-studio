/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EJB Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getBeanstalk <em>Beanstalk</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getMethod <em>Method</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdType <em>Session Id Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdLiteral <em>Session Id Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdExpression <em>Session Id Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#isRemove <em>Remove</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getJNDIName <em>JNDI Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getMethodArguments <em>Method Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator()
 * @model
 * @generated
 */
public interface EJBMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(EJBMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EJBMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(EJBMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(EJBMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EJBMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(EJBMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Beanstalk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beanstalk</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beanstalk</em>' attribute.
	 * @see #setBeanstalk(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_Beanstalk()
	 * @model
	 * @generated
	 */
	String getBeanstalk();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getBeanstalk <em>Beanstalk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beanstalk</em>' attribute.
	 * @see #getBeanstalk()
	 * @generated
	 */
	void setBeanstalk(String value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_Method()
	 * @model
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Session Id Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Id Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
	 * @see #setSessionIdType(PropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_SessionIdType()
	 * @model
	 * @generated
	 */
	PropertyValueType getSessionIdType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdType <em>Session Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Id Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
	 * @see #getSessionIdType()
	 * @generated
	 */
	void setSessionIdType(PropertyValueType value);

	/**
	 * Returns the value of the '<em><b>Session Id Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Id Literal</em>' attribute.
	 * @see #setSessionIdLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_SessionIdLiteral()
	 * @model
	 * @generated
	 */
	String getSessionIdLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdLiteral <em>Session Id Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Id Literal</em>' attribute.
	 * @see #getSessionIdLiteral()
	 * @generated
	 */
	void setSessionIdLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Session Id Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Id Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Id Expression</em>' containment reference.
	 * @see #setSessionIdExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_SessionIdExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSessionIdExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getSessionIdExpression <em>Session Id Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Id Expression</em>' containment reference.
	 * @see #getSessionIdExpression()
	 * @generated
	 */
	void setSessionIdExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove</em>' attribute.
	 * @see #setRemove(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_Remove()
	 * @model
	 * @generated
	 */
	boolean isRemove();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#isRemove <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' attribute.
	 * @see #isRemove()
	 * @generated
	 */
	void setRemove(boolean value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_Target()
	 * @model
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

	/**
	 * Returns the value of the '<em><b>JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JNDI Name</em>' attribute.
	 * @see #setJNDIName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_JNDIName()
	 * @model
	 * @generated
	 */
	String getJNDIName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator#getJNDIName <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JNDI Name</em>' attribute.
	 * @see #getJNDIName()
	 * @generated
	 */
	void setJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>Method Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Arguments</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEJBMediator_MethodArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodArgument> getMethodArguments();

} // EJBMediator
