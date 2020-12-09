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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnableConditionManager {

    private final Map<String, List<EnableCondition>> enableConditionsMap;
    private final Map<String, Composite> compositeList;
    private final Map<String, String> dependantComponentValuesMap;

    public EnableConditionManager(Map<String, Composite> compositeList) {

        enableConditionsMap = new HashMap<>();
        dependantComponentValuesMap = new HashMap<>();
        this.compositeList = compositeList;
    }

    public void addEnableCondition(final EnableCondition enableCondition, String targetComponent) {

        if (enableCondition != null) {
            enableCondition.setTargetComponent(targetComponent);
            List<String> componentsList = enableCondition.getComponentsList();
            for (String component : componentsList) {
                if (enableConditionsMap.containsKey(component)) {
                    enableConditionsMap.get(component).add(enableCondition);
                } else {
                    enableConditionsMap.put(component, new ArrayList<>(Collections.singletonList(enableCondition)));
                }
            }
        }
    }

    public void handleValueChange(String componentName, String value) {

        dependantComponentValuesMap.put(componentName, value);
        if (enableConditionsMap.containsKey(componentName)) {
            List<EnableCondition> enableConditions = enableConditionsMap.get(componentName);
            for (EnableCondition enableCondition : enableConditions) {
                setComponentVisibility(enableCondition, enableCondition.isValid(dependantComponentValuesMap));
            }
        }
    }

    public void handleValueChange(List<CallTemplateParameter> parameterList) {
        for (CallTemplateParameter parameter : parameterList) {
            handleValueChange(parameter.getParameterName(), parameter.getParameterValue());
        }
    }

    private void setComponentVisibility(EnableCondition enableCondition, boolean visibility) {

        String targetComponentName = enableCondition.getTargetComponentName();
        if (compositeList.containsKey(targetComponentName)) {
            Composite composite = compositeList.get(targetComponentName);
            composite.setVisible(visibility);
            ((GridData) composite.getLayoutData()).exclude = !visibility;
            composite.getParent().getParent().layout();
        }
    }

}
