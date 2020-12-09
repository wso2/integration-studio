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
package org.wso2.developerstudio.datamapper.diagram.custom.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.datamapper.DataMapperOperatorType;

/**
 * This class should be extend by operation types of datamapper
 *
 */
public class DMOperation {

    private DataMapperOperatorType operatorType;
    private String id;
    private int index = -1;
    private boolean visited;
    private Map<String, Object> properties;

    List<Integer> inputs;
    List<Integer> outPuts;

    public DMOperation(DataMapperOperatorType operatorType, String id, int index) {
        this.operatorType = operatorType;
        this.id = id;
        this.index = index;
        properties = new HashMap<>();
    }

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setInputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public List<Integer> getOutputs() {
        return outPuts;
    }

    public void setOutputs(List<Integer> outPuts) {
        this.outPuts = outPuts;
    }

    public DataMapperOperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(DataMapperOperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + operatorType + "-" + index;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void addProperty(String key, Object value) {
        this.properties.put(key, value);
    }

    public Object getProperty(String key) {
        if (properties.containsKey(key)) {
            return properties.get(key);
        }
        throw new IllegalArgumentException("Property value not found for key :" + key);
    }

}
