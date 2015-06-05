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
 * A representation of the model object '<em><b>For Each Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget#getToAddress <em>To Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getForEachTarget()
 * @model
 * @generated
 */
public interface ForEachTarget extends AbstractCommonTarget {

	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getForEachTarget_SoapAction()
	 * @model
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>To Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Address</em>' attribute.
	 * @see #setToAddress(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getForEachTarget_ToAddress()
	 * @model
	 * @generated
	 */
	String getToAddress();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget#getToAddress <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Address</em>' attribute.
	 * @see #getToAddress()
	 * @generated
	 */
	void setToAddress(String value);
} // ForEachTarget
