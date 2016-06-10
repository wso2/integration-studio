/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Multiply;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiply</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MultiplyImpl extends OperatorImpl implements Multiply {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MultiplyImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(false);
		setOutputSizeFixed(true);
		getInputVariableType().add(SchemaDataType.NUMBER);
		getOutputVariableType().add(SchemaDataType.NUMBER);
		setOperatorType(DataMapperOperatorType.MULTIPLY);
		getInputLabelList().add("In");
		getOutputLabelList().add("Result");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.MULTIPLY;
	}

} //MultiplyImpl
