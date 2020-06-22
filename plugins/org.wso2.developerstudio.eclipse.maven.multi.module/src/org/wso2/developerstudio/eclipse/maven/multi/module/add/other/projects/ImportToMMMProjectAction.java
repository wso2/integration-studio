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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class ImportToMMMProjectAction implements IActionDelegate {
    private IStructuredSelection selection;

    /**
     * Method of running ILauncher with maven dependencies.
     */
    public void run(IAction action) {
        
        // save all the existing editors
        IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
        if (pages != null) {
            for (IWorkbenchPage page : pages) {
                IEditorPart editor = page.getActiveEditor();
                if (editor != null) {
                    page.saveEditor(editor, true);
                }
            }
        }
        
        MMMProjectSelectionWizard wizard = new MMMProjectSelectionWizard();
        wizard.init(PlatformUI.getWorkbench(), selection);
        WizardDialog dilog = new WizardDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
        dilog.open();
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }
}
