/**
 */
package dataMapper.impl;

import dataMapper.Attribute;
import dataMapper.DataMapperLink;
import dataMapper.DataMapperPackage;
import dataMapper.Element;
import dataMapper.InNode;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.InNodeImpl#getIncomingLink <em>Incoming Link</em>}</li>
 *   <li>{@link dataMapper.impl.InNodeImpl#getElementParent <em>Element Parent</em>}</li>
 *   <li>{@link dataMapper.impl.InNodeImpl#getAttributeParent <em>Attribute Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InNodeImpl extends EObjectImpl implements InNode {
	/**
	 * The cached value of the '{@link #getIncomingLink() <em>Incoming Link</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingLink()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapperLink> incomingLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.IN_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapperLink> getIncomingLink() {
		if (incomingLink == null) {
			incomingLink = new EObjectWithInverseResolvingEList<DataMapperLink>(DataMapperLink.class, this, DataMapperPackage.IN_NODE__INCOMING_LINK, DataMapperPackage.DATA_MAPPER_LINK__IN_NODE);
		}
		return incomingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElementParent() {
		if (eContainerFeatureID() != DataMapperPackage.IN_NODE__ELEMENT_PARENT) return null;
		return (Element)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementParent(Element newElementParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementParent, DataMapperPackage.IN_NODE__ELEMENT_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementParent(Element newElementParent) {
		if (newElementParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.IN_NODE__ELEMENT_PARENT && newElementParent != null)) {
			if (EcoreUtil.isAncestor(this, newElementParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElementParent != null)
				msgs = ((InternalEObject)newElementParent).eInverseAdd(this, DataMapperPackage.ELEMENT__IN_NODE, Element.class, msgs);
			msgs = basicSetElementParent(newElementParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.IN_NODE__ELEMENT_PARENT, newElementParent, newElementParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttributeParent() {
		if (eContainerFeatureID() != DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT) return null;
		return (Attribute)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeParent(Attribute newAttributeParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAttributeParent, DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeParent(Attribute newAttributeParent) {
		if (newAttributeParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT && newAttributeParent != null)) {
			if (EcoreUtil.isAncestor(this, newAttributeParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAttributeParent != null)
				msgs = ((InternalEObject)newAttributeParent).eInverseAdd(this, DataMapperPackage.ATTRIBUTE__IN_NODE, Attribute.class, msgs);
			msgs = basicSetAttributeParent(newAttributeParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT, newAttributeParent, newAttributeParent));
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLink()).basicAdd(otherEnd, msgs);
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElementParent((Element)otherEnd, msgs);
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAttributeParent((Attribute)otherEnd, msgs);
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				return ((InternalEList<?>)getIncomingLink()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				return basicSetElementParent(null, msgs);
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				return basicSetAttributeParent(null, msgs);
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
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.ELEMENT__IN_NODE, Element.class, msgs);
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.ATTRIBUTE__IN_NODE, Attribute.class, msgs);
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				return getIncomingLink();
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				return getElementParent();
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				return getAttributeParent();
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				getIncomingLink().clear();
				getIncomingLink().addAll((Collection<? extends DataMapperLink>)newValue);
				return;
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				setElementParent((Element)newValue);
				return;
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				setAttributeParent((Attribute)newValue);
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				getIncomingLink().clear();
				return;
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				setElementParent((Element)null);
				return;
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				setAttributeParent((Attribute)null);
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
			case DataMapperPackage.IN_NODE__INCOMING_LINK:
				return incomingLink != null && !incomingLink.isEmpty();
			case DataMapperPackage.IN_NODE__ELEMENT_PARENT:
				return getElementParent() != null;
			case DataMapperPackage.IN_NODE__ATTRIBUTE_PARENT:
				return getAttributeParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //InNodeImpl
