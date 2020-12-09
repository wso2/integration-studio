/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.wso2.developerstudio.bpel.humantask.model.util;

import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.util.BPELUtils;

public class HTUtils {

	/**
	 * Adds the HumanTask namespace to the given process
	 * @param process
	 * @return the preferred namespace prefix
	 */
	public static String addNamespace(Process process) {
		String nsPrefix = ModelPackage.eINSTANCE.getNsPrefix();
		String nsURI = ModelPackage.eINSTANCE.getNsURI();
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(process);
		nsMap.put(nsPrefix, nsURI);
		return nsPrefix;
	}
	
	
	public static String boolean2XML(Boolean b) {
		if (b == null || b.equals(Boolean.FALSE)) {
			return "no";
		}
		return "yes";
	}
}
