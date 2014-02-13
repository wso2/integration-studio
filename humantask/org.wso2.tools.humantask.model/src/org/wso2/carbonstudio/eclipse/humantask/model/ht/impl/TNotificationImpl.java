/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TNotification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getPeopleAssignments <em>People Assignments</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getPresentationElements <em>Presentation Elements</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getRenderings <em>Renderings</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TNotificationImpl extends TExtensibleElementsImpl implements TNotification {
	/**
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected TNotificationInterface interface_;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected TPriority priority;

	/**
	 * The cached value of the '{@link #getPeopleAssignments() <em>People Assignments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleAssignments()
	 * @generated
	 * @ordered
	 */
	protected TPeopleAssignments peopleAssignments;

	/**
	 * The cached value of the '{@link #getPresentationElements() <em>Presentation Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationElements()
	 * @generated
	 * @ordered
	 */
	protected TPresentationElements presentationElements;

	/**
	 * The cached value of the '{@link #getRenderings() <em>Renderings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenderings()
	 * @generated
	 * @ordered
	 */
	protected TRenderings renderings;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TNOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotificationInterface getInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(TNotificationInterface newInterface, NotificationChain msgs) {
		TNotificationInterface oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__INTERFACE, oldInterface, newInterface);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(TNotificationInterface newInterface) {
		if (newInterface != interface_) {
			NotificationChain msgs = null;
			if (interface_ != null)
				msgs = ((InternalEObject)interface_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__INTERFACE, null, msgs);
			if (newInterface != null)
				msgs = ((InternalEObject)newInterface).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__INTERFACE, null, msgs);
			msgs = basicSetInterface(newInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__INTERFACE, newInterface, newInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPriority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPriority(TPriority newPriority, NotificationChain msgs) {
		TPriority oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PRIORITY, oldPriority, newPriority);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(TPriority newPriority) {
		if (newPriority != priority) {
			NotificationChain msgs = null;
			if (priority != null)
				msgs = ((InternalEObject)priority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PRIORITY, null, msgs);
			if (newPriority != null)
				msgs = ((InternalEObject)newPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PRIORITY, null, msgs);
			msgs = basicSetPriority(newPriority, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PRIORITY, newPriority, newPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPeopleAssignments getPeopleAssignments() {
		return peopleAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeopleAssignments(TPeopleAssignments newPeopleAssignments, NotificationChain msgs) {
		TPeopleAssignments oldPeopleAssignments = peopleAssignments;
		peopleAssignments = newPeopleAssignments;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS, oldPeopleAssignments, newPeopleAssignments);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeopleAssignments(TPeopleAssignments newPeopleAssignments) {
		if (newPeopleAssignments != peopleAssignments) {
			NotificationChain msgs = null;
			if (peopleAssignments != null)
				msgs = ((InternalEObject)peopleAssignments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS, null, msgs);
			if (newPeopleAssignments != null)
				msgs = ((InternalEObject)newPeopleAssignments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS, null, msgs);
			msgs = basicSetPeopleAssignments(newPeopleAssignments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS, newPeopleAssignments, newPeopleAssignments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPresentationElements getPresentationElements() {
		return presentationElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPresentationElements(TPresentationElements newPresentationElements, NotificationChain msgs) {
		TPresentationElements oldPresentationElements = presentationElements;
		presentationElements = newPresentationElements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS, oldPresentationElements, newPresentationElements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationElements(TPresentationElements newPresentationElements) {
		if (newPresentationElements != presentationElements) {
			NotificationChain msgs = null;
			if (presentationElements != null)
				msgs = ((InternalEObject)presentationElements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS, null, msgs);
			if (newPresentationElements != null)
				msgs = ((InternalEObject)newPresentationElements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS, null, msgs);
			msgs = basicSetPresentationElements(newPresentationElements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS, newPresentationElements, newPresentationElements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TRenderings getRenderings() {
		return renderings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenderings(TRenderings newRenderings, NotificationChain msgs) {
		TRenderings oldRenderings = renderings;
		renderings = newRenderings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__RENDERINGS, oldRenderings, newRenderings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderings(TRenderings newRenderings) {
		if (newRenderings != renderings) {
			NotificationChain msgs = null;
			if (renderings != null)
				msgs = ((InternalEObject)renderings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__RENDERINGS, null, msgs);
			if (newRenderings != null)
				msgs = ((InternalEObject)newRenderings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TNOTIFICATION__RENDERINGS, null, msgs);
			msgs = basicSetRenderings(newRenderings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__RENDERINGS, newRenderings, newRenderings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TNOTIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TNOTIFICATION__INTERFACE:
				return basicSetInterface(null, msgs);
			case HTPackage.TNOTIFICATION__PRIORITY:
				return basicSetPriority(null, msgs);
			case HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS:
				return basicSetPeopleAssignments(null, msgs);
			case HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS:
				return basicSetPresentationElements(null, msgs);
			case HTPackage.TNOTIFICATION__RENDERINGS:
				return basicSetRenderings(null, msgs);
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
			case HTPackage.TNOTIFICATION__INTERFACE:
				return getInterface();
			case HTPackage.TNOTIFICATION__PRIORITY:
				return getPriority();
			case HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS:
				return getPeopleAssignments();
			case HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS:
				return getPresentationElements();
			case HTPackage.TNOTIFICATION__RENDERINGS:
				return getRenderings();
			case HTPackage.TNOTIFICATION__NAME:
				return getName();
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
			case HTPackage.TNOTIFICATION__INTERFACE:
				setInterface((TNotificationInterface)newValue);
				return;
			case HTPackage.TNOTIFICATION__PRIORITY:
				setPriority((TPriority)newValue);
				return;
			case HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)newValue);
				return;
			case HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS:
				setPresentationElements((TPresentationElements)newValue);
				return;
			case HTPackage.TNOTIFICATION__RENDERINGS:
				setRenderings((TRenderings)newValue);
				return;
			case HTPackage.TNOTIFICATION__NAME:
				setName((String)newValue);
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
			case HTPackage.TNOTIFICATION__INTERFACE:
				setInterface((TNotificationInterface)null);
				return;
			case HTPackage.TNOTIFICATION__PRIORITY:
				setPriority((TPriority)null);
				return;
			case HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS:
				setPeopleAssignments((TPeopleAssignments)null);
				return;
			case HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS:
				setPresentationElements((TPresentationElements)null);
				return;
			case HTPackage.TNOTIFICATION__RENDERINGS:
				setRenderings((TRenderings)null);
				return;
			case HTPackage.TNOTIFICATION__NAME:
				setName(NAME_EDEFAULT);
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
			case HTPackage.TNOTIFICATION__INTERFACE:
				return interface_ != null;
			case HTPackage.TNOTIFICATION__PRIORITY:
				return priority != null;
			case HTPackage.TNOTIFICATION__PEOPLE_ASSIGNMENTS:
				return peopleAssignments != null;
			case HTPackage.TNOTIFICATION__PRESENTATION_ELEMENTS:
				return presentationElements != null;
			case HTPackage.TNOTIFICATION__RENDERINGS:
				return renderings != null;
			case HTPackage.TNOTIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TNotificationImpl
