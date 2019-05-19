/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.action;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.Activator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomRunWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.CustomWizardDialog;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.runtest.UnitTestConfigurationWizard;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.unittest.UnitTestSuiteCreationWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible for running the unit test suites with configuration wizard.
 */
public class RunSynapseUnitTestAction implements IActionDelegate {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private IStructuredSelection selection;

    /**
     * Method of running ILauncher with maven dependencies.
     */
    public void run(IAction action) {

        if (checkTestSuitesAvailable()) {
            UnitTestConfigurationWizard wizard = new UnitTestConfigurationWizard();
            wizard.init(PlatformUI.getWorkbench(), selection);
            CustomRunWizardDialog testRunWizardDialog = new CustomRunWizardDialog(
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
            testRunWizardDialog.open();
        }

    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }

    /**
     * Method for checking test suites exists in the test folder to proceed testing.
     * 
     * @return boolean value of existence
     */
    private boolean checkTestSuitesAvailable() {
        boolean isTestFilesExists = true;
        try {
            IProject project = getSelectedProject(selection);
            if (project != null) {
                IFolder testIFolder = project.getFolder(new Path(Constants.TEST_FOLDER));
                File testFolder = new File(testIFolder.getLocation().toOSString());
                File[] filesList = testFolder.listFiles();

                boolean isFileExists = false;
                for (File file : filesList) {
                    if (file.isFile()) {
                        isFileExists = true;
                        break;
                    }
                }

                if (!isFileExists) {
                    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                    MessageBox messageBox = new MessageBox(window.getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);

                    messageBox.setText("No Unit Test Suites Found");
                    messageBox.setMessage("0 unit test suites found! Do you want to create an new unit test suite?");
                    int response = messageBox.open();
                    if (response == SWT.YES) {
                        UnitTestSuiteCreationWizard wizard = new UnitTestSuiteCreationWizard(project);
                        wizard.init(PlatformUI.getWorkbench(), null);
                        CustomWizardDialog mockServiceWizardDialog = new CustomWizardDialog(window.getShell(), wizard);
                        mockServiceWizardDialog.setHelpAvailable(false);
                        mockServiceWizardDialog.open();
                    }

                    isTestFilesExists = false;
                }
            }
        } catch (CoreException e) {
            log.error("Error getting session properties", e);
        } catch (Exception e) {
            log.error("Error reading project", e);
        }

        return isTestFilesExists;
    }

    /**
     * Method for getting current project from IStructuredSelection.
     * 
     * @param obj
     *            IStructuredSelection as an object
     * @return IProject
     */
    private IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }
}
