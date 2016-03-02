/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;

import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_RESOURCE;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.EsbTemplateFormatter;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class NewResourceTemplateDialog extends Dialog {
	private static IDeveloperStudioLog log = Logger
			.getLog("org.wso2.developerstudio.eclipse.esb.editor");

	private Text txtResourceName;
	private Text txtRegistryPath;
	private ArtifactTemplate[] artifactTemplates;
	private List lstTemplates;
	private int emptyXmlFileTemplate;
	private int emptyTextFileTemplate;
	private String selectedPath;
	private String ipathOfSelection;
	private Map<String, java.util.List<String>> filters;

	private Combo cmbProject;

	private Button btnOpenResourceOnce;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public NewResourceTemplateDialog(Shell parentShell, Map<String, java.util.List<String>> filters) {
		super(parentShell);
		setFilters(filters);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());

		Label lblProject = new Label(container, SWT.NONE);
		FormData fd_lblProject = new FormData();
		fd_lblProject.top = new FormAttachment(0, 31);
		fd_lblProject.left = new FormAttachment(0, 10);
		lblProject.setLayoutData(fd_lblProject);
		lblProject.setText("Project");

		cmbProject = new Combo(container, SWT.READ_ONLY);
		cmbProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		FormData fd_cmbProject = new FormData();
		fd_cmbProject.left = new FormAttachment(lblProject, 16);
		fd_cmbProject.top = new FormAttachment(lblProject, -5, SWT.TOP);
		cmbProject.setLayoutData(fd_cmbProject);
		
		Link linkButton = new Link(container, SWT.NULL);
		linkButton.setText("<a>Create New Project</a>");
		
		FormData fd_linkButton = new FormData();
		fd_linkButton.left = new FormAttachment(lblProject, 16);
		fd_linkButton.top = new FormAttachment(cmbProject, 40, SWT.TOP);
		linkButton.setLayoutData(fd_linkButton);
		linkButton.addListener (SWT.Selection, new Listener () {
		      public void handleEvent(Event event) {
		    	  Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		    	  
					IProject generalProject = GeneralProjectUtils.createGeneralProject(shell,null);
					if(generalProject!=null){
						cmbProject.add(generalProject.getName());
						if(cmbProject.getItems().length>0){
							cmbProject.select(cmbProject.getItems().length -1);
						}
					}
		        }
		      }); 
		Label lblArtifactName = new Label(container, SWT.NONE);
		FormData fd_lblArtifactName = new FormData();
		fd_lblArtifactName.top = new FormAttachment(linkButton, 22);
		fd_lblArtifactName.right = new FormAttachment(cmbProject, 22, SWT.RIGHT);
		fd_lblArtifactName.left = new FormAttachment(0, 10);
		lblArtifactName.setLayoutData(fd_lblArtifactName);
		lblArtifactName.setText("File name");

		txtResourceName = new Text(container, SWT.BORDER);
		txtResourceName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		txtResourceName.setText("NewResource");
		FormData fd_txtResourceName = new FormData();
		fd_txtResourceName.top = new FormAttachment(lblArtifactName, 6);
		fd_txtResourceName.right = new FormAttachment(cmbProject, 0, SWT.RIGHT);
		fd_txtResourceName.left = new FormAttachment(0, 32);
		txtResourceName.setLayoutData(fd_txtResourceName);

		Label lblRegistryPath = new Label(container, SWT.NONE);
		FormData fd_lblRegistryPath = new FormData();
		fd_lblRegistryPath.top = new FormAttachment(txtResourceName, 17);
		fd_lblRegistryPath.left = new FormAttachment(lblProject, 0, SWT.LEFT);
		lblRegistryPath.setLayoutData(fd_lblRegistryPath);
		lblRegistryPath.setText("Registry path");

		txtRegistryPath = new Text(container, SWT.BORDER);
		txtRegistryPath.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		txtRegistryPath.setText("/_system/config/myresources");
		FormData fd_txtRegistryPath = new FormData();
		fd_txtRegistryPath.top = new FormAttachment(lblRegistryPath, 6);
		fd_txtRegistryPath.left = new FormAttachment(lblProject, 22, SWT.LEFT);
		fd_txtRegistryPath.right = new FormAttachment(cmbProject, 0, SWT.RIGHT);
		txtRegistryPath.setLayoutData(fd_txtRegistryPath);

		Label label = new Label(container, SWT.SEPARATOR | SWT.VERTICAL);
		fd_lblArtifactName.right = new FormAttachment(label, -122);
		fd_cmbProject.right = new FormAttachment(label, -14);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 250);
		fd_label.top = new FormAttachment(0, 10);
		fd_label.bottom = new FormAttachment(0, 198);
		label.setLayoutData(fd_label);

		lstTemplates = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		lstTemplates.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateResourceFileName();
			}
		});
		FormData fd_list = new FormData();
		fd_list.right = new FormAttachment(label, 182, SWT.RIGHT);
		lstTemplates.setLayoutData(fd_list);

		Label lblSelectTemplate = new Label(container, SWT.NONE);
		fd_label.right = new FormAttachment(lblSelectTemplate, -6);
		fd_list.top = new FormAttachment(lblSelectTemplate, 6);
		fd_list.left = new FormAttachment(lblSelectTemplate, 10, SWT.LEFT);
		FormData fd_lblSelectTemplate = new FormData();
		fd_lblSelectTemplate.top = new FormAttachment(0, 26);
		fd_lblSelectTemplate.left = new FormAttachment(0, 258);
		lblSelectTemplate.setLayoutData(fd_lblSelectTemplate);
		lblSelectTemplate.setText("Select template...");
		
		btnOpenResourceOnce = new Button(container, SWT.CHECK);
		fd_list.bottom = new FormAttachment(btnOpenResourceOnce, 0, SWT.BOTTOM);
		FormData fd_btnOpenResourceOnce = new FormData();
		fd_btnOpenResourceOnce.bottom = new FormAttachment(100, -10);
		fd_btnOpenResourceOnce.left = new FormAttachment(lblProject, 0, SWT.LEFT);
		btnOpenResourceOnce.setLayoutData(fd_btnOpenResourceOnce);
		btnOpenResourceOnce.setText("Open resource once created");
		loadCAppProjects();
		loadTemplateList();
		return container;
	}

	private void loadCAppProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		cmbProject.removeAll();
		for (IProject project : projects) {
			try {
				if (project.isOpen()
						&& project.hasNature(Constants.GENERAL_PROJECT_NATURE)) {
					cmbProject.add(project.getName());
				}
			} catch (Exception e) {
				/*ignore*/
			}
		}
		if (cmbProject.getItemCount() > 0) {
			cmbProject.select(0);
		}
	}

	private void validate() {
		Button okButton = getButton(IDialogConstants.OK_ID);
		boolean okButtonState = true;
		if (cmbProject.getText() == null || cmbProject.getText().equals("")
				|| txtResourceName.getText().trim().equals("")
				|| txtRegistryPath.getText().trim().equals("")) {
			okButtonState = false;
		}
		if (okButton!=null){
			okButton.setEnabled(okButtonState);
		}
	}

	private void updateResourceFileName(){
		String resourceName = txtResourceName.getText();
		String resourceFileName = FileUtils.getResourceFileName(resourceName);
		String selectedTemplateExtension = getSelectedTemplateExtension();
		if (selectedTemplateExtension==null){
			txtResourceName.setText(resourceFileName);
		}else{
			txtResourceName.setText(resourceFileName+"."+selectedTemplateExtension);
		}
	}
	
	private String getSelectedTemplateExtension() {
		int selectionIndex = lstTemplates.getSelectionIndex();
		if (selectionIndex == emptyXmlFileTemplate) {
			return "xml";
		} else if (selectionIndex == emptyTextFileTemplate) {
			return "txt";
		} else {
			return artifactTemplates[selectionIndex].getDefaultExtension();
		}
	

	}
	
	private void loadTemplateList() {
		lstTemplates.removeAll();
		artifactTemplates = ArtifactTemplateHandler
				.getArtifactTemplates(getFilters());
		for (ArtifactTemplate artifactTemplate : artifactTemplates) {
			lstTemplates.add(artifactTemplate.getName());
		}
		emptyXmlFileTemplate = lstTemplates.getItemCount();
		lstTemplates.add("Empty XML file");
		emptyTextFileTemplate = lstTemplates.getItemCount();
		lstTemplates.add("Empty text file");

		lstTemplates.select(0);
		updateResourceFileName();
	}

	@Override
	protected void okPressed() {
		int selectionIndex = lstTemplates.getSelectionIndex();
		try {
			String templateString;
			if (selectionIndex == emptyXmlFileTemplate) {
				templateString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			} else if (selectionIndex == emptyTextFileTemplate) {
				templateString = "";
			} else {
				ArtifactTemplate esbArtifactTemplate = artifactTemplates[selectionIndex];
				templateString = FileUtils.getContentAsString(esbArtifactTemplate.getTemplateUrl());
			}
			String name = txtResourceName.getText();
			String content=EsbTemplateFormatter.stripParameters(templateString, name);
			ITemporaryFileTag createNewTempTag = FileUtils.createNewTempTag();
			File tempFile = new File(FileUtils.createTempDirectory(),name);
			tempFile.getParentFile().mkdirs();
			FileUtils.writeContent(tempFile, content);
			String projectName = cmbProject.getText();
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			String path = txtRegistryPath.getText();
			boolean ret = createRegistryArtifact(project,name,path,content);
			if (!ret) {
				MessageDialog.openInformation(getShell(), "Resource creation",
						"A resource already exists with name \'" + name + " on " + projectName);
				return;
			}
			path=path.endsWith("/")?path+name:path+"/"+name;
			setSelectedPath(path);
			setIPathOfSelection(project.getFullPath().append(name).toString());
			createNewTempTag.clearAndEnd();
		} catch (IOException e) {
			log.error(e);
			MessageDialog.openError(getShell(), "Template creation", e
					.getMessage());
			return;
		} catch (CoreException e) {
			log.error(e);
			MessageDialog.openError(getShell(), "Resource creation", e
					.getMessage());
			return;
		} catch (Exception e) {
			log.error(e);
			MessageDialog.openError(getShell(), "Resource creation", e
					.getMessage());
			return;
		}
		super.okPressed();
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		validate();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(446, 340);
	}

	public void setSelectedPath(String selectedPath) {
		this.selectedPath = selectedPath;
	}

	public String getSelectedPath() {
		return selectedPath;
	}

	public void setFilters(Map<String, java.util.List<String>> filters) {
		this.filters = filters;
	}

	public Map<String, java.util.List<String>> getFilters() {
		return filters;
	}
	
	private String getMavenGroupId(File pomLocation){
		String groupId = "org.wso2.carbon";
		if(pomLocation!=null && pomLocation.exists()){
			try {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
				groupId = mavenProject.getGroupId();
			} catch (Exception e) {
				log.error("error reading pom file", e);
			}
		}
		return groupId;
	}
	
	private boolean createRegistryArtifact(IProject project,String fileName, String registryPath,String content) throws Exception{
		File destFile = project.getFile(fileName).getLocation().toFile();
		String resourceName = FileUtils.getResourceFileName(fileName);
		if(destFile.exists()){
			return false;
		}
		
		String groupId = getMavenGroupId(project.getFile("pom.xml").getLocation().toFile());
		groupId += ".resource";
		
		FileUtils.createFile(destFile, content);
		
		RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();
		
		RegistryResourceUtils.createMetaDataForFolder(registryPath, project
				.getLocation().toFile());
		RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,
				project.getLocation().toFile(), registryPath);

		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		generalProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());

		RegistryArtifact artifact = new RegistryArtifact();
		artifact.setName(resourceName);
		artifact.setVersion("1.0.0");
		artifact.setType("registry/resource");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		java.util.List<RegistryResourceInfo> registryResources = regResInfoDoc
				.getRegistryResources();
		for (RegistryResourceInfo registryResourceInfo : registryResources) {
			RegistryElement item = null;
			if (registryResourceInfo.getType() == REGISTRY_RESOURCE) {
				item = new RegistryItem();
				((RegistryItem) item).setFile(registryResourceInfo
						.getResourceBaseRelativePath());
				item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$",
						""));
				artifact.addRegistryElement(item);
			}
		}
		generalProjectArtifact.addArtifact(artifact);
		generalProjectArtifact.toFile();
		addGeneralProjectPlugin(project);
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		return true;
	}
	
	private void addGeneralProjectPlugin(IProject project) throws Exception{
		MavenProject mavenProject;
		
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		if(!mavenProjectPomLocation.exists()){
			mavenProject = MavenUtils.createMavenProject("org.wso2.carbon", project.getName(), "1.0.0","pom");
		} else {
			mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		}
		
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.wso2.maven", "wso2-general-project-plugin",
				ESBMavenConstants.WSO2_GENERAL_PROJECT_VERSION);
		if(pluginExists){
			return ;
		}
		
		mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven",
				"wso2-general-project-plugin", ESBMavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);
		
		PluginExecution pluginExecution;
		
		pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("registry");
		plugin.addExecution(pluginExecution);
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		
		Repository repo = new Repository();
		repo.setUrl("http://dist.wso2.org/maven2");
		repo.setId("wso2-maven2-repository-1");
		
		Repository repo1 = new Repository();
		repo1.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo1.setId("wso2-nexus-maven2-repository-1");
		
		if (!mavenProject.getRepositories().contains(repo)) {
	        mavenProject.getModel().addRepository(repo);
	        mavenProject.getModel().addPluginRepository(repo);
        }

		if (!mavenProject.getRepositories().contains(repo1)) {
	        mavenProject.getModel().addRepository(repo1);
	        mavenProject.getModel().addPluginRepository(repo1);
        }
		
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void setIPathOfSelection(String ipath) {
		ipathOfSelection = ipath;
	}
	public String getIPathOfSelection() {
		return ipathOfSelection;
	}
	
}
