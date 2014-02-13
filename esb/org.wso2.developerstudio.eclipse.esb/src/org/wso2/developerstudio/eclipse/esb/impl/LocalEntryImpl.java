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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.esb.LocalEntryValueType;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LocalEntryImpl#getEntryName <em>Entry Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LocalEntryImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LocalEntryImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LocalEntryImpl#getValueXML <em>Value XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LocalEntryImpl#getValueURL <em>Value URL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalEntryImpl extends ConfigurationElementImpl implements LocalEntry {
	/**
	 * The default value of the '{@link #getEntryName() <em>Entry Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_NAME_EDEFAULT = "entry_name";

	/**
	 * The cached value of the '{@link #getEntryName() <em>Entry Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryName()
	 * @generated
	 * @ordered
	 */
	protected String entryName = ENTRY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected static final LocalEntryValueType VALUE_TYPE_EDEFAULT = LocalEntryValueType.LITERAL;

	/**
	 * The cached value of the '{@link #getValueType() <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueType()
	 * @generated
	 * @ordered
	 */
	protected LocalEntryValueType valueType = VALUE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "entry_value";

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
	 * The default value of the '{@link #getValueXML() <em>Value XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueXML()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_XML_EDEFAULT = "<value/>";

	/**
	 * The cached value of the '{@link #getValueXML() <em>Value XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueXML()
	 * @generated
	 * @ordered
	 */
	protected String valueXML = VALUE_XML_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueURL() <em>Value URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueURL()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_URL_EDEFAULT = "file:/path/to/resource.ext";

	/**
	 * The cached value of the '{@link #getValueURL() <em>Value URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueURL()
	 * @generated
	 * @ordered
	 */
	protected String valueURL = VALUE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalEntryImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Entry name.
		if (self.hasAttribute("key")) {
			setEntryName(self.getAttribute("key"));
		} else {
			throw new Exception("Expected local entry name.");
		}
		
		// Entry value.
		if (self.hasAttribute("src")) {			
			setValueURL(self.getAttribute("src"));
			setValueType(LocalEntryValueType.URL);
		} else {
			List<Element> children = getChildElements(self);
			if (!children.isEmpty()) {
				// Question: is it possible to have multiple child elements here?
				setValueXML(EsbUtils.renderElement(children.get(0), true));
				setValueType(LocalEntryValueType.XML);
			} else if (null != self.getTextContent()) {
				setValueLiteral(self.getTextContent());
				setValueType(LocalEntryValueType.LITERAL);
			}
		}	
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "localEntry");
		self.setAttribute("key", getEntryName());
		
		switch (getValueType()) {
			case LITERAL: {
				self.setTextContent(getValueLiteral());
				break;
			}
			
			case URL: {
				self.setAttribute("src", getValueURL());
				break;
			}
			
			case XML: {
				try {
					Element xmlElem = EsbUtils.parseElement(getValueXML());
					xmlElem = (Element) self.getOwnerDocument().importNode(xmlElem, true);
					self.appendChild(xmlElem);
				} catch (Exception ex) {
					// TODO: Log.
					createChildElement(self, "value");
					setValueXML(VALUE_XML_EDEFAULT);
				}				
			}
		}
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.LOCAL_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryName() {
		return entryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryName(String newEntryName) {
		String oldEntryName = entryName;
		entryName = newEntryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__ENTRY_NAME, oldEntryName, entryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntryValueType getValueType() {
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(LocalEntryValueType newValueType) {
		LocalEntryValueType oldValueType = valueType;
		valueType = newValueType == null ? VALUE_TYPE_EDEFAULT : newValueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_TYPE, oldValueType, valueType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_LITERAL, oldValueLiteral, valueLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueXML() {
		return valueXML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueXML(String newValueXML) {
		String oldValueXML = valueXML;
		valueXML = newValueXML;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_XML, oldValueXML, valueXML));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueURL() {
		return valueURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueURL(String newValueURL) {
		String oldValueURL = valueURL;
		valueURL = newValueURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_URL, oldValueURL, valueURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				return getEntryName();
			case EsbPackage.LOCAL_ENTRY__VALUE_TYPE:
				return getValueType();
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				return getValueXML();
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				return getValueURL();
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				setEntryName((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_TYPE:
				setValueType((LocalEntryValueType)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				setValueXML((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				setValueURL((String)newValue);
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				setEntryName(ENTRY_NAME_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_TYPE:
				setValueType(VALUE_TYPE_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				setValueXML(VALUE_XML_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				setValueURL(VALUE_URL_EDEFAULT);
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				return ENTRY_NAME_EDEFAULT == null ? entryName != null : !ENTRY_NAME_EDEFAULT.equals(entryName);
			case EsbPackage.LOCAL_ENTRY__VALUE_TYPE:
				return valueType != VALUE_TYPE_EDEFAULT;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				return VALUE_XML_EDEFAULT == null ? valueXML != null : !VALUE_XML_EDEFAULT.equals(valueXML);
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				return VALUE_URL_EDEFAULT == null ? valueURL != null : !VALUE_URL_EDEFAULT.equals(valueURL);
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
		result.append(" (entryName: ");
		result.append(entryName);
		result.append(", valueType: ");
		result.append(valueType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(", valueXML: ");
		result.append(valueXML);
		result.append(", valueURL: ");
		result.append(valueURL);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
		ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
    	if(null==getEntryName() || getEntryName().trim().isEmpty()){
    		validateMap.put("key", "key is empty");
    	}
		switch (getValueType()) {
			case LITERAL: {
				if(null==getValueLiteral() || getValueLiteral().trim().isEmpty()){
		    		validateMap.put("Value", "Value is empty");
		    	}
				break;
			}
			case URL: {
				if(null==getValueURL() || getValueURL().trim().isEmpty()){
		    		validateMap.put("URL", "URL is empty");
		    		//TODO: validate URL
		    	}
				break;
			}
			case XML: {
				try {
					Element xmlElem = EsbUtils.parseElement(getValueXML());
				} catch (Exception ex) {
					validateMap.put("ValueXML", "Invalid ValueXML");
				}				
			}
    	
		}
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Local Entry", objectValidator);
	    return mediatorValidateMap;
    }

} //LocalEntryImpl
