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
 * A representation of the model object '<em><b>Property Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyDataType <em>Property Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyAction <em>Property Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyScope <em>Property Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueOM <em>Value OM</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringPattern <em>Value String Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringCapturingGroup <em>Value String Capturing Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator()
 * @model
 * @generated
 */
public interface PropertyMediator extends Mediator {

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * The default value is <code>"property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_PropertyName()
	 * @model default="property_name"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Data Type</b></em>' attribute.
	 * The default value is <code>"STRING"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType
	 * @see #setPropertyDataType(PropertyDataType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_PropertyDataType()
	 * @model default="STRING"
	 * @generated
	 */
	PropertyDataType getPropertyDataType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyDataType <em>Property Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType
	 * @see #getPropertyDataType()
	 * @generated
	 */
	void setPropertyDataType(PropertyDataType value);

	/**
	 * Returns the value of the '<em><b>Property Action</b></em>' attribute.
	 * The default value is <code>"SET"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction
	 * @see #setPropertyAction(PropertyAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_PropertyAction()
	 * @model default="SET"
	 * @generated
	 */
	PropertyAction getPropertyAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyAction <em>Property Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction
	 * @see #getPropertyAction()
	 * @generated
	 */
	void setPropertyAction(PropertyAction value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType
	 * @see #setValueType(PropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	PropertyValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(PropertyValueType value);

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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueLiteral()
	 * @model default="value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueLiteral <em>Value Literal</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Value OM</b></em>' attribute.
	 * The default value is <code>"<value/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value OM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value OM</em>' attribute.
	 * @see #setValueOM(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueOM()
	 * @model default="<value/>"
	 * @generated
	 */
	String getValueOM();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueOM <em>Value OM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value OM</em>' attribute.
	 * @see #getValueOM()
	 * @generated
	 */
	void setValueOM(String value);

	/**
	 * Returns the value of the '<em><b>Value String Pattern</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value String Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value String Pattern</em>' attribute.
	 * @see #setValueStringPattern(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueStringPattern()
	 * @model default=""
	 * @generated
	 */
	String getValueStringPattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringPattern <em>Value String Pattern</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_ValueStringCapturingGroup()
	 * @model default="0"
	 * @generated
	 */
	int getValueStringCapturingGroup();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringCapturingGroup <em>Value String Capturing Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value String Capturing Group</em>' attribute.
	 * @see #getValueStringCapturingGroup()
	 * @generated
	 */
	void setValueStringCapturingGroup(int value);

	/**
	 * Returns the value of the '<em><b>Property Scope</b></em>' attribute.
	 * The default value is <code>"SYNAPSE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope
	 * @see #setPropertyScope(PropertyScope)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPropertyMediator_PropertyScope()
	 * @model default="SYNAPSE"
	 * @generated
	 */
	PropertyScope getPropertyScope();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyScope <em>Property Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope
	 * @see #getPropertyScope()
	 * @generated
	 */
	void setPropertyScope(PropertyScope value);
} // PropertyMediator
