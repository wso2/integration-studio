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
 * A representation of the model object '<em><b>Switch Mediator Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer#getSwitchCaseParentContainer <em>Switch Case Parent Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer#getSwitchDefaultParentContainer <em>Switch Default Parent Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediatorContainer()
 * @model
 * @generated
 */
public interface SwitchMediatorContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Switch Case Parent Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch Case Parent Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch Case Parent Container</em>' containment reference.
	 * @see #setSwitchCaseParentContainer(SwitchCaseParentContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediatorContainer_SwitchCaseParentContainer()
	 * @model containment="true"
	 * @generated
	 */
	SwitchCaseParentContainer getSwitchCaseParentContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer#getSwitchCaseParentContainer <em>Switch Case Parent Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch Case Parent Container</em>' containment reference.
	 * @see #getSwitchCaseParentContainer()
	 * @generated
	 */
	void setSwitchCaseParentContainer(SwitchCaseParentContainer value);

	/**
	 * Returns the value of the '<em><b>Switch Default Parent Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch Default Parent Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch Default Parent Container</em>' containment reference.
	 * @see #setSwitchDefaultParentContainer(SwitchDefaultParentContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediatorContainer_SwitchDefaultParentContainer()
	 * @model containment="true"
	 * @generated
	 */
	SwitchDefaultParentContainer getSwitchDefaultParentContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediatorContainer#getSwitchDefaultParentContainer <em>Switch Default Parent Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch Default Parent Container</em>' containment reference.
	 * @see #getSwitchDefaultParentContainer()
	 * @generated
	 */
	void setSwitchDefaultParentContainer(SwitchDefaultParentContainer value);

} // SwitchMediatorContainer
