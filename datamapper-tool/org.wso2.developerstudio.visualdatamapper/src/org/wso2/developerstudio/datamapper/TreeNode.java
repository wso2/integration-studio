/**
 */
package org.wso2.developerstudio.datamapper;

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
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getNode <em>Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getElement <em>Element</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getFieldParent <em>Field Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getOutputParent <em>Output Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getInputParent <em>Input Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getSchemaDataType <em>Schema Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.TreeNode#getLevel <em>Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode()
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
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.TreeNode}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.TreeNode#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_Node()
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<TreeNode> getNode();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Attribute#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_Attribute()
	 * @see org.wso2.developerstudio.datamapper.Attribute#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.Element}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Element#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_Element()
	 * @see org.wso2.developerstudio.datamapper.Element#getFieldParent
	 * @model opposite="fieldParent" containment="true"
	 * @generated
	 */
	EList<Element> getElement();

	/**
	 * Returns the value of the '<em><b>Field Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.TreeNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Parent</em>' container reference.
	 * @see #setFieldParent(TreeNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_FieldParent()
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getNode
	 * @model opposite="node" transient="false"
	 * @generated
	 */
	TreeNode getFieldParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getFieldParent <em>Field Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Parent</em>' container reference.
	 * @see #getFieldParent()
	 * @generated
	 */
	void setFieldParent(TreeNode value);

	/**
	 * Returns the value of the '<em><b>Output Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Output#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parent</em>' container reference.
	 * @see #setOutputParent(Output)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_OutputParent()
	 * @see org.wso2.developerstudio.datamapper.Output#getTreeNode
	 * @model opposite="treeNode" transient="false"
	 * @generated
	 */
	Output getOutputParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getOutputParent <em>Output Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Parent</em>' container reference.
	 * @see #getOutputParent()
	 * @generated
	 */
	void setOutputParent(Output value);

	/**
	 * Returns the value of the '<em><b>Input Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Input#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parent</em>' container reference.
	 * @see #setInputParent(Input)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_InputParent()
	 * @see org.wso2.developerstudio.datamapper.Input#getTreeNode
	 * @model opposite="treeNode" transient="false"
	 * @generated
	 */
	Input getInputParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getInputParent <em>Input Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Parent</em>' container reference.
	 * @see #getInputParent()
	 * @generated
	 */
	void setInputParent(Input value);

    /**
	 * Returns the value of the '<em><b>Schema Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.datamapper.SchemaDataType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schema Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see #setSchemaDataType(SchemaDataType)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_SchemaDataType()
	 * @model
	 * @generated
	 */
    SchemaDataType getSchemaDataType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getSchemaDataType <em>Schema Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Data Type</em>' attribute.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see #getSchemaDataType()
	 * @generated
	 */
    void setSchemaDataType(SchemaDataType value);

    /**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getTreeNode_Level()
	 * @model
	 * @generated
	 */
    int getLevel();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.TreeNode#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
    void setLevel(int value);

} // TreeNode
