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
 * A representation of the model object '<em><b>Publish Event Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getOutputconnector <em>Outputconnector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getStreamName <em>Stream Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getStreamVersion <em>Stream Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getEventSink <em>Event Sink</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getMetaAttributes <em>Meta Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getCorrelationAttributes <em>Correlation Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getPayloadAttributes <em>Payload Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getArbitraryAttributes <em>Arbitrary Attributes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#isAsync <em>Async</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getAsyncTimeout <em>Async Timeout</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator()
 * @model
 * @generated
 */
public interface PublishEventMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(PublishEventMediatorInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    PublishEventMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(PublishEventMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Outputconnector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputconnector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outputconnector</em>' containment reference.
     * @see #setOutputconnector(PublishEventMediatorOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_Outputconnector()
     * @model containment="true"
     * @generated
     */
    PublishEventMediatorOutputConnector getOutputconnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getOutputconnector <em>Outputconnector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Outputconnector</em>' containment reference.
     * @see #getOutputconnector()
     * @generated
     */
    void setOutputconnector(PublishEventMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>Stream Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stream Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stream Name</em>' attribute.
     * @see #setStreamName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_StreamName()
     * @model
     * @generated
     */
    String getStreamName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getStreamName <em>Stream Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stream Name</em>' attribute.
     * @see #getStreamName()
     * @generated
     */
    void setStreamName(String value);

    /**
     * Returns the value of the '<em><b>Stream Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stream Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stream Version</em>' attribute.
     * @see #setStreamVersion(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_StreamVersion()
     * @model
     * @generated
     */
    String getStreamVersion();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getStreamVersion <em>Stream Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stream Version</em>' attribute.
     * @see #getStreamVersion()
     * @generated
     */
    void setStreamVersion(String value);

    /**
     * Returns the value of the '<em><b>Event Sink</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Sink</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Sink</em>' attribute.
     * @see #setEventSink(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_EventSink()
     * @model
     * @generated
     */
    String getEventSink();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getEventSink <em>Event Sink</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event Sink</em>' attribute.
     * @see #getEventSink()
     * @generated
     */
    void setEventSink(String value);

    /**
     * Returns the value of the '<em><b>Meta Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Meta Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Meta Attributes</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_MetaAttributes()
     * @model containment="true"
     * @generated
     */
    EList<PublishEventMediatorAttribute> getMetaAttributes();

    /**
     * Returns the value of the '<em><b>Correlation Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Correlation Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Correlation Attributes</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_CorrelationAttributes()
     * @model containment="true"
     * @generated
     */
    EList<PublishEventMediatorAttribute> getCorrelationAttributes();

    /**
     * Returns the value of the '<em><b>Payload Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Payload Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Payload Attributes</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_PayloadAttributes()
     * @model containment="true"
     * @generated
     */
    EList<PublishEventMediatorAttribute> getPayloadAttributes();

    /**
     * Returns the value of the '<em><b>Arbitrary Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Arbitrary Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Arbitrary Attributes</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_ArbitraryAttributes()
     * @model containment="true"
     * @generated
     */
    EList<PublishEventMediatorAttribute> getArbitraryAttributes();

    /**
     * Returns the value of the '<em><b>Async</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Async</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Async</em>' attribute.
     * @see #setAsync(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_Async()
     * @model default="true"
     * @generated
     */
    boolean isAsync();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#isAsync <em>Async</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Async</em>' attribute.
     * @see #isAsync()
     * @generated
     */
    void setAsync(boolean value);

    /**
     * Returns the value of the '<em><b>Async Timeout</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Async Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Async Timeout</em>' attribute.
     * @see #setAsyncTimeout(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventMediator_AsyncTimeout()
     * @model default=""
     * @generated
     */
    String getAsyncTimeout();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator#getAsyncTimeout <em>Async Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Async Timeout</em>' attribute.
     * @see #getAsyncTimeout()
     * @generated
     */
    void setAsyncTimeout(String value);

} // PublishEventMediator
