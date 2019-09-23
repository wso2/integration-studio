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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible checking the selected resource is eligible for create unit
 * test suite.
 */
public class UnitTestResourceTester extends PropertyTester {

    private static String selectFolderType;
    private static String selectConfigurationFileName;
    private static String selectedFilePath;
    private static boolean isPageSelection;

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

        // If the selected item is an resource, then disable the item
        if (receiver instanceof IFile && ((IFile) receiver).getFileExtension().equals(Constants.XML_EXTENSION)) {
            String[] acceptFolders = { "api", "proxy-services", "sequences" };
            IPath filePath = ((IResource) receiver).getFullPath();

            String filePathString = filePath.toOSString();
            String fileSeperatePattern = Pattern.quote(System.getProperty(Constants.FILE_SEPERATOR));
            String[] pathTypes = filePathString.split(fileSeperatePattern);
            String folder = pathTypes[pathTypes.length - 2];
            setSelectFolderType(folder);
            setSelectedFilePath(filePathString);
            setSelectConfigurationFileName(pathTypes[pathTypes.length - 1]);

            if (Arrays.stream(acceptFolders).anyMatch(folder::equals)) {
                String fileLocation = ((IFile) receiver).getFullPath().toOSString();
                String fileName = ((IFile) receiver).getName();
                String projectName = ((IResource) receiver).getProject().getName();
                String expectedPath = File.separator + projectName + File.separator + "src" + File.separator + "main"
                        + File.separator + "synapse-config" + File.separator + folder + File.separator + fileName;
                if (expectedPath.equals(fileLocation)) {
                    setPageSelection(true);
                    return true;
                }
            }
        } else if (receiver instanceof IFolder && ((IFolder) receiver).getName().equals(Constants.TEST_FOLDER)) {
            String folderLocation = ((IFolder) receiver).getFullPath().toOSString();
            String projectName = ((IResource) receiver).getProject().getName();
            String expectedPath = File.separator + projectName + File.separator + Constants.TEST_FOLDER;

            if (expectedPath.equals(folderLocation)) {
                setPageSelection(false);
                return true;
            }
        }
        return false;
    }

    public static String getSelectFolderType() {
        return selectFolderType;
    }

    public void setSelectFolderType(String type) {
        selectFolderType = type;
    }

    public static String getSelectConfigurationFileName() {
        return selectConfigurationFileName;
    }

    public void setSelectConfigurationFileName(String name) {
        selectConfigurationFileName = name;
    }

    public static String getSelectedFilePath() {
        return selectedFilePath;
    }

    public void setSelectedFilePath(String path) {
        selectedFilePath = path;
    }

    public static boolean isPageSelection() {
        return isPageSelection;
    }

    public static void setPageSelection(boolean isPageSelection) {
        UnitTestResourceTester.isPageSelection = isPageSelection;
    }
}
