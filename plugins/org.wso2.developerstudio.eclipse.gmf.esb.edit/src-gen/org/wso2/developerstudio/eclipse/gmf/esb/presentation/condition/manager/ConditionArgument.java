/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConditionArgument extends EnableCondition {

    private String component;
    private String state;

    public ConditionArgument(String component, String state) {

        this.component = component;
        this.state = state;
    }

    @Override
    public List<String> getComponentsList() {

        return Collections.singletonList(component);
    }

    @Override
    public boolean isValid(Map<String, String> componentsValueMap) {

        boolean isValid = false;

        if (componentsValueMap.containsKey(component)) {
            String componentValue = componentsValueMap.get(component);
            isValid = componentValue.equals(state);
        } else if (state == null || state.isEmpty()) {
            isValid = true;
        }

        return isValid;
    }

    public String getComponent() {

        return component;
    }

    public void setComponent(String component) {

        this.component = component;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }
}
