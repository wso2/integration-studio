/**
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
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Smooks Out Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getAction <em>Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getOutputMethod <em>Output Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration()
 * @model
 * @generated
 */
public interface SmooksOutConfiguration extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType
	 * @see #setType(SmooksIODataType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration_Type()
	 * @model
	 * @generated
	 */
	SmooksIODataType getType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType
	 * @see #getType()
	 * @generated
	 */
	void setType(SmooksIODataType value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration_Expression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration_Property()
	 * @model
	 * @generated
	 */
	String getProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction
	 * @see #setAction(ExpressionAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration_Action()
	 * @model
	 * @generated
	 */
	ExpressionAction getAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ExpressionAction value);

	/**
	 * Returns the value of the '<em><b>Output Method</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod
	 * @see #setOutputMethod(OutputMethod)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSmooksOutConfiguration_OutputMethod()
	 * @model default=""
	 * @generated
	 */
	OutputMethod getOutputMethod();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getOutputMethod <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Method</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod
	 * @see #getOutputMethod()
	 * @generated
	 */
	void setOutputMethod(OutputMethod value);

} // SmooksOutConfiguration
