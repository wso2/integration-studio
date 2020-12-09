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
import java.util.regex.Pattern;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible checking the selected resource is eligible for run test
 * suite.
 */
public class RunTestResourceTester extends PropertyTester {

    public static boolean isUnitTestFileSelected = false;
    private static String selectedFileName = null;

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

        // If the selected item is an resource, then disable the item
        if (receiver instanceof IFile && ((IFile) receiver).getFileExtension().equals(Constants.XML_EXTENSION)) {
            String filePathString = ((IResource) receiver).getFullPath().toOSString();
            String fileSeperatePattern = Pattern.quote(System.getProperty(Constants.FILE_SEPERATOR));
            String[] pathTypes = filePathString.split(fileSeperatePattern);
            String folder = pathTypes[pathTypes.length - 2];

            if (folder.equals(Constants.TEST_FOLDER)) {
                String fileLocation = ((IFile) receiver).getFullPath().toOSString();
                String fileName = ((IFile) receiver).getName();
                String projectName = ((IResource) receiver).getProject().getName();
                String expectedPath = File.separator + projectName + File.separator + Constants.TEST_FOLDER
                        + File.separator + fileName;

                if (expectedPath.equals(fileLocation)) {
                    setUnitTestFileSelected(true);
                    setSelectedFileName(((IFile) receiver).getName());
                    return true;
                }
            }
        } else if (receiver instanceof IFolder && ((IFolder) receiver).getName().equals(Constants.TEST_FOLDER)) {
            String folderLocation = ((IFolder) receiver).getFullPath().toOSString();
            String projectName = ((IResource) receiver).getProject().getName();
            String expectedPath = File.separator + projectName + File.separator + Constants.TEST_FOLDER;

            if (expectedPath.equals(folderLocation)) {
                setUnitTestFileSelected(false);
                setSelectedFileName(null);
                return true;
            }
        }

        setUnitTestFileSelected(false);
        setSelectedFileName(null);
        return false;
    }

    public static boolean isUnitTestFileSelected() {
        return isUnitTestFileSelected;
    }

    public static void setUnitTestFileSelected(boolean isUnitTestFileSelected) {
        RunTestResourceTester.isUnitTestFileSelected = isUnitTestFileSelected;
    }

    public static String getSelectedFileName() {
        return selectedFileName;
    }

    public static void setSelectedFileName(String selectedFileLocation) {
        RunTestResourceTester.selectedFileName = selectedFileLocation;
    }
}
