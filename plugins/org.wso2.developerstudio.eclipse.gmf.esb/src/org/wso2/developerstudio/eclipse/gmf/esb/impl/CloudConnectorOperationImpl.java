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

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cloud Connector Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getConnectorParameters <em>Connector Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getConfigRef <em>Config Ref</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getConnectorName <em>Connector Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getCloudConnectorName <em>Cloud Connector Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getNewConfig <em>New Config</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getAvailableConfigs <em>Available Configs</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl#getParameterEditorType <em>Parameter Editor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloudConnectorOperationImpl extends MediatorImpl implements CloudConnectorOperation {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CloudConnectorOperationInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CloudConnectorOperationOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getConnectorParameters() <em>Connector Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CallTemplateParameter> connectorParameters;

	/**
	 * The default value of the '{@link #getConfigRef() <em>Config Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigRef()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigRef() <em>Config Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigRef()
	 * @generated
	 * @ordered
	 */
	protected String configRef = CONFIG_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectorName() <em>Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectorName() <em>Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorName()
	 * @generated
	 * @ordered
	 */
	protected String connectorName = CONNECTOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected String operationName = OPERATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCloudConnectorName() <em>Cloud Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloudConnectorName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLOUD_CONNECTOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCloudConnectorName() <em>Cloud Connector Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloudConnectorName()
	 * @generated
	 * @ordered
	 */
	protected String cloudConnectorName = CLOUD_CONNECTOR_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNewConfig() <em>New Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewConfig()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty newConfig;

	/**
	 * The default value of the '{@link #getAvailableConfigs() <em>Available Configs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableConfigs()
	 * @generated
	 * @ordered
	 */
	protected static final String AVAILABLE_CONFIGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAvailableConfigs() <em>Available Configs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableConfigs()
	 * @generated
	 * @ordered
	 */
	protected String availableConfigs = AVAILABLE_CONFIGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterEditorType() <em>Parameter Editor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterEditorType()
	 * @generated
	 * @ordered
	 */
	protected static final CloudConnectorOperationParamEditorType PARAMETER_EDITOR_TYPE_EDEFAULT = CloudConnectorOperationParamEditorType.INLINE;

	/**
	 * The cached value of the '{@link #getParameterEditorType() <em>Parameter Editor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterEditorType()
	 * @generated
	 * @ordered
	 */
	protected CloudConnectorOperationParamEditorType parameterEditorType = PARAMETER_EDITOR_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CloudConnectorOperationImpl() {
		super();
		RegistryKeyProperty newNewConfig = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		newNewConfig.setKeyName("Sequence Key");
		newNewConfig.setPrettyName("Sequence Key");
		newNewConfig.setKeyValue("Create New Configuration");
		setNewConfig(newNewConfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CloudConnectorOperationInputConnector newInputConnector, NotificationChain msgs) {
		CloudConnectorOperationInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CloudConnectorOperationInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CloudConnectorOperationOutputConnector newOutputConnector, NotificationChain msgs) {
		CloudConnectorOperationOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CloudConnectorOperationOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CallTemplateParameter> getConnectorParameters() {
		if (connectorParameters == null) {
			connectorParameters = new EObjectContainmentEList<CallTemplateParameter>(CallTemplateParameter.class, this, EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS);
		}
		return connectorParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigRef() {
		return configRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigRef(String newConfigRef) {
		String oldConfigRef = configRef;
		configRef = newConfigRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF, oldConfigRef, configRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectorName() {
		return connectorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectorName(String newConnectorName) {
		String oldConnectorName = connectorName;
		connectorName = newConnectorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME, oldConnectorName, connectorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationName(String newOperationName) {
		String oldOperationName = operationName;
		operationName = newOperationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME, oldOperationName, operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCloudConnectorName() {
		return cloudConnectorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloudConnectorName(String newCloudConnectorName) {
		String oldCloudConnectorName = cloudConnectorName;
		cloudConnectorName = newCloudConnectorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME, oldCloudConnectorName, cloudConnectorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getNewConfig() {
		return newConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewConfig(RegistryKeyProperty newNewConfig, NotificationChain msgs) {
		RegistryKeyProperty oldNewConfig = newConfig;
		newConfig = newNewConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG, oldNewConfig, newNewConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewConfig(RegistryKeyProperty newNewConfig) {
		if (newNewConfig != newConfig) {
			NotificationChain msgs = null;
			if (newConfig != null)
				msgs = ((InternalEObject)newConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG, null, msgs);
			if (newNewConfig != null)
				msgs = ((InternalEObject)newNewConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG, null, msgs);
			msgs = basicSetNewConfig(newNewConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG, newNewConfig, newNewConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAvailableConfigs() {
		return availableConfigs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableConfigs(String newAvailableConfigs) {
		String oldAvailableConfigs = availableConfigs;
		availableConfigs = newAvailableConfigs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS, oldAvailableConfigs, availableConfigs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationParamEditorType getParameterEditorType() {
		return parameterEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterEditorType(CloudConnectorOperationParamEditorType newParameterEditorType) {
		CloudConnectorOperationParamEditorType oldParameterEditorType = parameterEditorType;
		parameterEditorType = newParameterEditorType == null ? PARAMETER_EDITOR_TYPE_EDEFAULT : newParameterEditorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE, oldParameterEditorType, parameterEditorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
				return ((InternalEList<?>)getConnectorParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
				return basicSetNewConfig(null, msgs);
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
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
				return getConnectorParameters();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF:
				return getConfigRef();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME:
				return getConnectorName();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME:
				return getOperationName();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME:
				return getCloudConnectorName();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
				return getNewConfig();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS:
				return getAvailableConfigs();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE:
				return getParameterEditorType();
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
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
				setInputConnector((CloudConnectorOperationInputConnector)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
				setOutputConnector((CloudConnectorOperationOutputConnector)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
				getConnectorParameters().clear();
				getConnectorParameters().addAll((Collection<? extends CallTemplateParameter>)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF:
				setConfigRef((String)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME:
				setConnectorName((String)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME:
				setOperationName((String)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME:
				setCloudConnectorName((String)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
				setNewConfig((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS:
				setAvailableConfigs((String)newValue);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE:
				setParameterEditorType((CloudConnectorOperationParamEditorType)newValue);
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
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
				setInputConnector((CloudConnectorOperationInputConnector)null);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
				setOutputConnector((CloudConnectorOperationOutputConnector)null);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
				getConnectorParameters().clear();
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF:
				setConfigRef(CONFIG_REF_EDEFAULT);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME:
				setConnectorName(CONNECTOR_NAME_EDEFAULT);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME:
				setOperationName(OPERATION_NAME_EDEFAULT);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME:
				setCloudConnectorName(CLOUD_CONNECTOR_NAME_EDEFAULT);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
				setNewConfig((RegistryKeyProperty)null);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS:
				setAvailableConfigs(AVAILABLE_CONFIGS_EDEFAULT);
				return;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE:
				setParameterEditorType(PARAMETER_EDITOR_TYPE_EDEFAULT);
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
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS:
				return connectorParameters != null && !connectorParameters.isEmpty();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONFIG_REF:
				return CONFIG_REF_EDEFAULT == null ? configRef != null : !CONFIG_REF_EDEFAULT.equals(configRef);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CONNECTOR_NAME:
				return CONNECTOR_NAME_EDEFAULT == null ? connectorName != null : !CONNECTOR_NAME_EDEFAULT.equals(connectorName);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__OPERATION_NAME:
				return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__CLOUD_CONNECTOR_NAME:
				return CLOUD_CONNECTOR_NAME_EDEFAULT == null ? cloudConnectorName != null : !CLOUD_CONNECTOR_NAME_EDEFAULT.equals(cloudConnectorName);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__NEW_CONFIG:
				return newConfig != null;
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__AVAILABLE_CONFIGS:
				return AVAILABLE_CONFIGS_EDEFAULT == null ? availableConfigs != null : !AVAILABLE_CONFIGS_EDEFAULT.equals(availableConfigs);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE:
				return parameterEditorType != PARAMETER_EDITOR_TYPE_EDEFAULT;
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
		result.append(" (configRef: ");
		result.append(configRef);
		result.append(", connectorName: ");
		result.append(connectorName);
		result.append(", operationName: ");
		result.append(operationName);
		result.append(", cloudConnectorName: ");
		result.append(cloudConnectorName);
		result.append(", availableConfigs: ");
		result.append(availableConfigs);
		result.append(", parameterEditorType: ");
		result.append(parameterEditorType);
		result.append(')');
		return result.toString();
	}

} //CloudConnectorOperationImpl
