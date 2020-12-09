/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.eclipse.gmf.esb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cache Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheProtocolType <em>Cache Protocol Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheType <em>Cache Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHashGenerator <em>Hash Generator</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheProtocolMethods <em>Cache Protocol Methods</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getOnHitOutputConnector <em>On Hit Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHeadersToExcludeInHash <em>Headers To Exclude In Hash</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getResponseCodes <em>Response Codes</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#isEnableCacheControl <em>Enable Cache Control</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#isIncludeAgeHeader <em>Include Age Header</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getId <em>Id</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHashGeneratorAttribute <em>Hash Generator Attribute</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getScope <em>Scope</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheMediatorImplementation <em>Cache Mediator Implementation</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator()
 * @model
 * @generated
 */
public interface CacheMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Cache Protocol Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheProtocolType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cache Protocol Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cache Protocol Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheProtocolType
     * @see #setCacheProtocolType(CacheProtocolType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheProtocolType()
     * @model
     * @generated
     */
    CacheProtocolType getCacheProtocolType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheProtocolType <em>Cache Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cache Protocol Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheProtocolType
     * @see #getCacheProtocolType()
     * @generated
     */
    void setCacheProtocolType(CacheProtocolType value);

    /**
     * Returns the value of the '<em><b>Cache Type</b></em>' attribute.
     * The default value is <code>"FINDER"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cache Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cache Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheType
     * @see #setCacheType(CacheType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheType()
     * @model default="FINDER"
     * @generated
     */
    CacheType getCacheType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheType <em>Cache Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cache Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheType
     * @see #getCacheType()
     * @generated
     */
    void setCacheType(CacheType value);

    /**
     * Returns the value of the '<em><b>Hash Generator</b></em>' attribute.
     * The default value is <code>"org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hash Generator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hash Generator</em>' attribute.
     * @see #setHashGenerator(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_HashGenerator()
     * @model default="org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator"
     * @generated
     */
    String getHashGenerator();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHashGenerator <em>Hash Generator</em>}' attribute.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheTimeout()
     * @model default="120"
     * @generated
     */
    int getCacheTimeout();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}' attribute.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MaxMessageSize()
     * @model default="2000"
     * @generated
     */
    int getMaxMessageSize();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Message Size</em>' attribute.
     * @see #getMaxMessageSize()
     * @generated
     */
    void setMaxMessageSize(int value);

    /**
     * Returns the value of the '<em><b>Cache Protocol Methods</b></em>' attribute.
     * The default value is <code>"*"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cache Protocol Methods</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cache Protocol Methods</em>' attribute.
     * @see #setCacheProtocolMethods(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheProtocolMethods()
     * @model default="*"
     * @generated
     */
    String getCacheProtocolMethods();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheProtocolMethods <em>Cache Protocol Methods</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cache Protocol Methods</em>' attribute.
     * @see #getCacheProtocolMethods()
     * @generated
     */
    void setCacheProtocolMethods(String value);

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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MaxEntryCount()
     * @model default="1000"
     * @generated
     */
    int getMaxEntryCount();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}' attribute.
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
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sequence Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType
     * @see #setSequenceType(CacheSequenceType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_SequenceType()
     * @model default="REGISTRY_REFERENCE"
     * @generated
     */
    CacheSequenceType getSequenceType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getSequenceType <em>Sequence Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sequence Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_SequenceKey()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getSequenceKey();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getSequenceKey <em>Sequence Key</em>}' containment reference.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    CacheMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getInputConnector <em>Input Connector</em>}' containment reference.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    CacheMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_OnHitOutputConnector()
     * @model containment="true"
     * @generated
     */
    CacheMediatorOnHitOutputConnector getOnHitOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getOnHitOutputConnector <em>On Hit Output Connector</em>}' containment reference.
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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_MediatorFlow()
     * @model containment="true"
     * @generated
     */
    MediatorFlow getMediatorFlow();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
     * @see #getMediatorFlow()
     * @generated
     */
    void setMediatorFlow(MediatorFlow value);

    /**
     * Returns the value of the '<em><b>Headers To Exclude In Hash</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Headers To Exclude In Hash</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Headers To Exclude In Hash</em>' attribute.
     * @see #setHeadersToExcludeInHash(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_HeadersToExcludeInHash()
     * @model
     * @generated
     */
    String getHeadersToExcludeInHash();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHeadersToExcludeInHash <em>Headers To Exclude In Hash</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Headers To Exclude In Hash</em>' attribute.
     * @see #getHeadersToExcludeInHash()
     * @generated
     */
    void setHeadersToExcludeInHash(String value);

    /**
     * Returns the value of the '<em><b>Response Codes</b></em>' attribute.
     * The default value is <code>".*"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Response Codes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Response Codes</em>' attribute.
     * @see #setResponseCodes(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_ResponseCodes()
     * @model default=".*"
     * @generated
     */
    String getResponseCodes();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getResponseCodes <em>Response Codes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Response Codes</em>' attribute.
     * @see #getResponseCodes()
     * @generated
     */
    void setResponseCodes(String value);

    /**
     * Returns the value of the '<em><b>Enable Cache Control</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable Cache Control</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable Cache Control</em>' attribute.
     * @see #setEnableCacheControl(boolean)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_EnableCacheControl()
     * @model default="false"
     * @generated
     */
    boolean isEnableCacheControl();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#isEnableCacheControl <em>Enable Cache Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable Cache Control</em>' attribute.
     * @see #isEnableCacheControl()
     * @generated
     */
    void setEnableCacheControl(boolean value);

    /**
     * Returns the value of the '<em><b>Include Age Header</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Include Age Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Include Age Header</em>' attribute.
     * @see #setIncludeAgeHeader(boolean)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_IncludeAgeHeader()
     * @model default="false"
     * @generated
     */
    boolean isIncludeAgeHeader();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#isIncludeAgeHeader <em>Include Age Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Include Age Header</em>' attribute.
     * @see #isIncludeAgeHeader()
     * @generated
     */
    void setIncludeAgeHeader(boolean value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_Id()
     * @model default=""
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Hash Generator Attribute</b></em>' attribute.
     * The default value is <code>"org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hash Generator Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hash Generator Attribute</em>' attribute.
     * @see #setHashGeneratorAttribute(String)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_HashGeneratorAttribute()
     * @model default="org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator"
     * @generated
     */
    String getHashGeneratorAttribute();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getHashGeneratorAttribute <em>Hash Generator Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hash Generator Attribute</em>' attribute.
     * @see #getHashGeneratorAttribute()
     * @generated
     */
    void setHashGeneratorAttribute(String value);

    /**
     * Returns the value of the '<em><b>Scope</b></em>' attribute.
     * The default value is <code>"Per_Host"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheScopeType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scope</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scope</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheScopeType
     * @see #setScope(CacheScopeType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_Scope()
     * @model default="Per_Host"
     * @generated
     */
    CacheScopeType getScope();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getScope <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scope</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheScopeType
     * @see #getScope()
     * @generated
     */
    void setScope(CacheScopeType value);

    /**
     * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
     * The default value is <code>"memory"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheImplementationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheImplementationType
     * @see #setImplementationType(CacheImplementationType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_ImplementationType()
     * @model default="memory"
     * @generated
     */
    CacheImplementationType getImplementationType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getImplementationType <em>Implementation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation Type</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheImplementationType
     * @see #getImplementationType()
     * @generated
     */
    void setImplementationType(CacheImplementationType value);

    /**
     * Returns the value of the '<em><b>Cache Mediator Implementation</b></em>' attribute.
     * The default value is <code>"Default"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cache Mediator Implementation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cache Mediator Implementation</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType
     * @see #setCacheMediatorImplementation(CacheMediatorType)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getCacheMediator_CacheMediatorImplementation()
     * @model default="Default"
     * @generated
     */
    CacheMediatorType getCacheMediatorImplementation();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator#getCacheMediatorImplementation <em>Cache Mediator Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cache Mediator Implementation</em>' attribute.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType
     * @see #getCacheMediatorImplementation()
     * @generated
     */
    void setCacheMediatorImplementation(CacheMediatorType value);

} // CacheMediator
