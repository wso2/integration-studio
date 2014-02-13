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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheAction;
import org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Iterate Mediator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#getIterateID <em>Iterate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#isPreservePayload <em>Preserve Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#getIterateExpression <em>Iterate Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#getAttachPath <em>Attach Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateMediatorImpl extends MediatorImpl implements
		IterateMediator {
	/**
	 * The default value of the '{@link #getIterateID() <em>Iterate ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIterateID()
	 * @generated
	 * @ordered
	 */
	protected static final String ITERATE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIterateID() <em>Iterate ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIterateID()
	 * @generated
	 * @ordered
	 */
	protected String iterateID = ITERATE_ID_EDEFAULT;

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
	 * The default value of the '{@link #isPreservePayload() <em>Preserve Payload</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isPreservePayload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRESERVE_PAYLOAD_EDEFAULT = false;

	protected static final String ATTACH_PATH_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #isPreservePayload() <em>Preserve Payload</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isPreservePayload()
	 * @generated
	 * @ordered
	 */
	protected boolean preservePayload = PRESERVE_PAYLOAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIterateExpression() <em>Iterate Expression</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getIterateExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty iterateExpression;

	/**
	 * The cached value of the '{@link #getAttachPath() <em>Attach Path</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttachPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty attachPath;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected IterateTarget target;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected IterateMediatorImpl() {
		super();

		// Attach path.
		NamespacedProperty attachPath = getEsbFactory()
				.createNamespacedProperty();
		attachPath.setPrettyName("Attach Path");
		attachPath.setPropertyName("attachPath");
		attachPath.setPropertyValue(ATTACH_PATH_EDEFAULT);
		setAttachPath(attachPath);

		// Iterate expression.
		NamespacedProperty iterateExpression = getEsbFactory()
				.createNamespacedProperty();
		iterateExpression.setPrettyName("Iterate Expression");
		iterateExpression.setPropertyName("expression");
		iterateExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setIterateExpression(iterateExpression);

		setTarget(getMediatorFactory().createIterateTarget());
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// ID
		if (self.hasAttribute("id")) {
			setIterateID(self.getAttribute("id"));
		}

		// Sequential Mediation
		if (self.hasAttribute("sequential")) {
			setSequentialMediation(self.getAttribute("sequential").equals(true) ? true
					: false);

		}else{
			setSequentialMediation(false);
		}
		// continueParent
		if (self.hasAttribute("continueParent")) {
			if (self.getAttribute("continueParent").equals("true")) {
				setContinueParent(true);
			} else {
				setContinueParent(false);
			}
		} else {
			setContinueParent(false);
		}

		// preserve payload
		if (self.hasAttribute("preservePayload")) {
			if (self.getAttribute("preservePayload").equals("true")) {
				setPreservePayload(true);
			} else {
				setPreservePayload(false);
			}
		} else {
			setPreservePayload(false);
		}

		// attach path
		if (self.hasAttribute("attachPath")) {
			getAttachPath().load(self);
		}

		// iterate expression
		if (self.hasAttribute("expression")) {
			getIterateExpression().load(self);
		}

		// Target.
		loadObject(self, "target", IterateTarget.class, false,
				new ObjectHandler<IterateTarget>() {
					public void handle(IterateTarget object) {
						setTarget(object);
					}
				});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "iterate");

		switch (getCurrentEsbVersion()) {
		case ESB301:

			if (isContinueParent()) {
				self.setAttribute("continueParent", "true");
			}
			if (isPreservePayload()) {
				self.setAttribute("preservePayload", "true");
			}

			if (isAttachPathSet()) {
				getAttachPath().save(self);
			}

			getIterateExpression().save(self);

			// target element
			if (getTarget() != null) {
				getTarget().save(self);
			}
			if(description!=null)
				description.save(self);
			break;
		case ESB400:
			// ID
			if (getIterateID() != null) {
				self.setAttribute("id", getIterateID());
			}
			// Sequential Mediation
			if (isSequentialMediation()) {
				self.setAttribute("sequential", "true");
			}
			if (isContinueParent()) {
				self.setAttribute("continueParent", "true");
			}
			if (isPreservePayload()) {
				self.setAttribute("preservePayload", "true");
			}

			if (isAttachPathSet()) {
				getAttachPath().save(self);
			}

			getIterateExpression().save(self);

			// target element
			if (getTarget() != null) {
				getTarget().save(self);
			}
			if(description!=null)
				description.save(self);
			break;

		}

		addComments(self);
		return self;
	}

	private boolean isAttachPathSet() {
		return getAttachPath().getPropertyValue() != null
				&& !getAttachPath().getPropertyValue().trim().equals("");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.ITERATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterateID() {
		return iterateID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterateID(String newIterateID) {
		String oldIterateID = iterateID;
		iterateID = newIterateID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__ITERATE_ID, oldIterateID, iterateID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION, oldSequentialMediation, sequentialMediation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__CONTINUE_PARENT, oldContinueParent, continueParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreservePayload() {
		return preservePayload;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreservePayload(boolean newPreservePayload) {
		boolean oldPreservePayload = preservePayload;
		preservePayload = newPreservePayload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD, oldPreservePayload, preservePayload));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getIterateExpression() {
		return iterateExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterateExpression(
			NamespacedProperty newIterateExpression, NotificationChain msgs) {
		NamespacedProperty oldIterateExpression = iterateExpression;
		iterateExpression = newIterateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, oldIterateExpression, newIterateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterateExpression(NamespacedProperty newIterateExpression) {
		if (newIterateExpression != iterateExpression) {
			NotificationChain msgs = null;
			if (iterateExpression != null)
				msgs = ((InternalEObject)iterateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, null, msgs);
			if (newIterateExpression != null)
				msgs = ((InternalEObject)newIterateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, null, msgs);
			msgs = basicSetIterateExpression(newIterateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, newIterateExpression, newIterateExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getAttachPath() {
		return attachPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachPath(
			NamespacedProperty newAttachPath, NotificationChain msgs) {
		NamespacedProperty oldAttachPath = attachPath;
		attachPath = newAttachPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH, oldAttachPath, newAttachPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttachPath(NamespacedProperty newAttachPath) {
		if (newAttachPath != attachPath) {
			NotificationChain msgs = null;
			if (attachPath != null)
				msgs = ((InternalEObject)attachPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH, null, msgs);
			if (newAttachPath != null)
				msgs = ((InternalEObject)newAttachPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH, null, msgs);
			msgs = basicSetAttachPath(newAttachPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH, newAttachPath, newAttachPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IterateTarget getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(IterateTarget newTarget,
			NotificationChain msgs) {
		IterateTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(IterateTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.ITERATE_MEDIATOR__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.ITERATE_MEDIATOR__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return basicSetIterateExpression(null, msgs);
			case MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return basicSetAttachPath(null, msgs);
			case MediatorsPackage.ITERATE_MEDIATOR__TARGET:
				return basicSetTarget(null, msgs);
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
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_ID:
				return getIterateID();
			case MediatorsPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return isSequentialMediation();
			case MediatorsPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				return isContinueParent();
			case MediatorsPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				return isPreservePayload();
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return getIterateExpression();
			case MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return getAttachPath();
			case MediatorsPackage.ITERATE_MEDIATOR__TARGET:
				return getTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_ID:
				setIterateID((String)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation((Boolean)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent((Boolean)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				setPreservePayload((Boolean)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				setIterateExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__TARGET:
				setTarget((IterateTarget)newValue);
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
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_ID:
				setIterateID(ITERATE_ID_EDEFAULT);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation(SEQUENTIAL_MEDIATION_EDEFAULT);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent(CONTINUE_PARENT_EDEFAULT);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				setPreservePayload(PRESERVE_PAYLOAD_EDEFAULT);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				setIterateExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)null);
				return;
			case MediatorsPackage.ITERATE_MEDIATOR__TARGET:
				setTarget((IterateTarget)null);
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
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_ID:
				return ITERATE_ID_EDEFAULT == null ? iterateID != null : !ITERATE_ID_EDEFAULT.equals(iterateID);
			case MediatorsPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return sequentialMediation != SEQUENTIAL_MEDIATION_EDEFAULT;
			case MediatorsPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				return continueParent != CONTINUE_PARENT_EDEFAULT;
			case MediatorsPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				return preservePayload != PRESERVE_PAYLOAD_EDEFAULT;
			case MediatorsPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return iterateExpression != null;
			case MediatorsPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return attachPath != null;
			case MediatorsPackage.ITERATE_MEDIATOR__TARGET:
				return target != null;
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
		result.append(" (iterateID: ");
		result.append(iterateID);
		result.append(", sequentialMediation: ");
		result.append(sequentialMediation);
		result.append(", continueParent: ");
		result.append(continueParent);
		result.append(", preservePayload: ");
		result.append(preservePayload);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (null == getIterateExpression().getPropertyValue()
				|| getIterateExpression().getPropertyValue().trim().isEmpty()) {
			validateMap
					.put("Iterate expression", "Iterate expression is empty");
		}			
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Iterate Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} // IterateMediatorImpl
