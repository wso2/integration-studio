/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.artifact.cep.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.editor.CEPProjectEditorPage;
import org.wso2.developerstudio.eclipse.artifact.cep.model.CEPModel;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPImageUtils;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPTemplateUtils;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class CEPProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static final String CEP_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.cep.project.nature";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private final CEPModel cepModel;
	private static final String CEP_WIZARD_WINDOW_TITLE = "Create New CEP Project";
	private IProject project;
	private File openFile = null;

	public CEPProjectCreationWizard() {
		this.cepModel = new CEPModel();
		setModel(this.cepModel);
		setWindowTitle(CEP_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(CEPImageUtils.getInstance()
				.getImageDescriptor("buket-64x64.png"));
	}

	public boolean performFinish() {
		CEPProjectEditorPage.isCreatedProject = false;
		boolean already = false;
		try {
			if (getModel().getSelectedOption().equals("import.cepproject")) {
				File importFile = getModel().getImportFile();
				CEPProjectEditorPage.initialFileLocation = importFile
						.getAbsolutePath();
				CEPProjectEditorPage.isNewProject = false;
				IProject exproject = ResourcesPlugin.getWorkspace().getRoot()
						.getProject(cepModel.getProjectName());
				if (exproject.exists()) {
					MessageDialog.openError(getShell(), "ERROR",
							"Project already exisits");
				} else {
					cepModel.setBucketName(cepModel.getProjectName());
					project = createNewProject();
					openFile = addCEPTemplate(project);
				}
			}
			if (getModel().getSelectedOption().equals("new.cepproject")) {
				project = createNewProject();
				openFile = addCEPTemplate(project);
				CEPProjectEditorPage.bucketProjectName = project.getName();
				cepModel.setBucketName(project.getName());
			}
			if (!already) {
				File pomfile = project.getFile("pom.xml").getLocation()
						.toFile();
				getModel().getMavenInfo().setPackageName(
						"cep/bucket");
				createPOM(pomfile);
				ProjectUtils.addNatureToProject(project, false,
						CEP_PROJECT_NATURE);
				MavenUtils
				.updateWithMavenEclipsePlugin(
						pomfile,
						new String[] {  },
						new String[] { CEP_PROJECT_NATURE });
				getModel().addToWorkingSet(project);
				project.refreshLocal(IResource.DEPTH_INFINITE,
						new NullProgressMonitor());
				try {
					refreshDistProjects();
					IFile cepFile = ResourcesPlugin
							.getWorkspace()
							.getRoot()
							.getFileForLocation(
									Path.fromOSString(openFile
											.getAbsolutePath()));

					IDE.openEditor(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage(),
							new FileEditorInput(cepFile),
							"org.wso2.developerstudio.eclipse.artifact.cep.editor.CEPProjectEditor");

				} catch (Exception e) {
					log.error("Cannot open file in editor", e);
				}
			}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}

	private File addCEPTemplate(IProject project) throws Exception {
		String eol = System.getProperty("line.separator");
		ITemporaryFileTag cepTempTag = FileUtils.createNewTempTag();
		File cepTemplateFile = new CEPTemplateUtils()
				.getResourceFile("templates" + File.separator
						+ "cepservice.xml");
		String templateContent = FileUtils.getContentAsString(cepTemplateFile);
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		templateContent = templateContent.replaceAll("<service.name>",
				cepModel.getBucketName());
		IFolder cepfolder = project.getFolder("src" + File.separator + "main"
				+ File.separator + "cepbucket");
		File template = new File(cepfolder.getLocation().toFile(),
				cepModel.getBucketName() + ".xml");
		templateContent = XMLUtil.prettify(templateContent);
		templateContent = templateContent.replaceAll("^" + eol, "");
		FileUtils.createFile(template, templateContent);
		cepTempTag.clearAndEnd();
		return template;
	}

	public IResource getCreatedResource() {
		return project;
	}

}
