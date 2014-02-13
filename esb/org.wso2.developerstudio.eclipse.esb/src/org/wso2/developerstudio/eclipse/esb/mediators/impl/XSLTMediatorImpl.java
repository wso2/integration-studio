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
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptType;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>XSLT Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getSourceXPath <em>Source XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl#getXsltKey <em>Xslt Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSLTMediatorImpl extends MediatorImpl implements XSLTMediator {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTProperty> properties;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTFeature> features;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTResource> resources;

	/**
	 * The default value of the '{@link #getXsltSchemaKeyType() <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType XSLT_SCHEMA_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getXsltSchemaKeyType() <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType xsltSchemaKeyType = XSLT_SCHEMA_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getXsltStaticSchemaKey() <em>Xslt Static Schema Key</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getXsltStaticSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty xsltStaticSchemaKey;

	/**
	 * The cached value of the '{@link #getXsltDynamicSchemaKey() <em>Xslt Dynamic Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltDynamicSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty xsltDynamicSchemaKey;

	/**
	 * The cached value of the '{@link #getSourceXPath() <em>Source XPath</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceXPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sourceXPath;

	/**
	 * The cached value of the '{@link #getXsltKey() <em>Xslt Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty xsltKey;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected XSLTMediatorImpl() {
		super();

		// XSLT Static Schema Key
		xsltStaticSchemaKey = getEsbFactory().createRegistryKeyProperty();
		// Set filter properties to filter in only xslt media type
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) xsltStaticSchemaKey.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				PlatformMediaTypeConstants.MEDIA_TYPE_XSLT);

		xsltStaticSchemaKey.setPrettyName("XSLT Static Key");
		xsltStaticSchemaKey.setKeyName("key");
		xsltStaticSchemaKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setXsltStaticSchemaKey(xsltStaticSchemaKey);

		// XSLT Dynamic Schema Key
		xsltDynamicSchemaKey = getEsbFactory().createNamespacedProperty();
		xsltDynamicSchemaKey.setPrettyName("XSLT Dynamic Key");
		xsltDynamicSchemaKey.setPropertyName("key");
		xsltDynamicSchemaKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setXsltDynamicSchemaKey(xsltDynamicSchemaKey);

		// Source XPath.
		NamespacedProperty sourceXPath = getEsbFactory()
				.createNamespacedProperty();
		sourceXPath.setPrettyName("Source XPath");
		sourceXPath.setPropertyName("source");
		setSourceXPath(sourceXPath);
		
		// XSLT key.
		RegistryKeyProperty xsltKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only xslt media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)xsltKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_XSLT);
		
		xsltKey.setPrettyName("XSLT Key");
		xsltKey.setKeyName("key");
		xsltKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setXsltKey(xsltKey);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		switch (getCurrentEsbVersion()) {
		case ESB301:
			getXsltKey().load(self);
			getSourceXPath().load(self);

			// Properties.
			loadObjects(self, "property", XSLTProperty.class,
					new ObjectHandler<XSLTProperty>() {
						public void handle(XSLTProperty object) {
							getProperties().add(object);
						}
					});

			// Features.
			loadObjects(self, "feature", XSLTFeature.class,
					new ObjectHandler<XSLTFeature>() {
						public void handle(XSLTFeature object) {
							getFeatures().add(object);
						}
					});

			// Resources.
			loadObjects(self, "resource", XSLTResource.class,
					new ObjectHandler<XSLTResource>() {
						public void handle(XSLTResource object) {
							getResources().add(object);
						}
					});
			break;
		case ESB400:
			getSourceXPath().load(self);

			// load XSLT key
			if (self.hasAttribute("key")) {
				String xsltKeyValue = self.getAttribute("key");
				if (xsltKeyValue == null) {
					xsltKeyValue = "";
				}
				xsltKeyValue = xsltKeyValue.trim();
				if (xsltKeyValue.startsWith("{") && xsltKeyValue.endsWith("}")) {
					setXsltSchemaKeyType(getXsltSchemaKeyType().DYNAMIC);
					xsltKeyValue = xsltKeyValue.substring(1,
							xsltKeyValue.length() - 2);
					getXsltDynamicSchemaKey().setPropertyValue(xsltKeyValue);
				} else {
					setXsltSchemaKeyType(getXsltSchemaKeyType().STATIC);
					getXsltStaticSchemaKey().setKeyValue(xsltKeyValue);
				}
			} else {
				setXsltSchemaKeyType(getXsltSchemaKeyType().STATIC);
			}

			// Properties.
			loadObjects(self, "property", XSLTProperty.class,
					new ObjectHandler<XSLTProperty>() {
						public void handle(XSLTProperty object) {
							getProperties().add(object);
						}
					});

			// Features.
			loadObjects(self, "feature", XSLTFeature.class,
					new ObjectHandler<XSLTFeature>() {
						public void handle(XSLTFeature object) {
							getFeatures().add(object);
						}
					});

			// Resources.
			loadObjects(self, "resource", XSLTResource.class,
					new ObjectHandler<XSLTResource>() {
						public void handle(XSLTResource object) {
							getResources().add(object);
						}
					});
		break;
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "xslt");
		switch (getCurrentEsbVersion()) {
		case ESB301:
			// XSLT Key.
			getXsltKey().save(self);

			// Source XPath.
			if (!StringUtils.isBlank(getSourceXPath().getPropertyValue())) {
				getSourceXPath().save(self);
			}

			// Properties.
			for (XSLTProperty property : getProperties()) {
				property.save(self);
			}

			// Features.
			for (XSLTFeature feature : getFeatures()) {
				feature.save(self);
			}

			// Resources.
			for (XSLTResource resource : getResources()) {
				resource.save(self);
			}
			break;

		case ESB400:
			// XSLT Key.
			switch (getXsltSchemaKeyType()) {
			case STATIC:
				getXsltStaticSchemaKey().save(self);
				break;
			case DYNAMIC:
				self.setAttribute(getXsltDynamicSchemaKey().getPropertyName(),
						"{" + getXsltDynamicSchemaKey().getPropertyValue()
								+ "}");
				break;
			}

			// Source XPath.
			if (!StringUtils.isBlank(getSourceXPath().getPropertyValue())) {
				getSourceXPath().save(self);
			}

			// Properties.
			for (XSLTProperty property : getProperties()) {
				property.save(self);
			}

			// Features.
			for (XSLTFeature feature : getFeatures()) {
				feature.save(self);
			}

			// Resources.
			for (XSLTResource resource : getResources()) {
				resource.save(self);
			}

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
		return MediatorsPackage.Literals.XSLT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSourceXPath() {
		return sourceXPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceXPath(
			NamespacedProperty newSourceXPath, NotificationChain msgs) {
		NamespacedProperty oldSourceXPath = sourceXPath;
		sourceXPath = newSourceXPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH, oldSourceXPath, newSourceXPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXPath(NamespacedProperty newSourceXPath) {
		if (newSourceXPath != sourceXPath) {
			NotificationChain msgs = null;
			if (sourceXPath != null)
				msgs = ((InternalEObject)sourceXPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXPath != null)
				msgs = ((InternalEObject)newSourceXPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXPath(newSourceXPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH, newSourceXPath, newSourceXPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getXsltKey() {
		if (xsltKey != null && xsltKey.eIsProxy()) {
			InternalEObject oldXsltKey = (InternalEObject)xsltKey;
			xsltKey = (RegistryKeyProperty)eResolveProxy(oldXsltKey);
			if (xsltKey != oldXsltKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY, oldXsltKey, xsltKey));
			}
		}
		return xsltKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetXsltKey() {
		return xsltKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltKey(RegistryKeyProperty newXsltKey) {
		RegistryKeyProperty oldXsltKey = xsltKey;
		xsltKey = newXsltKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY, oldXsltKey, xsltKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<XSLTProperty>(XSLTProperty.class, this, MediatorsPackage.XSLT_MEDIATOR__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<XSLTFeature>(XSLTFeature.class, this, MediatorsPackage.XSLT_MEDIATOR__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<XSLTResource>(XSLTResource.class, this, MediatorsPackage.XSLT_MEDIATOR__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getXsltSchemaKeyType() {
		return xsltSchemaKeyType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltSchemaKeyType(KeyType newXsltSchemaKeyType) {
		KeyType oldXsltSchemaKeyType = xsltSchemaKeyType;
		xsltSchemaKeyType = newXsltSchemaKeyType == null ? XSLT_SCHEMA_KEY_TYPE_EDEFAULT : newXsltSchemaKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE, oldXsltSchemaKeyType, xsltSchemaKeyType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getXsltStaticSchemaKey() {
		if (xsltStaticSchemaKey != null && xsltStaticSchemaKey.eIsProxy()) {
			InternalEObject oldXsltStaticSchemaKey = (InternalEObject)xsltStaticSchemaKey;
			xsltStaticSchemaKey = (RegistryKeyProperty)eResolveProxy(oldXsltStaticSchemaKey);
			if (xsltStaticSchemaKey != oldXsltStaticSchemaKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, oldXsltStaticSchemaKey, xsltStaticSchemaKey));
			}
		}
		return xsltStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty basicGetXsltStaticSchemaKey() {
		return xsltStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltStaticSchemaKey(
			RegistryKeyProperty newXsltStaticSchemaKey) {
		RegistryKeyProperty oldXsltStaticSchemaKey = xsltStaticSchemaKey;
		xsltStaticSchemaKey = newXsltStaticSchemaKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, oldXsltStaticSchemaKey, xsltStaticSchemaKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getXsltDynamicSchemaKey() {
		if (xsltDynamicSchemaKey != null && xsltDynamicSchemaKey.eIsProxy()) {
			InternalEObject oldXsltDynamicSchemaKey = (InternalEObject)xsltDynamicSchemaKey;
			xsltDynamicSchemaKey = (NamespacedProperty)eResolveProxy(oldXsltDynamicSchemaKey);
			if (xsltDynamicSchemaKey != oldXsltDynamicSchemaKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, oldXsltDynamicSchemaKey, xsltDynamicSchemaKey));
			}
		}
		return xsltDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty basicGetXsltDynamicSchemaKey() {
		return xsltDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltDynamicSchemaKey(
			NamespacedProperty newXsltDynamicSchemaKey) {
		NamespacedProperty oldXsltDynamicSchemaKey = xsltDynamicSchemaKey;
		xsltDynamicSchemaKey = newXsltDynamicSchemaKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, oldXsltDynamicSchemaKey, xsltDynamicSchemaKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.XSLT_MEDIATOR__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.XSLT_MEDIATOR__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.XSLT_MEDIATOR__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXPath(null, msgs);
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
			case MediatorsPackage.XSLT_MEDIATOR__PROPERTIES:
				return getProperties();
			case MediatorsPackage.XSLT_MEDIATOR__FEATURES:
				return getFeatures();
			case MediatorsPackage.XSLT_MEDIATOR__RESOURCES:
				return getResources();
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				return getXsltSchemaKeyType();
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				if (resolve) return getXsltStaticSchemaKey();
				return basicGetXsltStaticSchemaKey();
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				if (resolve) return getXsltDynamicSchemaKey();
				return basicGetXsltDynamicSchemaKey();
			case MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return getSourceXPath();
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY:
				if (resolve) return getXsltKey();
				return basicGetXsltKey();
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
			case MediatorsPackage.XSLT_MEDIATOR__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends XSLTProperty>)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends XSLTFeature>)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends XSLTResource>)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				setXsltSchemaKeyType((KeyType)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				setXsltStaticSchemaKey((RegistryKeyProperty)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				setXsltDynamicSchemaKey((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				setSourceXPath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY:
				setXsltKey((RegistryKeyProperty)newValue);
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
			case MediatorsPackage.XSLT_MEDIATOR__PROPERTIES:
				getProperties().clear();
				return;
			case MediatorsPackage.XSLT_MEDIATOR__FEATURES:
				getFeatures().clear();
				return;
			case MediatorsPackage.XSLT_MEDIATOR__RESOURCES:
				getResources().clear();
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				setXsltSchemaKeyType(XSLT_SCHEMA_KEY_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				setXsltStaticSchemaKey((RegistryKeyProperty)null);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				setXsltDynamicSchemaKey((NamespacedProperty)null);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				setSourceXPath((NamespacedProperty)null);
				return;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY:
				setXsltKey((RegistryKeyProperty)null);
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
			case MediatorsPackage.XSLT_MEDIATOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case MediatorsPackage.XSLT_MEDIATOR__FEATURES:
				return features != null && !features.isEmpty();
			case MediatorsPackage.XSLT_MEDIATOR__RESOURCES:
				return resources != null && !resources.isEmpty();
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				return xsltSchemaKeyType != XSLT_SCHEMA_KEY_TYPE_EDEFAULT;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				return xsltStaticSchemaKey != null;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				return xsltDynamicSchemaKey != null;
			case MediatorsPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return sourceXPath != null;
			case MediatorsPackage.XSLT_MEDIATOR__XSLT_KEY:
				return xsltKey != null;
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
		result.append(" (xsltSchemaKeyType: ");
		result.append(xsltSchemaKeyType);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		switch (getCurrentEsbVersion()) {
		case ESB301:	
			if (null == getXsltKey().getKeyValue() || getXsltKey().getKeyValue().trim().isEmpty()) {
				validateMap.put("Schema Key","Schema Key is empty");
			}
			break;
		case ESB400:
			switch (getXsltSchemaKeyType()) {
			case STATIC:
				if (null == getXsltKey().getKeyValue() || getXsltKey().getKeyValue().trim().isEmpty()) {
					validateMap.put("Schema Key","Schema Key is empty");
				}
				break;
			case DYNAMIC:
				if (null == getXsltDynamicSchemaKey().getPropertyValue() || getXsltDynamicSchemaKey().getPropertyValue().trim().isEmpty()) {
					validateMap.put("Schema Key","Schema Key is empty");
				}
				break;
			}
		}
		
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("XSLTMediator", objectValidator);
 	    return mediatorValidateMap;
    }

} // XSLTMediatorImpl
