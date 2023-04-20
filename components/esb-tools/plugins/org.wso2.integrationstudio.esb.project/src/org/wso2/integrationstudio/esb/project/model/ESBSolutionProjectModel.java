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
package org.wso2.integrationstudio.esb.project.model;

import org.wso2.integrationstudio.esb.project.utils.SolutionProjectArtifactConstants;
import org.wso2.integrationstudio.platform.core.exception.ObserverFailedException;
import org.wso2.integrationstudio.platform.ui.utils.PlatformUIConstants;

import static org.wso2.integrationstudio.esb.project.utils.SolutionProjectArtifactConstants.*;

public class ESBSolutionProjectModel extends ESBProjectModel {

    private String esbProjectName;
    private String registryProjectName;
    private String connectorExporterProjectName;
    private String compositeApplicationProjectName;
    private String dockerExporterProjectName;
    private String kubernetesExporterProjectName;
    private String mmmProjectName;
    private String projectRuntimeVersion = PlatformUIConstants.EMBEDDED_RUNTIME_DEFAULT_VERSION;
    private boolean isDefaultRuntimeVersionChecked = true;
    private String dataServiceProjectName;
    private String dataSourceProjectName;
    private boolean registryProjectChecked = false;
    private boolean connectorExporterProjectChecked = false;
    private boolean cappProjectChecked = true;
    private boolean isConfigProjectChecked = true;
    private boolean isMMMProjectChecked = true;
    private boolean isDataServiceProjectChecked = false;
    private boolean isDataSourceProjectChecked = false;

    public void setMMMProjectName(String projectName) {
        this.mmmProjectName = projectName;
    }
    
    public String getMMMProjectName() {
        return this.mmmProjectName;
    }
    
    public String getProjectRuntimeVersion() {
        return projectRuntimeVersion;
    }

    public void setProjectRuntimeVersion(String projectRuntimeVersion) {
        this.projectRuntimeVersion = projectRuntimeVersion;
    }

    public boolean isDefaultRuntimeVersionChecked() {
        return isDefaultRuntimeVersionChecked;
    }

    public void setDefaultRuntimeVersionChecked(boolean isDefaultRuntimeVersionChecked) {
        this.isDefaultRuntimeVersionChecked = isDefaultRuntimeVersionChecked;
    }

    public void setConfigProjectChecked(boolean isConfigProjectChecked) {
        this.isConfigProjectChecked = isConfigProjectChecked;
    }
    
    public boolean isConfigProjectChecked() {
        return this.isConfigProjectChecked;
    }
    
    public void setMMMProjectChecked(boolean isMMMProjectChecked) {
        this.isMMMProjectChecked = isMMMProjectChecked;
    }
    
    public boolean isMMMProjectChecked() {
        return this.isMMMProjectChecked;
    }
    
    public String getDockerExporterProjectName() {
        return dockerExporterProjectName;
    }
    
    public String getKubernetesExporterProjectName() {
        return kubernetesExporterProjectName;
    }

    public void setDockerExporterProjectName(String dockerExporterProjectName) {
        this.dockerExporterProjectName = dockerExporterProjectName;
    }
    
    public void setKubernetesExporterProjectName(String kubernetesExporterProjectName) {
        this.kubernetesExporterProjectName = kubernetesExporterProjectName;
    }
    
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

    public boolean isRegistryProjectChecked() {
        return registryProjectChecked;
    }

    public void setRegistryProjectChecked(boolean registryProjectChecked) {
        this.registryProjectChecked = registryProjectChecked;
    }
    
    public boolean isDataServiceProjectChecked() {
        return this.isDataServiceProjectChecked;
    }

    public void setDataServiceProjectChecked(boolean isDataServiceProjectChecked) {
        this.isDataServiceProjectChecked = isDataServiceProjectChecked;
    }
    
    public boolean isDataSourceProjectChecked() {
        return this.isDataSourceProjectChecked;
    }

    public void setDataSourceProjectChecked(boolean isDataSourceProjectChecked) {
        this.isDataSourceProjectChecked = isDataSourceProjectChecked;
    }
    
    public Object getModelPropertyValue(String key) {
        Object modelPropertyValue = super.getModelPropertyValue(key);
        if (modelPropertyValue == null) {
            if (key.equals(ESB_PROJECT_NAME)) {
                return getEsbProjectName();
            } else if (key.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
                return getRegistryProjectName();
            } else if (key.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
                return getConnectorExporterProjectName();
            } else if (key.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
                return getCompositeApplicationProjectName();
            } else if (key.equals(DOCKER_EXPORTER_PROJECT_NAME)) {
                return getDockerExporterProjectName();
            } else if (key.equals(KUBERNETES_EXPORTER_PROJECT_NAME)) {
                return getKubernetesExporterProjectName();
            } else if (key.equals(SolutionProjectArtifactConstants.REGISTRY_PROJECT_CHECKED)) {
                return isRegistryProjectChecked();
            } else if (key.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
                return isConnectorExporterProjectChecked();
            } else if (key.equals(CAPP_PROJECT_CHECKED)) {
                return isCappProjectChecked();
            } else if (key.equals(DOCKER_EXPORTER_PROJECT_CHECKED)) {
                return isDockerExporterProjectChecked();
            } else if (key.equals(KUBERNETES_EXPORTER_PROJECT_CHECKED)) {
                return isKubernetesExporterProjectChecked();
            } else if (key.equals(ESB_PROJECT_CHOICE)) {
                return isConfigProjectChecked();
            } else if (key.equals(MMM_PROJECT_NAME)) {
                return getMMMProjectName();
            } else if (key.equals(MMM_PROJECT_CHOICE)) {
                return isMMMProjectChecked();
            } else if (key.equals(DATA_SERVICE_PROJECT_CHECKED)) {
                return isDataServiceProjectChecked();
            } else if (key.equals(DATA_SERVICE_PROJECT_NAME)) {
                return getDataServiceProjectName();
            } else if (key.equals(DATA_SOURCE_PROJECT_CHECKED)) {
                return isDataSourceProjectChecked();
            } else if (key.equals(DATA_SOURCE_PROJECT_NAME)) {
                return getDataSourceProjectName();
            } else if (key.equals(PROJECT_RUNTIME_VERSION)) {
                return getProjectRuntimeVersion();
            } else if (key.equals(PROJECT_RUNTIME_DEFAULT_VERSION_CHECKED)) {
                return isDefaultRuntimeVersionChecked();
            }
        }
        return modelPropertyValue;

    }

