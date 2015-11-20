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

import org.wso2.developerstudio.eclipse.gmf.esb.CacheAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheImplementationType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorOnHitOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheScope;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cache Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheId <em>Cache Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheScope <em>Cache Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheAction <em>Cache Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getOnHitOutputConnector <em>On Hit Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CacheMediatorImpl extends MediatorImpl implements CacheMediator {
	/**
	 * The default value of the '{@link #getCacheId() <em>Cache Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String CACHE_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getCacheId() <em>Cache Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheId()
	 * @generated
	 * @ordered
	 */
	protected String cacheId = CACHE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCacheScope() <em>Cache Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheScope()
	 * @generated
	 * @ordered
	 */
	protected static final CacheScope CACHE_SCOPE_EDEFAULT = CacheScope.PER_MEDIATOR;

	/**
	 * The cached value of the '{@link #getCacheScope() <em>Cache Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheScope()
	 * @generated
	 * @ordered
	 */
	protected CacheScope cacheScope = CACHE_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCacheAction() <em>Cache Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheAction()
	 * @generated
	 * @ordered
	 */
	protected static final CacheAction CACHE_ACTION_EDEFAULT = CacheAction.FINDER;

	/**
	 * The cached value of the '{@link #getCacheAction() <em>Cache Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheAction()
	 * @generated
	 * @ordered
	 */
	protected CacheAction cacheAction = CACHE_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHashGenerator() <em>Hash Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHashGenerator()
	 * @generated
	 * @ordered
	 */
	protected static final String HASH_GENERATOR_EDEFAULT = "org.wso2.caching.digest.DOMHashGenerator";

	/**
	 * The cached value of the '{@link #getHashGenerator() <em>Hash Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHashGenerator()
	 * @generated
	 * @ordered
	 */
	protected String hashGenerator = HASH_GENERATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCacheTimeout() <em>Cache Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int CACHE_TIMEOUT_EDEFAULT = 120;

	/**
	 * The cached value of the '{@link #getCacheTimeout() <em>Cache Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheTimeout()
	 * @generated
	 * @ordered
	 */
	protected int cacheTimeout = CACHE_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxMessageSize() <em>Max Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMessageSize()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_MESSAGE_SIZE_EDEFAULT = 2000;

	/**
	 * The cached value of the '{@link #getMaxMessageSize() <em>Max Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMessageSize()
	 * @generated
	 * @ordered
	 */
	protected int maxMessageSize = MAX_MESSAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementationType() <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationType()
	 * @generated
	 * @ordered
	 */
	protected static final CacheImplementationType IMPLEMENTATION_TYPE_EDEFAULT = CacheImplementationType.IN_MEMORY;

	/**
	 * The cached value of the '{@link #getImplementationType() <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationType()
	 * @generated
	 * @ordered
	 */
	protected CacheImplementationType implementationType = IMPLEMENTATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEntryCount() <em>Max Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEntryCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_ENTRY_COUNT_EDEFAULT = 1000;

	/**
	 * The cached value of the '{@link #getMaxEntryCount() <em>Max Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEntryCount()
	 * @generated
	 * @ordered
	 */
	protected int maxEntryCount = MAX_ENTRY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated NOT
	 * @ordered
	 */
	protected static final CacheSequenceType SEQUENCE_TYPE_EDEFAULT = CacheSequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected CacheSequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CacheMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CacheMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOnHitOutputConnector() <em>On Hit Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnHitOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CacheMediatorOnHitOutputConnector onHitOutputConnector;

	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CacheMediatorImpl() {
		super();
		
		RegistryKeyProperty keyproperty = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		keyproperty.setKeyName("keyName");
		keyproperty.setPrettyName("prettyName");
		keyproperty.setKeyValue("default/path");		
		setSequenceKey(keyproperty);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CACHE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCacheId() {
		return cacheId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheId(String newCacheId) {
		String oldCacheId = cacheId;
		cacheId = newCacheId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_ID, oldCacheId, cacheId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheScope getCacheScope() {
		return cacheScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheScope(CacheScope newCacheScope) {
		CacheScope oldCacheScope = cacheScope;
		cacheScope = newCacheScope == null ? CACHE_SCOPE_EDEFAULT : newCacheScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE, oldCacheScope, cacheScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheAction getCacheAction() {
		return cacheAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheAction(CacheAction newCacheAction) {
		CacheAction oldCacheAction = cacheAction;
		cacheAction = newCacheAction == null ? CACHE_ACTION_EDEFAULT : newCacheAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_ACTION, oldCacheAction, cacheAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHashGenerator() {
		return hashGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHashGenerator(String newHashGenerator) {
		String oldHashGenerator = hashGenerator;
		hashGenerator = newHashGenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR, oldHashGenerator, hashGenerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCacheTimeout() {
		return cacheTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheTimeout(int newCacheTimeout) {
		int oldCacheTimeout = cacheTimeout;
		cacheTimeout = newCacheTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT, oldCacheTimeout, cacheTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxMessageSize() {
		return maxMessageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMessageSize(int newMaxMessageSize) {
		int oldMaxMessageSize = maxMessageSize;
		maxMessageSize = newMaxMessageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE, oldMaxMessageSize, maxMessageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheImplementationType getImplementationType() {
		return implementationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationType(CacheImplementationType newImplementationType) {
		CacheImplementationType oldImplementationType = implementationType;
		implementationType = newImplementationType == null ? IMPLEMENTATION_TYPE_EDEFAULT : newImplementationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE, oldImplementationType, implementationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxEntryCount() {
		return maxEntryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEntryCount(int newMaxEntryCount) {
		int oldMaxEntryCount = maxEntryCount;
		maxEntryCount = newMaxEntryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT, oldMaxEntryCount, maxEntryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheSequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(CacheSequenceType newSequenceType) {
		CacheSequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CacheMediatorInputConnector newInputConnector, NotificationChain msgs) {
		CacheMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CacheMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CacheMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		CacheMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CacheMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorOnHitOutputConnector getOnHitOutputConnector() {
		return onHitOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnHitOutputConnector(CacheMediatorOnHitOutputConnector newOnHitOutputConnector, NotificationChain msgs) {
		CacheMediatorOnHitOutputConnector oldOnHitOutputConnector = onHitOutputConnector;
		onHitOutputConnector = newOnHitOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR, oldOnHitOutputConnector, newOnHitOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnHitOutputConnector(CacheMediatorOnHitOutputConnector newOnHitOutputConnector) {
		if (newOnHitOutputConnector != onHitOutputConnector) {
			NotificationChain msgs = null;
			if (onHitOutputConnector != null)
				msgs = ((InternalEObject)onHitOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR, null, msgs);
			if (newOnHitOutputConnector != null)
				msgs = ((InternalEObject)newOnHitOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnHitOutputConnector(newOnHitOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR, newOnHitOutputConnector, newOnHitOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
				return basicSetOnHitOutputConnector(null, msgs);
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
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
			case EsbPackage.CACHE_MEDIATOR__CACHE_ID:
				return getCacheId();
			case EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				return getCacheScope();
			case EsbPackage.CACHE_MEDIATOR__CACHE_ACTION:
				return getCacheAction();
			case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				return getHashGenerator();
			case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				return getCacheTimeout();
			case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				return getMaxMessageSize();
			case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				return getImplementationType();
			case EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				return getMaxEntryCount();
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
				return getOnHitOutputConnector();
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
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
			case EsbPackage.CACHE_MEDIATOR__CACHE_ID:
				setCacheId((String)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				setCacheScope((CacheScope)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_ACTION:
				setCacheAction((CacheAction)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				setHashGenerator((String)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				setCacheTimeout((Integer)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				setMaxMessageSize((Integer)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				setImplementationType((CacheImplementationType)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				setMaxEntryCount((Integer)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((CacheSequenceType)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CacheMediatorInputConnector)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CacheMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
				setOnHitOutputConnector((CacheMediatorOnHitOutputConnector)newValue);
				return;
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
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
			case EsbPackage.CACHE_MEDIATOR__CACHE_ID:
				setCacheId(CACHE_ID_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				setCacheScope(CACHE_SCOPE_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_ACTION:
				setCacheAction(CACHE_ACTION_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				setHashGenerator(HASH_GENERATOR_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				setCacheTimeout(CACHE_TIMEOUT_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				setMaxMessageSize(MAX_MESSAGE_SIZE_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				setImplementationType(IMPLEMENTATION_TYPE_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				setMaxEntryCount(MAX_ENTRY_COUNT_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CacheMediatorInputConnector)null);
				return;
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CacheMediatorOutputConnector)null);
				return;
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
				setOnHitOutputConnector((CacheMediatorOnHitOutputConnector)null);
				return;
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
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
			case EsbPackage.CACHE_MEDIATOR__CACHE_ID:
				return CACHE_ID_EDEFAULT == null ? cacheId != null : !CACHE_ID_EDEFAULT.equals(cacheId);
			case EsbPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				return cacheScope != CACHE_SCOPE_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__CACHE_ACTION:
				return cacheAction != CACHE_ACTION_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				return HASH_GENERATOR_EDEFAULT == null ? hashGenerator != null : !HASH_GENERATOR_EDEFAULT.equals(hashGenerator);
			case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				return cacheTimeout != CACHE_TIMEOUT_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				return maxMessageSize != MAX_MESSAGE_SIZE_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				return implementationType != IMPLEMENTATION_TYPE_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				return maxEntryCount != MAX_ENTRY_COUNT_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.CACHE_MEDIATOR__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.CACHE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CACHE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CACHE_MEDIATOR__ON_HIT_OUTPUT_CONNECTOR:
				return onHitOutputConnector != null;
			case EsbPackage.CACHE_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
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
		result.append(" (cacheId: ");
		result.append(cacheId);
		result.append(", cacheScope: ");
		result.append(cacheScope);
		result.append(", cacheAction: ");
		result.append(cacheAction);
		result.append(", hashGenerator: ");
		result.append(hashGenerator);
		result.append(", cacheTimeout: ");
		result.append(cacheTimeout);
		result.append(", maxMessageSize: ");
		result.append(maxMessageSize);
		result.append(", implementationType: ");
		result.append(implementationType);
		result.append(", maxEntryCount: ");
		result.append(maxEntryCount);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(')');
		return result.toString();
	}

} //CacheMediatorImpl
