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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Proxy Sequence Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getInlineSequence <em>Inline Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceName <em>Sequence Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractProxySequenceConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProxySequenceConfiguration extends ModelObject {

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.ProxySequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxySequenceType
	 * @see #setSequenceType(ProxySequenceType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractProxySequenceConfiguration_SequenceType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	ProxySequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxySequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(ProxySequenceType value);

	/**
	 * Returns the value of the '<em><b>Inline Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Sequence</em>' containment reference.
	 * @see #setInlineSequence(MediatorSequence)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractProxySequenceConfiguration_InlineSequence()
	 * @model containment="true"
	 * @generated
	 */
	MediatorSequence getInlineSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getInlineSequence <em>Inline Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Sequence</em>' containment reference.
	 * @see #getInlineSequence()
	 * @generated
	 */
	void setInlineSequence(MediatorSequence value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' containment reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractProxySequenceConfiguration_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

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
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractProxySequenceConfiguration_SequenceName()
	 * @model default="sequence_name"
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);
} // AbstractProxySequenceConfiguration
