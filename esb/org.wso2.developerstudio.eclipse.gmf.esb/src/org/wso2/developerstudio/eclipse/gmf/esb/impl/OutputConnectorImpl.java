/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.OutputConnectorImpl#getOutgoingLink <em>Outgoing Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.OutputConnectorImpl#getCommentMediators <em>Comment Mediators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OutputConnectorImpl extends EsbConnectorImpl implements OutputConnector {
	/**
	 * The cached value of the '{@link #getOutgoingLink() <em>Outgoing Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLink()
	 * @generated
	 * @ordered
	 */
	protected EsbLink outgoingLink;

	/**
	 * The cached value of the '{@link #getCommentMediators() <em>Comment Mediators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentMediators()
	 * @generated
	 * @ordered
	 */
	protected EList<CommentMediator> commentMediators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.OUTPUT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbLink getOutgoingLink() {
		return outgoingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingLink(EsbLink newOutgoingLink, NotificationChain msgs) {
		EsbLink oldOutgoingLink = outgoingLink;
		outgoingLink = newOutgoingLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK, oldOutgoingLink, newOutgoingLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoingLink(EsbLink newOutgoingLink) {
		if (newOutgoingLink != outgoingLink) {
			NotificationChain msgs = null;
			if (outgoingLink != null)
				msgs = ((InternalEObject)outgoingLink).eInverseRemove(this, EsbPackage.ESB_LINK__SOURCE, EsbLink.class, msgs);
			if (newOutgoingLink != null)
				msgs = ((InternalEObject)newOutgoingLink).eInverseAdd(this, EsbPackage.ESB_LINK__SOURCE, EsbLink.class, msgs);
			msgs = basicSetOutgoingLink(newOutgoingLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK, newOutgoingLink, newOutgoingLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommentMediator> getCommentMediators() {
		if (commentMediators == null) {
			commentMediators = new EObjectContainmentEList<CommentMediator>(CommentMediator.class, this, EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS);
		}
		return commentMediators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean shouldConnect(InputConnector targetEnd) {
		// By default we allow connections to any target.
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				if (outgoingLink != null)
					msgs = ((InternalEObject)outgoingLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK, null, msgs);
				return basicSetOutgoingLink((EsbLink)otherEnd, msgs);
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
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				return basicSetOutgoingLink(null, msgs);
			case EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS:
				return ((InternalEList<?>)getCommentMediators()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				return getOutgoingLink();
			case EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS:
				return getCommentMediators();
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
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				setOutgoingLink((EsbLink)newValue);
				return;
			case EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS:
				getCommentMediators().clear();
				getCommentMediators().addAll((Collection<? extends CommentMediator>)newValue);
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
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				setOutgoingLink((EsbLink)null);
				return;
			case EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS:
				getCommentMediators().clear();
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
			case EsbPackage.OUTPUT_CONNECTOR__OUTGOING_LINK:
				return outgoingLink != null;
			case EsbPackage.OUTPUT_CONNECTOR__COMMENT_MEDIATORS:
				return commentMediators != null && !commentMediators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OutputConnectorImpl
