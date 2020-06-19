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
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediatorType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheProtocolType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheScope;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheScopeType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.HashGenerator;
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
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheProtocolType <em>Cache Protocol Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheType <em>Cache Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheProtocolMethods <em>Cache Protocol Methods</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getOnHitOutputConnector <em>On Hit Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getHeadersToExcludeInHash <em>Headers To Exclude In Hash</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getResponseCodes <em>Response Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#isEnableCacheControl <em>Enable Cache Control</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#isIncludeAgeHeader <em>Include Age Header</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getHashGeneratorAttribute <em>Hash Generator Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CacheMediatorImpl#getCacheMediatorImplementation <em>Cache Mediator Implementation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CacheMediatorImpl extends MediatorImpl implements CacheMediator {
    /**
     * The default value of the '{@link #getCacheProtocolType() <em>Cache Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheProtocolType()
     * @generated
     * @ordered
     */
    protected static final CacheProtocolType CACHE_PROTOCOL_TYPE_EDEFAULT = CacheProtocolType.HTTP;

    /**
     * The cached value of the '{@link #getCacheProtocolType() <em>Cache Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheProtocolType()
     * @generated
     * @ordered
     */
    protected CacheProtocolType cacheProtocolType = CACHE_PROTOCOL_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getCacheType() <em>Cache Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheType()
     * @generated
     * @ordered
     */
    protected static final CacheType CACHE_TYPE_EDEFAULT = CacheType.FINDER;

    /**
     * The cached value of the '{@link #getCacheType() <em>Cache Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheType()
     * @generated
     * @ordered
     */
    protected CacheType cacheType = CACHE_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getHashGenerator() <em>Hash Generator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHashGenerator()
     * @generated
     * @ordered
     */
    protected static final String HASH_GENERATOR_EDEFAULT = "org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator";

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
     * The default value of the '{@link #getCacheProtocolMethods() <em>Cache Protocol Methods</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheProtocolMethods()
     * @generated
     * @ordered
     */
    protected static final String CACHE_PROTOCOL_METHODS_EDEFAULT = "*";

    /**
     * The cached value of the '{@link #getCacheProtocolMethods() <em>Cache Protocol Methods</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheProtocolMethods()
     * @generated
     * @ordered
     */
    protected String cacheProtocolMethods = CACHE_PROTOCOL_METHODS_EDEFAULT;

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
     * 
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
     * The default value of the '{@link #getHeadersToExcludeInHash() <em>Headers To Exclude In Hash</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeadersToExcludeInHash()
     * @generated
     * @ordered
     */
    protected static final String HEADERS_TO_EXCLUDE_IN_HASH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeadersToExcludeInHash() <em>Headers To Exclude In Hash</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeadersToExcludeInHash()
     * @generated
     * @ordered
     */
    protected String headersToExcludeInHash = HEADERS_TO_EXCLUDE_IN_HASH_EDEFAULT;

    /**
     * The default value of the '{@link #getResponseCodes() <em>Response Codes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResponseCodes()
     * @generated
     * @ordered
     */
    protected static final String RESPONSE_CODES_EDEFAULT = ".*";

    /**
     * The cached value of the '{@link #getResponseCodes() <em>Response Codes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResponseCodes()
     * @generated
     * @ordered
     */
    protected String responseCodes = RESPONSE_CODES_EDEFAULT;

    /**
     * The default value of the '{@link #isEnableCacheControl() <em>Enable Cache Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableCacheControl()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_CACHE_CONTROL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEnableCacheControl() <em>Enable Cache Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableCacheControl()
     * @generated
     * @ordered
     */
    protected boolean enableCacheControl = ENABLE_CACHE_CONTROL_EDEFAULT;

    /**
     * The default value of the '{@link #isIncludeAgeHeader() <em>Include Age Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludeAgeHeader()
     * @generated
     * @ordered
     */
    protected static final boolean INCLUDE_AGE_HEADER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIncludeAgeHeader() <em>Include Age Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludeAgeHeader()
     * @generated
     * @ordered
     */
    protected boolean includeAgeHeader = INCLUDE_AGE_HEADER_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getHashGeneratorAttribute() <em>Hash Generator Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHashGeneratorAttribute()
     * @generated
     * @ordered
     */
    protected static final String HASH_GENERATOR_ATTRIBUTE_EDEFAULT = "org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator";

    /**
     * The cached value of the '{@link #getHashGeneratorAttribute() <em>Hash Generator Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHashGeneratorAttribute()
     * @generated
     * @ordered
     */
    protected String hashGeneratorAttribute = HASH_GENERATOR_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScope()
     * @generated
     * @ordered
     */
    protected static final CacheScopeType SCOPE_EDEFAULT = CacheScopeType.PER_HOST;

    /**
     * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScope()
     * @generated
     * @ordered
     */
    protected CacheScopeType scope = SCOPE_EDEFAULT;

    /**
     * The default value of the '{@link #getImplementationType() <em>Implementation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImplementationType()
     * @generated
     * @ordered
     */
    protected static final CacheImplementationType IMPLEMENTATION_TYPE_EDEFAULT = CacheImplementationType.MEMORY;

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
     * The default value of the '{@link #getCacheMediatorImplementation() <em>Cache Mediator Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheMediatorImplementation()
     * @generated
     * @ordered
     */
    protected static final CacheMediatorType CACHE_MEDIATOR_IMPLEMENTATION_EDEFAULT = CacheMediatorType.DEFAULT;

    /**
     * The cached value of the '{@link #getCacheMediatorImplementation() <em>Cache Mediator Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCacheMediatorImplementation()
     * @generated
     * @ordered
     */
    protected CacheMediatorType cacheMediatorImplementation = CACHE_MEDIATOR_IMPLEMENTATION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected CacheMediatorImpl() {
        super();

        RegistryKeyProperty keyproperty = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
        keyproperty.setKeyName("keyName");
        keyproperty.setPrettyName("prettyName");
        keyproperty.setKeyValue("");
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
    public CacheProtocolType getCacheProtocolType() {
        return cacheProtocolType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCacheProtocolType(CacheProtocolType newCacheProtocolType) {
        CacheProtocolType oldCacheProtocolType = cacheProtocolType;
        cacheProtocolType = newCacheProtocolType == null ? CACHE_PROTOCOL_TYPE_EDEFAULT : newCacheProtocolType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE, oldCacheProtocolType, cacheProtocolType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CacheType getCacheType() {
        return cacheType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCacheType(CacheType newCacheType) {
        CacheType oldCacheType = cacheType;
        cacheType = newCacheType == null ? CACHE_TYPE_EDEFAULT : newCacheType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_TYPE, oldCacheType, cacheType));
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
    public String getCacheProtocolMethods() {
        return cacheProtocolMethods;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCacheProtocolMethods(String newCacheProtocolMethods) {
        String oldCacheProtocolMethods = cacheProtocolMethods;
        cacheProtocolMethods = newCacheProtocolMethods;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS, oldCacheProtocolMethods, cacheProtocolMethods));
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
    public NotificationChain basicSetInputConnector(CacheMediatorInputConnector newInputConnector,
            NotificationChain msgs) {
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
    public NotificationChain basicSetOutputConnector(CacheMediatorOutputConnector newOutputConnector,
            NotificationChain msgs) {
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
    public NotificationChain basicSetOnHitOutputConnector(CacheMediatorOnHitOutputConnector newOnHitOutputConnector,
            NotificationChain msgs) {
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
    public String getHeadersToExcludeInHash() {
        return headersToExcludeInHash;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeadersToExcludeInHash(String newHeadersToExcludeInHash) {
        String oldHeadersToExcludeInHash = headersToExcludeInHash;
        headersToExcludeInHash = newHeadersToExcludeInHash;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH, oldHeadersToExcludeInHash, headersToExcludeInHash));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getResponseCodes() {
        return responseCodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResponseCodes(String newResponseCodes) {
        String oldResponseCodes = responseCodes;
        responseCodes = newResponseCodes;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__RESPONSE_CODES, oldResponseCodes, responseCodes));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnableCacheControl() {
        return enableCacheControl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnableCacheControl(boolean newEnableCacheControl) {
        boolean oldEnableCacheControl = enableCacheControl;
        enableCacheControl = newEnableCacheControl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL, oldEnableCacheControl, enableCacheControl));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIncludeAgeHeader() {
        return includeAgeHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIncludeAgeHeader(boolean newIncludeAgeHeader) {
        boolean oldIncludeAgeHeader = includeAgeHeader;
        includeAgeHeader = newIncludeAgeHeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__INCLUDE_AGE_HEADER, oldIncludeAgeHeader, includeAgeHeader));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHashGeneratorAttribute() {
        return hashGeneratorAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHashGeneratorAttribute(String newHashGeneratorAttribute) {
        String oldHashGeneratorAttribute = hashGeneratorAttribute;
        hashGeneratorAttribute = newHashGeneratorAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR_ATTRIBUTE, oldHashGeneratorAttribute, hashGeneratorAttribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CacheScopeType getScope() {
        return scope;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScope(CacheScopeType newScope) {
        CacheScopeType oldScope = scope;
        scope = newScope == null ? SCOPE_EDEFAULT : newScope;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__SCOPE, oldScope, scope));
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
    public CacheMediatorType getCacheMediatorImplementation() {
        return cacheMediatorImplementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCacheMediatorImplementation(CacheMediatorType newCacheMediatorImplementation) {
        CacheMediatorType oldCacheMediatorImplementation = cacheMediatorImplementation;
        cacheMediatorImplementation = newCacheMediatorImplementation == null ? CACHE_MEDIATOR_IMPLEMENTATION_EDEFAULT : newCacheMediatorImplementation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CACHE_MEDIATOR__CACHE_MEDIATOR_IMPLEMENTATION, oldCacheMediatorImplementation, cacheMediatorImplementation));
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE:
                return getCacheProtocolType();
            case EsbPackage.CACHE_MEDIATOR__CACHE_TYPE:
                return getCacheType();
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
                return getHashGenerator();
            case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
                return getCacheTimeout();
            case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
                return getMaxMessageSize();
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS:
                return getCacheProtocolMethods();
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
            case EsbPackage.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH:
                return getHeadersToExcludeInHash();
            case EsbPackage.CACHE_MEDIATOR__RESPONSE_CODES:
                return getResponseCodes();
            case EsbPackage.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL:
                return isEnableCacheControl();
            case EsbPackage.CACHE_MEDIATOR__INCLUDE_AGE_HEADER:
                return isIncludeAgeHeader();
            case EsbPackage.CACHE_MEDIATOR__ID:
                return getId();
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR_ATTRIBUTE:
                return getHashGeneratorAttribute();
            case EsbPackage.CACHE_MEDIATOR__SCOPE:
                return getScope();
            case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
                return getImplementationType();
            case EsbPackage.CACHE_MEDIATOR__CACHE_MEDIATOR_IMPLEMENTATION:
                return getCacheMediatorImplementation();
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE:
                setCacheProtocolType((CacheProtocolType)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__CACHE_TYPE:
                setCacheType((CacheType)newValue);
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS:
                setCacheProtocolMethods((String)newValue);
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
            case EsbPackage.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH:
                setHeadersToExcludeInHash((String)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__RESPONSE_CODES:
                setResponseCodes((String)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL:
                setEnableCacheControl((Boolean)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__INCLUDE_AGE_HEADER:
                setIncludeAgeHeader((Boolean)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__ID:
                setId((String)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR_ATTRIBUTE:
                setHashGeneratorAttribute((String)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__SCOPE:
                setScope((CacheScopeType)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
                setImplementationType((CacheImplementationType)newValue);
                return;
            case EsbPackage.CACHE_MEDIATOR__CACHE_MEDIATOR_IMPLEMENTATION:
                setCacheMediatorImplementation((CacheMediatorType)newValue);
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE:
                setCacheProtocolType(CACHE_PROTOCOL_TYPE_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__CACHE_TYPE:
                setCacheType(CACHE_TYPE_EDEFAULT);
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS:
                setCacheProtocolMethods(CACHE_PROTOCOL_METHODS_EDEFAULT);
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
            case EsbPackage.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH:
                setHeadersToExcludeInHash(HEADERS_TO_EXCLUDE_IN_HASH_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__RESPONSE_CODES:
                setResponseCodes(RESPONSE_CODES_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL:
                setEnableCacheControl(ENABLE_CACHE_CONTROL_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__INCLUDE_AGE_HEADER:
                setIncludeAgeHeader(INCLUDE_AGE_HEADER_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__ID:
                setId(ID_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR_ATTRIBUTE:
                setHashGeneratorAttribute(HASH_GENERATOR_ATTRIBUTE_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__SCOPE:
                setScope(SCOPE_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
                setImplementationType(IMPLEMENTATION_TYPE_EDEFAULT);
                return;
            case EsbPackage.CACHE_MEDIATOR__CACHE_MEDIATOR_IMPLEMENTATION:
                setCacheMediatorImplementation(CACHE_MEDIATOR_IMPLEMENTATION_EDEFAULT);
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
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE:
                return cacheProtocolType != CACHE_PROTOCOL_TYPE_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__CACHE_TYPE:
                return cacheType != CACHE_TYPE_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR:
                return HASH_GENERATOR_EDEFAULT == null ? hashGenerator != null : !HASH_GENERATOR_EDEFAULT.equals(hashGenerator);
            case EsbPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
                return cacheTimeout != CACHE_TIMEOUT_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
                return maxMessageSize != MAX_MESSAGE_SIZE_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS:
                return CACHE_PROTOCOL_METHODS_EDEFAULT == null ? cacheProtocolMethods != null : !CACHE_PROTOCOL_METHODS_EDEFAULT.equals(cacheProtocolMethods);
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
            case EsbPackage.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH:
                return HEADERS_TO_EXCLUDE_IN_HASH_EDEFAULT == null ? headersToExcludeInHash != null : !HEADERS_TO_EXCLUDE_IN_HASH_EDEFAULT.equals(headersToExcludeInHash);
            case EsbPackage.CACHE_MEDIATOR__RESPONSE_CODES:
                return RESPONSE_CODES_EDEFAULT == null ? responseCodes != null : !RESPONSE_CODES_EDEFAULT.equals(responseCodes);
            case EsbPackage.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL:
                return enableCacheControl != ENABLE_CACHE_CONTROL_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__INCLUDE_AGE_HEADER:
                return includeAgeHeader != INCLUDE_AGE_HEADER_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case EsbPackage.CACHE_MEDIATOR__HASH_GENERATOR_ATTRIBUTE:
                return HASH_GENERATOR_ATTRIBUTE_EDEFAULT == null ? hashGeneratorAttribute != null : !HASH_GENERATOR_ATTRIBUTE_EDEFAULT.equals(hashGeneratorAttribute);
            case EsbPackage.CACHE_MEDIATOR__SCOPE:
                return scope != SCOPE_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
                return implementationType != IMPLEMENTATION_TYPE_EDEFAULT;
            case EsbPackage.CACHE_MEDIATOR__CACHE_MEDIATOR_IMPLEMENTATION:
                return cacheMediatorImplementation != CACHE_MEDIATOR_IMPLEMENTATION_EDEFAULT;
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
        result.append(" (cacheProtocolType: ");
        result.append(cacheProtocolType);
        result.append(", cacheType: ");
        result.append(cacheType);
        result.append(", hashGenerator: ");
        result.append(hashGenerator);
        result.append(", cacheTimeout: ");
        result.append(cacheTimeout);
        result.append(", maxMessageSize: ");
        result.append(maxMessageSize);
        result.append(", cacheProtocolMethods: ");
        result.append(cacheProtocolMethods);
        result.append(", maxEntryCount: ");
        result.append(maxEntryCount);
        result.append(", sequenceType: ");
        result.append(sequenceType);
        result.append(", headersToExcludeInHash: ");
        result.append(headersToExcludeInHash);
        result.append(", responseCodes: ");
        result.append(responseCodes);
        result.append(", enableCacheControl: ");
        result.append(enableCacheControl);
        result.append(", includeAgeHeader: ");
        result.append(includeAgeHeader);
        result.append(", id: ");
        result.append(id);
        result.append(", hashGeneratorAttribute: ");
        result.append(hashGeneratorAttribute);
        result.append(", scope: ");
        result.append(scope);
        result.append(", implementationType: ");
        result.append(implementationType);
        result.append(", cacheMediatorImplementation: ");
        result.append(cacheMediatorImplementation);
        result.append(')');
        return result.toString();
    }

} // CacheMediatorImpl
