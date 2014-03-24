/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.Operation#getInNodes <em>In Nodes</em>}</li>
 *   <li>{@link dataMapper.Operation#getOutNodes <em>Out Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends DataMapperNode {
	/**
	 * Returns the value of the '<em><b>In Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.InNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Nodes</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getOperation_InNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<InNode> getInNodes();

	/**
	 * Returns the value of the '<em><b>Out Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.OutNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Nodes</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getOperation_OutNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutNode> getOutNodes();

} // Operation
