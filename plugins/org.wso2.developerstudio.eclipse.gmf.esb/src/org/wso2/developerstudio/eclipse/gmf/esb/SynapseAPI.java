/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synapse API</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getApiName <em>Api Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getContext <em>Context</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getHostName <em>Host Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getPort <em>Port</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getResources <em>Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getVersion <em>Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getVersionType <em>Version Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getPublishSwagger <em>Publish Swagger</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI()
 * @model
 * @generated
 */
public interface SynapseAPI extends EsbElement {
    /**
     * Returns the value of the '<em><b>Api Name</b></em>' attribute.
     * The default value is <code>"api_name"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Api Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Api Name</em>' attribute.
     * @see #setApiName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_ApiName()
     * @model default="api_name" required="true"
     * @generated
     */
    String getApiName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getApiName <em>Api Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Api Name</em>' attribute.
     * @see #getApiName()
     * @generated
     */
    void setApiName(String value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' attribute.
     * The default value is <code>"/context"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' attribute.
     * @see #setContext(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_Context()
     * @model default="/context" required="true"
     * @generated
     */
    String getContext();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getContext <em>Context</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' attribute.
     * @see #getContext()
     * @generated
     */
    void setContext(String value);

    /**
     * Returns the value of the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Host Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host Name</em>' attribute.
     * @see #setHostName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_HostName()
     * @model
     * @generated
     */
    String getHostName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getHostName <em>Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host Name</em>' attribute.
     * @see #getHostName()
     * @generated
     */
    void setHostName(String value);

    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(int)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_Port()
     * @model
     * @generated
     */
    int getPort();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort(int value);

    /**
     * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.APIResource}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resources</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_Resources()
     * @model containment="true"
     * @generated
     */
    EList<APIResource> getResources();

    /**
     * Returns the value of the '<em><b>Handlers</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.APIHandler}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Handlers</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Handlers</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_Handlers()
     * @model containment="true"
     * @generated
     */
    EList<APIHandler> getHandlers();

    /**
     * Returns the value of the '<em><b>Trace Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trace Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trace Enabled</em>' attribute.
     * @see #setTraceEnabled(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_TraceEnabled()
     * @model
     * @generated
     */
    boolean isTraceEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#isTraceEnabled <em>Trace Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trace Enabled</em>' attribute.
     * @see #isTraceEnabled()
     * @generated
     */
    void setTraceEnabled(boolean value);

    /**
     * Returns the value of the '<em><b>Statistics Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Statistics Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Statistics Enabled</em>' attribute.
     * @see #setStatisticsEnabled(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_StatisticsEnabled()
     * @model
     * @generated
     */
    boolean isStatisticsEnabled();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
     * @see #isStatisticsEnabled()
     * @generated
     */
    void setStatisticsEnabled(boolean value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_Version()
     * @model default=""
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Version Type</b></em>' attribute.
     * The default value is <code>"none"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType
     * @see #setVersionType(APIVersionType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_VersionType()
     * @model default="none"
     * @generated
     */
    APIVersionType getVersionType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getVersionType <em>Version Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType
     * @see #getVersionType()
     * @generated
     */
    void setVersionType(APIVersionType value);

    /**
     * Returns the value of the '<em><b>Publish Swagger</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Publish Swagger</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Publish Swagger</em>' containment reference.
     * @see #setPublishSwagger(RegistryKeyProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSynapseAPI_PublishSwagger()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getPublishSwagger();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI#getPublishSwagger <em>Publish Swagger</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Publish Swagger</em>' containment reference.
     * @see #getPublishSwagger()
     * @generated
     */
    void setPublishSwagger(RegistryKeyProperty value);

} // SynapseAPI
