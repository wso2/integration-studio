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

import org.apache.commons.validator.routines.UrlValidator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import java.io.File;

public class Axis2SelectWSDLPage extends WizardPage {
	
	private Text txtBrowseWorkspace;
	private Text txtBrowseFileSystem;
	private Text txtOnlineWSDLUri;
	private Button btnBrowseWorkspace;
	private Button btnBrowseFileSystem;
	private ElementTreeSelectionDialog dialog;
	// This might not be needed
	private File wsdlFile;
	private DataModel model;
	private int optionType;

	public static final int OPTION_IMPORT_FS = 3;
	public static final int OPTION_IMPORT_WS = 8;

	// local entry source types
	public static final int OPTION_SOURCE_URL = 32;

	public int getOptionType() {
		return optionType;
	}

	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}

	public boolean canFlipToNextPage() {
		return wsdlFile != null || model.getWsdlURI() != null;
	}

	public IWizardPage getNextPage() {

		if (wsdlFile != null) {
			model.setWsdlURI(wsdlFile.getAbsolutePath());
		}
		return super.getNextPage();
	}

	protected Axis2SelectWSDLPage(String pageName, DataModel model) {
		// Select WSDL
		super(pageName);
		setTitle(pageName);
		this.model = model;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 108, 17);
		lblNewLabel.setText("Select WSDL ");

		txtBrowseWorkspace = new Text(container, SWT.BORDER);
		txtBrowseWorkspace.setBounds(164, 49, 366, 27);

		btnBrowseWorkspace = new Button(container, SWT.NONE);
		btnBrowseWorkspace.setText("Browse...");
		btnBrowseWorkspace.setBounds(536, 45, 101, 35);

		if (txtBrowseWorkspace.getText() != null && !txtBrowseWorkspace.getText().equals("")) {
			btnBrowseWorkspace.setEnabled(false);

		} else {
			btnBrowseWorkspace.setEnabled(true);
		}
		
		btnBrowseWorkspace.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				dialog = new ElementTreeSelectionDialog(btnBrowseWorkspace.getShell(),
						new WorkbenchLabelProvider(),
						new BaseWorkbenchContentProvider());
				dialog.setTitle("Tree Selection");
				dialog.setMessage("Select the elements from the tree:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.addFilter(new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement,
							Object element) {
						if (element instanceof IProject) {
							return true;
						}
						if (element instanceof IFolder) {
							return true;
						}
						if (element instanceof IFile) {
							IFile file = (IFile) element;
							if ("wsdl".equals(file.getFileExtension())) {
								return true;
							}
						}
						return false;

					}
				});

				if (dialog.open() == Window.OK) {
					if (dialog.getFirstResult() instanceof IFile) {
						IFile file = (IFile) dialog.getFirstResult();

						if (file.exists()) {
							wsdlFile = new File(file.getRawLocation()
									.toString());
						}

						if (wsdlFile != null && wsdlFile.exists()) {
							txtBrowseWorkspace.setText(wsdlFile.getName());
							model.setWsdlURI(file.getRawLocation().toString());
							setPageComplete(true);
						}
					} else {
						txtBrowseWorkspace.setText("");
						wsdlFile = null;
						model.setWsdlURI(null);
						
						setPageComplete(false);
					}
				}
			}
		});
		
		Button btnWorkspace = new Button(container, SWT.RADIO);
		btnWorkspace.setText("Browse workspace");
		btnWorkspace.setBounds(10, 53, 152, 20);
		btnWorkspace.setSelection(true);
		setOptionType(OPTION_IMPORT_WS);
		btnWorkspace.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setOptionType(OPTION_IMPORT_WS);
				btnBrowseWorkspace.setEnabled(true);
				txtBrowseWorkspace.setText("");
				txtBrowseWorkspace.setEnabled(true);
				btnBrowseFileSystem.setEnabled(false);
				/*if (model.getWsdlURI() != null
						&& !model.getWsdlURI().equals("")) {
					text.setText(model.getWsdlURI());
					wsdlFile = new File(model.getWsdlURI());
					setPageComplete(true);
				} else {
					text.setText("");
					wsdlFile = null;
					setPageComplete(false);
				}*/
				// text_1.setText("");
				txtBrowseFileSystem.setEnabled(false);
				txtOnlineWSDLUri.setText("");
				txtOnlineWSDLUri.setEnabled(false);

				wsdlFile = null;
				model.setWsdlURI(null);
				
				setPageComplete(false);
			}
		});

		Button btnFilySystem = new Button(container, SWT.RADIO);
		btnFilySystem.setText("Browse file system");
		btnFilySystem.setBounds(10, 96, 152, 20);
		btnFilySystem.setSelection(false);

		txtBrowseFileSystem = new Text(container, SWT.BORDER);
		txtBrowseFileSystem.setBounds(164, 92, 366, 27);
		txtBrowseFileSystem.setEnabled(false);

		btnFilySystem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setOptionType(OPTION_IMPORT_FS);
				btnBrowseWorkspace.setEnabled(false);
				txtBrowseWorkspace.setText("");
				txtBrowseWorkspace.setEnabled(false);
				btnBrowseFileSystem.setEnabled(true);
				txtBrowseFileSystem.setText("");
				txtBrowseFileSystem.setEnabled(true);
				setPageComplete(false);
				wsdlFile = null;
				model.setWsdlURI(null);
				
				txtOnlineWSDLUri.setText("");
				txtOnlineWSDLUri.setEnabled(false);
			}
		});

		btnBrowseFileSystem = new Button(container, SWT.NONE);
		btnBrowseFileSystem.setText("Browse...");
		btnBrowseFileSystem.setBounds(536, 86, 101, 35);
		btnBrowseFileSystem.setEnabled(false);
		btnBrowseFileSystem.addSelectionListener(new SelectionAdapter() {
			// TODO put this code in a utililty class
			public void widgetSelected(SelectionEvent e) {
				String fileName = null;
				FileDialog dlg = new FileDialog(getShell());
				dlg.setFilterExtensions(new String[] { "*.wsdl" });
				boolean done = false;

				while (!done) {
					// Open the File Dialog
					fileName = dlg.open();
					if (fileName == null) {
						// User has cancelled, so quit and return
						done = true;
					} else {
						// User has selected a file; see if it already exists
						wsdlFile = new File(fileName);
						if (wsdlFile.exists()) {
							// If they click Yes, we're done and we drop out. If
							// they click No, we redisplay the File Dialog
							done = true;
							txtBrowseFileSystem.setText(fileName);
							model.setWsdlURI(fileName);
							setPageComplete(true);
						} else {
							// File does not exist, so drop out
							done = false;
						}
					}
				}
			}
		});

		Button btnOnlineWSDL = new Button(container, SWT.RADIO);
		btnOnlineWSDL.setText("WSDL URI");
		btnOnlineWSDL.setBounds(10, 139, 148, 20);
		btnOnlineWSDL.setSelection(false);

		txtOnlineWSDLUri = new Text(container, SWT.BORDER);
		txtOnlineWSDLUri.setBounds(164, 135, 366, 27);
		txtOnlineWSDLUri.setEnabled(false);

		btnOnlineWSDL.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setOptionType(OPTION_SOURCE_URL);
				btnBrowseWorkspace.setEnabled(false);
				txtBrowseWorkspace.setEnabled(false);
				txtBrowseWorkspace.setText("");
				btnBrowseFileSystem.setEnabled(false);
				txtBrowseFileSystem.setText("");
				txtBrowseFileSystem.setEnabled(false);

				txtOnlineWSDLUri.setEnabled(true);
				txtOnlineWSDLUri.setText("");

				wsdlFile = null;
				model.setWsdlURI(null);
				
				setPageComplete(false);
			}
		});

		txtBrowseWorkspace.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				if (txtBrowseWorkspace.getText() != null && !txtBrowseWorkspace.getText().equals("")) {
					String fileName = txtBrowseWorkspace.getText();
					wsdlFile = new File(fileName);
					if (wsdlFile.exists()) {
						model.setWsdlURI(fileName);
						setPageComplete(true);
					} else {
						wsdlFile = null;
						model.setWsdlURI(null);
						setPageComplete(false);
					}
				} else {
					wsdlFile = null;
					model.setWsdlURI(null);
					setPageComplete(false);
				}
			}
		});
		
		txtBrowseFileSystem.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				if (txtBrowseFileSystem.getText() != null && !txtBrowseFileSystem.getText().equals("")) {
					String fileName = txtBrowseFileSystem.getText();
					wsdlFile = new File(fileName);
					if (wsdlFile.exists()) {
						model.setWsdlURI(fileName);
						setPageComplete(true);
					} else {
						wsdlFile = null;
						model.setWsdlURI(null);
						setPageComplete(false);
					}
				} else {
					wsdlFile = null;
					model.setWsdlURI(null);
					setPageComplete(false);
				}				
			}
		});
		
		txtOnlineWSDLUri.addListener(SWT.Modify, new Listener() {
			UrlValidator urlValidator = new UrlValidator(
					UrlValidator.ALLOW_LOCAL_URLS);

			public void handleEvent(Event arg0) {
				if (urlValidator.isValid(txtOnlineWSDLUri.getText())) {
					model.setWsdlURI(txtOnlineWSDLUri.getText());
					setPageComplete(true);
				} else {
					wsdlFile = null;
					model.setWsdlURI(null);
					setPageComplete(false);
				}
			}
		});
		
		if (((getOptionType() == OPTION_IMPORT_WS) && txtBrowseWorkspace.getText() != null && !txtBrowseWorkspace
				.getText().equals(""))
				|| ((getOptionType() == OPTION_IMPORT_FS)
						&& txtBrowseFileSystem.getText() != null && !txtBrowseFileSystem.getText()
						.equals(""))
				|| ((getOptionType() == OPTION_SOURCE_URL)
						&& txtOnlineWSDLUri.getText() != null && !txtOnlineWSDLUri
						.getText().equals(""))) {
			setPageComplete(true);
		}
	}

}
