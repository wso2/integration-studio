/**
 */
package org.wso2.developerstudio.datamapper.util;

import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage
 * @generated
 */
public class DataMapperAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataMapperPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataMapperPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMapperSwitch<Adapter> modelSwitch =
		new DataMapperSwitch<Adapter>() {
			@Override
			public Adapter caseDataMapperNode(DataMapperNode object) {
				return createDataMapperNodeAdapter();
			}
			@Override
			public Adapter caseTrim(Trim object) {
				return createTrimAdapter();
			}
			@Override
			public Adapter caseClone(Clone object) {
				return createCloneAdapter();
			}
			@Override
			public Adapter caseReplace(Replace object) {
				return createReplaceAdapter();
			}
			@Override
			public Adapter caseMatch(Match object) {
				return createMatchAdapter();
			}
			@Override
			public Adapter caseMin(Min object) {
				return createMinAdapter();
			}
			@Override
			public Adapter caseMax(Max object) {
				return createMaxAdapter();
			}
			@Override
			public Adapter caseCustomFunction(CustomFunction object) {
				return createCustomFunctionAdapter();
			}
			@Override
			public Adapter caseProperties(Properties object) {
				return createPropertiesAdapter();
			}
			@Override
			public Adapter caseCompare(Compare object) {
				return createCompareAdapter();
			}
			@Override
			public Adapter caseStringToNumber(StringToNumber object) {
				return createStringToNumberAdapter();
			}
			@Override
			public Adapter caseStringToBoolean(StringToBoolean object) {
				return createStringToBooleanAdapter();
			}
			@Override
			public Adapter caseDataMapperRoot(DataMapperRoot object) {
				return createDataMapperRootAdapter();
			}
			@Override
			public Adapter caseStringLength(StringLength object) {
				return createStringLengthAdapter();
			}
			@Override
			public Adapter caseStartsWith(StartsWith object) {
				return createStartsWithAdapter();
			}
			@Override
			public Adapter caseEndsWith(EndsWith object) {
				return createEndsWithAdapter();
			}
			@Override
			public Adapter caseSubstring(Substring object) {
				return createSubstringAdapter();
			}
			@Override
			public Adapter caseIfElse(IfElse object) {
				return createIfElseAdapter();
			}
			@Override
			public Adapter caseAND(AND object) {
				return createANDAdapter();
			}
			@Override
			public Adapter caseOR(OR object) {
				return createORAdapter();
			}
			@Override
			public Adapter caseInput(Input object) {
				return createInputAdapter();
			}
			@Override
			public Adapter caseNOT(NOT object) {
				return createNOTAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseOperatorBasicContainer(OperatorBasicContainer object) {
				return createOperatorBasicContainerAdapter();
			}
			@Override
			public Adapter caseOperatorLeftContainer(OperatorLeftContainer object) {
				return createOperatorLeftContainerAdapter();
			}
			@Override
			public Adapter caseOperatorLeftConnector(OperatorLeftConnector object) {
				return createOperatorLeftConnectorAdapter();
			}
			@Override
			public Adapter caseOperatorRightContainer(OperatorRightContainer object) {
				return createOperatorRightContainerAdapter();
			}
			@Override
			public Adapter caseOperatorRightConnector(OperatorRightConnector object) {
				return createOperatorRightConnectorAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseTreeNode(TreeNode object) {
				return createTreeNodeAdapter();
			}
			@Override
			public Adapter caseSubtract(Subtract object) {
				return createSubtractAdapter();
			}
			@Override
			public Adapter caseInNode(InNode object) {
				return createInNodeAdapter();
			}
			@Override
			public Adapter caseOutNode(OutNode object) {
				return createOutNodeAdapter();
			}
			@Override
			public Adapter caseDataMapperLink(DataMapperLink object) {
				return createDataMapperLinkAdapter();
			}
			@Override
			public Adapter caseConcat(Concat object) {
				return createConcatAdapter();
			}
			@Override
			public Adapter caseAbsoluteValue(AbsoluteValue object) {
				return createAbsoluteValueAdapter();
			}
			@Override
			public Adapter caseEqual(Equal object) {
				return createEqualAdapter();
			}
			@Override
			public Adapter caseConstant(Constant object) {
				return createConstantAdapter();
			}
			@Override
			public Adapter caseAdd(Add object) {
				return createAddAdapter();
			}
			@Override
			public Adapter caseDivide(Divide object) {
				return createDivideAdapter();
			}
			@Override
			public Adapter caseFloor(Floor object) {
				return createFloorAdapter();
			}
			@Override
			public Adapter caseRound(Round object) {
				return createRoundAdapter();
			}
			@Override
			public Adapter caseMultiply(Multiply object) {
				return createMultiplyAdapter();
			}
			@Override
			public Adapter caseSetPrecision(SetPrecision object) {
				return createSetPrecisionAdapter();
			}
			@Override
			public Adapter caseSplit(Split object) {
				return createSplitAdapter();
			}
			@Override
			public Adapter caseLowerCase(LowerCase object) {
				return createLowerCaseAdapter();
			}
			@Override
			public Adapter caseCeli(Celi object) {
				return createCeliAdapter();
			}
			@Override
			public Adapter caseUpperCase(UpperCase object) {
				return createUpperCaseAdapter();
			}
			@Override
			public Adapter casePropertyKeyValuePair(PropertyKeyValuePair object) {
				return createPropertyKeyValuePairAdapter();
			}
			@Override
			public Adapter caseContains(Contains object) {
				return createContainsAdapter();
			}
			@Override
			public Adapter caseToString(ToString object) {
				return createToStringAdapter();
			}
			@Override
			public Adapter caseGlobalVariable(GlobalVariable object) {
				return createGlobalVariableAdapter();
			}
			@Override
			public Adapter caseAdvancedCustomFunction(AdvancedCustomFunction object) {
				return createAdvancedCustomFunctionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.DataMapperNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.DataMapperNode
	 * @generated
	 */
	public Adapter createDataMapperNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Trim <em>Trim</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Trim
	 * @generated
	 */
	public Adapter createTrimAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Clone <em>Clone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Clone
	 * @generated
	 */
	public Adapter createCloneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Replace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Replace
	 * @generated
	 */
	public Adapter createReplaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Match
	 * @generated
	 */
	public Adapter createMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Min <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Min
	 * @generated
	 */
	public Adapter createMinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Max <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Max
	 * @generated
	 */
	public Adapter createMaxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.CustomFunction <em>Custom Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.CustomFunction
	 * @generated
	 */
	public Adapter createCustomFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Properties
	 * @generated
	 */
	public Adapter createPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Compare <em>Compare</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Compare
	 * @generated
	 */
	public Adapter createCompareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.StringToNumber <em>String To Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.StringToNumber
	 * @generated
	 */
	public Adapter createStringToNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.StringToBoolean <em>String To Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.StringToBoolean
	 * @generated
	 */
	public Adapter createStringToBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.DataMapperRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.DataMapperRoot
	 * @generated
	 */
	public Adapter createDataMapperRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.StringLength <em>String Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.StringLength
	 * @generated
	 */
	public Adapter createStringLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.StartsWith <em>Starts With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.StartsWith
	 * @generated
	 */
	public Adapter createStartsWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.EndsWith <em>Ends With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.EndsWith
	 * @generated
	 */
	public Adapter createEndsWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Substring <em>Substring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Substring
	 * @generated
	 */
	public Adapter createSubstringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.IfElse <em>If Else</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.IfElse
	 * @generated
	 */
	public Adapter createIfElseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.AND
	 * @generated
	 */
	public Adapter createANDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OR
	 * @generated
	 */
	public Adapter createORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Input
	 * @generated
	 */
	public Adapter createInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.NOT <em>NOT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.NOT
	 * @generated
	 */
	public Adapter createNOTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OperatorBasicContainer <em>Operator Basic Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OperatorBasicContainer
	 * @generated
	 */
	public Adapter createOperatorBasicContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OperatorLeftContainer <em>Operator Left Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftContainer
	 * @generated
	 */
	public Adapter createOperatorLeftContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OperatorLeftConnector <em>Operator Left Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OperatorLeftConnector
	 * @generated
	 */
	public Adapter createOperatorLeftConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OperatorRightContainer <em>Operator Right Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightContainer
	 * @generated
	 */
	public Adapter createOperatorRightContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OperatorRightConnector <em>Operator Right Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OperatorRightConnector
	 * @generated
	 */
	public Adapter createOperatorRightConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.TreeNode
	 * @generated
	 */
	public Adapter createTreeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Subtract <em>Subtract</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Subtract
	 * @generated
	 */
	public Adapter createSubtractAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.InNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.InNode
	 * @generated
	 */
	public Adapter createInNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.OutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.OutNode
	 * @generated
	 */
	public Adapter createOutNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.DataMapperLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink
	 * @generated
	 */
	public Adapter createDataMapperLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Concat <em>Concat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Concat
	 * @generated
	 */
	public Adapter createConcatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.AbsoluteValue <em>Absolute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.AbsoluteValue
	 * @generated
	 */
	public Adapter createAbsoluteValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Equal
	 * @generated
	 */
	public Adapter createEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Constant
	 * @generated
	 */
	public Adapter createConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Add
	 * @generated
	 */
	public Adapter createAddAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Divide <em>Divide</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Divide
	 * @generated
	 */
	public Adapter createDivideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Floor
	 * @generated
	 */
	public Adapter createFloorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Round <em>Round</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Round
	 * @generated
	 */
	public Adapter createRoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Multiply <em>Multiply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Multiply
	 * @generated
	 */
	public Adapter createMultiplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.SetPrecision <em>Set Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.SetPrecision
	 * @generated
	 */
	public Adapter createSetPrecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Split <em>Split</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Split
	 * @generated
	 */
	public Adapter createSplitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.LowerCase <em>Lower Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.LowerCase
	 * @generated
	 */
	public Adapter createLowerCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Celi <em>Celi</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Celi
	 * @generated
	 */
	public Adapter createCeliAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.UpperCase <em>Upper Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.UpperCase
	 * @generated
	 */
	public Adapter createUpperCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair <em>Property Key Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.PropertyKeyValuePair
	 * @generated
	 */
	public Adapter createPropertyKeyValuePairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Contains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Contains
	 * @generated
	 */
	public Adapter createContainsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.ToString <em>To String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.ToString
	 * @generated
	 */
	public Adapter createToStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.GlobalVariable <em>Global Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.GlobalVariable
	 * @generated
	 */
	public Adapter createGlobalVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.AdvancedCustomFunction <em>Advanced Custom Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.AdvancedCustomFunction
	 * @generated
	 */
	public Adapter createAdvancedCustomFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DataMapperAdapterFactory
