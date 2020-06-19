/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.maven.multi.module.add.other.projects;

import java.io.File;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class ImportProjectTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

        try {
            if (receiver instanceof IProject
                    && !((IProject) receiver).hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
                String projectLocation = ((IProject) receiver).getLocation().toOSString();
                String workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
                String projectName = File.separator + ((IProject) receiver).getName();
                int lastIndex = projectLocation.lastIndexOf(projectName);  
                String parentLocation = projectLocation.substring(0, lastIndex);
                if (parentLocation.equals(workspaceLocation)) {
                    return true;
                }
            }
        } catch (CoreException e) {
            return false;
        }
        return false;
    }
}
