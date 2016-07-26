/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project.model;

import org.wso2.developerstudio.eclipse.esb.project.utils.SolutionProjectArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import static org.wso2.developerstudio.eclipse.esb.project.utils.SolutionProjectArtifactConstants.*;

public class ESBSolutionProjectModel extends ESBProjectModel {

	private String esbProjectName;
	private String registryProjectName;
	private String connectorExporterProjectName;
	private String compositeApplicationProjectName;
	private boolean registryProjectChecked = true;
	private boolean connectorExporterProjectChecked = true;

	public boolean isConnectorExporterProjectChecked() {
		return connectorExporterProjectChecked;
	}

	public void setConnectorExporterProjectChecked(boolean connectorExporterProjectChecked) {
		this.connectorExporterProjectChecked = connectorExporterProjectChecked;
	}

	public boolean isCappProjectChecked() {
		return cappProjectChecked;
	}

	public void setCappProjectChecked(boolean cappProjectChecked) {
		this.cappProjectChecked = cappProjectChecked;
	}

	private boolean cappProjectChecked = true;

	public boolean isRegistryProjectChecked() {
		return registryProjectChecked;
	}

	public void setRegistryProjectChecked(boolean registryProjectChecked) {
		this.registryProjectChecked = registryProjectChecked;
	}

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(ESB_PROJECT_NAME)) {
				modelPropertyValue = getEsbProjectName();
			} else if (key.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
				modelPropertyValue = getRegistryProjectName();
			} else if (key.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
				modelPropertyValue = getConnectorExporterProjectName();
			} else if (key.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
				modelPropertyValue = getCompositeApplicationProjectName();
			} else if (key.equals(SolutionProjectArtifactConstants.REGISTRY_PROJECT_CHECKED)) {
				modelPropertyValue = isRegistryProjectChecked();
			} else if (key.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
				modelPropertyValue = isConnectorExporterProjectChecked();
			} else if (key.equals(CAPP_PROJECT_CHECKED)) {
				modelPropertyValue = isCappProjectChecked();
			}
		}
		return modelPropertyValue;

	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals(ESB_PROJECT_NAME)) {
			setEsbProjectName(data.toString());
			if (data.toString() != null && !data.toString().isEmpty()) {
				setRegistryProjectName(data.toString() + "Registry");
				setConnectorExporterProjectName(data.toString() + "ConnectorExporter");
				setCompositeApplicationProjectName(data.toString() + "CompositeApplication");
			} else {
				setRegistryProjectName("");
				setConnectorExporterProjectName("");
				setCompositeApplicationProjectName("");
			}
		} else if (key.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
			setRegistryProjectName(data.toString());
		} else if (key.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
			setConnectorExporterProjectName(data.toString());
		} else if (key.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
			setCompositeApplicationProjectName(data.toString());
		} else if (key.equals(REGISTRY_PROJECT_CHECKED)) {
			setRegistryProjectChecked((boolean) data);
		} else if (key.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
			setConnectorExporterProjectChecked((boolean) data);
		} else if (key.equals(CAPP_PROJECT_CHECKED)) {
			setCappProjectChecked((boolean) data);
		}

		return returnResult;
	}

	public String getEsbProjectName() {
		return esbProjectName;
	}

	public void setEsbProjectName(String esbProjectName) {
		this.esbProjectName = esbProjectName;
	}

	public String getRegistryProjectName() {
		return registryProjectName;
	}

	public void setRegistryProjectName(String registryProjectName) {
		this.registryProjectName = registryProjectName;
	}

	public String getConnectorExporterProjectName() {
		return connectorExporterProjectName;
	}

	public void setConnectorExporterProjectName(String connectorExporterProjectName) {
		this.connectorExporterProjectName = connectorExporterProjectName;
	}

	public String getCompositeApplicationProjectName() {
		return compositeApplicationProjectName;
	}

	public void setCompositeApplicationProjectName(String compositeApplicationProjectName) {
		this.compositeApplicationProjectName = compositeApplicationProjectName;
	}

}
