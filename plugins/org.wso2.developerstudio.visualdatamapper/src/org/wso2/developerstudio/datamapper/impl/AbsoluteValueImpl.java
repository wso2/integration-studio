/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.AbsoluteValue;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Absolute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AbsoluteValueImpl extends OperatorImpl implements AbsoluteValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AbsoluteValueImpl() {
		super();
		setDefaultInputConnectors(1);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableType().add(SchemaDataType.DOUBLE);
		getInputVariableType().add(SchemaDataType.INT);
		getOutputVariableType().add(SchemaDataType.INT);
		setOperatorType(DataMapperOperatorType.ABSOLUTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.ABSOLUTE_VALUE;
	}

} //AbsoluteValueImpl
