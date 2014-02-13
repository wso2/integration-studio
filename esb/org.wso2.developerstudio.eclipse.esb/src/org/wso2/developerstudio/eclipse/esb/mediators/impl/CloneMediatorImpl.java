/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbVersion;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Clone Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl#getCloneID <em>Clone ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloneMediatorImpl extends MediatorImpl implements CloneMediator {
	/**
	 * The default value of the '{@link #getCloneID() <em>Clone ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCloneID()
	 * @generated
	 * @ordered
	 */
	protected static final String CLONE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCloneID() <em>Clone ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCloneID()
	 * @generated
	 * @ordered
	 */
	protected String cloneID = CLONE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isSequentialMediation() <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isSequentialMediation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEQUENTIAL_MEDIATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSequentialMediation() <em>Sequential Mediation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isSequentialMediation()
	 * @generated
	 * @ordered
	 */
	protected boolean sequentialMediation = SEQUENTIAL_MEDIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isContinueParent() <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isContinueParent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTINUE_PARENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContinueParent() <em>Continue Parent</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isContinueParent()
	 * @generated
	 * @ordered
	 */
	protected boolean continueParent = CONTINUE_PARENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<CloneTarget> targets;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CloneMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		if (self.hasAttribute("continueParent")) {
			setContinueParent(self.getAttribute("continueParent")
					.equals("true") ? true : false);
		} else {
			setContinueParent(false);
		}

		if (self.hasAttribute("sequential")) {
			setSequentialMediation(self.getAttribute("sequential").equals(
					"true") ? true : false);
		} else {
			setSequentialMediation(false);
		}
		if (self.hasAttribute("id")) {
			setCloneID(self.getAttribute("id"));
		}

		// Targets.
		loadObjects(self, "target", CloneTarget.class,
				new ObjectHandler<CloneTarget>() {
					public void handle(CloneTarget object) {
						getTargets().add(object);
					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "clone");
		switch (getCurrentEsbVersion()) {
		case ESB301:
			if (isContinueParent()) {
				self.setAttribute("continueParent", "true");
			}
			// Targets.
			for (CloneTarget target : getTargets()) {
				target.save(self);
			}
			if(description!=null)
				description.save(self);
			break;

		case ESB400:
			if (isContinueParent()) {
				self.setAttribute("continueParent", "true");
			}
			// Targets.
			for (CloneTarget target : getTargets()) {
				target.save(self);
			}

			if (isSequentialMediation()) {
				self.setAttribute("sequential", "true");
			}
			if (getCloneID() != null) {
				self.setAttribute("id", getCloneID());
			}
			if(description!=null)
				description.save(self);
			break;
		}

		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.CLONE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCloneID() {
		return cloneID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloneID(String newCloneID) {
		String oldCloneID = cloneID;
		cloneID = newCloneID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CLONE_MEDIATOR__CLONE_ID, oldCloneID, cloneID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequentialMediation() {
		return sequentialMediation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequentialMediation(boolean newSequentialMediation) {
		boolean oldSequentialMediation = sequentialMediation;
		sequentialMediation = newSequentialMediation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION, oldSequentialMediation, sequentialMediation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContinueParent() {
		return continueParent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContinueParent(boolean newContinueParent) {
		boolean oldContinueParent = continueParent;
		continueParent = newContinueParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.CLONE_MEDIATOR__CONTINUE_PARENT, oldContinueParent, continueParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CloneTarget> getTargets() {
		if (targets == null) {
			targets = new EObjectContainmentEList<CloneTarget>(CloneTarget.class, this, MediatorsPackage.CLONE_MEDIATOR__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.CLONE_MEDIATOR__TARGETS:
				return ((InternalEList<?>)getTargets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.CLONE_MEDIATOR__CLONE_ID:
				return getCloneID();
			case MediatorsPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return isSequentialMediation();
			case MediatorsPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				return isContinueParent();
			case MediatorsPackage.CLONE_MEDIATOR__TARGETS:
				return getTargets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.CLONE_MEDIATOR__CLONE_ID:
				setCloneID((String)newValue);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation((Boolean)newValue);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent((Boolean)newValue);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__TARGETS:
				getTargets().clear();
				getTargets().addAll((Collection<? extends CloneTarget>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CLONE_MEDIATOR__CLONE_ID:
				setCloneID(CLONE_ID_EDEFAULT);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation(SEQUENTIAL_MEDIATION_EDEFAULT);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent(CONTINUE_PARENT_EDEFAULT);
				return;
			case MediatorsPackage.CLONE_MEDIATOR__TARGETS:
				getTargets().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MediatorsPackage.CLONE_MEDIATOR__CLONE_ID:
				return CLONE_ID_EDEFAULT == null ? cloneID != null : !CLONE_ID_EDEFAULT.equals(cloneID);
			case MediatorsPackage.CLONE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return sequentialMediation != SEQUENTIAL_MEDIATION_EDEFAULT;
			case MediatorsPackage.CLONE_MEDIATOR__CONTINUE_PARENT:
				return continueParent != CONTINUE_PARENT_EDEFAULT;
			case MediatorsPackage.CLONE_MEDIATOR__TARGETS:
				return targets != null && !targets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

	
    public Map<String, ObjectValidator> validate() {
	    return new HashMap<String, ObjectValidator>();
    }

} // CloneMediatorImpl
