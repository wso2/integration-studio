/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy WSDL Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ProxyWSDLResourceImpl extends AbstractLocationKeyResourceImpl implements ProxyWSDLResource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected ProxyWSDLResourceImpl() {
		super();
		
		// Resource key.
		RegistryKeyProperty wsdlResourceKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		//Set filter properties to filter in only wsdl media type
		DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)wsdlResourceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, PlatformMediaTypeConstants.MEDIA_TYPE_XSD);

		wsdlResourceKey.setPrettyName("WSDL Resource Key");
		wsdlResourceKey.setKeyName("key");
		wsdlResourceKey.setKeyValue(DEFAULT_RESOURCE_REFERENCE_REGISTRY_KEY);
		setKey(wsdlResourceKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_WSDL_RESOURCE;
	}

} //ProxyWSDLResourceImpl
