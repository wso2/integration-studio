package org.wso2.developerstudio.eclipse.samples.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class ProjectCreationWizard extends Wizard implements INewWizard{
	
	ProjectCreationWizardPage projectCreationWizardPage;
	String name;
	private String projectTitle;
	private ImageDescriptor wizardImageDesc;
	IProject createdProject;
	
	public IProject getCreatedProject() {
		return createdProject;
	}
	public void setCreatedProject(IProject createdProject) {
		this.createdProject = createdProject;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectCreationWizard(String projectName, String title, ImageDescriptor wizardImage){
		setName(projectName);
		setProjectTitle(title);
		setWizardImageDesc(wizardImage);
	}
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
	}

	public boolean performFinish() {
		IProject project = projectCreationWizardPage.getProjectHandle();
		setCreatedProject(project);
		return true;
	}
	
	public void addPages() {
		projectCreationWizardPage = new ProjectCreationWizardPage("New Sample Project");
		projectCreationWizardPage.setInitialProjectName(getName());
		projectCreationWizardPage.setTitle(getProjectTitle());
		projectCreationWizardPage.setImageDescriptor(getWizardImageDesc());
		addPage(projectCreationWizardPage);
//		super.addPages();
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setWizardImageDesc(ImageDescriptor wizardImageDesc) {
		this.wizardImageDesc = wizardImageDesc;
	}
	public ImageDescriptor getWizardImageDesc() {
		return wizardImageDesc;
	}
	
	
	

}
