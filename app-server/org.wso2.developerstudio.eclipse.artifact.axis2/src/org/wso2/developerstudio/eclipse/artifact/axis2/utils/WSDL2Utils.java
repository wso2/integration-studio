/*
 * Copyright 2011 WSO2, Inc. http://www.wso2.org
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

package org.wso2.developerstudio.eclipse.artifact.axis2.utils;


import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.woden.WSDLFactory;
import org.apache.woden.WSDLReader;
import org.apache.woden.wsdl20.Description;
import org.apache.woden.wsdl20.Interface;
import org.apache.woden.wsdl20.InterfaceOperation;
import org.apache.woden.wsdl20.xml.DescriptionElement;

public class WSDL2Utils {
	
	 public static final int WSDL_VERSION_11=11;
	 public static final int WSDL_VERSION_20=20;
	
	 /**
	 * get WSDL version from WSDL file
	 * @param wsdlUrl
	 * @return
	 * @throws Exception
	 */
	public static int getWSDLVersion(String wsdlUrl) throws Exception {
		InputStream stream = null;
		if (new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS).isValid(wsdlUrl)) {
			stream = (new URL(wsdlUrl)).openStream();
		} else {
			stream = new FileInputStream(wsdlUrl);
		}
		OMElement documentElement = new StAXOMBuilder(stream)
				.getDocumentElement();
		String localName = documentElement.getLocalName();
		if (localName.equals("definitions")) {
			return WSDL_VERSION_11;
		} else if (localName.equals("description")) {
			return WSDL_VERSION_20;
		}
		return 0;
	}
	
	/**
	 * get WSDL description from WSDL file
	 * 
	 * @param wsdlUrl WSDL URL as string
	 * @return WSDL Description
	 * @throws Exception
	 */
	
	public static Description getDescription(String wsdlUrl) throws Exception {
		WSDLFactory factory;
		Description descComp = null;
			factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();
			reader.setFeature(WSDLReader.FEATURE_VALIDATION, false);
			descComp = reader.readWSDL(wsdlUrl);
		
		return descComp;

	}
	
	public static DescriptionElement getDescriptionElement(String wsdlUrl) throws Exception {
	return (DescriptionElement)getDescription(wsdlUrl);
	}
	
	/**
	 * get WSDL2 operations in given WSDL2 description
	 * 
	 * @param description
	 * @return List of WSDL2 operations
	 */
	public static List<InterfaceOperation> getOperations(Description description) {
		List<InterfaceOperation> interfaceOperation = new ArrayList<InterfaceOperation>();
		Interface[] interfaces = description.getInterfaces();
		for (Interface i : interfaces) {
			InterfaceOperation[] operations = i.getInterfaceOperations();
			for (InterfaceOperation operation : operations) {
				interfaceOperation.add(operation);
			}
		}
		return interfaceOperation;
	}
	
}
