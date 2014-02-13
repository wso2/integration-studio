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
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.eclipse.emf.common.util.EList;

import org.wso2.developerstudio.eclipse.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Template Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTargetTemplate <em>Target Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTemplateParameters <em>Template Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateMediator()
 * @model
 * @generated
 */
public interface CallTemplateMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Target Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Template</em>' attribute.
	 * @see #setTargetTemplate(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateMediator_TargetTemplate()
	 * @model
	 * @generated
	 */
	String getTargetTemplate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTargetTemplate <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Template</em>' attribute.
	 * @see #getTargetTemplate()
	 * @generated
	 */
	void setTargetTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Template Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateMediator_TemplateParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<CallTemplateParameter> getTemplateParameters();

} // CallTemplateMediator
