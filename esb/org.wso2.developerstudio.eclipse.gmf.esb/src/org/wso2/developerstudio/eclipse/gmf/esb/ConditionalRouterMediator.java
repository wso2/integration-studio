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
 * A representation of the model object '<em><b>Conditional Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#isContinueAfterRoute <em>Continue After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getConditionalRouteBranches <em>Conditional Route Branches</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getAdditionalOutputConnector <em>Additional Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator()
 * @model
 * @generated
 */
public interface ConditionalRouterMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Continue After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue After Route</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue After Route</em>' attribute.
	 * @see #setContinueAfterRoute(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_ContinueAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isContinueAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#isContinueAfterRoute <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue After Route</em>' attribute.
	 * @see #isContinueAfterRoute()
	 * @generated
	 */
	void setContinueAfterRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Conditional Route Branches</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional Route Branches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditional Route Branches</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_ConditionalRouteBranches()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionalRouteBranch> getConditionalRouteBranches();

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(ConditionalRouterMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ConditionalRouterMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(ConditionalRouterMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(ConditionalRouterMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ConditionalRouterMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(ConditionalRouterMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Additional Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Output Connector</em>' containment reference.
	 * @see #setAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_AdditionalOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ConditionalRouterMediatorAdditionalOutputConnector getAdditionalOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getAdditionalOutputConnector <em>Additional Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additional Output Connector</em>' containment reference.
	 * @see #getAdditionalOutputConnector()
	 * @generated
	 */
	void setAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector value);

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouterMediator_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

} // ConditionalRouterMediator
