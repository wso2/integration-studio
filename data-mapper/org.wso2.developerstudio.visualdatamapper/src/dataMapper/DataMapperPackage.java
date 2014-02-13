/**
 */
package dataMapper;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dataMapper.DataMapperFactory
 * @model kind="package"
 * @generated
 */
public interface DataMapperPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataMapper";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/wso2/developerstudio/eclipse/gmf/datamapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dataMapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataMapperPackage eINSTANCE = dataMapper.impl.DataMapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link dataMapper.impl.DataMapperNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.DataMapperNodeImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperNode()
	 * @generated
	 */
	int DATA_MAPPER_NODE = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dataMapper.impl.DataMapperDiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.DataMapperDiagramImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperDiagram()
	 * @generated
	 */
	int DATA_MAPPER_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_DIAGRAM__INPUT = DATA_MAPPER_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_DIAGRAM__OUTPUT = DATA_MAPPER_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Concat</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_DIAGRAM__CONCAT = DATA_MAPPER_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_DIAGRAM_FEATURE_COUNT = DATA_MAPPER_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dataMapper.impl.DataMapperRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.DataMapperRootImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperRoot()
	 * @generated
	 */
	int DATA_MAPPER_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Data Mapper Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dataMapper.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.InputImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 3;

	/**
	 * The feature id for the '<em><b>Tree Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__TREE_NODE = DATA_MAPPER_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = DATA_MAPPER_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dataMapper.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.OutputImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Tree Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__TREE_NODE = DATA_MAPPER_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = DATA_MAPPER_NODE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link dataMapper.impl.OperatorsImpl <em>Operators</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.OperatorsImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getOperators()
	 * @generated
	 */
	int OPERATORS = 5;

	/**
	 * The number of structural features of the '<em>Operators</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATORS_FEATURE_COUNT = DATA_MAPPER_NODE_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link dataMapper.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.ElementImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Out Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OUT_NODE = 2;

	/**
	 * The feature id for the '<em><b>In Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__IN_NODE = 3;

	/**
	 * The feature id for the '<em><b>Field Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__FIELD_PARENT = 4;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link dataMapper.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.AttributeImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Out Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OUT_NODE = 2;

	/**
	 * The feature id for the '<em><b>In Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IN_NODE = 3;

	/**
	 * The feature id for the '<em><b>Field Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__FIELD_PARENT = 4;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link dataMapper.impl.TreeNodeImpl <em>Tree Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.TreeNodeImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getTreeNode()
	 * @generated
	 */
	int TREE_NODE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__NODE = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Field Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__FIELD_PARENT = 4;

	/**
	 * The feature id for the '<em><b>Output Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__OUTPUT_PARENT = 5;

	/**
	 * The feature id for the '<em><b>Input Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__INPUT_PARENT = 6;

	/**
	 * The number of structural features of the '<em>Tree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_FEATURE_COUNT = 7;


	/**
	 * The meta object id for the '{@link dataMapper.impl.InNodeImpl <em>In Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.InNodeImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getInNode()
	 * @generated
	 */
	int IN_NODE = 9;

	/**
	 * The feature id for the '<em><b>Incoming Link</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_NODE__INCOMING_LINK = 0;

	/**
	 * The feature id for the '<em><b>Element Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_NODE__ELEMENT_PARENT = 1;

	/**
	 * The feature id for the '<em><b>Attribute Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_NODE__ATTRIBUTE_PARENT = 2;

	/**
	 * The number of structural features of the '<em>In Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link dataMapper.impl.OutNodeImpl <em>Out Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.OutNodeImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getOutNode()
	 * @generated
	 */
	int OUT_NODE = 10;

	/**
	 * The feature id for the '<em><b>Outgoing Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_NODE__OUTGOING_LINK = 0;

	/**
	 * The number of structural features of the '<em>Out Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_NODE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link dataMapper.impl.DataMapperLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.DataMapperLinkImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperLink()
	 * @generated
	 */
	int DATA_MAPPER_LINK = 11;

	/**
	 * The feature id for the '<em><b>In Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_LINK__IN_NODE = 0;

	/**
	 * The feature id for the '<em><b>Out Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_LINK__OUT_NODE = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_LINK_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link dataMapper.impl.ConcatImpl <em>Concat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dataMapper.impl.ConcatImpl
	 * @see dataMapper.impl.DataMapperPackageImpl#getConcat()
	 * @generated
	 */
	int CONCAT = 12;

	/**
	 * The feature id for the '<em><b>In Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__IN_NODE = 0;

	/**
	 * The feature id for the '<em><b>Out Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__OUT_NODE = 1;

	/**
	 * The number of structural features of the '<em>Concat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link dataMapper.DataMapperNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see dataMapper.DataMapperNode
	 * @generated
	 */
	EClass getDataMapperNode();

	/**
	 * Returns the meta object for class '{@link dataMapper.DataMapperDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see dataMapper.DataMapperDiagram
	 * @generated
	 */
	EClass getDataMapperDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.DataMapperDiagram#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see dataMapper.DataMapperDiagram#getInput()
	 * @see #getDataMapperDiagram()
	 * @generated
	 */
	EReference getDataMapperDiagram_Input();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.DataMapperDiagram#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see dataMapper.DataMapperDiagram#getOutput()
	 * @see #getDataMapperDiagram()
	 * @generated
	 */
	EReference getDataMapperDiagram_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.DataMapperDiagram#getConcat <em>Concat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concat</em>'.
	 * @see dataMapper.DataMapperDiagram#getConcat()
	 * @see #getDataMapperDiagram()
	 * @generated
	 */
	EReference getDataMapperDiagram_Concat();

	/**
	 * Returns the meta object for class '{@link dataMapper.DataMapperRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see dataMapper.DataMapperRoot
	 * @generated
	 */
	EClass getDataMapperRoot();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.DataMapperRoot#getDataMapperDiagram <em>Data Mapper Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Mapper Diagram</em>'.
	 * @see dataMapper.DataMapperRoot#getDataMapperDiagram()
	 * @see #getDataMapperRoot()
	 * @generated
	 */
	EReference getDataMapperRoot_DataMapperDiagram();

	/**
	 * Returns the meta object for class '{@link dataMapper.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see dataMapper.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.Input#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tree Node</em>'.
	 * @see dataMapper.Input#getTreeNode()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_TreeNode();

	/**
	 * Returns the meta object for class '{@link dataMapper.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see dataMapper.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.Output#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tree Node</em>'.
	 * @see dataMapper.Output#getTreeNode()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_TreeNode();

	/**
	 * Returns the meta object for class '{@link dataMapper.Operators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operators</em>'.
	 * @see dataMapper.Operators
	 * @generated
	 */
	EClass getOperators();

	/**
	 * Returns the meta object for class '{@link dataMapper.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see dataMapper.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link dataMapper.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dataMapper.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link dataMapper.Element#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dataMapper.Element#getValue()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Value();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.Element#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Node</em>'.
	 * @see dataMapper.Element#getOutNode()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OutNode();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.Element#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Node</em>'.
	 * @see dataMapper.Element#getInNode()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_InNode();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.Element#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Field Parent</em>'.
	 * @see dataMapper.Element#getFieldParent()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_FieldParent();

	/**
	 * Returns the meta object for class '{@link dataMapper.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see dataMapper.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link dataMapper.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dataMapper.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link dataMapper.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dataMapper.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.Attribute#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Node</em>'.
	 * @see dataMapper.Attribute#getOutNode()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_OutNode();

	/**
	 * Returns the meta object for the containment reference '{@link dataMapper.Attribute#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Node</em>'.
	 * @see dataMapper.Attribute#getInNode()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_InNode();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.Attribute#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Field Parent</em>'.
	 * @see dataMapper.Attribute#getFieldParent()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_FieldParent();

	/**
	 * Returns the meta object for class '{@link dataMapper.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Node</em>'.
	 * @see dataMapper.TreeNode
	 * @generated
	 */
	EClass getTreeNode();

	/**
	 * Returns the meta object for the attribute '{@link dataMapper.TreeNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dataMapper.TreeNode#getName()
	 * @see #getTreeNode()
	 * @generated
	 */
	EAttribute getTreeNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.TreeNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see dataMapper.TreeNode#getNode()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Node();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.TreeNode#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see dataMapper.TreeNode#getAttribute()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Attribute();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.TreeNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see dataMapper.TreeNode#getElement()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Element();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.TreeNode#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Field Parent</em>'.
	 * @see dataMapper.TreeNode#getFieldParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_FieldParent();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.TreeNode#getOutputParent <em>Output Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output Parent</em>'.
	 * @see dataMapper.TreeNode#getOutputParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_OutputParent();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.TreeNode#getInputParent <em>Input Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input Parent</em>'.
	 * @see dataMapper.TreeNode#getInputParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_InputParent();

	/**
	 * Returns the meta object for class '{@link dataMapper.InNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Node</em>'.
	 * @see dataMapper.InNode
	 * @generated
	 */
	EClass getInNode();

	/**
	 * Returns the meta object for the reference list '{@link dataMapper.InNode#getIncomingLink <em>Incoming Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Link</em>'.
	 * @see dataMapper.InNode#getIncomingLink()
	 * @see #getInNode()
	 * @generated
	 */
	EReference getInNode_IncomingLink();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.InNode#getElementParent <em>Element Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Element Parent</em>'.
	 * @see dataMapper.InNode#getElementParent()
	 * @see #getInNode()
	 * @generated
	 */
	EReference getInNode_ElementParent();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.InNode#getAttributeParent <em>Attribute Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Attribute Parent</em>'.
	 * @see dataMapper.InNode#getAttributeParent()
	 * @see #getInNode()
	 * @generated
	 */
	EReference getInNode_AttributeParent();

	/**
	 * Returns the meta object for class '{@link dataMapper.OutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Node</em>'.
	 * @see dataMapper.OutNode
	 * @generated
	 */
	EClass getOutNode();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.OutNode#getOutgoingLink <em>Outgoing Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Link</em>'.
	 * @see dataMapper.OutNode#getOutgoingLink()
	 * @see #getOutNode()
	 * @generated
	 */
	EReference getOutNode_OutgoingLink();

	/**
	 * Returns the meta object for class '{@link dataMapper.DataMapperLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see dataMapper.DataMapperLink
	 * @generated
	 */
	EClass getDataMapperLink();

	/**
	 * Returns the meta object for the reference '{@link dataMapper.DataMapperLink#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Node</em>'.
	 * @see dataMapper.DataMapperLink#getInNode()
	 * @see #getDataMapperLink()
	 * @generated
	 */
	EReference getDataMapperLink_InNode();

	/**
	 * Returns the meta object for the container reference '{@link dataMapper.DataMapperLink#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Out Node</em>'.
	 * @see dataMapper.DataMapperLink#getOutNode()
	 * @see #getDataMapperLink()
	 * @generated
	 */
	EReference getDataMapperLink_OutNode();

	/**
	 * Returns the meta object for class '{@link dataMapper.Concat <em>Concat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concat</em>'.
	 * @see dataMapper.Concat
	 * @generated
	 */
	EClass getConcat();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.Concat#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>In Node</em>'.
	 * @see dataMapper.Concat#getInNode()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_InNode();

	/**
	 * Returns the meta object for the containment reference list '{@link dataMapper.Concat#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out Node</em>'.
	 * @see dataMapper.Concat#getOutNode()
	 * @see #getConcat()
	 * @generated
	 */
	EReference getConcat_OutNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataMapperFactory getDataMapperFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dataMapper.impl.DataMapperNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.DataMapperNodeImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperNode()
		 * @generated
		 */
		EClass DATA_MAPPER_NODE = eINSTANCE.getDataMapperNode();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.DataMapperDiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.DataMapperDiagramImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperDiagram()
		 * @generated
		 */
		EClass DATA_MAPPER_DIAGRAM = eINSTANCE.getDataMapperDiagram();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_DIAGRAM__INPUT = eINSTANCE.getDataMapperDiagram_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_DIAGRAM__OUTPUT = eINSTANCE.getDataMapperDiagram_Output();

		/**
		 * The meta object literal for the '<em><b>Concat</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_DIAGRAM__CONCAT = eINSTANCE.getDataMapperDiagram_Concat();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.DataMapperRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.DataMapperRootImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperRoot()
		 * @generated
		 */
		EClass DATA_MAPPER_ROOT = eINSTANCE.getDataMapperRoot();

		/**
		 * The meta object literal for the '<em><b>Data Mapper Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM = eINSTANCE.getDataMapperRoot_DataMapperDiagram();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.InputImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Tree Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__TREE_NODE = eINSTANCE.getInput_TreeNode();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.OutputImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Tree Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__TREE_NODE = eINSTANCE.getOutput_TreeNode();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.OperatorsImpl <em>Operators</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.OperatorsImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getOperators()
		 * @generated
		 */
		EClass OPERATORS = eINSTANCE.getOperators();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.ElementImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__VALUE = eINSTANCE.getElement_Value();

		/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OUT_NODE = eINSTANCE.getElement_OutNode();

		/**
		 * The meta object literal for the '<em><b>In Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__IN_NODE = eINSTANCE.getElement_InNode();

		/**
		 * The meta object literal for the '<em><b>Field Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__FIELD_PARENT = eINSTANCE.getElement_FieldParent();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.AttributeImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OUT_NODE = eINSTANCE.getAttribute_OutNode();

		/**
		 * The meta object literal for the '<em><b>In Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__IN_NODE = eINSTANCE.getAttribute_InNode();

		/**
		 * The meta object literal for the '<em><b>Field Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__FIELD_PARENT = eINSTANCE.getAttribute_FieldParent();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.TreeNodeImpl <em>Tree Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.TreeNodeImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getTreeNode()
		 * @generated
		 */
		EClass TREE_NODE = eINSTANCE.getTreeNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_NODE__NAME = eINSTANCE.getTreeNode_Name();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__NODE = eINSTANCE.getTreeNode_Node();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__ATTRIBUTE = eINSTANCE.getTreeNode_Attribute();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__ELEMENT = eINSTANCE.getTreeNode_Element();

		/**
		 * The meta object literal for the '<em><b>Field Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__FIELD_PARENT = eINSTANCE.getTreeNode_FieldParent();

		/**
		 * The meta object literal for the '<em><b>Output Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__OUTPUT_PARENT = eINSTANCE.getTreeNode_OutputParent();

		/**
		 * The meta object literal for the '<em><b>Input Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__INPUT_PARENT = eINSTANCE.getTreeNode_InputParent();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.InNodeImpl <em>In Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.InNodeImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getInNode()
		 * @generated
		 */
		EClass IN_NODE = eINSTANCE.getInNode();

		/**
		 * The meta object literal for the '<em><b>Incoming Link</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_NODE__INCOMING_LINK = eINSTANCE.getInNode_IncomingLink();

		/**
		 * The meta object literal for the '<em><b>Element Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_NODE__ELEMENT_PARENT = eINSTANCE.getInNode_ElementParent();

		/**
		 * The meta object literal for the '<em><b>Attribute Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_NODE__ATTRIBUTE_PARENT = eINSTANCE.getInNode_AttributeParent();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.OutNodeImpl <em>Out Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.OutNodeImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getOutNode()
		 * @generated
		 */
		EClass OUT_NODE = eINSTANCE.getOutNode();

		/**
		 * The meta object literal for the '<em><b>Outgoing Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUT_NODE__OUTGOING_LINK = eINSTANCE.getOutNode_OutgoingLink();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.DataMapperLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.DataMapperLinkImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getDataMapperLink()
		 * @generated
		 */
		EClass DATA_MAPPER_LINK = eINSTANCE.getDataMapperLink();

		/**
		 * The meta object literal for the '<em><b>In Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_LINK__IN_NODE = eINSTANCE.getDataMapperLink_InNode();

		/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_LINK__OUT_NODE = eINSTANCE.getDataMapperLink_OutNode();

		/**
		 * The meta object literal for the '{@link dataMapper.impl.ConcatImpl <em>Concat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dataMapper.impl.ConcatImpl
		 * @see dataMapper.impl.DataMapperPackageImpl#getConcat()
		 * @generated
		 */
		EClass CONCAT = eINSTANCE.getConcat();

		/**
		 * The meta object literal for the '<em><b>In Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__IN_NODE = eINSTANCE.getConcat_InNode();

		/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCAT__OUT_NODE = eINSTANCE.getConcat_OutNode();

	}

} //DataMapperPackage
