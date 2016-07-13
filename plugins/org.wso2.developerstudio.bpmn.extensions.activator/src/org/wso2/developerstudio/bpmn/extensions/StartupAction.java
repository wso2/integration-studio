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

package org.wso2.developerstudio.bpmn.extensions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IStartup;
import org.osgi.framework.Bundle;

public class StartupAction implements IStartup {
    private static final Logger logger = Logger.getLogger(ExtensionConstants.BUNDLE_ID);

    @Override
    public void earlyStartup() {
        try {
            addUserLibraries();
        } catch (CoreException | URISyntaxException | IOException e) {
            logger.log(Level.FINE, ExtensionConstants.ERROR_CREATING_CORRESPONDING_USER_LIBRARY, e);
        }
    }

    /*
     * Adds a user library to runtime eclipse as Activiti Designer Extension.
     */
    public void addUserLibraries() throws CoreException, URISyntaxException, IOException {
        ClasspathContainerInitializer initializer = JavaCore
                .getClasspathContainerInitializer(JavaCore.USER_LIBRARY_CONTAINER_ID);
        Bundle bundle = Platform.getBundle(ExtensionConstants.BUNDLE_ID);
        URL fileURL = bundle.getEntry(ExtensionConstants.WSO2_TASK_LIB_LOCATION);
        ArrayList<IClasspathEntry> classPathEntries = new ArrayList<IClasspathEntry>();
        URL url = FileLocator.toFileURL(fileURL);
        File libFolder = new File(new URI(url.getProtocol(), url.getPath(), null));
        List<File> files = (List<File>) FileUtils.listFiles(libFolder, new String[]{"jar"}, true);
        for (File file : files) {
            if (file.isFile()) {
                classPathEntries.add(JavaCore.newLibraryEntry(new Path(file.getAbsolutePath()).makeAbsolute(),
                        null, null));
            }
        }
        setLibraryPath(initializer, classPathEntries);
    }

    /*
     * Sets the library paths for identified file paths in lib/extensions folder
     */
    public void setLibraryPath(ClasspathContainerInitializer initializer, ArrayList<IClasspathEntry> classPathEntries)
            throws CoreException {
        Path containerPath = new Path(JavaCore.USER_LIBRARY_CONTAINER_ID);
        initializer.requestClasspathContainerUpdate(
                containerPath.append(ExtensionConstants.ACTIVITI_DESIGNER_EXTENSIONS), null, new IClasspathContainer() {
                    public IPath getPath() {
                        return new Path(JavaCore.USER_LIBRARY_CONTAINER_ID)
                                .append(ExtensionConstants.ACTIVITI_DESIGNER_EXTENSIONS);
                    }

                    public int getKind() {
                        return K_APPLICATION;
                    }

                    public String getDescription() {
                        return ExtensionConstants.ACTIVITI_DESIGNER_EXTENSIONS;
                    }

                    public IClasspathEntry[] getClasspathEntries() {
                        IClasspathEntry[] classPathArray = new IClasspathEntry[classPathEntries.size()];
                        return classPathEntries.toArray(classPathArray);
                    }
                });
    }

}
