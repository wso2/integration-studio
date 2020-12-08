/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionInfo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This is a SWT ui (Composite) class for creating project location selector
 * part in project creation wizard
 */
public class LocationInfoComposite extends Composite implements Observer {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	// SWT components used to build location selector ui
	private final Text locationHolder;
	private final Button defaultCheckButton;
	private final Button browseButton;

	private WizardPage wizardPage;
	private List<ProjectOptionData> projectOptionsData;
	private ProjectDataModel projectModel;
	private final File defaultLocation;
	private String currentProjectName;
	private boolean defaultCheckButtonSelected;

	// variable used to indicate whether location selector composite is complete
	private boolean complete;
	// variable used to keep the error message of location selector composite
	private String errorMessage;
	// variable used to keep the location value that user selected last
	private String lastUserSelectedLocation;

	// Defining String constants
	private static final String LOCATION = "Location";
	private static final String USE_DEFAULT_LOCATION = "Use Default Location";
	private static final String BROWSE = "Browse";
	private static final String ERR_MESSAGE_VALID_LOCATION = "Enter a valid location for the project";
	private static final String DATA_FIELD_VALIDATOR_METHOD = "doPostFieldModificationAction";

    ModifyListener modifyListener = new ModifyListener() {

        public void modifyText(ModifyEvent evt) {
            validateAndUpdateLocation();
        }

    };
	/**
	 * Constructor that creates composite ui for project location selector and
	 * adding necessary listeners.
	 */
	public LocationInfoComposite(Composite parent, int style, ProjectDataModel model, final File location,
	                             ProjectOptionInfo optionDataInfo, WizardPage wizardPage) {
		super(parent, style);
		setProjectModel(model);
		setCurrentProjectName(model.getProjectName());
		File modelLocation = getProjectModel().getLocation();
		if (modelLocation != null) {
			this.defaultLocation = modelLocation; /*
												   * Developer has changed the
												   * default selection location
												   */
		} else {
			this.defaultLocation = location; /*
											  * Default location using the
											  * selection
											  */
		}

		this.wizardPage = wizardPage;
		this.projectOptionsData = optionDataInfo.getProjectOptionsData();

		setLayout(new GridLayout(1, false));

		Group locationSelectorGroup = new Group(this, SWT.NONE);
		locationSelectorGroup.setText(LOCATION);
		locationSelectorGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		locationSelectorGroup.setLayout(new GridLayout(4, false));

		defaultCheckButton = new Button(locationSelectorGroup, SWT.CHECK);
		defaultCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 4, 1));
		defaultCheckButton.setText(USE_DEFAULT_LOCATION);
		defaultCheckButton.setSelection(true);
		defaultCheckButtonSelected = defaultCheckButton.getSelection();

		Label locationLabel = new Label(locationSelectorGroup, SWT.NONE);
		locationLabel.setText(LOCATION);

		locationHolder = new Text(locationSelectorGroup, SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.widthHint = 314;
		locationHolder.setLayoutData(gridData);
		locationHolder.setText(this.defaultLocation.toString());
		locationHolder.setEnabled(false);

		complete = true;
		errorMessage = null;

		browseButton = new Button(locationSelectorGroup, SWT.NONE);
		browseButton.setText(BROWSE);
		browseButton.setEnabled(false);

		// Adding a selection listener to 'defaultCheckButton' check box
		defaultCheckButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				defaultCheckButtonSelected = defaultCheckButton.getSelection();
				locationHolder.setEnabled(!defaultCheckButtonSelected);
				browseButton.setEnabled(!defaultCheckButtonSelected);
				if (defaultCheckButtonSelected) {

					updateDefaultProjectLocation();
					getProjectModel().setIsUserDefine(false);
					
                    // remove a modify listener to 'locationHolder' Text field
                    locationHolder.removeModifyListener(modifyListener);
                    
				} else {
					getProjectModel().setIsUserDefine(true);
					if (lastUserSelectedLocation == null) {
						locationHolder.setText("");
						getProjectModel().setLocation(null);
					} else {
						locationHolder.setText(lastUserSelectedLocation);
						getProjectModel().setLocation(new File(lastUserSelectedLocation));

					}
                    // Adding a modify listener to 'locationHolder' Text field
                    locationHolder.addModifyListener(modifyListener);

				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				// No implementation, because need to handle only user selected
				// values, not the platform specific default selections
			}

		});

		// Adding a selection listener to browse button
		browseButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				handlePathBrowseButton();
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				// No implementation, because need to handle only user selected
				// values, not the platform specific default selections
			}
		});

		model.addObserver(this);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == getProjectModel() &&
		    (getCurrentProjectName() == null || !getCurrentProjectName().equals(getProjectModel().getProjectName()))) {
			setCurrentProjectName(getProjectModel().getProjectName());
			if (defaultCheckButtonSelected) {
				updateDefaultProjectLocation();
			}
		}
	}

	/**
	 * This is for validating and updating the location value in
	 * ProjectDataModel when there is a change in location text field
	 */
	private void validateAndUpdateLocation() {

		try {
			if (locationHolder.getText() == null || locationHolder.getText().trim().isEmpty()) {
				complete = false;
				errorMessage = ERR_MESSAGE_VALID_LOCATION;
				throw new FieldValidationException(errorMessage);
			} else {
				if (defaultCheckButtonSelected && getCurrentProjectName() != null) {
					getProjectModel().setLocation(new File(locationHolder.getText(), getCurrentProjectName()));
				} else {
					getProjectModel().setLocation(new File(locationHolder.getText()));
				}
				complete = true;
				errorMessage = null;
			}

			for (ProjectOptionData data : projectOptionsData) {
				validateDataFieldsOfWizard(wizardPage, DATA_FIELD_VALIDATOR_METHOD, new Object[] { data });
			}
		} catch (FieldValidationException e) {
			// If an exception is thrown, when validating the input fields from
			// user, just print error message in wizards
			wizardPage.setPageComplete(false);
			wizardPage.setErrorMessage(e.getMessage());
		}
	}

	/**
	 * This is for validating data fields of WizardPage corresponding to this
	 * Composite
	 */
	private void validateDataFieldsOfWizard(WizardPage page, String methodName, Object[] params) {
		// Getting all declared methods of WizardPage class
		final Method[] methods = page.getClass().getDeclaredMethods();

		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				try {
					method.setAccessible(true);
					method.invoke(page, params);
				} catch (IllegalAccessException e) {
					log.error("Error when invoking private method of ProjectOptionsDataPage class, Method name : " +
					          DATA_FIELD_VALIDATOR_METHOD, e);
					/*
					 * This an JVM thrown exception at run time, not possible to
					 * handle
					 */
				} catch (InvocationTargetException e) {
					log.error("Error when invoking private method of ProjectOptionsDataPage class, Method name : " +
					          DATA_FIELD_VALIDATOR_METHOD, e);
					/*
					 * This an JVM thrown exception at run time, not possible to
					 * handle
					 */
				}
			}
		}
	}

	/**
	 * This is for handling path selection process when user clicks browse
	 * button
	 */
	private void handlePathBrowseButton() {
		String fileName = getUserSelectedLocation();
		if (fileName != null) {
			locationHolder.setText(fileName);
		}
	}

	/**
	 * This is for getting user selected path string from directory dialog box
	 */
	private String getUserSelectedLocation() {
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
					done = true;
				} else {
					// File does not exist, so drop out
					done = false;
				}
			}
		}

		lastUserSelectedLocation = fileName;
		return fileName;
	}

	/**
	 * This is for updating default location as project name changes
	 */
	private void updateDefaultProjectLocation() {
		File updatedProjectLocation;

		if (getCurrentProjectName() != null) {
			updatedProjectLocation = new File(defaultLocation, getCurrentProjectName());
		} else {
			updatedProjectLocation = defaultLocation;
		}

		locationHolder.setText(updatedProjectLocation.toString());
		getProjectModel().setLocation(updatedProjectLocation);
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

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isDefaultCheckButtonSelected() {
		return defaultCheckButtonSelected;
	}

	public void setDefaultCheckButtonSelected(boolean defaultCheckButtonSelected) {
		this.defaultCheckButtonSelected = defaultCheckButtonSelected;
	}
}