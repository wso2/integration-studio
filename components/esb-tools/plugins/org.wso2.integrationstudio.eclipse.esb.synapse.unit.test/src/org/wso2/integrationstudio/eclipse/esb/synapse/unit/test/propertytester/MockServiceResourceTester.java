/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.propertytester;

import java.io.File;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible checking the selected resource is eligible for create mock
 * service suite.
 */
public class MockServiceResourceTester extends PropertyTester {

    private final String TEST_FOLDER = "test";

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

        if (receiver instanceof IFolder && ((IFolder) receiver).getName().equals(TEST_FOLDER)) {
            String folderLocation = ((IFolder) receiver).getFullPath().toOSString();
            String projectName = ((IResource) receiver).getProject().getName();
            String expectedPath = File.separator + projectName + File.separator + TEST_FOLDER;

            if (expectedPath.equals(folderLocation)) {
                return true;
            }

        } else if (receiver instanceof IFolder && ((IFolder) receiver).getName().equals(Constants.MOCK_SERVICES)) {
            String folderLocation = ((IFolder) receiver).getFullPath().toOSString();
            String projectName = ((IResource) receiver).getProject().getName();
            String expectedPath = File.separator + projectName + File.separator + TEST_FOLDER + File.separator
                    + Constants.SERVICE_RESOURCES + File.separator + Constants.MOCK_SERVICES;

            if (expectedPath.equals(folderLocation)) {
                return true;
            }
        }

        return false;
    }
}
