package org.wso2.developerstudio.eclipse.ds.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditorPlugin;

public class DsModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

	public DsModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
		super(pageId, selection);
	}

	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !DataServiceCreationWizard.FILE_EXTENSIONS.contains(extension)) {
				String key =
				             DataServiceCreationWizard.FILE_EXTENSIONS.size() > 1
				                                                                 ? "_WARN_FilenameExtensions"
				                                                                 : "_WARN_FilenameExtension";
				setErrorMessage(DsEditorPlugin.INSTANCE.getString(key,
				                                                  new Object[] { DataServiceCreationWizard.FORMATTED_FILE_EXTENSIONS }));
				return false;
			}
			return true;
		}
		return false;
	}

	public IFile getModelFile() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = getContainerFullPath().append(getFileName());
		IFile ifile = root.getFile(path);
		return ifile;
	}
}
