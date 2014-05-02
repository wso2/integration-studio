/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Basic Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getLeftContainer <em>Left Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getRightContainer <em>Right Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorBasicContainer()
 * @model
 * @generated
 */
public interface OperatorBasicContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Container</em>' containment reference.
	 * @see #setLeftContainer(OperatorLeftContainer)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorBasicContainer_LeftContainer()
	 * @model containment="true"
	 * @generated
	 */
	OperatorLeftContainer getLeftContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getLeftContainer <em>Left Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Container</em>' containment reference.
	 * @see #getLeftContainer()
	 * @generated
	 */
	void setLeftContainer(OperatorLeftContainer value);

	/**
	 * Returns the value of the '<em><b>Right Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Container</em>' containment reference.
	 * @see #setRightContainer(OperatorRightContainer)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorBasicContainer_RightContainer()
	 * @model containment="true"
	 * @generated
	 */
	OperatorRightContainer getRightContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getRightContainer <em>Right Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Container</em>' containment reference.
	 * @see #getRightContainer()
	 * @generated
	 */
	void setRightContainer(OperatorRightContainer value);

} // OperatorBasicContainer
