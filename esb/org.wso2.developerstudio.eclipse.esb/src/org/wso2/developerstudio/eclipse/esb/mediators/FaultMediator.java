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
 * A representation of the model object '<em><b>Fault Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getSoapVersion <em>Soap Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap11 <em>Fault Code Soap11</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringType <em>Fault String Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringValue <em>Fault String Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringExpression <em>Fault String Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultActor <em>Fault Actor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap12 <em>Fault Code Soap12</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonType <em>Fault Reason Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonValue <em>Fault Reason Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonExpression <em>Fault Reason Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailType <em>Fault Detail Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailValue <em>Fault Detail Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailExpression <em>Fault Detail Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator()
 * @model
 * @generated
 */
public interface FaultMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Soap Version</b></em>' attribute.
	 * The default value is <code>"SOAP_1_1"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion
	 * @see #setSoapVersion(FaultSoapVersion)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_SoapVersion()
	 * @model default="SOAP_1_1"
	 * @generated
	 */
	FaultSoapVersion getSoapVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getSoapVersion <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion
	 * @see #getSoapVersion()
	 * @generated
	 */
	void setSoapVersion(FaultSoapVersion value);

	/**
	 * Returns the value of the '<em><b>Fault Code Soap11</b></em>' attribute.
	 * The default value is <code>"VERSION_MISSMATCH"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Soap11</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Soap11</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11
	 * @see #setFaultCodeSoap11(FaultCodeSoap11)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultCodeSoap11()
	 * @model default="VERSION_MISSMATCH"
	 * @generated
	 */
	FaultCodeSoap11 getFaultCodeSoap11();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap11 <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Soap11</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11
	 * @see #getFaultCodeSoap11()
	 * @generated
	 */
	void setFaultCodeSoap11(FaultCodeSoap11 value);

	/**
	 * Returns the value of the '<em><b>Fault Code Soap12</b></em>' attribute.
	 * The default value is <code>"VERSION_MISSMATCH"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Code Soap12</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Code Soap12</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12
	 * @see #setFaultCodeSoap12(FaultCodeSoap12)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultCodeSoap12()
	 * @model default="VERSION_MISSMATCH"
	 * @generated
	 */
	FaultCodeSoap12 getFaultCodeSoap12();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap12 <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Code Soap12</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12
	 * @see #getFaultCodeSoap12()
	 * @generated
	 */
	void setFaultCodeSoap12(FaultCodeSoap12 value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Type</b></em>' attribute.
	 * The default value is <code>"VALUE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType
	 * @see #setFaultReasonType(FaultReasonType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultReasonType()
	 * @model default="VALUE"
	 * @generated
	 */
	FaultReasonType getFaultReasonType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonType <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType
	 * @see #getFaultReasonType()
	 * @generated
	 */
	void setFaultReasonType(FaultReasonType value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Value</b></em>' attribute.
	 * The default value is <code>"fault_reason"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Value</em>' attribute.
	 * @see #setFaultReasonValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultReasonValue()
	 * @model default="fault_reason"
	 * @generated
	 */
	String getFaultReasonValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonValue <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Value</em>' attribute.
	 * @see #getFaultReasonValue()
	 * @generated
	 */
	void setFaultReasonValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault Reason Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Reason Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Reason Expression</em>' containment reference.
	 * @see #setFaultReasonExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultReasonExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultReasonExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonExpression <em>Fault Reason Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Reason Expression</em>' containment reference.
	 * @see #getFaultReasonExpression()
	 * @generated
	 */
	void setFaultReasonExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Name</em>' attribute.
	 * @see #setRoleName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_RoleName()
	 * @model
	 * @generated
	 */
	String getRoleName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getRoleName <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Name</em>' attribute.
	 * @see #getRoleName()
	 * @generated
	 */
	void setRoleName(String value);

	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_NodeName()
	 * @model
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType
	 * @see #setFaultDetailType(FaultDetailType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultDetailType()
	 * @model
	 * @generated
	 */
	FaultDetailType getFaultDetailType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailType <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType
	 * @see #getFaultDetailType()
	 * @generated
	 */
	void setFaultDetailType(FaultDetailType value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Value</b></em>' attribute.
	 * The default value is <code>"fault_detail"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Value</em>' attribute.
	 * @see #setFaultDetailValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultDetailValue()
	 * @model default="fault_detail"
	 * @generated
	 */
	String getFaultDetailValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailValue <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Value</em>' attribute.
	 * @see #getFaultDetailValue()
	 * @generated
	 */
	void setFaultDetailValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault Detail Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Detail Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Detail Expression</em>' containment reference.
	 * @see #setFaultDetailExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultDetailExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultDetailExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailExpression <em>Fault Detail Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Detail Expression</em>' containment reference.
	 * @see #getFaultDetailExpression()
	 * @generated
	 */
	void setFaultDetailExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Fault String Type</b></em>' attribute.
	 * The default value is <code>"VALUE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType
	 * @see #setFaultStringType(FaultStringType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultStringType()
	 * @model default="VALUE"
	 * @generated
	 */
	FaultStringType getFaultStringType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringType <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType
	 * @see #getFaultStringType()
	 * @generated
	 */
	void setFaultStringType(FaultStringType value);

	/**
	 * Returns the value of the '<em><b>Fault String Value</b></em>' attribute.
	 * The default value is <code>"fault_string"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Value</em>' attribute.
	 * @see #setFaultStringValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultStringValue()
	 * @model default="fault_string"
	 * @generated
	 */
	String getFaultStringValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringValue <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Value</em>' attribute.
	 * @see #getFaultStringValue()
	 * @generated
	 */
	void setFaultStringValue(String value);

	/**
	 * Returns the value of the '<em><b>Fault String Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault String Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault String Expression</em>' containment reference.
	 * @see #setFaultStringExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultStringExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFaultStringExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringExpression <em>Fault String Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault String Expression</em>' containment reference.
	 * @see #getFaultStringExpression()
	 * @generated
	 */
	void setFaultStringExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Fault Actor</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Actor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Actor</em>' attribute.
	 * @see #setFaultActor(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getFaultMediator_FaultActor()
	 * @model default=""
	 * @generated
	 */
	String getFaultActor();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultActor <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Actor</em>' attribute.
	 * @see #getFaultActor()
	 * @generated
	 */
	void setFaultActor(String value);

} // FaultMediator
