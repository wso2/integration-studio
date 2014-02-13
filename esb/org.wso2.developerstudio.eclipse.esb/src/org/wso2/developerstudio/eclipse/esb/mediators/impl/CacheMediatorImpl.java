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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheAction;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheScope;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cache Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getCacheId <em>Cache Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getCacheScope <em>Cache Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getCacheAction <em>Cache Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl#getOnHitBranch <em>On Hit Branch</em>}</li>
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
	 * @generated
	 * @ordered
	 */
	protected static final String CACHE_ID_EDEFAULT = null;

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
	 * The cached value of the '{@link #getOnHitBranch() <em>On Hit Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnHitBranch()
	 * @generated
	 * @ordered
	 */
	protected CacheOnHitBranch onHitBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected CacheMediatorImpl() {
		super();
		
		// OnHit branch.
		//setOnHitBranch(getMediatorFactory().createCacheOnHitBranch()); /* Fixing TOOLS-1052*/
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Id.
		if (self.hasAttribute("id")) {
			setCacheId(self.getAttribute("id"));
		}
		
		// Scope.
		CacheScope scope = CacheScope.get(self.getAttribute("scope"));
		if (null != scope) {
			setCacheScope(scope);
		}
		
		// Cache configuration.
		if (self.getAttribute("collector").equalsIgnoreCase("true")) {
			setCacheAction(CacheAction.COLLECTOR);
		} else {
			setCacheAction(CacheAction.FINDER);

			// Hash generator.
			if (self.hasAttribute("hashGenerator")) {
				setHashGenerator(self.getAttribute("hashGenerator"));
			}

			// Cache timeout.
			if (self.hasAttribute("timeout")) {
				setCacheTimeout(Integer.parseInt(self.getAttribute("timeout")));
			}

			// Max message size.
			if (self.hasAttribute("maxMessageSize")) {
				setMaxMessageSize(Integer.parseInt(self.getAttribute("maxMessageSize")));
			}

			// Cache implementation.
			Element implElem = getChildElement(self, "implementation");
			if (null != implElem) {
				// Implementation type.
				CacheImplementationType cacheImpl = CacheImplementationType.get(implElem.getAttribute("type"));
				if (null != cacheImpl) {
					setImplementationType(cacheImpl);
				} else {
					throw new Exception("Unknown cache implementation.");
				}

				// Max entry count.
				if (implElem.hasAttribute("maxSize")) {
					setMaxEntryCount((Integer.parseInt(implElem.getAttribute("maxSize"))));
				}
			}

			// OneHit branch.
			loadObject(self, "onCacheHit", CacheOnHitBranch.class, false, new ObjectHandler<CacheOnHitBranch>() {
				public void handle(CacheOnHitBranch object) {
					setOnHitBranch(object);
				}
			});			
		}	
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "cache");

		// Id.
		if(getCacheId() != null && !getCacheId().equals("")){
		self.setAttribute("id", getCacheId());
		}

		// Scope.		
		self.setAttribute("scope", getCacheScope().getLiteral());		

		// Cache configuration.
		if (getCacheAction().equals(CacheAction.COLLECTOR)) {
			self.setAttribute("collector", "true");						
		} else {
			self.setAttribute("collector", "false");
			self.setAttribute("hashGenerator", getHashGenerator());
			self.setAttribute("timeout", Integer.toString(getCacheTimeout()));
			self.setAttribute("maxMessageSize", Integer.toString(getMaxMessageSize()));

			// Cache implementation.
			Element elemImplementation = createChildElement(self, "implementation");
			elemImplementation.setAttribute("type", getImplementationType().getLiteral());			
			elemImplementation.setAttribute("maxSize", Integer.toString(getMaxEntryCount()));

			// OnHit branch.
			if(getOnHitBranch()!=null){
				getOnHitBranch().save(self);
			}
			
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
		return MediatorsPackage.Literals.CACHE_MEDIATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__CACHE_ID, oldCacheId, cacheId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE, oldCacheScope, cacheScope));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION, oldCacheAction, cacheAction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR, oldHashGenerator, hashGenerator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT, oldCacheTimeout, cacheTimeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE, oldMaxMessageSize, maxMessageSize));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE, oldImplementationType, implementationType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT, oldMaxEntryCount, maxEntryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheOnHitBranch getOnHitBranch() {
		return onHitBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnHitBranch(CacheOnHitBranch newOnHitBranch, NotificationChain msgs) {
		CacheOnHitBranch oldOnHitBranch = onHitBranch;
		onHitBranch = newOnHitBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH, oldOnHitBranch, newOnHitBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnHitBranch(CacheOnHitBranch newOnHitBranch) {
		if (newOnHitBranch != onHitBranch) {
			NotificationChain msgs = null;
			if (onHitBranch != null)
				msgs = ((InternalEObject)onHitBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH, null, msgs);
			if (newOnHitBranch != null)
				msgs = ((InternalEObject)newOnHitBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH, null, msgs);
			msgs = basicSetOnHitBranch(newOnHitBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH, newOnHitBranch, newOnHitBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
				return basicSetOnHitBranch(null, msgs);
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
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ID:
				return getCacheId();
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				return getCacheScope();
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION:
				return getCacheAction();
			case MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				return getHashGenerator();
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				return getCacheTimeout();
			case MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				return getMaxMessageSize();
			case MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				return getImplementationType();
			case MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				return getMaxEntryCount();
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
				return getOnHitBranch();
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
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ID:
				setCacheId((String)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				setCacheScope((CacheScope)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION:
				setCacheAction((CacheAction)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				setHashGenerator((String)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				setCacheTimeout((Integer)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				setMaxMessageSize((Integer)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				setImplementationType((CacheImplementationType)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				setMaxEntryCount((Integer)newValue);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
				setOnHitBranch((CacheOnHitBranch)newValue);
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
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ID:
				setCacheId(CACHE_ID_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				setCacheScope(CACHE_SCOPE_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION:
				setCacheAction(CACHE_ACTION_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				setHashGenerator(HASH_GENERATOR_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				setCacheTimeout(CACHE_TIMEOUT_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				setMaxMessageSize(MAX_MESSAGE_SIZE_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				setImplementationType(IMPLEMENTATION_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				setMaxEntryCount(MAX_ENTRY_COUNT_EDEFAULT);
				return;
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
				setOnHitBranch((CacheOnHitBranch)null);
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
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ID:
				return CACHE_ID_EDEFAULT == null ? cacheId != null : !CACHE_ID_EDEFAULT.equals(cacheId);
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_SCOPE:
				return cacheScope != CACHE_SCOPE_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_ACTION:
				return cacheAction != CACHE_ACTION_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__HASH_GENERATOR:
				return HASH_GENERATOR_EDEFAULT == null ? hashGenerator != null : !HASH_GENERATOR_EDEFAULT.equals(hashGenerator);
			case MediatorsPackage.CACHE_MEDIATOR__CACHE_TIMEOUT:
				return cacheTimeout != CACHE_TIMEOUT_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_MESSAGE_SIZE:
				return maxMessageSize != MAX_MESSAGE_SIZE_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__IMPLEMENTATION_TYPE:
				return implementationType != IMPLEMENTATION_TYPE_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__MAX_ENTRY_COUNT:
				return maxEntryCount != MAX_ENTRY_COUNT_EDEFAULT;
			case MediatorsPackage.CACHE_MEDIATOR__ON_HIT_BRANCH:
				return onHitBranch != null;
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
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (getCacheAction().equals(CacheAction.FINDER)) {
			if(null==getHashGenerator() || getHashGenerator().trim().isEmpty()){
	    		validateMap.put("hashGenerator", "hashGenerator is empty");
	    	}				
		} 
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Cache Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //CacheMediatorImpl
