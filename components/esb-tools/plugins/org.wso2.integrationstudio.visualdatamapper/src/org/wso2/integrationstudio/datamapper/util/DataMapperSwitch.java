/**
 */
package org.wso2.integrationstudio.datamapper.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.wso2.integrationstudio.datamapper.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.datamapper.DataMapperPackage
 * @generated
 */
public class DataMapperSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataMapperPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperSwitch() {
		if (modelPackage == null) {
			modelPackage = DataMapperPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DataMapperPackage.DATA_MAPPER_NODE: {
				DataMapperNode dataMapperNode = (DataMapperNode)theEObject;
				T result = caseDataMapperNode(dataMapperNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.TRIM: {
				Trim trim = (Trim)theEObject;
				T result = caseTrim(trim);
				if (result == null) result = caseOperator(trim);
				if (result == null) result = caseDataMapperNode(trim);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CLONE: {
				Clone clone = (Clone)theEObject;
				T result = caseClone(clone);
				if (result == null) result = caseOperator(clone);
				if (result == null) result = caseDataMapperNode(clone);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.REPLACE: {
				Replace replace = (Replace)theEObject;
				T result = caseReplace(replace);
				if (result == null) result = caseOperator(replace);
				if (result == null) result = caseDataMapperNode(replace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.MATCH: {
				Match match = (Match)theEObject;
				T result = caseMatch(match);
				if (result == null) result = caseOperator(match);
				if (result == null) result = caseDataMapperNode(match);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.MIN: {
				Min min = (Min)theEObject;
				T result = caseMin(min);
				if (result == null) result = caseOperator(min);
				if (result == null) result = caseDataMapperNode(min);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.MAX: {
				Max max = (Max)theEObject;
				T result = caseMax(max);
				if (result == null) result = caseOperator(max);
				if (result == null) result = caseDataMapperNode(max);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CUSTOM_FUNCTION: {
				CustomFunction customFunction = (CustomFunction)theEObject;
				T result = caseCustomFunction(customFunction);
				if (result == null) result = caseOperator(customFunction);
				if (result == null) result = caseDataMapperNode(customFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.PROPERTIES: {
				Properties properties = (Properties)theEObject;
				T result = caseProperties(properties);
				if (result == null) result = caseOperator(properties);
				if (result == null) result = caseDataMapperNode(properties);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.COMPARE: {
				Compare compare = (Compare)theEObject;
				T result = caseCompare(compare);
				if (result == null) result = caseOperator(compare);
				if (result == null) result = caseDataMapperNode(compare);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.STRING_TO_NUMBER: {
				StringToNumber stringToNumber = (StringToNumber)theEObject;
				T result = caseStringToNumber(stringToNumber);
				if (result == null) result = caseOperator(stringToNumber);
				if (result == null) result = caseDataMapperNode(stringToNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.STRING_TO_BOOLEAN: {
				StringToBoolean stringToBoolean = (StringToBoolean)theEObject;
				T result = caseStringToBoolean(stringToBoolean);
				if (result == null) result = caseOperator(stringToBoolean);
				if (result == null) result = caseDataMapperNode(stringToBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.DATA_MAPPER_ROOT: {
				DataMapperRoot dataMapperRoot = (DataMapperRoot)theEObject;
				T result = caseDataMapperRoot(dataMapperRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.STRING_LENGTH: {
				StringLength stringLength = (StringLength)theEObject;
				T result = caseStringLength(stringLength);
				if (result == null) result = caseOperator(stringLength);
				if (result == null) result = caseDataMapperNode(stringLength);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.STARTS_WITH: {
				StartsWith startsWith = (StartsWith)theEObject;
				T result = caseStartsWith(startsWith);
				if (result == null) result = caseOperator(startsWith);
				if (result == null) result = caseDataMapperNode(startsWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ENDS_WITH: {
				EndsWith endsWith = (EndsWith)theEObject;
				T result = caseEndsWith(endsWith);
				if (result == null) result = caseOperator(endsWith);
				if (result == null) result = caseDataMapperNode(endsWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.SUBSTRING: {
				Substring substring = (Substring)theEObject;
				T result = caseSubstring(substring);
				if (result == null) result = caseOperator(substring);
				if (result == null) result = caseDataMapperNode(substring);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.IF_ELSE: {
				IfElse ifElse = (IfElse)theEObject;
				T result = caseIfElse(ifElse);
				if (result == null) result = caseOperator(ifElse);
				if (result == null) result = caseDataMapperNode(ifElse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.AND: {
				AND and = (AND)theEObject;
				T result = caseAND(and);
				if (result == null) result = caseOperator(and);
				if (result == null) result = caseDataMapperNode(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OR: {
				OR or = (OR)theEObject;
				T result = caseOR(or);
				if (result == null) result = caseOperator(or);
				if (result == null) result = caseDataMapperNode(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.INPUT: {
				Input input = (Input)theEObject;
				T result = caseInput(input);
				if (result == null) result = caseDataMapperNode(input);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.NOT: {
				NOT not = (NOT)theEObject;
				T result = caseNOT(not);
				if (result == null) result = caseOperator(not);
				if (result == null) result = caseDataMapperNode(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = caseDataMapperNode(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR: {
				Operator operator = (Operator)theEObject;
				T result = caseOperator(operator);
				if (result == null) result = caseDataMapperNode(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER: {
				OperatorBasicContainer operatorBasicContainer = (OperatorBasicContainer)theEObject;
				T result = caseOperatorBasicContainer(operatorBasicContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER: {
				OperatorLeftContainer operatorLeftContainer = (OperatorLeftContainer)theEObject;
				T result = caseOperatorLeftContainer(operatorLeftContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR_LEFT_CONNECTOR: {
				OperatorLeftConnector operatorLeftConnector = (OperatorLeftConnector)theEObject;
				T result = caseOperatorLeftConnector(operatorLeftConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER: {
				OperatorRightContainer operatorRightContainer = (OperatorRightContainer)theEObject;
				T result = caseOperatorRightContainer(operatorRightContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR: {
				OperatorRightConnector operatorRightConnector = (OperatorRightConnector)theEObject;
				T result = caseOperatorRightConnector(operatorRightConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.TREE_NODE: {
				TreeNode treeNode = (TreeNode)theEObject;
				T result = caseTreeNode(treeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.SUBTRACT: {
				Subtract subtract = (Subtract)theEObject;
				T result = caseSubtract(subtract);
				if (result == null) result = caseOperator(subtract);
				if (result == null) result = caseDataMapperNode(subtract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.IN_NODE: {
				InNode inNode = (InNode)theEObject;
				T result = caseInNode(inNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.OUT_NODE: {
				OutNode outNode = (OutNode)theEObject;
				T result = caseOutNode(outNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.DATA_MAPPER_LINK: {
				DataMapperLink dataMapperLink = (DataMapperLink)theEObject;
				T result = caseDataMapperLink(dataMapperLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CONCAT: {
				Concat concat = (Concat)theEObject;
				T result = caseConcat(concat);
				if (result == null) result = caseOperator(concat);
				if (result == null) result = caseDataMapperNode(concat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ABSOLUTE_VALUE: {
				AbsoluteValue absoluteValue = (AbsoluteValue)theEObject;
				T result = caseAbsoluteValue(absoluteValue);
				if (result == null) result = caseOperator(absoluteValue);
				if (result == null) result = caseDataMapperNode(absoluteValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.EQUAL: {
				Equal equal = (Equal)theEObject;
				T result = caseEqual(equal);
				if (result == null) result = caseOperator(equal);
				if (result == null) result = caseDataMapperNode(equal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CONSTANT: {
				Constant constant = (Constant)theEObject;
				T result = caseConstant(constant);
				if (result == null) result = caseOperator(constant);
				if (result == null) result = caseDataMapperNode(constant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ADD: {
				Add add = (Add)theEObject;
				T result = caseAdd(add);
				if (result == null) result = caseOperator(add);
				if (result == null) result = caseDataMapperNode(add);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.DIVIDE: {
				Divide divide = (Divide)theEObject;
				T result = caseDivide(divide);
				if (result == null) result = caseOperator(divide);
				if (result == null) result = caseDataMapperNode(divide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.FLOOR: {
				Floor floor = (Floor)theEObject;
				T result = caseFloor(floor);
				if (result == null) result = caseOperator(floor);
				if (result == null) result = caseDataMapperNode(floor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ROUND: {
				Round round = (Round)theEObject;
				T result = caseRound(round);
				if (result == null) result = caseOperator(round);
				if (result == null) result = caseDataMapperNode(round);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.MULTIPLY: {
				Multiply multiply = (Multiply)theEObject;
				T result = caseMultiply(multiply);
				if (result == null) result = caseOperator(multiply);
				if (result == null) result = caseDataMapperNode(multiply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.SET_PRECISION: {
				SetPrecision setPrecision = (SetPrecision)theEObject;
				T result = caseSetPrecision(setPrecision);
				if (result == null) result = caseOperator(setPrecision);
				if (result == null) result = caseDataMapperNode(setPrecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.SPLIT: {
				Split split = (Split)theEObject;
				T result = caseSplit(split);
				if (result == null) result = caseOperator(split);
				if (result == null) result = caseDataMapperNode(split);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.LOWER_CASE: {
				LowerCase lowerCase = (LowerCase)theEObject;
				T result = caseLowerCase(lowerCase);
				if (result == null) result = caseOperator(lowerCase);
				if (result == null) result = caseDataMapperNode(lowerCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CELI: {
				Celi celi = (Celi)theEObject;
				T result = caseCeli(celi);
				if (result == null) result = caseOperator(celi);
				if (result == null) result = caseDataMapperNode(celi);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.UPPER_CASE: {
				UpperCase upperCase = (UpperCase)theEObject;
				T result = caseUpperCase(upperCase);
				if (result == null) result = caseOperator(upperCase);
				if (result == null) result = caseDataMapperNode(upperCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.PROPERTY_KEY_VALUE_PAIR: {
				PropertyKeyValuePair propertyKeyValuePair = (PropertyKeyValuePair)theEObject;
				T result = casePropertyKeyValuePair(propertyKeyValuePair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.CONTAINS: {
				Contains contains = (Contains)theEObject;
				T result = caseContains(contains);
				if (result == null) result = caseOperator(contains);
				if (result == null) result = caseDataMapperNode(contains);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.TO_STRING: {
				ToString toString = (ToString)theEObject;
				T result = caseToString(toString);
				if (result == null) result = caseOperator(toString);
				if (result == null) result = caseDataMapperNode(toString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.GLOBAL_VARIABLE: {
				GlobalVariable globalVariable = (GlobalVariable)theEObject;
				T result = caseGlobalVariable(globalVariable);
				if (result == null) result = caseOperator(globalVariable);
				if (result == null) result = caseDataMapperNode(globalVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION: {
				AdvancedCustomFunction advancedCustomFunction = (AdvancedCustomFunction)theEObject;
				T result = caseAdvancedCustomFunction(advancedCustomFunction);
				if (result == null) result = caseOperator(advancedCustomFunction);
				if (result == null) result = caseDataMapperNode(advancedCustomFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperNode(DataMapperNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trim</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trim</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrim(Trim object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClone(Clone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplace(Replace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch(Match object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMin(Min object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMax(Max object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomFunction(CustomFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperties(Properties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompare(Compare object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToNumber(StringToNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToBoolean(StringToBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperRoot(DataMapperRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLength(StringLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Starts With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Starts With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartsWith(StartsWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ends With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ends With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndsWith(EndsWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstring(Substring object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfElse(IfElse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AND</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAND(AND object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOR(OR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInput(Input object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NOT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NOT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNOT(NOT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperator(Operator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Basic Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Basic Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorBasicContainer(OperatorBasicContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Left Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Left Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorLeftContainer(OperatorLeftContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Left Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Left Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorLeftConnector(OperatorLeftConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Right Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Right Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorRightContainer(OperatorRightContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Right Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Right Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorRightConnector(OperatorRightConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeNode(TreeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subtract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subtract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubtract(Subtract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInNode(InNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutNode(OutNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperLink(DataMapperLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcat(Concat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Absolute Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Absolute Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbsoluteValue(AbsoluteValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqual(Equal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstant(Constant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdd(Add object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Divide</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Divide</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivide(Divide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloor(Floor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Round</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Round</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRound(Round object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiply(Multiply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Precision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Precision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetPrecision(SetPrecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplit(Split object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerCase(LowerCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Celi</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Celi</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCeli(Celi object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upper Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upper Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpperCase(UpperCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Key Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Key Value Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyKeyValuePair(PropertyKeyValuePair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContains(Contains object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToString(ToString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalVariable(GlobalVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advanced Custom Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advanced Custom Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdvancedCustomFunction(AdvancedCustomFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DataMapperSwitch
