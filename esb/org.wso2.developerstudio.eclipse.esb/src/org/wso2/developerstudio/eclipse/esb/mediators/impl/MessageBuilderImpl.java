/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Builder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl#getBuilderClass <em>Builder Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl#getFormatterClass <em>Formatter Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageBuilderImpl extends ModelObjectImpl implements MessageBuilder {
	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_EDEFAULT = "application/xml";

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
	protected static final String BUILDER_CLASS_EDEFAULT = "org.apache.axis2.builder.ApplicationXMLBuilder";

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
	protected static final String FORMATTER_CLASS_EDEFAULT = "org.apache.axis2.transport.http.ApplicationXMLFormatter";

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
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Content type.
		if (self.hasAttribute("contentType")) {
			setContentType(self.getAttribute("contentType"));
		} else {
			throw new Exception("Missing message builder content type.");
		}
		
		// Builder class.
		if (self.hasAttribute("class")) {
			setBuilderClass(self.getAttribute("class"));
		} else {
			throw new Exception("Missing message builder class.");
		}
		
		// Formatter class.
		if (self.hasAttribute("formatterClass")) {
			setFormatterClass(self.getAttribute("formatterClass"));
		} else {
			setFormatterClass(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "messageBuilder");
		self.setAttribute("contentType", getContentType());
		self.setAttribute("class", getBuilderClass());
		if (!StringUtils.isBlank(getFormatterClass())) {
			self.setAttribute("formatterClass", getFormatterClass());
		}
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.MESSAGE_BUILDER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.MESSAGE_BUILDER__CONTENT_TYPE, oldContentType, contentType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.MESSAGE_BUILDER__BUILDER_CLASS, oldBuilderClass, builderClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.MESSAGE_BUILDER__FORMATTER_CLASS, oldFormatterClass, formatterClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MediatorsPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				return getContentType();
			case MediatorsPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				return getBuilderClass();
			case MediatorsPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
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
			case MediatorsPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				setContentType((String)newValue);
				return;
			case MediatorsPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				setBuilderClass((String)newValue);
				return;
			case MediatorsPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
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
			case MediatorsPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				setBuilderClass(BUILDER_CLASS_EDEFAULT);
				return;
			case MediatorsPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
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
			case MediatorsPackage.MESSAGE_BUILDER__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
			case MediatorsPackage.MESSAGE_BUILDER__BUILDER_CLASS:
				return BUILDER_CLASS_EDEFAULT == null ? builderClass != null : !BUILDER_CLASS_EDEFAULT.equals(builderClass);
			case MediatorsPackage.MESSAGE_BUILDER__FORMATTER_CLASS:
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

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		if (null == getContentType() || getContentType().trim().isEmpty()) {
			validateMap.put("contentType","contentType is empty");
		}
		if (null == getBuilderClass() || getBuilderClass().trim().isEmpty()) {
			validateMap.put("BuilderClass","BuilderClass is empty");
		}
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("Builder Mediator - MessageBuilder", objectValidator);
 	    return mediatorValidateMap;
    }

} //MessageBuilderImpl
