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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Publish Event Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getCorrelation <em>Correlation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getPayload <em>Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getArbitrary <em>Arbitrary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventAttributes()
 * @model
 * @generated
 */
public interface PublishEventAttributes extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' reference.
	 * @see #setMeta(PublishEventMetaAttributes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventAttributes_Meta()
	 * @model
	 * @generated
	 */
	PublishEventMetaAttributes getMeta();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getMeta <em>Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(PublishEventMetaAttributes value);

	/**
	 * Returns the value of the '<em><b>Correlation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation</em>' reference.
	 * @see #setCorrelation(PublishEventCorrelationAttributes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventAttributes_Correlation()
	 * @model
	 * @generated
	 */
	PublishEventCorrelationAttributes getCorrelation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getCorrelation <em>Correlation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation</em>' reference.
	 * @see #getCorrelation()
	 * @generated
	 */
	void setCorrelation(PublishEventCorrelationAttributes value);

	/**
	 * Returns the value of the '<em><b>Payload</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' reference.
	 * @see #setPayload(PublishEventPayloadAttributes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventAttributes_Payload()
	 * @model
	 * @generated
	 */
	PublishEventPayloadAttributes getPayload();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getPayload <em>Payload</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' reference.
	 * @see #getPayload()
	 * @generated
	 */
	void setPayload(PublishEventPayloadAttributes value);

	/**
	 * Returns the value of the '<em><b>Arbitrary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arbitrary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arbitrary</em>' reference.
	 * @see #setArbitrary(PublishEventArbitraryAttributes)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPublishEventAttributes_Arbitrary()
	 * @model
	 * @generated
	 */
	PublishEventArbitraryAttributes getArbitrary();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.PublishEventAttributes#getArbitrary <em>Arbitrary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arbitrary</em>' reference.
	 * @see #getArbitrary()
	 * @generated
	 */
	void setArbitrary(PublishEventArbitraryAttributes value);

} // PublishEventAttributes
