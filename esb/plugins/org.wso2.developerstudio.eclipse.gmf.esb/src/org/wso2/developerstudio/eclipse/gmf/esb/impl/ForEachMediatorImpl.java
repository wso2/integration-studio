/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getForEachID <em>For Each ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getForEachExpression <em>For Each Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getAttachPath <em>Attach Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getTargetOutputConnector <em>Target Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ForEachMediatorImpl#getSequenceName <em>Sequence Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForEachMediatorImpl extends MediatorImpl implements ForEachMediator {
	
	private static final String FOREACH_EXPRESSION_NAME = "ForEach Expression";
	private static final String FOREACH_EXPRESSION_PROPERTY_NAME = "expression";
	private static final String FOREACH_REGISTRY_KEY_NAME = "Sequence Reference";
	private static final String FOREACH_REGISTRY_KEY_KEY_NAME = "key";

	/**
	 * The default value of the '{@link #getForEachID() <em>For Each ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForEachID()
	 * @generated
	 * @ordered
	 */
	protected static final String FOR_EACH_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForEachID() <em>For Each ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForEachID()
	 * @generated
	 * @ordered
	 */
	protected String forEachID = FOR_EACH_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForEachExpression() <em>For Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForEachExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty forEachExpression;

	/**
	 * The cached value of the '{@link #getAttachPath() <em>Attach Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachPath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty attachPath;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ForEachTarget target;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ForEachMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ForEachMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getTargetOutputConnector() <em>Target Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ForEachMediatorTargetOutputConnector targetOutputConnector;

	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

	/**
	 * The default value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getSequenceType() <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType sequenceType = SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequenceKey() <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty sequenceKey;

	/**
	 * The default value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String sequenceName = SEQUENCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ForEachMediatorImpl() {
		super();

		// ForEach expression.
		NamespacedProperty forEachExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		forEachExpression.setPrettyName(FOREACH_EXPRESSION_NAME);
		forEachExpression.setPropertyName(FOREACH_EXPRESSION_PROPERTY_NAME);
		forEachExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setForEachExpression(forEachExpression);
		
		RegistryKeyProperty targetSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		targetSequenceKey.setPrettyName(FOREACH_REGISTRY_KEY_NAME);
		targetSequenceKey.setKeyName(FOREACH_REGISTRY_KEY_KEY_NAME);
		targetSequenceKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setSequenceKey(targetSequenceKey);

		setTarget(EsbFactoryImpl.eINSTANCE.createForEachTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.FOR_EACH_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForEachID() {
		return forEachID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForEachID(String newForEachID) {
		String oldForEachID = forEachID;
		forEachID = newForEachID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID, oldForEachID, forEachID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getForEachExpression() {
		return forEachExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForEachExpression(NamespacedProperty newForEachExpression, NotificationChain msgs) {
		NamespacedProperty oldForEachExpression = forEachExpression;
		forEachExpression = newForEachExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION, oldForEachExpression, newForEachExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForEachExpression(NamespacedProperty newForEachExpression) {
		if (newForEachExpression != forEachExpression) {
			NotificationChain msgs = null;
			if (forEachExpression != null)
				msgs = ((InternalEObject)forEachExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION, null, msgs);
			if (newForEachExpression != null)
				msgs = ((InternalEObject)newForEachExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION, null, msgs);
			msgs = basicSetForEachExpression(newForEachExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION, newForEachExpression, newForEachExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getAttachPath() {
		return attachPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachPath(NamespacedProperty newAttachPath, NotificationChain msgs) {
		NamespacedProperty oldAttachPath = attachPath;
		attachPath = newAttachPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH, oldAttachPath, newAttachPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttachPath(NamespacedProperty newAttachPath) {
		if (newAttachPath != attachPath) {
			NotificationChain msgs = null;
			if (attachPath != null)
				msgs = ((InternalEObject)attachPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH, null, msgs);
			if (newAttachPath != null)
				msgs = ((InternalEObject)newAttachPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH, null, msgs);
			msgs = basicSetAttachPath(newAttachPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH, newAttachPath, newAttachPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachTarget getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ForEachTarget newTarget, NotificationChain msgs) {
		ForEachTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ForEachTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ForEachMediatorInputConnector newInputConnector, NotificationChain msgs) {
		ForEachMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ForEachMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ForEachMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		ForEachMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ForEachMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorTargetOutputConnector getTargetOutputConnector() {
		return targetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOutputConnector(ForEachMediatorTargetOutputConnector newTargetOutputConnector, NotificationChain msgs) {
		ForEachMediatorTargetOutputConnector oldTargetOutputConnector = targetOutputConnector;
		targetOutputConnector = newTargetOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR, oldTargetOutputConnector, newTargetOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOutputConnector(ForEachMediatorTargetOutputConnector newTargetOutputConnector) {
		if (newTargetOutputConnector != targetOutputConnector) {
			NotificationChain msgs = null;
			if (targetOutputConnector != null)
				msgs = ((InternalEObject)targetOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR, null, msgs);
			if (newTargetOutputConnector != null)
				msgs = ((InternalEObject)newTargetOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetTargetOutputConnector(newTargetOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR, newTargetOutputConnector, newTargetOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getSequenceType() {
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(SequenceType newSequenceType) {
		SequenceType oldSequenceType = sequenceType;
		sequenceType = newSequenceType == null ? SEQUENCE_TYPE_EDEFAULT : newSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSequenceKey() {
		return sequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceKey(RegistryKeyProperty newSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldSequenceKey = sequenceKey;
		sequenceKey = newSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceKey(RegistryKeyProperty newSequenceKey) {
		if (newSequenceKey != sequenceKey) {
			NotificationChain msgs = null;
			if (sequenceKey != null)
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSequenceName() {
		return sequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceName(String newSequenceName) {
		String oldSequenceName = sequenceName;
		sequenceName = newSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME, oldSequenceName, sequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
				return basicSetForEachExpression(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
				return basicSetAttachPath(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
				return basicSetTarget(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return basicSetTargetOutputConnector(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
				return basicSetSequenceKey(null, msgs);
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
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID:
				return getForEachID();
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
				return getForEachExpression();
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
				return getAttachPath();
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
				return getTarget();
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return getTargetOutputConnector();
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME:
				return getSequenceName();
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
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID:
				setForEachID((String)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
				setForEachExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
				setTarget((ForEachTarget)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ForEachMediatorInputConnector)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ForEachMediatorOutputConnector)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				setTargetOutputConnector((ForEachMediatorTargetOutputConnector)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME:
				setSequenceName((String)newValue);
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
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID:
				setForEachID(FOR_EACH_ID_EDEFAULT);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
				setForEachExpression((NamespacedProperty)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
				setTarget((ForEachTarget)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ForEachMediatorInputConnector)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ForEachMediatorOutputConnector)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				setTargetOutputConnector((ForEachMediatorTargetOutputConnector)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME:
				setSequenceName(SEQUENCE_NAME_EDEFAULT);
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
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_ID:
				return FOR_EACH_ID_EDEFAULT == null ? forEachID != null : !FOR_EACH_ID_EDEFAULT.equals(forEachID);
			case EsbPackage.FOR_EACH_MEDIATOR__FOR_EACH_EXPRESSION:
				return forEachExpression != null;
			case EsbPackage.FOR_EACH_MEDIATOR__ATTACH_PATH:
				return attachPath != null;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET:
				return target != null;
			case EsbPackage.FOR_EACH_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.FOR_EACH_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.FOR_EACH_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return targetOutputConnector != null;
			case EsbPackage.FOR_EACH_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.FOR_EACH_MEDIATOR__SEQUENCE_NAME:
				return SEQUENCE_NAME_EDEFAULT == null ? sequenceName != null : !SEQUENCE_NAME_EDEFAULT.equals(sequenceName);
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
		result.append(" (forEachID: ");
		result.append(forEachID);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(", sequenceName: ");
		result.append(sequenceName);
		result.append(')');
		return result.toString();
	}

} //ForEachMediatorImpl
