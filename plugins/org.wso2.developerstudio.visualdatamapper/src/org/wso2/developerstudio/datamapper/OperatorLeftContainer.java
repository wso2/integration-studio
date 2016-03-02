/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Left Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.OperatorLeftContainer#getLeftConnectors <em>Left Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorLeftContainer()
 * @model
 * @generated
 */
public interface OperatorLeftContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.OperatorLeftConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Connectors</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorLeftContainer_LeftConnectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperatorLeftConnector> getLeftConnectors();

} // OperatorLeftContainer
