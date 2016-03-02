/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorBasicContainer;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Basic Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl#getLeftContainer <em>Left Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorBasicContainerImpl#getRightContainer <em>Right Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorBasicContainerImpl extends EObjectImpl implements OperatorBasicContainer {
	/**
	 * The cached value of the '{@link #getLeftContainer() <em>Left Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftContainer()
	 * @generated
	 * @ordered
	 */
	protected OperatorLeftContainer leftContainer;

	/**
	 * The cached value of the '{@link #getRightContainer() <em>Right Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightContainer()
	 * @generated
	 * @ordered
	 */
	protected OperatorRightContainer rightContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorBasicContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR_BASIC_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorLeftContainer getLeftContainer() {
		return leftContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftContainer(OperatorLeftContainer newLeftContainer, NotificationChain msgs) {
		OperatorLeftContainer oldLeftContainer = leftContainer;
		leftContainer = newLeftContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER, oldLeftContainer, newLeftContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftContainer(OperatorLeftContainer newLeftContainer) {
		if (newLeftContainer != leftContainer) {
			NotificationChain msgs = null;
			if (leftContainer != null)
				msgs = ((InternalEObject)leftContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER, null, msgs);
			if (newLeftContainer != null)
				msgs = ((InternalEObject)newLeftContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER, null, msgs);
			msgs = basicSetLeftContainer(newLeftContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER, newLeftContainer, newLeftContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorRightContainer getRightContainer() {
		return rightContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightContainer(OperatorRightContainer newRightContainer, NotificationChain msgs) {
		OperatorRightContainer oldRightContainer = rightContainer;
		rightContainer = newRightContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER, oldRightContainer, newRightContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightContainer(OperatorRightContainer newRightContainer) {
		if (newRightContainer != rightContainer) {
			NotificationChain msgs = null;
			if (rightContainer != null)
				msgs = ((InternalEObject)rightContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER, null, msgs);
			if (newRightContainer != null)
				msgs = ((InternalEObject)newRightContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER, null, msgs);
			msgs = basicSetRightContainer(newRightContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER, newRightContainer, newRightContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER:
				return basicSetLeftContainer(null, msgs);
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER:
				return basicSetRightContainer(null, msgs);
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
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER:
				return getLeftContainer();
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER:
				return getRightContainer();
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
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER:
				setLeftContainer((OperatorLeftContainer)newValue);
				return;
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER:
				setRightContainer((OperatorRightContainer)newValue);
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
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER:
				setLeftContainer((OperatorLeftContainer)null);
				return;
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER:
				setRightContainer((OperatorRightContainer)null);
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
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__LEFT_CONTAINER:
				return leftContainer != null;
			case DataMapperPackage.OPERATOR_BASIC_CONTAINER__RIGHT_CONTAINER:
				return rightContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //OperatorBasicContainerImpl
