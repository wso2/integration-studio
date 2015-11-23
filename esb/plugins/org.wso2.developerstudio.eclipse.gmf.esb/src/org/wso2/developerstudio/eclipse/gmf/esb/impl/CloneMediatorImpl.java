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

import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clone Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getCloneID <em>Clone ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getTargetsOutputConnector <em>Targets Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorImpl#getCloneContainer <em>Clone Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloneMediatorImpl extends MediatorImpl implements CloneMediator {
	/**
	 * The default value of the '{@link #getCloneID() <em>Clone ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloneID()
	 * @generated
	 * @ordered
	 */
	protected static final String CLONE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCloneID() <em>Clone ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloneID()
	 * @generated
	 * @ordered
	 */
	protected String cloneID = CLONE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isSequentialMediation() <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequentialMediation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEQUENTIAL_MEDIATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSequentialMediation() <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequentialMediation()
	 * @generated
	 * @ordered
	 */
	protected boolean sequentialMediation = SEQUENTIAL_MEDIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isContinueParent() <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueParent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTINUE_PARENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContinueParent() <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContinueParent()
	 * @generated
	 * @ordered
	 */
	protected boolean continueParent = CONTINUE_PARENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<CloneTarget> targets;

	/**
	 * The cached value of the '{@link #getTargetsOutputConnector() <em>Targets Output Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetsOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<CloneMediatorTargetOutputConnector> targetsOutputConnector;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CloneMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CloneMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getCloneContainer() <em>Clone Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloneContainer()
	 * @generated
	 * @ordered
	 */
	protected CloneMediatorContainer cloneContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloneMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CLONE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCloneID() {
		return cloneID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloneID(String newCloneID) {
		String oldCloneID = cloneID;
		cloneID = newCloneID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__CLONE_ID, oldCloneID, cloneID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequentialMediation() {
		return sequentialMediation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequentialMediation(boolean newSequentialMediation) {
		boolean oldSequentialMediation = sequentialMediation;
		sequentialMediation = newSequentialMediation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION, oldSequentialMediation, sequentialMediation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContinueParent() {
		return continueParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinueParent(boolean newContinueParent) {
		boolean oldContinueParent = continueParent;
		continueParent = newContinueParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__CONTINUE_PARENT, oldContinueParent, continueParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloneTarget> getTargets() {
		if (targets == null) {
			targets = new EObjectContainmentEList<CloneTarget>(CloneTarget.class, this, EsbPackage.CLONE_MEDIATOR__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloneMediatorTargetOutputConnector> getTargetsOutputConnector() {
		if (targetsOutputConnector == null) {
			targetsOutputConnector = new EObjectContainmentEList<CloneMediatorTargetOutputConnector>(CloneMediatorTargetOutputConnector.class, this, EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR);
		}
		return targetsOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CloneMediatorInputConnector newInputConnector, NotificationChain msgs) {
		CloneMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CloneMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CloneMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		CloneMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CloneMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorContainer getCloneContainer() {
		return cloneContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCloneContainer(CloneMediatorContainer newCloneContainer, NotificationChain msgs) {
		CloneMediatorContainer oldCloneContainer = cloneContainer;
		cloneContainer = newCloneContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER, oldCloneContainer, newCloneContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloneContainer(CloneMediatorContainer newCloneContainer) {
		if (newCloneContainer != cloneContainer) {
			NotificationChain msgs = null;
			if (cloneContainer != null)
				msgs = ((InternalEObject)cloneContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER, null, msgs);
			if (newCloneContainer != null)
				msgs = ((InternalEObject)newCloneContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER, null, msgs);
			msgs = basicSetCloneContainer(newCloneContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER, newCloneContainer, newCloneContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CLONE_MEDIATOR__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
			case EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR:
				return ((InternalEList<?>)getTargetsOutputConnector()).basicRemove(otherEnd, msgs);
			case EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER:
				return basicSetCloneContainer(null, msgs);
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
			case EsbPackage.CLONE_MEDIATOR__CLONE_ID:
				return getCloneID();
			case EsbPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return isSequentialMediation();
			case EsbPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				return isContinueParent();
			case EsbPackage.CLONE_MEDIATOR__TARGETS:
				return getTargets();
			case EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR:
				return getTargetsOutputConnector();
			case EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER:
				return getCloneContainer();
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
			case EsbPackage.CLONE_MEDIATOR__CLONE_ID:
				setCloneID((String)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation((Boolean)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent((Boolean)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends CloneTarget>)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR:
				getTargetsOutputConnector().clear();
				getTargetsOutputConnector().addAll((Collection<? extends CloneMediatorTargetOutputConnector>)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CloneMediatorInputConnector)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CloneMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER:
				setCloneContainer((CloneMediatorContainer)newValue);
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
			case EsbPackage.CLONE_MEDIATOR__CLONE_ID:
				setCloneID(CLONE_ID_EDEFAULT);
				return;
			case EsbPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation(SEQUENTIAL_MEDIATION_EDEFAULT);
				return;
			case EsbPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent(CONTINUE_PARENT_EDEFAULT);
				return;
			case EsbPackage.CLONE_MEDIATOR__TARGETS:
				getTargets().clear();
				return;
			case EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR:
				getTargetsOutputConnector().clear();
				return;
			case EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CloneMediatorInputConnector)null);
				return;
			case EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CloneMediatorOutputConnector)null);
				return;
			case EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER:
				setCloneContainer((CloneMediatorContainer)null);
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
			case EsbPackage.CLONE_MEDIATOR__CLONE_ID:
				return CLONE_ID_EDEFAULT == null ? cloneID != null : !CLONE_ID_EDEFAULT.equals(cloneID);
			case EsbPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return sequentialMediation != SEQUENTIAL_MEDIATION_EDEFAULT;
			case EsbPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				return continueParent != CONTINUE_PARENT_EDEFAULT;
			case EsbPackage.CLONE_MEDIATOR__TARGETS:
				return targets != null && !targets.isEmpty();
			case EsbPackage.CLONE_MEDIATOR__TARGETS_OUTPUT_CONNECTOR:
				return targetsOutputConnector != null && !targetsOutputConnector.isEmpty();
			case EsbPackage.CLONE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CLONE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CLONE_MEDIATOR__CLONE_CONTAINER:
				return cloneContainer != null;
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
		result.append(" (cloneID: ");
		result.append(cloneID);
		result.append(", sequentialMediation: ");
		result.append(sequentialMediation);
		result.append(", continueParent: ");
		result.append(continueParent);
		result.append(')');
		return result.toString();
	}

} //CloneMediatorImpl
