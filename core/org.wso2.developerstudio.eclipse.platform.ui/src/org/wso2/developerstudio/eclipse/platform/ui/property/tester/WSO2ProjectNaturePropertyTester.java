/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.platform.ui.property.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

import java.util.List;

/**
 * This is a PropertyTester class for checking a particular IProject has any WSO2 Developer Studio project nature.
 */
public class WSO2ProjectNaturePropertyTester extends PropertyTester {
    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This method is for testing selected IProject has any of WSO2 DevStudio project nature.
     *
     * @param property      - property for testing, this value not used
     * @param args          - additional arguments, this value not used
     * @param expectedValue - expected property value, this value not used
     * @return boolean, true if IProject is a WSO2 project, false otherwise
     * @parm receiver - selected IProject object
     */
    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

        if (receiver instanceof IProject) {
            IProject project = (IProject) receiver;

            //Getting all the WSO2 Developer Studio defined project natures
            List<String> wso2ProjectNatures = Constants.getAllNatures();
            for (String nature : wso2ProjectNatures) {
                try {
					if (project.isOpen() && project.hasNature(nature)) {
                        return true;
                    }
                } catch (CoreException e) {
                    log.error("Error in checking IProject : " + project + ", for having Nature : " + nature, e);
                }
            }
        } else {
            log.error("Invalid IResource type sent to WSO2ProjectNaturePropertyTester, Type : " + receiver.getClass() + " , Expected : " + IProject.class);
            return false;
        }
        return false;
    }

}