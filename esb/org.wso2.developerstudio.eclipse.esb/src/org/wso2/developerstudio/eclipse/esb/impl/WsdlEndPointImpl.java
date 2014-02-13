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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EndPointWsdlType;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.WsdlEndPoint;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wsdl End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.WsdlEndPointImpl#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.WsdlEndPointImpl#getWsdlURI <em>Wsdl URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.WsdlEndPointImpl#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.WsdlEndPointImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.WsdlEndPointImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WsdlEndPointImpl extends AbstractEndPointImpl implements WsdlEndPoint {
    /**
	 * The default value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
    protected static final EndPointWsdlType WSDL_TYPE_EDEFAULT = EndPointWsdlType.URI;

    /**
	 * The cached value of the '{@link #getWsdlType() <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getWsdlType()
	 * @generated
	 * @ordered
	 */
    protected EndPointWsdlType wsdlType = WSDL_TYPE_EDEFAULT;

    /**
	 * The default value of the '{@link #getWsdlURI() <em>Wsdl URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getWsdlURI()
	 * @generated
	 * @ordered
	 */
    protected static final String WSDL_URI_EDEFAULT = "http://default/wsdl/uri";

    /**
	 * The cached value of the '{@link #getWsdlURI() <em>Wsdl URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getWsdlURI()
	 * @generated
	 * @ordered
	 */
    protected String wsdlURI = WSDL_URI_EDEFAULT;

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
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
    protected static final String SERVICE_EDEFAULT = "Service";

    /**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
    protected String service = SERVICE_EDEFAULT;

    /**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
    protected static final String PORT_EDEFAULT = "Port";

    /**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
    protected String port = PORT_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 */
    protected WsdlEndPointImpl() {
		super();
		
		// Reliable messaging policy key.
		RegistryKeyProperty regPropertyRMPolicy = getEsbFactory().createRegistryKeyProperty();
		regPropertyRMPolicy.setPrettyName("Select RM Policy");
		regPropertyRMPolicy.setKeyName("policy");
		setReliableMessagingPolicy(regPropertyRMPolicy);

		// Security policy key.
		RegistryKeyProperty regPropertySecurityPolicy = getEsbFactory().createRegistryKeyProperty();
		regPropertySecurityPolicy.setPrettyName("Select Security Policy");
		regPropertySecurityPolicy.setKeyName("policy");
		setSecurityPolicy(regPropertySecurityPolicy);
	}

    /**
     * {@inheritDoc}
     */
    public void doLoad(Element self) throws Exception {
	    super.doLoad(self);
	    
	    // Get the <wsdl/> element.
	    Element wsdlElem = getChildElement(self, "wsdl");
	    
	    // WSDL.
	    if (wsdlElem.hasAttribute("uri")) {
	    	setWsdlType(EndPointWsdlType.URI);
	    	setWsdlURI(wsdlElem.getAttribute("uri"));
	    } else {
	    	setWsdlType(EndPointWsdlType.INLINE);
	    	
	    	// TODO: This needs to be improved in future.
	    	Element definitionsElem = getChildElement(wsdlElem, "definitions");
	    	if (null != definitionsElem) {
	    		setWsdlXML(EsbUtils.renderElement(definitionsElem, true));
	    	}
	    }
	    
	    // Service.
	    setService(wsdlElem.getAttribute("service"));
	    
	    // Port.
	    if (wsdlElem.hasAttribute("endpoint")) {
	    	setPort(wsdlElem.getAttribute("endpoint"));
	    } else {
	    	setPort(wsdlElem.getAttribute("port"));
	    }
	    
	    // Delegate.
	    loadContent(wsdlElem);
    }

    /**
     * {@inheritDoc}
     */
    public Element doSave(Element parent) throws Exception {
		Element self = super.doSave(parent);
		
	    // Create <wsdl/> element.
	    Element wsdlElem = createChildElement(self, "wsdl");
	    
	    // WSDL.
	    if (getWsdlType().equals(EndPointWsdlType.URI)) {
	    	wsdlElem.setAttribute("uri", getWsdlURI());
	    } else {
	    	// TODO: This needs to be improved in future.
	    	Element definitionsElem = null;
	    	try {
	    		definitionsElem = EsbUtils.parseElement(getWsdlXML());
	    		definitionsElem = (Element) wsdlElem.getOwnerDocument().importNode(definitionsElem, true);
	    		wsdlElem.appendChild(definitionsElem);
	    	} catch (Exception ex) {
	    		definitionsElem = createChildElement(wsdlElem, "definitions");
	    		setWsdlXML(WSDL_XML_EDEFAULT);
	    	}	    		    	
	    }
	    
	    // Service.
	    wsdlElem.setAttribute("service", getService());
	    
	    // Port.
	    wsdlElem.setAttribute("port", getPort());
	    
	    // Delegate.
	    storeContent(wsdlElem);
	    
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
		return EsbPackage.Literals.WSDL_END_POINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndPointWsdlType getWsdlType() {
		return wsdlType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setWsdlType(EndPointWsdlType newWsdlType) {
		EndPointWsdlType oldWsdlType = wsdlType;
		wsdlType = newWsdlType == null ? WSDL_TYPE_EDEFAULT : newWsdlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.WSDL_END_POINT__WSDL_TYPE, oldWsdlType, wsdlType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getWsdlURI() {
		return wsdlURI;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setWsdlURI(String newWsdlURI) {
		String oldWsdlURI = wsdlURI;
		wsdlURI = newWsdlURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.WSDL_END_POINT__WSDL_URI, oldWsdlURI, wsdlURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.WSDL_END_POINT__WSDL_XML, oldWsdlXML, wsdlXML));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getService() {
		return service;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setService(String newService) {
		String oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.WSDL_END_POINT__SERVICE, oldService, service));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getPort() {
		return port;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.WSDL_END_POINT__PORT, oldPort, port));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.WSDL_END_POINT__WSDL_TYPE:
				return getWsdlType();
			case EsbPackage.WSDL_END_POINT__WSDL_URI:
				return getWsdlURI();
			case EsbPackage.WSDL_END_POINT__WSDL_XML:
				return getWsdlXML();
			case EsbPackage.WSDL_END_POINT__SERVICE:
				return getService();
			case EsbPackage.WSDL_END_POINT__PORT:
				return getPort();
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
			case EsbPackage.WSDL_END_POINT__WSDL_TYPE:
				setWsdlType((EndPointWsdlType)newValue);
				return;
			case EsbPackage.WSDL_END_POINT__WSDL_URI:
				setWsdlURI((String)newValue);
				return;
			case EsbPackage.WSDL_END_POINT__WSDL_XML:
				setWsdlXML((String)newValue);
				return;
			case EsbPackage.WSDL_END_POINT__SERVICE:
				setService((String)newValue);
				return;
			case EsbPackage.WSDL_END_POINT__PORT:
				setPort((String)newValue);
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
			case EsbPackage.WSDL_END_POINT__WSDL_TYPE:
				setWsdlType(WSDL_TYPE_EDEFAULT);
				return;
			case EsbPackage.WSDL_END_POINT__WSDL_URI:
				setWsdlURI(WSDL_URI_EDEFAULT);
				return;
			case EsbPackage.WSDL_END_POINT__WSDL_XML:
				setWsdlXML(WSDL_XML_EDEFAULT);
				return;
			case EsbPackage.WSDL_END_POINT__SERVICE:
				setService(SERVICE_EDEFAULT);
				return;
			case EsbPackage.WSDL_END_POINT__PORT:
				setPort(PORT_EDEFAULT);
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
			case EsbPackage.WSDL_END_POINT__WSDL_TYPE:
				return wsdlType != WSDL_TYPE_EDEFAULT;
			case EsbPackage.WSDL_END_POINT__WSDL_URI:
				return WSDL_URI_EDEFAULT == null ? wsdlURI != null : !WSDL_URI_EDEFAULT.equals(wsdlURI);
			case EsbPackage.WSDL_END_POINT__WSDL_XML:
				return WSDL_XML_EDEFAULT == null ? wsdlXML != null : !WSDL_XML_EDEFAULT.equals(wsdlXML);
			case EsbPackage.WSDL_END_POINT__SERVICE:
				return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
			case EsbPackage.WSDL_END_POINT__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
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
		result.append(", wsdlURI: ");
		result.append(wsdlURI);
		result.append(", wsdlXML: ");
		result.append(wsdlXML);
		result.append(", service: ");
		result.append(service);
		result.append(", port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		 if (getWsdlType().equals(EndPointWsdlType.URI)) {
			 if (null == getWsdlURI() || getWsdlURI().trim().isEmpty()) {
					validateMap.put("WSDL URI","WSDL URI is empty");
				} 
		    } else {
		    	try {
		    		Element definitionsElem = EsbUtils.parseElement(getWsdlXML());
		    	} catch (Exception ex) {
		    		validateMap.put("WSDL XML","WSDL XML, must be valid xml");
		    	}	    		    	
		    }
		
		if (null == getService() || getService().trim().isEmpty()) {
			validateMap.put("Service","Service is empty");
		}
		if (null == getPort() || getPort().trim().isEmpty()) {
			validateMap.put("URI","URI is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("WSDL EndPoint", objectValidator);
	    return mediatorValidateMap;
    }

} //WsdlEndPointImpl
