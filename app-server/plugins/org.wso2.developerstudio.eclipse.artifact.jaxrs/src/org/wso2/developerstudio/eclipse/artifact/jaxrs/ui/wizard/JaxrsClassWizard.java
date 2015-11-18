/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.jaxrs.ui.wizard;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IBuffer;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.artifact.jaxrs.Activator;
import org.wso2.developerstudio.eclipse.artifact.jaxrs.utils.JaxUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class JaxrsClassWizard extends Wizard implements INewWizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	IWorkbench workbench;
	IStructuredSelection selection;
	JaxrsClassWizardPage classWizardPage;
	private IProject selectedProject;
	
	public void addPages() {
		classWizardPage = new JaxrsClassWizardPage(workbench, selection);
		addPage(classWizardPage);
		classWizardPage.init(selection);
		classWizardPage.setImageDescriptor(Activator.getImageDescriptor("icons/JAX-RS-wizard.png"));
	}
	
	
	public boolean performFinish() {
		String id = "";
		String address = "";
		String serviceClass ="";
		
		try {
					
			IProject project = getSelectedProject();
			IFolder sourceFolder =ProjectUtils.getWorkspaceFolder(project, "src", "main", "java");
			IFolder webINF = ProjectUtils.getWorkspaceFolder(project, "src", "main", "webapp","WEB-INF");
			IFile cxfServletXML = webINF.getFile("cxf-servlet.xml");
			IJavaProject javaProject = JavaCore.create(project);
			IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
			
			if(classWizardPage.getIsCreateIfClass()){
				String ifPkg = classWizardPage.getIfPkg();
				String ifClass = classWizardPage.getIfClass();
			
				IPackageFragment ifSourcePackage = root.getPackageFragment(ifPkg);
				if(!ifSourcePackage.exists()){
					ifSourcePackage = root.createPackageFragment(ifPkg, false, null);
				}
				ICompilationUnit compilationUnit = ifSourcePackage.createCompilationUnit(ifClass
					+ ".java", JaxUtil.getServiceClassSource(ifPkg, ifClass,
					classWizardPage.isCreateStubs()), false, null);
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				
				List superInterfaces = classWizardPage.getSuperInterfaces();
				superInterfaces.add(compilationUnit.getTypes()[0].getFullyQualifiedName());
				classWizardPage.setSuperInterfaces(superInterfaces, false);
				
				id = compilationUnit.getTypes()[0].getElementName();
				id = Character.toLowerCase(id.charAt(0)) + id.substring(1);
				serviceClass = "";
				address = "/" + compilationUnit.getTypes()[0].getElementName();
				
			}
			
			classWizardPage.createType(new NullProgressMonitor());
			IType classSource = classWizardPage.getCreatedType();
			ICompilationUnit unit = classSource.getCompilationUnit();
			unit.getJavaProject().getProject().refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			
			unit.becomeWorkingCopy(new NullProgressMonitor());
			unit.createImport("javax.ws.rs.Path", null,new NullProgressMonitor());
			String source = unit.getSource();
			String searchFor = "public class " + classSource.getTypeQualifiedName();
			int pos = source.indexOf(searchFor);
			source = (source.substring(0,pos)+ "@Path(\"/"+"\")"+ System.getProperty("line.separator") +source.substring(pos));
			IBuffer workingCopyBuffer = unit.getBuffer();
			workingCopyBuffer.setContents(source);
			unit.commitWorkingCopy(false, new NullProgressMonitor());
			
			try {
				
				if(!classWizardPage.getIsCreateIfClass()){ 
					id = unit.getTypes()[0].getElementName();
					id = Character.toLowerCase(id.charAt(0)) + id.substring(1);
					serviceClass = unit.getTypes()[0].getFullyQualifiedName();
					address = "/" + unit.getTypes()[0].getElementName();
				}
				
				JaxUtil.CxfServlet cxfServlet = new JaxUtil.CxfServlet();
				cxfServlet.deserialize(cxfServletXML);
				address = address.replaceAll("([A-Z])", "_$1"); // split CamelCase
				address = address.replaceAll("^/_", "/");
				address = address.toLowerCase();
				String beanClass = unit.getTypes()[0].getFullyQualifiedName();
				cxfServlet.addServer(id , serviceClass, address,beanClass );			
				String content = cxfServlet.toString().replaceAll("\\ xmlns=\"\"",""); 
				cxfServletXML.setContents(new ByteArrayInputStream(content.getBytes()), IResource.FORCE, null);
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				
				try {
					IEditorPart javaEditor = JavaUI.openInEditor(unit);
					JavaUI.revealInEditor(javaEditor, (IJavaElement) unit);
				} catch (Exception e) {/* ignore */
					log.error("Exception has occurred", e);
				}
				
			} catch (Exception e) {
				log.error("cannot update cxf-servlet.xml", e);
			}

		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (InterruptedException e) {
			log.error("An InterruptedException has occurred", e);
		}
		return true;
	}

	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	      this.workbench = workbench;
	      this.selection = selection;
	      setSelectedProject(getProject(selection));
	      setWindowTitle("New JAX-RS class");
	      setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/JAX-RS-wizard.png"));
	}
	
	public static IProject getProject(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IJavaElement) { 
        	return ((IJavaElement) obj).getJavaProject().getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getProject(((IStructuredSelection) obj).getFirstElement());
        }
        return null;
    }


	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}


	public IProject getSelectedProject() {
		return selectedProject;
	}
	
	

}
