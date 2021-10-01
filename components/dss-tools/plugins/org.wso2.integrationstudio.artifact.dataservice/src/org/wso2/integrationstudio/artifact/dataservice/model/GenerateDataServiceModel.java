/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.artifact.dataservice.model;

import java.sql.DatabaseMetaData;
import java.util.EnumSet;
import java.util.Map;

import org.wso2.integrationstudio.artifact.dataservice.ui.wizard.GenerateDataServicesUtils.Methods;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

public class GenerateDataServiceModel extends ProjectDataModel{
    
    private String datasource;
    private Map<String, EnumSet<Methods>> tables;
    private boolean isGenerateSingleService = true;
    private DatabaseMetaData metadata;
    private String serviceName;
    
    public String getDatasource() {
        return datasource;
    }
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }
    public Map<String, EnumSet<Methods>> getTables() {
        return tables;
    }
    public void setTables(Map<String, EnumSet<Methods>> tableNames) {
        this.tables = tableNames;
    }
    public boolean isGenerateSingleService() {
        return isGenerateSingleService;
    }
    public void setGenerateSingleService(boolean isGenerateSingleService) {
        this.isGenerateSingleService = isGenerateSingleService;
    }
    public DatabaseMetaData getMetadata() {
        return metadata;
    }
    public void setMetadata(DatabaseMetaData metadata) {
        this.metadata = metadata;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
