/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Left Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorLeftContainerImpl#getLeftConnectors <em>Left Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorLeftContainerImpl extends EObjectImpl implements OperatorLeftContainer {
	/**
	 * The cached value of the '{@link #getLeftConnectors() <em>Left Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<OperatorLeftConnector> leftConnectors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorLeftContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperatorLeftConnector> getLeftConnectors() {
		if (leftConnectors == null) {
			leftConnectors = new EObjectContainmentEList<OperatorLeftConnector>(OperatorLeftConnector.class, this, DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS);
		}
		return leftConnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS:
				return ((InternalEList<?>)getLeftConnectors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS:
				return getLeftConnectors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS:
				getLeftConnectors().clear();
				getLeftConnectors().addAll((Collection<? extends OperatorLeftConnector>)newValue);
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
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS:
				getLeftConnectors().clear();
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
			case DataMapperPackage.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS:
				return leftConnectors != null && !leftConnectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperatorLeftContainerImpl
