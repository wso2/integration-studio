/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.model.RegistryHandlerModel;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;

public class ImportHandlerJarWizardPage extends WizardPage{
	
	private Text jarLocation;
	private RegistryHandlerModel regModel;
	
	public ImportHandlerJarWizardPage(String pageName, RegistryHandlerModel model) {
		super(pageName);
		setDescription("Import Handler from File System");
		setTitle(pageName);
		this.regModel = model;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblHandlerClass = new Label(container, SWT.NONE);
		lblHandlerClass.setText("Location: ");
		lblHandlerClass.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		jarLocation = new Text(container, SWT.BORDER| SWT.READ_ONLY);
		jarLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button cmdBrowse = new Button(container, SWT.NONE);
		cmdBrowse.setText(" browse.. ");
		cmdBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				String fileLocation = openFileDialog();
				if (fileLocation != null && !fileLocation.trim().isEmpty()) {
					File file = new File(fileLocation);
					if (file.exists()) {
						// TODO: validate jar
						regModel.setExternalJar(file);
						jarLocation.setText(file.getAbsolutePath());
					}
				}
				validate();
			}
		});
		
		//if(regModel.getHandlerClassSeletionMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_FS_TEXT)){
			validate();
		//}

	}

//	private boolean isValidHandler(IFile jar){
//			IPackageFragmentRoot rootPkg = JavaCore.createJarPackageFragmentRootFrom(jar);
//			try {
//				IPackageFragment[] packageFragments =rootPkg.getJavaProject().getPackageFragments();
//				for (IPackageFragment fragment : packageFragments) {
//					IJavaElement[] children = fragment.getChildren();
//					for (IJavaElement element : children) {
//							ICompilationUnit[] compilationUnits = fragment.getCompilationUnits();
//							for (ICompilationUnit unit : compilationUnits) {
//								String a = unit.getElementName();
//								IType[] types = unit.getTypes();
//								for (IType type : types) {
//									if(type.getSuperclassName() != null){
//										String[][] resolveType = type.resolveType(type.getSuperclassName());
//										if(resolveType != null){
//											String fullyQualifiedSuperClassName=(resolveType[0][0]).toString()+"."+(resolveType[0][1]).toString();
//											if(Constants.HANDLER_SUPER_CLASSNAME.equals(fullyQualifiedSuperClassName)){
//											return true;	
//											}
//										}
//									}
//								}
//							}
//					}
//				}
//			} catch (JavaModelException e) {
//			}
//		return false;
//	}
	
	private String openFileDialog(){
		FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setText("Open");
        String[] filterExt = { "*.jar" };
        fd.setFilterExtensions(filterExt);
        return fd.open();
	}
	
	public void validate(){
		if(regModel.getExternalJar() == null || !regModel.getExternalJar().exists() ){
			setErrorMessage("please browse jar from file system");
			setPageComplete(false);
		}else{
			setErrorMessage(null);
			setPageComplete(true);
		}
	}
}
