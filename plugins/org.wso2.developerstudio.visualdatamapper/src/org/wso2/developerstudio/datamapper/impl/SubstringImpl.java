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
import org.wso2.developerstudio.datamapper.Substring;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substring</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SubstringImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SubstringImpl#getEndIndex <em>End Index</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SubstringImpl#isGetPatternFromInput <em>Get Pattern From Input</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubstringImpl extends OperatorImpl implements Substring {
	/**
	 * The default value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected static final String START_INDEX_EDEFAULT = "{$StartIndex}";
	/**
	 * The cached value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected String startIndex = START_INDEX_EDEFAULT;
	/**
	 * The default value of the '{@link #getEndIndex() <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndIndex()
	 * @generated
	 * @ordered
	 */
	protected static final String END_INDEX_EDEFAULT = "{$Length}";
	/**
	 * The cached value of the '{@link #getEndIndex() <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndIndex()
	 * @generated
	 * @ordered
	 */
	protected String endIndex = END_INDEX_EDEFAULT;
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
	protected SubstringImpl() {
		super();
		setDefaultInputConnectors(3);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().put(1, new ArrayList<SchemaDataType>());
		getInputVariableTypes().put(2, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getInputVariableTypes().get(1).add(SchemaDataType.STRING);
		getInputVariableTypes().get(2).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.STRING);
		setOperatorType(DataMapperOperatorType.SUBSTRING);
		getInputLabelList().add(VALUE_TAG);
		getInputLabelList().add(DataMapperImplConstants.START_INDEX);
		getInputLabelList().add(DataMapperImplConstants.LENGTH_TAG);
		getOutputLabelList().add(RESULT_TAG);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.SUBSTRING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartIndex() {
		return startIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(String newStartIndex) {
		String oldStartIndex = startIndex;
		startIndex = newStartIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SUBSTRING__START_INDEX, oldStartIndex, startIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndIndex() {
		return endIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndIndex(String newEndIndex) {
		String oldEndIndex = endIndex;
		endIndex = newEndIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SUBSTRING__END_INDEX, oldEndIndex, endIndex));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SUBSTRING__GET_PATTERN_FROM_INPUT, oldGetPatternFromInput, getPatternFromInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.SUBSTRING__START_INDEX:
				return getStartIndex();
			case DataMapperPackage.SUBSTRING__END_INDEX:
				return getEndIndex();
			case DataMapperPackage.SUBSTRING__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.SUBSTRING__START_INDEX:
				setStartIndex((String)newValue);
				return;
			case DataMapperPackage.SUBSTRING__END_INDEX:
				setEndIndex((String)newValue);
				return;
			case DataMapperPackage.SUBSTRING__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.SUBSTRING__START_INDEX:
				setStartIndex(START_INDEX_EDEFAULT);
				return;
			case DataMapperPackage.SUBSTRING__END_INDEX:
				setEndIndex(END_INDEX_EDEFAULT);
				return;
			case DataMapperPackage.SUBSTRING__GET_PATTERN_FROM_INPUT:
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
			case DataMapperPackage.SUBSTRING__START_INDEX:
				return START_INDEX_EDEFAULT == null ? startIndex != null : !START_INDEX_EDEFAULT.equals(startIndex);
			case DataMapperPackage.SUBSTRING__END_INDEX:
				return END_INDEX_EDEFAULT == null ? endIndex != null : !END_INDEX_EDEFAULT.equals(endIndex);
			case DataMapperPackage.SUBSTRING__GET_PATTERN_FROM_INPUT:
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
		result.append(" (startIndex: ");
		result.append(startIndex);
		result.append(", endIndex: ");
		result.append(endIndex);
		result.append(", getPatternFromInput: ");
		result.append(getPatternFromInput);
		result.append(')');
		return result.toString();
	}

} //SubstringImpl
