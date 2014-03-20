/**
 */
package dataMapper.impl;

import dataMapper.DataMapperPackage;
import dataMapper.InNode;
import dataMapper.Operation;
import dataMapper.OutNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.OperationImpl#getInNodes <em>In Nodes</em>}</li>
 *   <li>{@link dataMapper.impl.OperationImpl#getOutNodes <em>Out Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends DataMapperNodeImpl implements Operation {
	/**
	 * The cached value of the '{@link #getInNodes() <em>In Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<InNode> inNodes;

	/**
	 * The cached value of the '{@link #getOutNodes() <em>Out Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<OutNode> outNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InNode> getInNodes() {
		if (inNodes == null) {
			inNodes = new EObjectContainmentEList<InNode>(InNode.class, this, DataMapperPackage.OPERATION__IN_NODES);
		}
		return inNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutNode> getOutNodes() {
		if (outNodes == null) {
			outNodes = new EObjectContainmentEList<OutNode>(OutNode.class, this, DataMapperPackage.OPERATION__OUT_NODES);
		}
		return outNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATION__IN_NODES:
				return ((InternalEList<?>)getInNodes()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.OPERATION__OUT_NODES:
				return ((InternalEList<?>)getOutNodes()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.OPERATION__IN_NODES:
				return getInNodes();
			case DataMapperPackage.OPERATION__OUT_NODES:
				return getOutNodes();
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
			case DataMapperPackage.OPERATION__IN_NODES:
				getInNodes().clear();
				getInNodes().addAll((Collection<? extends InNode>)newValue);
				return;
			case DataMapperPackage.OPERATION__OUT_NODES:
				getOutNodes().clear();
				getOutNodes().addAll((Collection<? extends OutNode>)newValue);
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
			case DataMapperPackage.OPERATION__IN_NODES:
				getInNodes().clear();
				return;
			case DataMapperPackage.OPERATION__OUT_NODES:
				getOutNodes().clear();
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
			case DataMapperPackage.OPERATION__IN_NODES:
				return inNodes != null && !inNodes.isEmpty();
			case DataMapperPackage.OPERATION__OUT_NODES:
				return outNodes != null && !outNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl
