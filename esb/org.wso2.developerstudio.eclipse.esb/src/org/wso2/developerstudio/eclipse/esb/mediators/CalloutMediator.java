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

import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Callout Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getServiceURL <em>Service URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadType <em>Payload Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadRegistryKey <em>Payload Registry Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isPassHeaders <em>Pass Headers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isUseServerConfig <em>Use Server Config</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointKey <em>Endpoint Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator()
 * @model
 * @generated
 */
public interface CalloutMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Service URL</b></em>' attribute.
	 * The default value is <code>"service_url"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service URL</em>' attribute.
	 * @see #setServiceURL(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_ServiceURL()
	 * @model default="service_url"
	 * @generated
	 */
	String getServiceURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getServiceURL <em>Service URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service URL</em>' attribute.
	 * @see #getServiceURL()
	 * @generated
	 */
	void setServiceURL(String value);

	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * The default value is <code>"soap_action"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_SoapAction()
	 * @model default="soap_action"
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2xml</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2xml</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #setPathToAxis2xml(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PathToAxis2xml()
	 * @model default=""
	 * @generated
	 */
	String getPathToAxis2xml();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2xml</em>' attribute.
	 * @see #getPathToAxis2xml()
	 * @generated
	 */
	void setPathToAxis2xml(String value);

	/**
	 * Returns the value of the '<em><b>Path To Axis2 Repository</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Axis2 Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #setPathToAxis2Repository(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PathToAxis2Repository()
	 * @model default=""
	 * @generated
	 */
	String getPathToAxis2Repository();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Axis2 Repository</em>' attribute.
	 * @see #getPathToAxis2Repository()
	 * @generated
	 */
	void setPathToAxis2Repository(String value);

	/**
	 * Returns the value of the '<em><b>Payload Type</b></em>' attribute.
	 * The default value is <code>"MESSAGE_ELEMENT"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType
	 * @see #setPayloadType(CalloutPayloadType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PayloadType()
	 * @model default="MESSAGE_ELEMENT"
	 * @generated
	 */
	CalloutPayloadType getPayloadType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadType <em>Payload Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType
	 * @see #getPayloadType()
	 * @generated
	 */
	void setPayloadType(CalloutPayloadType value);

	/**
	 * Returns the value of the '<em><b>Payload Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #setPayloadMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PayloadMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getPayloadMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Message Xpath</em>' containment reference.
	 * @see #getPayloadMessageXpath()
	 * @generated
	 */
	void setPayloadMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Payload Registry Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload Registry Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload Registry Key</em>' containment reference.
	 * @see #setPayloadRegistryKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PayloadRegistryKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getPayloadRegistryKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadRegistryKey <em>Payload Registry Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload Registry Key</em>' containment reference.
	 * @see #getPayloadRegistryKey()
	 * @generated
	 */
	void setPayloadRegistryKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * The default value is <code>"MESSAGE_ELEMENT"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType
	 * @see #setResultType(CalloutResultType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_ResultType()
	 * @model default="MESSAGE_ELEMENT"
	 * @generated
	 */
	CalloutResultType getResultType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(CalloutResultType value);

	/**
	 * Returns the value of the '<em><b>Result Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Message Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #setResultMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_ResultMessageXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getResultMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Message Xpath</em>' containment reference.
	 * @see #getResultMessageXpath()
	 * @generated
	 */
	void setResultMessageXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Result Context Property</b></em>' attribute.
	 * The default value is <code>"context_property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Context Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Context Property</em>' attribute.
	 * @see #setResultContextProperty(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_ResultContextProperty()
	 * @model default="context_property_name"
	 * @generated
	 */
	String getResultContextProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Context Property</em>' attribute.
	 * @see #getResultContextProperty()
	 * @generated
	 */
	void setResultContextProperty(String value);

	/**
	 * Returns the value of the '<em><b>Pass Headers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pass Headers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Headers</em>' attribute.
	 * @see #setPassHeaders(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_PassHeaders()
	 * @model
	 * @generated
	 */
	boolean isPassHeaders();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isPassHeaders <em>Pass Headers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Headers</em>' attribute.
	 * @see #isPassHeaders()
	 * @generated
	 */
	void setPassHeaders(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Server Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Server Config</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Server Config</em>' attribute.
	 * @see #setUseServerConfig(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_UseServerConfig()
	 * @model
	 * @generated
	 */
	boolean isUseServerConfig();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isUseServerConfig <em>Use Server Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Server Config</em>' attribute.
	 * @see #isUseServerConfig()
	 * @generated
	 */
	void setUseServerConfig(boolean value);

	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType
	 * @see #setEndpointType(CallOutMediatorEndpointType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_EndpointType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	CallOutMediatorEndpointType getEndpointType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointType <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType
	 * @see #getEndpointType()
	 * @generated
	 */
	void setEndpointType(CallOutMediatorEndpointType value);

	/**
	 * Returns the value of the '<em><b>Endpoint Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Key</em>' reference.
	 * @see #setEndpointKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCalloutMediator_EndpointKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getEndpointKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointKey <em>Endpoint Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Key</em>' reference.
	 * @see #getEndpointKey()
	 * @generated
	 */
	void setEndpointKey(RegistryKeyProperty value);

} // CalloutMediator
