/**
 */
package org.wso2.developerstudio.datamapper.util;

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
			public Adapter caseDataMapperDiagram(DataMapperDiagram object) {
				return createDataMapperDiagramAdapter();
			}
			@Override
			public Adapter caseDataMapperRoot(DataMapperRoot object) {
				return createDataMapperRootAdapter();
			}
			@Override
			public Adapter caseInput(Input object) {
				return createInputAdapter();
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
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseTreeNode(TreeNode object) {
				return createTreeNodeAdapter();
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
			public Adapter caseEqual(Equal object) {
				return createEqualAdapter();
			}
			@Override
			public Adapter caseConstant(Constant object) {
				return createConstantAdapter();
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
			public Adapter caseContains(Contains object) {
				return createContainsAdapter();
			}
			@Override
			public Adapter caseUpperCase(UpperCase object) {
				return createUpperCaseAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.DataMapperDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.DataMapperDiagram
	 * @generated
	 */
	public Adapter createDataMapperDiagramAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.datamapper.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.datamapper.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
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
