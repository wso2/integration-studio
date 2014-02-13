/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPresentation Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl#getPresentationParameters <em>Presentation Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPresentationElementsImpl extends TExtensibleElementsImpl implements TPresentationElements {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EList<TText> name;

	/**
	 * The cached value of the '{@link #getPresentationParameters() <em>Presentation Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationParameters()
	 * @generated
	 * @ordered
	 */
	protected TPresentationParameters presentationParameters;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected EList<TText> subject;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<TDescription> description;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TPresentationElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TPRESENTATION_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TText> getName() {
		if (name == null) {
			name = new EObjectContainmentEList<TText>(TText.class, this, HTPackage.TPRESENTATION_ELEMENTS__NAME);
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPresentationParameters getPresentationParameters() {
		return presentationParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPresentationParameters(TPresentationParameters newPresentationParameters, NotificationChain msgs) {
		TPresentationParameters oldPresentationParameters = presentationParameters;
		presentationParameters = newPresentationParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS, oldPresentationParameters, newPresentationParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationParameters(TPresentationParameters newPresentationParameters) {
		if (newPresentationParameters != presentationParameters) {
			NotificationChain msgs = null;
			if (presentationParameters != null)
				msgs = ((InternalEObject)presentationParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS, null, msgs);
			if (newPresentationParameters != null)
				msgs = ((InternalEObject)newPresentationParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS, null, msgs);
			msgs = basicSetPresentationParameters(newPresentationParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS, newPresentationParameters, newPresentationParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TText> getSubject() {
		if (subject == null) {
			subject = new EObjectContainmentEList<TText>(TText.class, this, HTPackage.TPRESENTATION_ELEMENTS__SUBJECT);
		}
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TDescription> getDescription() {
		if (description == null) {
			description = new EObjectContainmentEList<TDescription>(TDescription.class, this, HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION);
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TPRESENTATION_ELEMENTS__NAME:
				return ((InternalEList<?>)getName()).basicRemove(otherEnd, msgs);
			case HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS:
				return basicSetPresentationParameters(null, msgs);
			case HTPackage.TPRESENTATION_ELEMENTS__SUBJECT:
				return ((InternalEList<?>)getSubject()).basicRemove(otherEnd, msgs);
			case HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
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
			case HTPackage.TPRESENTATION_ELEMENTS__NAME:
				return getName();
			case HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS:
				return getPresentationParameters();
			case HTPackage.TPRESENTATION_ELEMENTS__SUBJECT:
				return getSubject();
			case HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION:
				return getDescription();
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
			case HTPackage.TPRESENTATION_ELEMENTS__NAME:
				getName().clear();
				getName().addAll((Collection<? extends TText>)newValue);
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS:
				setPresentationParameters((TPresentationParameters)newValue);
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__SUBJECT:
				getSubject().clear();
				getSubject().addAll((Collection<? extends TText>)newValue);
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends TDescription>)newValue);
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
			case HTPackage.TPRESENTATION_ELEMENTS__NAME:
				getName().clear();
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS:
				setPresentationParameters((TPresentationParameters)null);
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__SUBJECT:
				getSubject().clear();
				return;
			case HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION:
				getDescription().clear();
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
			case HTPackage.TPRESENTATION_ELEMENTS__NAME:
				return name != null && !name.isEmpty();
			case HTPackage.TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS:
				return presentationParameters != null;
			case HTPackage.TPRESENTATION_ELEMENTS__SUBJECT:
				return subject != null && !subject.isEmpty();
			case HTPackage.TPRESENTATION_ELEMENTS__DESCRIPTION:
				return description != null && !description.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TPresentationElementsImpl
