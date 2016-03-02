/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.datamapper.diagram.custom.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a for loop object with operations and nested for loops it contains
 *
 */
public class ForLoopBean {

    private String iterativeName;
    private String variableName;
    private List<Integer> nestedForLoopList;
    private List<Integer> operationList;
    private int parentIndex;

    public ForLoopBean(String iterativeName, String variableName) {
        nestedForLoopList = new ArrayList<>();
        operationList = new ArrayList<>();
        this.iterativeName = iterativeName;
        this.variableName = variableName;
    }

    public String getIterativeName() {
        return iterativeName;
    }

    public void setIterativeName(String iterativeName) {
        this.iterativeName = iterativeName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public List<Integer> getNestedForLoopList() {
        return nestedForLoopList;
    }

    public void setNestedForLoopList(List<Integer> nestedForLoopList) {
        this.nestedForLoopList = nestedForLoopList;
    }

    public List<Integer> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Integer> operationList) {
        this.operationList = operationList;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }
}
