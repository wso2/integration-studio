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

package org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.wso2.carbon.registry.core.Collection;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.RegistryResourceEditor;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class CollectionEditorPage extends FormPage implements
														IResourceChangeListener, 
														IRegistryFormEditorPage {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private RegistryResourceEditor editor;
	private boolean pageDirty;

	private String parentPath;
	private String resourceName = "";
	private String resourceMediaType = "";
	private String resourceDescription = "";

	private String currentResourceName;
	private String currentResourceMediaType = "";
	private String currentResourceDescription = "";
	private int currentMyRating;
	
	private Date createdDate;
	private String createdUser;
	private Date lastModifiedDate;
	private String lastModifiedUser;
	private String currentVersion;
	private int myRating;
	private float averageRating;
	private String currentlifeCycle;
	private String currentlifeCycleState;

	private FormToolkit toolkit;
	private ScrolledForm form;
	private Text txtName;
	private Combo comboMediaType;

	private RegistryResourceNode regResourcePathData;

	private Text txtDescription;
	private Text mediaTypeText;
	
	private Label otherLabel;
	private Text otherMediaTypeText;
	
	private Label createdDateLabel;
	private Label lastModifedDateLabel;
	private Label currentVersionLabel;
	private Label myRatingLabel;
	private Label averageRatingLabel;
	private Combo myRatingCombo;
	private Label lifeCycle;
	private Label lifeCycleState;
	
	private Button btnOk;
	
	private boolean isNewCollection;

	private ResourceEditorInput editorInput;
	
	private String[] collectionMediaTypes = {"application/vnd.wso2.esb",
	                                         "application/vnd.wso2.wsas",
	                                         "application/vnd.apache.axis2",
	                                         "application/vnd.apache.synapse"};

	/**
	 * CollectionEditorPage constructor
	 * @param editor
	 * @param id
	 * @param title
	 */
	public CollectionEditorPage(RegistryResourceEditor editor, String id, String title) {
		super(editor, id, title);
		this.editor = editor;
		editorInput = (ResourceEditorInput) editor.getEditorInput();
		retrieveData();
	}

	private void retrieveData() {
	    if (editorInput != null) {
	        RegistryResourceNode resource = editorInput.getResource();
	        if (resource != null) {
		        setCurrentResourceName(resource.getLastSegmentInPath());
		        setResourceName(resource.getLastSegmentInPath());
		        try {
			        Registry registry = resource.getConnectionInfo().getRegistry();
			        String selectedPath = resource.getRegistryResourcePath();
			        Resource regResource = registry.get(selectedPath);
			        setCurrentResourceMediaType(regResource.getMediaType());
			        setResourceMediaType(getCurrentResourceMediaType());
			        setCurrentResourceDescription(regResource.getDescription());
			        setResourceDescription(getCurrentResourceDescription());
			        setCreatedDate(regResource.getCreatedTime());
			        setLastModifiedDate(regResource.getLastModified());
			        setCreatedUser(regResource.getAuthorUserName());
			        setLastModifiedUser(regResource.getLastUpdaterUserName());

			        String version = null;

			        try {
				        //					Format of a version result is "/_system/registry-info.xml;version:72". Hence decoded in the following manner.
				        version = registry.getVersions(selectedPath)[0].split(";")[1].split(":")[1];
			        } catch (Exception e) {
				        //Exception is possible if the versions are not available. Hence avoid log.
				        //                	log.error(e);
			        }

			        if (version == null) {
				        setCurrentVersion("No Versions available for this resource");
			        } else {
				        setCurrentVersion(version);
			        }

					setCurrentLifeCycle(registry.getLifeCycleName(regResource));
					setCurrentLifeCycleState(registry.getLifeCycleState(regResource));

					try {
						setCurrentMyRating(registry.getRating(selectedPath, registry.getUserName()));
						setMyRating(getCurrentMyRating());
						setAverageRating(registry.getAverageRating(selectedPath));
					} catch (Exception e) {
						log.error("Error occured while retriveing the Rating for the user", e);
						setCurrentMyRating(0);
						setMyRating(0);
						setAverageRating(0);
					}
			        

		        } catch (Exception e) {
			        MessageDialogUtils.error(getSite().getShell(),
			                                 "Error while retreiving registry collection information",
			                                 e);
		        }
	        }
        }
    }

	/**
	 * get ResourceName
	 * @return
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * set ResourceName
	 * @param resourceName
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * get Resource MediaType
	 * @return
	 */
	public String getResourceMediaType() {
		return resourceMediaType;
	}

	/**
	 * set Resource MediaType
	 * @param resourceMediaType
	 */
	public void setResourceMediaType(String resourceMediaType) {
		this.resourceMediaType = resourceMediaType;
	}

	/**
	 * get Resource Description
	 * @return
	 */
	public String getResourceDescription() {
		return resourceDescription;
	}

	/**
	 * set Resource Description
	 * @param resourceDescription
	 */
	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
		if (this.resourceDescription == null){
			this.resourceDescription = "";
		}
	}

	/**
	 * get Current Resource Name
	 * @return
	 */
	public String getCurrentResourceName() {
		return currentResourceName;
	}

	/**
	 * set Current Resource Name
	 * @param currentResourceName
	 */
	public void setCurrentResourceName(String currentResourceName) {
		this.currentResourceName = currentResourceName;
		if (this.currentResourceName == null){
			this.currentResourceName = "";
		}
	}

	/**
	 * get Current Resource Media Type
	 * @return
	 */
	public String getCurrentResourceMediaType() {
		return currentResourceMediaType;
	}

	/**
	 * set Current Resource MediaType
	 * @param currentResourceMediaType
	 */
	public void setCurrentResourceMediaType(String currentResourceMediaType) {
		this.currentResourceMediaType = currentResourceMediaType;
		if (this.currentResourceMediaType == null){
			this.currentResourceMediaType = "";
		}
	}

	/**
	 * get Current Resource Description
	 * @return
	 */
	public String getCurrentResourceDescription() {
		return currentResourceDescription;
	}

	/**
	 * set Current Resource Description
	 * @param currentResourceDescription
	 */
	public void setCurrentResourceDescription(String currentResourceDescription) {
		this.currentResourceDescription = currentResourceDescription;
		if (this.currentResourceDescription == null){
			this.currentResourceDescription = "";
		}
	}

	/**
	 * resource Changed
	 */
	public void resourceChanged(IResourceChangeEvent arg0) {

	}

	/**
	 * update Form Name
	 */
	public void updateFormName() {
		String name = getResourceName().equalsIgnoreCase("") ? 
					  "<Collection>" :
					  getResourceName();
		name = getParentPath() + (getParentPath().endsWith("/") ? 
			   name : 
			   "/" + name);
		name = name.replaceAll(Pattern.quote("//"), "/");
		if (form!=null && !form.isDisposed()){
			form.setText(name);
		}

	}

	/**
	 * create Form Content
	 */
	protected void createFormContent(IManagedForm managedForm) {
		
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		form.getForm();
		form.getBody().setLayout(new GridLayout());

		Composite columnComp = toolkit.createComposite(form.getBody());
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
//		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 10;
//		layout.marginWidth = 10;
//		layout.makeColumnsEqualWidth = true;
		columnComp.setLayout(layout);
		columnComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL| 
											  GridData.VERTICAL_ALIGN_FILL));
		if (editorInput.getResource() == null) {
			isNewCollection=true;
			
			Label lbl = toolkit.createLabel(columnComp, "Name");
			lbl.setLayoutData(new GridData());
			txtName = toolkit.createText(columnComp, "", SWT.BORDER);
			txtName.setLayoutData(new GridData(300, -1));

			Label hiddenLab1 = toolkit.createLabel(columnComp, "");
			Label hiddenLab2 = toolkit.createLabel(columnComp, "");

			lbl = toolkit.createLabel(columnComp, "Media Type");
			lbl.setLayoutData(new GridData());
			comboMediaType = new Combo(columnComp, SWT.READ_ONLY);
			comboMediaType.setLayoutData(new GridData(310, -1));

			otherLabel = toolkit.createLabel(columnComp, "Other");
			otherLabel.setVisible(false);

			otherMediaTypeText = toolkit.createText(columnComp, "",
					SWT.BORDER);
			otherMediaTypeText.setLayoutData(new GridData(320, -1));
			otherMediaTypeText.setVisible(false);
			// otherMediaTypeText

			lbl = toolkit.createLabel(columnComp, "Description");
			GridData gd = new GridData();
			gd.horizontalSpan = 1;
			gd.verticalIndent = GridData.VERTICAL_ALIGN_BEGINNING;
			lbl.setLayoutData(gd);
			txtDescription = toolkit.createText(columnComp, "", SWT.BORDER
					| SWT.MULTI | SWT.V_SCROLL);

			// gd = new GridData(GridData.FILL_HORIZONTAL);
			gd = new GridData();
			// gd.horizontalSpan = 1;
			// gd.verticalSpan = 5;
			gd.widthHint = 305;
			gd.heightHint = 60;
			txtDescription.setLayoutData(gd);
			txtDescription.setText(getResourceDescription());
			// txtDescription.setLayoutData(new GridData(310, -1));

			txtName.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					setResourceName(txtName.getText());
					updateDirtyState();
					updateFormName();
				}

			});
			comboMediaType.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					if (comboMediaType.getSelectionIndex() == 0) {
						setResourceMediaType("");
					} else {
						setResourceMediaType(comboMediaType.getText());
						if (comboMediaType.getText().equals("other")) {
							otherLabel.setVisible(true);
							otherMediaTypeText.setVisible(true);
						}
					}
					updateDirtyState();
				}

			});

			otherMediaTypeText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent arg0) {
					setResourceMediaType(otherMediaTypeText.getText());
					updateDirtyState();
				}
			});

			txtDescription.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					setResourceDescription(txtDescription.getText());
					updateDirtyState();
				}

			});
			Label hiddenLab3 = toolkit.createLabel(columnComp, "");
			Label hiddenLab4 = toolkit.createLabel(columnComp, "");
			fillMediaTypes();
		}else{
			updateInfo(columnComp);
		}
		
		Label lblEmpty=toolkit.createLabel(columnComp, "");
		btnOk=toolkit.createButton(columnComp, " Save ", SWT.BUTTON1 | SWT.BORDER);
		btnOk.addListener(SWT.Selection, new Listener() {
			
			public void handleEvent(Event arg0) {
				try {
	                doFinish();
//	                refreshPage();
                } catch (Exception e) {
	                e.printStackTrace();
                }
			}
		});
		btnOk.setEnabled(false);
		
		form.reflow(true);
	}
	
	
	private void refreshPage(){
		retrieveData();
		if (!isNewCollection) {
			reloadData();
		}
	}
	
	private void reloadData(){
//		txtDescription.setText(getResourceDescription());
		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy H:mm:ss");
		lastModifedDateLabel.setText("By "+getLastModifiedUser()+" "+formatter.format(getLastModifiedDate()));
		currentVersionLabel.setText(getCurrentVersion());
		myRatingCombo.select(getMyRating());
		averageRatingLabel.setText(""+getAverageRating());
	}

	/**
	 * update Info
	 * @throws UnknownRegistryException 
	 * @throws InvalidRegistryURLException 
	 */
	private void updateInfo(Composite container){
		

		
		GridData gd;
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		Label nameLabel = toolkit.createLabel(container, "Name: ");
		nameLabel.setLayoutData(gd);
		
		Label name = toolkit.createLabel(container, getResourceName());
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		name.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		toolkit.createLabel(container, "Media Type: ");

		
		if (comboMediaType == null) {
			comboMediaType = new Combo(container, SWT.READ_ONLY);
			comboMediaType.setLayoutData(new GridData(310, -1));

			otherLabel = toolkit.createLabel(container, "Other");
			otherLabel.setVisible(false);

			otherMediaTypeText = toolkit.createText(container, "",
					SWT.BORDER);
			otherMediaTypeText.setLayoutData(new GridData(320, -1));
			otherMediaTypeText.setVisible(false);
		}
		
		comboMediaType.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (comboMediaType.getSelectionIndex() == 0) {
					setResourceMediaType("");
				} else {
					setResourceMediaType(comboMediaType.getText());
					if (comboMediaType.getText().equals("other")) {
						otherLabel.setVisible(true);
						otherMediaTypeText.setVisible(true);
					}
				}
				updateDirtyState();
			}

		});

		otherMediaTypeText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setResourceMediaType(otherMediaTypeText.getText());
				updateDirtyState();
			}
		});
		
		fillMediaTypes();
		
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 250;
		Label descriptionLabel = toolkit.createLabel(container, "", SWT.NULL);
		descriptionLabel.setText("Description: ");
		descriptionLabel.setLayoutData(gd);

		if (txtDescription == null) {
			gd = new GridData();
			gd.widthHint = 300;
			gd.heightHint = 150;
			txtDescription = toolkit.createText(container, "", SWT.MULTI | SWT.BORDER
					| SWT.V_SCROLL | SWT.WRAP);
			txtDescription.setLayoutData(gd);
		}
		txtDescription.setText(getResourceDescription());
		
		txtDescription.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setResourceDescription(txtDescription.getText());
				updateDirtyState();
				
			}
		});
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");

		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy H:mm:ss");
		
		Label lblCreated= toolkit.createLabel(container, "Created Date: ", SWT.NULL);
		createdDateLabel=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		createdDateLabel.setText("By "+ getCreatedUser()+" "+formatter.format(getCreatedDate()));
		createdDateLabel.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		Label lblLastModified= toolkit.createLabel(container, "Last Modified Date: ", SWT.NULL);
		lastModifedDateLabel=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lastModifedDateLabel.setText("By "+getLastModifiedUser()+" "+formatter.format(getLastModifiedDate()));
		lastModifedDateLabel.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		Label lblVersion=toolkit.createLabel(container, "Current Version:",SWT.NULL);
		currentVersionLabel=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		currentVersionLabel.setText(getCurrentVersion());
		currentVersionLabel.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		
		Label lblLifeCycle=toolkit.createLabel(container, "Current Life Cycle:",SWT.NULL);
		lifeCycle=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lifeCycle.setText(getCurrentLifeCycle());
		lifeCycle.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		Label lblLifeCycleState=toolkit.createLabel(container, "Life Cycle State:",SWT.NULL);
		lifeCycleState=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		lifeCycleState.setText(getCurrentLifeCycleState());
		lifeCycleState.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
