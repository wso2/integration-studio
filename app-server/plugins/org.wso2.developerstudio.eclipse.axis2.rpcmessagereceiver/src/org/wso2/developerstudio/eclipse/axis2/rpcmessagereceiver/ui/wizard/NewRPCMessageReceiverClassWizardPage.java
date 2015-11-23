/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.utils.Axis2Constants;
import org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.utils.Axis2Utils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class NewRPCMessageReceiverClassWizardPage extends NewClassWizardPage{
	private String selectedProject;
	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	public NewRPCMessageReceiverClassWizardPage() {
		setDescription("Create new rpc message receiver class");
		setTitle("Axis2 RPC Message Receiver Java Class");
	}

	public void init(IStructuredSelection selection) {
	    super.init(selection);
		addSuperInterface(Axis2Constants.MESSAGE_RECEIVER_INTERFACE_NAME);
		setMethodStubSelection(false, false, true, true);
	}
	
	public String createClass() throws CoreException, InterruptedException{
		addAxis2Library();
		createType(new NullProgressMonitor());
		IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), (IFile)getCreatedType().getResource());
		setSelectedProject(getCreatedType().getJavaProject().getElementName());
		return getCreatedType().getFullyQualifiedName();
	}

	private void addAxis2Library() throws JavaModelException {
	    IJavaProject javaProject = getJavaProject();
		JavaUtils.addJarLibraryToProject(javaProject, Axis2Utils.getAxis2LibraryPath());
    }

	public  IProject getProject() {
	    return getJavaProject().getProject();
    }
	
}
