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
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smooks Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl#getConfigurationKey <em>Configuration Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmooksMediatorImpl extends MediatorImpl implements SmooksMediator {
	/**
	 * The cached value of the '{@link #getConfigurationKey() <em>Configuration Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty configurationKey;
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected SmooksInConfiguration input;
	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected SmooksOutConfiguration output;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SmooksMediatorImpl() {
		super();
		
		// Configuration key.
		RegistryKeyProperty configurationKey = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)configurationKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_SMOOKS);
		configurationKey.setPrettyName("Configuration Key");
		configurationKey.setKeyName("config-key");
		configurationKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setConfigurationKey(configurationKey);
		
		//Smooks input configurations
		setInput(getMediatorFactory().createSmooksInConfiguration());

		//Smooks output configurations
		setOutput(getMediatorFactory().createSmooksOutConfiguration());
		
	}
	
	/**
	 * {@inheritDoc}
	 */
    public void doLoad(Element self) throws Exception {		
		getConfigurationKey().load(self);
		loadObjects(self, "input", SmooksInConfiguration.class, new ObjectHandler<SmooksInConfiguration>() {
			public void handle(SmooksInConfiguration object) {
				setInput(object);
			}			
		});	
		loadObjects(self, "output", SmooksOutConfiguration.class, new ObjectHandler<SmooksOutConfiguration>() {
			public void handle(SmooksOutConfiguration object) {
				setOutput(object);
			}			
		});	
		super.doLoad(self);
    }

	/**
	 * {@inheritDoc}
	 */
    public Element doSave(Element parent) throws Exception {
		Element self =  createChildElement(parent, "smooks");		
		getConfigurationKey().save(self);   	
		getInput().save(self);
		getOutput().save(self);
		if(description!=null)
			description.save(self);
		
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
		return MediatorsPackage.Literals.SMOOKS_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getConfigurationKey() {
		return configurationKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationKey(RegistryKeyProperty newConfigurationKey, NotificationChain msgs) {
		RegistryKeyProperty oldConfigurationKey = configurationKey;
		configurationKey = newConfigurationKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, oldConfigurationKey, newConfigurationKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationKey(RegistryKeyProperty newConfigurationKey) {
		if (newConfigurationKey != configurationKey) {
			NotificationChain msgs = null;
			if (configurationKey != null)
				msgs = ((InternalEObject)configurationKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			if (newConfigurationKey != null)
				msgs = ((InternalEObject)newConfigurationKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			msgs = basicSetConfigurationKey(newConfigurationKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, newConfigurationKey, newConfigurationKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksInConfiguration getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(SmooksInConfiguration newInput, NotificationChain msgs) {
		SmooksInConfiguration oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(SmooksInConfiguration newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksOutConfiguration getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(SmooksOutConfiguration newOutput, NotificationChain msgs) {
		SmooksOutConfiguration oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(SmooksOutConfiguration newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return basicSetConfigurationKey(null, msgs);
			case MediatorsPackage.SMOOKS_MEDIATOR__INPUT:
				return basicSetInput(null, msgs);
			case MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT:
				return basicSetOutput(null, msgs);
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
			case MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return getConfigurationKey();
			case MediatorsPackage.SMOOKS_MEDIATOR__INPUT:
				return getInput();
			case MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT:
				return getOutput();
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
			case MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.SMOOKS_MEDIATOR__INPUT:
				setInput((SmooksInConfiguration)newValue);
				return;
			case MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT:
				setOutput((SmooksOutConfiguration)newValue);
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
			case MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.SMOOKS_MEDIATOR__INPUT:
				setInput((SmooksInConfiguration)null);
				return;
			case MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT:
				setOutput((SmooksOutConfiguration)null);
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
			case MediatorsPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return configurationKey != null;
			case MediatorsPackage.SMOOKS_MEDIATOR__INPUT:
				return input != null;
			case MediatorsPackage.SMOOKS_MEDIATOR__OUTPUT:
				return output != null;
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (null == configurationKey.getKeyValue() || configurationKey.getKeyValue().trim().isEmpty()) {
			validateMap.put("Config-Key","Config-Key is empty");
		}
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Smooks Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} //SmooksMediatorImpl
