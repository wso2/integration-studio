/**
 */
package org.wso2.developerstudio.datamapper.impl;

import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.IN_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.PATTERN_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Max;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Max</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MaxImpl extends OperatorImpl implements Max {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MaxImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(false);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		setOperatorType(DataMapperOperatorType.MAX);
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
		return DataMapperPackage.Literals.MAX;
	}

} //MaxImpl
