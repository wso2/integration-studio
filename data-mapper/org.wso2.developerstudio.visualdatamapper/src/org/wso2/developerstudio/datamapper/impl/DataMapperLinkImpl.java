/**
 */
package org.wso2.developerstudio.datamapper.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.OutNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl#getInNode <em>In Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.DataMapperLinkImpl#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperLinkImpl extends EObjectImpl implements DataMapperLink {
	/**
	 * The cached value of the '{@link #getInNode() <em>In Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInNode()
	 * @generated
	 * @ordered
	 */
	protected InNode inNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMapperLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.DATA_MAPPER_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InNode getInNode() {
		if (inNode != null && inNode.eIsProxy()) {
			InternalEObject oldInNode = (InternalEObject)inNode;
			inNode = (InNode)eResolveProxy(oldInNode);
			if (inNode != oldInNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataMapperPackage.DATA_MAPPER_LINK__IN_NODE, oldInNode, inNode));
			}
		}
		return inNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InNode basicGetInNode() {
		return inNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInNode(InNode newInNode, NotificationChain msgs) {
		InNode oldInNode = inNode;
		inNode = newInNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_LINK__IN_NODE, oldInNode, newInNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInNode(InNode newInNode) {
		if (newInNode != inNode) {
			NotificationChain msgs = null;
			if (inNode != null)
				msgs = ((InternalEObject)inNode).eInverseRemove(this, DataMapperPackage.IN_NODE__INCOMING_LINK, InNode.class, msgs);
			if (newInNode != null)
				msgs = ((InternalEObject)newInNode).eInverseAdd(this, DataMapperPackage.IN_NODE__INCOMING_LINK, InNode.class, msgs);
			msgs = basicSetInNode(newInNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_LINK__IN_NODE, newInNode, newInNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutNode getOutNode() {
		if (eContainerFeatureID() != DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE) return null;
		return (OutNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutNode(OutNode newOutNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutNode, DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutNode(OutNode newOutNode) {
		if (newOutNode != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE && newOutNode != null)) {
			if (EcoreUtil.isAncestor(this, newOutNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutNode != null)
				msgs = ((InternalEObject)newOutNode).eInverseAdd(this, DataMapperPackage.OUT_NODE__OUTGOING_LINK, OutNode.class, msgs);
			msgs = basicSetOutNode(newOutNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE, newOutNode, newOutNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				if (inNode != null)
					msgs = ((InternalEObject)inNode).eInverseRemove(this, DataMapperPackage.IN_NODE__INCOMING_LINK, InNode.class, msgs);
				return basicSetInNode((InNode)otherEnd, msgs);
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutNode((OutNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				return basicSetInNode(null, msgs);
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.OUT_NODE__OUTGOING_LINK, OutNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				if (resolve) return getInNode();
				return basicGetInNode();
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
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
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				setInNode((InNode)newValue);
				return;
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
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
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				setInNode((InNode)null);
				return;
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
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
			case DataMapperPackage.DATA_MAPPER_LINK__IN_NODE:
				return inNode != null;
			case DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE:
				return getOutNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataMapperLinkImpl
