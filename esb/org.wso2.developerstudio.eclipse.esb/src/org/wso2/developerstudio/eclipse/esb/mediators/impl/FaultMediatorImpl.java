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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getSoapVersion <em>Soap Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultCodeSoap11 <em>Fault Code Soap11</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultStringType <em>Fault String Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultStringValue <em>Fault String Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultStringExpression <em>Fault String Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultActor <em>Fault Actor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultCodeSoap12 <em>Fault Code Soap12</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultReasonType <em>Fault Reason Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultReasonValue <em>Fault Reason Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultReasonExpression <em>Fault Reason Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultDetailType <em>Fault Detail Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultDetailValue <em>Fault Detail Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl#getFaultDetailExpression <em>Fault Detail Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultMediatorImpl extends MediatorImpl implements FaultMediator {
	/**
	 * The default value of the '{@link #getSoapVersion() <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapVersion()
	 * @generated
	 * @ordered
	 */
	protected static final FaultSoapVersion SOAP_VERSION_EDEFAULT = FaultSoapVersion.SOAP_11;

	/**
	 * The cached value of the '{@link #getSoapVersion() <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapVersion()
	 * @generated
	 * @ordered
	 */
	protected FaultSoapVersion soapVersion = SOAP_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultCodeSoap11() <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap11()
	 * @generated
	 * @ordered
	 */
	protected static final FaultCodeSoap11 FAULT_CODE_SOAP11_EDEFAULT = FaultCodeSoap11.VERSION_MISSMATCH;

	/**
	 * The cached value of the '{@link #getFaultCodeSoap11() <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap11()
	 * @generated
	 * @ordered
	 */
	protected FaultCodeSoap11 faultCodeSoap11 = FAULT_CODE_SOAP11_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultStringType() <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultStringType FAULT_STRING_TYPE_EDEFAULT = FaultStringType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultStringType() <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringType()
	 * @generated
	 * @ordered
	 */
	protected FaultStringType faultStringType = FAULT_STRING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultStringValue() <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_STRING_VALUE_EDEFAULT = "fault_string";

	/**
	 * The cached value of the '{@link #getFaultStringValue() <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringValue()
	 * @generated
	 * @ordered
	 */
	protected String faultStringValue = FAULT_STRING_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultStringExpression() <em>Fault String Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultStringExpression;

	/**
	 * The default value of the '{@link #getFaultActor() <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultActor()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_ACTOR_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFaultActor() <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultActor()
	 * @generated
	 * @ordered
	 */
	protected String faultActor = FAULT_ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultCodeSoap12() <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap12()
	 * @generated
	 * @ordered
	 */
	protected static final FaultCodeSoap12 FAULT_CODE_SOAP12_EDEFAULT = FaultCodeSoap12.VERSION_MISSMATCH;

	/**
	 * The cached value of the '{@link #getFaultCodeSoap12() <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap12()
	 * @generated
	 * @ordered
	 */
	protected FaultCodeSoap12 faultCodeSoap12 = FAULT_CODE_SOAP12_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultReasonType() <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultReasonType FAULT_REASON_TYPE_EDEFAULT = FaultReasonType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultReasonType() <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonType()
	 * @generated
	 * @ordered
	 */
	protected FaultReasonType faultReasonType = FAULT_REASON_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultReasonValue() <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_REASON_VALUE_EDEFAULT = "fault_reason";

	/**
	 * The cached value of the '{@link #getFaultReasonValue() <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonValue()
	 * @generated
	 * @ordered
	 */
	protected String faultReasonValue = FAULT_REASON_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultReasonExpression() <em>Fault Reason Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultReasonExpression;

	/**
	 * The default value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected String roleName = ROLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultDetailType() <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultDetailType FAULT_DETAIL_TYPE_EDEFAULT = FaultDetailType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultDetailType() <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailType()
	 * @generated
	 * @ordered
	 */
	protected FaultDetailType faultDetailType = FAULT_DETAIL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultDetailValue() <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_DETAIL_VALUE_EDEFAULT = "fault_detail";

	/**
	 * The cached value of the '{@link #getFaultDetailValue() <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailValue()
	 * @generated
	 * @ordered
	 */
	protected String faultDetailValue = FAULT_DETAIL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultDetailExpression() <em>Fault Detail Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultDetailExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected FaultMediatorImpl() {
		super();
		
		// Fault reason expression.
		NamespacedProperty faultReasonExpression = getEsbFactory().createNamespacedProperty();
		faultReasonExpression.setPrettyName("Fault Reason");
		faultReasonExpression.setPropertyName("expression");
		faultReasonExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultReasonExpression(faultReasonExpression);
		
		// Fault string expression.
		NamespacedProperty faultStringExpression = getEsbFactory().createNamespacedProperty();
		faultStringExpression.setPrettyName("Fault String");
		faultStringExpression.setPropertyName("expression");
		faultStringExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultStringExpression(faultStringExpression);
		
		// Fault detail expression.
		NamespacedProperty faultDetailExpression = getEsbFactory().createNamespacedProperty();
		faultDetailExpression.setPrettyName("Fault Detail");
		faultDetailExpression.setPropertyName("expression");
		faultDetailExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultDetailExpression(faultDetailExpression);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		// Soap version.
		FaultSoapVersion soapVersion = 
			FaultSoapVersion.get(self.getAttribute("version"));
		if (null != soapVersion) {
			setSoapVersion(soapVersion);
		}		

		// Fault code.		
		Element codeElem = getChildElement(self, "code");
		if (null != codeElem) {
			String faultCodeLiteralAttr = codeElem.getAttribute("value");
			String [] faultCodeLiteralParts = faultCodeLiteralAttr.split(":");
			String faultCodeLiteral = FaultCodeSoap11.VERSION_MISSMATCH.getLiteral();
			if (faultCodeLiteralParts.length == 2) {
				faultCodeLiteral = faultCodeLiteralParts[1];
			}
			
			if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
				setFaultCodeSoap11(FaultCodeSoap11.get(faultCodeLiteral));
			} else {
				setFaultCodeSoap12(FaultCodeSoap12.get(faultCodeLiteral));
			}
		} else {
			throw new Exception("Expected code element.");
		}
		
		// Fault string / reason.
		Element reasonElem = getChildElement(self, "reason");
		if (null != reasonElem) {
			if (reasonElem.hasAttribute("value")) {
				if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
					setFaultStringType(FaultStringType.VALUE);
					setFaultStringValue(reasonElem.getAttribute("value"));
				} else {
					setFaultReasonType(FaultReasonType.VALUE);
					setFaultReasonValue(reasonElem.getAttribute("value"));
				}
			} else if (reasonElem.hasAttribute("expression")) {
				if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
					setFaultStringType(FaultStringType.EXPRESSION);
					getFaultStringExpression().load(reasonElem);
				} else {
					setFaultReasonType(FaultReasonType.EXPRESSION);
					getFaultReasonExpression().load(reasonElem);
				}
			} else {
				throw new Exception("Expected value / expression attribute.");
			}
		} else {
			throw new Exception("Expected reason element.");
		}

		// Fault actor / role.
		Element roleElem = getChildElement(self, "role");
		if (null != roleElem) {
			if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
				setFaultActor(roleElem.getTextContent());
			} else {
				setRoleName(roleElem.getTextContent());
			}
		}
		
		// Fault node.
		Element nodeElem = getChildElement(self, "node");
		if (null != nodeElem) {
			setNodeName(nodeElem.getTextContent());
		}
		
		// Fault detail.
		Element detailElem = getChildElement(self, "detail");
		if (null != detailElem) {
			if (detailElem.hasAttribute("expression")) {
				setFaultDetailType(FaultDetailType.EXPRESSION);
				getFaultDetailExpression().load(detailElem);
			} else {
				setFaultDetailType(FaultDetailType.VALUE);
				setFaultDetailValue(detailElem.getTextContent());
			}			
		}
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "makefault"); 
		
		// Soap version.
		self.setAttribute("version", getSoapVersion().getLiteral());

		Element elemCode = createChildElement(self,	"code");		
		Element reasonElem = createChildElement(self, "reason");
		Element roleElem = createChildElement(self, "role");
		
		if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
			// Fault code (soap 1.1).
			elemCode.setAttribute(String.format("xmlns:%s", SOAP_1_1_ENVELOPE_NAMESPACE_PREFIX),
					SOAP_1_1_ENVELOPE_NAMESPACE_URI);
			elemCode.setAttribute("value", String.format("%s:%s",
					SOAP_1_1_ENVELOPE_NAMESPACE_PREFIX, getFaultCodeSoap11().getLiteral()));			
			
			// Fault string.
			if (getFaultStringType().equals(FaultStringType.VALUE)) {
				reasonElem.setAttribute("value", getFaultStringValue());
			} else {
				getFaultStringExpression().save(reasonElem);
			}
			
			// Fault actor.
			roleElem.setTextContent(getFaultActor());						
		} else {
			// Fault code (soap 1.2).
			elemCode.setAttribute(String.format("xmlns:%s", SOAP_1_2_ENVELOPE_NAMESPACE_PREFIX),
					SOAP_1_2_ENVELOPE_NAMESPACE_URI);
			elemCode.setAttribute("value", String.format("%s:%s",
					SOAP_1_2_ENVELOPE_NAMESPACE_PREFIX, getFaultCodeSoap12().getLiteral()));
			
			// Fault reason.
			if (getFaultReasonType().equals(FaultReasonType.VALUE)) {
				reasonElem.setAttribute("value", getFaultReasonValue());
			} else {
				getFaultReasonExpression().save(reasonElem);
			}
			
			// Role name.
			roleElem.setTextContent(getRoleName());
			
			// Fault node.
			Element nodeElem = createChildElement(self, "node");
			nodeElem.setTextContent(getNodeName());
		}		
		
		// Fault detail.
		Element detailElem = createChildElement(self, "detail");
		if (getFaultDetailType().equals(FaultDetailType.EXPRESSION)) {
			getFaultDetailExpression().save(detailElem);
		} else {
			detailElem.setTextContent(getFaultDetailValue());
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
		return MediatorsPackage.Literals.FAULT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultSoapVersion getSoapVersion() {
		return soapVersion;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapVersion(FaultSoapVersion newSoapVersion) {
		FaultSoapVersion oldSoapVersion = soapVersion;
		soapVersion = newSoapVersion == null ? SOAP_VERSION_EDEFAULT : newSoapVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION, oldSoapVersion, soapVersion));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap11 getFaultCodeSoap11() {
		return faultCodeSoap11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeSoap11(FaultCodeSoap11 newFaultCodeSoap11) {
		FaultCodeSoap11 oldFaultCodeSoap11 = faultCodeSoap11;
		faultCodeSoap11 = newFaultCodeSoap11 == null ? FAULT_CODE_SOAP11_EDEFAULT : newFaultCodeSoap11;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11, oldFaultCodeSoap11, faultCodeSoap11));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap12 getFaultCodeSoap12() {
		return faultCodeSoap12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeSoap12(FaultCodeSoap12 newFaultCodeSoap12) {
		FaultCodeSoap12 oldFaultCodeSoap12 = faultCodeSoap12;
		faultCodeSoap12 = newFaultCodeSoap12 == null ? FAULT_CODE_SOAP12_EDEFAULT : newFaultCodeSoap12;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12, oldFaultCodeSoap12, faultCodeSoap12));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultReasonType getFaultReasonType() {
		return faultReasonType;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonType(FaultReasonType newFaultReasonType) {
		FaultReasonType oldFaultReasonType = faultReasonType;
		faultReasonType = newFaultReasonType == null ? FAULT_REASON_TYPE_EDEFAULT : newFaultReasonType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE, oldFaultReasonType, faultReasonType));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultReasonValue() {
		return faultReasonValue;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonValue(String newFaultReasonValue) {
		String oldFaultReasonValue = faultReasonValue;
		faultReasonValue = newFaultReasonValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE, oldFaultReasonValue, faultReasonValue));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultReasonExpression() {
		return faultReasonExpression;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultReasonExpression(NamespacedProperty newFaultReasonExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultReasonExpression = faultReasonExpression;
		faultReasonExpression = newFaultReasonExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, oldFaultReasonExpression, newFaultReasonExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonExpression(NamespacedProperty newFaultReasonExpression) {
		if (newFaultReasonExpression != faultReasonExpression) {
			NotificationChain msgs = null;
			if (faultReasonExpression != null)
				msgs = ((InternalEObject)faultReasonExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, null, msgs);
			if (newFaultReasonExpression != null)
				msgs = ((InternalEObject)newFaultReasonExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, null, msgs);
			msgs = basicSetFaultReasonExpression(newFaultReasonExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, newFaultReasonExpression, newFaultReasonExpression));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoleName() {
		return roleName;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleName(String newRoleName) {
		String oldRoleName = roleName;
		roleName = newRoleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME, oldRoleName, roleName));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__NODE_NAME, oldNodeName, nodeName));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultDetailType getFaultDetailType() {
		return faultDetailType;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailType(FaultDetailType newFaultDetailType) {
		FaultDetailType oldFaultDetailType = faultDetailType;
		faultDetailType = newFaultDetailType == null ? FAULT_DETAIL_TYPE_EDEFAULT : newFaultDetailType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE, oldFaultDetailType, faultDetailType));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultDetailValue() {
		return faultDetailValue;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailValue(String newFaultDetailValue) {
		String oldFaultDetailValue = faultDetailValue;
		faultDetailValue = newFaultDetailValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE, oldFaultDetailValue, faultDetailValue));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultDetailExpression() {
		return faultDetailExpression;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultDetailExpression(NamespacedProperty newFaultDetailExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultDetailExpression = faultDetailExpression;
		faultDetailExpression = newFaultDetailExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, oldFaultDetailExpression, newFaultDetailExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailExpression(NamespacedProperty newFaultDetailExpression) {
		if (newFaultDetailExpression != faultDetailExpression) {
			NotificationChain msgs = null;
			if (faultDetailExpression != null)
				msgs = ((InternalEObject)faultDetailExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, null, msgs);
			if (newFaultDetailExpression != null)
				msgs = ((InternalEObject)newFaultDetailExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, null, msgs);
			msgs = basicSetFaultDetailExpression(newFaultDetailExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, newFaultDetailExpression, newFaultDetailExpression));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultStringType getFaultStringType() {
		return faultStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringType(FaultStringType newFaultStringType) {
		FaultStringType oldFaultStringType = faultStringType;
		faultStringType = newFaultStringType == null ? FAULT_STRING_TYPE_EDEFAULT : newFaultStringType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE, oldFaultStringType, faultStringType));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultStringValue() {
		return faultStringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringValue(String newFaultStringValue) {
		String oldFaultStringValue = faultStringValue;
		faultStringValue = newFaultStringValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE, oldFaultStringValue, faultStringValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultStringExpression() {
		return faultStringExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultStringExpression(NamespacedProperty newFaultStringExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultStringExpression = faultStringExpression;
		faultStringExpression = newFaultStringExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, oldFaultStringExpression, newFaultStringExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringExpression(NamespacedProperty newFaultStringExpression) {
		if (newFaultStringExpression != faultStringExpression) {
			NotificationChain msgs = null;
			if (faultStringExpression != null)
				msgs = ((InternalEObject)faultStringExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, null, msgs);
			if (newFaultStringExpression != null)
				msgs = ((InternalEObject)newFaultStringExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, null, msgs);
			msgs = basicSetFaultStringExpression(newFaultStringExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, newFaultStringExpression, newFaultStringExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultActor() {
		return faultActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultActor(String newFaultActor) {
		String oldFaultActor = faultActor;
		faultActor = newFaultActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR, oldFaultActor, faultActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return basicSetFaultStringExpression(null, msgs);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return basicSetFaultReasonExpression(null, msgs);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return basicSetFaultDetailExpression(null, msgs);
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
			case MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION:
				return getSoapVersion();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				return getFaultCodeSoap11();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				return getFaultStringType();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				return getFaultStringValue();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return getFaultStringExpression();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				return getFaultActor();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				return getFaultCodeSoap12();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				return getFaultReasonType();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				return getFaultReasonValue();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return getFaultReasonExpression();
			case MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME:
				return getRoleName();
			case MediatorsPackage.FAULT_MEDIATOR__NODE_NAME:
				return getNodeName();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				return getFaultDetailType();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				return getFaultDetailValue();
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return getFaultDetailExpression();
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
			case MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION:
				setSoapVersion((FaultSoapVersion)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				setFaultCodeSoap11((FaultCodeSoap11)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				setFaultStringType((FaultStringType)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				setFaultStringValue((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				setFaultStringExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				setFaultActor((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				setFaultCodeSoap12((FaultCodeSoap12)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				setFaultReasonType((FaultReasonType)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				setFaultReasonValue((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				setFaultReasonExpression((NamespacedProperty)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME:
				setRoleName((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				setFaultDetailType((FaultDetailType)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				setFaultDetailValue((String)newValue);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				setFaultDetailExpression((NamespacedProperty)newValue);
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
			case MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION:
				setSoapVersion(SOAP_VERSION_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				setFaultCodeSoap11(FAULT_CODE_SOAP11_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				setFaultStringType(FAULT_STRING_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				setFaultStringValue(FAULT_STRING_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				setFaultStringExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				setFaultActor(FAULT_ACTOR_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				setFaultCodeSoap12(FAULT_CODE_SOAP12_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				setFaultReasonType(FAULT_REASON_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				setFaultReasonValue(FAULT_REASON_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				setFaultReasonExpression((NamespacedProperty)null);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME:
				setRoleName(ROLE_NAME_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				setFaultDetailType(FAULT_DETAIL_TYPE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				setFaultDetailValue(FAULT_DETAIL_VALUE_EDEFAULT);
				return;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				setFaultDetailExpression((NamespacedProperty)null);
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
			case MediatorsPackage.FAULT_MEDIATOR__SOAP_VERSION:
				return soapVersion != SOAP_VERSION_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				return faultCodeSoap11 != FAULT_CODE_SOAP11_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				return faultStringType != FAULT_STRING_TYPE_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				return FAULT_STRING_VALUE_EDEFAULT == null ? faultStringValue != null : !FAULT_STRING_VALUE_EDEFAULT.equals(faultStringValue);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return faultStringExpression != null;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				return FAULT_ACTOR_EDEFAULT == null ? faultActor != null : !FAULT_ACTOR_EDEFAULT.equals(faultActor);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				return faultCodeSoap12 != FAULT_CODE_SOAP12_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				return faultReasonType != FAULT_REASON_TYPE_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				return FAULT_REASON_VALUE_EDEFAULT == null ? faultReasonValue != null : !FAULT_REASON_VALUE_EDEFAULT.equals(faultReasonValue);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return faultReasonExpression != null;
			case MediatorsPackage.FAULT_MEDIATOR__ROLE_NAME:
				return ROLE_NAME_EDEFAULT == null ? roleName != null : !ROLE_NAME_EDEFAULT.equals(roleName);
			case MediatorsPackage.FAULT_MEDIATOR__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				return faultDetailType != FAULT_DETAIL_TYPE_EDEFAULT;
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				return FAULT_DETAIL_VALUE_EDEFAULT == null ? faultDetailValue != null : !FAULT_DETAIL_VALUE_EDEFAULT.equals(faultDetailValue);
			case MediatorsPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return faultDetailExpression != null;
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
		result.append(" (soapVersion: ");
		result.append(soapVersion);
		result.append(", faultCodeSoap11: ");
		result.append(faultCodeSoap11);
		result.append(", faultStringType: ");
		result.append(faultStringType);
		result.append(", faultStringValue: ");
		result.append(faultStringValue);
		result.append(", faultActor: ");
		result.append(faultActor);
		result.append(", faultCodeSoap12: ");
		result.append(faultCodeSoap12);
		result.append(", faultReasonType: ");
		result.append(faultReasonType);
		result.append(", faultReasonValue: ");
		result.append(faultReasonValue);
		result.append(", roleName: ");
		result.append(roleName);
		result.append(", nodeName: ");
		result.append(nodeName);
		result.append(", faultDetailType: ");
		result.append(faultDetailType);
		result.append(", faultDetailValue: ");
		result.append(faultDetailValue);
		result.append(')');
		return result.toString();
	}


	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
		Map<String, String> validateMap = new HashMap<String, String>();
		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
		
		if (getSoapVersion().equals(FaultSoapVersion.SOAP_11)) {
			// Fault string.
			if (getFaultStringType().equals(FaultStringType.VALUE)) {
				if (null == getFaultStringValue() || getFaultStringValue().trim().isEmpty()) {
					validateMap.put("Fault String (Literal)","Fault String (Literal) is empty");
				}
			} else {
				if (null == getFaultStringExpression().getPropertyValue()
						|| getFaultStringExpression().getPropertyValue().trim()
								.isEmpty()) {
					validateMap.put("Fault String (Expression)", "Fault String (Expression) is empty");
				}
			}
						
		} else {
			// Fault code (soap 1.2).
			// Fault reason.
			if (getFaultReasonType().equals(FaultReasonType.VALUE)) {
				if (null == getFaultReasonValue() || getFaultReasonValue().trim().isEmpty()) {
					validateMap.put("Fault Reason (Literal)","Fault Reason (Literal) is empty");
				}
			} else {
				if (null == getFaultReasonExpression().getPropertyValue()
						|| getFaultReasonExpression().getPropertyValue().trim()
								.isEmpty()) {
					validateMap.put("Fault Reason (Expression)", "Fault Reason (Expression) is empty");
				}
			}

		}		
	    objectValidator.setMediatorErrorMap(validateMap);
	    mediatorValidateMap.put("Fault Mediator", objectValidator);
	    return mediatorValidateMap;
    }

} //FaultMediatorImpl
