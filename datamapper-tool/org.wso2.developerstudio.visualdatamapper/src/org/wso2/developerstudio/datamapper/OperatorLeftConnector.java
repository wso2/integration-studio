/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Left Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.OperatorLeftConnector#getInNode <em>In Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorLeftConnector()
 * @model
 * @generated
 */
public interface OperatorLeftConnector extends EObject {
	/**
	 * Returns the value of the '<em><b>In Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Node</em>' containment reference.
	 * @see #setInNode(InNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorLeftConnector_InNode()
	 * @model containment="true"
	 * @generated
	 */
	InNode getInNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.OperatorLeftConnector#getInNode <em>In Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Node</em>' containment reference.
	 * @see #getInNode()
	 * @generated
	 */
	void setInNode(InNode value);

} // OperatorLeftConnector
