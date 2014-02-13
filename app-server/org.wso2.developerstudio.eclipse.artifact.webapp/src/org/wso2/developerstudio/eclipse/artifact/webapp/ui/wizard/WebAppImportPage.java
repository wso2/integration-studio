package org.wso2.developerstudio.eclipse.artifact.webapp.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.webapp.model.WebAppModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class WebAppImportPage extends WizardPage {
	
	private Text txtImportFromFileSystem;
	private Button btnBrowseWAR;
	public static final int IMPORT_FROM_WORKSPACE=0;
	public static final int IMPORT_FROM_FILE_SYSTEM=1;
	public static final int NEW_WEB_APPLICATION=2;
	private WebAppModel appModel;
	private IProject[] workspaceProjects;
	boolean pageEnable;
	
	protected WebAppImportPage(WebAppModel model) {
		super("ImportOption");
		setTitle("WebApp Importp option page");
		this.appModel = model;
		
	}

	@Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns=2;
        layout.verticalSpacing = 9;
        container.setLayout(layout);
        GridData gd = new GridData();
        Label label = new Label(container,SWT.NONE);
        label.setText("Web Application (WAR) in the fileSystem:");
        gd.horizontalSpan=2;
        label.setLayoutData(gd);
        
		gd=new GridData();
        gd.horizontalSpan=2;
        new Label(container,SWT.NULL).setLayoutData(gd);
		
        gd=new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalIndent=25;
        
        txtImportFromFileSystem = new Text(container,SWT.BORDER);
        txtImportFromFileSystem.setLayoutData(gd);
        txtImportFromFileSystem.setEnabled(true);
        
        btnBrowseWAR = new Button(container,SWT.None);
        btnBrowseWAR.setText("Browse...");
        btnBrowseWAR.setEnabled(true);
        gd = new GridData(); 
        gd.widthHint = 150;
        btnBrowseWAR.setLayoutData(gd);
        
        btnBrowseWAR.addSelectionListener(new SelectionListener(){
            public void widgetDefaultSelected(SelectionEvent event) {
	            widgetSelected(event);
            }
            public void widgetSelected(SelectionEvent event) {
            	FileDialog fileDialog = new FileDialog(getShell());
            	fileDialog.setFilterExtensions(new String[]{"*.war"});
            	fileDialog.setText("Browse for an Web Application (WAR) file");
            	if (fileDialog.open()!=null){
            		File file= new File(fileDialog.getFilterPath(),fileDialog.getFileName());
            		txtImportFromFileSystem.setText(file.toString());
            		setProject(file.toString());
            	}
            }
        	
        });
		txtImportFromFileSystem.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent event) {
				setErrorMessage(null);
				Text text = (Text) event.widget;
				setProject(text.getText());
			}
		}); 
		setControl(container);
    	setPageComplete(true);
    }
	
    private void setProject(String path){
    	File file= new File(path);
		String fileNameWithoutExtension = ProjectUtils.fileNameWithoutExtension(file.getName());
		appModel.setWarName(fileNameWithoutExtension);
		appModel.setLocation(file);
		appModel.setImportFile(file);
		validate();
    }

	 private void validate(){ 	
		        if (appModel.getImportFile() == null || !appModel.getImportFile().exists()) {
			        setErrorMessage("Specify a valid existing Web Application (WAR) in the file system");
			        setPageComplete(false);
			        return;
		        }
		        workspaceProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		        for (IProject project : workspaceProjects) {
		 	       if(appModel.getWarName().equals(project.getName())){
		 	    	  setErrorMessage("Specify project already exsits in the workspace");
		 	    	  setPageComplete(false);
		 	    	 return;
		 	       }
		        }
			setErrorMessage(null);
			setPageComplete(true);
			pageEnable=true;
			canFlipToNextPage();
	    }

	@Override
	public boolean canFlipToNextPage() {
		if(pageEnable){
		return super.canFlipToNextPage();
		}else{
			return false;
		}
	}
	
	
}
