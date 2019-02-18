package org.wso2.developerstudio.eclipse.esb.cloud.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class AppDetailsWizardPage extends WizardPage{
    
    private static final String FILE_VERSION_LABEL_TEXT = "Application version";
    private static final String FILE_NAME_LABEL_TEXT = "Name of the application";
    private static final String DIALOG_TITLE = "WSO2 Platform Distribution - Application Details";
    private static final String EMPTY_STRING = "";

    private Text txtExportPath;
    private Text txtName;
    private Text txtVersion;
    
    private String name = EMPTY_STRING;
    private String version = EMPTY_STRING;
    private String imageName = EMPTY_STRING;
    private String imageTag = EMPTY_STRING;
    private String initialName = EMPTY_STRING;
    private String initialVersion = EMPTY_STRING;
    private String exportPath = EMPTY_STRING;
    
    private IProject selectedProject;
    private boolean isPageDirty = false;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected AppDetailsWizardPage() {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
    }

    protected AppDetailsWizardPage(IWorkbench wb, IStructuredSelection selection) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);

        try {
            IProject project = getProject(selection);
            if (project != null) {
                setSelectedProject(project);
                exportPath = (String) getSelectedProject()
                        .getSessionProperty(new QualifiedName(EMPTY_STRING, getSelectedProject().getName()));
            }
        } catch (CoreException e) {
            log.error("Error getting session properties", e);
        } catch (Exception e) {
            log.error("Error reading project", e);
        }
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(1, false));
        
        Group appTypeGroup = new Group(container, SWT.NONE);
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 130;
        rowLayout.marginBottom = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 200;
        
        appTypeGroup.setLayout(rowLayout);
        
        Button btnNewApplication = new Button(appTypeGroup, SWT.RADIO);
        btnNewApplication.setText("Create New Application");
        btnNewApplication.setSelection(true);
        
        Button btnExistingApplication = new Button(appTypeGroup, SWT.RADIO);
        btnExistingApplication.setText("Update Existing Application");
        
        // Create new Application container
        Composite newAppContainer = new Composite(container, SWT.NULL);
        
        GridData newAppGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        newAppGridData.exclude = false;
        newAppContainer.setLayoutData(newAppGridData);

        setControl(newAppContainer);
        newAppContainer.setLayout(new GridLayout(3, false));
        newAppContainer.setVisible(true);
       
        Label lblName = new Label(newAppContainer, SWT.NONE);
        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblNameGridData.widthHint = 140;
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(FILE_NAME_LABEL_TEXT);

        txtName = new Text(newAppContainer, SWT.BORDER);
        GridData txtNameGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        txtName.setLayoutData(txtNameGridData);
        initialName = getName();
        txtName.setText(initialName);

        txtName.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setName(txtName.getText());
                validate();
            }

        });
        
        Label lblVersion = new Label(newAppContainer, SWT.NONE);
        lblVersion.setText(FILE_VERSION_LABEL_TEXT);

        txtVersion = new Text(newAppContainer, SWT.BORDER);
        GridData txtVersionGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        txtVersionGridData.horizontalAlignment = SWT.FILL;
        initialVersion = getVersion();
        txtVersion.setText(initialVersion);
        txtVersion.setLayoutData(txtVersionGridData);

        txtVersion.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setVersion(txtVersion.getText());
                validate();
            }

        });
        
        // Update existing application container
        
        Composite existingAppContainer = new Composite(container, SWT.NULL);
        
        GridData existingAppData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        existingAppData.exclude = true;
        existingAppContainer.setLayoutData(existingAppData);

        setControl(existingAppContainer);
        existingAppContainer.setLayout(new GridLayout(3, false));
        existingAppContainer.setVisible(false);

        Label lblVersion1 = new Label(existingAppContainer, SWT.NONE);
        lblVersion1.setText(FILE_VERSION_LABEL_TEXT);

        txtVersion = new Text(existingAppContainer, SWT.BORDER);
        GridData txtVersionGridData1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        initialVersion = getVersion();
        txtVersion.setText(initialVersion);
        txtVersion.setLayoutData(txtVersionGridData1);

        txtVersion.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setVersion(txtVersion.getText());
                validate();
            }

        });
        
        btnNewApplication.addSelectionListener(new SelectionAdapter()  {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                
                if(source.getSelection())  {
                    newAppGridData.exclude = false;
                    existingAppData.exclude = true;
                    newAppContainer.setVisible(true);
                    existingAppContainer.setVisible(false);
                    newAppContainer.getParent().pack();
                }
            }
             
        });
        
        btnExistingApplication.addSelectionListener(new SelectionAdapter()  {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source=  (Button) e.getSource();
                 
                if(source.getSelection())  {
                    newAppGridData.exclude = true;
                    existingAppData.exclude = false;
                    newAppContainer.setVisible(false);
                    existingAppContainer.setVisible(true);
                    existingAppContainer.getParent().pack();
                }
            }
             
        });
    }

    private void validate() {
        if ((getName() == null || getName().equals(EMPTY_STRING)) || getVersion() == null
                || getVersion().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a name and version to .car file.");
            setPageComplete(false);
            return;
        } else if (getImageName() == null || getImageName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify an image name.");
            setPageComplete(false);
            return;
        } else if (!getImageName().matches("[a-zA-Z0-9][a-zA-Z0-9_.-]+")) {
            setErrorMessage("The image name format is invalid.");
            setPageComplete(false);
            return;
        } else if (!getName().matches("[_a-zA-Z0-9\\-\\.]+")) {
            setErrorMessage("Could not create CAR files with special characters");
            setPageComplete(false);
            return;
        } else if ((getExportPath() == null || getExportPath().equals(EMPTY_STRING))) {
            setErrorMessage("Please specify the docker image export destination");
            setPageComplete(false);
            return;
        } else if (getImageTag() == null || getImageTag().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify the image tag.");
            setPageComplete(false);
            return;
        } else {
            String version = txtVersion.getText();
            String[] versionParts = version.split("\\.");
            if (version.endsWith(".")) {
                setErrorMessage("File version cannot end with period.");
                setPageComplete(false);
                return;
            }
            if (versionParts.length > 4) {
                setErrorMessage("File version should be in the standared format.");
                setPageComplete(false);
                return;
            }
            if (!Character.isDigit(version.charAt(0))) {
                setErrorMessage("File version should start with a numeric value.");
                setPageComplete(false);
                return;
            }
            if (!(new File(getExportPath())).exists()) {
                setErrorMessage("Export destination must be a valid path.");
                setPageComplete(false);
                return;
            }
            if (!getImageTag().matches("[\\w][\\w.-]{0,127}")) {
                setErrorMessage("The image tag is invalid.");
                setPageComplete(false);
                return;
            }
        }

        setPageDirtyState();
        setErrorMessage(null);
        setPageComplete(true);
    }

    private void setPageDirtyState() {
        if (getName().equals(initialName) && getVersion().equals(initialVersion)) {
            isPageDirty = false;
        } else {
            isPageDirty = true;
        }
    }

    public boolean isPageDirty() {
        return isPageDirty;
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

    public IProject getSelectedProject() {
        return selectedProject;
    }

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String path) {
        this.exportPath = path;
    }

    public Text getTxtExportPathText() {
        return txtExportPath;
    }
    
    public void setName(String carName) {
        this.name = carName;
    }

    public String getName() {
        return name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

}
