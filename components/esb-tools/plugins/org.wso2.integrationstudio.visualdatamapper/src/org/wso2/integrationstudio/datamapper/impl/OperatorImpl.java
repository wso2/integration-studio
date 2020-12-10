/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.Operator;
import org.wso2.integrationstudio.datamapper.OperatorBasicContainer;
import org.wso2.integrationstudio.datamapper.OperatorLeftConnector;
import org.wso2.integrationstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#getBasicContainer <em>Basic Container</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#isSerialized <em>Serialized</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#getDefaultInputConnectors <em>Default Input Connectors</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#getDefaultOutputConnectors <em>Default Output Connectors</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#isInputSizeFixed <em>Input Size Fixed</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#isOutputSizeFixed <em>Output Size Fixed</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.OperatorImpl#getOperatorType <em>Operator Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatorImpl extends DataMapperNodeImpl implements Operator {
	
	/**
	 * This list holds the label text for input connector
	 */
	protected List<String> inputLabelList;
	
	/**
	 * This list holds the label text for output connector
	 */
	protected List<String> outputLabelList;
	
	/**
	 * Number of left connectors in the operator
	 */
	protected int leftConnectorCount;
	
	/**
	 * Number of right connectors in the operator
	 */
	protected int rightConnectorCount;
	
	/**
	 * The cached value of the '{@link #getBasicContainer() <em>Basic Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicContainer()
	 * @generated
	 * @ordered
	 */
	protected OperatorBasicContainer basicContainer;

	/**
	 * The default value of the '{@link #isSerialized() <em>Serialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SERIALIZED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSerialized() <em>Serialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerialized()
	 * @generated
	 * @ordered
	 */
	protected boolean serialized = SERIALIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultInputConnectors() <em>Default Input Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInputConnectors()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_INPUT_CONNECTORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultInputConnectors() <em>Default Input Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInputConnectors()
	 * @generated
	 * @ordered
	 */
	protected int defaultInputConnectors = DEFAULT_INPUT_CONNECTORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultOutputConnectors() <em>Default Output Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultOutputConnectors()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_OUTPUT_CONNECTORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultOutputConnectors() <em>Default Output Connectors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultOutputConnectors()
	 * @generated
	 * @ordered
	 */
	protected int defaultOutputConnectors = DEFAULT_OUTPUT_CONNECTORS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputVariableTypes() <em>Input Variable Type</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariableTypes()
	 * @generated NOT
	 * @ordered
	 */
	protected Map<Integer,List<SchemaDataType>> inputVariableTypes;

	/**
	 * The cached value of the '{@link #getOutputVariableTypes() <em>Output Variable Type</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableTypes()
	 * @generated NOT
	 * @ordered
	 */
	protected Map<Integer,List<SchemaDataType>> outputVariableTypes;

	/**
	 * The default value of the '{@link #isInputSizeFixed() <em>Input Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputSizeFixed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INPUT_SIZE_FIXED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInputSizeFixed() <em>Input Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputSizeFixed()
	 * @generated
	 * @ordered
	 */
	protected boolean inputSizeFixed = INPUT_SIZE_FIXED_EDEFAULT;

	/**
	 * The default value of the '{@link #isOutputSizeFixed() <em>Output Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutputSizeFixed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUTPUT_SIZE_FIXED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOutputSizeFixed() <em>Output Size Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOutputSizeFixed()
	 * @generated
	 * @ordered
	 */
	protected boolean outputSizeFixed = OUTPUT_SIZE_FIXED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected static final DataMapperOperatorType OPERATOR_TYPE_EDEFAULT = DataMapperOperatorType.OPERATOR;

	/**
	 * The cached value of the '{@link #getOperatorType() <em>Operator Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatorType()
	 * @generated
	 * @ordered
	 */
	protected DataMapperOperatorType operatorType = OPERATOR_TYPE_EDEFAULT;

	/**
	*<!-- begin-user-doc -->
	* <!-- end-user-doc -->
	* @generated NOT
	*/
     
	private int index=-1;

	/**
     * This node has been visited by the graph traversal algorithm
     */
    private boolean visited;
    
    /**
     * This node has been added to the list of nodes in the graph traversal algorithm
     */
    private boolean marked;
    
    private List<Integer> portVariableIndex=new ArrayList<Integer>();
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public List<Integer> getPortVariableIndex() {
        return portVariableIndex;
    }

    public void setPortVariableIndex(List<Integer> portVariableIndex) {
        this.portVariableIndex = portVariableIndex;
    }
    
	protected OperatorImpl() {
		super();
	}
	
	public int getLeftConnectorCount() {
		return leftConnectorCount;
	}

	public void setLeftConnectorCount(int leftConnectorCount) {
		this.leftConnectorCount = leftConnectorCount;
	}

	public int getRightConnectorCount() {
		return rightConnectorCount;
	}

	public void setRightConnectorCount(int rightConnectorCount) {
		this.rightConnectorCount = rightConnectorCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorBasicContainer getBasicContainer() {
		return basicContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicContainer(OperatorBasicContainer newBasicContainer, NotificationChain msgs) {
		OperatorBasicContainer oldBasicContainer = basicContainer;
		basicContainer = newBasicContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__BASIC_CONTAINER, oldBasicContainer, newBasicContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicContainer(OperatorBasicContainer newBasicContainer) {
		if (newBasicContainer != basicContainer) {
			NotificationChain msgs = null;
			if (basicContainer != null)
				msgs = ((InternalEObject)basicContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR__BASIC_CONTAINER, null, msgs);
			if (newBasicContainer != null)
				msgs = ((InternalEObject)newBasicContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR__BASIC_CONTAINER, null, msgs);
			msgs = basicSetBasicContainer(newBasicContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__BASIC_CONTAINER, newBasicContainer, newBasicContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSerialized() {
		return serialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialized(boolean newSerialized) {
		boolean oldSerialized = serialized;
		serialized = newSerialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__SERIALIZED, oldSerialized, serialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultInputConnectors() {
		return defaultInputConnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultInputConnectors(int newDefaultInputConnectors) {
		int oldDefaultInputConnectors = defaultInputConnectors;
		defaultInputConnectors = newDefaultInputConnectors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__DEFAULT_INPUT_CONNECTORS, oldDefaultInputConnectors, defaultInputConnectors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultOutputConnectors() {
		return defaultOutputConnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultOutputConnectors(int newDefaultOutputConnectors) {
		int oldDefaultOutputConnectors = defaultOutputConnectors;
		defaultOutputConnectors = newDefaultOutputConnectors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__DEFAULT_OUTPUT_CONNECTORS, oldDefaultOutputConnectors, defaultOutputConnectors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<Integer, List<SchemaDataType>> getInputVariableTypes() {
		if (inputVariableTypes == null) {
			inputVariableTypes = new HashMap<>();
		}
		return inputVariableTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<Integer, List<SchemaDataType>> getOutputVariableTypes() {
		if (outputVariableTypes == null) {
			outputVariableTypes = new HashMap<>();
		}
		return outputVariableTypes;
	}
	
	public List<String> getInputLabelList() {
		if (inputLabelList == null) {
			inputLabelList = new ArrayList<>();
		}
		return inputLabelList;
	}

	public List<String> getOutputLabelList() {
		if (outputLabelList == null) {
			outputLabelList = new ArrayList<>();
		}
		return outputLabelList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInputSizeFixed() {
		return inputSizeFixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSizeFixed(boolean newInputSizeFixed) {
		boolean oldInputSizeFixed = inputSizeFixed;
		inputSizeFixed = newInputSizeFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__INPUT_SIZE_FIXED, oldInputSizeFixed, inputSizeFixed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOutputSizeFixed() {
		return outputSizeFixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputSizeFixed(boolean newOutputSizeFixed) {
		boolean oldOutputSizeFixed = outputSizeFixed;
		outputSizeFixed = newOutputSizeFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__OUTPUT_SIZE_FIXED, oldOutputSizeFixed, outputSizeFixed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperOperatorType getOperatorType() {
		return operatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatorType(DataMapperOperatorType newOperatorType) {
		DataMapperOperatorType oldOperatorType = operatorType;
		operatorType = newOperatorType == null ? OPERATOR_TYPE_EDEFAULT : newOperatorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__OPERATOR_TYPE, oldOperatorType, operatorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return basicSetBasicContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return getBasicContainer();
			case DataMapperPackage.OPERATOR__SERIALIZED:
				return isSerialized();
			case DataMapperPackage.OPERATOR__DEFAULT_INPUT_CONNECTORS:
				return getDefaultInputConnectors();
			case DataMapperPackage.OPERATOR__DEFAULT_OUTPUT_CONNECTORS:
				return getDefaultOutputConnectors();
			case DataMapperPackage.OPERATOR__INPUT_SIZE_FIXED:
				return isInputSizeFixed();
			case DataMapperPackage.OPERATOR__OUTPUT_SIZE_FIXED:
				return isOutputSizeFixed();
			case DataMapperPackage.OPERATOR__OPERATOR_TYPE:
				return getOperatorType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				setBasicContainer((OperatorBasicContainer)newValue);
				return;
			case DataMapperPackage.OPERATOR__SERIALIZED:
				setSerialized((Boolean)newValue);
				return;
			case DataMapperPackage.OPERATOR__DEFAULT_INPUT_CONNECTORS:
				setDefaultInputConnectors((Integer)newValue);
				return;
			case DataMapperPackage.OPERATOR__DEFAULT_OUTPUT_CONNECTORS:
				setDefaultOutputConnectors((Integer)newValue);
				return;
			case DataMapperPackage.OPERATOR__INPUT_SIZE_FIXED:
				setInputSizeFixed((Boolean)newValue);
				return;
			case DataMapperPackage.OPERATOR__OUTPUT_SIZE_FIXED:
				setOutputSizeFixed((Boolean)newValue);
				return;
			case DataMapperPackage.OPERATOR__OPERATOR_TYPE:
				setOperatorType((DataMapperOperatorType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> 
	 * [IMPORTANT] - Here we are setting generated NOT.
	 * Which means this method will not get modified with code generation even
	 * you do some changes in ecore model to "Operator". Remove 'NOT' if you
	 * want to do changes for "Operator" in the ecore. 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				//Fixing DEVTOOLESB-312
				EList<OperatorLeftConnector> leftConnectors = getBasicContainer().getLeftContainer().getLeftConnectors();
				for(OperatorLeftConnector  connector : leftConnectors){
					connector.getInNode().getIncomingLink().clear();		
				}
				setBasicContainer((OperatorBasicContainer)null);
				return;
			case DataMapperPackage.OPERATOR__SERIALIZED:
				setSerialized(SERIALIZED_EDEFAULT);
				return;
			case DataMapperPackage.OPERATOR__DEFAULT_INPUT_CONNECTORS:
				setDefaultInputConnectors(DEFAULT_INPUT_CONNECTORS_EDEFAULT);
				return;
			case DataMapperPackage.OPERATOR__DEFAULT_OUTPUT_CONNECTORS:
				setDefaultOutputConnectors(DEFAULT_OUTPUT_CONNECTORS_EDEFAULT);
				return;
			case DataMapperPackage.OPERATOR__INPUT_SIZE_FIXED:
				setInputSizeFixed(INPUT_SIZE_FIXED_EDEFAULT);
				return;
			case DataMapperPackage.OPERATOR__OUTPUT_SIZE_FIXED:
				setOutputSizeFixed(OUTPUT_SIZE_FIXED_EDEFAULT);
				return;
			case DataMapperPackage.OPERATOR__OPERATOR_TYPE:
				setOperatorType(OPERATOR_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return basicContainer != null;
			case DataMapperPackage.OPERATOR__SERIALIZED:
				return serialized != SERIALIZED_EDEFAULT;
			case DataMapperPackage.OPERATOR__DEFAULT_INPUT_CONNECTORS:
				return defaultInputConnectors != DEFAULT_INPUT_CONNECTORS_EDEFAULT;
			case DataMapperPackage.OPERATOR__DEFAULT_OUTPUT_CONNECTORS:
				return defaultOutputConnectors != DEFAULT_OUTPUT_CONNECTORS_EDEFAULT;
			case DataMapperPackage.OPERATOR__INPUT_SIZE_FIXED:
				return inputSizeFixed != INPUT_SIZE_FIXED_EDEFAULT;
			case DataMapperPackage.OPERATOR__OUTPUT_SIZE_FIXED:
				return outputSizeFixed != OUTPUT_SIZE_FIXED_EDEFAULT;
			case DataMapperPackage.OPERATOR__OPERATOR_TYPE:
				return operatorType != OPERATOR_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serialized: ");
		result.append(serialized);
		result.append(", defaultInputConnectors: ");
		result.append(defaultInputConnectors);
		result.append(", defaultOutputConnectors: ");
		result.append(defaultOutputConnectors);
		result.append(", inputSizeFixed: ");
		result.append(inputSizeFixed);
		result.append(", outputSizeFixed: ");
		result.append(outputSizeFixed);
		result.append(", operatorType: ");
		result.append(operatorType);
		result.append(')');
		return result.toString();
	}

} //OperatorImpl
