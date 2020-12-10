/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.Subtract;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subtract</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SubtractImpl extends OperatorImpl implements Subtract {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SubtractImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		setOperatorType(DataMapperOperatorType.SUBTRACT);
		getInputLabelList().add("Number");
		getInputLabelList().add("Subtrahend");
		getOutputLabelList().add("Result");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.SUBTRACT;
	}

} //SubtractImpl
