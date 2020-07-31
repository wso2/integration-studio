package org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager;

import java.util.List;
import java.util.Map;

public class AndConditionOperation extends ConditionOperation {

    public AndConditionOperation(List<EnableCondition> arguments) {
        super(arguments);
    }

    @Override
    public boolean isValid(Map<String, String> componentsValueMap) {
        for (EnableCondition argument : getArguments()) {
            if (!argument.isValid(componentsValueMap)) {
                return false;
            }
        }

        return true;
    }
}
