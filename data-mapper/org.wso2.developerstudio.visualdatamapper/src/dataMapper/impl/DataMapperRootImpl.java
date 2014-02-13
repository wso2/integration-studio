/**
 */
package dataMapper.impl;

import dataMapper.DataMapperDiagram;
import dataMapper.DataMapperPackage;
import dataMapper.DataMapperRoot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.DataMapperRootImpl#getDataMapperDiagram <em>Data Mapper Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperRootImpl extends EObjectImpl implements DataMapperRoot {
	/**
	 * The cached value of the '{@link #getDataMapperDiagram() <em>Data Mapper Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataMapperDiagram()
	 * @generated
	 * @ordered
	 */
	protected DataMapperDiagram dataMapperDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMapperRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.DATA_MAPPER_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperDiagram getDataMapperDiagram() {
		return dataMapperDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataMapperDiagram(DataMapperDiagram newDataMapperDiagram, NotificationChain msgs) {
		DataMapperDiagram oldDataMapperDiagram = dataMapperDiagram;
		dataMapperDiagram = newDataMapperDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM, oldDataMapperDiagram, newDataMapperDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataMapperDiagram(DataMapperDiagram newDataMapperDiagram) {
		if (newDataMapperDiagram != dataMapperDiagram) {
			NotificationChain msgs = null;
			if (dataMapperDiagram != null)
				msgs = ((InternalEObject)dataMapperDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM, null, msgs);
			if (newDataMapperDiagram != null)
				msgs = ((InternalEObject)newDataMapperDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM, null, msgs);
			msgs = basicSetDataMapperDiagram(newDataMapperDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM, newDataMapperDiagram, newDataMapperDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM:
				return basicSetDataMapperDiagram(null, msgs);
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
			case DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM:
				return getDataMapperDiagram();
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
			case DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM:
				setDataMapperDiagram((DataMapperDiagram)newValue);
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
			case DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM:
				setDataMapperDiagram((DataMapperDiagram)null);
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
			case DataMapperPackage.DATA_MAPPER_ROOT__DATA_MAPPER_DIAGRAM:
				return dataMapperDiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //DataMapperRootImpl
