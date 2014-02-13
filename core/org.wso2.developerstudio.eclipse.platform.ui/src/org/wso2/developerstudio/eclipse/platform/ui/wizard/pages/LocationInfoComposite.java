package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionInfo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LocationInfoComposite extends Composite implements Observer {
	private final Text locationText;
	private String path;
	private String selectedProject;
	private String currentProjectName;
	private ProjectDataModel projectModel;
	// private IResource selectedObject;
	private final File saveLocation;
	private Button btnCheckButton;
	private WizardPage wizardPage;
	private File workspaceRoot;
	private List<ProjectOptionData> projectOptionsData; 

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	// public LocationInfoComposite(Composite parent, String projectName){
	// super(parent, SWT.NULL);
	// setSelectedProject(projectName);
	// }
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public LocationInfoComposite(Composite parent, int style, ProjectDataModel model, File location, ProjectOptionInfo optionDataInfo, WizardPage wizardPage) {
		super(parent, style);
		setProjectModel(model);
		setCurrentProjectName(model.getProjectName());
		this.saveLocation = location;
		this.wizardPage = wizardPage;
		projectOptionsData = optionDataInfo.getProjectOptionsData();
		workspaceRoot = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
		
		setLayout(new GridLayout(1, false));
		Group grpLocation = new Group(this, SWT.NONE);
		grpLocation.setText("Location");
		grpLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpLocation.setLayout(new GridLayout(4, false));

		btnCheckButton = new Button(grpLocation, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 4, 1));
		btnCheckButton.setText("Use Default Location");
		btnCheckButton.setSelection(true);

		Label lblNewLabel = new Label(grpLocation, SWT.NONE);
		lblNewLabel.setText("Location");

		locationText = new Text(grpLocation, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 314;
		locationText.setLayoutData(gd_text);
		locationText.setText(getDefaultLocation(getSelectedProject()));
		locationText.setEnabled(false);

		final Button browseButton = new Button(grpLocation, SWT.NONE);
		browseButton.setText("Browse");
		browseButton.setEnabled(false);
		new Label(grpLocation, SWT.NONE);

		btnCheckButton.addSelectionListener(new SelectionListener() {

		
			public void widgetSelected(SelectionEvent event) {
				boolean selected = ((Button) event.widget).getSelection();
				locationText.setEnabled(!selected);
				browseButton.setEnabled(!selected);
				if(selected){
					String path = workspaceRoot + File.separator + getProjectModel().getProjectName();
					setPath(path);
					getProjectModel().setLocation(new File(path));
					locationText.setText(path);
				} else{
					locationText.setText("");
					setPath("");
					getProjectModel().setLocation(null);
				}
			}

			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		locationText.addModifyListener(new ModifyListener() {

			
			public void modifyText(ModifyEvent evt) {
				validateLocation(locationText.getText());
				}

		});

		browseButton.addSelectionListener(new SelectionListener() {

			
			public void widgetSelected(SelectionEvent arg0) {
				handlePathBrowseButton(locationText);
			}

			
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		model.addObserver(this);

	}
	
	private void validateLocation(String text){
		try {
			if(null==locationText.getText() || locationText.getText().trim().isEmpty()){
				throw new FieldValidationException("Enter a valid location for the project");
				
			} else {
				if(workspaceRoot.equals(new File(locationText.getText()))){
					throw new FieldValidationException(locationText.getText() + " overlaps the workspace location: " + workspaceRoot);
				} else{
					new File(locationText.getText());
					setPath(locationText.getText());
					getProjectModel().setLocation(new File(locationText.getText()));
				}
			}
			wizardPage.setPageComplete(true);
			wizardPage.setErrorMessage(null);
			for(ProjectOptionData data : projectOptionsData){
				invokePrivateMethod((Object)wizardPage,"doPostFieldModificationAction",new Object[]{ data});
			}
		} catch (FieldValidationException e) {
			wizardPage.setPageComplete(false);
			wizardPage.setErrorMessage(e.getMessage());
		} catch (Exception e) {
			wizardPage.setPageComplete(false);
		}
	}
	
	private static Object invokePrivateMethod (Object o, String methodName, Object[] params) {   
		 
	    final Method methods[] = o.getClass().getDeclaredMethods();
	    for (int i = 0; i < methods.length; ++i) {
	      if (methodName.equals(methods[i].getName())) {
	        try {
	          methods[i].setAccessible(true);
	          return methods[i].invoke(o, params);
	        } 
	        catch (IllegalAccessException ex) {
	         /* ignore*/
	        }
	        catch (InvocationTargetException ite) {
	        	/* ignore*/	        	
	        }
	      }
	    }
	    return null;
	  }  

	
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public String getPath() {
		return path;
	}

	public void setPath(String location) {
		this.path = location;
	}

	private String getDefaultLocation(String projectName) {
		String defaultLocation = "";
		if (projectName != null) {
			defaultLocation = saveLocation.getPath() + File.separator + projectName;
		} else {
			defaultLocation = saveLocation.getPath();
		}

		return defaultLocation;
	}

	public void handlePathBrowseButton(Text filePathText) {
		String fileName = getSavePath();
		if (fileName != null)
			filePathText.setText(fileName);
	}

	private String getSavePath() {
		String fileName = null;
		// FileDialog
		DirectoryDialog fld = new DirectoryDialog(this.getShell(), SWT.OPEN);
		boolean done = false;
		while (!done) {
			// Open the File Dialog
			fileName = fld.open();
			if (fileName == null) {
				// User has cancelled, so quit and return
				done = true;
			} else {
				// User has selected a file; see if it already exists
				File file = new File(fileName);
				if (file.exists()) {
					// If they click Yes, we're done and we drop out. If
					// they click No, we redisplay the File Dialog
					if(!workspaceRoot.equals(file)){
						done = true;
					} else{
						
						done = false;
					}
					
				} else {
					// File does not exist, so drop out
					done = false;
				}
			}
		}
		return fileName;
	}

	public void setCurrentProjectName(String currentProjectName) {
		this.currentProjectName = currentProjectName;
	}

	public String getCurrentProjectName() {
		return currentProjectName;
	}

	public void setProjectModel(ProjectDataModel projectModel) {
		this.projectModel = projectModel;
	}

	public ProjectDataModel getProjectModel() {
		return projectModel;
	}

	
	public void update(Observable o, Object arg) {
		if (o == getProjectModel()) {
			if (getCurrentProjectName() == null ||
			    !getCurrentProjectName().equals(getProjectModel().getProjectName())) {
				setCurrentProjectName(getProjectModel().getProjectName());
				if(btnCheckButton.getSelection()){
					setProjectLocationTextBox(); 
				} else{
					if(null==locationText.getText() || locationText.getText().trim().isEmpty() || workspaceRoot.equals(new File(locationText.getText()))){
						String path = workspaceRoot + File.separator + getProjectModel().getProjectName();
						setPath(path);
						getProjectModel().setLocation(new File(path));
						locationText.setText(path);
					} 
				}
			}
			
		}
	}

	public void setProjectLocationTextBox() {
		File updatedProjectLocation;
		if (saveLocation == null) {
			if (getCurrentProjectName() != null) {
				updatedProjectLocation =
				        new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile(),
				                getCurrentProjectName());
			} else {
				updatedProjectLocation =
				        ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
			}
		} else {
			if (getCurrentProjectName() != null) {
				updatedProjectLocation = new File(saveLocation, getCurrentProjectName());
			} else {
				updatedProjectLocation = saveLocation;
			}
		}

		locationText.setText(updatedProjectLocation.toString());
		// getProjectModel().setLocation(updatedProjectLocation);
	}

}
