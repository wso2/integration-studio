/**
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
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;

import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Store Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl#getMessageStore <em>Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl#getOnStoreSequence <em>On Store Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StoreMediatorImpl extends MediatorImpl implements StoreMediator {
	/**
     * The default value of the '{@link #getMessageStore() <em>Message Store</em>}' attribute.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @see #getMessageStore()
     * @generated NOT
     * @ordered
     */
	protected static final String MESSAGE_STORE_EDEFAULT = "messageStore";
	/**
	 * The cached value of the '{@link #getMessageStore() <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessageStore()
	 * @generated
	 * @ordered
	 */
	protected String messageStore = MESSAGE_STORE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getOnStoreSequence() <em>On Store Sequence</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOnStoreSequence()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onStoreSequence;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * 
	 */
	protected StoreMediatorImpl() {
		super();

		onStoreSequence = getEsbFactory().createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) onStoreSequence.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		onStoreSequence.setPrettyName("On Store Sequence");
		onStoreSequence.setKeyName("sequence");
		onStoreSequence.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setOnStoreSequence(onStoreSequence);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Load messageStore
		if (self.hasAttribute("messageStore")) {
			String messageStoreValue = self.getAttribute("messageStore");
			if (messageStoreValue == null) {
				messageStoreValue = "";
			}
			messageStoreValue = messageStoreValue.trim();
			setMessageStore(messageStoreValue);

		} else {
			setMessageStore("");
		}

		// Load sequence

		if (self.hasAttribute("sequence")) {
			String sequenceValue = self.getAttribute("sequence");
			if (sequenceValue == null) {
				sequenceValue = "";
			}
			sequenceValue = sequenceValue.trim();
			getOnStoreSequence().setKeyValue(sequenceValue);
		}
		super.doLoad(self);

	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {

		Element self = createChildElement(parent, "store");
		if (null != getMessageStore()) {
			self.setAttribute("messageStore", getMessageStore());
		}

		if (!getOnStoreSequence().getKeyValue().equals(
				DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY)) {
			getOnStoreSequence().save(self);
		}
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.STORE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessageStore() {
		return messageStore;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageStore(String newMessageStore) {
		String oldMessageStore = messageStore;
		messageStore = newMessageStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.STORE_MEDIATOR__MESSAGE_STORE, oldMessageStore, messageStore));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnStoreSequence() {
		if (onStoreSequence != null && onStoreSequence.eIsProxy()) {
			InternalEObject oldOnStoreSequence = (InternalEObject)onStoreSequence;
			onStoreSequence = (RegistryKeyProperty)eResolveProxy(oldOnStoreSequence);
			if (onStoreSequence != oldOnStoreSequence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE, oldOnStoreSequence, onStoreSequence));
			}
		}
		return onStoreSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetOnStoreSequence() {
		return onStoreSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnStoreSequence(RegistryKeyProperty newOnStoreSequence) {
		RegistryKeyProperty oldOnStoreSequence = onStoreSequence;
		onStoreSequence = newOnStoreSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE, oldOnStoreSequence, onStoreSequence));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.STORE_MEDIATOR__MESSAGE_STORE:
				return getMessageStore();
			case MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE:
				if (resolve) return getOnStoreSequence();
				return basicGetOnStoreSequence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.STORE_MEDIATOR__MESSAGE_STORE:
				setMessageStore((String)newValue);
				return;
			case MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE:
				setOnStoreSequence((RegistryKeyProperty)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.STORE_MEDIATOR__MESSAGE_STORE:
				setMessageStore(MESSAGE_STORE_EDEFAULT);
				return;
			case MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE:
				setOnStoreSequence((RegistryKeyProperty)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.STORE_MEDIATOR__MESSAGE_STORE:
				return MESSAGE_STORE_EDEFAULT == null ? messageStore != null : !MESSAGE_STORE_EDEFAULT.equals(messageStore);
			case MediatorsPackage.STORE_MEDIATOR__ON_STORE_SEQUENCE:
				return onStoreSequence != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (messageStore: ");
		result.append(messageStore);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		 
    	if(null==getMessageStore() || getMessageStore().trim().isEmpty()){
    		validateMap.put("MessageStore", "MessageStore is empty");
    	}
	    
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Store Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} // StoreMediatorImpl
