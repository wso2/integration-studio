/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.wso2.developerstudio.bpel.humantask.model;

import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.PartnerLink;

import org.eclipse.wst.wsdl.Operation;
import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getResponseOperation <em>Response Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteTask()
 * @model
 * @generated
 */
public interface RemoteTask extends ExtensionElement {
	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' reference.
	 * @see #setPartnerLink(PartnerLink)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteTask_PartnerLink()
	 * @model
	 * @generated
	 */
	PartnerLink getPartnerLink();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getPartnerLink <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' reference.
	 * @see #getPartnerLink()
	 * @generated
	 */
	void setPartnerLink(PartnerLink value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteTask_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Response Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Operation</em>' reference.
	 * @see #setResponseOperation(Operation)
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#getRemoteTask_ResponseOperation()
	 * @model
	 * @generated
	 */
	Operation getResponseOperation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.bpel.humantask.model.RemoteTask#getResponseOperation <em>Response Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Operation</em>' reference.
	 * @see #getResponseOperation()
	 * @generated
	 */
	void setResponseOperation(Operation value);

} // RemoteTask
