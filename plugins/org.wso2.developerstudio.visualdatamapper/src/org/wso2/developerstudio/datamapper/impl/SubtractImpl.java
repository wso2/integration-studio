/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.Subtract;

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
		getInputVariableType().add(SchemaDataType.INT);
		getInputVariableType().add(SchemaDataType.DOUBLE);
		getOutputVariableType().add(SchemaDataType.INT);
		getOutputVariableType().add(SchemaDataType.DOUBLE);
		setOperatorType(DataMapperOperatorType.SUBTRACT);
		getInputLabelList().add("In");
		getOutputLabelList().add("Out");
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
