/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbServerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbServerImpl#getMessageMediator <em>Message Mediator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbServerImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EsbServerImpl extends EsbNodeImpl implements EsbServer {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<EsbElement> children;

	/**
	 * The cached value of the '{@link #getMessageMediator() <em>Message Mediator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageMediator()
	 * @generated
	 * @ordered
	 */
	protected MessageMediator messageMediator;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ArtifactType TYPE_EDEFAULT = ArtifactType.SYNAPSE_CONFIG;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ArtifactType type = TYPE_EDEFAULT;
	
	
	/**
	 * The cached status of the lock attribute.
	 */
	private boolean lockmode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EsbServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ESB_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EsbElement> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<EsbElement>(EsbElement.class, this, EsbPackage.ESB_SERVER__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageMediator getMessageMediator() {
		return messageMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessageMediator(MessageMediator newMessageMediator, NotificationChain msgs) {
		MessageMediator oldMessageMediator = messageMediator;
		messageMediator = newMessageMediator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR, oldMessageMediator, newMessageMediator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageMediator(MessageMediator newMessageMediator) {
		if (newMessageMediator != messageMediator) {
			NotificationChain msgs = null;
			if (messageMediator != null)
				msgs = ((InternalEObject)messageMediator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR, null, msgs);
			if (newMessageMediator != null)
				msgs = ((InternalEObject)newMessageMediator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR, null, msgs);
			msgs = basicSetMessageMediator(newMessageMediator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR, newMessageMediator, newMessageMediator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ArtifactType newType) {
		ArtifactType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ESB_SERVER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ESB_SERVER__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
				return basicSetMessageMediator(null, msgs);
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
			case EsbPackage.ESB_SERVER__CHILDREN:
				return getChildren();
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
				return getMessageMediator();
			case EsbPackage.ESB_SERVER__TYPE:
				return getType();
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
			case EsbPackage.ESB_SERVER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends EsbElement>)newValue);
				return;
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
				setMessageMediator((MessageMediator)newValue);
				return;
			case EsbPackage.ESB_SERVER__TYPE:
				setType((ArtifactType)newValue);
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
			case EsbPackage.ESB_SERVER__CHILDREN:
				getChildren().clear();
				return;
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
				setMessageMediator((MessageMediator)null);
				return;
			case EsbPackage.ESB_SERVER__TYPE:
				setType(TYPE_EDEFAULT);
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
			case EsbPackage.ESB_SERVER__CHILDREN:
				return children != null && !children.isEmpty();
			case EsbPackage.ESB_SERVER__MESSAGE_MEDIATOR:
				return messageMediator != null;
			case EsbPackage.ESB_SERVER__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	/**
	 * Sets the status of the lock attribute.
	 */
	public void setLockmode(boolean lockmode) {
		this.lockmode = lockmode;
	}

	/**
	 * Returns the status of the lock attribute.
	 */
	public boolean isLockmode() {
		return lockmode;
	}

} //EsbServerImpl
