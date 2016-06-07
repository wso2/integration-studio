/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.ecore.EClass;
import org.wso2.developerstudio.datamapper.Celi;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Celi</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CeliImpl extends OperatorImpl implements Celi {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CeliImpl() {
		super();
		setDefaultInputConnectors(1);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableType().add(SchemaDataType.DOUBLE);
		getInputVariableType().add(SchemaDataType.INT);
		getOutputVariableType().add(SchemaDataType.INT);
		getOutputVariableType().add(SchemaDataType.DOUBLE);
		setOperatorType(DataMapperOperatorType.CEILING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.CELI;
	}

} //CeliImpl
