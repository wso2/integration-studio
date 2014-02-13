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

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enrich Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#isCloneSource <em>Clone Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXML <em>Source XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetAction <em>Target Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetXpath <em>Target Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineType <em>Inline Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineRegistryKey <em>Inline Registry Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator()
 * @model
 * @generated
 */
public interface EnrichMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Clone Source</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clone Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clone Source</em>' attribute.
	 * @see #setCloneSource(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_CloneSource()
	 * @model default="false"
	 * @generated
	 */
	boolean isCloneSource();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#isCloneSource <em>Clone Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clone Source</em>' attribute.
	 * @see #isCloneSource()
	 * @generated
	 */
	void setCloneSource(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * The default value is <code>"CUSTOM"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType
	 * @see #setSourceType(EnrichSourceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_SourceType()
	 * @model default="CUSTOM"
	 * @generated
	 */
	EnrichSourceType getSourceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(EnrichSourceType value);

	/**
	 * Returns the value of the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Xpath</em>' containment reference.
	 * @see #setSourceXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_SourceXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXpath <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Xpath</em>' containment reference.
	 * @see #getSourceXpath()
	 * @generated
	 */
	void setSourceXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Source Property</b></em>' attribute.
	 * The default value is <code>"source_property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Property</em>' attribute.
	 * @see #setSourceProperty(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_SourceProperty()
	 * @model default="source_property"
	 * @generated
	 */
	String getSourceProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceProperty <em>Source Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Property</em>' attribute.
	 * @see #getSourceProperty()
	 * @generated
	 */
	void setSourceProperty(String value);

	/**
	 * Returns the value of the '<em><b>Source XML</b></em>' attribute.
	 * The default value is <code>"<inline/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source XML</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source XML</em>' attribute.
	 * @see #setSourceXML(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_SourceXML()
	 * @model default="<inline/>"
	 * @generated
	 */
	String getSourceXML();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXML <em>Source XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source XML</em>' attribute.
	 * @see #getSourceXML()
	 * @generated
	 */
	void setSourceXML(String value);

	/**
	 * Returns the value of the '<em><b>Target Action</b></em>' attribute.
	 * The default value is <code>"REPLACE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction
	 * @see #setTargetAction(EnrichTargetAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_TargetAction()
	 * @model default="REPLACE"
	 * @generated
	 */
	EnrichTargetAction getTargetAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetAction <em>Target Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction
	 * @see #getTargetAction()
	 * @generated
	 */
	void setTargetAction(EnrichTargetAction value);

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute.
	 * The default value is <code>"CUSTOM"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType
	 * @see #setTargetType(EnrichTargetType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_TargetType()
	 * @model default="CUSTOM"
	 * @generated
	 */
	EnrichTargetType getTargetType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(EnrichTargetType value);

	/**
	 * Returns the value of the '<em><b>Target Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Xpath</em>' containment reference.
	 * @see #setTargetXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_TargetXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getTargetXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetXpath <em>Target Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Xpath</em>' containment reference.
	 * @see #getTargetXpath()
	 * @generated
	 */
	void setTargetXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' attribute.
	 * The default value is <code>"target_property"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' attribute.
	 * @see #setTargetProperty(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_TargetProperty()
	 * @model default="target_property"
	 * @generated
	 */
	String getTargetProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetProperty <em>Target Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' attribute.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(String value);

	/**
	 * Returns the value of the '<em><b>Inline Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType
	 * @see #setInlineType(EnrichSourceInlineType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_InlineType()
	 * @model
	 * @generated
	 */
	EnrichSourceInlineType getInlineType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineType <em>Inline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType
	 * @see #getInlineType()
	 * @generated
	 */
	void setInlineType(EnrichSourceInlineType value);

	/**
	 * Returns the value of the '<em><b>Inline Registry Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Registry Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Registry Key</em>' reference.
	 * @see #setInlineRegistryKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEnrichMediator_InlineRegistryKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getInlineRegistryKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineRegistryKey <em>Inline Registry Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Registry Key</em>' reference.
	 * @see #getInlineRegistryKey()
	 * @generated
	 */
	void setInlineRegistryKey(RegistryKeyProperty value);

} // EnrichMediator
