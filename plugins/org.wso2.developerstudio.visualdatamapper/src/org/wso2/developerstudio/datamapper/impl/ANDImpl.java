/**
 */
package org.wso2.developerstudio.datamapper.impl;

import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.IN_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;

import org.wso2.developerstudio.datamapper.AND;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AND</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ANDImpl extends OperatorImpl implements AND {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ANDImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(false);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		setOperatorType(DataMapperOperatorType.AND);
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
		return DataMapperPackage.Literals.AND;
	}

} //ANDImpl
