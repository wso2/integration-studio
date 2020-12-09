/**
 */
package org.wso2.integrationstudio.datamapper.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.integrationstudio.datamapper.AdvancedCustomFunction;
import org.wso2.integrationstudio.datamapper.DataMapperPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced Custom Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.AdvancedCustomFunctionImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.AdvancedCustomFunctionImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.datamapper.impl.AdvancedCustomFunctionImpl#isIsEndFunction <em>Is End Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdvancedCustomFunctionImpl extends OperatorImpl implements AdvancedCustomFunction {
	/**
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_NAME_EDEFAULT = "endFunction";

	/**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String functionName = FUNCTION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_DEFINITION_EDEFAULT = "function(input,output){};";

	/**
	 * The cached value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDefinition()
	 * @generated
	 * @ordered
	 */
	protected String functionDefinition = FUNCTION_DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEndFunction() <em>Is End Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEndFunction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_END_FUNCTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsEndFunction() <em>Is End Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEndFunction()
	 * @generated
	 * @ordered
	 */
	protected boolean isEndFunction = IS_END_FUNCTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedCustomFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.ADVANCED_CUSTOM_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME, oldFunctionName, functionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionDefinition() {
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDefinition(String newFunctionDefinition) {
		String oldFunctionDefinition = functionDefinition;
		functionDefinition = newFunctionDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION, oldFunctionDefinition, functionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEndFunction() {
		return isEndFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEndFunction(boolean newIsEndFunction) {
		boolean oldIsEndFunction = isEndFunction;
		isEndFunction = newIsEndFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__IS_END_FUNCTION, oldIsEndFunction, isEndFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME:
				return getFunctionName();
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				return getFunctionDefinition();
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__IS_END_FUNCTION:
				return isIsEndFunction();
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
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				setFunctionDefinition((String)newValue);
				return;
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__IS_END_FUNCTION:
				setIsEndFunction((Boolean)newValue);
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
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				setFunctionDefinition(FUNCTION_DEFINITION_EDEFAULT);
				return;
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__IS_END_FUNCTION:
				setIsEndFunction(IS_END_FUNCTION_EDEFAULT);
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
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION:
				return FUNCTION_DEFINITION_EDEFAULT == null ? functionDefinition != null : !FUNCTION_DEFINITION_EDEFAULT.equals(functionDefinition);
			case DataMapperPackage.ADVANCED_CUSTOM_FUNCTION__IS_END_FUNCTION:
				return isEndFunction != IS_END_FUNCTION_EDEFAULT;
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
		result.append(" (functionName: ");
		result.append(functionName);
		result.append(", functionDefinition: ");
		result.append(functionDefinition);
		result.append(", isEndFunction: ");
		result.append(isEndFunction);
		result.append(')');
		return result.toString();
	}

} //AdvancedCustomFunctionImpl
