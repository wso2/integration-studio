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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inbound Endpoint Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer#getSequenceContainer <em>Sequence Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer#getOnErrorSequenceContainer <em>On Error Sequence Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpointContainer()
 * @model
 * @generated
 */
public interface InboundEndpointContainer extends EsbElement {
	/**
	 * Returns the value of the '<em><b>Sequence Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Container</em>' containment reference.
	 * @see #setSequenceContainer(InboundEndpointSequenceContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpointContainer_SequenceContainer()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointSequenceContainer getSequenceContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer#getSequenceContainer <em>Sequence Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Container</em>' containment reference.
	 * @see #getSequenceContainer()
	 * @generated
	 */
	void setSequenceContainer(InboundEndpointSequenceContainer value);

	/**
	 * Returns the value of the '<em><b>On Error Sequence Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error Sequence Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error Sequence Container</em>' containment reference.
	 * @see #setOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpointContainer_OnErrorSequenceContainer()
	 * @model containment="true"
	 * @generated
	 */
	InboundEndpointOnErrorSequenceContainer getOnErrorSequenceContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer#getOnErrorSequenceContainer <em>On Error Sequence Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error Sequence Container</em>' containment reference.
	 * @see #getOnErrorSequenceContainer()
	 * @generated
	 */
	void setOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer value);

} // InboundEndpointContainer
