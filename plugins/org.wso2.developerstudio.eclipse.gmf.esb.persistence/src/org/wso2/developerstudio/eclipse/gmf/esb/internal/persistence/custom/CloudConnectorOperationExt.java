/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.synapse.mediators.template.InvokeMediator;

public class CloudConnectorOperationExt extends InvokeMediator{

	private String connectorComponentName;
	private String operation;
	private String configRef;	
	private String cloudConnectorName;
	
	public String getConnectorComponentName() {
		return connectorComponentName;
	}
	public void setConnectorComponentName(String connectorComponentName) {
		this.connectorComponentName = connectorComponentName;
	}	
	public String getCloudConnectorName() {
		return cloudConnectorName;
	}
	public void setCloudConnectorName(String cloudConnectorName) {
		this.cloudConnectorName = cloudConnectorName;
	}
	public String getConfigRef() {
		return configRef;
	}
	public void setConfigRef(String configRef) {
		this.configRef = configRef;
	}	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}	
}
