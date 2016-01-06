/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.OutNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Out Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OutNodeImpl#getOutgoingLink <em>Outgoing Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.OutNodeImpl#getElementParent <em>Element Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutNodeImpl extends EObjectImpl implements OutNode {
	/**
	 * The cached value of the '{@link #getOutgoingLink() <em>Outgoing Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLink()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapperLink> outgoingLink;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.OUT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapperLink> getOutgoingLink() {
		if (outgoingLink == null) {
			outgoingLink = new EObjectContainmentWithInverseEList<DataMapperLink>(DataMapperLink.class, this, DataMapperPackage.OUT_NODE__OUTGOING_LINK, DataMapperPackage.DATA_MAPPER_LINK__OUT_NODE);
		}
		return outgoingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElementParent() {
		if (eContainerFeatureID() != DataMapperPackage.OUT_NODE__ELEMENT_PARENT) return null;
		return (Element)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementParent(Element newElementParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementParent, DataMapperPackage.OUT_NODE__ELEMENT_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementParent(Element newElementParent) {
		if (newElementParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.OUT_NODE__ELEMENT_PARENT && newElementParent != null)) {
			if (EcoreUtil.isAncestor(this, newElementParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElementParent != null)
				msgs = ((InternalEObject)newElementParent).eInverseAdd(this, DataMapperPackage.ELEMENT__OUT_NODE, Element.class, msgs);
			msgs = basicSetElementParent(newElementParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.OUT_NODE__ELEMENT_PARENT, newElementParent, newElementParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLink()).basicAdd(otherEnd, msgs);
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElementParent((Element)otherEnd, msgs);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return ((InternalEList<?>)getOutgoingLink()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				return basicSetElementParent(null, msgs);
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
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.ELEMENT__OUT_NODE, Element.class, msgs);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return getOutgoingLink();
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				return getElementParent();
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				getOutgoingLink().clear();
				getOutgoingLink().addAll((Collection<? extends DataMapperLink>)newValue);
				return;
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				setElementParent((Element)newValue);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				getOutgoingLink().clear();
				return;
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				setElementParent((Element)null);
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
			case DataMapperPackage.OUT_NODE__OUTGOING_LINK:
				return outgoingLink != null && !outgoingLink.isEmpty();
			case DataMapperPackage.OUT_NODE__ELEMENT_PARENT:
				return getElementParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //OutNodeImpl
