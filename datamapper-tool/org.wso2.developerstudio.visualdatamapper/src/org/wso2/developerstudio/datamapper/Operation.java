/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operation#getInNodes <em>In Nodes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operation#getOutNodes <em>Out Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends DataMapperNode {
	/**
	 * Returns the value of the '<em><b>In Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.InNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Nodes</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperation_InNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<InNode> getInNodes();

	/**
	 * Returns the value of the '<em><b>Out Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.OutNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Nodes</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperation_OutNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutNode> getOutNodes();

} // Operation
