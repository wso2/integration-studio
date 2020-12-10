/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.IN_TAG;
import static org.wso2.integrationstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.SchemaDataType;
import org.wso2.integrationstudio.datamapper.SetPrecision;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Precision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.SetPrecisionImpl#getNumberOfDigits <em>Number Of Digits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetPrecisionImpl extends OperatorImpl implements SetPrecision {
	/**
	 * The default value of the '{@link #getNumberOfDigits() <em>Number Of Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfDigits()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_OF_DIGITS_EDEFAULT = "{$NoOfDigits}";
	/**
	 * The cached value of the '{@link #getNumberOfDigits() <em>Number Of Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfDigits()
	 * @generated
	 * @ordered
	 */
	protected String numberOfDigits = NUMBER_OF_DIGITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SetPrecisionImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		setOperatorType(DataMapperOperatorType.SET_PRECISION);
		getInputLabelList().add(IN_TAG);
		getInputLabelList().add("Num of Decimals");
		getOutputLabelList().add(RESULT_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.SET_PRECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberOfDigits() {
		return numberOfDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfDigits(String newNumberOfDigits) {
		String oldNumberOfDigits = numberOfDigits;
		numberOfDigits = newNumberOfDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SET_PRECISION__NUMBER_OF_DIGITS, oldNumberOfDigits, numberOfDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.SET_PRECISION__NUMBER_OF_DIGITS:
				return getNumberOfDigits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataMapperPackage.SET_PRECISION__NUMBER_OF_DIGITS:
				setNumberOfDigits((String)newValue);
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
			case DataMapperPackage.SET_PRECISION__NUMBER_OF_DIGITS:
				setNumberOfDigits(NUMBER_OF_DIGITS_EDEFAULT);
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
			case DataMapperPackage.SET_PRECISION__NUMBER_OF_DIGITS:
				return NUMBER_OF_DIGITS_EDEFAULT == null ? numberOfDigits != null : !NUMBER_OF_DIGITS_EDEFAULT.equals(numberOfDigits);
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
		result.append(" (numberOfDigits: ");
		result.append(numberOfDigits);
		result.append(')');
		return result.toString();
	}

} //SetPrecisionImpl
