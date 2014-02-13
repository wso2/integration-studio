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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validate Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getOnFailBranch <em>On Fail Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator()
 * @model
 * @generated
 */
public interface ValidateMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Xpath</em>' containment reference.
	 * @see #setSourceXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator_SourceXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSourceXpath <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Xpath</em>' containment reference.
	 * @see #getSourceXpath()
	 * @generated
	 */
	void setSourceXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>On Fail Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Fail Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Fail Branch</em>' containment reference.
	 * @see #setOnFailBranch(ValidateOnFailBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator_OnFailBranch()
	 * @model containment="true"
	 * @generated
	 */
	ValidateOnFailBranch getOnFailBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getOnFailBranch <em>On Fail Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Fail Branch</em>' containment reference.
	 * @see #getOnFailBranch()
	 * @generated
	 */
	void setOnFailBranch(ValidateOnFailBranch value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValidateFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Schemas</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schemas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schemas</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator_Schemas()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValidateSchema> getSchemas();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getValidateMediator_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValidateResource> getResources();

} // ValidateMediator
