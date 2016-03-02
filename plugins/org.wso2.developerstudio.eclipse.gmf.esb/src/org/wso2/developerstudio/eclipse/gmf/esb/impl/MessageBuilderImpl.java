/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Builder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageBuilderImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageBuilderImpl#getBuilderClass <em>Builder Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.MessageBuilderImpl#getFormatterClass <em>Formatter Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageBuilderImpl extends EsbNodeImpl implements MessageBuilder {
	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected String contentType = CONTENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBuilderClass() <em>Builder Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilderClass()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILDER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuilderClass() <em>Builder Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilderClass()
	 * @generated
	 * @ordered
	 */
	protected String builderClass = BUILDER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormatterClass() <em>Formatter Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatterClass()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMATTER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormatterClass() <em>Formatter Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatterClass()
	 * @generated
	 * @ordered
	 */
	protected String formatterClass = FORMATTER_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageBuilderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MESSAGE_BUILDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentType(String newContentType) {
		String oldContentType = contentType;
		contentType = newContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_BUILDER__CONTENT_TYPE, oldContentType, contentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBuilderClass() {
		return builderClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuilderClass(String newBuilderClass) {
		String oldBuilderClass = builderClass;
		builderClass = newBuilderClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_BUILDER__BUILDER_CLASS, oldBuilderClass, builderClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormatterClass() {
		return formatterClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatterClass(String newFormatterClass) {
		String oldFormatterClass = formatterClass;
		formatterClass = newFormatterClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MESSAGE_BUILDER__FORMATTER_CLASS, oldFormatterClass, formatterClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				return getContentType();
			case EsbPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				return getBuilderClass();
			case EsbPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
				return getFormatterClass();
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
			case EsbPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				setContentType((String)newValue);
				return;
			case EsbPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				setBuilderClass((String)newValue);
				return;
			case EsbPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
				setFormatterClass((String)newValue);
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
			case EsbPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				setBuilderClass(BUILDER_CLASS_EDEFAULT);
				return;
			case EsbPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
				setFormatterClass(FORMATTER_CLASS_EDEFAULT);
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
			case EsbPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
			case EsbPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				return BUILDER_CLASS_EDEFAULT == null ? builderClass != null : !BUILDER_CLASS_EDEFAULT.equals(builderClass);
			case EsbPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
				return FORMATTER_CLASS_EDEFAULT == null ? formatterClass != null : !FORMATTER_CLASS_EDEFAULT.equals(formatterClass);
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
		result.append(" (contentType: ");
		result.append(contentType);
		result.append(", builderClass: ");
		result.append(builderClass);
		result.append(", formatterClass: ");
		result.append(formatterClass);
		result.append(')');
		return result.toString();
	}

} //MessageBuilderImpl
