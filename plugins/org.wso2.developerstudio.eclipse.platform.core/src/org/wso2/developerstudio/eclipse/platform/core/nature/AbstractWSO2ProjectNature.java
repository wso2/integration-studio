package org.wso2.developerstudio.eclipse.platform.core.nature;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public abstract class AbstractWSO2ProjectNature implements IProjectNature {

	private IProject selectedProject;

	protected void addJavaProjectNature() throws CoreException {
		IProject project = getProject();
		String[] folderList = new String[] { "src", "main", "java" };
		IFolder sourceFolder = ProjectUtils.getWorkspaceFolder(project, folderList);
		JavaUtils.addJavaSupportAndSourceFolder(project, sourceFolder);
	}

	public IProject getProject() {
		return selectedProject;
	}

	public void setProject(IProject project) {
		this.selectedProject = project;
	}
}
