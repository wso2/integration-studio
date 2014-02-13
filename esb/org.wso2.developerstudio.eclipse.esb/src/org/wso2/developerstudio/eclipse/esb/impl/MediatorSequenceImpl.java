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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.esb.Description;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.EsbVersion;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sequence Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.MediatorSequenceImpl#isAnonymous <em>Anonymous</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.MediatorSequenceImpl#getSequenceName <em>Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.MediatorSequenceImpl#getMediators <em>Mediators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.MediatorSequenceImpl#getOnError <em>On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.MediatorSequenceImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MediatorSequenceImpl extends ConfigurationElementImpl implements
		MediatorSequence {
	/**
	 * The default value of the '{@link #isAnonymous() <em>Anonymous</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAnonymous()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANONYMOUS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAnonymous() <em>Anonymous</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAnonymous()
	 * @generated
	 * @ordered
	 */
	protected boolean anonymous = ANONYMOUS_EDEFAULT;
	/**
	 * The default value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_NAME_EDEFAULT = "sequence_name";
	/**
	 * The cached value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String sequenceName = SEQUENCE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMediators() <em>Mediators</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMediators()
	 * @generated
	 * @ordered
	 */
	protected EList<Mediator> mediators;

	/**
	 * The cached value of the '{@link #getOnError() <em>On Error</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onError;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Description description;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @!generated
	 */
	protected MediatorSequenceImpl() {
		super();

		// Set the on error property value
		RegistryKeyProperty onErrorProperty = getEsbFactory()
				.createRegistryKeyProperty();
		onErrorProperty.setPrettyName("On Error");
		onErrorProperty.setKeyValue("");
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) onErrorProperty.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		setOnError(onErrorProperty);
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// Extract the name attribute.
		if (self.hasAttribute("name")) {
			setSequenceName(self.getAttribute("name"));
		} else {
			setAnonymous(true);
		}

		// Extract the on error attribute
		if (self.hasAttribute("onError")) {
			getOnError().setKeyValue(self.getAttribute("onError"));
		}			
		
		
		Element descriptionElem = getChildElement(self, "description");		
		if (null != descriptionElem) {			
			if (getDescription() == null) {
				Description description = getEsbFactory().createDescription();
				description.setValue(descriptionElem.getTextContent());
				setDescription(description);
			} else {
				getDescription().setValue(descriptionElem.getTextContent());
			}

		} else {
			//TODO
		}
				
		//Description tag will be unrecognized since it is not a mediator. So we remove it now and we add description tag manually.
		Node node=null;
		Element elementForMedator=(Element) self.cloneNode(true);
		NodeList list=elementForMedator.getChildNodes();
		
		for(int i=0;i<list.getLength();++i){
			node=list.item(i);
			if("description".equals(node.getLocalName())){
				elementForMedator.removeChild(node);
				break;
			}
		}
		
		// Load all the children.
		loadObjects(elementForMedator, Mediator.class, new ObjectHandler<Mediator>() {
			public void handle(Mediator object) {
				getMediators().add(object);
			}
		});	

		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "sequence");
		if (!isAnonymous()) {
			self.setAttribute("name", getSequenceName());
		}

		if (isOnErrorPresent()) {
			self.setAttribute("onError", getOnError().getKeyValue());
		}

		// Save all the children.
		for (Mediator mediator : getMediators()) {
			mediator.save(self);
		}

		// Save description
		if(description!=null)
			description.save(self);
		
		addComments(self);
		return self;
	}

	private boolean isOnErrorPresent() {
		String onErrorValue = getOnError().getKeyValue();
		return onErrorValue != null && !onErrorValue.equals("");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MEDIATOR_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnonymous() {
		return anonymous;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnonymous(boolean newAnonymous) {
		boolean oldAnonymous = anonymous;
		anonymous = newAnonymous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MEDIATOR_SEQUENCE__ANONYMOUS, oldAnonymous, anonymous));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSequenceName() {
		return sequenceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceName(String newSequenceName) {
		String oldSequenceName = sequenceName;
		sequenceName = newSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MEDIATOR_SEQUENCE__SEQUENCE_NAME, oldSequenceName, sequenceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mediator> getMediators() {
		if (mediators == null) {
			mediators = new EObjectContainmentEList<Mediator>(Mediator.class, this, EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS);
		}
		return mediators;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnError() {
		if (onError != null && onError.eIsProxy()) {
			InternalEObject oldOnError = (InternalEObject)onError;
			onError = (RegistryKeyProperty)eResolveProxy(oldOnError);
			if (onError != oldOnError) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR, oldOnError, onError));
			}
		}
		return onError;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetOnError() {
		return onError;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnError(RegistryKeyProperty newOnError) {
		RegistryKeyProperty oldOnError = onError;
		onError = newOnError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR, oldOnError, onError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs) {
		Description oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(Description newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS:
				return ((InternalEList<?>)getMediators()).basicRemove(otherEnd, msgs);
			case EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION:
				return basicSetDescription(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.MEDIATOR_SEQUENCE__ANONYMOUS:
				return isAnonymous();
			case EsbPackage.MEDIATOR_SEQUENCE__SEQUENCE_NAME:
				return getSequenceName();
			case EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS:
				return getMediators();
			case EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR:
				if (resolve) return getOnError();
				return basicGetOnError();
			case EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.MEDIATOR_SEQUENCE__ANONYMOUS:
				setAnonymous((Boolean)newValue);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__SEQUENCE_NAME:
				setSequenceName((String)newValue);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS:
				getMediators().clear();
				getMediators().addAll((Collection<? extends Mediator>)newValue);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR:
				setOnError((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION:
				setDescription((Description)newValue);
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
			case EsbPackage.MEDIATOR_SEQUENCE__ANONYMOUS:
				setAnonymous(ANONYMOUS_EDEFAULT);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__SEQUENCE_NAME:
				setSequenceName(SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS:
				getMediators().clear();
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR:
				setOnError((RegistryKeyProperty)null);
				return;
			case EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION:
				setDescription((Description)null);
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
			case EsbPackage.MEDIATOR_SEQUENCE__ANONYMOUS:
				return anonymous != ANONYMOUS_EDEFAULT;
			case EsbPackage.MEDIATOR_SEQUENCE__SEQUENCE_NAME:
				return SEQUENCE_NAME_EDEFAULT == null ? sequenceName != null : !SEQUENCE_NAME_EDEFAULT.equals(sequenceName);
			case EsbPackage.MEDIATOR_SEQUENCE__MEDIATORS:
				return mediators != null && !mediators.isEmpty();
			case EsbPackage.MEDIATOR_SEQUENCE__ON_ERROR:
				return onError != null;
			case EsbPackage.MEDIATOR_SEQUENCE__DESCRIPTION:
				return description != null;
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
		result.append(" (anonymous: ");
		result.append(anonymous);
		result.append(", sequenceName: ");
		result.append(sequenceName);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (!isAnonymous()) {
			if(null==getSequenceName() ||getSequenceName().trim().isEmpty()){
	    		validateMap.put("Sequence Name", "Sequence Name is empty");
	    	}
		}
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Sequence", objectValidator);
	    return mediatorValidateMap;
    }

} // SequenceMediatorImpl
