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

package org.wso2.developerstudio.eclipse.esb.mediators.ui.wizard;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.esb.mediators.utils.MediatorConstants;
import org.wso2.developerstudio.eclipse.esb.mediators.utils.MediatorUtils;
import org.wso2.developerstudio.eclipse.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class NewSynapseMediatorClassWizardPage extends NewClassWizardPage{
	
	private String selectedProject;
	private String[] depedencyList = {"abdera_1.0.0.wso2v3.jar",
									LibraryUtils.axiom_1_2_11_wso2vXX_jar,
									LibraryUtils.axis2_1_6_1_wso2vXX_jar,
									"commons-codec_1.4.0.wso2v1.jar",
									"commons-httpclient_3.1.0.wso2v2.jar",
									"commons-io_2.0.0.wso2v2.jar",
									"commons-logging-1.1.1.jar",
									"geronimo-stax-api_1.0_spec_1.0.1.wso2v2.jar",
									LibraryUtils.httpcore_4_3_0_wso2vXX_jar,
									"neethi_2.0.4.wso2v4.jar",
									"not-yet-commons-ssl-0.3.9.jar",
									LibraryUtils.woden_1_0_0_M8_wso2vXX_jar,
									"wsdl4j_1.6.2.wso2v4.jar",
									"XmlSchema_1.4.7.wso2v2.jar"};
	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public NewSynapseMediatorClassWizardPage() {
		setDescription("Create new synapse Mediator class");
		setTitle("Synapse Mediator Java Class");
	}
	
	public void init(IStructuredSelection selection) {
	    super.init(selection);
		setSuperClass(MediatorConstants.MEDIATOR_ABSTRACT_CLASS_NAME,false);
		setMethodStubSelection(false, false, true, true);
	}
	
	protected IMethod[] createInheritedMethods(IType type,
			boolean doConstructors, boolean doUnimplementedMethods,
			ImportsManager imports, IProgressMonitor monitor)
			throws CoreException {
		String method = "\n public boolean mediate("+
				 imports.addImport(MediatorConstants.MESSAGE_CONTEXT_NAME)+
				" context) \n {\n// TODO Implement your mediation logic here" +
				"\n	return true;}";
		IMethod newMethod = type.createMethod(method, null, false, null);
		return new IMethod[] { newMethod };
	}
	
	public String createClass() throws CoreException, InterruptedException{
		addSynapseLibrary();
		addOtherDependencies();
		createType(new NullProgressMonitor());
		IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), (IFile)getCreatedType().getResource());
		setSelectedProject(getCreatedType().getJavaProject().getElementName());
		return getCreatedType().getFullyQualifiedName();
	}

	private void addSynapseLibrary() throws JavaModelException {
	    IJavaProject javaProject = getJavaProject();
	    File synapseLibraryPath = LibraryUtils.getDependencyPath(LibraryUtils.synapse_core_2_1_2_wso2vXX_jar);
	    JavaUtils.addJarLibraryToProject(javaProject, synapseLibraryPath);
    }
	
	public void addOtherDependencies() throws JavaModelException{
		IJavaProject javaProject = getJavaProject();
		for (String dependencyName : depedencyList) {
			File dependencyPath = LibraryUtils.getDependencyPath(dependencyName);
			JavaUtils.addJarLibraryToProject(javaProject, dependencyPath);
		}
	}

	public  IProject getProject() {
	    return getJavaProject().getProject();
    }
	
}
