/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Right Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.OperatorRightConnector#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorRightConnector()
 * @model
 * @generated
 */
public interface OperatorRightConnector extends EObject {
	/**
	 * Returns the value of the '<em><b>Out Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Node</em>' containment reference.
	 * @see #setOutNode(OutNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperatorRightConnector_OutNode()
	 * @model containment="true"
	 * @generated
	 */
	OutNode getOutNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.OperatorRightConnector#getOutNode <em>Out Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Node</em>' containment reference.
	 * @see #getOutNode()
	 * @generated
	 */
	void setOutNode(OutNode value);

} // OperatorRightConnector
