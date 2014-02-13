/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.wizards.JavaProjectWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.ui.dialog.SourceFolderSelectionDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Axis2CodeGenerationOptionPage extends WizardPage {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private Text sourceFolderText;
	private IPackageFragmentRoot sourceFolder;
	private static final int CREATE_CLIENT = 0;
	private static final int CREATE_SERVICE = 1;
	private int modelGeneratingType;
	private Link createNewProjectLink;
	private DataModel model;
	private Button radioButton;
	private Button btnBrowse;

	public Axis2CodeGenerationOptionPage(String pageName,
			IPackageFragmentRoot sourceFolder, DataModel model,
			int modelGeneratingType) {
		super(pageName);
		setTitle(pageName);
		this.model = model;
		this.modelGeneratingType = modelGeneratingType;
		this.sourceFolder = sourceFolder;
		setPageComplete(false);
	}

	public void createControl(Composite arg0) {
		Composite composite = new Composite(arg0, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);

		GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.horizontalSpan = 10;

		radioButton = new Button(composite, SWT.RADIO);
		radioButton.setLayoutData(gd);

		String optionText = "Select src folder to contain the generated client";
		if (modelGeneratingType == CREATE_SERVICE) {
			optionText = "Select src folder to contain the generated service skeleton";
		}
		radioButton.setText(optionText);
		radioButton.setSelection(true);

		Label labelSourceFolder = new Label(composite, SWT.NONE);
		labelSourceFolder.setText("Source Folder:");

		gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.horizontalIndent = 10;
		gd.verticalIndent = 10;
		gd.widthHint = 100;

		labelSourceFolder.setLayoutData(gd);

		sourceFolderText = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
		sourceFolderText.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event arg0) {

				IProject javaProject = sourceFolder.getJavaProject()
						.getProject();
				model.setSelectedProject(javaProject);
				model.setGeneratedCodeLocation((javaProject.getLocation())
						.toString() + "/");
				model.setSourceFolder(sourceFolderText.getText().substring(
						(javaProject.getName() + File.separator).length()));

				setPageComplete(true);
			}
		});

		if (sourceFolder != null) {
			sourceFolderText.setText(sourceFolder.getPath().toOSString()
					.substring(1));
		}
		gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.verticalIndent = 10;
		gd.widthHint = 350;
		sourceFolderText.setLayoutData(gd);

		btnBrowse = new Button(composite, SWT.NONE);
		btnBrowse.setText("Browse...");

		gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.verticalIndent = 10;
		gd.widthHint = 100;
		btnBrowse.setLayoutData(gd);

		btnBrowse.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event arg0) {
				SourceFolderSelectionDialog dialog = new SourceFolderSelectionDialog(
						Display.getDefault().getActiveShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
					sourceFolder = dialog.getSourceFolder();
					sourceFolderText.setText(sourceFolder.getPath()
							.toOSString().substring(1));

					// IProject javaProject =
					// sourceFolder.getJavaProject().getProject();
					// model.setSelectedProject(javaProject);
					// model.setGeneratedCodeLocation((javaProject.getLocation()).toString()+
					// "/");
					// model.setSourceFolder(sourceFolderText.getText().substring((javaProject.getName()+File.separator).length()));
					setPageComplete(true);
				}
			}
		});

		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		createNewProjectLink = new Link(composite, SWT.LEFT);
		createNewProjectLink.setText("<a>Create a new Project</a>");

		gd = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		gd.verticalIndent = 5;
		createNewProjectLink.setLayoutData(gd);

		createNewProjectLink.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event arg0) {
				openProjectCreation();
			}
		});

		setControl(composite);
	}

	private void openProjectCreation() {
		JavaProjectWizard cappProjectWizard = new JavaProjectWizard();
		cappProjectWizard.init(PlatformUI.getWorkbench(), null);
		cappProjectWizard.setForcePreviousAndNextButtons(true);

		WizardDialog wizardDialog = new WizardDialog(getShell(),
				cappProjectWizard);
		if (wizardDialog.open() == Window.OK) {
			IProject createdCAppProject = cappProjectWizard.getCreatedElement()
					.getJavaProject().getProject();
			if (!createdCAppProject.isOpen()) {
				try {
					createdCAppProject.open(new NullProgressMonitor());
					createdCAppProject.refreshLocal(IResource.DEPTH_INFINITE,
							new NullProgressMonitor());
				} catch (CoreException e) {
					log.error("Error occured while trying to open the newly created C-App project: "
							+ createdCAppProject.getName());
				}
			}
			IJavaProject createdJavaProject = cappProjectWizard
					.getCreatedElement().getJavaProject();
			try {
				IClasspathEntry[] rawClasspath = createdJavaProject
						.getRawClasspath();
				for (int i = 0; i < rawClasspath.length; i++) {
					if (rawClasspath[i].getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						sourceFolder = createdJavaProject
								.getPackageFragmentRoot(rawClasspath[i]
										.getPath().toOSString());
						sourceFolderText.setText(sourceFolder.getPath()
								.toOSString().substring(1));
						break;
					}
				}
			} catch (JavaModelException e) {
				log.error("Error occured while trying to extract source information.");
			}
			this.getControl().setFocus();
			setPageComplete(true);
		}
	}

}
