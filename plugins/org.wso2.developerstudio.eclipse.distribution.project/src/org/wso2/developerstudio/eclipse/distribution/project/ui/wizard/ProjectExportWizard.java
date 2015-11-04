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

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;

import java.io.File;
import java.util.List;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.distribution.project.model.GeneralArtifact;
import org.wso2.developerstudio.eclipse.distribution.project.model.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ProjectExportWizard extends Wizard implements IExportWizard {
	private ExportDetailsWizardPage detailsPage;
	private final int ESB_PROJECT=1;
	private final int GENERAL_PROJECT=2;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();

	public void init(IWorkbench wb, IStructuredSelection selection) {
		detailsPage = new ExportDetailsWizardPage(wb, selection);

	}

	public void addPages() {
		addPage(detailsPage);
		super.addPages();
	}

	public boolean performFinish() {
		MessageBox exportMsg = new MessageBox(getShell(), SWT.ICON_ERROR);
		exportMsg.setText("WSO2 Platform Distribution");
		IProject project = detailsPage.getSelectedProject();
		try {
			if(project.hasNature(Constants.AXIS2_PROJECT_NATURE) ||
					   project.hasNature(Constants.BPEL_PROJECT_NATURE) ||
					   project.hasNature(Constants.DS_VALIDATOR_PROJECT_NATURE) ||
					   project.hasNature(Constants.JAXWS_PROJECT_NATURE) ||
					   project.hasNature(Constants.JAXRS_PROJECT_NATURE) ||
					   project.hasNature(Constants.WEBAPP_PROJECT_NATURE) ||
					   project.hasNature(Constants.GADGET_PROJECT_NATURE) ||
					   project.hasNature(Constants.LIBRARY_PROJECT_NATURE) ||
					   project.hasNature(Constants.MEDIATOR_PROJECT_NATURE) ||
					   project.hasNature(Constants.REGISTRY_FILTER_PROJECT_NATURE) ||
					   project.hasNature(Constants.REGISTRY_HANDLER_PROJECT_NATURE) ||
					   project.hasNature(Constants.CARBON_UI_PROJECT_NATURE)||
					   project.hasNature(Constants.ANALYTICS_PROJECT_NATURE)||
					   project.hasNature(Constants.BRS_PROJECT_NATURE)||
					   project.hasNature(Constants.JAGGERY_NATURE)){
				exportArchivable(project);
			} else if(project.hasNature(Constants.ESB_PROJECT_NATURE)){
				exportNonArchivable(project,ESB_PROJECT);
			} else if(project.hasNature(Constants.GENERAL_PROJECT_NATURE)){
				exportNonArchivable(project,GENERAL_PROJECT);
			}
		} catch (Exception e) {
			log.error("An error occured while creating the archive file", e);
			exportMsg
					.setMessage("An error occured while creating the archive file. For more details view the log.");
			exportMsg.open();
		}
		setSessionProperty();
		return true;
	}
	private void setSessionProperty(){		
        try {
        	detailsPage.getSelectedProject().setSessionProperty(new QualifiedName("",detailsPage.getSelectedProject().getName()),
					detailsPage.getTxtExportPathText().getText());
		} catch (CoreException e) {
			log.error("Error geting session properties", e);	
		}
	}

	private void exportArchivable(IProject project) throws Exception{
		String cAppType = "";
		MavenProject mavenProject;
		String ext = "";
		String finalFileName = "";
		mavenProject = DistProjectUtils.getMavenProject(project);
		cAppType = mavenProject.getModel().getPackaging();
		String version = mavenProject.getModel().getVersion();
		if (cAppType == null
				|| !artifactTypeMapping.isValidArtifactType(cAppType)) {
			if (mavenProject.getModel().getProperties()
					.containsKey("CApp.type")) {
				cAppType = (String) mavenProject.getModel().getProperties()
						.get("CApp.type");
			}
		}
		List<IResource> archive = ExportUtil.buildProject(
				detailsPage.getSelectedProject(), cAppType);
		if (archive.size() == 1) {
			ext = artifactTypeMapping.getType(cAppType);
			finalFileName = String.format("%s_%s.%s", project.getName(),
					version, ext);
			File destFileName = new File(detailsPage.getExportPath(),
					finalFileName);
            if(destFileName.exists()){
                org.apache.commons.io.FileUtils.deleteQuietly(destFileName);
            }
			FileUtils.copy(archive.get(0).getLocation().toFile(), destFileName);
		} else {
			throw new Exception("No resource found that matches the given type " + cAppType);
		}
	}
	
	private void exportNonArchivable(IProject project, int type) throws Exception{
		MavenProject mavenProject = DistProjectUtils.getMavenProject(project);
		String version = mavenProject.getModel().getVersion();
		String finalFileName = String.format("%s_%s", project.getName(),
		version);
		File destFileName = new File(detailsPage.getExportPath(),
		finalFileName);
		IFile artifactXMLFile = project.getFile(Constants.ARTIFACT_XML);
		if (artifactXMLFile.exists()) {
			GeneralProjectArtifact artifactXMLDoc = new GeneralProjectArtifact();
				artifactXMLDoc.fromFile(artifactXMLFile.getLocation().toFile());
				List<GeneralArtifact> artifacts = artifactXMLDoc.getAllESBArtifacts();
				if(type==ESB_PROJECT){
					exportESBArtifact(artifacts,project,destFileName);
				} else if (type==GENERAL_PROJECT){
					exportRegResources(artifacts,project,destFileName);
				}
		}
	}
	
	private void exportESBArtifact(List<GeneralArtifact> artifacts,
			IProject project, File dir) throws Exception {
		File synapseConfigDir = new File(dir, "synapse-config");
		File endpointsDir = new File(synapseConfigDir, "endpoints");
		File localEntriesDir = new File(synapseConfigDir, "local-entries");
		File proxyServicesDir = new File(synapseConfigDir, "proxy-services");
		File sequencesDir = new File(synapseConfigDir, "sequences");
		File tasksDir = new File(synapseConfigDir, "tasks");
		File apiDir = new File(synapseConfigDir, "api");
		File templatesDir = new File(synapseConfigDir, "templates");
		File messageStoresDir = new File(synapseConfigDir, "message-stores");
		File messageProcessorsDir = new File(synapseConfigDir, "message-processors");
		File eventSourcesDir = new File(synapseConfigDir, "event-sources");
		File priorityExecutorsDir = new File(synapseConfigDir, "priority-executors");
		if (!synapseConfigDir.exists())
			synapseConfigDir.mkdirs();
		if (!endpointsDir.exists())
			endpointsDir.mkdirs();
		if (!proxyServicesDir.exists())
			proxyServicesDir.mkdirs();
		if (!localEntriesDir.exists())
			localEntriesDir.mkdirs();
		if (!sequencesDir.exists())
			sequencesDir.mkdirs();
		if (!tasksDir.exists())
			tasksDir.mkdirs();
		if (!apiDir.exists())
			apiDir.mkdirs();
		if (!templatesDir.exists())
			templatesDir.mkdirs();
		if (!messageStoresDir.exists())
			messageStoresDir.mkdirs();
		if (!messageProcessorsDir.exists())
			messageProcessorsDir.mkdirs();
		if (!eventSourcesDir.exists())
			eventSourcesDir.mkdirs();
		if (!priorityExecutorsDir.exists())
			priorityExecutorsDir.mkdirs();
		for (GeneralArtifact artifact : artifacts) {
			String type = artifact.getType();
			File file = project.getFile(artifact.getFile()).getLocation().toFile();
			File dstFile=null;
			if(file.exists()){
				String artifactFile = file.getName();
				if("synapse/local-entry".equals(type)){
					dstFile = new File(localEntriesDir,artifactFile);
				} else if("synapse/proxy-service".equals(type)){
					dstFile = new File(proxyServicesDir,artifactFile);
				} else if("synapse/endpoint".equals(type)){
					dstFile = new File(endpointsDir,artifactFile);
				} else if("synapse/sequence".equals(type)){
					dstFile = new File(sequencesDir,artifactFile);
				} else if("synapse/configuration".equals(type)){
					dstFile = new File(synapseConfigDir,artifactFile);
				} else if("synapse/task".equals(type)){
					dstFile = new File(tasksDir,artifactFile);
				} else if("synapse/api".equals(type)){
					dstFile = new File(apiDir,artifactFile);
				} else if("synapse/template".equals(type)){
					dstFile = new File(templatesDir,artifactFile);
				} else if("synapse/message-store".equals(type)){
					dstFile = new File(messageStoresDir,artifactFile);
				} else if("synapse/message-processors".equals(type)){
					dstFile = new File(messageProcessorsDir,artifactFile);
				} else if("synapse/event-source".equals(type)){
					dstFile = new File(eventSourcesDir,artifactFile);
				} else if("synapse/priority-executor".equals(type)){
					dstFile = new File(priorityExecutorsDir,artifactFile);
				} else{
					log.warn("ignoring unrecognized type " + type);	
					continue;
				}
                if(dstFile.exists()){
                    org.apache.commons.io.FileUtils.deleteQuietly(dstFile);
                }
				FileUtils.copy(file, dstFile);
			}
		}
	}
	
	private void exportRegResources(List<GeneralArtifact> artifacts,IProject project,File dir) throws Exception{
		List<IResource> buildProject = ExportUtil.buildProject(
				project,
				"registry/resource");
		for(IResource res : buildProject) {
			if(res instanceof IFolder){
				File dstFile= new File(dir,res.getName());
                if(dstFile.exists()){
                    org.apache.commons.io.FileUtils.deleteQuietly(dstFile);
                }
				FileUtils.copyDirectory(res.getLocation().toFile(),
						dstFile);
			}
		}
	}
}
