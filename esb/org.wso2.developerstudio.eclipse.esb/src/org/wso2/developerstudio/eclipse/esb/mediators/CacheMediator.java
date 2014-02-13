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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.Mediator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cache Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheId <em>Cache Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheScope <em>Cache Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheAction <em>Cache Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getOnHitBranch <em>On Hit Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator()
 * @model
 * @generated
 */
public interface CacheMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Cache Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Id</em>' attribute.
	 * @see #setCacheId(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_CacheId()
	 * @model
	 * @generated
	 */
	String getCacheId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheId <em>Cache Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Id</em>' attribute.
	 * @see #getCacheId()
	 * @generated
	 */
	void setCacheId(String value);

	/**
	 * Returns the value of the '<em><b>Cache Scope</b></em>' attribute.
	 * The default value is <code>"PER_MEDIATOR"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CacheScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheScope
	 * @see #setCacheScope(CacheScope)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_CacheScope()
	 * @model default="PER_MEDIATOR"
	 * @generated
	 */
	CacheScope getCacheScope();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheScope <em>Cache Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheScope
	 * @see #getCacheScope()
	 * @generated
	 */
	void setCacheScope(CacheScope value);

	/**
	 * Returns the value of the '<em><b>Cache Action</b></em>' attribute.
	 * The default value is <code>"FINDER"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CacheAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheAction
	 * @see #setCacheAction(CacheAction)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_CacheAction()
	 * @model default="FINDER"
	 * @generated
	 */
	CacheAction getCacheAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheAction <em>Cache Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheAction
	 * @see #getCacheAction()
	 * @generated
	 */
	void setCacheAction(CacheAction value);

	/**
	 * Returns the value of the '<em><b>Hash Generator</b></em>' attribute.
	 * The default value is <code>"org.wso2.caching.digest.DOMHashGenerator"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hash Generator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hash Generator</em>' attribute.
	 * @see #setHashGenerator(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_HashGenerator()
	 * @model default="org.wso2.caching.digest.DOMHashGenerator"
	 * @generated
	 */
	String getHashGenerator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getHashGenerator <em>Hash Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hash Generator</em>' attribute.
	 * @see #getHashGenerator()
	 * @generated
	 */
	void setHashGenerator(String value);

	/**
	 * Returns the value of the '<em><b>Cache Timeout</b></em>' attribute.
	 * The default value is <code>"120"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Timeout</em>' attribute.
	 * @see #setCacheTimeout(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_CacheTimeout()
	 * @model default="120"
	 * @generated
	 */
	int getCacheTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Timeout</em>' attribute.
	 * @see #getCacheTimeout()
	 * @generated
	 */
	void setCacheTimeout(int value);

	/**
	 * Returns the value of the '<em><b>Max Message Size</b></em>' attribute.
	 * The default value is <code>"2000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Message Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Message Size</em>' attribute.
	 * @see #setMaxMessageSize(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_MaxMessageSize()
	 * @model default="2000"
	 * @generated
	 */
	int getMaxMessageSize();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Message Size</em>' attribute.
	 * @see #getMaxMessageSize()
	 * @generated
	 */
	void setMaxMessageSize(int value);

	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * The default value is <code>"IN_MEMORY"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType
	 * @see #setImplementationType(CacheImplementationType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_ImplementationType()
	 * @model default="IN_MEMORY"
	 * @generated
	 */
	CacheImplementationType getImplementationType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType
	 * @see #getImplementationType()
	 * @generated
	 */
	void setImplementationType(CacheImplementationType value);

	/**
	 * Returns the value of the '<em><b>Max Entry Count</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Entry Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Entry Count</em>' attribute.
	 * @see #setMaxEntryCount(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_MaxEntryCount()
	 * @model default="1000"
	 * @generated
	 */
	int getMaxEntryCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Entry Count</em>' attribute.
	 * @see #getMaxEntryCount()
	 * @generated
	 */
	void setMaxEntryCount(int value);

	/**
	 * Returns the value of the '<em><b>On Hit Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Hit Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Hit Branch</em>' containment reference.
	 * @see #setOnHitBranch(CacheOnHitBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheMediator_OnHitBranch()
	 * @model containment="true"
	 * @generated
	 */
	CacheOnHitBranch getOnHitBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getOnHitBranch <em>On Hit Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Hit Branch</em>' containment reference.
	 * @see #getOnHitBranch()
	 * @generated
	 */
	void setOnHitBranch(CacheOnHitBranch value);

} // CacheMediator
