/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.wso2.developerstudio.datamapper.AbsoluteValue;
import org.wso2.developerstudio.datamapper.Add;
import org.wso2.developerstudio.datamapper.Celi;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperNode;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Divide;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Equal;
import org.wso2.developerstudio.datamapper.Floor;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.Input;
import org.wso2.developerstudio.datamapper.LowerCase;
import org.wso2.developerstudio.datamapper.Multiply;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorBasicContainer;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.Round;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.SetPrecision;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.Subtract;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.UpperCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataMapperPackageImpl extends EPackageImpl implements DataMapperPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorBasicContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorLeftContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorLeftConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorRightContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorRightConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subtractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMapperLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass absoluteValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setPrecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lowerCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass celiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass upperCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyKeyValuePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum schemaDataTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataMapperOperatorTypeEEnum = null;

				/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataMapperPackageImpl() {
		super(eNS_URI, DataMapperFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DataMapperPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataMapperPackage init() {
		if (isInited) return (DataMapperPackage)EPackage.Registry.INSTANCE.getEPackage(DataMapperPackage.eNS_URI);

		// Obtain or create and register package
		DataMapperPackageImpl theDataMapperPackage = (DataMapperPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataMapperPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataMapperPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDataMapperPackage.createPackageContents();

		// Initialize created meta-data
		theDataMapperPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataMapperPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataMapperPackage.eNS_URI, theDataMapperPackage);
		return theDataMapperPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperNode() {
		return dataMapperNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperRoot() {
		return dataMapperRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperRoot_Input() {
		return (EReference)dataMapperRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperRoot_Output() {
		return (EReference)dataMapperRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperRoot_Operators() {
		return (EReference)dataMapperRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_TreeNode() {
		return (EReference)inputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_TreeNode() {
		return (EReference)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_BasicContainer() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Serialized() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_DefaultInputConnectors() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_DefaultOutputConnectors() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_InputVariableType() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_OutputVariableType() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_InputSizeFixed() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_OutputSizeFixed() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_OperatorType() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorBasicContainer() {
		return operatorBasicContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBasicContainer_LeftContainer() {
		return (EReference)operatorBasicContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorBasicContainer_RightContainer() {
		return (EReference)operatorBasicContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorLeftContainer() {
		return operatorLeftContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorLeftContainer_LeftConnectors() {
		return (EReference)operatorLeftContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorLeftConnector() {
		return operatorLeftConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorLeftConnector_InNode() {
		return (EReference)operatorLeftConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorRightContainer() {
		return operatorRightContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorRightContainer_RightConnectors() {
		return (EReference)operatorRightContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorRightConnector() {
		return operatorRightConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorRightConnector_OutNode() {
		return (EReference)operatorRightConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Name() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Value() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_OutNode() {
		return (EReference)elementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_InNode() {
		return (EReference)elementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_FieldParent() {
		return (EReference)elementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getElement_SchemaDataType() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getElement_Level() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_Properties() {
		return (EReference)elementEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeNode() {
		return treeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeNode_Name() {
		return (EAttribute)treeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Node() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Element() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_FieldParent() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_OutputParent() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_InputParent() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getTreeNode_SchemaDataType() {
		return (EAttribute)treeNodeEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getTreeNode_Level() {
		return (EAttribute)treeNodeEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Properties() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(8);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_OutNode() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(9);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_InNode() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(10);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubtract() {
		return subtractEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInNode() {
		return inNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInNode_IncomingLink() {
		return (EReference)inNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInNode_ElementParent() {
		return (EReference)inNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutNode() {
		return outNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutNode_OutgoingLink() {
		return (EReference)outNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutNode_ElementParent() {
		return (EReference)outNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapperLink() {
		return dataMapperLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperLink_InNode() {
		return (EReference)dataMapperLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapperLink_OutNode() {
		return (EReference)dataMapperLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcat() {
		return concatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcat_Delimiter() {
		return (EAttribute)concatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbsoluteValue() {
		return absoluteValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqual() {
		return equalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_ConstantValue() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_Type() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdd() {
		return addEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDivide() {
		return divideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloor() {
		return floorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRound() {
		return roundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiply() {
		return multiplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetPrecision() {
		return setPrecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetPrecision_NumberOfDigits() {
		return (EAttribute)setPrecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSplit() {
		return splitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_Delimiter() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getSplit_ArrayOutput() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_ArrayOutputResultOmitingIndices() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLowerCase() {
		return lowerCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCeli() {
		return celiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContains() {
		return containsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpperCase() {
		return upperCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyKeyValuePair() {
		return propertyKeyValuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyKeyValuePair_Key() {
		return (EAttribute)propertyKeyValuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyKeyValuePair_Value() {
		return (EAttribute)propertyKeyValuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getSchemaDataType() {
		return schemaDataTypeEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataMapperOperatorType() {
		return dataMapperOperatorTypeEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperFactory getDataMapperFactory() {
		return (DataMapperFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dataMapperNodeEClass = createEClass(DATA_MAPPER_NODE);

		dataMapperRootEClass = createEClass(DATA_MAPPER_ROOT);
		createEReference(dataMapperRootEClass, DATA_MAPPER_ROOT__INPUT);
		createEReference(dataMapperRootEClass, DATA_MAPPER_ROOT__OUTPUT);
		createEReference(dataMapperRootEClass, DATA_MAPPER_ROOT__OPERATORS);

		inputEClass = createEClass(INPUT);
		createEReference(inputEClass, INPUT__TREE_NODE);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__TREE_NODE);

		operatorEClass = createEClass(OPERATOR);
		createEReference(operatorEClass, OPERATOR__BASIC_CONTAINER);
		createEAttribute(operatorEClass, OPERATOR__SERIALIZED);
		createEAttribute(operatorEClass, OPERATOR__DEFAULT_INPUT_CONNECTORS);
		createEAttribute(operatorEClass, OPERATOR__DEFAULT_OUTPUT_CONNECTORS);
		createEAttribute(operatorEClass, OPERATOR__INPUT_VARIABLE_TYPE);
		createEAttribute(operatorEClass, OPERATOR__OUTPUT_VARIABLE_TYPE);
		createEAttribute(operatorEClass, OPERATOR__INPUT_SIZE_FIXED);
		createEAttribute(operatorEClass, OPERATOR__OUTPUT_SIZE_FIXED);
		createEAttribute(operatorEClass, OPERATOR__OPERATOR_TYPE);

		operatorBasicContainerEClass = createEClass(OPERATOR_BASIC_CONTAINER);
		createEReference(operatorBasicContainerEClass, OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER);
		createEReference(operatorBasicContainerEClass, OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER);

		operatorLeftContainerEClass = createEClass(OPERATOR_LEFT_CONTAINER);
		createEReference(operatorLeftContainerEClass, OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS);

		operatorLeftConnectorEClass = createEClass(OPERATOR_LEFT_CONNECTOR);
		createEReference(operatorLeftConnectorEClass, OPERATOR_LEFT_CONNECTOR__IN_NODE);

		operatorRightContainerEClass = createEClass(OPERATOR_RIGHT_CONTAINER);
		createEReference(operatorRightContainerEClass, OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS);

		operatorRightConnectorEClass = createEClass(OPERATOR_RIGHT_CONNECTOR);
		createEReference(operatorRightConnectorEClass, OPERATOR_RIGHT_CONNECTOR__OUT_NODE);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__NAME);
		createEAttribute(elementEClass, ELEMENT__VALUE);
		createEReference(elementEClass, ELEMENT__OUT_NODE);
		createEReference(elementEClass, ELEMENT__IN_NODE);
		createEReference(elementEClass, ELEMENT__FIELD_PARENT);
		createEAttribute(elementEClass, ELEMENT__SCHEMA_DATA_TYPE);
		createEAttribute(elementEClass, ELEMENT__LEVEL);
		createEReference(elementEClass, ELEMENT__PROPERTIES);

		treeNodeEClass = createEClass(TREE_NODE);
		createEAttribute(treeNodeEClass, TREE_NODE__NAME);
		createEReference(treeNodeEClass, TREE_NODE__NODE);
		createEReference(treeNodeEClass, TREE_NODE__ELEMENT);
		createEReference(treeNodeEClass, TREE_NODE__FIELD_PARENT);
		createEReference(treeNodeEClass, TREE_NODE__OUTPUT_PARENT);
		createEReference(treeNodeEClass, TREE_NODE__INPUT_PARENT);
		createEAttribute(treeNodeEClass, TREE_NODE__SCHEMA_DATA_TYPE);
		createEAttribute(treeNodeEClass, TREE_NODE__LEVEL);
		createEReference(treeNodeEClass, TREE_NODE__PROPERTIES);
		createEReference(treeNodeEClass, TREE_NODE__OUT_NODE);
		createEReference(treeNodeEClass, TREE_NODE__IN_NODE);

		subtractEClass = createEClass(SUBTRACT);

		inNodeEClass = createEClass(IN_NODE);
		createEReference(inNodeEClass, IN_NODE__INCOMING_LINK);
		createEReference(inNodeEClass, IN_NODE__ELEMENT_PARENT);

		outNodeEClass = createEClass(OUT_NODE);
		createEReference(outNodeEClass, OUT_NODE__OUTGOING_LINK);
		createEReference(outNodeEClass, OUT_NODE__ELEMENT_PARENT);

		dataMapperLinkEClass = createEClass(DATA_MAPPER_LINK);
		createEReference(dataMapperLinkEClass, DATA_MAPPER_LINK__IN_NODE);
		createEReference(dataMapperLinkEClass, DATA_MAPPER_LINK__OUT_NODE);

		concatEClass = createEClass(CONCAT);
		createEAttribute(concatEClass, CONCAT__DELIMITER);

		absoluteValueEClass = createEClass(ABSOLUTE_VALUE);

		equalEClass = createEClass(EQUAL);

		constantEClass = createEClass(CONSTANT);
		createEAttribute(constantEClass, CONSTANT__CONSTANT_VALUE);
		createEAttribute(constantEClass, CONSTANT__TYPE);

		addEClass = createEClass(ADD);

		divideEClass = createEClass(DIVIDE);

		floorEClass = createEClass(FLOOR);

		roundEClass = createEClass(ROUND);

		multiplyEClass = createEClass(MULTIPLY);

		setPrecisionEClass = createEClass(SET_PRECISION);
		createEAttribute(setPrecisionEClass, SET_PRECISION__NUMBER_OF_DIGITS);

		splitEClass = createEClass(SPLIT);
		createEAttribute(splitEClass, SPLIT__DELIMITER);
		createEAttribute(splitEClass, SPLIT__ARRAY_OUTPUT);
		createEAttribute(splitEClass, SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES);

		lowerCaseEClass = createEClass(LOWER_CASE);

		celiEClass = createEClass(CELI);

		containsEClass = createEClass(CONTAINS);

		upperCaseEClass = createEClass(UPPER_CASE);

		propertyKeyValuePairEClass = createEClass(PROPERTY_KEY_VALUE_PAIR);
		createEAttribute(propertyKeyValuePairEClass, PROPERTY_KEY_VALUE_PAIR__KEY);
		createEAttribute(propertyKeyValuePairEClass, PROPERTY_KEY_VALUE_PAIR__VALUE);

		// Create enums
		schemaDataTypeEEnum = createEEnum(SCHEMA_DATA_TYPE);
		dataMapperOperatorTypeEEnum = createEEnum(DATA_MAPPER_OPERATOR_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputEClass.getESuperTypes().add(this.getDataMapperNode());
		outputEClass.getESuperTypes().add(this.getDataMapperNode());
		operatorEClass.getESuperTypes().add(this.getDataMapperNode());
		subtractEClass.getESuperTypes().add(this.getOperator());
		concatEClass.getESuperTypes().add(this.getOperator());
		absoluteValueEClass.getESuperTypes().add(this.getOperator());
		equalEClass.getESuperTypes().add(this.getOperator());
		constantEClass.getESuperTypes().add(this.getOperator());
		addEClass.getESuperTypes().add(this.getOperator());
		divideEClass.getESuperTypes().add(this.getOperator());
		floorEClass.getESuperTypes().add(this.getOperator());
		roundEClass.getESuperTypes().add(this.getOperator());
		multiplyEClass.getESuperTypes().add(this.getOperator());
		setPrecisionEClass.getESuperTypes().add(this.getOperator());
		splitEClass.getESuperTypes().add(this.getOperator());
		lowerCaseEClass.getESuperTypes().add(this.getOperator());
		celiEClass.getESuperTypes().add(this.getOperator());
		containsEClass.getESuperTypes().add(this.getOperator());
		upperCaseEClass.getESuperTypes().add(this.getOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(dataMapperNodeEClass, DataMapperNode.class, "DataMapperNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataMapperRootEClass, DataMapperRoot.class, "DataMapperRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMapperRoot_Input(), this.getInput(), null, "input", null, 0, 1, DataMapperRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperRoot_Output(), this.getOutput(), null, "output", null, 0, 1, DataMapperRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperRoot_Operators(), this.getOperator(), null, "operators", null, 0, -1, DataMapperRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInput_TreeNode(), this.getTreeNode(), this.getTreeNode_InputParent(), "treeNode", null, 0, -1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_TreeNode(), this.getTreeNode(), this.getTreeNode_OutputParent(), "treeNode", null, 0, -1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperator_BasicContainer(), this.getOperatorBasicContainer(), null, "basicContainer", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_Serialized(), ecorePackage.getEBoolean(), "serialized", "false", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_DefaultInputConnectors(), ecorePackage.getEInt(), "defaultInputConnectors", "0", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_DefaultOutputConnectors(), ecorePackage.getEInt(), "defaultOutputConnectors", "0", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_InputVariableType(), this.getSchemaDataType(), "inputVariableType", "STRING", 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_OutputVariableType(), this.getSchemaDataType(), "outputVariableType", "STRING", 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_InputSizeFixed(), ecorePackage.getEBoolean(), "inputSizeFixed", "true", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_OutputSizeFixed(), ecorePackage.getEBoolean(), "outputSizeFixed", "true", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperator_OperatorType(), this.getDataMapperOperatorType(), "operatorType", "OPERATOR", 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorBasicContainerEClass, OperatorBasicContainer.class, "OperatorBasicContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorBasicContainer_LeftContainer(), this.getOperatorLeftContainer(), null, "leftContainer", null, 0, 1, OperatorBasicContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperatorBasicContainer_RightContainer(), this.getOperatorRightContainer(), null, "rightContainer", null, 0, 1, OperatorBasicContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorLeftContainerEClass, OperatorLeftContainer.class, "OperatorLeftContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorLeftContainer_LeftConnectors(), this.getOperatorLeftConnector(), null, "leftConnectors", null, 0, -1, OperatorLeftContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorLeftConnectorEClass, OperatorLeftConnector.class, "OperatorLeftConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorLeftConnector_InNode(), this.getInNode(), null, "inNode", null, 0, 1, OperatorLeftConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorRightContainerEClass, OperatorRightContainer.class, "OperatorRightContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorRightContainer_RightConnectors(), this.getOperatorRightConnector(), null, "rightConnectors", null, 0, -1, OperatorRightContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorRightConnectorEClass, OperatorRightConnector.class, "OperatorRightConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorRightConnector_OutNode(), this.getOutNode(), null, "outNode", null, 0, 1, OperatorRightConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Value(), ecorePackage.getEString(), "value", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_OutNode(), this.getOutNode(), this.getOutNode_ElementParent(), "outNode", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_InNode(), this.getInNode(), this.getInNode_ElementParent(), "inNode", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_FieldParent(), this.getTreeNode(), this.getTreeNode_Element(), "fieldParent", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_SchemaDataType(), this.getSchemaDataType(), "schemaDataType", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Level(), ecorePackage.getEInt(), "level", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_Properties(), this.getPropertyKeyValuePair(), null, "properties", null, 1, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeNodeEClass, TreeNode.class, "TreeNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTreeNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_Node(), this.getTreeNode(), this.getTreeNode_FieldParent(), "node", null, 0, -1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_Element(), this.getElement(), this.getElement_FieldParent(), "element", null, 0, -1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_FieldParent(), this.getTreeNode(), this.getTreeNode_Node(), "fieldParent", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_OutputParent(), this.getOutput(), this.getOutput_TreeNode(), "outputParent", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_InputParent(), this.getInput(), this.getInput_TreeNode(), "inputParent", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeNode_SchemaDataType(), this.getSchemaDataType(), "schemaDataType", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeNode_Level(), ecorePackage.getEInt(), "level", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_Properties(), this.getPropertyKeyValuePair(), null, "properties", null, 1, -1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_OutNode(), this.getOutNode(), null, "outNode", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_InNode(), this.getInNode(), null, "inNode", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subtractEClass, Subtract.class, "Subtract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inNodeEClass, InNode.class, "InNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInNode_IncomingLink(), this.getDataMapperLink(), this.getDataMapperLink_InNode(), "incomingLink", null, 0, -1, InNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInNode_ElementParent(), this.getElement(), this.getElement_InNode(), "elementParent", null, 0, 1, InNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outNodeEClass, OutNode.class, "OutNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutNode_OutgoingLink(), this.getDataMapperLink(), this.getDataMapperLink_OutNode(), "outgoingLink", null, 0, -1, OutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutNode_ElementParent(), this.getElement(), this.getElement_OutNode(), "elementParent", null, 0, 1, OutNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataMapperLinkEClass, DataMapperLink.class, "DataMapperLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMapperLink_InNode(), this.getInNode(), this.getInNode_IncomingLink(), "inNode", null, 0, 1, DataMapperLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapperLink_OutNode(), this.getOutNode(), this.getOutNode_OutgoingLink(), "outNode", null, 0, 1, DataMapperLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concatEClass, Concat.class, "Concat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcat_Delimiter(), ecorePackage.getEString(), "delimiter", null, 0, 1, Concat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(absoluteValueEClass, AbsoluteValue.class, "AbsoluteValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalEClass, Equal.class, "Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstant_ConstantValue(), ecorePackage.getEString(), "constantValue", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstant_Type(), this.getSchemaDataType(), "type", "STRING", 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addEClass, Add.class, "Add", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(divideEClass, Divide.class, "Divide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(floorEClass, Floor.class, "Floor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roundEClass, Round.class, "Round", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiplyEClass, Multiply.class, "Multiply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setPrecisionEClass, SetPrecision.class, "SetPrecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetPrecision_NumberOfDigits(), ecorePackage.getEInt(), "numberOfDigits", "1", 0, 1, SetPrecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splitEClass, Split.class, "Split", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSplit_Delimiter(), ecorePackage.getEString(), "delimiter", null, 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplit_ArrayOutput(), ecorePackage.getEInt(), "arrayOutput", "-1", 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplit_ArrayOutputResultOmitingIndices(), ecorePackage.getEString(), "arrayOutputResultOmitingIndices", null, 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lowerCaseEClass, LowerCase.class, "LowerCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(celiEClass, Celi.class, "Celi", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containsEClass, Contains.class, "Contains", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(upperCaseEClass, UpperCase.class, "UpperCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyKeyValuePairEClass, PropertyKeyValuePair.class, "PropertyKeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyKeyValuePair_Key(), ecorePackage.getEString(), "key", null, 1, 1, PropertyKeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyKeyValuePair_Value(), ecorePackage.getEString(), "value", "", 1, 1, PropertyKeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(schemaDataTypeEEnum, SchemaDataType.class, "SchemaDataType");
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.ARRAY);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.BOOLEAN);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.BYTES);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.DOUBLE);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.ENUM);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.FIXED);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.FLOAT);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.INT);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.LONG);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.MAP);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.NULL);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.RECORD);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.STRING);
		addEEnumLiteral(schemaDataTypeEEnum, SchemaDataType.UNION);

		initEEnum(dataMapperOperatorTypeEEnum, DataMapperOperatorType.class, "DataMapperOperatorType");
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.OPERATOR);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.COMMON_OPERATION);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.DIRECT);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.STRING_OPERATION);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.ARITHMATIC_OPERATION);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.BOOLEAN_OPERATION);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.CONDITIONAL_OPERATION);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.CONSTANT);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.EQUALS);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.CONCAT);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.SPLIT);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.UPPERCASE);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.LOWERCASE);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.CONTAINS);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.ADD);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.SUBTRACT);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.MULTIPLY);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.DIVIDE);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.ABSOLUTE);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.ROUND);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.FLOOR);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.CEILING);
		addEEnumLiteral(dataMapperOperatorTypeEEnum, DataMapperOperatorType.SET_PRECISION);

		// Create resource
		createResource(eNS_URI);
	}

} //DataMapperPackageImpl
