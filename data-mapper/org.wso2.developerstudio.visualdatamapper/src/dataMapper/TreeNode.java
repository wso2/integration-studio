/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.TreeNode#getName <em>Name</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getNode <em>Node</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getElement <em>Element</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getFieldParent <em>Field Parent</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getOutputParent <em>Output Parent</em>}</li>
 *   <li>{@link dataMapper.TreeNode#getInputParent <em>Input Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getTreeNode()
 * @model
 * @generated
 */
public interface TreeNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dataMapper.DataMapperPackage#getTreeNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dataMapper.TreeNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.TreeNode}.
	 * It is bidirectional and its opposite is '{@link dataMapper.TreeNode#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getTreeNode_Node()
	 * @see dataMapper.TreeNode#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<TreeNode> getNode();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.Attribute}.
	 * It is bidirectional and its opposite is '{@link dataMapper.Attribute#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getTreeNode_Attribute()
	 * @see dataMapper.Attribute#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.Element}.
	 * It is bidirectional and its opposite is '{@link dataMapper.Element#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getTreeNode_Element()
	 * @see dataMapper.Element#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<Element> getElement();

	/**
	 * Returns the value of the '<em><b>Field Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataMapper.TreeNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Parent</em>' container reference.
	 * @see #setFieldParent(TreeNode)
	 * @see dataMapper.DataMapperPackage#getTreeNode_FieldParent()
	 * @see dataMapper.TreeNode#getNode
	 * @model opposite="node" transient="false"
	 * @generated
	 */
	TreeNode getFieldParent();

	/**
	 * Sets the value of the '{@link dataMapper.TreeNode#getFieldParent <em>Field Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Parent</em>' container reference.
	 * @see #getFieldParent()
	 * @generated
	 */
	void setFieldParent(TreeNode value);

	/**
	 * Returns the value of the '<em><b>Output Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataMapper.Output#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parent</em>' container reference.
	 * @see #setOutputParent(Output)
	 * @see dataMapper.DataMapperPackage#getTreeNode_OutputParent()
	 * @see dataMapper.Output#getTreeNode
	 * @model opposite="treeNode" transient="false"
	 * @generated
	 */
	Output getOutputParent();

	/**
	 * Sets the value of the '{@link dataMapper.TreeNode#getOutputParent <em>Output Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Parent</em>' container reference.
	 * @see #getOutputParent()
	 * @generated
	 */
	void setOutputParent(Output value);

	/**
	 * Returns the value of the '<em><b>Input Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataMapper.Input#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parent</em>' container reference.
	 * @see #setInputParent(Input)
	 * @see dataMapper.DataMapperPackage#getTreeNode_InputParent()
	 * @see dataMapper.Input#getTreeNode
	 * @model opposite="treeNode" transient="false"
	 * @generated
	 */
	Input getInputParent();

	/**
	 * Sets the value of the '{@link dataMapper.TreeNode#getInputParent <em>Input Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Parent</em>' container reference.
	 * @see #getInputParent()
	 * @generated
	 */
	void setInputParent(Input value);

} // TreeNode
