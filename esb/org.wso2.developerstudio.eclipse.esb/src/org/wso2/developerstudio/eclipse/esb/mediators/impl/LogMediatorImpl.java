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
import org.wso2.developerstudio.eclipse.esb.Description;
import org.wso2.developerstudio.eclipse.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.LogCategory;
import org.wso2.developerstudio.eclipse.esb.mediators.LogLevel;
import org.wso2.developerstudio.eclipse.esb.mediators.LogMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.LogProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LogMediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl#getLogCategory <em>Log Category</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl#getLogSeparator <em>Log Separator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogMediatorImpl extends MediatorImpl implements LogMediator {
	/**
	 * The default value of the '{@link #getLogCategory() <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogCategory()
	 * @generated
	 * @ordered
	 */
	protected static final LogCategory LOG_CATEGORY_EDEFAULT = LogCategory.INFO;

	/**
	 * The cached value of the '{@link #getLogCategory() <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogCategory()
	 * @generated
	 * @ordered
	 */
	protected LogCategory logCategory = LOG_CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogLevel()
	 * @!generated
	 * @ordered
	 */
	protected static final LogLevel LOG_LEVEL_EDEFAULT = LogLevel.SIMPLE;

	/**
	 * The cached value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogLevel()
	 * @generated
	 * @ordered
	 */
	protected LogLevel logLevel = LOG_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogSeparator() <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_SEPARATOR_EDEFAULT = ",";

	/**
	 * The cached value of the '{@link #getLogSeparator() <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSeparator()
	 * @generated
	 * @ordered
	 */
	protected String logSeparator = LOG_SEPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<LogProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void doLoad(Element self) throws Exception {
		if (self.hasAttribute("level")) {
			setLogLevel(LogLevel.get(self.getAttribute("level")));
		}

		if (self.hasAttribute("category")) {
			setLogCategory(LogCategory.get(self.getAttribute("category")));
		}

		if (self.hasAttribute("separator")) {
			setLogSeparator(self.getAttribute("separator"));
		}
		
		loadObjects(self, "property", LogProperty.class, new ObjectHandler<LogProperty>() {
			public void handle(LogProperty object) {
				getProperties().add(object);
			}			
		});		
		
		super.doLoad(self);
	
	}

	/**
	 * {@inheritDoc}
	 */
	public Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "log");
		self.setAttribute("level", getLogLevel().getLiteral());
		self.setAttribute("category", getLogCategory().getLiteral());
		self.setAttribute("separator", getLogSeparator());
		for (LogProperty property : getProperties()) {
			property.save(self);
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
		return MediatorsPackage.Literals.LOG_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogCategory getLogCategory() {
		return logCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogCategory(LogCategory newLogCategory) {
		LogCategory oldLogCategory = logCategory;
		logCategory = newLogCategory == null ? LOG_CATEGORY_EDEFAULT : newLogCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.LOG_MEDIATOR__LOG_CATEGORY, oldLogCategory, logCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogLevel getLogLevel() {
		return logLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogLevel(LogLevel newLogLevel) {
		LogLevel oldLogLevel = logLevel;
		logLevel = newLogLevel == null ? LOG_LEVEL_EDEFAULT : newLogLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.LOG_MEDIATOR__LOG_LEVEL, oldLogLevel, logLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogSeparator() {
		return logSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogSeparator(String newLogSeparator) {
		String oldLogSeparator = logSeparator;
		logSeparator = newLogSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.LOG_MEDIATOR__LOG_SEPARATOR, oldLogSeparator, logSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<LogProperty>(LogProperty.class, this, MediatorsPackage.LOG_MEDIATOR__PROPERTIES);
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
			case MediatorsPackage.LOG_MEDIATOR__PROPERTIES:
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
			case MediatorsPackage.LOG_MEDIATOR__LOG_CATEGORY:
				return getLogCategory();
			case MediatorsPackage.LOG_MEDIATOR__LOG_LEVEL:
				return getLogLevel();
			case MediatorsPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				return getLogSeparator();
			case MediatorsPackage.LOG_MEDIATOR__PROPERTIES:
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
			case MediatorsPackage.LOG_MEDIATOR__LOG_CATEGORY:
				setLogCategory((LogCategory)newValue);
				return;
			case MediatorsPackage.LOG_MEDIATOR__LOG_LEVEL:
				setLogLevel((LogLevel)newValue);
				return;
			case MediatorsPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				setLogSeparator((String)newValue);
				return;
			case MediatorsPackage.LOG_MEDIATOR__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends LogProperty>)newValue);
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
			case MediatorsPackage.LOG_MEDIATOR__LOG_CATEGORY:
				setLogCategory(LOG_CATEGORY_EDEFAULT);
				return;
			case MediatorsPackage.LOG_MEDIATOR__LOG_LEVEL:
				setLogLevel(LOG_LEVEL_EDEFAULT);
				return;
			case MediatorsPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				setLogSeparator(LOG_SEPARATOR_EDEFAULT);
				return;
			case MediatorsPackage.LOG_MEDIATOR__PROPERTIES:
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
			case MediatorsPackage.LOG_MEDIATOR__LOG_CATEGORY:
				return logCategory != LOG_CATEGORY_EDEFAULT;
			case MediatorsPackage.LOG_MEDIATOR__LOG_LEVEL:
				return logLevel != LOG_LEVEL_EDEFAULT;
			case MediatorsPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				return LOG_SEPARATOR_EDEFAULT == null ? logSeparator != null : !LOG_SEPARATOR_EDEFAULT.equals(logSeparator);
			case MediatorsPackage.LOG_MEDIATOR__PROPERTIES:
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
		result.append(" (logCategory: ");
		result.append(logCategory);
		result.append(", logLevel: ");
		result.append(logLevel);
		result.append(", logSeparator: ");
		result.append(logSeparator);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
    	return new HashMap<String, ObjectValidator>();
    }

} //LogMediatorImpl
