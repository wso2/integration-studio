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
import org.wso2.developerstudio.eclipse.esb.EndPointReference;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getAnonymousEndPoint <em>Anonymous End Point</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getEndPointReference <em>End Point Reference</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getReceivingSequenceType <em>Receiving Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getStaticReceivingSequence <em>Static Receiving Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator()
 * @model
 * @generated
 */
public interface SendMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Anonymous End Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anonymous End Point</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous End Point</em>' containment reference.
	 * @see #setAnonymousEndPoint(EndPoint)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator_AnonymousEndPoint()
	 * @model containment="true"
	 * @generated
	 */
	EndPoint getAnonymousEndPoint();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getAnonymousEndPoint <em>Anonymous End Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous End Point</em>' containment reference.
	 * @see #getAnonymousEndPoint()
	 * @generated
	 */
	void setAnonymousEndPoint(EndPoint value);

	/**
	 * Returns the value of the '<em><b>End Point Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Point Reference</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>End Point Reference</em>' containment reference.
	 * @see #setEndPointReference(EndPointReference)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator_EndPointReference()
	 * @model containment="true"
	 * @generated
	 */
    EndPointReference getEndPointReference();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getEndPointReference <em>End Point Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Point Reference</em>' containment reference.
	 * @see #getEndPointReference()
	 * @generated
	 */
    void setEndPointReference(EndPointReference value);

				/**
	 * Returns the value of the '<em><b>Receiving Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiving Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiving Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType
	 * @see #setReceivingSequenceType(ReceivingSequenceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator_ReceivingSequenceType()
	 * @model
	 * @generated
	 */
	ReceivingSequenceType getReceivingSequenceType();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getReceivingSequenceType <em>Receiving Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiving Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType
	 * @see #getReceivingSequenceType()
	 * @generated
	 */
	void setReceivingSequenceType(ReceivingSequenceType value);

				/**
	 * Returns the value of the '<em><b>Static Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Receiving Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Receiving Sequence</em>' containment reference.
	 * @see #setStaticReceivingSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator_StaticReceivingSequence()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getStaticReceivingSequence();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getStaticReceivingSequence <em>Static Receiving Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Receiving Sequence</em>' containment reference.
	 * @see #getStaticReceivingSequence()
	 * @generated
	 */
	void setStaticReceivingSequence(RegistryKeyProperty value);

				/**
	 * Returns the value of the '<em><b>Dynamic Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Receiving Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Receiving Sequence</em>' containment reference.
	 * @see #setDynamicReceivingSequence(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSendMediator_DynamicReceivingSequence()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getDynamicReceivingSequence();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Receiving Sequence</em>' containment reference.
	 * @see #getDynamicReceivingSequence()
	 * @generated
	 */
	void setDynamicReceivingSequence(NamespacedProperty value);

} // SendMediator
