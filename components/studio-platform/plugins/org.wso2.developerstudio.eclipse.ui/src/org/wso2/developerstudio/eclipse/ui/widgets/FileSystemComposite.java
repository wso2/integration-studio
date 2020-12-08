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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class FileSystemComposite extends Composite {

	private String filePath;
	private Text locationText;
	private String extension; 
	private boolean selectableOption;
	private boolean isDataValid = false;
	public static final int FILE_TYPE_FILE=1;
	public static final int FILE_TYPE_DIRECTORY=2;
	private int browseType;
	Control btnCaption;
	private Button fileButton;
	private Button folderButton;
	private List<Control> controlList;
	private List<IPathChangedListener> listeners;
	
	FileSystemComposite(Composite composite, int style, int browseType, boolean selectableOption) {
		super(composite, style | SWT.NO_RADIO_GROUP);
		setSelectableOption(selectableOption);
		setBrowseType(browseType);
		createControl(composite);
	}
	
	public void setCaption(String caption){
		if (btnCaption instanceof Button){
			((Button)btnCaption).setText(caption);
		}else{
			((Label)btnCaption).setText(caption);
		}
	}
	
	public String getCaption(){
		if (btnCaption instanceof Button){
			return ((Button)btnCaption).getText();
		}else{
			return ((Label)btnCaption).getText();
		}
	}
	
	public void select(boolean select){
		if (isSelectableOption()){
			((Button)btnCaption).setSelection(select);
		}
	}
	
	public boolean isSelected() {
		if (isSelectableOption()){
			return ((Button)btnCaption).getSelection();
		}else{
			return true;
		}
    }
	
	public void createControl(Composite parent){
		controlList=new ArrayList<Control>();
		Composite composite = this;
		GridLayout layout = new GridLayout(4,false);
//		layout.numColumns = 4;
		layout.verticalSpacing = 9;
		composite.setLayout(layout);
		GridData gd;
		gd=new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);
		if (isSelectableOption()){
			btnCaption = new Button(composite, SWT.RADIO);
		}else{
			btnCaption = new Label(composite, SWT.RADIO);
		}
		setCaption("Location");
		gd = new GridData();
		btnCaption.setLayoutData(gd);

		locationText = new Text(composite, SWT.BORDER);
		controlList.add(locationText);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		boolean onlyOne=false;
		if (getBrowseType()==FILE_TYPE_FILE || getBrowseType()==FILE_TYPE_DIRECTORY){
			gd.horizontalSpan=2;
			onlyOne=true;
		}else{
			gd.horizontalSpan=3;
			new Label(composite,SWT.None);
			new Label(composite,SWT.None);
		}
		locationText.setLayoutData(gd);
		if ((getBrowseType() & FILE_TYPE_FILE) == FILE_TYPE_FILE){
    		fileButton = new Button(composite, SWT.PUSH);
    		fileButton.setText(onlyOne? "...":"File");
    		gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
    		if (!onlyOne){
    			gd.widthHint =70;
    			gd.grabExcessHorizontalSpace=true;
    			gd.minimumWidth=70;
    		}
    		fileButton.setLayoutData(gd);
    		controlList.add(fileButton);
		}
		if ((getBrowseType() & FILE_TYPE_DIRECTORY) == FILE_TYPE_DIRECTORY){
    		folderButton = new Button(composite, SWT.PUSH);
    		folderButton.setText(onlyOne? "...":"Directory");
    		gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
    		if (!onlyOne){
    			gd.widthHint =70;
    			gd.minimumWidth=70;
    		}
    		folderButton.setLayoutData(gd);
    		controlList.add(folderButton);
		}
		
		if (fileButton!=null) {
	        fileButton.addSelectionListener(new SelectionAdapter() {
		        public void widgetSelected(SelectionEvent arg0) {
			        handlePathBrowseButton(locationText, true);
		        }
	        });
        }
		if (folderButton!=null) {
	        folderButton.addSelectionListener(new SelectionAdapter() {
		        public void widgetSelected(SelectionEvent arg0) {
			        handlePathBrowseButton(locationText, false);
		        }
	        });
        }
		if (isSelectableOption()){
    		((Button)btnCaption).addSelectionListener(new SelectionAdapter() {
    			public void widgetSelected(SelectionEvent event) {
    				boolean b = ((Button) (event.widget)).getSelection();
    				for (Control control : controlList) {
	                    control.setEnabled(b);
                    }
    			}
    		});
		}
		
		locationText.addModifyListener(new ModifyListener(){
            public void modifyText(ModifyEvent arg0) {
            	setFilePath(locationText.getText());
            	pathChanged();
            }
		});
		
	}
	
	private void pathChanged(){
		for (IPathChangedListener listener : getListeners()) {
	        listener.pathChanged(getSelected());
        }
	}
	
	public void handlePathBrowseButton(Text pathText, boolean isFile) {
		String fileName = getSavePath(isFile);
		if (fileName != null){
			pathText.setText(fileName);
		}
	}

	private String getSavePath(boolean isFile) {
		String fileName = null;
		// FileDialog
		FileDialog fld = new FileDialog(this.getShell(), SWT.OPEN);
//		fld.setFilterExtensions(new String[]{extension});
		DirectoryDialog dird = new DirectoryDialog(this.getShell(), SWT.OPEN);
		boolean done = false;
			// Open the File Dialog
		while (!done) {
			// Open the File Dialog
			if(isFile){
				fileName = fld.open();
			}else{
				fileName = dird.open();
			}
			
			if (fileName == null) {
				// User has cancelled, so quit and return
				done = true;
			} else {
				// User has selected a file; see if it already exists
				File file = new File(fileName);
				if (file.exists()) {
					// If they click Yes, we're done and we drop out. If
					// they click No, we redisplay the File Dialog
					done = true;
				} else {
					// File does not exist, so drop out
					done = false;
				}
			}
		}
		return fileName;
	
	}

	
	public boolean handleFilePathText(boolean isFile) {
		boolean isPathValid = false;
		if(isFile){
			this.setFilePath(locationText.getText());
		}else{
			this.setFilePath(locationText.getText());
		}
		
		String msg = null;
		String ext = null;
		File file = new File(getFilePath());
		if (!file.exists()) {
			msg = "Invalid path specified";
			isPathValid = false;
		} else {
			if(file.isFile()){
				if (getFilePath().contains(".")) {
					ext = getFilePath().substring(
							getFilePath().lastIndexOf('.'),
							getFilePath().length());
				}else {
					msg = "Invalid file specified";
				}
			} 
			if (ext != null) {
				if (!ext.equals("."+extension)) {
					msg = "file should be with the extension of ." + extension + ". Please specify the correct gadget file. ";
					isPathValid = false;
				} else {
					isPathValid = true;
				}
			}
		}
		
		return isPathValid;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		if (!locationText.getText().equals(filePath)){
			locationText.setText(filePath);
		}else{
			this.filePath = filePath;
		}
	}
	
	public boolean validate(){
		if(getFilePath() != null && ! getFilePath().equals("")){
			File file = new File(getFilePath());
			if(file.exists()){
				isDataValid = true;
			}
		}
		return isDataValid;
	}

	public void setSelectableOption(boolean selectableOption) {
	    this.selectableOption = selectableOption;
    }

	public boolean isSelectableOption() {
	    return selectableOption;
    }

	public void setBrowseType(int browseType) {
	    this.browseType = browseType;
    }

	public int getBrowseType() {
	    return browseType;
    }
	
	public File getSelected(){
		return (getFilePath()==null)? null:new File(getFilePath());
	}
	
	public interface IPathChangedListener{
		public void pathChanged(File newPath);
	}
	
	public void addPathChangedListener(IPathChangedListener listner){
		getListeners().add(listner);
	}

	private List<IPathChangedListener> getListeners() {
		if (listeners==null){
			listeners=new ArrayList<IPathChangedListener>();
		}
	    return listeners;
    }
}
