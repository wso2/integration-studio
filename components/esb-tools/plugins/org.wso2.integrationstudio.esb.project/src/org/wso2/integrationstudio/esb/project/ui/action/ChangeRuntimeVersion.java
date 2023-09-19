/*
 * Copyright (c) 2023, WSO2 LLC (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.esb.project.ui.action;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.wso2.integrationstudio.esb.project.ui.wizard.ESBSolutionProjectCreationWizard;

public class ChangeRuntimeVersion implements IActionDelegate {
    IStructuredSelection selection;

    public void run(IAction action) {
        if (selection != null) {
            IProject project = (IProject) selection.getFirstElement();
            if (project != null) {
                IFile pomXml = project.getFile("pom.xml");
                IPath pomFilePath = pomXml.getLocation();
                File pomFile = pomFilePath.toFile();

                IInputValidator validator = new IInputValidator() {

                    public String isValid(String str) {
                        if (str.trim().isEmpty()) {
                            return "Runtime version cannot be empty";
                        } else if (str.indexOf(0x20) != -1) {
                            return "Runtime version cannot contain spaces";
                        }
                        return null;
                    }

                };

                final InputDialog versionInput = new InputDialog(Display.getCurrent().getActiveShell(),
                        "Enter MI Runtime Version", "MI Runtime Version",
                        ESBSolutionProjectCreationWizard.getRuntimeVersionFromPOM(pomFile), validator) {
                    protected Control createDialogArea(Composite parent) {
                        Composite composite = (Composite) super.createDialogArea(parent);
                        return composite;
                    }
                };
                int open = versionInput.open();
                if (open == Dialog.OK) {
                    String sequenceName = versionInput.getValue();
                    ESBSolutionProjectCreationWizard.addRuntimeVersionToPOM(pomFile, sequenceName);
                }
            }
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }

    }

}
