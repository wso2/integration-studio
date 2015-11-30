/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.proxy.ScopeProxy;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compensate Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.CompensateScopeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompensateScopeImpl extends ActivityImpl implements
		CompensateScope {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Activity target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompensateScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.COMPENSATE_SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Activity) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.COMPENSATE_SCOPE__TARGET, oldTarget,
							target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setTarget(Activity newTarget) {
		Activity oldTarget = target;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_TARGET, newTarget == null ? null
							: newTarget.getName());
		}
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.COMPENSATE_SCOPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.COMPENSATE_SCOPE__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
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
		case BPELPackage.COMPENSATE_SCOPE__TARGET:
			setTarget((Activity) newValue);
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
		case BPELPackage.COMPENSATE_SCOPE__TARGET:
			setTarget((Activity) null);
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
		case BPELPackage.COMPENSATE_SCOPE__TARGET:
			return target != null;
		}
		return super.eIsSet(featureID);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.model.CompensateScope#setTarget(java.lang.String)
	 * @customized
	 */

	public void setTarget(String scopeName) {

		// From the spec: 
		//
		// <quote>
		//   This activity can be used only in the following parts of a business process: 
		// - In a fault handler of the scope that immediately encloses the scope for which 
		//   compensation is to be performed. 
		// - In the compensation handler of the scope that immediately encloses the scope 
		//   for which compensation is to be performed.
		// </quote>
		//
		// JM: Modified this method to include a more sensible interpretation of
		// "immediately encloses". Rather than a strict parent-child relationship,
		// this simply means the closest enclosing Scope.

		EObject enclosingScopeOrProcess = null;
		// Look for the closest enclosing Scope, or the process, ensuring that we pass a
		// Catch, CatchAll or CompensationHandler on the way, as these are
		// the only places where a Compensate activity is valid.
		EObject container = eContainer();
		boolean isValidLocation = false;
		while (container != null) {
			if (container instanceof Catch || container instanceof CatchAll
					|| container instanceof CompensationHandler) {
				isValidLocation = true;
			} else if (container instanceof Scope
					|| container instanceof Process) {
				enclosingScopeOrProcess = container;
				break;
			}
			container = container.eContainer();
		}
		if (enclosingScopeOrProcess == null) {
			// Error, silently fail
			return;
		}
		if (!isValidLocation) {
			// Error, silently fail
			// CH: Allow this and let the validator mark it as an error.
			//return;
		}

		// Find the enclosed scope with the specified scopeName. Since there are
		// many places where scope activities may appear, this search
		// intentionally starts with a broad set of candidates (the entire
		// containment hierarchy) and prunes away the uninteresting parts.
		for (TreeIterator i = enclosingScopeOrProcess.eAllContents(); i
				.hasNext();) {
			EObject next = (EObject) i.next();
			if (next instanceof Scope) {
				Scope candidate = (Scope) next;
				if (scopeName.equals(candidate.getName())) {
					setTarget(candidate);
					return;
				}
				// JM: Do not prune the subtree. A scope here which doesn't match
				// may contain another scope which does.
				//i.prune();
			} else if (next instanceof Invoke) {
				Invoke candidate = (Invoke) next;
				if (scopeName.equals(candidate.getName())) {
					setTarget(candidate);
					return;
				}
				i.prune();
			}
		}

		// In the case where a match was not found, install a proxy.
		ScopeProxy scopeProxy = new ScopeProxy(eResource().getURI(), scopeName);
		setTarget(scopeProxy);
	}

} //CompensateScopeImpl
