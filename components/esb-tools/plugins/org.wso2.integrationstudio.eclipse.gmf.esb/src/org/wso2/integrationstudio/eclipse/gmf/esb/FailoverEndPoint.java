/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failover End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#isBuildMessage <em>Build Message</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint()
 * @model
 * @generated
 */
public interface FailoverEndPoint extends ParentEndPoint {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(FailoverEndPointInputConnector)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint_InputConnector()
     * @model containment="true"
     * @generated
     */
    FailoverEndPointInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(FailoverEndPointInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference list.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint_OutputConnector()
     * @model containment="true"
     * @generated
     */
    EList<FailoverEndPointOutputConnector> getOutputConnector();

    /**
     * Returns the value of the '<em><b>West Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>West Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>West Output Connector</em>' containment reference.
     * @see #setWestOutputConnector(FailoverEndPointWestOutputConnector)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint_WestOutputConnector()
     * @model containment="true"
     * @generated
     */
    FailoverEndPointWestOutputConnector getWestOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getWestOutputConnector <em>West Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>West Output Connector</em>' containment reference.
     * @see #getWestOutputConnector()
     * @generated
     */
    void setWestOutputConnector(FailoverEndPointWestOutputConnector value);

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
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint_MediatorFlow()
     * @model containment="true"
     * @generated
     */
    MediatorFlow getMediatorFlow();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
     * @see #getMediatorFlow()
     * @generated
     */
    void setMediatorFlow(MediatorFlow value);

    /**
     * Returns the value of the '<em><b>Build Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Build Message</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Build Message</em>' attribute.
     * @see #setBuildMessage(boolean)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getFailoverEndPoint_BuildMessage()
     * @model
     * @generated
     */
    boolean isBuildMessage();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint#isBuildMessage <em>Build Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Build Message</em>' attribute.
     * @see #isBuildMessage()
     * @generated
     */
    void setBuildMessage(boolean value);

} // FailoverEndPoint
