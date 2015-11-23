/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceInlineType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichTargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enrich Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#isCloneSource <em>Clone Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getSourceXML <em>Source XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getTargetAction <em>Target Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getTargetXpath <em>Target Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getInlineType <em>Inline Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getInlineRegistryKey <em>Inline Registry Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EnrichMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnrichMediatorImpl extends MediatorImpl implements EnrichMediator {
	/**
	 * The default value of the '{@link #isCloneSource() <em>Clone Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCloneSource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLONE_SOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCloneSource() <em>Clone Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCloneSource()
	 * @generated
	 * @ordered
	 */
	protected boolean cloneSource = CLONE_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected static final EnrichSourceType SOURCE_TYPE_EDEFAULT = EnrichSourceType.CUSTOM;

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected EnrichSourceType sourceType = SOURCE_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getSourceProperty() <em>Source Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_PROPERTY_EDEFAULT = "source_property";

	/**
	 * The cached value of the '{@link #getSourceProperty() <em>Source Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceProperty()
	 * @generated
	 * @ordered
	 */
	protected String sourceProperty = SOURCE_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceXML() <em>Source XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXML()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_XML_EDEFAULT = "<inline/>";

	/**
	 * The cached value of the '{@link #getSourceXML() <em>Source XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXML()
	 * @generated
	 * @ordered
	 */
	protected String sourceXML = SOURCE_XML_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetAction() <em>Target Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAction()
	 * @generated
	 * @ordered
	 */
	protected static final EnrichTargetAction TARGET_ACTION_EDEFAULT = EnrichTargetAction.REPLACE;

	/**
	 * The cached value of the '{@link #getTargetAction() <em>Target Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAction()
	 * @generated
	 * @ordered
	 */
	protected EnrichTargetAction targetAction = TARGET_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final EnrichTargetType TARGET_TYPE_EDEFAULT = EnrichTargetType.CUSTOM;

	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected EnrichTargetType targetType = TARGET_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetXpath() <em>Target Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty targetXpath;

	/**
	 * The default value of the '{@link #getTargetProperty() <em>Target Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_PROPERTY_EDEFAULT = "target_property";

	/**
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected String targetProperty = TARGET_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInlineType() <em>Inline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlineType()
	 * @generated
	 * @ordered
	 */
	protected static final EnrichSourceInlineType INLINE_TYPE_EDEFAULT = EnrichSourceInlineType.CONTENT;

	/**
	 * The cached value of the '{@link #getInlineType() <em>Inline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlineType()
	 * @generated
	 * @ordered
	 */
	protected EnrichSourceInlineType inlineType = INLINE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInlineRegistryKey() <em>Inline Registry Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlineRegistryKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inlineRegistryKey;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected EnrichMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EnrichMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EnrichMediatorImpl() {
		super();
		
		// Source xpath.
		NamespacedProperty sourceXpath = EsbFactory.eINSTANCE.createNamespacedProperty();
		sourceXpath.setPrettyName("Source XPath");
		sourceXpath.setPropertyName("xpath");
		sourceXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);		
		setSourceXpath(sourceXpath);
		
		// Target xpath.
		NamespacedProperty targetXpath = EsbFactory.eINSTANCE.createNamespacedProperty();
		targetXpath.setPrettyName("Target XPath");
		targetXpath.setPropertyName("xpath");
		targetXpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);
		setTargetXpath(targetXpath);
		
		// Inline Registry Key
		inlineRegistryKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) inlineRegistryKey.getFilters(),
				CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		inlineRegistryKey.setPrettyName("InlineKey");
		inlineRegistryKey.setKeyName("key");
		inlineRegistryKey.setKeyValue(DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY);
		setInlineRegistryKey(inlineRegistryKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ENRICH_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCloneSource() {
		return cloneSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloneSource(boolean newCloneSource) {
		boolean oldCloneSource = cloneSource;
		cloneSource = newCloneSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE, oldCloneSource, cloneSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichSourceType getSourceType() {
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(EnrichSourceType newSourceType) {
		EnrichSourceType oldSourceType = sourceType;
		sourceType = newSourceType == null ? SOURCE_TYPE_EDEFAULT : newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE, oldSourceType, sourceType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH, oldSourceXpath, newSourceXpath);
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
				msgs = ((InternalEObject)sourceXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXpath != null)
				msgs = ((InternalEObject)newSourceXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXpath(newSourceXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH, newSourceXpath, newSourceXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceProperty() {
		return sourceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceProperty(String newSourceProperty) {
		String oldSourceProperty = sourceProperty;
		sourceProperty = newSourceProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY, oldSourceProperty, sourceProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceXML() {
		return sourceXML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXML(String newSourceXML) {
		String oldSourceXML = sourceXML;
		sourceXML = newSourceXML;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__SOURCE_XML, oldSourceXML, sourceXML));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichTargetAction getTargetAction() {
		return targetAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAction(EnrichTargetAction newTargetAction) {
		EnrichTargetAction oldTargetAction = targetAction;
		targetAction = newTargetAction == null ? TARGET_ACTION_EDEFAULT : newTargetAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION, oldTargetAction, targetAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichTargetType getTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(EnrichTargetType newTargetType) {
		EnrichTargetType oldTargetType = targetType;
		targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE, oldTargetType, targetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getTargetXpath() {
		return targetXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetXpath(NamespacedProperty newTargetXpath, NotificationChain msgs) {
		NamespacedProperty oldTargetXpath = targetXpath;
		targetXpath = newTargetXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH, oldTargetXpath, newTargetXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetXpath(NamespacedProperty newTargetXpath) {
		if (newTargetXpath != targetXpath) {
			NotificationChain msgs = null;
			if (targetXpath != null)
				msgs = ((InternalEObject)targetXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH, null, msgs);
			if (newTargetXpath != null)
				msgs = ((InternalEObject)newTargetXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH, null, msgs);
			msgs = basicSetTargetXpath(newTargetXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH, newTargetXpath, newTargetXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetProperty() {
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProperty(String newTargetProperty) {
		String oldTargetProperty = targetProperty;
		targetProperty = newTargetProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichSourceInlineType getInlineType() {
		return inlineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlineType(EnrichSourceInlineType newInlineType) {
		EnrichSourceInlineType oldInlineType = inlineType;
		inlineType = newInlineType == null ? INLINE_TYPE_EDEFAULT : newInlineType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE, oldInlineType, inlineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInlineRegistryKey() {
		return inlineRegistryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInlineRegistryKey(RegistryKeyProperty newInlineRegistryKey, NotificationChain msgs) {
		RegistryKeyProperty oldInlineRegistryKey = inlineRegistryKey;
		inlineRegistryKey = newInlineRegistryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY, oldInlineRegistryKey, newInlineRegistryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlineRegistryKey(RegistryKeyProperty newInlineRegistryKey) {
		if (newInlineRegistryKey != inlineRegistryKey) {
			NotificationChain msgs = null;
			if (inlineRegistryKey != null)
				msgs = ((InternalEObject)inlineRegistryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY, null, msgs);
			if (newInlineRegistryKey != null)
				msgs = ((InternalEObject)newInlineRegistryKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY, null, msgs);
			msgs = basicSetInlineRegistryKey(newInlineRegistryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY, newInlineRegistryKey, newInlineRegistryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(EnrichMediatorInputConnector newInputConnector, NotificationChain msgs) {
		EnrichMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(EnrichMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(EnrichMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		EnrichMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(EnrichMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXpath(null, msgs);
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
				return basicSetTargetXpath(null, msgs);
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
				return basicSetInlineRegistryKey(null, msgs);
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
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
			case EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
				return isCloneSource();
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
				return getSourceType();
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
				return getSourceXpath();
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
				return getSourceProperty();
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XML:
				return getSourceXML();
			case EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION:
				return getTargetAction();
			case EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE:
				return getTargetType();
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
				return getTargetXpath();
			case EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
				return getTargetProperty();
			case EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE:
				return getInlineType();
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
				return getInlineRegistryKey();
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
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
			case EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
				setCloneSource((Boolean)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
				setSourceType((EnrichSourceType)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
				setSourceProperty((String)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XML:
				setSourceXML((String)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION:
				setTargetAction((EnrichTargetAction)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE:
				setTargetType((EnrichTargetType)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
				setTargetXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
				setTargetProperty((String)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE:
				setInlineType((EnrichSourceInlineType)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
				setInlineRegistryKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EnrichMediatorInputConnector)newValue);
				return;
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EnrichMediatorOutputConnector)newValue);
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
			case EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
				setCloneSource(CLONE_SOURCE_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
				setSourceType(SOURCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)null);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
				setSourceProperty(SOURCE_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XML:
				setSourceXML(SOURCE_XML_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION:
				setTargetAction(TARGET_ACTION_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE:
				setTargetType(TARGET_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
				setTargetXpath((NamespacedProperty)null);
				return;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
				setTargetProperty(TARGET_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE:
				setInlineType(INLINE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
				setInlineRegistryKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((EnrichMediatorInputConnector)null);
				return;
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((EnrichMediatorOutputConnector)null);
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
			case EsbPackage.ENRICH_MEDIATOR__CLONE_SOURCE:
				return cloneSource != CLONE_SOURCE_EDEFAULT;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_TYPE:
				return sourceType != SOURCE_TYPE_EDEFAULT;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XPATH:
				return sourceXpath != null;
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_PROPERTY:
				return SOURCE_PROPERTY_EDEFAULT == null ? sourceProperty != null : !SOURCE_PROPERTY_EDEFAULT.equals(sourceProperty);
			case EsbPackage.ENRICH_MEDIATOR__SOURCE_XML:
				return SOURCE_XML_EDEFAULT == null ? sourceXML != null : !SOURCE_XML_EDEFAULT.equals(sourceXML);
			case EsbPackage.ENRICH_MEDIATOR__TARGET_ACTION:
				return targetAction != TARGET_ACTION_EDEFAULT;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_TYPE:
				return targetType != TARGET_TYPE_EDEFAULT;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_XPATH:
				return targetXpath != null;
			case EsbPackage.ENRICH_MEDIATOR__TARGET_PROPERTY:
				return TARGET_PROPERTY_EDEFAULT == null ? targetProperty != null : !TARGET_PROPERTY_EDEFAULT.equals(targetProperty);
			case EsbPackage.ENRICH_MEDIATOR__INLINE_TYPE:
				return inlineType != INLINE_TYPE_EDEFAULT;
			case EsbPackage.ENRICH_MEDIATOR__INLINE_REGISTRY_KEY:
				return inlineRegistryKey != null;
			case EsbPackage.ENRICH_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.ENRICH_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
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
		result.append(" (cloneSource: ");
		result.append(cloneSource);
		result.append(", sourceType: ");
		result.append(sourceType);
		result.append(", sourceProperty: ");
		result.append(sourceProperty);
		result.append(", sourceXML: ");
		result.append(sourceXML);
		result.append(", targetAction: ");
		result.append(targetAction);
		result.append(", targetType: ");
		result.append(targetType);
		result.append(", targetProperty: ");
		result.append(targetProperty);
		result.append(", inlineType: ");
		result.append(inlineType);
		result.append(')');
		return result.toString();
	}

} //EnrichMediatorImpl
