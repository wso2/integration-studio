package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

/**
 * @generated
 */
public class EsbCreationWizardPage extends WizardNewFileCreationPage {

	/**
	 * @generated
	 */
	private final String fileExtension;

	private String defaultFilename = "synapse";

	/**
	 * @generated
	 */
	public EsbCreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
	}

	/**
	 * Override to create files with this extension.
	 * 
	 * @generated
	 */
	protected String getExtension() {
		return fileExtension;
	}

	/**
	 * @generated
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 * @generated NOT
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		String fileName = getFileName();
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = getDefaultFilename();
		}
		setFileName(EsbDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, getExtension()));
		setPageComplete(validatePage());
	}

	/**
	 * @generated NOT
	 */
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}

		if (!validateProjectNature()) {
			setErrorMessage("Please select a ESB Config project");
			return false;
		}

		if (!validateArtifactName()) {
			return false;
		}

		return true;
	}

	protected boolean validateProjectNature() {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getContainerFullPath().segment(0));
			return project.hasNature(Constants.ESB_PROJECT_NATURE);
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

	protected boolean validateArtifactName() {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getContainerFullPath().segment(0));
			if (!CommonFieldValidator.isValidArtifactName(getFileName())) {
				setErrorMessage("Artifact name cannot contain invalid characters");
				return false;
			} else if (ESBProjectUtils.artifactExists(project, getFileName())) {
				setErrorMessage("An artifact with this name already exists");
				return false;
			} else
				return true;
		} catch (Exception e) {
			// ignore
		}
		return false;
	}

	public void setDefaultFilename(String defaultFilename) {
		this.defaultFilename = defaultFilename;
	}

	public String getDefaultFilename() {
		return defaultFilename;
	}
}
