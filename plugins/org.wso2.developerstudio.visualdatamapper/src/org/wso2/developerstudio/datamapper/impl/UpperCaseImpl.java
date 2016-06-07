/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.UpperCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Upper Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class UpperCaseImpl extends OperatorImpl implements UpperCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected UpperCaseImpl() {
		super();
		setDefaultInputConnectors(1);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableType().add(SchemaDataType.STRING);
		getOutputVariableType().add(SchemaDataType.STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.UPPER_CASE;
	}

} //UpperCaseImpl
