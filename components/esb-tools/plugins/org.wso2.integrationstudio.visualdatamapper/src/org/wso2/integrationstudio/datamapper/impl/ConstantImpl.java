/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.integrationstudio.datamapper.Constant;
import org.wso2.integrationstudio.datamapper.DataMapperOperatorType;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;
import org.wso2.integrationstudio.datamapper.SchemaDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.ConstantImpl#getConstantValue <em>Constant Value</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.ConstantImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstantImpl extends OperatorImpl implements Constant {
	/**
	 * The default value of the '{@link #getConstantValue() <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantValue()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTANT_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getConstantValue() <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantValue()
	 * @generated
	 * @ordered
	 */
	protected String constantValue = CONSTANT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SchemaDataType TYPE_EDEFAULT = SchemaDataType.STRING;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SchemaDataType type = TYPE_EDEFAULT;
	private String constValue = "";
	
	private String constType = "";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConstantImpl() {
		super();
		setDefaultInputConnectors(0);
		setDefaultOutputConnectors(1);
		setInputSizeFixed(true);
		setOutputSizeFixed(true);
		getInputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().put(0, new ArrayList<SchemaDataType>());
		getOutputVariableTypes().get(0).add(SchemaDataType.NUMBER);
		getOutputVariableTypes().get(0).add(SchemaDataType.STRING);
		getOutputVariableTypes().get(0).add(SchemaDataType.BOOLEAN);
		setOperatorType(DataMapperOperatorType.CONSTANT);
		getOutputLabelList().add("Const");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.CONSTANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstantValue() {
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantValue(String newConstantValue) {
		String oldConstantValue = constantValue;
		constantValue = newConstantValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.CONSTANT__CONSTANT_VALUE, oldConstantValue, constantValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaDataType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SchemaDataType newType) {
		SchemaDataType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.CONSTANT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.CONSTANT__CONSTANT_VALUE:
				return getConstantValue();
			case DataMapperPackage.CONSTANT__TYPE:
				return getType();
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
			case DataMapperPackage.CONSTANT__CONSTANT_VALUE:
				setConstantValue((String)newValue);
				return;
			case DataMapperPackage.CONSTANT__TYPE:
				setType((SchemaDataType)newValue);
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
			case DataMapperPackage.CONSTANT__CONSTANT_VALUE:
				setConstantValue(CONSTANT_VALUE_EDEFAULT);
				return;
			case DataMapperPackage.CONSTANT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DataMapperPackage.CONSTANT__CONSTANT_VALUE:
				return CONSTANT_VALUE_EDEFAULT == null ? constantValue != null : !CONSTANT_VALUE_EDEFAULT.equals(constantValue);
			case DataMapperPackage.CONSTANT__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (constantValue: ");
		result.append(constantValue);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

    public String getConstValue() {
        return constValue;
    }

    public void setConstValue(String constValue) {
        this.constValue = constValue;
    }

    public String getConstType() {
        return constType;
    }

    public void setConstType(String constType) {
        this.constType = constType;
    }

} //ConstantImpl
