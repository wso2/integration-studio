/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.integrationstudio.datamapper.servlets;

/**
 * This is a singleton class used to hold schema file paths used in datamapper mediator.
 * 
 * @author lahiru
 *
 */
public class DataMapperConfigHolder {

    private String inputSchemaPath;
    private String outputSchemaPath;
    private String dmcPath;
    private String inputType;
    private String outputType;
    private String inputFile;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }
    
    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    private static DataMapperConfigHolder dataHolderInstance = null;

    private DataMapperConfigHolder() {
    }

    public static DataMapperConfigHolder getInstance() {
        if (dataHolderInstance == null)
            dataHolderInstance = new DataMapperConfigHolder();
        return dataHolderInstance;
    }

    public String getInputSchemaPath() {
        return inputSchemaPath;
    }

    public void setInputSchemaPath(String inputSchemaPath) {
        this.inputSchemaPath = inputSchemaPath;
    }

    public String getOutputSchemaPath() {
        return outputSchemaPath;
    }

    public void setOutputSchemaPath(String outputSchemaPath) {
        this.outputSchemaPath = outputSchemaPath;
    }

    public String getDmcPath() {
        return dmcPath;
    }

    public void setDmcPath(String dmcPath) {
        this.dmcPath = dmcPath;
    }

    public void clearConfigs() {
        this.dmcPath = "";
        this.inputSchemaPath = "";
        this.outputSchemaPath = "";
    }
}
