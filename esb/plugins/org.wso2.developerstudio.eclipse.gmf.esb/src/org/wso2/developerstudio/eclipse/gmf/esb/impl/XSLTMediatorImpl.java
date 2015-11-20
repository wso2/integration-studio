/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XSLT Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getXsltKey <em>Xslt Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getSourceXPath <em>Source XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.XSLTMediatorImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSLTMediatorImpl extends MediatorImpl implements XSLTMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected XSLTMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected XSLTMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getXsltSchemaKeyType() <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyType XSLT_SCHEMA_KEY_TYPE_EDEFAULT = KeyType.STATIC;

	/**
	 * The cached value of the '{@link #getXsltSchemaKeyType() <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 * @ordered
	 */
	protected KeyType xsltSchemaKeyType = XSLT_SCHEMA_KEY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getXsltStaticSchemaKey() <em>Xslt Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltStaticSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty xsltStaticSchemaKey;

	/**
	 * The cached value of the '{@link #getXsltDynamicSchemaKey() <em>Xslt Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltDynamicSchemaKey()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty xsltDynamicSchemaKey;

	/**
	 * The cached value of the '{@link #getXsltKey() <em>Xslt Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsltKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty xsltKey;

	/**
	 * The cached value of the '{@link #getSourceXPath() <em>Source XPath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sourceXPath;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTProperty> properties;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTFeature> features;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<XSLTResource> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected XSLTMediatorImpl() {
		super();
		// XSLT Static Schema Key
		xsltStaticSchemaKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
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
		xsltDynamicSchemaKey = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		xsltDynamicSchemaKey.setPrettyName("XSLT Dynamic Key");
		xsltDynamicSchemaKey.setPropertyName("key");
		xsltDynamicSchemaKey.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setXsltDynamicSchemaKey(xsltDynamicSchemaKey);

		// Source XPath.
		NamespacedProperty sourceXPath = EsbFactoryImpl.eINSTANCE
				.createNamespacedProperty();
		sourceXPath.setPrettyName("Source XPath");
		sourceXPath.setPropertyName("source");
		setSourceXPath(sourceXPath);
		
		// XSLT key.
		RegistryKeyProperty xsltKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		//Set filter properties to filter in only xslt media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)xsltKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_XSLT);
		
		xsltKey.setPrettyName("XSLT Key");
		xsltKey.setKeyName("key");
		xsltKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setXsltKey(xsltKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.XSLT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(XSLTMediatorInputConnector newInputConnector, NotificationChain msgs) {
		XSLTMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(XSLTMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(XSLTMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		XSLTMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(XSLTMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getXsltSchemaKeyType() {
		return xsltSchemaKeyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltSchemaKeyType(KeyType newXsltSchemaKeyType) {
		KeyType oldXsltSchemaKeyType = xsltSchemaKeyType;
		xsltSchemaKeyType = newXsltSchemaKeyType == null ? XSLT_SCHEMA_KEY_TYPE_EDEFAULT : newXsltSchemaKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE, oldXsltSchemaKeyType, xsltSchemaKeyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getXsltStaticSchemaKey() {
		return xsltStaticSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXsltStaticSchemaKey(RegistryKeyProperty newXsltStaticSchemaKey, NotificationChain msgs) {
		RegistryKeyProperty oldXsltStaticSchemaKey = xsltStaticSchemaKey;
		xsltStaticSchemaKey = newXsltStaticSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, oldXsltStaticSchemaKey, newXsltStaticSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltStaticSchemaKey(RegistryKeyProperty newXsltStaticSchemaKey) {
		if (newXsltStaticSchemaKey != xsltStaticSchemaKey) {
			NotificationChain msgs = null;
			if (xsltStaticSchemaKey != null)
				msgs = ((InternalEObject)xsltStaticSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, null, msgs);
			if (newXsltStaticSchemaKey != null)
				msgs = ((InternalEObject)newXsltStaticSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetXsltStaticSchemaKey(newXsltStaticSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY, newXsltStaticSchemaKey, newXsltStaticSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getXsltDynamicSchemaKey() {
		return xsltDynamicSchemaKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXsltDynamicSchemaKey(NamespacedProperty newXsltDynamicSchemaKey, NotificationChain msgs) {
		NamespacedProperty oldXsltDynamicSchemaKey = xsltDynamicSchemaKey;
		xsltDynamicSchemaKey = newXsltDynamicSchemaKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, oldXsltDynamicSchemaKey, newXsltDynamicSchemaKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltDynamicSchemaKey(NamespacedProperty newXsltDynamicSchemaKey) {
		if (newXsltDynamicSchemaKey != xsltDynamicSchemaKey) {
			NotificationChain msgs = null;
			if (xsltDynamicSchemaKey != null)
				msgs = ((InternalEObject)xsltDynamicSchemaKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, null, msgs);
			if (newXsltDynamicSchemaKey != null)
				msgs = ((InternalEObject)newXsltDynamicSchemaKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, null, msgs);
			msgs = basicSetXsltDynamicSchemaKey(newXsltDynamicSchemaKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY, newXsltDynamicSchemaKey, newXsltDynamicSchemaKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getXsltKey() {
		return xsltKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXsltKey(RegistryKeyProperty newXsltKey, NotificationChain msgs) {
		RegistryKeyProperty oldXsltKey = xsltKey;
		xsltKey = newXsltKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_KEY, oldXsltKey, newXsltKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXsltKey(RegistryKeyProperty newXsltKey) {
		if (newXsltKey != xsltKey) {
			NotificationChain msgs = null;
			if (xsltKey != null)
				msgs = ((InternalEObject)xsltKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_KEY, null, msgs);
			if (newXsltKey != null)
				msgs = ((InternalEObject)newXsltKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__XSLT_KEY, null, msgs);
			msgs = basicSetXsltKey(newXsltKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__XSLT_KEY, newXsltKey, newXsltKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSourceXPath() {
		return sourceXPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceXPath(NamespacedProperty newSourceXPath, NotificationChain msgs) {
		NamespacedProperty oldSourceXPath = sourceXPath;
		sourceXPath = newSourceXPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH, oldSourceXPath, newSourceXPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXPath(NamespacedProperty newSourceXPath) {
		if (newSourceXPath != sourceXPath) {
			NotificationChain msgs = null;
			if (sourceXPath != null)
				msgs = ((InternalEObject)sourceXPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXPath != null)
				msgs = ((InternalEObject)newSourceXPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXPath(newSourceXPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH, newSourceXPath, newSourceXPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<XSLTProperty>(XSLTProperty.class, this, EsbPackage.XSLT_MEDIATOR__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<XSLTFeature>(XSLTFeature.class, this, EsbPackage.XSLT_MEDIATOR__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XSLTResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<XSLTResource>(XSLTResource.class, this, EsbPackage.XSLT_MEDIATOR__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				return basicSetXsltStaticSchemaKey(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				return basicSetXsltDynamicSchemaKey(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__XSLT_KEY:
				return basicSetXsltKey(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXPath(null, msgs);
			case EsbPackage.XSLT_MEDIATOR__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EsbPackage.XSLT_MEDIATOR__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case EsbPackage.XSLT_MEDIATOR__RESOURCES:
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
			case EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				return getXsltSchemaKeyType();
			case EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				return getXsltStaticSchemaKey();
			case EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				return getXsltDynamicSchemaKey();
			case EsbPackage.XSLT_MEDIATOR__XSLT_KEY:
				return getXsltKey();
			case EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return getSourceXPath();
			case EsbPackage.XSLT_MEDIATOR__PROPERTIES:
				return getProperties();
			case EsbPackage.XSLT_MEDIATOR__FEATURES:
				return getFeatures();
			case EsbPackage.XSLT_MEDIATOR__RESOURCES:
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
			case EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((XSLTMediatorInputConnector)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((XSLTMediatorOutputConnector)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				setXsltSchemaKeyType((KeyType)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				setXsltStaticSchemaKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				setXsltDynamicSchemaKey((NamespacedProperty)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_KEY:
				setXsltKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				setSourceXPath((NamespacedProperty)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends XSLTProperty>)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends XSLTFeature>)newValue);
				return;
			case EsbPackage.XSLT_MEDIATOR__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends XSLTResource>)newValue);
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
			case EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((XSLTMediatorInputConnector)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((XSLTMediatorOutputConnector)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				setXsltSchemaKeyType(XSLT_SCHEMA_KEY_TYPE_EDEFAULT);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				setXsltStaticSchemaKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				setXsltDynamicSchemaKey((NamespacedProperty)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__XSLT_KEY:
				setXsltKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				setSourceXPath((NamespacedProperty)null);
				return;
			case EsbPackage.XSLT_MEDIATOR__PROPERTIES:
				getProperties().clear();
				return;
			case EsbPackage.XSLT_MEDIATOR__FEATURES:
				getFeatures().clear();
				return;
			case EsbPackage.XSLT_MEDIATOR__RESOURCES:
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
			case EsbPackage.XSLT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.XSLT_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE:
				return xsltSchemaKeyType != XSLT_SCHEMA_KEY_TYPE_EDEFAULT;
			case EsbPackage.XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY:
				return xsltStaticSchemaKey != null;
			case EsbPackage.XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY:
				return xsltDynamicSchemaKey != null;
			case EsbPackage.XSLT_MEDIATOR__XSLT_KEY:
				return xsltKey != null;
			case EsbPackage.XSLT_MEDIATOR__SOURCE_XPATH:
				return sourceXPath != null;
			case EsbPackage.XSLT_MEDIATOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EsbPackage.XSLT_MEDIATOR__FEATURES:
				return features != null && !features.isEmpty();
			case EsbPackage.XSLT_MEDIATOR__RESOURCES:
				return resources != null && !resources.isEmpty();
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
		result.append(" (xsltSchemaKeyType: ");
		result.append(xsltSchemaKeyType);
		result.append(')');
		return result.toString();
	}

} //XSLTMediatorImpl
