/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver40.operations;

import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.wso2.developerstudio.eclipse.carbon.server.model.operations.CommonServiceWSDLRetriever;

public class ServiceWSDLRetriever extends CommonServiceWSDLRetriever {

	protected ServiceWSDLRetriever(IPath path, URL url, int delay) {
	    super(path, url, delay);
    }
}