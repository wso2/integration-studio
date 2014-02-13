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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlResource;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Wsdl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyWsdlConfigurationImpl#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyWsdlConfigurationImpl#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyWsdlConfigurationImpl#getWsdlURL <em>Wsdl URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyWsdlConfigurationImpl#getWsdlKey <em>Wsdl Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ProxyWsdlConfigurationImpl#getWsdlResources <em>Wsdl Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyWsdlConfigurationImpl extends ModelObjectImpl implements ProxyWsdlConfiguration {
	/**
	 * The default value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
	protected static final ProxyWsdlType WSDL_TYPE_EDEFAULT = ProxyWsdlType.NONE;
	/**
	 * The cached value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
	protected ProxyWsdlType wsdlType = WSDL_TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getWsdlXML() <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlXML()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_XML_EDEFAULT = "<definitions/>";
	/**
	 * The cached value of the '{@link #getWsdlXML() <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlXML()
	 * @generated
	 * @ordered
	 */
	protected String wsdlXML = WSDL_XML_EDEFAULT;
	/**
	 * The default value of the '{@link #getWsdlURL() <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlURL()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_URL_EDEFAULT = "http://default/wsdl/url";
	/**
	 * The cached value of the '{@link #getWsdlURL() <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlURL()
	 * @generated
	 * @ordered
	 */
	protected String wsdlURL = WSDL_URL_EDEFAULT;
	/**
	 * The cached value of the '{@link #getWsdlKey() <em>Wsdl Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty wsdlKey;
	/**
	 * The cached value of the '{@link #getWsdlResources() <em>Wsdl Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ProxyWsdlResource> wsdlResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ProxyWsdlConfigurationImpl() {
		super();
		
		// WSDL Key.
		RegistryKeyProperty wsdlKey = getEsbFactory().createRegistryKeyProperty();
		//Set filter properties to filter in only wsdl media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)wsdlKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_WSDL);

		wsdlKey.setPrettyName("WSDL Reference");
		wsdlKey.setKeyName("key");
		wsdlKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setWsdlKey(wsdlKey);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean hasSourceRepresentation() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		Element publishWsdlElem = getChildElement(self, "publishWSDL");
		if (null != publishWsdlElem) {
			Element wsdlElem = getChildElement(publishWsdlElem, "definitions");
			if (null != wsdlElem) {
				setWsdlType(ProxyWsdlType.INLINE);
				setWsdlXML(EsbUtils.renderElement(wsdlElem, true));				
			} else if (publishWsdlElem.hasAttribute("uri")) {
				setWsdlType(ProxyWsdlType.SOURCE_URL);
				setWsdlURL(publishWsdlElem.getAttribute("uri"));
			} else if (publishWsdlElem.hasAttribute("key")) {
				setWsdlType(ProxyWsdlType.REGISTRY_KEY);
				getWsdlKey().load(publishWsdlElem);
			} else {
				throw new Exception("Un-supported publish wsdl definition.");
			}
			
			// WSDL Resources.
			loadObjects(publishWsdlElem, "resource", ProxyWsdlResource.class, new ObjectHandler<ProxyWsdlResource>() {
				public void handle(ProxyWsdlResource object) {
					getWsdlResources().add(object);
				}
			});
			super.doLoad(publishWsdlElem);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		if (!getWsdlType().equals(ProxyWsdlType.NONE)) {
			Element publishWsdlElem = createChildElement(parent, "publishWSDL");
			switch (getWsdlType()) {
				case INLINE: {
					// TODO: This needs to be improved in future.
					Element definitionsElem = null;
					try {
						definitionsElem = EsbUtils.parseElement(getWsdlXML());
						definitionsElem = (Element) publishWsdlElem.getOwnerDocument().
							importNode(definitionsElem, true);
						publishWsdlElem.appendChild(definitionsElem);
					} catch (Exception ex) {
						definitionsElem = createChildElement(publishWsdlElem, "definitions");
						setWsdlXML(WSDL_XML_EDEFAULT);
					}
					break;
				}

				case SOURCE_URL: {
					publishWsdlElem.setAttribute("uri", getWsdlURL());
					break;
				}
				
				case REGISTRY_KEY: {
					getWsdlKey().save(publishWsdlElem);
					break;
				}
			}
			
			// Save wsdl resources.
			for (ProxyWsdlResource resource : getWsdlResources()) {
				resource.save(publishWsdlElem);
			}
			
			addComments(publishWsdlElem);
			return publishWsdlElem;
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_WSDL_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWsdlType getWsdlType() {
		return wsdlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlType(ProxyWsdlType newWsdlType) {
		ProxyWsdlType oldWsdlType = wsdlType;
		wsdlType = newWsdlType == null ? WSDL_TYPE_EDEFAULT : newWsdlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_TYPE, oldWsdlType, wsdlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlXML() {
		return wsdlXML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlXML(String newWsdlXML) {
		String oldWsdlXML = wsdlXML;
		wsdlXML = newWsdlXML;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_XML, oldWsdlXML, wsdlXML));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlURL() {
		return wsdlURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlURL(String newWsdlURL) {
		String oldWsdlURL = wsdlURL;
		wsdlURL = newWsdlURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_URL, oldWsdlURL, wsdlURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getWsdlKey() {
		return wsdlKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWsdlKey(RegistryKeyProperty newWsdlKey, NotificationChain msgs) {
		RegistryKeyProperty oldWsdlKey = wsdlKey;
		wsdlKey = newWsdlKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY, oldWsdlKey, newWsdlKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlKey(RegistryKeyProperty newWsdlKey) {
		if (newWsdlKey != wsdlKey) {
			NotificationChain msgs = null;
			if (wsdlKey != null)
				msgs = ((InternalEObject)wsdlKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY, null, msgs);
			if (newWsdlKey != null)
				msgs = ((InternalEObject)newWsdlKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY, null, msgs);
			msgs = basicSetWsdlKey(newWsdlKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY, newWsdlKey, newWsdlKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProxyWsdlResource> getWsdlResources() {
		if (wsdlResources == null) {
			wsdlResources = new EObjectContainmentEList<ProxyWsdlResource>(ProxyWsdlResource.class, this, EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES);
		}
		return wsdlResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY:
				return basicSetWsdlKey(null, msgs);
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES:
				return ((InternalEList<?>)getWsdlResources()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_TYPE:
				return getWsdlType();
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_XML:
				return getWsdlXML();
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_URL:
				return getWsdlURL();
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY:
				return getWsdlKey();
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES:
				return getWsdlResources();
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
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_TYPE:
				setWsdlType((ProxyWsdlType)newValue);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_XML:
				setWsdlXML((String)newValue);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_URL:
				setWsdlURL((String)newValue);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY:
				setWsdlKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES:
				getWsdlResources().clear();
				getWsdlResources().addAll((Collection<? extends ProxyWsdlResource>)newValue);
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
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_TYPE:
				setWsdlType(WSDL_TYPE_EDEFAULT);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_XML:
				setWsdlXML(WSDL_XML_EDEFAULT);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_URL:
				setWsdlURL(WSDL_URL_EDEFAULT);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY:
				setWsdlKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES:
				getWsdlResources().clear();
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
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_TYPE:
				return wsdlType != WSDL_TYPE_EDEFAULT;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_XML:
				return WSDL_XML_EDEFAULT == null ? wsdlXML != null : !WSDL_XML_EDEFAULT.equals(wsdlXML);
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_URL:
				return WSDL_URL_EDEFAULT == null ? wsdlURL != null : !WSDL_URL_EDEFAULT.equals(wsdlURL);
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_KEY:
				return wsdlKey != null;
			case EsbPackage.PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES:
				return wsdlResources != null && !wsdlResources.isEmpty();
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
		result.append(" (wsdlType: ");
		result.append(wsdlType);
		result.append(", wsdlXML: ");
		result.append(wsdlXML);
		result.append(", wsdlURL: ");
		result.append(wsdlURL);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //ProxyWsdlImpl
