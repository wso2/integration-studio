/**
 */
package dataMapper.impl;

import dataMapper.DataMapperLink;
import dataMapper.DataMapperPackage;
import dataMapper.OutNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Out Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.OutNodeImpl#getOutgoingLink <em>Outgoing Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutNodeImpl extends EObjectImpl implements OutNode {
	/**
	 * The cached value of the '{@link #getOutgoingLink() <em>Outgoing Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLink()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapperLink> outgoingLink;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OUT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapperLink> getOutgoingLink() {
		if (outgoingLink == null) {
			outgoingLink = new EObjectContainmentWithInverseEList<DataMapperLink>(DataMapperLink.class, this, DataMapperPackage.OUT_NODE__OUTGOING_LINK, DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE);
		}
		return outgoingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLink()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return ((InternalEList<?>)getOutgoingLink()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return getOutgoingLink();
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				getOutgoingLink().clear();
				getOutgoingLink().addAll((Collection<? extends DataMapperLink>)newValue);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				getOutgoingLink().clear();
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return outgoingLink != null && !outgoingLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OutNodeImpl
