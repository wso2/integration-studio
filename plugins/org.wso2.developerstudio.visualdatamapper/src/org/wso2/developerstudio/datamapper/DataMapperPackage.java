/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.wso2.developerstudio.datamapper.DataMapperFactory
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
	String eNAME = "datamapper";

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
	String eNS_PREFIX = "datamapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataMapperPackage eINSTANCE = org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperNodeImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperNode()
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
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperRoot()
	 * @generated
	 */
	int DATA_MAPPER_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT__INPUT = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT__OUTPUT = 1;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT__OPERATORS = 2;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPER_ROOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.InputImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 9;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.NOTImpl <em>NOT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.NOTImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getNOT()
	 * @generated
	 */
	int NOT = 10;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OutputImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 11;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 12;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__BASIC_CONTAINER = DATA_MAPPER_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SERIALIZED = DATA_MAPPER_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DEFAULT_INPUT_CONNECTORS = DATA_MAPPER_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DEFAULT_OUTPUT_CONNECTORS = DATA_MAPPER_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__INPUT_SIZE_FIXED = DATA_MAPPER_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OUTPUT_SIZE_FIXED = DATA_MAPPER_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__OPERATOR_TYPE = DATA_MAPPER_NODE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = DATA_MAPPER_NODE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.StringLengthImpl <em>String Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.StringLengthImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getStringLength()
	 * @generated
	 */
	int STRING_LENGTH = 2;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>String Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LENGTH_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.StartsWithImpl <em>Starts With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.StartsWithImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getStartsWith()
	 * @generated
	 */
	int STARTS_WITH = 3;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__PATTERN = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Get Pattern From Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH__GET_PATTERN_FROM_INPUT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Starts With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STARTS_WITH_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.EndsWithImpl <em>Ends With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.EndsWithImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getEndsWith()
	 * @generated
	 */
	int ENDS_WITH = 4;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__PATTERN = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Get Pattern From Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH__GET_PATTERN_FROM_INPUT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ends With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDS_WITH_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.SubstringImpl <em>Substring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.SubstringImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSubstring()
	 * @generated
	 */
	int SUBSTRING = 5;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__START_INDEX = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__END_INDEX = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Get Pattern From Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING__GET_PATTERN_FROM_INPUT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Substring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTRING_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.IfElseImpl <em>If Else</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.IfElseImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getIfElse()
	 * @generated
	 */
	int IF_ELSE = 6;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__CONDITION = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Get Pattern From Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE__GET_PATTERN_FROM_INPUT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>If Else</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_ELSE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ANDImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAND()
	 * @generated
	 */
	int AND = 7;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ORImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOR()
	 * @generated
	 */
	int OR = 8;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>NOT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl <em>Operator Basic Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorBasicContainer()
	 * @generated
	 */
	int OPERATOR_BASIC_CONTAINER = 13;

	/**
	 * The feature id for the '<em><b>Left Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Right Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER = 1;

	/**
	 * The number of structural features of the '<em>Operator Basic Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_BASIC_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorLeftContainerImpl <em>Operator Left Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorLeftContainerImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorLeftContainer()
	 * @generated
	 */
	int OPERATOR_LEFT_CONTAINER = 14;

	/**
	 * The feature id for the '<em><b>Left Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS = 0;

	/**
	 * The number of structural features of the '<em>Operator Left Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_LEFT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorLeftConnectorImpl <em>Operator Left Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorLeftConnectorImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorLeftConnector()
	 * @generated
	 */
	int OPERATOR_LEFT_CONNECTOR = 15;

	/**
	 * The feature id for the '<em><b>In Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_LEFT_CONNECTOR__IN_NODE = 0;

	/**
	 * The number of structural features of the '<em>Operator Left Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_LEFT_CONNECTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorRightContainerImpl <em>Operator Right Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorRightContainerImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorRightContainer()
	 * @generated
	 */
	int OPERATOR_RIGHT_CONTAINER = 16;

	/**
	 * The feature id for the '<em><b>Right Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS = 0;

	/**
	 * The number of structural features of the '<em>Operator Right Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_RIGHT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl <em>Operator Right Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorRightConnector()
	 * @generated
	 */
	int OPERATOR_RIGHT_CONNECTOR = 17;

	/**
	 * The feature id for the '<em><b>Out Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_RIGHT_CONNECTOR__OUT_NODE = 0;

	/**
	 * The number of structural features of the '<em>Operator Right Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_RIGHT_CONNECTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ElementImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 18;

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
	 * The feature id for the '<em><b>Schema Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ELEMENT__SCHEMA_DATA_TYPE = 5;

    /**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ELEMENT__LEVEL = 6;

    /**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__PROPERTIES = 7;

				/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.TreeNodeImpl <em>Tree Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.TreeNodeImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getTreeNode()
	 * @generated
	 */
	int TREE_NODE = 19;

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
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Field Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__FIELD_PARENT = 3;

	/**
	 * The feature id for the '<em><b>Output Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__OUTPUT_PARENT = 4;

	/**
	 * The feature id for the '<em><b>Input Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__INPUT_PARENT = 5;

	/**
	 * The feature id for the '<em><b>Schema Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TREE_NODE__SCHEMA_DATA_TYPE = 6;

    /**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TREE_NODE__LEVEL = 7;

    /**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__PROPERTIES = 8;

				/**
	 * The feature id for the '<em><b>Out Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__OUT_NODE = 9;

				/**
	 * The feature id for the '<em><b>In Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__IN_NODE = 10;

				/**
	 * The number of structural features of the '<em>Tree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_FEATURE_COUNT = 11;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.SubtractImpl <em>Subtract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.SubtractImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSubtract()
	 * @generated
	 */
	int SUBTRACT = 20;

				/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

				/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__SERIALIZED = OPERATOR__SERIALIZED;

				/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

				/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

				/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

				/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

				/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

				/**
	 * The number of structural features of the '<em>Subtract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.InNodeImpl <em>In Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.InNodeImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getInNode()
	 * @generated
	 */
	int IN_NODE = 21;

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
	 * The number of structural features of the '<em>In Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.OutNodeImpl <em>Out Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.OutNodeImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOutNode()
	 * @generated
	 */
	int OUT_NODE = 22;

	/**
	 * The feature id for the '<em><b>Outgoing Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_NODE__OUTGOING_LINK = 0;

	/**
	 * The feature id for the '<em><b>Element Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_NODE__ELEMENT_PARENT = 1;

	/**
	 * The number of structural features of the '<em>Out Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_NODE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperLink()
	 * @generated
	 */
	int DATA_MAPPER_LINK = 23;

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
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ConcatImpl <em>Concat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ConcatImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getConcat()
	 * @generated
	 */
	int CONCAT = 24;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT__DELIMITER = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCAT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.AbsoluteValueImpl <em>Absolute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.AbsoluteValueImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAbsoluteValue()
	 * @generated
	 */
	int ABSOLUTE_VALUE = 25;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Absolute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_VALUE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.EqualImpl <em>Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.EqualImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getEqual()
	 * @generated
	 */
	int EQUAL = 26;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ConstantImpl <em>Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ConstantImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getConstant()
	 * @generated
	 */
	int CONSTANT = 27;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__CONSTANT_VALUE = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__TYPE = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.AddImpl <em>Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.AddImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAdd()
	 * @generated
	 */
	int ADD = 28;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.DivideImpl <em>Divide</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.DivideImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDivide()
	 * @generated
	 */
	int DIVIDE = 29;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Divide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.FloorImpl <em>Floor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.FloorImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getFloor()
	 * @generated
	 */
	int FLOOR = 30;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.RoundImpl <em>Round</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.RoundImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getRound()
	 * @generated
	 */
	int ROUND = 31;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Round</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.MultiplyImpl <em>Multiply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.MultiplyImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getMultiply()
	 * @generated
	 */
	int MULTIPLY = 32;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Multiply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.SetPrecisionImpl <em>Set Precision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.SetPrecisionImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSetPrecision()
	 * @generated
	 */
	int SET_PRECISION = 33;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Number Of Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION__NUMBER_OF_DIGITS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Precision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PRECISION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.SplitImpl <em>Split</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.SplitImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSplit()
	 * @generated
	 */
	int SPLIT = 34;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__DELIMITER = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int SPLIT__ARRAY_OUTPUT = OPERATOR_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Array Output Result Omiting Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES = OPERATOR_FEATURE_COUNT + 2;

				/**
	 * The number of structural features of the '<em>Split</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPLIT_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.LowerCaseImpl <em>Lower Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.LowerCaseImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getLowerCase()
	 * @generated
	 */
	int LOWER_CASE = 35;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Lower Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CASE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.CeliImpl <em>Celi</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.CeliImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getCeli()
	 * @generated
	 */
	int CELI = 36;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Celi</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELI_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.ContainsImpl <em>Contains</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.ContainsImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getContains()
	 * @generated
	 */
	int CONTAINS = 37;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Contains</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.UpperCaseImpl <em>Upper Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.UpperCaseImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getUpperCase()
	 * @generated
	 */
	int UPPER_CASE = 38;

	/**
	 * The feature id for the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__BASIC_CONTAINER = OPERATOR__BASIC_CONTAINER;

	/**
	 * The feature id for the '<em><b>Serialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__SERIALIZED = OPERATOR__SERIALIZED;

	/**
	 * The feature id for the '<em><b>Default Input Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__DEFAULT_INPUT_CONNECTORS = OPERATOR__DEFAULT_INPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Default Output Connectors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__DEFAULT_OUTPUT_CONNECTORS = OPERATOR__DEFAULT_OUTPUT_CONNECTORS;

	/**
	 * The feature id for the '<em><b>Input Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__INPUT_SIZE_FIXED = OPERATOR__INPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Output Size Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__OUTPUT_SIZE_FIXED = OPERATOR__OUTPUT_SIZE_FIXED;

	/**
	 * The feature id for the '<em><b>Operator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE__OPERATOR_TYPE = OPERATOR__OPERATOR_TYPE;

	/**
	 * The number of structural features of the '<em>Upper Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CASE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.impl.PropertyKeyValuePairImpl <em>Property Key Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.impl.PropertyKeyValuePairImpl
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getPropertyKeyValuePair()
	 * @generated
	 */
	int PROPERTY_KEY_VALUE_PAIR = 39;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_KEY_VALUE_PAIR__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_KEY_VALUE_PAIR__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Key Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_KEY_VALUE_PAIR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.SchemaDataType <em>Schema Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSchemaDataType()
	 * @generated
	 */
    int SCHEMA_DATA_TYPE = 40;

    /**
	 * The meta object id for the '{@link org.wso2.developerstudio.datamapper.DataMapperOperatorType <em>Operator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.datamapper.DataMapperOperatorType
	 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperOperatorType()
	 * @generated
	 */
	int DATA_MAPPER_OPERATOR_TYPE = 41;

				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.DataMapperNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperNode
	 * @generated
	 */
	EClass getDataMapperNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.DataMapperRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperRoot
	 * @generated
	 */
	EClass getDataMapperRoot();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperRoot#getInput()
	 * @see #getDataMapperRoot()
	 * @generated
	 */
	EReference getDataMapperRoot_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperRoot#getOutput()
	 * @see #getDataMapperRoot()
	 * @generated
	 */
	EReference getDataMapperRoot_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operators</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperRoot#getOperators()
	 * @see #getDataMapperRoot()
	 * @generated
	 */
	EReference getDataMapperRoot_Operators();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.StringLength <em>String Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Length</em>'.
	 * @see org.wso2.developerstudio.datamapper.StringLength
	 * @generated
	 */
	EClass getStringLength();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.StartsWith <em>Starts With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Starts With</em>'.
	 * @see org.wso2.developerstudio.datamapper.StartsWith
	 * @generated
	 */
	EClass getStartsWith();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.StartsWith#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.wso2.developerstudio.datamapper.StartsWith#getPattern()
	 * @see #getStartsWith()
	 * @generated
	 */
	EAttribute getStartsWith_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.StartsWith#isGetPatternFromInput <em>Get Pattern From Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get Pattern From Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.StartsWith#isGetPatternFromInput()
	 * @see #getStartsWith()
	 * @generated
	 */
	EAttribute getStartsWith_GetPatternFromInput();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.EndsWith <em>Ends With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ends With</em>'.
	 * @see org.wso2.developerstudio.datamapper.EndsWith
	 * @generated
	 */
	EClass getEndsWith();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.EndsWith#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.wso2.developerstudio.datamapper.EndsWith#getPattern()
	 * @see #getEndsWith()
	 * @generated
	 */
	EAttribute getEndsWith_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.EndsWith#isGetPatternFromInput <em>Get Pattern From Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get Pattern From Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.EndsWith#isGetPatternFromInput()
	 * @see #getEndsWith()
	 * @generated
	 */
	EAttribute getEndsWith_GetPatternFromInput();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Substring <em>Substring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substring</em>'.
	 * @see org.wso2.developerstudio.datamapper.Substring
	 * @generated
	 */
	EClass getSubstring();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Substring#getStartIndex <em>Start Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Index</em>'.
	 * @see org.wso2.developerstudio.datamapper.Substring#getStartIndex()
	 * @see #getSubstring()
	 * @generated
	 */
	EAttribute getSubstring_StartIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Substring#getEndIndex <em>End Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Index</em>'.
	 * @see org.wso2.developerstudio.datamapper.Substring#getEndIndex()
	 * @see #getSubstring()
	 * @generated
	 */
	EAttribute getSubstring_EndIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Substring#isGetPatternFromInput <em>Get Pattern From Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get Pattern From Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.Substring#isGetPatternFromInput()
	 * @see #getSubstring()
	 * @generated
	 */
	EAttribute getSubstring_GetPatternFromInput();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.IfElse <em>If Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Else</em>'.
	 * @see org.wso2.developerstudio.datamapper.IfElse
	 * @generated
	 */
	EClass getIfElse();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.IfElse#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.wso2.developerstudio.datamapper.IfElse#getCondition()
	 * @see #getIfElse()
	 * @generated
	 */
	EAttribute getIfElse_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.IfElse#isGetPatternFromInput <em>Get Pattern From Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get Pattern From Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.IfElse#isGetPatternFromInput()
	 * @see #getIfElse()
	 * @generated
	 */
	EAttribute getIfElse_GetPatternFromInput();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see org.wso2.developerstudio.datamapper.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see org.wso2.developerstudio.datamapper.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see org.wso2.developerstudio.datamapper.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.Input#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tree Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.Input#getTreeNode()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_TreeNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NOT</em>'.
	 * @see org.wso2.developerstudio.datamapper.NOT
	 * @generated
	 */
	EClass getNOT();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see org.wso2.developerstudio.datamapper.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.Output#getTreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tree Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.Output#getTreeNode()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_TreeNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.Operator#getBasicContainer <em>Basic Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#getBasicContainer()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_BasicContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#isSerialized <em>Serialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serialized</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#isSerialized()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Serialized();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#getDefaultInputConnectors <em>Default Input Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Input Connectors</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#getDefaultInputConnectors()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_DefaultInputConnectors();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#getDefaultOutputConnectors <em>Default Output Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Output Connectors</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#getDefaultOutputConnectors()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_DefaultOutputConnectors();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#isInputSizeFixed <em>Input Size Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Size Fixed</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#isInputSizeFixed()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_InputSizeFixed();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#isOutputSizeFixed <em>Output Size Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Size Fixed</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#isOutputSizeFixed()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_OutputSizeFixed();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Operator#getOperatorType <em>Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.Operator#getOperatorType()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_OperatorType();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer <em>Operator Basic Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Basic Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorBasicContainer
	 * @generated
	 */
	EClass getOperatorBasicContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getLeftContainer <em>Left Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorBasicContainer#getLeftContainer()
	 * @see #getOperatorBasicContainer()
	 * @generated
	 */
	EReference getOperatorBasicContainer_LeftContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer#getRightContainer <em>Right Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorBasicContainer#getRightContainer()
	 * @see #getOperatorBasicContainer()
	 * @generated
	 */
	EReference getOperatorBasicContainer_RightContainer();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OperatorLeftContainer <em>Operator Left Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Left Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftContainer
	 * @generated
	 */
	EClass getOperatorLeftContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.OperatorLeftContainer#getLeftConnectors <em>Left Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Left Connectors</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftContainer#getLeftConnectors()
	 * @see #getOperatorLeftContainer()
	 * @generated
	 */
	EReference getOperatorLeftContainer_LeftConnectors();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OperatorLeftConnector <em>Operator Left Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Left Connector</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftConnector
	 * @generated
	 */
	EClass getOperatorLeftConnector();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.OperatorLeftConnector#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftConnector#getInNode()
	 * @see #getOperatorLeftConnector()
	 * @generated
	 */
	EReference getOperatorLeftConnector_InNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OperatorRightContainer <em>Operator Right Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Right Container</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightContainer
	 * @generated
	 */
	EClass getOperatorRightContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.OperatorRightContainer#getRightConnectors <em>Right Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Right Connectors</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightContainer#getRightConnectors()
	 * @see #getOperatorRightContainer()
	 * @generated
	 */
	EReference getOperatorRightContainer_RightConnectors();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OperatorRightConnector <em>Operator Right Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Right Connector</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightConnector
	 * @generated
	 */
	EClass getOperatorRightConnector();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.OperatorRightConnector#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightConnector#getOutNode()
	 * @see #getOperatorRightConnector()
	 * @generated
	 */
	EReference getOperatorRightConnector_OutNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Element#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getValue()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Value();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.Element#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getOutNode()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OutNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.Element#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getInNode()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_InNode();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.Element#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Field Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getFieldParent()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_FieldParent();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Element#getSchemaDataType <em>Schema Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Data Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getSchemaDataType()
	 * @see #getElement()
	 * @generated
	 */
    EAttribute getElement_SchemaDataType();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Element#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getLevel()
	 * @see #getElement()
	 * @generated
	 */
    EAttribute getElement_Level();

    /**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.Element#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.datamapper.Element#getProperties()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Properties();

				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode
	 * @generated
	 */
	EClass getTreeNode();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.TreeNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getName()
	 * @see #getTreeNode()
	 * @generated
	 */
	EAttribute getTreeNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.TreeNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getNode()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Node();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.TreeNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getElement()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Element();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.TreeNode#getFieldParent <em>Field Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Field Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getFieldParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_FieldParent();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.TreeNode#getOutputParent <em>Output Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getOutputParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_OutputParent();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.TreeNode#getInputParent <em>Input Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getInputParent()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_InputParent();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.TreeNode#getSchemaDataType <em>Schema Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Data Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getSchemaDataType()
	 * @see #getTreeNode()
	 * @generated
	 */
    EAttribute getTreeNode_SchemaDataType();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.TreeNode#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getLevel()
	 * @see #getTreeNode()
	 * @generated
	 */
    EAttribute getTreeNode_Level();

    /**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.TreeNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getProperties()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Properties();

				/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.TreeNode#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getOutNode()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_OutNode();

				/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.datamapper.TreeNode#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.TreeNode#getInNode()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_InNode();

				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Subtract <em>Subtract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtract</em>'.
	 * @see org.wso2.developerstudio.datamapper.Subtract
	 * @generated
	 */
	EClass getSubtract();

				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.InNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.InNode
	 * @generated
	 */
	EClass getInNode();

	/**
	 * Returns the meta object for the reference list '{@link org.wso2.developerstudio.datamapper.InNode#getIncomingLink <em>Incoming Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Link</em>'.
	 * @see org.wso2.developerstudio.datamapper.InNode#getIncomingLink()
	 * @see #getInNode()
	 * @generated
	 */
	EReference getInNode_IncomingLink();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.InNode#getElementParent <em>Element Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Element Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.InNode#getElementParent()
	 * @see #getInNode()
	 * @generated
	 */
	EReference getInNode_ElementParent();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.OutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.OutNode
	 * @generated
	 */
	EClass getOutNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.datamapper.OutNode#getOutgoingLink <em>Outgoing Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Link</em>'.
	 * @see org.wso2.developerstudio.datamapper.OutNode#getOutgoingLink()
	 * @see #getOutNode()
	 * @generated
	 */
	EReference getOutNode_OutgoingLink();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.OutNode#getElementParent <em>Element Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Element Parent</em>'.
	 * @see org.wso2.developerstudio.datamapper.OutNode#getElementParent()
	 * @see #getOutNode()
	 * @generated
	 */
	EReference getOutNode_ElementParent();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.DataMapperLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink
	 * @generated
	 */
	EClass getDataMapperLink();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink#getInNode()
	 * @see #getDataMapperLink()
	 * @generated
	 */
	EReference getDataMapperLink_InNode();

	/**
	 * Returns the meta object for the container reference '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Out Node</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode()
	 * @see #getDataMapperLink()
	 * @generated
	 */
	EReference getDataMapperLink_OutNode();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Concat <em>Concat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concat</em>'.
	 * @see org.wso2.developerstudio.datamapper.Concat
	 * @generated
	 */
	EClass getConcat();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Concat#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see org.wso2.developerstudio.datamapper.Concat#getDelimiter()
	 * @see #getConcat()
	 * @generated
	 */
	EAttribute getConcat_Delimiter();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.AbsoluteValue <em>Absolute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Absolute Value</em>'.
	 * @see org.wso2.developerstudio.datamapper.AbsoluteValue
	 * @generated
	 */
	EClass getAbsoluteValue();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see org.wso2.developerstudio.datamapper.Equal
	 * @generated
	 */
	EClass getEqual();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant</em>'.
	 * @see org.wso2.developerstudio.datamapper.Constant
	 * @generated
	 */
	EClass getConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Constant#getConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant Value</em>'.
	 * @see org.wso2.developerstudio.datamapper.Constant#getConstantValue()
	 * @see #getConstant()
	 * @generated
	 */
	EAttribute getConstant_ConstantValue();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Constant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.Constant#getType()
	 * @see #getConstant()
	 * @generated
	 */
	EAttribute getConstant_Type();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add</em>'.
	 * @see org.wso2.developerstudio.datamapper.Add
	 * @generated
	 */
	EClass getAdd();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Divide <em>Divide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Divide</em>'.
	 * @see org.wso2.developerstudio.datamapper.Divide
	 * @generated
	 */
	EClass getDivide();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floor</em>'.
	 * @see org.wso2.developerstudio.datamapper.Floor
	 * @generated
	 */
	EClass getFloor();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Round <em>Round</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round</em>'.
	 * @see org.wso2.developerstudio.datamapper.Round
	 * @generated
	 */
	EClass getRound();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Multiply <em>Multiply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply</em>'.
	 * @see org.wso2.developerstudio.datamapper.Multiply
	 * @generated
	 */
	EClass getMultiply();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.SetPrecision <em>Set Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Precision</em>'.
	 * @see org.wso2.developerstudio.datamapper.SetPrecision
	 * @generated
	 */
	EClass getSetPrecision();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.SetPrecision#getNumberOfDigits <em>Number Of Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Digits</em>'.
	 * @see org.wso2.developerstudio.datamapper.SetPrecision#getNumberOfDigits()
	 * @see #getSetPrecision()
	 * @generated
	 */
	EAttribute getSetPrecision_NumberOfDigits();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Split <em>Split</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Split</em>'.
	 * @see org.wso2.developerstudio.datamapper.Split
	 * @generated
	 */
	EClass getSplit();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Split#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see org.wso2.developerstudio.datamapper.Split#getDelimiter()
	 * @see #getSplit()
	 * @generated
	 */
	EAttribute getSplit_Delimiter();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Split#getArrayOutput <em>Array Output</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Output</em>'.
	 * @see org.wso2.developerstudio.datamapper.Split#getArrayOutput()
	 * @see #getSplit()
	 * @generated
	 */
    EAttribute getSplit_ArrayOutput();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.Split#getArrayOutputResultOmitingIndices <em>Array Output Result Omiting Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Output Result Omiting Indices</em>'.
	 * @see org.wso2.developerstudio.datamapper.Split#getArrayOutputResultOmitingIndices()
	 * @see #getSplit()
	 * @generated
	 */
	EAttribute getSplit_ArrayOutputResultOmitingIndices();

				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.LowerCase <em>Lower Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Case</em>'.
	 * @see org.wso2.developerstudio.datamapper.LowerCase
	 * @generated
	 */
	EClass getLowerCase();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Celi <em>Celi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Celi</em>'.
	 * @see org.wso2.developerstudio.datamapper.Celi
	 * @generated
	 */
	EClass getCeli();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.Contains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains</em>'.
	 * @see org.wso2.developerstudio.datamapper.Contains
	 * @generated
	 */
	EClass getContains();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.UpperCase <em>Upper Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Case</em>'.
	 * @see org.wso2.developerstudio.datamapper.UpperCase
	 * @generated
	 */
	EClass getUpperCase();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair <em>Property Key Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Key Value Pair</em>'.
	 * @see org.wso2.developerstudio.datamapper.PropertyKeyValuePair
	 * @generated
	 */
	EClass getPropertyKeyValuePair();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getKey()
	 * @see #getPropertyKeyValuePair()
	 * @generated
	 */
	EAttribute getPropertyKeyValuePair_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getValue()
	 * @see #getPropertyKeyValuePair()
	 * @generated
	 */
	EAttribute getPropertyKeyValuePair_Value();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.datamapper.SchemaDataType <em>Schema Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Schema Data Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.SchemaDataType
	 * @generated
	 */
    EEnum getSchemaDataType();

    /**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.datamapper.DataMapperOperatorType <em>Operator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Type</em>'.
	 * @see org.wso2.developerstudio.datamapper.DataMapperOperatorType
	 * @generated
	 */
	EEnum getDataMapperOperatorType();

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
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperNodeImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperNode()
		 * @generated
		 */
		EClass DATA_MAPPER_NODE = eINSTANCE.getDataMapperNode();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperRoot()
		 * @generated
		 */
		EClass DATA_MAPPER_ROOT = eINSTANCE.getDataMapperRoot();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_ROOT__INPUT = eINSTANCE.getDataMapperRoot_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_ROOT__OUTPUT = eINSTANCE.getDataMapperRoot_Output();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPER_ROOT__OPERATORS = eINSTANCE.getDataMapperRoot_Operators();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.StringLengthImpl <em>String Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.StringLengthImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getStringLength()
		 * @generated
		 */
		EClass STRING_LENGTH = eINSTANCE.getStringLength();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.StartsWithImpl <em>Starts With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.StartsWithImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getStartsWith()
		 * @generated
		 */
		EClass STARTS_WITH = eINSTANCE.getStartsWith();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTS_WITH__PATTERN = eINSTANCE.getStartsWith_Pattern();

		/**
		 * The meta object literal for the '<em><b>Get Pattern From Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STARTS_WITH__GET_PATTERN_FROM_INPUT = eINSTANCE.getStartsWith_GetPatternFromInput();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.EndsWithImpl <em>Ends With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.EndsWithImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getEndsWith()
		 * @generated
		 */
		EClass ENDS_WITH = eINSTANCE.getEndsWith();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDS_WITH__PATTERN = eINSTANCE.getEndsWith_Pattern();

		/**
		 * The meta object literal for the '<em><b>Get Pattern From Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDS_WITH__GET_PATTERN_FROM_INPUT = eINSTANCE.getEndsWith_GetPatternFromInput();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.SubstringImpl <em>Substring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.SubstringImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSubstring()
		 * @generated
		 */
		EClass SUBSTRING = eINSTANCE.getSubstring();

		/**
		 * The meta object literal for the '<em><b>Start Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTRING__START_INDEX = eINSTANCE.getSubstring_StartIndex();

		/**
		 * The meta object literal for the '<em><b>End Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTRING__END_INDEX = eINSTANCE.getSubstring_EndIndex();

		/**
		 * The meta object literal for the '<em><b>Get Pattern From Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTRING__GET_PATTERN_FROM_INPUT = eINSTANCE.getSubstring_GetPatternFromInput();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.IfElseImpl <em>If Else</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.IfElseImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getIfElse()
		 * @generated
		 */
		EClass IF_ELSE = eINSTANCE.getIfElse();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_ELSE__CONDITION = eINSTANCE.getIfElse_Condition();

		/**
		 * The meta object literal for the '<em><b>Get Pattern From Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_ELSE__GET_PATTERN_FROM_INPUT = eINSTANCE.getIfElse_GetPatternFromInput();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ANDImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ORImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.InputImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getInput()
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
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.NOTImpl <em>NOT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.NOTImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getNOT()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNOT();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OutputImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOutput()
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
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Basic Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__BASIC_CONTAINER = eINSTANCE.getOperator_BasicContainer();

		/**
		 * The meta object literal for the '<em><b>Serialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__SERIALIZED = eINSTANCE.getOperator_Serialized();

		/**
		 * The meta object literal for the '<em><b>Default Input Connectors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__DEFAULT_INPUT_CONNECTORS = eINSTANCE.getOperator_DefaultInputConnectors();

		/**
		 * The meta object literal for the '<em><b>Default Output Connectors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__DEFAULT_OUTPUT_CONNECTORS = eINSTANCE.getOperator_DefaultOutputConnectors();

		/**
		 * The meta object literal for the '<em><b>Input Size Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__INPUT_SIZE_FIXED = eINSTANCE.getOperator_InputSizeFixed();

		/**
		 * The meta object literal for the '<em><b>Output Size Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__OUTPUT_SIZE_FIXED = eINSTANCE.getOperator_OutputSizeFixed();

		/**
		 * The meta object literal for the '<em><b>Operator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__OPERATOR_TYPE = eINSTANCE.getOperator_OperatorType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl <em>Operator Basic Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorBasicContainer()
		 * @generated
		 */
		EClass OPERATOR_BASIC_CONTAINER = eINSTANCE.getOperatorBasicContainer();

		/**
		 * The meta object literal for the '<em><b>Left Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER = eINSTANCE.getOperatorBasicContainer_LeftContainer();

		/**
		 * The meta object literal for the '<em><b>Right Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER = eINSTANCE.getOperatorBasicContainer_RightContainer();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorLeftContainerImpl <em>Operator Left Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorLeftContainerImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorLeftContainer()
		 * @generated
		 */
		EClass OPERATOR_LEFT_CONTAINER = eINSTANCE.getOperatorLeftContainer();

		/**
		 * The meta object literal for the '<em><b>Left Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS = eINSTANCE.getOperatorLeftContainer_LeftConnectors();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorLeftConnectorImpl <em>Operator Left Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorLeftConnectorImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorLeftConnector()
		 * @generated
		 */
		EClass OPERATOR_LEFT_CONNECTOR = eINSTANCE.getOperatorLeftConnector();

		/**
		 * The meta object literal for the '<em><b>In Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_LEFT_CONNECTOR__IN_NODE = eINSTANCE.getOperatorLeftConnector_InNode();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorRightContainerImpl <em>Operator Right Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorRightContainerImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorRightContainer()
		 * @generated
		 */
		EClass OPERATOR_RIGHT_CONTAINER = eINSTANCE.getOperatorRightContainer();

		/**
		 * The meta object literal for the '<em><b>Right Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS = eINSTANCE.getOperatorRightContainer_RightConnectors();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl <em>Operator Right Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOperatorRightConnector()
		 * @generated
		 */
		EClass OPERATOR_RIGHT_CONNECTOR = eINSTANCE.getOperatorRightConnector();

		/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_RIGHT_CONNECTOR__OUT_NODE = eINSTANCE.getOperatorRightConnector_OutNode();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ElementImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getElement()
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
		 * The meta object literal for the '<em><b>Schema Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute ELEMENT__SCHEMA_DATA_TYPE = eINSTANCE.getElement_SchemaDataType();

        /**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute ELEMENT__LEVEL = eINSTANCE.getElement_Level();

        /**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__PROPERTIES = eINSTANCE.getElement_Properties();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.TreeNodeImpl <em>Tree Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.TreeNodeImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getTreeNode()
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
		 * The meta object literal for the '<em><b>Schema Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute TREE_NODE__SCHEMA_DATA_TYPE = eINSTANCE.getTreeNode_SchemaDataType();

        /**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute TREE_NODE__LEVEL = eINSTANCE.getTreeNode_Level();

        /**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__PROPERTIES = eINSTANCE.getTreeNode_Properties();

								/**
		 * The meta object literal for the '<em><b>Out Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__OUT_NODE = eINSTANCE.getTreeNode_OutNode();

								/**
		 * The meta object literal for the '<em><b>In Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__IN_NODE = eINSTANCE.getTreeNode_InNode();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.SubtractImpl <em>Subtract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.SubtractImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSubtract()
		 * @generated
		 */
		EClass SUBTRACT = eINSTANCE.getSubtract();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.InNodeImpl <em>In Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.InNodeImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getInNode()
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
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.OutNodeImpl <em>Out Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.OutNodeImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getOutNode()
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
		 * The meta object literal for the '<em><b>Element Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUT_NODE__ELEMENT_PARENT = eINSTANCE.getOutNode_ElementParent();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperLink()
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
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ConcatImpl <em>Concat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ConcatImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getConcat()
		 * @generated
		 */
		EClass CONCAT = eINSTANCE.getConcat();

		/**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCAT__DELIMITER = eINSTANCE.getConcat_Delimiter();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.AbsoluteValueImpl <em>Absolute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.AbsoluteValueImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAbsoluteValue()
		 * @generated
		 */
		EClass ABSOLUTE_VALUE = eINSTANCE.getAbsoluteValue();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.EqualImpl <em>Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.EqualImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getEqual()
		 * @generated
		 */
		EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ConstantImpl <em>Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ConstantImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getConstant()
		 * @generated
		 */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
		 * The meta object literal for the '<em><b>Constant Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT__CONSTANT_VALUE = eINSTANCE.getConstant_ConstantValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT__TYPE = eINSTANCE.getConstant_Type();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.AddImpl <em>Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.AddImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getAdd()
		 * @generated
		 */
		EClass ADD = eINSTANCE.getAdd();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.DivideImpl <em>Divide</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.DivideImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDivide()
		 * @generated
		 */
		EClass DIVIDE = eINSTANCE.getDivide();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.FloorImpl <em>Floor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.FloorImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getFloor()
		 * @generated
		 */
		EClass FLOOR = eINSTANCE.getFloor();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.RoundImpl <em>Round</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.RoundImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getRound()
		 * @generated
		 */
		EClass ROUND = eINSTANCE.getRound();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.MultiplyImpl <em>Multiply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.MultiplyImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getMultiply()
		 * @generated
		 */
		EClass MULTIPLY = eINSTANCE.getMultiply();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.SetPrecisionImpl <em>Set Precision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.SetPrecisionImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSetPrecision()
		 * @generated
		 */
		EClass SET_PRECISION = eINSTANCE.getSetPrecision();

		/**
		 * The meta object literal for the '<em><b>Number Of Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_PRECISION__NUMBER_OF_DIGITS = eINSTANCE.getSetPrecision_NumberOfDigits();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.SplitImpl <em>Split</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.SplitImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSplit()
		 * @generated
		 */
		EClass SPLIT = eINSTANCE.getSplit();

        /**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT__DELIMITER = eINSTANCE.getSplit_Delimiter();

								/**
		 * The meta object literal for the '<em><b>Array Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute SPLIT__ARRAY_OUTPUT = eINSTANCE.getSplit_ArrayOutput();

                                /**
		 * The meta object literal for the '<em><b>Array Output Result Omiting Indices</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES = eINSTANCE.getSplit_ArrayOutputResultOmitingIndices();

																																/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.LowerCaseImpl <em>Lower Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.LowerCaseImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getLowerCase()
		 * @generated
		 */
		EClass LOWER_CASE = eINSTANCE.getLowerCase();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.CeliImpl <em>Celi</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.CeliImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getCeli()
		 * @generated
		 */
		EClass CELI = eINSTANCE.getCeli();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.ContainsImpl <em>Contains</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.ContainsImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getContains()
		 * @generated
		 */
		EClass CONTAINS = eINSTANCE.getContains();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.UpperCaseImpl <em>Upper Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.UpperCaseImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getUpperCase()
		 * @generated
		 */
		EClass UPPER_CASE = eINSTANCE.getUpperCase();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.impl.PropertyKeyValuePairImpl <em>Property Key Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.impl.PropertyKeyValuePairImpl
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getPropertyKeyValuePair()
		 * @generated
		 */
		EClass PROPERTY_KEY_VALUE_PAIR = eINSTANCE.getPropertyKeyValuePair();

								/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_KEY_VALUE_PAIR__KEY = eINSTANCE.getPropertyKeyValuePair_Key();

								/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_KEY_VALUE_PAIR__VALUE = eINSTANCE.getPropertyKeyValuePair_Value();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.SchemaDataType <em>Schema Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.SchemaDataType
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getSchemaDataType()
		 * @generated
		 */
        EEnum SCHEMA_DATA_TYPE = eINSTANCE.getSchemaDataType();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.datamapper.DataMapperOperatorType <em>Operator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.datamapper.DataMapperOperatorType
		 * @see org.wso2.developerstudio.datamapper.impl.DataMapperPackageImpl#getDataMapperOperatorType()
		 * @generated
		 */
		EEnum DATA_MAPPER_OPERATOR_TYPE = eINSTANCE.getDataMapperOperatorType();

	}

} //DataMapperPackage
