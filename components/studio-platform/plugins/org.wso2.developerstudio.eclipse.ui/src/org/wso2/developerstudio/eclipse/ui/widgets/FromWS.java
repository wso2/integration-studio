/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ui.widgets;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.core.SourceType;
import org.eclipse.jdt.internal.core.search.JavaWorkspaceScope;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class FromWS extends Composite{
	
	private boolean isRadioButtonEnabled;
	private Text pathText;
	public FromWS(Composite composite, int style, boolean controlEnabled) {
		super(composite, style);
		this.isRadioButtonEnabled = controlEnabled ;
		createControl(composite);
		
		
	}
	
	public void createControl(Composite parent){
		final Group group = new Group(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		group.setLayout(layout);
		
		GridData gd = new GridData();
		Button enabledButton = new Button(group, SWT.RADIO);
		enabledButton.setText("From workspace");
		gd.horizontalSpan = 2;
		enabledButton.setLayoutData(gd);
		enabledButton.setVisible(false);
		
		if(isRadioButtonEnabled){
			enabledButton.setVisible(true);
		}
		
		pathText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		pathText.setLayoutData(gd);
		
//		Button newFileButton = new Button(group, SWT.PUSH);
//		newFileButton.setText("New Resource");
//		gd = new GridData(GridData.FILL_HORIZONTAL);
//		newFileButton.setLayoutData(gd);
		
		Button wsProjectButton = new Button(group, SWT.PUSH);
		wsProjectButton.setText("Project");
		gd = new GridData(GridData.FILL_HORIZONTAL);
//		gd.widthHint = 100; 
		wsProjectButton.setLayoutData(gd);
		
		Button wsClassButton = new Button(group, SWT.PUSH);
		wsClassButton.setText("Fully qualified class");
		gd = new GridData(GridData.FILL_HORIZONTAL);
//		gd.widthHint = 100; 
		wsClassButton.setLayoutData(gd);
		
		wsProjectButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
		        ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(group.getShell(),
																WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider(),
																new WorkbenchContentProvider());
		        elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		        if (elementTreeSelectionDialog.open() == Window.OK) {
			        elementTreeSelectionDialog.getFirstResult();
			        IResource resource =(IResource) elementTreeSelectionDialog.getFirstResult();
		        }
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
		wsClassButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				browseClassFile();				
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void browseClassFile() {
		FilteredTypesSelectionDialog dialog = new FilteredTypesSelectionDialog(Display.getCurrent().getActiveShell(), 
																				true, 
																				PlatformUI.getWorkbench().getProgressService(),
																				new JavaWorkspaceScope(), 
																				IJavaSearchConstants.CLASS);
		dialog.setTitle("Registry Handler Class");
		dialog.setMessage("Select a java class to create the Registry Handler from");

		if (dialog.open() == Window.OK) {
			SourceType firstResult = (SourceType) dialog.getFirstResult();
			IJavaProject p = (IJavaProject) firstResult.getAncestor(2);
			pathText.setText(firstResult.getFullyQualifiedName());
		}
	}
	
	

}
