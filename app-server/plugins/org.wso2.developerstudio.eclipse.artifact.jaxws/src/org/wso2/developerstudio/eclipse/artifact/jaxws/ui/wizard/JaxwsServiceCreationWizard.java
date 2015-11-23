/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.jaxws.ui.wizard;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.jaxws.Activator;
import org.wso2.developerstudio.eclipse.artifact.jaxws.model.JaxwsModel;
import org.wso2.developerstudio.eclipse.artifact.jaxws.utils.JaxUtil;
import org.wso2.developerstudio.eclipse.artifact.jaxws.utils.JaxUtil.CxfServlet;
import org.wso2.developerstudio.eclipse.artifact.jaxws.utils.JaxWSImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.JavaUI;

public class JaxwsServiceCreationWizard  extends AbstractWSO2ProjectCreationWizard{
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New JAX-WS Service Project";
	private static final String JAXWS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.jaxws.project.nature";
	private static final String CXF_CLASSLOADING_DESCRIPTOR = "webapp-classloading.xml";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private JaxwsModel jaxwsModel;
	private IProject project;
	private IFolder sourceFolder;
	private IFolder webappFolder; 
	private IFolder webINF;
	private IFolder resourceFolder;
	private IJavaProject javaProject;
	private IPackageFragmentRoot root;
	
	public JaxwsServiceCreationWizard(){	
		setjaxwsModel(new JaxwsModel());
		setModel(getJaxwsModel());
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(JaxWSImageUtils.getInstance().getImageDescriptor("JAX-WS-wizard.png"));

	}

	public void init(IWorkbench arg0, IStructuredSelection selection) {
		super.init(arg0, selection);
	}
	
	public boolean performFinish() {
		try {
			project = createNewProject();
			ICompilationUnit serviceClass = null;
			sourceFolder =ProjectUtils.getWorkspaceFolder(project, "src", "main", "java");
			webappFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "webapp");
			webINF = ProjectUtils.getWorkspaceFolder(project, "src", "main", "webapp","WEB-INF");
			resourceFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "resources");
			javaProject = JavaCore.create(project);
			IFolder metaINF = ProjectUtils.getWorkspaceFolder(project, "src", "main", "webapp","META-INF");
			Bundle bundle = Activator.getDefault().getBundle();
			IPath resourcePath=new Path("src"+File.separator+"main"+File.separator+"resources"+File.separator+CXF_CLASSLOADING_DESCRIPTOR);
			URL[] urls = FileLocator.findEntries(bundle, resourcePath);
			if(urls!=null && urls.length>0){
				File classLoadingFile = new File(FileLocator.toFileURL(urls[0]).getFile());
				FileUtils.copy(classLoadingFile, new File(metaINF.getLocation().toFile(),CXF_CLASSLOADING_DESCRIPTOR));
			}
			
			JavaUtils.addJavaSupportAndSourceFolder(project, sourceFolder);
			ProjectUtils.createFolder(webappFolder);
			ProjectUtils.createFolder(webINF);
			ProjectUtils.createFolder(resourceFolder);
			IFile webXML = webINF.getFile("web.xml");
			IFile cxfServletXML = webINF.getFile("cxf-servlet.xml");
			webXML.create(new ByteArrayInputStream(JaxUtil.getCXFWebConfig().getBytes()), true, null);
			JaxUtil.CxfServlet cxfServlet = new JaxUtil.CxfServlet();
			cxfServletXML.create(new ByteArrayInputStream(cxfServlet.toString().getBytes()), true, null);
			project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			cxfServlet = new JaxUtil.CxfServlet();
			cxfServlet.deserialize(cxfServletXML);
			
