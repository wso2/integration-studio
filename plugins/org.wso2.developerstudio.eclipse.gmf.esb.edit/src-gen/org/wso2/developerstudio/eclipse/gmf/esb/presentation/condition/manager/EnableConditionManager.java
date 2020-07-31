package org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;

import java.util.*;

public class EnableConditionManager {
    private final Map<String, List<EnableCondition>> enableConditionsMap;
    private final Map<String, Composite> compositeList;
    private final Map<String, String> dependantComponentValuesMap;

    public EnableConditionManager(Map<String, Composite> compositeList) {
        enableConditionsMap = new HashMap<>();
        dependantComponentValuesMap = new HashMap<>();
        this.compositeList = compositeList;
    }

    public void addEnableCondition(EnableCondition enableCondition, String targetComponent) {
        if (enableCondition != null) {
            enableCondition.setTargetComponent(targetComponent);
            List<String> componentsList = enableCondition.getComponentsList();
            componentsList.forEach(component -> {
                if (enableConditionsMap.containsKey(component)) {
                    enableConditionsMap.get(component).add(enableCondition);
                } else {
                    enableConditionsMap.put(component, new ArrayList<>(Collections.singletonList(enableCondition)));
                }
            });
        }
    }

    public void handleValueChange(String componentName, String value) {
        dependantComponentValuesMap.put(componentName, value);
        if (enableConditionsMap.containsKey(componentName)) {
            List<EnableCondition> enableConditions = enableConditionsMap.get(componentName);
            enableConditions.forEach(enableCondition ->
                    setComponentVisibility(enableCondition, enableCondition.isValid(dependantComponentValuesMap)));
        }
    }

    public void handleValueChange(List<CallTemplateParameter> parameterList) {
        parameterList.forEach(parameter -> {
            handleValueChange(parameter.getParameterName(), parameter.getParameterValue());
        });
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
