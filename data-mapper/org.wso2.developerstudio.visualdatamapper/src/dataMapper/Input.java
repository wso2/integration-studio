/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.Input#getTreeNode <em>Tree Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends DataMapperNode {

	/**
	 * Returns the value of the '<em><b>Tree Node</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.TreeNode}.
	 * It is bidirectional and its opposite is '{@link dataMapper.TreeNode#getInputParent <em>Input Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree Node</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getInput_TreeNode()
	 * @see dataMapper.TreeNode#getInputParent
	 * @model opposite="inputParent" containment="true"
	 * @generated
	 */
	EList<TreeNode> getTreeNode();
} // Input
