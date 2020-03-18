/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.dataservice.validators;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

public class DataServiceResourceTester extends PropertyTester {

    private final String DS_FOLDER = "dataservice";
    private final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
    
    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        try {
            if (receiver instanceof IFolder && ((IFolder) receiver).getName().equals(DS_FOLDER)
                    && ((IFolder) receiver).getParent() instanceof IProject
                    && ((IProject) ((IFolder) receiver).getParent()).hasNature(DS_PROJECT_NATURE)) {
                return true;
            }
        } catch (CoreException e) {
            return false;
        }
        return false;
    }
}

