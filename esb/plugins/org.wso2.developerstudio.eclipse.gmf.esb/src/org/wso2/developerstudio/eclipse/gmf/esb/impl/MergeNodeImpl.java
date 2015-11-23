/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeFirstInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNodeSecondInputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MergeNodeImpl#getFirstInputConnector <em>First Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MergeNodeImpl#getSecondInputConnector <em>Second Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MergeNodeImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergeNodeImpl extends MediatorImpl implements MergeNode {
	/**
	 * The cached value of the '{@link #getFirstInputConnector() <em>First Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstInputConnector()
	 * @generated
	 * @ordered
	 */
	protected MergeNodeFirstInputConnector firstInputConnector;

	/**
	 * The cached value of the '{@link #getSecondInputConnector() <em>Second Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondInputConnector()
	 * @generated
	 * @ordered
	 */
	protected MergeNodeSecondInputConnector secondInputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected MergeNodeOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MERGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeFirstInputConnector getFirstInputConnector() {
		return firstInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstInputConnector(MergeNodeFirstInputConnector newFirstInputConnector, NotificationChain msgs) {
		MergeNodeFirstInputConnector oldFirstInputConnector = firstInputConnector;
		firstInputConnector = newFirstInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR, oldFirstInputConnector, newFirstInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstInputConnector(MergeNodeFirstInputConnector newFirstInputConnector) {
		if (newFirstInputConnector != firstInputConnector) {
			NotificationChain msgs = null;
			if (firstInputConnector != null)
				msgs = ((InternalEObject)firstInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR, null, msgs);
			if (newFirstInputConnector != null)
				msgs = ((InternalEObject)newFirstInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetFirstInputConnector(newFirstInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR, newFirstInputConnector, newFirstInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeSecondInputConnector getSecondInputConnector() {
		return secondInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondInputConnector(MergeNodeSecondInputConnector newSecondInputConnector, NotificationChain msgs) {
		MergeNodeSecondInputConnector oldSecondInputConnector = secondInputConnector;
		secondInputConnector = newSecondInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR, oldSecondInputConnector, newSecondInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondInputConnector(MergeNodeSecondInputConnector newSecondInputConnector) {
		if (newSecondInputConnector != secondInputConnector) {
			NotificationChain msgs = null;
			if (secondInputConnector != null)
				msgs = ((InternalEObject)secondInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR, null, msgs);
			if (newSecondInputConnector != null)
				msgs = ((InternalEObject)newSecondInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetSecondInputConnector(newSecondInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR, newSecondInputConnector, newSecondInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(MergeNodeOutputConnector newOutputConnector, NotificationChain msgs) {
		MergeNodeOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(MergeNodeOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR:
				return basicSetFirstInputConnector(null, msgs);
			case EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR:
				return basicSetSecondInputConnector(null, msgs);
			case EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
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
			case EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR:
				return getFirstInputConnector();
			case EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR:
				return getSecondInputConnector();
			case EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR:
				return getOutputConnector();
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
			case EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR:
				setFirstInputConnector((MergeNodeFirstInputConnector)newValue);
				return;
			case EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR:
				setSecondInputConnector((MergeNodeSecondInputConnector)newValue);
				return;
			case EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR:
				setOutputConnector((MergeNodeOutputConnector)newValue);
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
			case EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR:
				setFirstInputConnector((MergeNodeFirstInputConnector)null);
				return;
			case EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR:
				setSecondInputConnector((MergeNodeSecondInputConnector)null);
				return;
			case EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR:
				setOutputConnector((MergeNodeOutputConnector)null);
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
			case EsbPackage.MERGE_NODE__FIRST_INPUT_CONNECTOR:
				return firstInputConnector != null;
			case EsbPackage.MERGE_NODE__SECOND_INPUT_CONNECTOR:
				return secondInputConnector != null;
			case EsbPackage.MERGE_NODE__OUTPUT_CONNECTOR:
				return outputConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //MergeNodeImpl