    public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
        boolean returnResult = super.setModelPropertyValue(key, data);
        String value = data.toString();
        if (key.equals(MMM_PROJECT_NAME)) {
            setMMMProjectName(value);
            if (value != null && !value.isEmpty()) {
                if (this.isConfigProjectChecked) {
                    if (this.isMMMProjectChecked) {
                        setEsbProjectName(value + "Configs");
                    } else {
                        setEsbProjectName(value);
                    }
                }
                
                setRegistryProjectName(value + "RegistryResources");
                setConnectorExporterProjectName(value + "ConnectorExporter");
                setCompositeApplicationProjectName(value + "CompositeExporter");
                setDockerExporterProjectName(value + "DockerExporter");
                setKubernetesExporterProjectName(value + "KubernetesExporter");
                setDataServiceProjectName(value + "DataServiceConfigs");
                setDataSourceProjectName(value + "DataSourceConfigs");
            } else {
                setEsbProjectName("");
                setRegistryProjectName("");
                setConnectorExporterProjectName("");
                setCompositeApplicationProjectName("");
                setDockerExporterProjectName("");
                setKubernetesExporterProjectName("");
                setDataServiceProjectName("");
                setDataSourceProjectName("");
            }
        } else if (key.equals(ESB_PROJECT_NAME)) {
            setEsbProjectName(value);
        } else if (key.equals(ESB_PROJECT_CHOICE)) {
            setConfigProjectChecked((boolean) data);
        } else if (key.equals(MMM_PROJECT_CHOICE)) {
            setMMMProjectChecked((boolean) data);
            setEsbProjectName(getMMMProjectName());
            setConfigProjectChecked(true);
        } else if (key.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
            setRegistryProjectName(value);
        } else if (key.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
            setConnectorExporterProjectName(value);
        } else if (key.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
            setCompositeApplicationProjectName(value);
        } else if (key.equals(DOCKER_EXPORTER_PROJECT_NAME)) {
            setDockerExporterProjectName(value);
        } else if (key.equals(KUBERNETES_EXPORTER_PROJECT_NAME)) {
            setKubernetesExporterProjectName(value);
        } else if (key.equals(DATA_SERVICE_PROJECT_NAME)) {
            setDataServiceProjectName(value);
        } else if (key.equals(DATA_SOURCE_PROJECT_NAME)) {
            setDataSourceProjectName(value);
        } else if (key.equals(REGISTRY_PROJECT_CHECKED)) {
            setRegistryProjectChecked((boolean) data);
        } else if (key.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
            setConnectorExporterProjectChecked((boolean) data);
        } else if (key.equals(CAPP_PROJECT_CHECKED)) {
            setCappProjectChecked((boolean) data);
        } else if (key.equals(DOCKER_EXPORTER_PROJECT_CHECKED)) {
            setDockerExporterProjectChecked((boolean) data);
            return (boolean) data;
        } else if (key.equals(KUBERNETES_EXPORTER_PROJECT_CHECKED)) {
            setKubernetesExporterProjectChecked((boolean) data);
            return (boolean) data;
        } else if (key.equals(DATA_SERVICE_PROJECT_CHECKED)) {
            setDataServiceProjectChecked((boolean) data);
        } else if (key.equals(DATA_SOURCE_PROJECT_CHECKED)) {
            setDataSourceProjectChecked((boolean) data);
        } else if (key.equals(PROJECT_RUNTIME_VERSION)) {
            setProjectRuntimeVersion(value);
        } else if (key.equals(PROJECT_RUNTIME_DEFAULT_VERSION_CHECKED)) {
            setDefaultRuntimeVersionChecked((boolean) data);
            setProjectRuntimeVersion(PlatformUIConstants.EMBEDDED_RUNTIME_DEFAULT_VERSION);
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
    
    public void setDataServiceProjectName(String dataServiceProjectName) {
        this.dataServiceProjectName = dataServiceProjectName;
    }
    
    public String getDataServiceProjectName() {
        return dataServiceProjectName;
    }
    
    public void setDataSourceProjectName(String dataSourceProjectName) {
        this.dataSourceProjectName = dataSourceProjectName;
    }
    
    public String getDataSourceProjectName() {
        return dataSourceProjectName;
    }

}
