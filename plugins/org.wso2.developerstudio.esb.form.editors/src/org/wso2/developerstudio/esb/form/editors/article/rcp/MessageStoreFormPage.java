/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.esb.form.editors.article.rcp;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.CustomStore;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.IMessageStore;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.InMemory;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.JDBC;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.JMS;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.RabbitMQ;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.Resequence;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores.WSO2MB;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageStoreFormPage extends AbstractEsbFormPage {
	/**
	 * @param id
	 * @param title
	 */
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private String[] messageStoreTypes = {"In-Memory Message Store", "JMS Message Store", "WSO2 MB Message Store", "RabbitMQ Message Store", "JDBC Message Store", "Resequence Message Store", "Custom Message Store"};
	@SuppressWarnings("unused")
	private IMessageStore currentMessageStore = null;
//	private ArrayList<Section> sectionsList = new ArrayList<Section>();
	
	public Text storeName;
	public Combo storeType;
	
	ScrolledForm form ;
	FormToolkit toolkit;
	
	private static final String IN_MEMORY_MS_FQN = "org.apache.synapse.message.store.impl.memory.InMemoryStore";
	private static final String JMS_MS_FQN = "org.apache.synapse.message.store.impl.jms.JmsStore";	
	private static final String WSO2MB = "wso2mb";
	private static final String RABBITMQ_MS_FQN = "org.apache.synapse.message.store.impl.rabbitmq.RabbitMQStore";
	private static final String JDBC_MS_FQN = "org.apache.synapse.message.store.impl.jdbc.JDBCMessageStore";
	private static final String RESEQUENCE_MS_FQN = "org.apache.synapse.message.store.impl.resequencer.ResequenceMessageStore";
	private static final String customStore = "customStore";
	
	Section guaranteedDeliverySection;
	
	public Combo guaranteedDeliveryEnable;
	public Combo failoverMessageStore;
	
	Map<String, IMessageStore> storeMap;
	
	public MessageStoreFormPage(FormEditor editor) {
		super(editor, "messageStoreForm", Messages.getString("MessageStorePage.sectionMainTitle"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("MessageStorePage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		
		GridLayout layout = new GridLayout();
		layout.marginLeft = 20;
		layout.marginRight = 20;
		layout.marginTop = 10;
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		
		form.getBody().setLayout(layout);
		GridData formGridData = new GridData();
		formGridData.horizontalSpan = 6;
		formGridData.grabExcessHorizontalSpace = true;
		form.setLayoutData(formGridData);
		
		/*ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);*/
		
		storeMap = new LinkedHashMap<>();
		
		storeMap.put(IN_MEMORY_MS_FQN, new InMemory(form, toolkit, this));
		storeMap.put(JMS_MS_FQN, new JMS(form, toolkit, this));
		storeMap.put(WSO2MB, new WSO2MB(form, toolkit, this));
		storeMap.put(RABBITMQ_MS_FQN, new RabbitMQ(form, toolkit, this));
		storeMap.put(JDBC_MS_FQN, new JDBC(form, toolkit, this));
		storeMap.put(RESEQUENCE_MS_FQN, new Resequence(form, toolkit, this));
		storeMap.put(customStore, new CustomStore(form, toolkit, this));


		createFormBasicSection(form, toolkit);
		createFormConnectionSection(form, toolkit);
		createFormGuaranteedDeliverySection(form, toolkit);
		createFormParameterSection(form, toolkit);
	}
	
	@SuppressWarnings("deprecation")
	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Basic Section */
		Section basicSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		basicSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		basicSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(basicSection);

		basicSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		basicSection.setText(Messages.getString("MessageStorePage.section.basic"));
		
		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		basicSection.setLayoutData(samplegridData);
		
		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new GridLayout());
		
		basicSection.setClient(basicSectionClient);
		
		toolkit.createLabel(basicSectionClient, "Message Store Name *");
		storeName = toolkit.createText(basicSectionClient, "");
		storeName.setBackground(new Color(null, 229,236,253));
		GridData storeNameGridData = new GridData();
		storeNameGridData.horizontalSpan = 3;
		storeNameGridData.horizontalAlignment = GridData.FILL;
		storeNameGridData.grabExcessHorizontalSpace = true;
		storeName.setLayoutData(storeNameGridData);
		
		storeName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Message Store Type *");
		storeType = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData storeTypeGridData = new GridData();
		storeTypeGridData.horizontalSpan = 3;
		storeTypeGridData.horizontalAlignment = GridData.FILL;
		storeTypeGridData.grabExcessHorizontalSpace = true;
		storeType.setLayoutData(storeTypeGridData);
		
		String[] triggerTypes = messageStoreTypes;
		storeType.setItems(triggerTypes);
		storeType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Create message stores
				if (storeType.getSelectionIndex() == 0) {
					currentMessageStore = storeMap.get(IN_MEMORY_MS_FQN);
				} else if (storeType.getSelectionIndex() == 1) {
					currentMessageStore = storeMap.get(JMS_MS_FQN);
				} else if (storeType.getSelectionIndex() == 2) {
					currentMessageStore = storeMap.get(WSO2MB);
				} else if (storeType.getSelectionIndex() == 3) {
					currentMessageStore = storeMap.get(RABBITMQ_MS_FQN);
				} else if (storeType.getSelectionIndex() == 4) {
					currentMessageStore = storeMap.get(JDBC_MS_FQN);
				} else if (storeType.getSelectionIndex() == 5) {
					currentMessageStore = storeMap.get(RESEQUENCE_MS_FQN);
				} else if (storeType.getSelectionIndex() == 6) {
					currentMessageStore = storeMap.get(customStore);
				}
				
				refreshStoreSettings();
				setSave(true);
				updateDirtyState();
				
			}
		});
		
		storeType.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
	}
	
	
	private void createFormConnectionSection(final ScrolledForm form, FormToolkit toolkit) {
		
		for (IMessageStore aStore : storeMap.values()) {
			aStore.createConnectionSectionFields();
		}

	}
	
	
	private void createFormGuaranteedDeliverySection(final ScrolledForm form, FormToolkit toolkit) {
		
		
		/* Guaranteed Delivery Section */ 
		guaranteedDeliverySection = this.createSection(form, toolkit, Messages.getString("MessageStorePage.section.guaranteedDelivery"));

		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		guaranteedDeliverySection.setLayoutData(samplegridData);
		
		Composite guaranteedDeliverySectionClient = toolkit.createComposite(guaranteedDeliverySection);
		guaranteedDeliverySectionClient.setLayout(new GridLayout());
		
		guaranteedDeliverySection.setClient(guaranteedDeliverySectionClient);
		guaranteedDeliverySection.setExpanded(false);
		
		toolkit.createLabel(guaranteedDeliverySectionClient, "Enable Producer Guaranteed Delivery");
		guaranteedDeliveryEnable = new Combo(guaranteedDeliverySectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData guaranteedDeliveryEnableGridData = new GridData();
		guaranteedDeliveryEnableGridData.horizontalSpan = 3;
		guaranteedDeliveryEnableGridData.horizontalAlignment = GridData.FILL;
		guaranteedDeliveryEnableGridData.grabExcessHorizontalSpace = true;
		guaranteedDeliveryEnable.setLayoutData(guaranteedDeliveryEnableGridData);
		String[] states = {"True", "False"};
		guaranteedDeliveryEnable.setItems(states);
		guaranteedDeliveryEnable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
				super.widgetSelected(e);
			}
		});
		
		guaranteedDeliveryEnable.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		
		toolkit.createLabel(guaranteedDeliverySectionClient, "Failover Message Store");
		failoverMessageStore = new Combo(guaranteedDeliverySectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		ArrayList<String> availableMSList = getAvailableMessageStores();
		String[] list = new String[availableMSList.size()];
		list = availableMSList.toArray(list);
		failoverMessageStore.setItems(list);
		GridData failoverMessageStoreGridData = new GridData();
		failoverMessageStoreGridData.horizontalSpan = 3;
		failoverMessageStoreGridData.horizontalAlignment = GridData.FILL;
		failoverMessageStoreGridData.grabExcessHorizontalSpace = true;
		failoverMessageStore.setLayoutData(failoverMessageStoreGridData);
		failoverMessageStore.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {	
				setSave(true);
				updateDirtyState();
			}

		});

		failoverMessageStore.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
	}
	
	/**
	 * Get the available message Stores
	 * @return
	 */
	private ArrayList<String> getAvailableMessageStores() {

		ArrayList<String> availableMS = new ArrayList<String>();
		File projectPath = null;
		Shell shell = Display.getDefault().getActiveShell();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject activeProject : projects) {
			if (activeProject != null) {
				try {
					if(activeProject.isOpen()){
						if (activeProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
							ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
							projectPath = activeProject.getLocation().toFile();
							try {
								esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile());
								List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
								for (ESBArtifact esbArtifact : allESBArtifacts) {
									if ("synapse/message-store".equals(esbArtifact.getType())) {
										File artifact = new File(projectPath, esbArtifact.getFile());
										availableMS.add(artifact.getName().replaceAll("[.]xml$", ""));
									} 
								}
							} catch (Exception e) {
								log.error("Error occured while scanning the project for artifacts", e);
								ErrorDialog.openError(shell, "Error occured while scanning the project for artifacts",
										e.getMessage(), null);
							}
						}
					}
				} catch (CoreException e) {
					log.error("Error occured while scanning the project", e);
					ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(), null);
				}
			}
		}
		return availableMS;
	}


	private void createFormParameterSection(final ScrolledForm form, FormToolkit toolkit) {
		
		for (IMessageStore aStore : storeMap.values()) {
			aStore.createParameterSectionFields();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);
		
		return section;
	}
	
	public IMessageStore getStoreImpl(String storeClass) {
		return storeMap.get(storeClass);
	}

	public void refreshStoreSettings() {
		int selectedIndex = storeType.getSelectionIndex();
		
		int index = 0;
		
		boolean guaranteedDeliveryFlag = false;
		
		for (IMessageStore aStore: storeMap.values()) {
			if (index == selectedIndex) {
				aStore.showParametersSection();
				aStore.showConnectionSection();
				
				if(aStore.hasGuaranteedDelivery() && !guaranteedDeliveryFlag) {
					this.guaranteedDeliverySection.setVisible(true);
					guaranteedDeliveryFlag = true;
				}
				
			} else {
				aStore.hideParametersSection();
				aStore.hideConnectionSection();
				
				if(aStore.hasGuaranteedDelivery() && !guaranteedDeliveryFlag) {
					this.guaranteedDeliverySection.setVisible(false);
				}
			}
			
			
			index ++;
		}
		
		
		
	}

}
