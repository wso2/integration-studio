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
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OutNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Right Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OperatorRightConnectorImpl#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorRightConnectorImpl extends EObjectImpl implements OperatorRightConnector {
	/**
	 * The cached value of the '{@link #getOutNode() <em>Out Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutNode()
	 * @generated
	 * @ordered
	 */
	protected OutNode outNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorRightConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OPERATOR_RIGHT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutNode getOutNode() {
		return outNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutNode(OutNode newOutNode, NotificationChain msgs) {
		OutNode oldOutNode = outNode;
		outNode = newOutNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE, oldOutNode, newOutNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutNode(OutNode newOutNode) {
		if (newOutNode != outNode) {
			NotificationChain msgs = null;
			if (outNode != null)
				msgs = ((InternalEObject)outNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE, null, msgs);
			if (newOutNode != null)
				msgs = ((InternalEObject)newOutNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE, null, msgs);
			msgs = basicSetOutNode(newOutNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE, newOutNode, newOutNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE:
				return basicSetOutNode(null, msgs);
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
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE:
				return getOutNode();
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
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE:
				setOutNode((OutNode)newValue);
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
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE:
				setOutNode((OutNode)null);
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
			case DataMapperPackage.OPERATOR_RIGHT_CONNECTOR__OUT_NODE:
				return outNode != null;
		}
		return super.eIsSet(featureID);
	}

} //OperatorRightConnectorImpl
