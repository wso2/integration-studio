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
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getIterateID <em>Iterate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#isSequentialMediation <em>Sequential Mediation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#isContinueParent <em>Continue Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#isPreservePayload <em>Preserve Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getIterateExpression <em>Iterate Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getAttachPath <em>Attach Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getTargetOutputConnector <em>Target Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getSequenceKey <em>Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateMediatorImpl#getSequenceName <em>Sequence Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateMediatorImpl extends MediatorImpl implements IterateMediator {
	/**
	 * The default value of the '{@link #getIterateID() <em>Iterate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterateID()
	 * @generated
	 * @ordered
	 */
	protected static final String ITERATE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIterateID() <em>Iterate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterateID()
	 * @generated
	 * @ordered
	 */
	protected String iterateID = ITERATE_ID_EDEFAULT;

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
	 * The default value of the '{@link #isPreservePayload() <em>Preserve Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreservePayload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRESERVE_PAYLOAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPreservePayload() <em>Preserve Payload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreservePayload()
	 * @generated
	 * @ordered
	 */
	protected boolean preservePayload = PRESERVE_PAYLOAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIterateExpression() <em>Iterate Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterateExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty iterateExpression;

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
	protected IterateTarget target;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected IterateMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected IterateMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getTargetOutputConnector() <em>Target Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected IterateMediatorTargetOutputConnector targetOutputConnector;

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
	protected IterateMediatorImpl() {
		super();
		
		// Attach path.
		NamespacedProperty attachPath = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		attachPath.setPrettyName("Attach Path");
		attachPath.setPropertyName("attachPath");
		attachPath.setPropertyValue("/default/expression");
		setAttachPath(attachPath);

		// Iterate expression.
		NamespacedProperty iterateExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		iterateExpression.setPrettyName("Iterate Expression");
		iterateExpression.setPropertyName("expression");
		iterateExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setIterateExpression(iterateExpression);
		
		RegistryKeyProperty targetSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		targetSequenceKey.setPrettyName("Sequence Reference");
		targetSequenceKey.setKeyName("key");
		targetSequenceKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setSequenceKey(targetSequenceKey);

		setTarget(EsbFactoryImpl.eINSTANCE.createIterateTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ITERATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIterateID() {
		return iterateID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterateID(String newIterateID) {
		String oldIterateID = iterateID;
		iterateID = newIterateID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__ITERATE_ID, oldIterateID, iterateID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION, oldSequentialMediation, sequentialMediation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT, oldContinueParent, continueParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreservePayload() {
		return preservePayload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreservePayload(boolean newPreservePayload) {
		boolean oldPreservePayload = preservePayload;
		preservePayload = newPreservePayload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD, oldPreservePayload, preservePayload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getIterateExpression() {
		return iterateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterateExpression(NamespacedProperty newIterateExpression, NotificationChain msgs) {
		NamespacedProperty oldIterateExpression = iterateExpression;
		iterateExpression = newIterateExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, oldIterateExpression, newIterateExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterateExpression(NamespacedProperty newIterateExpression) {
		if (newIterateExpression != iterateExpression) {
			NotificationChain msgs = null;
			if (iterateExpression != null)
				msgs = ((InternalEObject)iterateExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, null, msgs);
			if (newIterateExpression != null)
				msgs = ((InternalEObject)newIterateExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, null, msgs);
			msgs = basicSetIterateExpression(newIterateExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION, newIterateExpression, newIterateExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH, oldAttachPath, newAttachPath);
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
				msgs = ((InternalEObject)attachPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH, null, msgs);
			if (newAttachPath != null)
				msgs = ((InternalEObject)newAttachPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH, null, msgs);
			msgs = basicSetAttachPath(newAttachPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH, newAttachPath, newAttachPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateTarget getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(IterateTarget newTarget, NotificationChain msgs) {
		IterateTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(IterateTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(IterateMediatorInputConnector newInputConnector, NotificationChain msgs) {
		IterateMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(IterateMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(IterateMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		IterateMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(IterateMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorTargetOutputConnector getTargetOutputConnector() {
		return targetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetOutputConnector(IterateMediatorTargetOutputConnector newTargetOutputConnector, NotificationChain msgs) {
		IterateMediatorTargetOutputConnector oldTargetOutputConnector = targetOutputConnector;
		targetOutputConnector = newTargetOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR, oldTargetOutputConnector, newTargetOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetOutputConnector(IterateMediatorTargetOutputConnector newTargetOutputConnector) {
		if (newTargetOutputConnector != targetOutputConnector) {
			NotificationChain msgs = null;
			if (targetOutputConnector != null)
				msgs = ((InternalEObject)targetOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR, null, msgs);
			if (newTargetOutputConnector != null)
				msgs = ((InternalEObject)newTargetOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetTargetOutputConnector(newTargetOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR, newTargetOutputConnector, newTargetOutputConnector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE, oldSequenceType, sequenceType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY, oldSequenceKey, newSequenceKey);
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
				msgs = ((InternalEObject)sequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			if (newSequenceKey != null)
				msgs = ((InternalEObject)newSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY, null, msgs);
			msgs = basicSetSequenceKey(newSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY, newSequenceKey, newSequenceKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME, oldSequenceName, sequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return basicSetIterateExpression(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return basicSetAttachPath(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
				return basicSetTarget(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return basicSetTargetOutputConnector(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
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
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_ID:
				return getIterateID();
			case EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return isSequentialMediation();
			case EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				return isContinueParent();
			case EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				return isPreservePayload();
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return getIterateExpression();
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return getAttachPath();
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
				return getTarget();
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return getTargetOutputConnector();
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE:
				return getSequenceType();
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
				return getSequenceKey();
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME:
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
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_ID:
				setIterateID((String)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation((Boolean)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent((Boolean)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				setPreservePayload((Boolean)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				setIterateExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
				setTarget((IterateTarget)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((IterateMediatorInputConnector)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((IterateMediatorOutputConnector)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				setTargetOutputConnector((IterateMediatorTargetOutputConnector)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME:
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
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_ID:
				setIterateID(ITERATE_ID_EDEFAULT);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				setSequentialMediation(SEQUENTIAL_MEDIATION_EDEFAULT);
				return;
			case EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				setContinueParent(CONTINUE_PARENT_EDEFAULT);
				return;
			case EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				setPreservePayload(PRESERVE_PAYLOAD_EDEFAULT);
				return;
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				setIterateExpression((NamespacedProperty)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				setAttachPath((NamespacedProperty)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
				setTarget((IterateTarget)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((IterateMediatorInputConnector)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((IterateMediatorOutputConnector)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				setTargetOutputConnector((IterateMediatorTargetOutputConnector)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE:
				setSequenceType(SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
				setSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME:
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
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_ID:
				return ITERATE_ID_EDEFAULT == null ? iterateID != null : !ITERATE_ID_EDEFAULT.equals(iterateID);
			case EsbPackage.ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION:
				return sequentialMediation != SEQUENTIAL_MEDIATION_EDEFAULT;
			case EsbPackage.ITERATE_MEDIATOR__CONTINUE_PARENT:
				return continueParent != CONTINUE_PARENT_EDEFAULT;
			case EsbPackage.ITERATE_MEDIATOR__PRESERVE_PAYLOAD:
				return preservePayload != PRESERVE_PAYLOAD_EDEFAULT;
			case EsbPackage.ITERATE_MEDIATOR__ITERATE_EXPRESSION:
				return iterateExpression != null;
			case EsbPackage.ITERATE_MEDIATOR__ATTACH_PATH:
				return attachPath != null;
			case EsbPackage.ITERATE_MEDIATOR__TARGET:
				return target != null;
			case EsbPackage.ITERATE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.ITERATE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.ITERATE_MEDIATOR__TARGET_OUTPUT_CONNECTOR:
				return targetOutputConnector != null;
			case EsbPackage.ITERATE_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_TYPE:
				return sequenceType != SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_KEY:
				return sequenceKey != null;
			case EsbPackage.ITERATE_MEDIATOR__SEQUENCE_NAME:
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
		result.append(" (iterateID: ");
		result.append(iterateID);
		result.append(", sequentialMediation: ");
		result.append(sequentialMediation);
		result.append(", continueParent: ");
		result.append(continueParent);
		result.append(", preservePayload: ");
		result.append(preservePayload);
		result.append(", sequenceType: ");
		result.append(sequenceType);
		result.append(", sequenceName: ");
		result.append(sequenceName);
		result.append(')');
		return result.toString();
	}

} //IterateMediatorImpl
