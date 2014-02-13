/**
 */
package dataMapper.impl;

import dataMapper.Concat;
import dataMapper.DataMapperPackage;
import dataMapper.InNode;
import dataMapper.OutNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.ConcatImpl#getInNode <em>In Node</em>}</li>
 *   <li>{@link dataMapper.impl.ConcatImpl#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcatImpl extends EObjectImpl implements Concat {
	/**
	 * The cached value of the '{@link #getInNode() <em>In Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInNode()
	 * @generated
	 * @ordered
	 */
	protected EList<InNode> inNode;

	/**
	 * The cached value of the '{@link #getOutNode() <em>Out Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutNode()
	 * @generated
	 * @ordered
	 */
	protected EList<OutNode> outNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.CONCAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InNode> getInNode() {
		if (inNode == null) {
			inNode = new EObjectContainmentEList<InNode>(InNode.class, this, DataMapperPackage.CONCAT__IN_NODE);
		}
		return inNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutNode> getOutNode() {
		if (outNode == null) {
			outNode = new EObjectContainmentEList<OutNode>(OutNode.class, this, DataMapperPackage.CONCAT__OUT_NODE);
		}
		return outNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.CONCAT__IN_NODE:
				return ((InternalEList<?>)getInNode()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.CONCAT__OUT_NODE:
				return ((InternalEList<?>)getOutNode()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.CONCAT__IN_NODE:
				return getInNode();
			case DataMapperPackage.CONCAT__OUT_NODE:
				return getOutNode();
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
			case DataMapperPackage.CONCAT__IN_NODE:
				getInNode().clear();
				getInNode().addAll((Collection<? extends InNode>)newValue);
				return;
			case DataMapperPackage.CONCAT__OUT_NODE:
				getOutNode().clear();
				getOutNode().addAll((Collection<? extends OutNode>)newValue);
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
			case DataMapperPackage.CONCAT__IN_NODE:
				getInNode().clear();
				return;
			case DataMapperPackage.CONCAT__OUT_NODE:
				getOutNode().clear();
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
			case DataMapperPackage.CONCAT__IN_NODE:
				return inNode != null && !inNode.isEmpty();
			case DataMapperPackage.CONCAT__OUT_NODE:
				return outNode != null && !outNode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcatImpl
