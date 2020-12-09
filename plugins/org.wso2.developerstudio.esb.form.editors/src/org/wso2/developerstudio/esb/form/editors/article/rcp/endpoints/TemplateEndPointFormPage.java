 /*
  * Copyright 2016 WSO2, Inc. (http://wso2.com)
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
 
package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureTemplateEndpointParameterDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class TemplateEndPointFormPage extends EndpointFormPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private final String TYPE_TEMPLATE_SEQ = "synapse/sequenceTemplate";
	private final String TYPE_TEMPLATE_EPT = "synapse/endpointTemplate";
	private final String DEFAULT_VALUE = "Select From Templates";

	public Button templateEP_Parameters;
	public Combo tempEP_AvaiableTemp;
	public Text tempEP_TargetTemp;
	public Text tempEP_Description;

	public String name;
	public String uri;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getURI() {
		return uri;
	}

	public void setURI(String uri) {
		this.uri = uri;
	}

	public Combo getTempEP_AvaiableTemp() {
		return tempEP_AvaiableTemp;
	}

	public void setTempEP_AvaiableTemp(Combo tempEP_AvaiableTemp) {
		this.tempEP_AvaiableTemp = tempEP_AvaiableTemp;
	}

	public Text getTempEP_TargetTemp() {
		return tempEP_TargetTemp;
	}

	public void setTempEP_TargetTemp(Text tempEP_TargetTemp) {
		this.tempEP_TargetTemp = tempEP_TargetTemp;
	}

	public Text getTempEP_Description() {
		return tempEP_Description;
	}

	public void setTempEP_Description(Text tempEP_Description) {
		this.tempEP_Description = tempEP_Description;
	}

	public List<TemplateEndpointParameter> templateParameterList;

	Section basicSection;

	public TemplateEndPointFormPage(FormEditor editor) {
		super(editor);
	}

	protected void createFormContent(IManagedForm managedForm) {

		super.createFormContent(managedForm);

		form.setText(Messages.getString("TemplateEndpointPage.sectionMainTitle"));
	}

	@Override
	public void createFormBasicSection() {

		/* Basic Section */
		basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));
		GridData miscSectionGridData = new GridData();
		miscSectionGridData.horizontalSpan = 3;
		miscSectionGridData.horizontalAlignment = GridData.FILL;
		miscSectionGridData.grabExcessHorizontalSpace = true;
		basicSection.setLayoutData(miscSectionGridData);
		// miscSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite miscSectionClient = toolkit.createComposite(basicSection);
		miscSectionClient.setLayout(new GridLayout());
		basicSection.setClient(miscSectionClient);
		/*
		 * Composite miscSectionClient = toolkit.createComposite(miscSection); miscSectionClient.setLayout(new
		 * TableWrapLayout()); miscSection.setClient(miscSectionClient);
		 */

		toolkit.createLabel(miscSectionClient, "Available Templates :");
		tempEP_AvaiableTemp = new Combo(miscSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// defaultEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		ArrayList<String> availableTemplateList = getAvailableTemplateList();
		String[] list = new String[availableTemplateList.size()];
		list = availableTemplateList.toArray(list);
		tempEP_AvaiableTemp.setItems(list);
		GridData templateEPAvailableListGridData = new GridData();
		templateEPAvailableListGridData.horizontalSpan = 3;
		templateEPAvailableListGridData.horizontalAlignment = GridData.FILL;
		templateEPAvailableListGridData.grabExcessHorizontalSpace = true;
		tempEP_AvaiableTemp.setLayoutData(templateEPAvailableListGridData);

		tempEP_AvaiableTemp.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				if (!tempEP_AvaiableTemp.getText().equals(DEFAULT_VALUE)) {
					tempEP_TargetTemp.setText(tempEP_AvaiableTemp.getText());
				}
				setSave(true);
				updateDirtyState();
			}

		});
		
		tempEP_AvaiableTemp.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		toolkit.createLabel(miscSectionClient, "Target Template :");
		tempEP_TargetTemp = toolkit.createText(miscSectionClient, "");
		tempEP_TargetTemp.setEditable(false);
		tempEP_TargetTemp.setBackground(new Color(null, 229, 236, 253));
		// defaultEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData templateEPTargetListGridData = new GridData();
		templateEPTargetListGridData.horizontalSpan = 3;
		templateEPTargetListGridData.horizontalAlignment = GridData.FILL;
		templateEPTargetListGridData.grabExcessHorizontalSpace = true;
		tempEP_TargetTemp.setLayoutData(templateEPTargetListGridData);
		
		tempEP_TargetTemp.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		toolkit.createLabel(miscSectionClient, "Description :");
		tempEP_Description = toolkit.createText(miscSectionClient, "");
		tempEP_Description.setBackground(new Color(null, 229, 236, 253));
		// defaultEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData templateEPDescriptionGridData = new GridData();
		templateEPDescriptionGridData.horizontalSpan = 3;
		templateEPDescriptionGridData.horizontalAlignment = GridData.FILL;
		templateEPDescriptionGridData.grabExcessHorizontalSpace = true;
		tempEP_Description.setLayoutData(templateEPDescriptionGridData);
		
		tempEP_Description.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		toolkit.createLabel(miscSectionClient, "Parameters :");
		templateEP_Parameters = toolkit.createButton(miscSectionClient, "Add Parameters", SWT.PUSH);
		templateEP_Parameters.setBackground(new Color(null, 229, 236, 253));
		templateEP_Parameters.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				ConfigureTemplateEndpointParameterDialog paramDialog = new ConfigureTemplateEndpointParameterDialog(
						shell, templateParameterList, getName(), getURI());
				paramDialog.setBlockOnOpen(true);
				paramDialog.open();
				templateParameterList = paramDialog.getTemplateParameterList();
				name = paramDialog.getName();
				uri = paramDialog.getURI();
				
				setSave(true);
				updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		basicSection.setClient(miscSectionClient);

	}

	private ArrayList<String> getAvailableTemplateList() {

		ArrayList<String> definedTemplates = new ArrayList<String>();
		definedTemplates.add(DEFAULT_VALUE);
		File projectPath = null;
		Shell shell = Display.getDefault().getActiveShell();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject activeProject : projects) {
			if (activeProject != null) {
				try {
					if (activeProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						projectPath = activeProject.getLocation().toFile();
						try {
							esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile());
							List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
							for (ESBArtifact esbArtifact : allESBArtifacts) {
								if (TYPE_TEMPLATE_SEQ.equals(esbArtifact.getType())) {
									File artifact = new File(projectPath, esbArtifact.getFile());
									definedTemplates.add(artifact.getName().replaceAll("[.]xml$", ""));
								} else if (TYPE_TEMPLATE_EPT.equals(esbArtifact.getType())) {
									File artifact = new File(projectPath, esbArtifact.getFile());
									definedTemplates.add(artifact.getName().replaceAll("[.]xml$", ""));
								}
							}
						} catch (Exception e) {
							log.error("Error occured while scanning the project for artifacts", e);
						}
					}
				} catch (CoreException e) {
					log.error("Error occured while scanning the project", e);
				}
			}
		}
		return definedTemplates;
	}

}
