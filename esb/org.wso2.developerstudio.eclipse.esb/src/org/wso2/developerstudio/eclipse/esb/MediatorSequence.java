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
package org.wso2.developerstudio.eclipse.esb;

import org.eclipse.emf.common.util.EList;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#isAnonymous <em>Anonymous</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getSequenceName <em>Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getMediators <em>Mediators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getOnError <em>On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence()
 * @model
 * @generated
 */
public interface MediatorSequence extends ConfigurationElement {

	/**
	 * Returns the value of the '<em><b>Anonymous</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anonymous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous</em>' attribute.
	 * @see #setAnonymous(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence_Anonymous()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnonymous();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#isAnonymous <em>Anonymous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous</em>' attribute.
	 * @see #isAnonymous()
	 * @generated
	 */
	void setAnonymous(boolean value);

	/**
	 * Returns the value of the '<em><b>Sequence Name</b></em>' attribute.
	 * The default value is <code>"sequence_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Name</em>' attribute.
	 * @see #setSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence_SequenceName()
	 * @model default="sequence_name"
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Mediators</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.Mediator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediators</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence_Mediators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mediator> getMediators();

	/**
	 * Returns the value of the '<em><b>On Error</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error</em>' reference.
	 * @see #setOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence_OnError()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getOnError <em>On Error</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error</em>' reference.
	 * @see #getOnError()
	 * @generated
	 */
	void setOnError(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(Description)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getMediatorSequence_Description()
	 * @model containment="true"
	 * @generated
	 */
	Description getDescription();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Description value);
} // SequenceMediator
