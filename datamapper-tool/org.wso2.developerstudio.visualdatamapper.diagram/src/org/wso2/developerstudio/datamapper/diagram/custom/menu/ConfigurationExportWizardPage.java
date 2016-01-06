package org.wso2.developerstudio.datamapper.diagram.custom.menu;

import java.io.File;
import java.io.ObjectInputStream.GetField;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.swt.widgets.DirectoryDialog;

public class ConfigurationExportWizardPage extends WizardPage {

	private ISelection selection;
	private Text containerText;
	private Text txtConfigurationFileName;
	private Text txtConfigExportPath;
	private String configExportrPath;
	private String configurationFileName;
	private IProject selectedProject;

	public ConfigurationExportWizardPage(ISelection selection) {
		super("Data Mapper");
		setTitle("Visual Data Mapper Configuration Export");
		setDescription("This wizard export configuration of data mapping.");

		try {
			IProject project = getProject(selection);
			if (project != null) {
				setSelectedProject(project);
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		container.setLayout(new GridLayout(3, false));
		Label fileName = new Label(container, SWT.NONE);
		fileName.setText("Configuration file name:");

		containerText = new Text(container, SWT.BORDER);
		txtConfigurationFileName = new Text(container, SWT.BORDER);
		
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 2;
		gd.widthHint = 400;
		txtConfigurationFileName.setLayoutData(gd);
		txtConfigurationFileName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				setConfigurationFileName(txtConfigurationFileName.getText());
				validate();
			}
		});

		Label fileExportPath = new Label(container, SWT.NONE);
		fileExportPath.setText("Export location");
		txtConfigExportPath = new Text(container, SWT.BORDER);
		GridData gd_txtPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtPath.widthHint = 400;
		txtConfigExportPath.setLayoutData(gd_txtPath);

		txtConfigExportPath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent evt) {
				setConfigExportrPath(txtConfigExportPath.getText());
				txtConfigExportPath.setFocus();
				int charcount = txtConfigExportPath.getCharCount();
				txtConfigExportPath.setSelection(charcount);
				validate();

			}
		});

		if (configExportrPath != null) {
			txtConfigExportPath.setText(configExportrPath);
		} else {
			setPageComplete(false);
		}

		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog exportDirectory = new DirectoryDialog(getShell());
				String directoryName = exportDirectory.open();
				if (directoryName != null) {
					txtConfigExportPath.setText(directoryName);
					setConfigExportrPath(directoryName);
				}
				validate();
			}
		});
		btnBrowse.setText("Browse..");
	}

	private void validate() {
		if ((getConfigExportrPath() == null || getConfigExportrPath().equals(""))) {
			setErrorMessage("Please specify an export path");
			setPageComplete(false);
			return;
		} else if (getConfigurationFileName() == null || getConfigurationFileName().equals("")) {
			setErrorMessage("Please provide a file name");
			setPageComplete(false);
			return;
		}

		else {
			if (!(new File(getConfigExportrPath())).exists()) {
				setErrorMessage("Export path must be a valid path.");
				setPageComplete(false);
				return;
			}
		}
		setErrorMessage(null);
		setPageComplete(true);

	}

	public String getContainerName() {
		return containerText.getText();
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), false, "Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	public String getConfigExportrPath() {
		return configExportrPath;
	}

	public void setConfigExportrPath(String configExportrPath) {
		this.configExportrPath = configExportrPath;
	}

	public static IProject getProject(Object obj) throws Exception {
		if (obj == null) {
			return null;
		}
		if (obj instanceof IResource) {
			return ((IResource) obj).getProject();
		} else if (obj instanceof IStructuredSelection) {
			return getProject(((IStructuredSelection) obj).getFirstElement());
		}
		return null;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}



	public String getConfigurationFileName() {
		return configurationFileName;
	}

	public void setConfigurationFileName(String configurationFileName) {
		this.configurationFileName = configurationFileName;
	}

}
