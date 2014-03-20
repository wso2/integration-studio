/**
 */
package dataMapper.impl;

import java.lang.reflect.InvocationTargetException;

import dataMapper.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;

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
			case DataMapperPackage.OPERATORS: return createOperators();
			case DataMapperPackage.ELEMENT: return createElement();
			case DataMapperPackage.ATTRIBUTE: return createAttribute();
			case DataMapperPackage.TREE_NODE: return createTreeNode();
			case DataMapperPackage.IN_NODE: return createInNode();
			case DataMapperPackage.OUT_NODE: return createOutNode();
			case DataMapperPackage.DATA_MAPPER_LINK: return createDataMapperLink();
			case DataMapperPackage.CONCAT: return createConcat();
			case DataMapperPackage.EQUAL: return createEqual();
			case DataMapperPackage.CONSTANT: return createConstant();
			case DataMapperPackage.OPERATION: return createOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public Operators createOperators() {
		OperatorsImpl operators = new OperatorsImpl();
		return operators;
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
	 * @generated
	 */
	public Concat createConcat() {
		ConcatImpl concat = new ConcatImpl();
		return concat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equal createEqual() {
		EqualImpl equal = new EqualImpl();
		return equal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constant createConstant() {
		ConstantImpl constant = new ConstantImpl();
		return constant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
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
