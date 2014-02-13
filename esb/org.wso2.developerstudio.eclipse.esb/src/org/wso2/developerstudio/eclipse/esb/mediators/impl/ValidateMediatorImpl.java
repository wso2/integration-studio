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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl#getOnFailBranch <em>On Fail Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidateMediatorImpl extends MediatorImpl implements ValidateMediator {
	/**
	 * The cached value of the '{@link #getSourceXpath() <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sourceXpath;

	/**
	 * The cached value of the '{@link #getOnFailBranch() <em>On Fail Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnFailBranch()
	 * @generated
	 * @ordered
	 */
	protected ValidateOnFailBranch onFailBranch;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateFeature> features;

	/**
	 * The cached value of the '{@link #getSchemas() <em>Schemas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemas()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateSchema> schemas;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateResource> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ValidateMediatorImpl() {
		super();
		
		// Source xpath.
		NamespacedProperty sourceXpath = getEsbFactory().createNamespacedProperty();
		sourceXpath.setPrettyName("Source");
		sourceXpath.setPropertyName("source");
		sourceXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setSourceXpath(sourceXpath);
		
		setOnFailBranch(getMediatorFactory().createValidateOnFailBranch());
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		getSourceXpath().load(self);
		
		// OnFail branch.
		loadObject(self, "on-fail", ValidateOnFailBranch.class, false, new ObjectHandler<ValidateOnFailBranch>() {
			public void handle(ValidateOnFailBranch object) {
				setOnFailBranch(object);
			}
		});

		// Features.
		loadObjects(self, "feature", ValidateFeature.class, new ObjectHandler<ValidateFeature>() {
			public void handle(ValidateFeature object) {
				getFeatures().add(object);
			}			
		});

		// Schemas.
		loadObjects(self, "schema", ValidateSchema.class, new ObjectHandler<ValidateSchema>() {
			public void handle(ValidateSchema object) {
				getSchemas().add(object);				
			}			
		});	
		
		//Resources
		loadObjects(self, "resource", ValidateResource.class, new ObjectHandler<ValidateResource>() {
			public void handle(ValidateResource object) {
				getResources().add(object);
			}
		});
		
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "validate");
		getSourceXpath().save(self);

		// OnFail branch.
		getOnFailBranch().save(self);
		
		// Features.
		for (ValidateFeature feature : getFeatures()) {
			feature.save(self);
		}
		
		// Schemas.
		for (ValidateSchema schema : getSchemas()) {
			schema.save(self);
		}	
		
		// Resources
		for(ValidateResource resource : getResources()){
			resource.save(self);
		}
		
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
		return MediatorsPackage.Literals.VALIDATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSourceXpath() {
		return sourceXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceXpath(NamespacedProperty newSourceXpath, NotificationChain msgs) {
		NamespacedProperty oldSourceXpath = sourceXpath;
		sourceXpath = newSourceXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, oldSourceXpath, newSourceXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXpath(NamespacedProperty newSourceXpath) {
		if (newSourceXpath != sourceXpath) {
			NotificationChain msgs = null;
			if (sourceXpath != null)
				msgs = ((InternalEObject)sourceXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXpath != null)
				msgs = ((InternalEObject)newSourceXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXpath(newSourceXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, newSourceXpath, newSourceXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateOnFailBranch getOnFailBranch() {
		return onFailBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnFailBranch(ValidateOnFailBranch newOnFailBranch, NotificationChain msgs) {
		ValidateOnFailBranch oldOnFailBranch = onFailBranch;
		onFailBranch = newOnFailBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH, oldOnFailBranch, newOnFailBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnFailBranch(ValidateOnFailBranch newOnFailBranch) {
		if (newOnFailBranch != onFailBranch) {
			NotificationChain msgs = null;
			if (onFailBranch != null)
				msgs = ((InternalEObject)onFailBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH, null, msgs);
			if (newOnFailBranch != null)
				msgs = ((InternalEObject)newOnFailBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH, null, msgs);
			msgs = basicSetOnFailBranch(newOnFailBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH, newOnFailBranch, newOnFailBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<ValidateFeature>(ValidateFeature.class, this, MediatorsPackage.VALIDATE_MEDIATOR__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateSchema> getSchemas() {
		if (schemas == null) {
			schemas = new EObjectContainmentEList<ValidateSchema>(ValidateSchema.class, this, MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS);
		}
		return schemas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<ValidateResource>(ValidateResource.class, this, MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	                                        NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXpath(null, msgs);
			case MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH:
				return basicSetOnFailBranch(null, msgs);
			case MediatorsPackage.VALIDATE_MEDIATOR__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return ((InternalEList<?>)getSchemas()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return getSourceXpath();
			case MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH:
				return getOnFailBranch();
			case MediatorsPackage.VALIDATE_MEDIATOR__FEATURES:
				return getFeatures();
			case MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return getSchemas();
			case MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES:
				return getResources();
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
			case MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH:
				setOnFailBranch((ValidateOnFailBranch)newValue);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends ValidateFeature>)newValue);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS:
				getSchemas().clear();
				getSchemas().addAll((Collection<? extends ValidateSchema>)newValue);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ValidateResource>)newValue);
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
			case MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)null);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH:
				setOnFailBranch((ValidateOnFailBranch)null);
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__FEATURES:
				getFeatures().clear();
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS:
				getSchemas().clear();
				return;
			case MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES:
				getResources().clear();
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
			case MediatorsPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return sourceXpath != null;
			case MediatorsPackage.VALIDATE_MEDIATOR__ON_FAIL_BRANCH:
				return onFailBranch != null;
			case MediatorsPackage.VALIDATE_MEDIATOR__FEATURES:
				return features != null && !features.isEmpty();
			case MediatorsPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return schemas != null && !schemas.isEmpty();
			case MediatorsPackage.VALIDATE_MEDIATOR__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getSourceXpath().getPropertyValue() || getSourceXpath().getPropertyValue().trim().isEmpty()) {
			validateMap.put("Source Xpath","Source Xpath is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Validate Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} // ValidateMediatorImpl
