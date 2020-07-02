/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.wso2.developerstudio.eclipse.maven.multi.module.linkwitheditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class WSO2MavenMultimoduleLinkWithEditor implements ILinkHelper {
    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
        try {
            IFile file = ResourceUtil.getFile(anInput);

            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IProject[] iProjects = workspace.getRoot().getProjects();
            for (IProject iProject : iProjects) {
                if (iProject.hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
                    IFile iFileSample = iProject.getFile(file.getFullPath());
                    if (iFileSample.exists()) {
                        return new StructuredSelection(iFileSample);
                    }
                }
            }
        } catch (Exception e) {
            // Ignore additional link with editor
            return StructuredSelection.EMPTY;
        }
        return StructuredSelection.EMPTY;
    }

    @Override
    public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
    }
}
