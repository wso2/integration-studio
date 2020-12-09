/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.IN_TAG;
import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;

import java.util.ArrayList;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.wso2.integrationstudio.datamapper.CustomFunction;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.CustomFunctionImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.CustomFunctionImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.CustomFunctionImpl#getOutputConnectorTag <em>Output Connector Tag</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.CustomFunctionImpl#getInputConnectorTag <em>Input Connector Tag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomFunctionImpl extends OperatorImpl implements CustomFunction {
	/**
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_NAME_EDEFAULT = "customFunction";
	/**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String functionName = FUNCTION_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_DEFINITION_EDEFAULT = "function(in1,in2){ return (in1 + in2);};";
	/**
	 * The cached value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDefinition()
	 * @generated
	 * @ordered
	 */
	protected String functionDefinition = FUNCTION_DEFINITION_EDEFAULT;
	/**
	 * The default value of the '{@link #getOutputConnectorTag() <em>Output Connector Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnectorTag()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_CONNECTOR_TAG_EDEFAULT = "Result";
	/**
	 * The cached value of the '{@link #getOutputConnectorTag() <em>Output Connector Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnectorTag()
	 * @generated
	 * @ordered
	 */
	protected String outputConnectorTag = OUTPUT_CONNECTOR_TAG_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInputConnectorTag() <em>Input Connector Tag</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnectorTag()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inputConnectorTag;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CustomFunctionImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getInputVariableTypes().get(0).add(SchemaDataType.STRING);
		getInputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.STRING);
		setOperatorType(DataMapperOperatorType.CUSTOM_FUNCTION);
		getInputLabelList().add(IN_TAG);
		getOutputLabelList().add(RESULT_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.CUSTOM_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_NAME, oldFunctionName, functionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionDefinition() {
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDefinition(String newFunctionDefinition) {
		String oldFunctionDefinition = functionDefinition;
		functionDefinition = newFunctionDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_DEFINITION, oldFunctionDefinition, functionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputConnectorTag() {
		return outputConnectorTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnectorTag(String newOutputConnectorTag) {
		String oldOutputConnectorTag = outputConnectorTag;
		outputConnectorTag = newOutputConnectorTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.CUSTOM_FUNCTION__OUTPUT_CONNECTOR_TAG, oldOutputConnectorTag, outputConnectorTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInputConnectorTag() {
		if (inputConnectorTag == null) {
			inputConnectorTag = new EDataTypeUniqueEList<String>(String.class, this, DataMapperPackage.CUSTOM_FUNCTION__INPUT_CONNECTOR_TAG);
		}
		return inputConnectorTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_NAME:
				return getFunctionName();
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				return getFunctionDefinition();
			case DataMapperPackage.CUSTOM_FUNCTION__OUTPUT_CONNECTOR_TAG:
				return getOutputConnectorTag();
			case DataMapperPackage.CUSTOM_FUNCTION__INPUT_CONNECTOR_TAG:
				return getInputConnectorTag();
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
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				setFunctionDefinition((String)newValue);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__OUTPUT_CONNECTOR_TAG:
				setOutputConnectorTag((String)newValue);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__INPUT_CONNECTOR_TAG:
				getInputConnectorTag().clear();
				getInputConnectorTag().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				setFunctionDefinition(FUNCTION_DEFINITION_EDEFAULT);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__OUTPUT_CONNECTOR_TAG:
				setOutputConnectorTag(OUTPUT_CONNECTOR_TAG_EDEFAULT);
				return;
			case DataMapperPackage.CUSTOM_FUNCTION__INPUT_CONNECTOR_TAG:
				getInputConnectorTag().clear();
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
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case DataMapperPackage.CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				return FUNCTION_DEFINITION_EDEFAULT == null ? functionDefinition != null : !FUNCTION_DEFINITION_EDEFAULT.equals(functionDefinition);
			case DataMapperPackage.CUSTOM_FUNCTION__OUTPUT_CONNECTOR_TAG:
				return OUTPUT_CONNECTOR_TAG_EDEFAULT == null ? outputConnectorTag != null : !OUTPUT_CONNECTOR_TAG_EDEFAULT.equals(outputConnectorTag);
			case DataMapperPackage.CUSTOM_FUNCTION__INPUT_CONNECTOR_TAG:
				return inputConnectorTag != null && !inputConnectorTag.isEmpty();
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
		result.append(" (functionName: ");
		result.append(functionName);
		result.append(", functionDefinition: ");
		result.append(functionDefinition);
		result.append(", outputConnectorTag: ");
		result.append(outputConnectorTag);
		result.append(", InputConnectorTag: ");
		result.append(inputConnectorTag);
		result.append(')');
		return result.toString();
	}

} //CustomFunctionImpl
