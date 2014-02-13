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

import org.wso2.developerstudio.eclipse.esb.MediatorBranch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch#getCaseRegex <em>Case Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSwitchCaseBranch()
 * @model
 * @generated
 */
public interface SwitchCaseBranch extends MediatorBranch {
	/**
	 * Returns the value of the '<em><b>Case Regex</b></em>' attribute.
	 * The default value is <code>".*+"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Regex</em>' attribute.
	 * @see #setCaseRegex(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSwitchCaseBranch_CaseRegex()
	 * @model default=".*+"
	 * @generated
	 */
	String getCaseRegex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch#getCaseRegex <em>Case Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Regex</em>' attribute.
	 * @see #getCaseRegex()
	 * @generated
	 */
	void setCaseRegex(String value);

} // CaseBranch
