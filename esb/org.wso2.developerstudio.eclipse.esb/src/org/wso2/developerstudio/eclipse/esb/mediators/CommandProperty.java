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

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueContextPropertyName <em>Value Context Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueMessageElementXpath <em>Value Message Element Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getContextAction <em>Context Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getMessageAction <em>Message Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty()
 * @model
 * @generated
 */
public interface CommandProperty extends ModelObject {
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_PropertyName()
	 * @model default="property_name"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The default value is <code>"LITERAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType
	 * @see #setValueType(CommandPropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_ValueType()
	 * @model default="LITERAL"
	 * @generated
	 */
	CommandPropertyValueType getValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(CommandPropertyValueType value);

	/**
	 * Returns the value of the '<em><b>Value Literal</b></em>' attribute.
	 * The default value is <code>"literal_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Literal</em>' attribute.
	 * @see #setValueLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_ValueLiteral()
	 * @model default="literal_value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueLiteral <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Literal</em>' attribute.
	 * @see #getValueLiteral()
	 * @generated
	 */
	void setValueLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Value Context Property Name</b></em>' attribute.
	 * The default value is <code>"context_property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Context Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Context Property Name</em>' attribute.
	 * @see #setValueContextPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_ValueContextPropertyName()
	 * @model default="context_property_name"
	 * @generated
	 */
	String getValueContextPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueContextPropertyName <em>Value Context Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Context Property Name</em>' attribute.
	 * @see #getValueContextPropertyName()
	 * @generated
	 */
	void setValueContextPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Value Message Element Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Message Element Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Message Element Xpath</em>' containment reference.
	 * @see #setValueMessageElementXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_ValueMessageElementXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getValueMessageElementXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueMessageElementXpath <em>Value Message Element Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Message Element Xpath</em>' containment reference.
	 * @see #getValueMessageElementXpath()
	 * @generated
	 */
	void setValueMessageElementXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Context Action</b></em>' attribute.
	 * The default value is <code>"READ_AND_UPDATE_CONTEXT"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction
	 * @see #setContextAction(CommandPropertyContextAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_ContextAction()
	 * @model default="READ_AND_UPDATE_CONTEXT"
	 * @generated
	 */
	CommandPropertyContextAction getContextAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getContextAction <em>Context Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction
	 * @see #getContextAction()
	 * @generated
	 */
	void setContextAction(CommandPropertyContextAction value);

	/**
	 * Returns the value of the '<em><b>Message Action</b></em>' attribute.
	 * The default value is <code>"READ_AND_UPDATE_MESSAGE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction
	 * @see #setMessageAction(CommandPropertyMessageAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCommandProperty_MessageAction()
	 * @model default="READ_AND_UPDATE_MESSAGE"
	 * @generated
	 */
	CommandPropertyMessageAction getMessageAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getMessageAction <em>Message Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction
	 * @see #getMessageAction()
	 * @generated
	 */
	void setMessageAction(CommandPropertyMessageAction value);

} // CommandProperty
