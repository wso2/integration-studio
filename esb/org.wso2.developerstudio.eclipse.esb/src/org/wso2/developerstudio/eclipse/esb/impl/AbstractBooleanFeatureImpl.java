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
package org.wso2.developerstudio.eclipse.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractBooleanFeature;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Boolean Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractBooleanFeatureImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractBooleanFeatureImpl#isFeatureEnabled <em>Feature Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractBooleanFeatureImpl extends ModelObjectImpl implements AbstractBooleanFeature {
	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = "feature_name";

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isFeatureEnabled() <em>Feature Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFeatureEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FEATURE_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFeatureEnabled() <em>Feature Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFeatureEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean featureEnabled = FEATURE_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractBooleanFeatureImpl() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		setFeatureName(self.getAttribute("name"));
		if (!self.getAttribute("value").equalsIgnoreCase("true")) {			
			setFeatureEnabled(false);
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "feature");
		self.setAttribute("name", getFeatureName());
		if (isFeatureEnabled()) {
			self.setAttribute("value", "true");
		} else {
			self.setAttribute("value", "false");
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
		return EsbPackage.Literals.ABSTRACT_BOOLEAN_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFeatureEnabled() {
		return featureEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureEnabled(boolean newFeatureEnabled) {
		boolean oldFeatureEnabled = featureEnabled;
		featureEnabled = newFeatureEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED, oldFeatureEnabled, featureEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME:
				return getFeatureName();
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED:
				return isFeatureEnabled();
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
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED:
				setFeatureEnabled((Boolean)newValue);
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
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED:
				setFeatureEnabled(FEATURE_ENABLED_EDEFAULT);
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
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED:
				return featureEnabled != FEATURE_ENABLED_EDEFAULT;
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
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(", featureEnabled: ");
		result.append(featureEnabled);
		result.append(')');
		return result.toString();
	}

} //AbstractBooleanFeatureImpl
