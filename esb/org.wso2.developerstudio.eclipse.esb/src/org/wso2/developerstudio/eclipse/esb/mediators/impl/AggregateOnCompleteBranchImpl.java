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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorBranchImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>On Complete Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregateOnCompleteBranchImpl extends MediatorBranchImpl implements AggregateOnCompleteBranch {
	/**
	 * The cached value of the '{@link #getAggregationExpression() <em>Aggregation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty aggregationExpression;

	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final AggregateSequenceType SEQUENCE_TYPE_EDEFAULT = AggregateSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected AggregateSequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected AggregateOnCompleteBranchImpl() {
		super();
		
		// Sequence key.
		RegistryKeyProperty sequenceKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only sequences media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)sequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		sequenceKey.setPrettyName("Aggregate Sequence");
		sequenceKey.setKeyName("sequence");
		sequenceKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setSequenceKey(sequenceKey);
		
		// Aggregate expression.
		NamespacedProperty aggregateExpression = getEsbFactory().createNamespacedProperty();
		aggregateExpression.setPrettyName("Aggregation Expression");
		aggregateExpression.setPropertyName("expression");
		aggregateExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setAggregationExpression(aggregateExpression);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		getAggregationExpression().load(self);
		
		if (self.hasAttribute("sequence")) {
			setSequenceType(AggregateSequenceType.REGISTRY_REFERENCE);
			getSequenceKey().load(self);
		} else {
			setSequenceType(AggregateSequenceType.ANONYMOUS);
			super.doLoad(self);
		}	
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "onComplete");

		getAggregationExpression().save(self);
		
		if (getSequenceType().equals(AggregateSequenceType.ANONYMOUS)) {
			for (Mediator child : getChildren()) {
				child.save(self);
			}
		} else {
			getSequenceKey().save(self);
		}		

		addComments(self);
		return self;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.AGGREGATE_ON_COMPLETE_BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getAggregationExpression() {
		return aggregationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregationExpression(NamespacedProperty newAggregationExpression, NotificationChain msgs) {
		NamespacedProperty oldAggregationExpression = aggregationExpression;
		aggregationExpression = newAggregationExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION, oldAggregationExpression, newAggregationExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationExpression(NamespacedProperty newAggregationExpression) {
		if (newAggregationExpression != aggregationExpression) {
			NotificationChain msgs = null;
			if (aggregationExpression != null)
				msgs = ((InternalEObject)aggregationExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION, null, msgs);
			if (newAggregationExpression != null)
				msgs = ((InternalEObject)newAggregationExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION, null, msgs);
			msgs = basicSetAggregationExpression(newAggregationExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION, newAggregationExpression, newAggregationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateSequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(AggregateSequenceType newSequenceType) {
		AggregateSequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
				return basicSetAggregationExpression(null, msgs);
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
				return getAggregationExpression();
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE:
				return getSequenceType();
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
				return getSequenceKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
				setAggregationExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE:
				setSequenceType((AggregateSequenceType)newValue);
				return;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
				setAggregationExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION:
				return aggregationExpression != null;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY:
				return sequenceKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sequenceType: ");
		result.append(sequenceType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		if (null == getAggregationExpression().getPropertyValue()
 				|| getAggregationExpression().getPropertyValue().trim().isEmpty()) {
 			validateMap
 					.put("Aggregation expression", "Aggregation expression is empty");
 		}			
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Aggregate Mediator OnCompleteBranch", objectValidator);
 	    return mediatorValidateMap;
    }

} //OnCompleteBranchImpl
