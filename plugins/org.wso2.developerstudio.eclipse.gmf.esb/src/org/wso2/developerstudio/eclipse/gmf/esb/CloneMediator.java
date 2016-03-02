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
 * A representation of the model object '<em><b>Clone Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getCloneID <em>Clone ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getTargetsOutputConnector <em>Targets Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getCloneContainer <em>Clone Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator()
 * @model
 * @generated
 */
public interface CloneMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Clone ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clone ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clone ID</em>' attribute.
	 * @see #setCloneID(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_CloneID()
	 * @model
	 * @generated
	 */
	String getCloneID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getCloneID <em>Clone ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clone ID</em>' attribute.
	 * @see #getCloneID()
	 * @generated
	 */
	void setCloneID(String value);

	/**
	 * Returns the value of the '<em><b>Sequential Mediation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequential Mediation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequential Mediation</em>' attribute.
	 * @see #setSequentialMediation(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_SequentialMediation()
	 * @model
	 * @generated
	 */
	boolean isSequentialMediation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#isSequentialMediation <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequential Mediation</em>' attribute.
	 * @see #isSequentialMediation()
	 * @generated
	 */
	void setSequentialMediation(boolean value);

	/**
	 * Returns the value of the '<em><b>Continue Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue Parent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue Parent</em>' attribute.
	 * @see #setContinueParent(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_ContinueParent()
	 * @model
	 * @generated
	 */
	boolean isContinueParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#isContinueParent <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue Parent</em>' attribute.
	 * @see #isContinueParent()
	 * @generated
	 */
	void setContinueParent(boolean value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_Targets()
	 * @model containment="true"
	 * @generated
	 */
	EList<CloneTarget> getTargets();

	/**
	 * Returns the value of the '<em><b>Targets Output Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets Output Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets Output Connector</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_TargetsOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EList<CloneMediatorTargetOutputConnector> getTargetsOutputConnector();

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(CloneMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CloneMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(CloneMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(CloneMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	CloneMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(CloneMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Clone Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clone Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clone Container</em>' containment reference.
	 * @see #setCloneContainer(CloneMediatorContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCloneMediator_CloneContainer()
	 * @model containment="true"
	 * @generated
	 */
	CloneMediatorContainer getCloneContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator#getCloneContainer <em>Clone Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clone Container</em>' containment reference.
	 * @see #getCloneContainer()
	 * @generated
	 */
	void setCloneContainer(CloneMediatorContainer value);

} // CloneMediator
