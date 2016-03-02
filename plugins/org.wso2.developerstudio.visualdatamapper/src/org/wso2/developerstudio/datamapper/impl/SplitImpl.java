/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Split;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SplitImpl#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SplitImpl#getArrayOutput <em>Array Output</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.SplitImpl#getArrayOutputResultOmitingIndices <em>Array Output Result Omiting Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitImpl extends OperatorImpl implements Split {
	/**
	 * The default value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected static final String DELIMITER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDelimiter() <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelimiter()
	 * @generated
	 * @ordered
	 */
	protected String delimiter = DELIMITER_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrayOutput() <em>Array Output</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArrayOutput()
	 * @generated
	 * @ordered
	 */
    protected static final int ARRAY_OUTPUT_EDEFAULT = -1;
    /**
	 * The cached value of the '{@link #getArrayOutput() <em>Array Output</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getArrayOutput()
	 * @generated
	 * @ordered
	 */
    protected int arrayOutput = ARRAY_OUTPUT_EDEFAULT;

    /**
	 * The default value of the '{@link #getArrayOutputResultOmitingIndices() <em>Array Output Result Omiting Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayOutputResultOmitingIndices()
	 * @generated
	 * @ordered
	 */
	protected static final String ARRAY_OUTPUT_RESULT_OMITING_INDICES_EDEFAULT = null;
				/**
	 * The cached value of the '{@link #getArrayOutputResultOmitingIndices() <em>Array Output Result Omiting Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayOutputResultOmitingIndices()
	 * @generated
	 * @ordered
	 */
	protected String arrayOutputResultOmitingIndices = ARRAY_OUTPUT_RESULT_OMITING_INDICES_EDEFAULT;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SplitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.SPLIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelimiter(String newDelimiter) {
		String oldDelimiter = delimiter;
		delimiter = newDelimiter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SPLIT__DELIMITER, oldDelimiter, delimiter));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getArrayOutput() {
		return arrayOutput;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setArrayOutput(int newArrayOutput) {
		int oldArrayOutput = arrayOutput;
		arrayOutput = newArrayOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SPLIT__ARRAY_OUTPUT, oldArrayOutput, arrayOutput));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArrayOutputResultOmitingIndices() {
		return arrayOutputResultOmitingIndices;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayOutputResultOmitingIndices(String newArrayOutputResultOmitingIndices) {
		String oldArrayOutputResultOmitingIndices = arrayOutputResultOmitingIndices;
		arrayOutputResultOmitingIndices = newArrayOutputResultOmitingIndices;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES, oldArrayOutputResultOmitingIndices, arrayOutputResultOmitingIndices));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.SPLIT__DELIMITER:
				return getDelimiter();
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT:
				return getArrayOutput();
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES:
				return getArrayOutputResultOmitingIndices();
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
			case DataMapperPackage.SPLIT__DELIMITER:
				setDelimiter((String)newValue);
				return;
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT:
				setArrayOutput((Integer)newValue);
				return;
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES:
				setArrayOutputResultOmitingIndices((String)newValue);
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
			case DataMapperPackage.SPLIT__DELIMITER:
				setDelimiter(DELIMITER_EDEFAULT);
				return;
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT:
				setArrayOutput(ARRAY_OUTPUT_EDEFAULT);
				return;
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES:
				setArrayOutputResultOmitingIndices(ARRAY_OUTPUT_RESULT_OMITING_INDICES_EDEFAULT);
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
			case DataMapperPackage.SPLIT__DELIMITER:
				return DELIMITER_EDEFAULT == null ? delimiter != null : !DELIMITER_EDEFAULT.equals(delimiter);
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT:
				return arrayOutput != ARRAY_OUTPUT_EDEFAULT;
			case DataMapperPackage.SPLIT__ARRAY_OUTPUT_RESULT_OMITING_INDICES:
				return ARRAY_OUTPUT_RESULT_OMITING_INDICES_EDEFAULT == null ? arrayOutputResultOmitingIndices != null : !ARRAY_OUTPUT_RESULT_OMITING_INDICES_EDEFAULT.equals(arrayOutputResultOmitingIndices);
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
		result.append(" (delimiter: ");
		result.append(delimiter);
		result.append(", arrayOutput: ");
		result.append(arrayOutput);
		result.append(", arrayOutputResultOmitingIndices: ");
		result.append(arrayOutputResultOmitingIndices);
		result.append(')');
		return result.toString();
	}

} //SplitImpl
