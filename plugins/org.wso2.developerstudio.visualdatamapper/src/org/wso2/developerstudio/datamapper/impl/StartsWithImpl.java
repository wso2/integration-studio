/**
 */
package org.wso2.developerstudio.datamapper.impl;

import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.PATTERN_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.RESULT_TAG;
import static org.wso2.developerstudio.datamapper.impl.DataMapperImplConstants.VALUE_TAG;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.datamapper.DataMapperOperatorType;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.StartsWith;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Starts With</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.StartsWithImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.StartsWithImpl#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartsWithImpl extends OperatorImpl implements StartsWith {
	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = "{$Pattern}";
	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;
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
	protected StartsWithImpl() {
		super();
		setDefaultInputConnectors(2);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(0).add(SchemaDataType.STRING);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		setOperatorType(DataMapperOperatorType.STARTS_WITH);
		getInputLabelList().add(VALUE_TAG);
		getInputLabelList().add(PATTERN_TAG);
		getOutputLabelList().add(RESULT_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.STARTS_WITH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.STARTS_WITH__PATTERN, oldPattern, pattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.STARTS_WITH__GET_PATTERN_FROM_INPUT, oldGetPatternFromInput, getPatternFromInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.STARTS_WITH__PATTERN:
				return getPattern();
			case DataMapperPackage.STARTS_WITH__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.STARTS_WITH__PATTERN:
				setPattern((String)newValue);
				return;
			case DataMapperPackage.STARTS_WITH__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.STARTS_WITH__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case DataMapperPackage.STARTS_WITH__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.STARTS_WITH__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case DataMapperPackage.STARTS_WITH__GET_PATTERN_FROM_INPUT:
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
		result.append(" (pattern: ");
		result.append(pattern);
		result.append(", getPatternFromInput: ");
		result.append(getPatternFromInput);
		result.append(')');
		return result.toString();
	}

} //StartsWithImpl
