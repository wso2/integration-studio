/**
 * <copyright>
 * </copyright>
 *
 * $Id: ToPartImpl.java,v 1.12 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.wsdl.Output;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.proxy.PartProxy;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ToPartImpl#getFromVariable <em>From Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToPartImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToPartImpl extends BPELExtensibleElementImpl implements ToPart {
	/**
	 * The cached value of the '{@link #getFromVariable() <em>From Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable fromVariable;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected Part part;

	/**
	 * The deserialized value of the part name.
	 * @customized
	 */
	protected String partName = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.TO_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getFromVariable() {
		if (fromVariable != null && fromVariable.eIsProxy()) {
			InternalEObject oldFromVariable = (InternalEObject) fromVariable;
			fromVariable = (Variable) eResolveProxy(oldFromVariable);
			if (fromVariable != oldFromVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO_PART__FROM_VARIABLE,
							oldFromVariable, fromVariable));
			}
		}
		return fromVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetFromVariable() {
		return fromVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFromVariable(Variable newFromVariable) {
		Variable oldFromVariable = fromVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_FROM_VARIABLE,
					newFromVariable == null ? null : newFromVariable.getName());
		}
		fromVariable = newFromVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO_PART__FROM_VARIABLE, oldFromVariable,
					fromVariable));
	}

	/**
	 * Customizes {@link #getPartGen()} to lazy-resolve the part name.
	 * @customized
	 */
	public Part getPart() {
		if (part == null && partName != null) {
			EObject container = this.eContainer;
			if (container != null && container instanceof ToParts) {
				ToParts toParts = (ToParts) container;
				container = toParts.eContainer();
				if (container != null && container instanceof PartnerActivity) {
					PartnerActivity partnerActivity = (PartnerActivity) container;
					if (partnerActivity != null) {
						Operation operation = partnerActivity.getOperation();
						if (operation != null) {
							Output output = operation.getOutput();
							if (output != null) {
								javax.wsdl.Message message = output
										.getMessage();
								if (message != null) {
									// Create an part proxy with the
									// deserialized part name.
									part = new PartProxy(eResource(),
											(Message) message, partName);
									partName = null;
								}
							}
						}
					}
				}
			}
		}
		return getPartGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getPartGen() {
		if (part != null && part.eIsProxy()) {
			InternalEObject oldPart = (InternalEObject) part;
			part = (Part) eResolveProxy(oldPart);
			if (part != oldPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO_PART__PART, oldPart, part));
			}
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetPart() {
		return part;
	}

	/**
	 * Set the deserialized value of the part name.
	 * @customized
	 */
	public void setPartName(String newPartName) {

		partName = newPartName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPart(Part newPart) {
		Part oldPart = part;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_PART,
					newPart == null ? null : newPart.getName());
		}
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO_PART__PART, oldPart, part));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.TO_PART__FROM_VARIABLE:
			if (resolve)
				return getFromVariable();
			return basicGetFromVariable();
		case BPELPackage.TO_PART__PART:
			if (resolve)
				return getPart();
			return basicGetPart();
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
		case BPELPackage.TO_PART__FROM_VARIABLE:
			setFromVariable((Variable) newValue);
			return;
		case BPELPackage.TO_PART__PART:
			setPart((Part) newValue);
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
		case BPELPackage.TO_PART__FROM_VARIABLE:
			setFromVariable((Variable) null);
			return;
		case BPELPackage.TO_PART__PART:
			setPart((Part) null);
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
		case BPELPackage.TO_PART__FROM_VARIABLE:
			return fromVariable != null;
		case BPELPackage.TO_PART__PART:
			return part != null;
		}
		return super.eIsSet(featureID);
	}

} //ToPartImpl
