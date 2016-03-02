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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getValueContextPropertyName <em>Value Context Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getValueMessageElementXpath <em>Value Message Element Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getContextAction <em>Context Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CommandPropertyImpl#getMessageAction <em>Message Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandPropertyImpl extends EObjectImpl implements CommandProperty {
	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = "property_name";

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final CommandPropertyValueType VALUE_TYPE_EDEFAULT = CommandPropertyValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected CommandPropertyValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "literal_value";

	/**
	 * The cached value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected String valueLiteral = VALUE_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueContextPropertyName() <em>Value Context Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueContextPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_CONTEXT_PROPERTY_NAME_EDEFAULT = "context_property_name";

	/**
	 * The cached value of the '{@link #getValueContextPropertyName() <em>Value Context Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueContextPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String valueContextPropertyName = VALUE_CONTEXT_PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueMessageElementXpath() <em>Value Message Element Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueMessageElementXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty valueMessageElementXpath;

	/**
	 * The default value of the '{@link #getContextAction() <em>Context Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextAction()
	 * @generated
	 * @ordered
	 */
	protected static final CommandPropertyContextAction CONTEXT_ACTION_EDEFAULT = CommandPropertyContextAction.READ_CONTEXT;

	/**
	 * The cached value of the '{@link #getContextAction() <em>Context Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextAction()
	 * @generated
	 * @ordered
	 */
	protected CommandPropertyContextAction contextAction = CONTEXT_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageAction() <em>Message Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageAction()
	 * @generated
	 * @ordered
	 */
	protected static final CommandPropertyMessageAction MESSAGE_ACTION_EDEFAULT = CommandPropertyMessageAction.READ_MESSAGE;

	/**
	 * The cached value of the '{@link #getMessageAction() <em>Message Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageAction()
	 * @generated
	 * @ordered
	 */
	protected CommandPropertyMessageAction messageAction = MESSAGE_ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.COMMAND_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(CommandPropertyValueType newValueType) {
		CommandPropertyValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__VALUE_TYPE, oldValueType, valueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueLiteral() {
		return valueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueLiteral(String newValueLiteral) {
		String oldValueLiteral = valueLiteral;
		valueLiteral = newValueLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__VALUE_LITERAL, oldValueLiteral, valueLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueContextPropertyName() {
		return valueContextPropertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueContextPropertyName(String newValueContextPropertyName) {
		String oldValueContextPropertyName = valueContextPropertyName;
		valueContextPropertyName = newValueContextPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME, oldValueContextPropertyName, valueContextPropertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getValueMessageElementXpath() {
		return valueMessageElementXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueMessageElementXpath(NamespacedProperty newValueMessageElementXpath, NotificationChain msgs) {
		NamespacedProperty oldValueMessageElementXpath = valueMessageElementXpath;
		valueMessageElementXpath = newValueMessageElementXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH, oldValueMessageElementXpath, newValueMessageElementXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueMessageElementXpath(NamespacedProperty newValueMessageElementXpath) {
		if (newValueMessageElementXpath != valueMessageElementXpath) {
			NotificationChain msgs = null;
			if (valueMessageElementXpath != null)
				msgs = ((InternalEObject)valueMessageElementXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH, null, msgs);
			if (newValueMessageElementXpath != null)
				msgs = ((InternalEObject)newValueMessageElementXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH, null, msgs);
			msgs = basicSetValueMessageElementXpath(newValueMessageElementXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH, newValueMessageElementXpath, newValueMessageElementXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyContextAction getContextAction() {
		return contextAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextAction(CommandPropertyContextAction newContextAction) {
		CommandPropertyContextAction oldContextAction = contextAction;
		contextAction = newContextAction == null ? CONTEXT_ACTION_EDEFAULT : newContextAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__CONTEXT_ACTION, oldContextAction, contextAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyMessageAction getMessageAction() {
		return messageAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageAction(CommandPropertyMessageAction newMessageAction) {
		CommandPropertyMessageAction oldMessageAction = messageAction;
		messageAction = newMessageAction == null ? MESSAGE_ACTION_EDEFAULT : newMessageAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.COMMAND_PROPERTY__MESSAGE_ACTION, oldMessageAction, messageAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH:
				return basicSetValueMessageElementXpath(null, msgs);
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
			case EsbPackage.COMMAND_PROPERTY__PROPERTY_NAME:
				return getPropertyName();
			case EsbPackage.COMMAND_PROPERTY__VALUE_TYPE:
				return getValueType();
			case EsbPackage.COMMAND_PROPERTY__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME:
				return getValueContextPropertyName();
			case EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH:
				return getValueMessageElementXpath();
			case EsbPackage.COMMAND_PROPERTY__CONTEXT_ACTION:
				return getContextAction();
			case EsbPackage.COMMAND_PROPERTY__MESSAGE_ACTION:
				return getMessageAction();
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
			case EsbPackage.COMMAND_PROPERTY__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_TYPE:
				setValueType((CommandPropertyValueType)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME:
				setValueContextPropertyName((String)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH:
				setValueMessageElementXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__CONTEXT_ACTION:
				setContextAction((CommandPropertyContextAction)newValue);
				return;
			case EsbPackage.COMMAND_PROPERTY__MESSAGE_ACTION:
				setMessageAction((CommandPropertyMessageAction)newValue);
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
			case EsbPackage.COMMAND_PROPERTY__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME:
				setValueContextPropertyName(VALUE_CONTEXT_PROPERTY_NAME_EDEFAULT);
				return;
			case EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH:
				setValueMessageElementXpath((NamespacedProperty)null);
				return;
			case EsbPackage.COMMAND_PROPERTY__CONTEXT_ACTION:
				setContextAction(CONTEXT_ACTION_EDEFAULT);
				return;
			case EsbPackage.COMMAND_PROPERTY__MESSAGE_ACTION:
				setMessageAction(MESSAGE_ACTION_EDEFAULT);
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
			case EsbPackage.COMMAND_PROPERTY__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case EsbPackage.COMMAND_PROPERTY__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.COMMAND_PROPERTY__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME:
				return VALUE_CONTEXT_PROPERTY_NAME_EDEFAULT == null ? valueContextPropertyName != null : !VALUE_CONTEXT_PROPERTY_NAME_EDEFAULT.equals(valueContextPropertyName);
			case EsbPackage.COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH:
				return valueMessageElementXpath != null;
			case EsbPackage.COMMAND_PROPERTY__CONTEXT_ACTION:
				return contextAction != CONTEXT_ACTION_EDEFAULT;
			case EsbPackage.COMMAND_PROPERTY__MESSAGE_ACTION:
				return messageAction != MESSAGE_ACTION_EDEFAULT;
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(", valueContextPropertyName: ");
		result.append(valueContextPropertyName);
		result.append(", contextAction: ");
		result.append(contextAction);
		result.append(", messageAction: ");
		result.append(messageAction);
		result.append(')');
		return result.toString();
	}

} //CommandPropertyImpl
