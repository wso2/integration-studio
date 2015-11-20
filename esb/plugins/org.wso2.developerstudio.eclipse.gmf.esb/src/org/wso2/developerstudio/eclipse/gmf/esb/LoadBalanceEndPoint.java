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
 * A representation of the model object '<em><b>Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#isFailover <em>Failover</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getWestOutputConnector <em>West Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getMember <em>Member</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getSessionType <em>Session Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getSessionTimeout <em>Session Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint()
 * @model
 * @generated
 */
public interface LoadBalanceEndPoint extends ParentEndPoint {
	/**
	 * Returns the value of the '<em><b>Failover</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failover</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failover</em>' attribute.
	 * @see #setFailover(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_Failover()
	 * @model
	 * @generated
	 */
	boolean isFailover();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#isFailover <em>Failover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failover</em>' attribute.
	 * @see #isFailover()
	 * @generated
	 */
	void setFailover(boolean value);

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' attribute.
	 * @see #setPolicy(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_Policy()
	 * @model
	 * @generated
	 */
	String getPolicy();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' attribute.
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(LoadBalanceEndPointInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	LoadBalanceEndPointInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(LoadBalanceEndPointInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EList<LoadBalanceEndPointOutputConnector> getOutputConnector();

	/**
	 * Returns the value of the '<em><b>West Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>West Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>West Output Connector</em>' containment reference.
	 * @see #setWestOutputConnector(LoadBalanceEndPointWestOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_WestOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	LoadBalanceEndPointWestOutputConnector getWestOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getWestOutputConnector <em>West Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>West Output Connector</em>' containment reference.
	 * @see #getWestOutputConnector()
	 * @generated
	 */
	void setWestOutputConnector(LoadBalanceEndPointWestOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.Member}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_Member()
	 * @model containment="true" derived="true"
	 * @generated
	 */
	EList<Member> getMember();

	/**
	 * Returns the value of the '<em><b>Session Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType
	 * @see #setSessionType(LoadBalanceSessionType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_SessionType()
	 * @model default="NONE"
	 * @generated
	 */
	LoadBalanceSessionType getSessionType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getSessionType <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceSessionType
	 * @see #getSessionType()
	 * @generated
	 */
	void setSessionType(LoadBalanceSessionType value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * The default value is <code>"org.apache.synapse.endpoints.algorithms.RoundRobin"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see #setAlgorithm(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_Algorithm()
	 * @model default="org.apache.synapse.endpoints.algorithms.RoundRobin"
	 * @generated
	 */
	String getAlgorithm();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(String value);

	/**
	 * Returns the value of the '<em><b>Session Timeout</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Timeout</em>' attribute.
	 * @see #setSessionTimeout(long)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_SessionTimeout()
	 * @model default="0"
	 * @generated
	 */
	long getSessionTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getSessionTimeout <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Timeout</em>' attribute.
	 * @see #getSessionTimeout()
	 * @generated
	 */
	void setSessionTimeout(long value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLoadBalanceEndPoint_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

} // LoadBalanceEndPoint
