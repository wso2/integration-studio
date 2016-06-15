/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.common.notify.Notification;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.PATTERN_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.VALUE_TAG;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.IfElse;
import org.wso2.developerstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.IfElseImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.IfElseImpl#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfElseImpl extends OperatorImpl implements IfElse {
	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = "true";
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;
	/**
	 * The default value of the '{@link #isGetPatternFromInput() <em>Get Pattern From Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGetPatternFromInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GET_PATTERN_FROM_INPUT_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isGetPatternFromInput() <em>Get Pattern From Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGetPatternFromInput()
	 * @generated
	 * @ordered
	 */
	protected boolean getPatternFromInput = GET_PATTERN_FROM_INPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected IfElseImpl() {
		super();
		setDefaultInputConnectors(3);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		// If else input connector already built when trying assign type
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getInputVariableTypes().put(1, new ArrayList<SchemaDataType>());
		getInputVariableTypes().put(2, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(1).add(SchemaDataType.BOOLEAN);
		getInputVariableTypes().get(2).add(SchemaDataType.STRING);
		getInputVariableTypes().get(2).add(SchemaDataType.NUMBER);
		getInputVariableTypes().get(2).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.STRING);
		setOperatorType(DataMapperOperatorType.IF_ELSE);
		getInputLabelList().add(DataMapperImplConstants.CONDITION_TAG);
		getInputLabelList().add(DataMapperImplConstants.THEN_TAG);
		getInputLabelList().add(DataMapperImplConstants.ELSE_TAG);
		getOutputLabelList().add(DataMapperImplConstants.OUT_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.IF_ELSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.IF_ELSE__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGetPatternFromInput() {
		return getPatternFromInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGetPatternFromInput(boolean newGetPatternFromInput) {
		boolean oldGetPatternFromInput = getPatternFromInput;
		getPatternFromInput = newGetPatternFromInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.IF_ELSE__GET_PATTERN_FROM_INPUT, oldGetPatternFromInput, getPatternFromInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.IF_ELSE__CONDITION:
				return getCondition();
			case DataMapperPackage.IF_ELSE__GET_PATTERN_FROM_INPUT:
				return isGetPatternFromInput();
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
			case DataMapperPackage.IF_ELSE__CONDITION:
				setCondition((String)newValue);
				return;
			case DataMapperPackage.IF_ELSE__GET_PATTERN_FROM_INPUT:
				setGetPatternFromInput((Boolean)newValue);
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
			case DataMapperPackage.IF_ELSE__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case DataMapperPackage.IF_ELSE__GET_PATTERN_FROM_INPUT:
				setGetPatternFromInput(GET_PATTERN_FROM_INPUT_EDEFAULT);
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
			case DataMapperPackage.IF_ELSE__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
			case DataMapperPackage.IF_ELSE__GET_PATTERN_FROM_INPUT:
				return getPatternFromInput != GET_PATTERN_FROM_INPUT_EDEFAULT;
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
		result.append(" (condition: ");
		result.append(condition);
		result.append(", getPatternFromInput: ");
		result.append(getPatternFromInput);
		result.append(')');
		return result.toString();
	}

} //IfElseImpl
