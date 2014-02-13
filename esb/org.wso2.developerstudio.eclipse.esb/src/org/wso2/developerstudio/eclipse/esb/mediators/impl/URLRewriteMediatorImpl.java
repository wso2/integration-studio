/**
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.w3c.dom.Element;
//import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl.ObjectHandler;

import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URL Rewrite Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl#getUrlRewriteRules <em>Url Rewrite Rules</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl#getInProperty <em>In Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl#getOutProperty <em>Out Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteMediatorImpl extends MediatorImpl implements URLRewriteMediator {
	/**
	 * The cached value of the '{@link #getUrlRewriteRules() <em>Url Rewrite Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlRewriteRules()
	 * @generated
	 * @ordered
	 */
	protected EList<URLRewriteRule> urlRewriteRules;

	/**
	 * The default value of the '{@link #getInProperty() <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_PROPERTY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInProperty() <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInProperty()
	 * @generated
	 * @ordered
	 */
	protected String inProperty = IN_PROPERTY_EDEFAULT;
	/**
	 * The default value of the '{@link #getOutProperty() <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String OUT_PROPERTY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOutProperty() <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutProperty()
	 * @generated
	 * @ordered
	 */
	protected String outProperty = OUT_PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URLRewriteMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		//Load In Property
		if (self.hasAttribute("inProperty")) {
			String inPropertyValue = self.getAttribute("inProperty");
			if (inPropertyValue == null) {
				inPropertyValue = "";
			}
			inPropertyValue = inPropertyValue.trim();
			setInProperty(inPropertyValue);

		} else {
			setInProperty("");
		}
		
		//Load Out Property
		if (self.hasAttribute("outProperty")) {
			String outPropertyValue = self.getAttribute("outProperty");
			if (outPropertyValue == null) {
				outPropertyValue = "";
			}
			outPropertyValue = outPropertyValue.trim();
			setOutProperty(outPropertyValue);

		} else {
			setOutProperty("");
		}
		
		loadObjects(self, "rewriterule", URLRewriteRule.class,
				new ObjectHandler<URLRewriteRule>() {
					public void handle(URLRewriteRule object) {
						getUrlRewriteRules().add(object);

					}
				});
		super.doLoad(self);
		
		
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "rewrite");
		//In Property
		if ( !StringUtils.isBlank(getInProperty())) {
			self.setAttribute("inProperty", getInProperty());
		}
		//Out Property
		if ( !StringUtils.isBlank(getOutProperty())) {
			self.setAttribute("outProperty", getOutProperty());
		}
		
		for (URLRewriteRule urlRewriteRules: getUrlRewriteRules()) {
			urlRewriteRules.save(self);
		}
		if(description!=null)
			description.save(self);
		
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
		return MediatorsPackage.Literals.URL_REWRITE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URLRewriteRule> getUrlRewriteRules() {
		if (urlRewriteRules == null) {
			urlRewriteRules = new EObjectContainmentEList<URLRewriteRule>(URLRewriteRule.class, this, MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES);
		}
		return urlRewriteRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInProperty() {
		return inProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInProperty(String newInProperty) {
		String oldInProperty = inProperty;
		inProperty = newInProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY, oldInProperty, inProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutProperty() {
		return outProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutProperty(String newOutProperty) {
		String oldOutProperty = outProperty;
		outProperty = newOutProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY, oldOutProperty, outProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return ((InternalEList<?>)getUrlRewriteRules()).basicRemove(otherEnd, msgs);
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
			case MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return getUrlRewriteRules();
			case MediatorsPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				return getInProperty();
			case MediatorsPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				return getOutProperty();
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
			case MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				getUrlRewriteRules().clear();
				getUrlRewriteRules().addAll((Collection<? extends URLRewriteRule>)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				setInProperty((String)newValue);
				return;
			case MediatorsPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				setOutProperty((String)newValue);
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
			case MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				getUrlRewriteRules().clear();
				return;
			case MediatorsPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				setInProperty(IN_PROPERTY_EDEFAULT);
				return;
			case MediatorsPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				setOutProperty(OUT_PROPERTY_EDEFAULT);
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
			case MediatorsPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return urlRewriteRules != null && !urlRewriteRules.isEmpty();
			case MediatorsPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				return IN_PROPERTY_EDEFAULT == null ? inProperty != null : !IN_PROPERTY_EDEFAULT.equals(inProperty);
			case MediatorsPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				return OUT_PROPERTY_EDEFAULT == null ? outProperty != null : !OUT_PROPERTY_EDEFAULT.equals(outProperty);
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
		result.append(" (InProperty: ");
		result.append(inProperty);
		result.append(", outProperty: ");
		result.append(outProperty);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    return new HashMap<String, ObjectValidator>();
    }

	

} //URLRewriteMediatorImpl
