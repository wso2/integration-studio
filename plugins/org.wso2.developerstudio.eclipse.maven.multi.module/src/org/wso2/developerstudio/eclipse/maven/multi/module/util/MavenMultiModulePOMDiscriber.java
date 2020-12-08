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

package org.wso2.developerstudio.eclipse.maven.multi.module.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.XMLContentDescriber;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

/**
 * This class is used to describe the content of the POM file of a maven multi module project.
 */
public class MavenMultiModulePOMDiscriber extends XMLContentDescriber {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public int describe(InputStream input, IContentDescription description) throws IOException {
        try {
            input.read();
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            if (window != null) {
                IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
                Object firstElement = selection.getFirstElement();
                if (firstElement instanceof IAdaptable) {
                    IProject project = ((File) firstElement).getProject();
                    String[] natureIDs = project.getDescription().getNatureIds();
                    for (String natureID : natureIDs) {
                        if (natureID.equals(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
                            return VALID;
                        }
                    }
                }
            }
        } catch (CoreException e) {
            log.warn(e);
        }
        return INVALID;
    }
}
