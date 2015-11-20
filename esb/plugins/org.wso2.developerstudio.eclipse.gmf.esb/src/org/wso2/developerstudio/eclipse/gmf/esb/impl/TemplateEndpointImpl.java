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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getTargetTemplate <em>Target Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl#getAvailableTemplates <em>Available Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateEndpointImpl extends AbstractEndPointImpl implements TemplateEndpoint {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected TemplateEndpointInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected TemplateEndpointOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TEMPLATE_EDEFAULT = null;
 
	/**
	 * The cached value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated
	 * @ordered
	 */
	protected String targetTemplate = TARGET_TEMPLATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateEndpointParameter> parameters;

	/**
	 * The default value of the '{@link #getAvailableTemplates() <em>Available Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableTemplates()
	 * @generated
	 * @ordered
	 */
	protected static final String AVAILABLE_TEMPLATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAvailableTemplates() <em>Available Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableTemplates()
	 * @generated
	 * @ordered
	 */
	protected String availableTemplates = AVAILABLE_TEMPLATES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.TEMPLATE_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateEndpointInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(TemplateEndpointInputConnector newInputConnector, NotificationChain msgs) {
		TemplateEndpointInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(TemplateEndpointInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateEndpointOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(TemplateEndpointOutputConnector newOutputConnector, NotificationChain msgs) {
		TemplateEndpointOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(TemplateEndpointOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTemplate() {
		return targetTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTemplate(String newTargetTemplate) {
		String oldTargetTemplate = targetTemplate;
		targetTemplate = newTargetTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__TARGET_TEMPLATE, oldTargetTemplate, targetTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateEndpointParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<TemplateEndpointParameter>(TemplateEndpointParameter.class, this, EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAvailableTemplates() {
		return availableTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableTemplates(String newAvailableTemplates) {
		String oldAvailableTemplates = availableTemplates;
		availableTemplates = newAvailableTemplates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES, oldAvailableTemplates, availableTemplates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.TEMPLATE_ENDPOINT__ADDRESS:
				return getAddress();
			case EsbPackage.TEMPLATE_ENDPOINT__TARGET_TEMPLATE:
				return getTargetTemplate();
			case EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS:
				return getParameters();
			case EsbPackage.TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES:
				return getAvailableTemplates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR:
				setInputConnector((TemplateEndpointInputConnector)newValue);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR:
				setOutputConnector((TemplateEndpointOutputConnector)newValue);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__ADDRESS:
				setAddress((String)newValue);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__TARGET_TEMPLATE:
				setTargetTemplate((String)newValue);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TemplateEndpointParameter>)newValue);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES:
				setAvailableTemplates((String)newValue);
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
			case EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR:
				setInputConnector((TemplateEndpointInputConnector)null);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR:
				setOutputConnector((TemplateEndpointOutputConnector)null);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__TARGET_TEMPLATE:
				setTargetTemplate(TARGET_TEMPLATE_EDEFAULT);
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS:
				getParameters().clear();
				return;
			case EsbPackage.TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES:
				setAvailableTemplates(AVAILABLE_TEMPLATES_EDEFAULT);
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
			case EsbPackage.TEMPLATE_ENDPOINT__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.TEMPLATE_ENDPOINT__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case EsbPackage.TEMPLATE_ENDPOINT__TARGET_TEMPLATE:
				return TARGET_TEMPLATE_EDEFAULT == null ? targetTemplate != null : !TARGET_TEMPLATE_EDEFAULT.equals(targetTemplate);
			case EsbPackage.TEMPLATE_ENDPOINT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case EsbPackage.TEMPLATE_ENDPOINT__AVAILABLE_TEMPLATES:
				return AVAILABLE_TEMPLATES_EDEFAULT == null ? availableTemplates != null : !AVAILABLE_TEMPLATES_EDEFAULT.equals(availableTemplates);
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
		result.append(" (address: ");
		result.append(address);
		result.append(", targetTemplate: ");
		result.append(targetTemplate);
		result.append(", availableTemplates: ");
		result.append(availableTemplates);
		result.append(')');
		return result.toString();
	}

} //TemplateEndpointImpl
