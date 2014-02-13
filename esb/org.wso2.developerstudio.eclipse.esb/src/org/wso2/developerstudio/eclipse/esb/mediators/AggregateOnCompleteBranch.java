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
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On Complete Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateOnCompleteBranch()
 * @model
 * @generated
 */
public interface AggregateOnCompleteBranch extends MediatorBranch {
	/**
	 * Returns the value of the '<em><b>Aggregation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Expression</em>' containment reference.
	 * @see #setAggregationExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateOnCompleteBranch_AggregationExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getAggregationExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getAggregationExpression <em>Aggregation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Expression</em>' containment reference.
	 * @see #getAggregationExpression()
	 * @generated
	 */
	void setAggregationExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType
	 * @see #setSequenceType(AggregateSequenceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateOnCompleteBranch_SequenceType()
	 * @model
	 * @generated
	 */
	AggregateSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(AggregateSequenceType value);

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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateOnCompleteBranch_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

} // OnCompleteBranch
