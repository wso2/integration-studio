/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorBasicContainer;
import org.wso2.developerstudio.datamapper.OutNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorImpl#getBasicContainer <em>Basic Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorImpl extends DataMapperNodeImpl implements Operator {
	/**
	 * The cached value of the '{@link #getBasicContainer() <em>Basic Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicContainer()
	 * @generated
	 * @ordered
	 */
	protected OperatorBasicContainer basicContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorBasicContainer getBasicContainer() {
		return basicContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicContainer(OperatorBasicContainer newBasicContainer, NotificationChain msgs) {
		OperatorBasicContainer oldBasicContainer = basicContainer;
		basicContainer = newBasicContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__BASIC_CONTAINER, oldBasicContainer, newBasicContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicContainer(OperatorBasicContainer newBasicContainer) {
		if (newBasicContainer != basicContainer) {
			NotificationChain msgs = null;
			if (basicContainer != null)
				msgs = ((InternalEObject)basicContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR__BASIC_CONTAINER, null, msgs);
			if (newBasicContainer != null)
				msgs = ((InternalEObject)newBasicContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR__BASIC_CONTAINER, null, msgs);
			msgs = basicSetBasicContainer(newBasicContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR__BASIC_CONTAINER, newBasicContainer, newBasicContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return basicSetBasicContainer(null, msgs);
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
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return getBasicContainer();
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
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				setBasicContainer((OperatorBasicContainer)newValue);
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
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				setBasicContainer((OperatorBasicContainer)null);
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
			case DataMapperPackage.OPERATOR__BASIC_CONTAINER:
				return basicContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //OperatorImpl