			if (getModel().getSelectedOption().equals("new.jaxws")) {
				serviceClass = createServiceClass(project, cxfServlet, jaxwsModel.getServiceClassPackage(),
						jaxwsModel.getServiceClass());
				String content = cxfServlet.toString().replaceAll("xmlns=\"\"",""); 
				cxfServletXML.setContents(new ByteArrayInputStream(content.getBytes()), IResource.FORCE, null);
				
			} else if (getModel().getSelectedOption().equals("import.jaxwswsdl")) {
				ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());
				progressMonitorDialog.create();
				progressMonitorDialog.open();
				progressMonitorDialog.run(false, false, new CXFCodegenJob());
				
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			}

			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			getModel().getMavenInfo().setPackageName("war");
			createPOM(pomfile);
			ProjectUtils.addNatureToProject(project,
			                                false,
											JAXWS_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { JDT_BUILD_COMMAND },
					new String[] {
							JAXWS_PROJECT_NATURE,
							JDT_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
			if (serviceClass != null) {
				serviceClass.getJavaProject().getProject()
						.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				try {
					IEditorPart javaEditor = JavaUI.openInEditor(serviceClass);
					JavaUI.revealInEditor(javaEditor, (IJavaElement) serviceClass);
				} catch (Exception e) { /* ignore */
				}
			}
			   
		}  catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (IOException e) {
			log.error("I/O error has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}
	
	private ICompilationUnit createServiceClass(IProject project, CxfServlet cxfServlet, String packageName, String className
			) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
		IPackageFragment sourcePackage = root.createPackageFragment(packageName, false, null);
		StringBuffer buffer = new StringBuffer();
		if (!packageName.equalsIgnoreCase("")) {
			buffer.append("package " + packageName + ";\n");
			buffer.append("\n");
		}
		buffer.append("import javax.jws.WebService;\n");
		buffer.append("import javax.jws.WebMethod;\n");
		buffer.append("import javax.jws.WebParam;\n");
		buffer.append("\n");
		buffer.append("@WebService(serviceName = \"" + className + "\")\n" + "public class "
				+ className + "{\n\n");
		buffer.append("\t/** This is a sample web service operation */\n");
		buffer.append("\t@WebMethod(operationName = \"hello\")\n");
		buffer.append("\tpublic String hello(@WebParam(name = \"name\") String txt) {\n");
		buffer.append("\t\treturn \"Hello \" + txt + \" !\";\n");
		buffer.append("\t}\n\n");
		buffer.append("\n}");
		ICompilationUnit cu = sourcePackage.createCompilationUnit(className + ".java",
				buffer.toString(), false, null);
		String address = "/" + cu.getTypes()[0].getElementName();
		address = address.replaceAll("([A-Z])", "_$1"); // split CamelCase
		address = address.replaceAll("^/_", "/");
		address = address.toLowerCase();
		String beanClass = cu.getTypes()[0].getFullyQualifiedName();
		cxfServlet.addServer(cu.getTypes()[0].getElementName(), null, address, beanClass);
		return cu;
	}
	
	
	private class CXFCodegenJob implements IRunnableWithProgress {

		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			String operationText="Generating server side code";
			monitor.beginTask(operationText, 100);
			monitor.subTask("Processing configuration...");
			monitor.worked(10);

			try {
				monitor.subTask("Generating code...");			
				String cxfRuntime = jaxwsModel.getCXFRuntime();
				String sourcePkg = jaxwsModel.getSourcePackage();
		        String sourceDir = sourceFolder.getLocation().toFile().toString();
				String wadlFile = jaxwsModel.getImportFile().getAbsolutePath();
				String os = System.getProperty("os.name").toLowerCase();
				String wsdlFile = jaxwsModel.getImportFile().getAbsolutePath();
				IVMInstall vmInstall= JavaRuntime.getDefaultVMInstall();
				String s = null;
		        String shell =null;
		        String wsdl2java = null;
				ProcessBuilder pb;
				Process p=null;

				if(jaxwsModel.getCxfRuntimeMode().equals("AppSever CXF Runtime")){					
					pb = new ProcessBuilder("java", "-cp", cxfRuntime+"/lib/runtimes/cxf/*","org.apache.cxf.tools.wsdlto.WSDLToJava","-p",sourcePkg, "-d", sourceDir, wsdlFile);
					p = pb.start();
			
				}else{
					if(os.indexOf("win") >= 0){
						shell = "cmd.exe";
						wsdl2java = "wsdl2java.bat";
						if(sourcePkg!=null && sourcePkg.trim().length()>0){
							pb = new ProcessBuilder(shell, "/c", wsdl2java, "-impl", "-server", "-p",sourcePkg, "-d",sourceDir,wadlFile);
						} else {
							pb = new ProcessBuilder(shell, "/c", wsdl2java, "-impl", "-server", "-d",sourceDir,wadlFile);
						}
					} else {
						shell = "sh";
						wsdl2java = "wsdl2java";
						if(sourcePkg!=null && sourcePkg.trim().length()>0){
							pb = new ProcessBuilder(shell, wsdl2java, "-impl", "-server", "-p",sourcePkg, "-d",sourceDir,wadlFile);
						} else {
							pb = new ProcessBuilder(shell, wsdl2java, "-impl", "-server", "-d",sourceDir,wadlFile);
						}
					}
					
					 Map<String, String> env = pb.environment();
					 env.put("CXF_HOME", jaxwsModel.getCXFRuntime());
					 env.put("JAVA_HOME", vmInstall.getInstallLocation().toString());
					 pb.directory(new File(jaxwsModel.getCXFRuntime() + File.separator + "bin" ));
					 p = pb.start();
				}
	            
	            InputStream inputStream = p.getInputStream();
				InputStreamReader in = new InputStreamReader(inputStream);
				BufferedReader stdInput = new BufferedReader(in);
	            InputStream errorStream = p.getErrorStream();
				InputStreamReader inError = new InputStreamReader(errorStream);
				BufferedReader stdError = new BufferedReader(inError);
	            

	            while ((s = stdInput.readLine()) != null) {
	            	monitor.subTask(s);
	            }
	            
	            while ((s = stdError.readLine()) != null) {
	            	log.error(s);
	            }
	            
	            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	            
				monitor.worked(75);	

				monitor.worked(10);
				monitor.subTask("Refreshing project...");
				monitor.worked(5);
				monitor.done();
				
				inputStream.close();
				errorStream.close();
				
				in.close();
				inError.close();

			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}
		
	}
	
	public void setjaxwsModel(JaxwsModel jaxwsModel) {
		this.jaxwsModel = jaxwsModel;
	}

	public JaxwsModel getJaxwsModel() {
		return jaxwsModel;
	}
	
	public IResource getCreatedResource() {
		return null;
	}

}
