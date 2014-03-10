/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cache Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheId <em>Cache Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheScope <em>Cache Scope</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheAction <em>Cache Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getOnHitOutputConnector <em>On Hit Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator()
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheId()
	 * @model
	 * @generated
	 */
	String getCacheId();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheId <em>Cache Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Id</em>' attribute.
	 * @see #getCacheId()
	 * @generated
	 */
	void setCacheId(String value);

	/**
	 * Returns the value of the '<em><b>Cache Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CacheScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheScope
	 * @see #setCacheScope(CacheScope)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheScope()
	 * @model
	 * @generated
	 */
	CacheScope getCacheScope();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheScope <em>Cache Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Scope</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheScope
	 * @see #getCacheScope()
	 * @generated
	 */
	void setCacheScope(CacheScope value);

	/**
	 * Returns the value of the '<em><b>Cache Action</b></em>' attribute.
	 * The default value is <code>"FINDER"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CacheAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheAction
	 * @see #setCacheAction(CacheAction)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheAction()
	 * @model default="FINDER"
	 * @generated
	 */
	CacheAction getCacheAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheAction <em>Cache Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Action</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheAction
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_HashGenerator()
	 * @model default="org.wso2.caching.digest.DOMHashGenerator"
	 * @generated
	 */
	String getHashGenerator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getHashGenerator <em>Hash Generator</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheTimeout()
	 * @model default="120"
	 * @generated
	 */
	int getCacheTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MaxMessageSize()
	 * @model default="2000"
	 * @generated
	 */
	int getMaxMessageSize();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Message Size</em>' attribute.
	 * @see #getMaxMessageSize()
	 * @generated
	 */
	void setMaxMessageSize(int value);

	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CacheImplementationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheImplementationType
	 * @see #setImplementationType(CacheImplementationType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_ImplementationType()
	 * @model
	 * @generated
	 */
	CacheImplementationType getImplementationType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheImplementationType
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MaxEntryCount()
	 * @model default="1000"
	 * @generated
	 */
	int getMaxEntryCount();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Entry Count</em>' attribute.
	 * @see #getMaxEntryCount()
	 * @generated
	 */
	void setMaxEntryCount(int value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"REGISTRY_REFERENCE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType
	 * @see #setSequenceType(CacheSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_SequenceType()
	 * @model default="REGISTRY_REFERENCE"
	 * @generated
	 */
	CacheSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(CacheSequenceType value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' containment reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(CacheMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CacheMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(CacheMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(CacheMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CacheMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(CacheMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>On Hit Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Hit Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Hit Output Connector</em>' containment reference.
	 * @see #setOnHitOutputConnector(CacheMediatorOnHitOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_OnHitOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CacheMediatorOnHitOutputConnector getOnHitOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getOnHitOutputConnector <em>On Hit Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Hit Output Connector</em>' containment reference.
	 * @see #getOnHitOutputConnector()
	 * @generated
	 */
	void setOnHitOutputConnector(CacheMediatorOnHitOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #setMediatorFlow(MediatorFlow)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

} // CacheMediator
