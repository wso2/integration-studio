/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.IN_TAG;
import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.NOT;
import org.wso2.integrationstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NOT</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NOTImpl extends OperatorImpl implements NOT {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected NOTImpl() {
		super();
		setDefaultInputConnectors(1);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		setOperatorType(DataMapperOperatorType.NOT);
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
		return DataMapperPackage.Literals.NOT;
	}

} //NOTImpl
