/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.wso2.developerstudio.datamapper.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataMapperFactoryImpl extends EFactoryImpl implements DataMapperFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataMapperFactory init() {
		try {
			DataMapperFactory theDataMapperFactory = (DataMapperFactory)EPackage.Registry.INSTANCE.getEFactory(DataMapperPackage.eNS_URI);
			if (theDataMapperFactory != null) {
				return theDataMapperFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataMapperFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataMapperPackage.DATA_MAPPER_NODE: return createDataMapperNode();
			case DataMapperPackage.DATA_MAPPER_DIAGRAM: return createDataMapperDiagram();
			case DataMapperPackage.DATA_MAPPER_ROOT: return createDataMapperRoot();
			case DataMapperPackage.INPUT: return createInput();
			case DataMapperPackage.OUTPUT: return createOutput();
			case DataMapperPackage.OPERATOR: return createOperator();
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER: return createOperatorBasicContainer();
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER: return createOperatorLeftContainer();
			case DataMapperPackage.OPERATOR_LEFT_CONNECTOR: return createOperatorLeftConnector();
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER: return createOperatorRightContainer();
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR: return createOperatorRightConnector();
			case DataMapperPackage.ELEMENT: return createElement();
			case DataMapperPackage.ATTRIBUTE: return createAttribute();
			case DataMapperPackage.TREE_NODE: return createTreeNode();
			case DataMapperPackage.IN_NODE: return createInNode();
			case DataMapperPackage.OUT_NODE: return createOutNode();
			case DataMapperPackage.DATA_MAPPER_LINK: return createDataMapperLink();
			case DataMapperPackage.CONCAT: return createConcat();
			case DataMapperPackage.EQUAL: return createEqual();
			case DataMapperPackage.CONSTANT: return createConstant();
			case DataMapperPackage.SPLIT: return createSplit();
			case DataMapperPackage.LOWER_CASE: return createLowerCase();
			case DataMapperPackage.CONTAINS: return createContains();
			case DataMapperPackage.UPPER_CASE: return createUpperCase();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DataMapperPackage.SCHEMA_DATA_TYPE:
				return createSchemaDataTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DataMapperPackage.SCHEMA_DATA_TYPE:
				return convertSchemaDataTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperNode createDataMapperNode() {
		DataMapperNodeImpl dataMapperNode = new DataMapperNodeImpl();
		return dataMapperNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataMapperDiagram createDataMapperDiagram() {
		DataMapperDiagramImpl dataMapperDiagram = new DataMapperDiagramImpl();

		return dataMapperDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataMapperRoot createDataMapperRoot() {
		DataMapperRootImpl dataMapperRoot = new DataMapperRootImpl();
		dataMapperRoot.setInput(createInput());
		dataMapperRoot.setOutput(createOutput());
		return dataMapperRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input createInput() {
		InputImpl input = new InputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OperatorBasicContainer createOperatorBasicContainer() {
		OperatorBasicContainerImpl operatorBasicContainer = new OperatorBasicContainerImpl();
		operatorBasicContainer.setLeftContainer(createOperatorLeftContainer());
		operatorBasicContainer.setRightContainer(createOperatorRightContainer());
		return operatorBasicContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OperatorLeftContainer createOperatorLeftContainer() {
		OperatorLeftContainerImpl operatorLeftContainer = new OperatorLeftContainerImpl();
//		operatorLeftContainer.getLeftConnectors().add(createOperatorLeftConnector()); //FIXME these need to be programmaticaly handled not hard coded
//		operatorLeftContainer.getLeftConnectors().add(createOperatorLeftConnector()); //FIXME these need to be programmaticaly handled not hard coded
		return operatorLeftContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OperatorLeftConnector createOperatorLeftConnector() {
		OperatorLeftConnectorImpl operatorLeftConnector = new OperatorLeftConnectorImpl();
		operatorLeftConnector.setInNode(createInNode());
		return operatorLeftConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OperatorRightContainer createOperatorRightContainer() {
		OperatorRightContainerImpl operatorRightContainer = new OperatorRightContainerImpl();
//		operatorRightContainer.getRightConnectors().add(createOperatorRightConnector()); //FIXME these need to be programmaticaly handled not hard coded
		//operatorRightContainer.getRightConnectors().add(createOperatorRightConnector());
		//operatorRightContainer.getRightConnectors().add(createOperatorRightConnector());
		return operatorRightContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OperatorRightConnector createOperatorRightConnector() {
		OperatorRightConnectorImpl operatorRightConnector = new OperatorRightConnectorImpl();
		operatorRightConnector.setOutNode(createOutNode());
		return operatorRightConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		element.setInNode(createInNode());
		element.setOutNode(createOutNode());
		
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();		
		//attribute.setInNode(createInNode());
		//attribute.setOutNode(createOutNode());
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode createTreeNode() {
		TreeNodeImpl treeNode = new TreeNodeImpl();
		return treeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InNode createInNode() {
		InNodeImpl inNode = new InNodeImpl();
		return inNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutNode createOutNode() {
		OutNodeImpl outNode = new OutNodeImpl();
		return outNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperLink createDataMapperLink() {
		DataMapperLinkImpl dataMapperLink = new DataMapperLinkImpl();
		return dataMapperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Concat createConcat() {
		ConcatImpl concat = new ConcatImpl();
		concat.setBasicContainer(createOperatorBasicContainer());
		return concat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Equal createEqual() {
		EqualImpl equal = new EqualImpl();
		equal.setBasicContainer(createOperatorBasicContainer());
		return equal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Constant createConstant() {
		ConstantImpl constant = new ConstantImpl();
		constant.setBasicContainer(createOperatorBasicContainer());
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Split createSplit() {
		SplitImpl split = new SplitImpl();
		split.setBasicContainer(createOperatorBasicContainer());
		return split;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LowerCase createLowerCase() {
		LowerCaseImpl lowerCase = new LowerCaseImpl();
		lowerCase.setBasicContainer(createOperatorBasicContainer());
		return lowerCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Contains createContains() {
		ContainsImpl contains = new ContainsImpl();
		contains.setBasicContainer(createOperatorBasicContainer());
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UpperCase createUpperCase() {
		UpperCaseImpl upperCase = new UpperCaseImpl();
		upperCase.setBasicContainer(createOperatorBasicContainer());
		return upperCase;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SchemaDataType createSchemaDataTypeFromString(EDataType eDataType, String initialValue) {
		SchemaDataType result = SchemaDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertSchemaDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperPackage getDataMapperPackage() {
		return (DataMapperPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataMapperPackage getPackage() {
		return DataMapperPackage.eINSTANCE;
	}

} //DataMapperFactoryImpl