//		Label lblMyRating=toolkit.createLabel(container, "My Rating:",SWT.NULL);
//		myRatingLabel=toolkit.createLabel(container, "", SWT.NULL);
//		gd = new GridData();
//		gd.heightHint = 18;
//		gd.widthHint = 350;
//		myRatingLabel.setText(""+getMyRating());
//		myRatingLabel.setLayoutData(gd);
//		
//		toolkit.createLabel(container, "");
//		toolkit.createLabel(container, "");
		
		Label lblMyRatingCmb=toolkit.createLabel(container, "My Rating:",SWT.NULL);
		myRatingCombo= new Combo(container, SWT.READ_ONLY);  //toolkit.cre(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = -1;
		gd.widthHint = 310;
		myRatingCombo.setLayoutData(gd);
		String[] items={"0","1","2","3","4","5"};
		myRatingCombo.setItems(items);
		myRatingCombo.select(getMyRating());
		
		myRatingCombo.addListener(SWT.Selection, new Listener() {
			
			public void handleEvent(Event arg0) {
				setMyRating(Integer.parseInt(myRatingCombo.getText()));
//				setPageDirty(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
		
		Label lblAverageRating=toolkit.createLabel(container, "Average Rating:",SWT.NULL);
		averageRatingLabel=toolkit.createLabel(container, "", SWT.NULL);
		gd = new GridData();
		gd.heightHint = 18;
		gd.widthHint = 350;
		averageRatingLabel.setText(""+getAverageRating());
		averageRatingLabel.setLayoutData(gd);
		
		toolkit.createLabel(container, "");
		toolkit.createLabel(container, "");
	}

	public String getCurrentLifeCycle() {
		return this.currentlifeCycle;
	}
	
	public void setCurrentLifeCycle(String currentLifeCycle ){
		this.currentlifeCycle = currentLifeCycle;
	}
	
	public String getCurrentLifeCycleState() {
		return this.currentlifeCycleState;
	}
	
	public void setCurrentLifeCycleState(String currentLifeCycleState ){
		this.currentlifeCycleState = currentLifeCycleState;
	}

	/**
	 * fill MediaTypes
	 */
	private void fillMediaTypes() {
		if (comboMediaType != null) {
			comboMediaType.removeAll();
			if(!getResourceMediaType().equals("")){
				comboMediaType.setText(getResourceMediaType());
			}
			comboMediaType.add("not specified");
			for (int i = 0; i < collectionMediaTypes.length; i++) {
	            comboMediaType.add(collectionMediaTypes[i]);
            } 
			comboMediaType.add("other");
//			for (String type : MediaTypes.getAllKeys()) {
//				if (type.contains("/")){
//					comboMediaType.add(type);
//				}
//			}
			if (getResourceMediaType().equals("")){
				comboMediaType.select(0);
			}else{
				comboMediaType.setText(getResourceMediaType());
			}
		}
	}

	/**
	 * update DirtyState
	 */
	private void updateDirtyState() {
		boolean isDirty =
		                  (getCurrentResourceName() == null ||
		                   (!getCurrentResourceName().equals(getResourceName())) ||
		                   (!getCurrentResourceMediaType().equals(getResourceMediaType())) ||
		                   (!getCurrentResourceDescription().equals(getResourceDescription())) || getCurrentMyRating() != getMyRating());
		setPageDirty(isDirty);

		// Enabling Save button if delta exists
		if (btnOk != null) {
			btnOk.setEnabled(isDirty);
		}
	}

	/**
	 * set ParentPath
	 * @param parentPath
	 */
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	/**
	 * get ParentPath
	 * @return
	 */
	public String getParentPath() {
		if (parentPath == null) {
			parentPath = "";
		}
		return parentPath;
	}

	/**
	 * sync To CurrentValues
	 */
	public void syncToCurrentValues() {
		setCurrentResourceName(getResourceName());
		setCurrentResourceMediaType(getResourceMediaType());
		setCurrentResourceDescription(getResourceDescription());
		updateDirtyState();
	}

	/**
	 * get RegResource PathData
	 * @return
	 */
	public RegistryResourceNode getRegResourcePathData() {
		return regResourcePathData;
	}

	/**
	 * set Registry Resource node
	 * @param regResourcePathData
	 */
	public void setRegResourcePathData(RegistryResourceNode regResourcePathData) {
		this.regResourcePathData = regResourcePathData;
	}

	/**
	 * execute action
	 */
	public void executeAction(int actionID, Object object) {
		switch (actionID) {
			case IRegistryFormEditorPage.ACTION_VIEW_INFORMATION:
				setEditorFocus();
				break;
			}
	}
	
	public void setEditorFocus(){
		this.setFocus();
	}

	/**
	 *get Page Type 
	 */
	public int getPageType() {
		return IRegistryFormEditorPage.PAGE_COLLECTION;
	}

	/**
	 * validate form page info
	 */
	public void validate() throws Exception {
		String resourceName = getResourceName();
		if (resourceName == null || resourceName.equals("")){
			throw new Exception("The collection name cannot be empty");
		}
		RegistryResourceNode regResourcePathData = ((ResourceEditorInput) getEditorInput())
																				.getParentResource();
		boolean found = false;
		if (!resourceName.equals(getCurrentResourceName())) {
			for (RegistryResourceNode child : regResourcePathData.getResourceNodeList()) {
				if (child.getCaption().equals(resourceName)) {
					found = true;
					break;
				}
			}
			if (found){
				throw new Exception("The collection name '" + 
									resourceName +
									"' is already used by another sibling");
			}
		}
	}

	/**
	 * finish tasks on the editor page
	 */
	public void doFinish() throws Exception {
		if (editorInput.getResource() == null) {
			ResourceEditorInput editorInput = (ResourceEditorInput) getEditorInput();
			final RegistryResourceNode regResourcePathData = editorInput.getParentResource();
			Registry registry = regResourcePathData.getConnectionInfo().getRegistry();
			String selectedPath = regResourcePathData.getRegistryResourcePath();
			selectedPath = selectedPath.endsWith("/") ? selectedPath: selectedPath + "/";
			Collection collection = registry.newCollection();
			collection.setDescription(getResourceDescription());
			collection.setMediaType(getResourceMediaType());
			String newPath = selectedPath + getResourceName();
			String name = URLEncoder.encode(newPath);
			if (getCurrentResourceName() != null &&
				!getCurrentResourceName().equals(getResourceName())){
				registry.rename( selectedPath + "/" + getCurrentResourceName(),
								   newPath);
			}
			
			registry.put(newPath, collection);
			Display.getDefault().asyncExec(new Runnable() {
				
				public void run() {
					try {
	                    regResourcePathData.refreshChildren();
                    } catch (InvalidRegistryURLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
                    } catch (UnknownRegistryException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
                    }					
				}
			});
			regResourcePathData.getConnectionInfo().getRegUrlData().refreshViewer(false);
			ArrayList<RegistryResourceNode> resourcePathList = regResourcePathData
																			 .getResourceNodeList();
			for (RegistryResourceNode registryResourcePathData : resourcePathList) {
				if (registryResourcePathData.getRegistryResourcePath().equals(newPath)){
					editorInput.setResource(registryResourcePathData);
				}
			}
		} else {
			regResourcePathData = editorInput.getResource();
			Registry registry = regResourcePathData.getConnectionInfo().getRegistry();
			Resource resource = registry.get(regResourcePathData.getRegistryResourcePath());
			resource.setMediaType(getResourceMediaType());
			resource.setDescription(getResourceDescription());
			registry.put(regResourcePathData.getRegistryResourcePath(), resource);
			registry.setRating(regResourcePathData.getRegistryResourcePath(), getMyRating());

		}
		syncToCurrentValues();
		refreshPage();
		updateDirtyState();
	}

	/**
	 * set page dirty
	 * @param pageDirty
	 */
	public void setPageDirty(boolean pageDirty) {
		this.pageDirty = pageDirty;
		editor.updateDirtyState();
	}

	/**
	 * page dirty check
	 */
	public boolean isPageDirty() {
		return pageDirty;
	}

	/**
     * @param createdDateLabel the createdDateLabel to set
     */
    public void setCreatedDateLabel(Label createdDateLabel) {
	    this.createdDateLabel = createdDateLabel;
    }

	/**
     * @return the createdDateLabel
     */
    public Label getCreatedDateLabel() {
	    return createdDateLabel;
    }

	/**
     * @param lastModifedDateLabel the lastModifedDateLabel to set
     */
    public void setLastModifedDateLabel(Label lastModifedDateLabel) {
	    this.lastModifedDateLabel = lastModifedDateLabel;
    }

	/**
     * @return the lastModifedDateLabel
     */
    public Label getLastModifedDateLabel() {
	    return lastModifedDateLabel;
    }

	/**
     * @param currentVersionLabel the currentVersionLabel to set
     */
    public void setCurrentVersionLabel(Label currentVersionLabel) {
	    this.currentVersionLabel = currentVersionLabel;
    }

	/**
     * @return the currentVersionLabel
     */
    public Label getCurrentVersionLabel() {
	    return currentVersionLabel;
    }

	/**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
	    this.createdDate = createdDate;
    }

	/**
     * @return the createdDate
     */
    public Date getCreatedDate() {
	    return createdDate;
    }

	public String getCreatedUser() {
    	return createdUser;
    }

	public void setCreatedUser(String createdUser) {
    	this.createdUser = createdUser;
    }

	public Date getLastModifiedDate() {
    	return lastModifiedDate;
    }

	public void setLastModifiedDate(Date lastModifiedDate) {
    	this.lastModifiedDate = lastModifiedDate;
    }

	public String getLastModifiedUser() {
    	return lastModifiedUser;
    }

	public void setLastModifiedUser(String lastModifiedUser) {
    	this.lastModifiedUser = lastModifiedUser;
    }

	public String getCurrentVersion() {
    	return currentVersion;
    }

	public void setCurrentVersion(String currentVersion) {
    	this.currentVersion = currentVersion;
    }

	/**
     * @param myRating the myRating to set
     */
    public void setMyRating(int myRating) {
	    this.myRating = myRating;
    }

	/**
     * @return the myRating
     */
    public int getMyRating() {
	    return myRating;
    }

	/**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(float averageRating) {
	    this.averageRating = averageRating;
    }

	/**
     * @return the averageRating
     */
    public float getAverageRating() {
	    return averageRating;
    }

	/**
     * @param currentMyRating the currentMyRating to set
     */
    public void setCurrentMyRating(int currentMyRating) {
	    this.currentMyRating = currentMyRating;
    }

	/**
     * @return the currentMyRating
     */
    public int getCurrentMyRating() {
	    return currentMyRating;
    }
}
