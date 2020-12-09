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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.utils;

import static org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This enum represents the property scope types in ESB Server.
 *
 */
public enum ESBPropertyScopeType {

    AXIS2_SCOPE(AXIS2_PROPERTIES_KEY), AXIS2_CLIENT_SCOPE(AXIS2_CLIENT_PROPERTIES_KEY), TRANSPORT_SCOPE(
            TRANSPORT_PROPERTIES_KEY), SYNAPSE_SCOPE(SYNAPSE_PROPERTIES_KEY), OPERATION_SCOPE(OPERATION_PROPERTIES_KEY);

    private final String scope;

    private ESBPropertyScopeType(String scopeName) {
        scope = scopeName;
    }

    public boolean equalsName(String scopeName) {
        return (scopeName == null) ? false : scope.equals(scopeName);
    }

    @Override
    public String toString() {
        return this.scope;
    }
}
