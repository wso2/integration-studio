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
import java.util.HashMap;
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
import org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceProperty;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.DynamicLoadBalanceEndPointImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.DynamicLoadBalanceEndPointImpl#isFailoverEnabled <em>Failover Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.DynamicLoadBalanceEndPointImpl#getMembershipHandlerClass <em>Membership Handler Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.DynamicLoadBalanceEndPointImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicLoadBalanceEndPointImpl extends EndPointImpl implements DynamicLoadBalanceEndPoint {
	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final LoadBalanceAlgorithm ALGORITHM_EDEFAULT = LoadBalanceAlgorithm.ROUND_ROBIN;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected LoadBalanceAlgorithm algorithm = ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #isFailoverEnabled() <em>Failover Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailoverEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FAILOVER_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFailoverEnabled() <em>Failover Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailoverEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean failoverEnabled = FAILOVER_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getMembershipHandlerClass() <em>Membership Handler Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembershipHandlerClass()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBERSHIP_HANDLER_CLASS_EDEFAULT = "class_name";

	/**
	 * The cached value of the '{@link #getMembershipHandlerClass() <em>Membership Handler Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembershipHandlerClass()
	 * @generated
	 * @ordered
	 */
	protected String membershipHandlerClass = MEMBERSHIP_HANDLER_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<DynamicLoadBalanceProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicLoadBalanceEndPointImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		super.doLoad(self);
		
		// Get the <dynamicLoadBalance/> element.
		Element dynamicLoadBalanceElem = getChildElement(self, "dynamicLoadBalance");
		
		// Algorithm.
		LoadBalanceAlgorithm algorithm = LoadBalanceAlgorithm.get(dynamicLoadBalanceElem.getAttribute("algorithm"));
		if (null != algorithm) {
			setAlgorithm(algorithm);
		}
		
		// Failover status.
		setFailoverEnabled(dynamicLoadBalanceElem.getAttribute("failover").equalsIgnoreCase("false"));
		
		// Check for <membershipHandler/> element.
		Element membershipHandlerElem = getChildElement(dynamicLoadBalanceElem, "membershipHandler");
		if (null != membershipHandlerElem) {
			setMembershipHandlerClass(membershipHandlerElem.getAttribute("class"));
			
			// Properties.
			loadObjects(membershipHandlerElem, "property", DynamicLoadBalanceProperty.class,
					new ObjectHandler<DynamicLoadBalanceProperty>() {
						public void handle(DynamicLoadBalanceProperty object) {
							getProperties().add(object);
						}
					});
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = super.doSave(parent);
		
		// Create the <dynamicLoadBalance/> element.
		Element dynamicLoadBalanceElem = createChildElement(self, "dynamicLoadBalance");
		dynamicLoadBalanceElem.setAttribute("algorithm", getAlgorithm().getLiteral());
		dynamicLoadBalanceElem.setAttribute("failover", Boolean.toString(isFailoverEnabled()));
		
		// Create the <membershipHandler/> element.
		Element membershipHandlerElem = createChildElement(dynamicLoadBalanceElem, "membershipHandler");
		membershipHandlerElem.setAttribute("class", getMembershipHandlerClass());
		
		// Properties.
		for (DynamicLoadBalanceProperty property : getProperties()) {
			property.save(membershipHandlerElem);
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
		return EsbPackage.Literals.DYNAMIC_LOAD_BALANCE_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceAlgorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(LoadBalanceAlgorithm newAlgorithm) {
		LoadBalanceAlgorithm oldAlgorithm = algorithm;
		algorithm = newAlgorithm == null ? ALGORITHM_EDEFAULT : newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFailoverEnabled() {
		return failoverEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailoverEnabled(boolean newFailoverEnabled) {
		boolean oldFailoverEnabled = failoverEnabled;
		failoverEnabled = newFailoverEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED, oldFailoverEnabled, failoverEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMembershipHandlerClass() {
		return membershipHandlerClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMembershipHandlerClass(String newMembershipHandlerClass) {
		String oldMembershipHandlerClass = membershipHandlerClass;
		membershipHandlerClass = newMembershipHandlerClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS, oldMembershipHandlerClass, membershipHandlerClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DynamicLoadBalanceProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<DynamicLoadBalanceProperty>(DynamicLoadBalanceProperty.class, this, EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM:
				return getAlgorithm();
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED:
				return isFailoverEnabled();
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS:
				return getMembershipHandlerClass();
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES:
				return getProperties();
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
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm((LoadBalanceAlgorithm)newValue);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED:
				setFailoverEnabled((Boolean)newValue);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS:
				setMembershipHandlerClass((String)newValue);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends DynamicLoadBalanceProperty>)newValue);
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
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED:
				setFailoverEnabled(FAILOVER_ENABLED_EDEFAULT);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS:
				setMembershipHandlerClass(MEMBERSHIP_HANDLER_CLASS_EDEFAULT);
				return;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES:
				getProperties().clear();
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
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM:
				return algorithm != ALGORITHM_EDEFAULT;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED:
				return failoverEnabled != FAILOVER_ENABLED_EDEFAULT;
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS:
				return MEMBERSHIP_HANDLER_CLASS_EDEFAULT == null ? membershipHandlerClass != null : !MEMBERSHIP_HANDLER_CLASS_EDEFAULT.equals(membershipHandlerClass);
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", failoverEnabled: ");
		result.append(failoverEnabled);
		result.append(", membershipHandlerClass: ");
		result.append(membershipHandlerClass);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (null == getMembershipHandlerClass() || getMembershipHandlerClass().trim().isEmpty()) {
			validateMap.put("Membership Handler Class","Membership handler class is empty");
		}
		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Dynamic LoadBalance EndPoint", objectValidator);
	    return mediatorValidateMap;
    }

} //DynamicLoadBalanceEndPointImpl
