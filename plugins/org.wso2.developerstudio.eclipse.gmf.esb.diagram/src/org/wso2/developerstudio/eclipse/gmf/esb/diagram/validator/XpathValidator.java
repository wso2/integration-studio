/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;


public class XpathValidator {

	public static  boolean isValidNamespace(Shell activeShell, Map<String, String> namespaceMap, String prefix, String uri) {
		
		if (StringUtils.isBlank(prefix) || StringUtils.isBlank(uri)) {
			return false;
		}
		if (!isValidUrl(uri)) {
			showMessage(activeShell, "Invalid URI \n\n" + uri);
			return false;
		}
		if (namespaceMap.containsKey(prefix)) {
			showMessage(activeShell, "Namespace with the given prefix (" + prefix + ") is already exists");
			return false;
		}
		return true;
	}
	
	public static boolean isValidUrl(String uri) {
		/*
		 * http://org.apache.synapse/xsd url is valid. But following logic doesn't recognize it.
		 * Hence following logic is commented out by reopening TOOLS-1814.
		 */
		
/*		boolean result = true;
		try {
			CommonFieldValidator.isValidUrl(uri, "URI: ");
		}
		catch (Exception e){
			result = false;
		}
		
		return result;*/
		return true;
	}
	
	public static boolean isValidConfiguration(Shell activeShell, String xpath, Map<String, String> namespaceMap) {
		if (!isValidXpathSyntax(xpath)) {
			showMessage(activeShell, "Invalid Xpath Expression.\n\n" + xpath);
			return false;
		}
		
/*		boolean result = true;
		if (xpath.contains(":")) {
			String[] splitedParts = xpath.split("/");
			ArrayList<String> prefixList = new ArrayList<String>();
			for (String part: splitedParts) {
				if (part.length() > 1 && part.contains(":")) {
					String prefix = part.substring(0, part.indexOf(":"));
					prefixList.add(prefix);
				}
			}
			
			for (String prefix : prefixList) {
				if (!namespaceMap.keySet().contains(prefix)) {
						showMessage(activeShell, "The prefix '" + prefix + "' is not contain in the prefix list.");
					result = false;
					break; 
				}
			}
		}*/
		return true;
	}
	
	public static boolean isValidXpathSyntax(String string) {
		/*
		 * get-property('GET_PROXY_PROPERTIES_RETURN_SEQ') xpath expression is valid. But following logic doesn't recognize it.
		 * Hence following logic is commented out by reopening TOOLS-1814.
		 */
		
/*		boolean result = true;
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			@SuppressWarnings("unused")
			XPathExpression expr = xpath.compile(string);
		} catch (XPathExpressionException e) {
			result = false;
		}
	
		return result;*/
		return true;
	}
	
	private static void showMessage(Shell activeShell, String message){
		if (activeShell != null) {
			MessageDialog.openWarning(activeShell, "Error", message);
		}
	}
}
