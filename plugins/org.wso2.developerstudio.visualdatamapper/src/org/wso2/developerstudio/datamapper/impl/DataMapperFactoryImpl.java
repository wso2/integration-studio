/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.wso2.developerstudio.datamapper.*;
import org.wso2.developerstudio.datamapper.AbsoluteValue;
import org.wso2.developerstudio.datamapper.Add;
import org.wso2.developerstudio.datamapper.Celi;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperNode;
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
			case DataMapperPackage.TRIM: return createTrim();
			case DataMapperPackage.CLONE: return createClone();
			case DataMapperPackage.REPLACE: return createReplace();
			case DataMapperPackage.MATCH: return createMatch();
			case DataMapperPackage.MIN: return createMin();
			case DataMapperPackage.MAX: return createMax();
			case DataMapperPackage.CUSTOM_FUNCTION: return createCustomFunction();
			case DataMapperPackage.PROPERTIES: return createProperties();
			case DataMapperPackage.COMPARE: return createCompare();
			case DataMapperPackage.STRING_TO_NUMBER: return createStringToNumber();
			case DataMapperPackage.STRING_TO_BOOLEAN: return createStringToBoolean();
			case DataMapperPackage.DATA_MAPPER_ROOT: return createDataMapperRoot();
			case DataMapperPackage.STRING_LENGTH: return createStringLength();
			case DataMapperPackage.STARTS_WITH: return createStartsWith();
			case DataMapperPackage.ENDS_WITH: return createEndsWith();
			case DataMapperPackage.SUBSTRING: return createSubstring();
			case DataMapperPackage.IF_ELSE: return createIfElse();
			case DataMapperPackage.AND: return createAND();
			case DataMapperPackage.OR: return createOR();
			case DataMapperPackage.INPUT: return createInput();
			case DataMapperPackage.NOT: return createNOT();
			case DataMapperPackage.OUTPUT: return createOutput();
			case DataMapperPackage.OPERATOR: return createOperator();
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER: return createOperatorBasicContainer();
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER: return createOperatorLeftContainer();
			case DataMapperPackage.OPERATOR_LEFT_CONNECTOR: return createOperatorLeftConnector();
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER: return createOperatorRightContainer();
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR: return createOperatorRightConnector();
			case DataMapperPackage.ELEMENT: return createElement();
			case DataMapperPackage.TREE_NODE: return createTreeNode();
			case DataMapperPackage.SUBTRACT: return createSubtract();
			case DataMapperPackage.IN_NODE: return createInNode();
			case DataMapperPackage.OUT_NODE: return createOutNode();
			case DataMapperPackage.DATA_MAPPER_LINK: return createDataMapperLink();
			case DataMapperPackage.CONCAT: return createConcat();
			case DataMapperPackage.ABSOLUTE_VALUE: return createAbsoluteValue();
			case DataMapperPackage.EQUAL: return createEqual();
			case DataMapperPackage.CONSTANT: return createConstant();
			case DataMapperPackage.ADD: return createAdd();
			case DataMapperPackage.DIVIDE: return createDivide();
			case DataMapperPackage.FLOOR: return createFloor();
			case DataMapperPackage.ROUND: return createRound();
			case DataMapperPackage.MULTIPLY: return createMultiply();
			case DataMapperPackage.SET_PRECISION: return createSetPrecision();
			case DataMapperPackage.SPLIT: return createSplit();
			case DataMapperPackage.LOWER_CASE: return createLowerCase();
			case DataMapperPackage.CELI: return createCeli();
			case DataMapperPackage.UPPER_CASE: return createUpperCase();
			case DataMapperPackage.PROPERTY_KEY_VALUE_PAIR: return createPropertyKeyValuePair();
			case DataMapperPackage.CONTAINS: return createContains();
			case DataMapperPackage.TO_STRING: return createToString();
			case DataMapperPackage.GLOBAL_VARIABLE: return createGlobalVariable();
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION: return createAdvancedCustomFunction();
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
			case DataMapperPackage.COMPARISON_OPERATOR_TYPE:
				return createComparisonOperatorTypeFromString(eDataType, initialValue);
			case DataMapperPackage.SCHEMA_DATA_TYPE:
				return createSchemaDataTypeFromString(eDataType, initialValue);
			case DataMapperPackage.DATA_MAPPER_OPERATOR_TYPE:
				return createDataMapperOperatorTypeFromString(eDataType, initialValue);
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
			case DataMapperPackage.COMPARISON_OPERATOR_TYPE:
				return convertComparisonOperatorTypeToString(eDataType, instanceValue);
			case DataMapperPackage.SCHEMA_DATA_TYPE:
				return convertSchemaDataTypeToString(eDataType, instanceValue);
			case DataMapperPackage.DATA_MAPPER_OPERATOR_TYPE:
				return convertDataMapperOperatorTypeToString(eDataType, instanceValue);
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
	public Trim createTrim() {
		TrimImpl trim = new TrimImpl();
		trim.setBasicContainer(createOperatorBasicContainer());
		return trim;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clone createClone() {
		CloneImpl clone = new CloneImpl();
		return clone;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Replace createReplace() {
		ReplaceImpl replace = new ReplaceImpl();
		replace.setBasicContainer(createOperatorBasicContainer());
		return replace;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Match createMatch() {
		MatchImpl match = new MatchImpl();
		match.setBasicContainer(createOperatorBasicContainer());
		return match;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Min createMin() {
		MinImpl min = new MinImpl();
		min.setBasicContainer(createOperatorBasicContainer());
		return min;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Max createMax() {
		MaxImpl max = new MaxImpl();
		max.setBasicContainer(createOperatorBasicContainer());
		return max;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CustomFunction createCustomFunction() {
		CustomFunctionImpl customFunction = new CustomFunctionImpl();
		customFunction.setBasicContainer(createOperatorBasicContainer());
		return customFunction;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Properties createProperties() {
		PropertiesImpl properties = new PropertiesImpl();
		properties.setBasicContainer(createOperatorBasicContainer());
		return properties;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compare createCompare() {
		CompareImpl compare = new CompareImpl();
		compare.setBasicContainer(createOperatorBasicContainer());
		return compare;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StringToNumber createStringToNumber() {
		StringToNumberImpl stringToNumber = new StringToNumberImpl();
		stringToNumber.setBasicContainer(createOperatorBasicContainer());
		return stringToNumber;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StringToBoolean createStringToBoolean() {
		StringToBooleanImpl stringToBoolean = new StringToBooleanImpl();
		stringToBoolean.setBasicContainer(createOperatorBasicContainer());
		return stringToBoolean;
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
	 * @generated NOT
	 */
	public StringLength createStringLength() {
		StringLengthImpl stringLength = new StringLengthImpl();
		stringLength.setBasicContainer(createOperatorBasicContainer());
		return stringLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StartsWith createStartsWith() {
		StartsWithImpl startsWith = new StartsWithImpl();
		startsWith.setBasicContainer(createOperatorBasicContainer());
		return startsWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EndsWith createEndsWith() {
		EndsWithImpl endsWith = new EndsWithImpl();
		endsWith.setBasicContainer(createOperatorBasicContainer());
		return endsWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Substring createSubstring() {
		SubstringImpl substring = new SubstringImpl();
		substring.setBasicContainer(createOperatorBasicContainer());
		return substring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IfElse createIfElse() {
		IfElseImpl ifElse = new IfElseImpl();
		ifElse.setBasicContainer(createOperatorBasicContainer());
		return ifElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AND createAND() {
		ANDImpl and = new ANDImpl();
		and.setBasicContainer(createOperatorBasicContainer());
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OR createOR() {
		ORImpl or = new ORImpl();
		or.setBasicContainer(createOperatorBasicContainer());
		return or;
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
	 * @generated NOT
	 */
	public NOT createNOT() {
		NOTImpl not = new NOTImpl();
		not.setBasicContainer(createOperatorBasicContainer());
		return not;
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
	public TreeNode createTreeNode() {
		TreeNodeImpl treeNode = new TreeNodeImpl();
		treeNode.setInNode(createInNode());
		treeNode.setOutNode(createOutNode());
		return treeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Subtract createSubtract() {
		SubtractImpl subtract = new SubtractImpl();
		subtract.setBasicContainer(createOperatorBasicContainer());
		return subtract;
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
	public AbsoluteValue createAbsoluteValue() {
		AbsoluteValueImpl absoluteValue = new AbsoluteValueImpl();
		absoluteValue.setBasicContainer(createOperatorBasicContainer());
		return absoluteValue;
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
	public Add createAdd() {
		AddImpl add = new AddImpl();
		add.setBasicContainer(createOperatorBasicContainer());
		return add;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Divide createDivide() {
		DivideImpl divide = new DivideImpl();
		divide.setBasicContainer(createOperatorBasicContainer());
		return divide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Floor createFloor() {
		FloorImpl floor = new FloorImpl();
		floor.setBasicContainer(createOperatorBasicContainer());
		return floor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Round createRound() {
		RoundImpl round = new RoundImpl();
		round.setBasicContainer(createOperatorBasicContainer());
		return round;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Multiply createMultiply() {
		MultiplyImpl multiply = new MultiplyImpl();
		multiply.setBasicContainer(createOperatorBasicContainer());
		return multiply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SetPrecision createSetPrecision() {
		SetPrecisionImpl setPrecision = new SetPrecisionImpl();
		setPrecision.setBasicContainer(createOperatorBasicContainer());
		return setPrecision;
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
	public Celi createCeli() {
		CeliImpl celi = new CeliImpl();
		celi.setBasicContainer(createOperatorBasicContainer());
		return celi;
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
	public PropertyKeyValuePair createPropertyKeyValuePair() {
		PropertyKeyValuePairImpl propertyKeyValuePair = new PropertyKeyValuePairImpl();
		return propertyKeyValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contains createContains() {
		ContainsImpl contains = new ContainsImpl();
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ToString createToString() {
		ToStringImpl toString = new ToStringImpl();
		toString.setBasicContainer(createOperatorBasicContainer());
		return toString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GlobalVariable createGlobalVariable() {
		GlobalVariableImpl globalVariable = new GlobalVariableImpl();
		globalVariable.setBasicContainer(createOperatorBasicContainer());
		return globalVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedCustomFunction createAdvancedCustomFunction() {
		AdvancedCustomFunctionImpl advancedCustomFunction = new AdvancedCustomFunctionImpl();
		return advancedCustomFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonOperatorType createComparisonOperatorTypeFromString(EDataType eDataType, String initialValue) {
		ComparisonOperatorType result = ComparisonOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComparisonOperatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public DataMapperOperatorType createDataMapperOperatorTypeFromString(EDataType eDataType, String initialValue) {
		DataMapperOperatorType result = DataMapperOperatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataMapperOperatorTypeToString(EDataType eDataType, Object instanceValue) {
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
