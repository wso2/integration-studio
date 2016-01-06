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
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Right Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorRightContainerImpl#getRightConnectors <em>Right Connectors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorRightContainerImpl extends EObjectImpl implements OperatorRightContainer {
	/**
	 * The cached value of the '{@link #getRightConnectors() <em>Right Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<OperatorRightConnector> rightConnectors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorRightContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR_RIGHT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperatorRightConnector> getRightConnectors() {
		if (rightConnectors == null) {
			rightConnectors = new EObjectContainmentEList<OperatorRightConnector>(OperatorRightConnector.class, this, DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS);
		}
		return rightConnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS:
				return ((InternalEList<?>)getRightConnectors()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS:
				return getRightConnectors();
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
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS:
				getRightConnectors().clear();
				getRightConnectors().addAll((Collection<? extends OperatorRightConnector>)newValue);
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
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS:
				getRightConnectors().clear();
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
			case DataMapperPackage.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS:
				return rightConnectors != null && !rightConnectors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperatorRightContainerImpl
