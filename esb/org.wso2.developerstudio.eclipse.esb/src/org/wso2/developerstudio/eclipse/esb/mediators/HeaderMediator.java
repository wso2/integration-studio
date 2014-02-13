/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Header Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderName <em>Header Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderAction <em>Header Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator()
 * @model
 * @generated
 */
public interface HeaderMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Header Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Name</em>' containment reference.
	 * @see #setHeaderName(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator_HeaderName()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getHeaderName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderName <em>Header Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Name</em>' containment reference.
	 * @see #getHeaderName()
	 * @generated
	 */
	void setHeaderName(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Header Action</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction
	 * @see #setHeaderAction(HeaderAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator_HeaderAction()
	 * @model default=""
	 * @generated
	 */
	HeaderAction getHeaderAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderAction <em>Header Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction
	 * @see #getHeaderAction()
	 * @generated
	 */
	void setHeaderAction(HeaderAction value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType
	 * @see #setValueType(HeaderValueType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator_ValueType()
	 * @model default=""
	 * @generated
	 */
	HeaderValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(HeaderValueType value);

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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator_ValueLiteral()
	 * @model default="header_value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueLiteral <em>Value Literal</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getHeaderMediator_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(NamespacedProperty value);

} // HeaderMediator
