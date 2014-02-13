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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.ApiFaultSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiInSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiOutSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiResource;
import org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Api Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getInSequenceConfiguration <em>In Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getUrlStyle <em>Url Style</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#getUrlMapping <em>Url Mapping</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#isAllowGet <em>Allow Get</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#isAllowPost <em>Allow Post</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#isAllowPut <em>Allow Put</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#isAllowDelete <em>Allow Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ApiResourceImpl#isAllowOptions <em>Allow Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApiResourceImpl extends ModelObjectImpl implements ApiResource {
	/**
	 * The cached value of the '{@link #getInSequenceConfiguration() <em>In Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ApiInSequenceConfiguration inSequenceConfiguration;

	/**
	 * The cached value of the '{@link #getOutSequenceConfiguration() <em>Out Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ApiOutSequenceConfiguration outSequenceConfiguration;

	/**
	 * The cached value of the '{@link #getFaultSequenceConfiguration() <em>Fault Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ApiFaultSequenceConfiguration faultSequenceConfiguration;

	/**
	 * The default value of the '{@link #getUrlStyle() <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlStyle()
	 * @generated
	 * @ordered
	 */
	protected static final ApiResourceUrlStyle URL_STYLE_EDEFAULT = ApiResourceUrlStyle.NONE;

	/**
	 * The cached value of the '{@link #getUrlStyle() <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlStyle()
	 * @generated
	 * @ordered
	 */
	protected ApiResourceUrlStyle urlStyle = URL_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUriTemplate() <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriTemplate() <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected String uriTemplate = URI_TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrlMapping() <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlMapping()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_MAPPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrlMapping() <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlMapping()
	 * @generated
	 * @ordered
	 */
	protected String urlMapping = URL_MAPPING_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowGet() <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowGet()
	 * @generated NOT
	 * @ordered
	 */
	protected static final boolean ALLOW_GET_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAllowGet() <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowGet()
	 * @generated
	 * @ordered
	 */
	protected boolean allowGet = ALLOW_GET_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowPost() <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPost()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_POST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowPost() <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPost()
	 * @generated
	 * @ordered
	 */
	protected boolean allowPost = ALLOW_POST_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowPut() <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPut()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_PUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowPut() <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPut()
	 * @generated
	 * @ordered
	 */
	protected boolean allowPut = ALLOW_PUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowDelete() <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowDelete() <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean allowDelete = ALLOW_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowOptions() <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowOptions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_OPTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowOptions() <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowOptions()
	 * @generated
	 * @ordered
	 */
	protected boolean allowOptions = ALLOW_OPTIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ApiResourceImpl() {
		super();
		
		// In Sequence
		ApiInSequenceConfiguration inSequenceConfiguration = getEsbFactory().createApiInSequenceConfiguration();
		setInSequenceConfiguration(inSequenceConfiguration);
		
		// Out Sequence
		ApiOutSequenceConfiguration outSequenceConfiguration = getEsbFactory().createApiOutSequenceConfiguration();
		setOutSequenceConfiguration(outSequenceConfiguration);
		
		// Fault Sequence
		ApiFaultSequenceConfiguration faultSequenceConfiguration = getEsbFactory().createApiFaultSequenceConfiguration();
		setFaultSequenceConfiguration(faultSequenceConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.API_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiInSequenceConfiguration getInSequenceConfiguration() {
		return inSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSequenceConfiguration(ApiInSequenceConfiguration newInSequenceConfiguration, NotificationChain msgs) {
		ApiInSequenceConfiguration oldInSequenceConfiguration = inSequenceConfiguration;
		inSequenceConfiguration = newInSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION, oldInSequenceConfiguration, newInSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceConfiguration(ApiInSequenceConfiguration newInSequenceConfiguration) {
		if (newInSequenceConfiguration != inSequenceConfiguration) {
			NotificationChain msgs = null;
			if (inSequenceConfiguration != null)
				msgs = ((InternalEObject)inSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION, null, msgs);
			if (newInSequenceConfiguration != null)
				msgs = ((InternalEObject)newInSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetInSequenceConfiguration(newInSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION, newInSequenceConfiguration, newInSequenceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiOutSequenceConfiguration getOutSequenceConfiguration() {
		return outSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceConfiguration(ApiOutSequenceConfiguration newOutSequenceConfiguration, NotificationChain msgs) {
		ApiOutSequenceConfiguration oldOutSequenceConfiguration = outSequenceConfiguration;
		outSequenceConfiguration = newOutSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION, oldOutSequenceConfiguration, newOutSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceConfiguration(ApiOutSequenceConfiguration newOutSequenceConfiguration) {
		if (newOutSequenceConfiguration != outSequenceConfiguration) {
			NotificationChain msgs = null;
			if (outSequenceConfiguration != null)
				msgs = ((InternalEObject)outSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION, null, msgs);
			if (newOutSequenceConfiguration != null)
				msgs = ((InternalEObject)newOutSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetOutSequenceConfiguration(newOutSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION, newOutSequenceConfiguration, newOutSequenceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiFaultSequenceConfiguration getFaultSequenceConfiguration() {
		return faultSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceConfiguration(ApiFaultSequenceConfiguration newFaultSequenceConfiguration, NotificationChain msgs) {
		ApiFaultSequenceConfiguration oldFaultSequenceConfiguration = faultSequenceConfiguration;
		faultSequenceConfiguration = newFaultSequenceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION, oldFaultSequenceConfiguration, newFaultSequenceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceConfiguration(ApiFaultSequenceConfiguration newFaultSequenceConfiguration) {
		if (newFaultSequenceConfiguration != faultSequenceConfiguration) {
			NotificationChain msgs = null;
			if (faultSequenceConfiguration != null)
				msgs = ((InternalEObject)faultSequenceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION, null, msgs);
			if (newFaultSequenceConfiguration != null)
				msgs = ((InternalEObject)newFaultSequenceConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION, null, msgs);
			msgs = basicSetFaultSequenceConfiguration(newFaultSequenceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION, newFaultSequenceConfiguration, newFaultSequenceConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiResourceUrlStyle getUrlStyle() {
		return urlStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlStyle(ApiResourceUrlStyle newUrlStyle) {
		ApiResourceUrlStyle oldUrlStyle = urlStyle;
		urlStyle = newUrlStyle == null ? URL_STYLE_EDEFAULT : newUrlStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URL_STYLE, oldUrlStyle, urlStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriTemplate() {
		return uriTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriTemplate(String newUriTemplate) {
		String oldUriTemplate = uriTemplate;
		uriTemplate = newUriTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URI_TEMPLATE, oldUriTemplate, uriTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrlMapping() {
		return urlMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlMapping(String newUrlMapping) {
		String oldUrlMapping = urlMapping;
		urlMapping = newUrlMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URL_MAPPING, oldUrlMapping, urlMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowGet() {
		return allowGet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowGet(boolean newAllowGet) {
		boolean oldAllowGet = allowGet;
		allowGet = newAllowGet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_GET, oldAllowGet, allowGet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowPost() {
		return allowPost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowPost(boolean newAllowPost) {
		boolean oldAllowPost = allowPost;
		allowPost = newAllowPost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_POST, oldAllowPost, allowPost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowPut() {
		return allowPut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowPut(boolean newAllowPut) {
		boolean oldAllowPut = allowPut;
		allowPut = newAllowPut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_PUT, oldAllowPut, allowPut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowDelete() {
		return allowDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowDelete(boolean newAllowDelete) {
		boolean oldAllowDelete = allowDelete;
		allowDelete = newAllowDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_DELETE, oldAllowDelete, allowDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowOptions() {
		return allowOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowOptions(boolean newAllowOptions) {
		boolean oldAllowOptions = allowOptions;
		allowOptions = newAllowOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_OPTIONS, oldAllowOptions, allowOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
				return basicSetInSequenceConfiguration(null, msgs);
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
				return basicSetOutSequenceConfiguration(null, msgs);
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
				return basicSetFaultSequenceConfiguration(null, msgs);
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
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
				return getInSequenceConfiguration();
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
				return getOutSequenceConfiguration();
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
				return getFaultSequenceConfiguration();
			case EsbPackage.API_RESOURCE__URL_STYLE:
				return getUrlStyle();
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				return getUriTemplate();
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				return getUrlMapping();
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				return isAllowGet();
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				return isAllowPost();
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				return isAllowPut();
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				return isAllowDelete();
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				return isAllowOptions();
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
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
				setInSequenceConfiguration((ApiInSequenceConfiguration)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
				setOutSequenceConfiguration((ApiOutSequenceConfiguration)newValue);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
				setFaultSequenceConfiguration((ApiFaultSequenceConfiguration)newValue);
				return;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				setUrlStyle((ApiResourceUrlStyle)newValue);
				return;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				setUriTemplate((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				setUrlMapping((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				setAllowGet((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				setAllowPost((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				setAllowPut((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				setAllowDelete((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				setAllowOptions((Boolean)newValue);
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
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
				setInSequenceConfiguration((ApiInSequenceConfiguration)null);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
				setOutSequenceConfiguration((ApiOutSequenceConfiguration)null);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
				setFaultSequenceConfiguration((ApiFaultSequenceConfiguration)null);
				return;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				setUrlStyle(URL_STYLE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				setUriTemplate(URI_TEMPLATE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				setUrlMapping(URL_MAPPING_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				setAllowGet(ALLOW_GET_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				setAllowPost(ALLOW_POST_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				setAllowPut(ALLOW_PUT_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				setAllowDelete(ALLOW_DELETE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				setAllowOptions(ALLOW_OPTIONS_EDEFAULT);
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
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_CONFIGURATION:
				return inSequenceConfiguration != null;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_CONFIGURATION:
				return outSequenceConfiguration != null;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION:
				return faultSequenceConfiguration != null;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				return urlStyle != URL_STYLE_EDEFAULT;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				return URI_TEMPLATE_EDEFAULT == null ? uriTemplate != null : !URI_TEMPLATE_EDEFAULT.equals(uriTemplate);
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				return URL_MAPPING_EDEFAULT == null ? urlMapping != null : !URL_MAPPING_EDEFAULT.equals(urlMapping);
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				return allowGet != ALLOW_GET_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				return allowPost != ALLOW_POST_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				return allowPut != ALLOW_PUT_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				return allowDelete != ALLOW_DELETE_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				return allowOptions != ALLOW_OPTIONS_EDEFAULT;
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
		result.append(" (urlStyle: ");
		result.append(urlStyle);
		result.append(", uriTemplate: ");
		result.append(uriTemplate);
		result.append(", urlMapping: ");
		result.append(urlMapping);
		result.append(", allowGet: ");
		result.append(allowGet);
		result.append(", allowPost: ");
		result.append(allowPost);
		result.append(", allowPut: ");
		result.append(allowPut);
		result.append(", allowDelete: ");
		result.append(allowDelete);
		result.append(", allowOptions: ");
		result.append(allowOptions);
		result.append(')');
		return result.toString();
	}

	@Override
	public Map<String, ObjectValidator> validate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void doLoad(Element self) throws Exception {
		
		if(self.hasAttribute("uri-template")){
			setUrlStyle(ApiResourceUrlStyle.URI_TEMPLATE);
			setUriTemplate(self.getAttribute("uri-template"));
		} else if(self.hasAttribute("url-mapping")){
			setUrlStyle(ApiResourceUrlStyle.URL_MAPPING);
			setUrlMapping(self.getAttribute("url-mapping"));
		} else{
			setUrlStyle(ApiResourceUrlStyle.NONE);
		}
		
		if(self.hasAttribute("methods")){
			String methods = self.getAttribute("methods");
			if(methods!=null){
				List<String> methodList = Arrays.asList(methods.split(" "));  
				setAllowGet(methodList.contains("GET"));
				setAllowPost(methodList.contains("POST"));
				setAllowOptions(methodList.contains("OPTIONS"));
				setAllowDelete(methodList.contains("DELETE"));
				setAllowPut(methodList.contains("PUT"));
			}
		}
		
		// In sequence.
		getInSequenceConfiguration().load(self);
		
		// Out sequence.
		getOutSequenceConfiguration().load(self);		
		
		// Fault sequence.
		getFaultSequenceConfiguration().load(self);
		
		
		super.doLoad(self);
	}

	@Override
	protected Element doSave(Element parent) throws Exception {
		List<String> methods = new ArrayList<String>();
		String methodsValue = new String();
		Element self = createChildElement(parent, "resource");
		
		if(getUrlStyle()==ApiResourceUrlStyle.URI_TEMPLATE && getUriTemplate()!=null){
			self.setAttribute("uri-template", getUriTemplate());
		} else if(getUrlStyle()==ApiResourceUrlStyle.URL_MAPPING && getUrlMapping()!=null){
			self.setAttribute("url-mapping", getUrlMapping());
		}
		
		if(isAllowGet()){
			methods.add("GET");
		} 
		if(isAllowPost()){
			methods.add("POST");
		}
		if(isAllowPut()){
			methods.add("PUT");
		}
		if(isAllowDelete()){
			methods.add("DELETE");
		}
		if(isAllowOptions()){
			methods.add("OPTIONS");
		}
		
		for (String method : methods) {
			methodsValue += method;
			methodsValue += " ";
		}
		methodsValue = methodsValue.trim();
		
		self.setAttribute("methods", (methodsValue.length() > 0) ? methodsValue : "GET");
		//"GET" saved by default, if not selected any method 
		
		// In sequence.
		if(getInSequenceConfiguration()!=null){
			getInSequenceConfiguration().save(self);
		}
		
		// Out sequence.
		if(getOutSequenceConfiguration()!=null){
			getOutSequenceConfiguration().save(self);
		}
		
		// Fault sequence.
		if(getFaultSequenceConfiguration()!=null){
			getFaultSequenceConfiguration().save(self);
		}				
		return self;
	}

} //ApiResourceImpl
