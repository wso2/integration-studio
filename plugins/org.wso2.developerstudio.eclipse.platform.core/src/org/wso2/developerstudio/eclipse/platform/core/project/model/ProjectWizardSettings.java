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

package org.wso2.developerstudio.eclipse.platform.core.project.model;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.ICompositeProvider;
import org.wso2.developerstudio.eclipse.platform.core.utils.RegistryOptionsConstants;

// import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectWizardSettings extends AbstractXMLDoc {

	// Project Options page
	private String projectOptionsTitle;
	private String projectOptionsDescription;
	private String projectOptionsError;
	private List<ProjectOption> projectOptions;

	private List<ProjectOptionInfo> projectOptionInfo;

	private IConfigurationElement configElement;

	public ProjectWizardSettings(InputStream settingsStream, IConfigurationElement configElement) throws Exception {
		setConfigElement(configElement);
		deserialize(settingsStream);
	}

	public ProjectWizardSettings() {
	}

	public String getProjectOptionsTitle() {
		return projectOptionsTitle;
	}

	public void setProjectOptionsTitle(String projectOptionsTitle) {
		this.projectOptionsTitle = projectOptionsTitle;
	}

	public String getProjectOptionsDescription() {
		return projectOptionsDescription;
	}

	public void setProjectOptionsDescription(String projectOptionsDescription) {
		this.projectOptionsDescription = projectOptionsDescription;
	}

	public String getProjectOptionsError() {
		return projectOptionsError;
	}

	public void setProjectOptionsError(String projectOptionsError) {
		this.projectOptionsError = projectOptionsError;
	}

	public List<ProjectOption> getProjectOptions() {
		if (projectOptions == null) {
			projectOptions = new ArrayList<ProjectOption>();
		}
		return projectOptions;
	}

	private Map<String, String> getControlData(OMElement element) {
		Map<String, String> data = getControlData(getAttribute(element, "controlData"));
		return data;
	}

	private Map<String, String> getControlData(String controlDataAttr) {
		Map<String, String> data = new HashMap<String, String>();
		if (controlDataAttr != null) {
			String[] controlData = controlDataAttr.split(";");
			for (String controlDataElement : controlData) {
				String[] dataElements = controlDataElement.split("=");
				if (dataElements.length > 1) {
					data.put(dataElements[0], dataElements[1]);
				}
			}
		}
		return data;
	}

	protected void deserialize(OMElement documentElement) throws Exception {
		List<OMElement> projectOptionsElement = getChildElements(documentElement, "projectOptions");
		if (projectOptionsElement != null && projectOptionsElement.size() > 0) {
			setProjectOptionsTitle(getAttribute(projectOptionsElement.get(0), "title"));
			setProjectOptionsDescription(getAttribute(projectOptionsElement.get(0), "description"));
			setProjectOptionsError(getAttribute(projectOptionsElement.get(0), "error"));
			List<OMElement> projectOptionElements = getChildElements(projectOptionsElement.get(0), "option");
			for (OMElement projectOptionElement : projectOptionElements) {
				String id = getAttribute(projectOptionElement, "id");
				String label = projectOptionElement.getText();
				String defaultAttr = getAttribute(projectOptionElement, "default");
				boolean isDefault = (defaultAttr == null ? false : defaultAttr.equalsIgnoreCase("true"));
				getProjectOptions().add(new ProjectOption(id, label, isDefault));
			}
		}
		List<OMElement> projectOptionSettingsElement = getChildElements(documentElement, "projectOptionSettings");
		if (projectOptionSettingsElement != null && projectOptionSettingsElement.size() > 0) {
			List<OMElement> projectOptionDataInfoElements =
			                                                getChildElements(projectOptionSettingsElement.get(0),
			                                                                 "settings");
			for (OMElement projectOptionDataInfoElement : projectOptionDataInfoElements) {
				String idAttribute = getAttribute(projectOptionDataInfoElement, "optionId");
				String titleAttribute = getAttribute(projectOptionDataInfoElement, "title");
				String descriptionAttribute = getAttribute(projectOptionDataInfoElement, "description");
				ProjectOptionInfo optionInfo = new ProjectOptionInfo();
				optionInfo.setOptionId(idAttribute);
				optionInfo.setTitle(titleAttribute);
				optionInfo.setDescription(descriptionAttribute);
				List<OMElement> groupElements = getChildElements(projectOptionDataInfoElement, "group");
				Map<String, ProjectOptionDataGroup> tmpList = new HashMap<String, ProjectOptionDataGroup>();
				for (OMElement groupElement : groupElements) {
					ProjectOptionDataGroup projectOptionDataGroup = new ProjectOptionDataGroup();
					String groupIDAttr = getAttribute(groupElement, "id");
					String groupTitleAttr = getAttribute(groupElement, "title");
					String parentGroupId = getAttribute(groupElement, "group");
					Map<String, String> controlData = getControlData(groupElement);
					if (controlData.containsKey("type")) {
						projectOptionDataGroup.setCollapsible(controlData.get("type").equals("collapsible"));
					}
					if (controlData.containsKey("state")) {
						projectOptionDataGroup.setExpanded(controlData.get("state").equals("expanded"));
					}
					updateIndentInfo(projectOptionDataGroup, controlData);
					updateMarginInfo(projectOptionDataGroup, controlData);
					projectOptionDataGroup.setId(groupIDAttr);
					projectOptionDataGroup.setTitle(groupTitleAttr);
					projectOptionDataGroup.setParentGroupId(parentGroupId);
					tmpList.put(projectOptionDataGroup.getId(), projectOptionDataGroup);
				}

				for (ProjectOptionDataGroup dataGroup : tmpList.values()) {
					String parentGroupId = dataGroup.getParentGroupId();
					if (parentGroupId == null) {
						optionInfo.getProjectOptionsDataGroup().add(dataGroup);
					} else {
						if (tmpList.containsKey(parentGroupId)) {
							tmpList.get(parentGroupId).getProjectOptionsDataGroup().add(dataGroup);
						} else {
							optionInfo.getProjectOptionsDataGroup().add(dataGroup);
						}
					}
				}

				List<OMElement> dataElements = getChildElements(projectOptionDataInfoElement, "data");
				for (OMElement dataElement : dataElements) {
					ProjectOptionData projectOptionData = new ProjectOptionData();
					String modelPropertyAttr = getAttribute(dataElement, "modelProperty");
					String typeAttr = getAttribute(dataElement, "type");
					String filterAttr = getAttribute(dataElement, "filter");
					String defaultValueAttr = getAttribute(dataElement, "defaultValue");
					String fieldControllerAttr = getAttribute(dataElement, "fieldController");
					AbstractFieldController fieldControllerObj = null;
					if (fieldControllerAttr != null && !fieldControllerAttr.equals("")) {
						fieldControllerObj = (AbstractFieldController) createExecutable(fieldControllerAttr);
					}
					String groupAttr = getAttribute(dataElement, "group");
					String captionAttr = dataElement.getText();
					ProjectOptionDataType type = ProjectOptionDataType.getType(typeAttr);
					switch (type) {
						case CHOICE:
						case DIR:
						case FILE:
						case FILE_DIR:
						case INTEGER:
						case OPTION:
							break;
						case REGISTRY:
						case REGISTRY_TEXT:
							updateSelectedRegistryOptionType(dataElement, projectOptionData);
							break;
						case STRING:
							setupTextControlData(dataElement, projectOptionData);
							break;
						case LIST:
							updateWithTypeListInfo(dataElement, projectOptionData);
							break;
						case LINK:
							updateWithTypeLinkInfo(dataElement, projectOptionData);
							break;
						case LABEL:
						case TITLED_LABEL:
							updateWithTypeLabelInfo(dataElement, projectOptionData);
							break;
						case WORKSPACE:
						case WORKSPACE_FILE:
						case WORKSAPCE_FOLDER:
						case WORKSAPCE_PATH_BROWSER:
							updateWithTypeWorkspaceInfo(dataElement, projectOptionData);
							break;
						case COMPOSITE:
							updateWithCompositeInfo(dataElement, projectOptionData);
							break;
					}
					projectOptionData.setModelProperty(modelPropertyAttr);
					projectOptionData.setType(type);
					projectOptionData.setFilter(filterAttr);
					projectOptionData.setGroup(groupAttr);
					projectOptionData.setCaption(captionAttr);
					projectOptionData.setFieldController(fieldControllerObj);
					projectOptionData.setDefaultValue(defaultValueAttr);
					optionInfo.getProjectOptionsData().add(projectOptionData);
				}
				List<OMElement> projectNaturesElement =
				                                        getChildElements(projectOptionDataInfoElement, "projectNatures");
				if (projectNaturesElement != null && projectNaturesElement.size() > 0) {
					List<OMElement> projectNatureElements = getChildElements(projectNaturesElement.get(0), "nature");
					for (OMElement projectNatureElement : projectNatureElements) {
						optionInfo.getProjectNatures().add(projectNatureElement.getText());
					}
				}
				getProjectOptionInfo().add(optionInfo);
			}
		}

	}

	private void updateWithCompositeInfo(OMElement dataElement, ProjectOptionData projectOptionData)
	                                                                                                throws CoreException {
		Map<String, String> controlData = getControlData(dataElement);
		ICompositeProvider iCompositeProvider = null;
		if (controlData.containsKey("class")) {
			iCompositeProvider = (ICompositeProvider) createExecutable(controlData.get("class"));
		}
		setupCommonControlData(dataElement, projectOptionData);
		projectOptionData.setCompositeProvider(iCompositeProvider);

	}

	private void updateSelectedRegistryOptionType(OMElement dataElement, ProjectOptionData projectOptionData)
	                                                                                                         throws CoreException {
		Map<String, String> controlData = getControlData(dataElement);
		String registyPathBindingProperty = null;
		if (controlData.containsKey("path.binding.property")) {
			registyPathBindingProperty = controlData.get("path.binding.property");
		}

		if (controlData.containsKey("registry.selection.type")) {
			String value = controlData.get("registry.selection.type");
			if (value != null) {
				if (value.equals("collection")) {
					projectOptionData.setRegistyResourceSelectionType(RegistryOptionsConstants.SELECTED_REGISTRY_PATH);
				} else if (value.equals("resource")) {
					projectOptionData.setRegistyResourceSelectionType(RegistryOptionsConstants.SELECTED_REGISTRY_RESOURCE);
				} else if (value.equals("resource+collection")) {
					projectOptionData.setRegistyResourceSelectionType(RegistryOptionsConstants.SELECTED_REGISTRY_RESOURCE |
					                                                  RegistryOptionsConstants.SELECTED_REGISTRY_PATH);
				} else if (value.equals("registy")) {
					projectOptionData.setRegistyResourceSelectionType(RegistryOptionsConstants.SELECTED_REGISTRY);
				}
			}
		} else {
			projectOptionData.setRegistyResourceSelectionType(RegistryOptionsConstants.SELECTED_REGISTRY);
		}
		projectOptionData.setRegistyPathBindingProperty(registyPathBindingProperty);
	}

	private void setupCommonControlData(OMElement dataElement, ProjectOptionData projectOptionData) {
		Map<String, String> controlData = getControlData(dataElement);
		updateIndentInfo(projectOptionData, controlData);
	}

	private void setupTextControlData(OMElement dataElement, ProjectOptionData projectOptionData) {
		Map<String, String> controlData = getControlData(dataElement);
		boolean multiline = false;
		boolean listner = false;
		String textToolTip = null;
		if (controlData.containsKey("multiline")) {
			multiline = controlData.get("multiline").toLowerCase().equals("true");

		}
		if (controlData.containsKey("height")) {
			projectOptionData.setTextboxHeight(Integer.parseInt(controlData.get("height")));
		}
		if (controlData.containsKey("listner")) {
			listner = controlData.get("listner").toLowerCase().equals("true");
		}
		if (controlData.containsKey("toolTip")) {
			textToolTip = controlData.get("toolTip");
		}
		projectOptionData.setAddListnner(listner);
		projectOptionData.setTextMultiline(multiline);
		if (textToolTip != null) {
			projectOptionData.setToolTip(textToolTip);
		}
		setupCommonControlData(dataElement, projectOptionData);
	}

	private void updateMarginInfo(ProjectOptionDataGroup projectOptionDataGroup, Map<String, String> controlData) {
		if (controlData.containsKey("marginH")) {
			projectOptionDataGroup.setMarginHeight(Integer.parseInt(controlData.get("marginH")));
		}
		if (controlData.containsKey("marginW")) {
			projectOptionDataGroup.setMarginWidth(Integer.parseInt(controlData.get("marginW")));
		}
	}

	private void updateWithTypeLinkInfo(OMElement dataElement, ProjectOptionData projectOptionData)
	                                                                                               throws CoreException {
		Map<String, String> controlData = getControlData(dataElement);
		SelectionListener selectionListenerClass = null;
		int horizontalAlignment = SWT.LEFT;
		if (controlData.containsKey("align")) {
			String alignment = controlData.get("align").toLowerCase();
			horizontalAlignment =
			                      alignment.equals("left")
			                                              ? SWT.LEFT
			                                              : alignment.equals("right")
			                                                                         ? SWT.RIGHT
			                                                                         : alignment.equals("center")
			                                                                                                     ? SWT.CENTER
			                                                                                                     : SWT.FILL;
		}
		if (controlData.containsKey("onSelect")) {
			selectionListenerClass = (SelectionListener) createExecutable(controlData.get("onSelect"));
		}
		setupCommonControlData(dataElement, projectOptionData);
		projectOptionData.setLinkClickedListener(selectionListenerClass);
		projectOptionData.setLinkAlignment(horizontalAlignment);
	}

	private void updateWithTypeLabelInfo(OMElement dataElement, ProjectOptionData projectOptionData) {
		int horizontalAlignment = SWT.LEFT;
		Map<String, String> controlData = getControlData(dataElement);
		if (controlData.containsKey("align")) {
			String alignment = controlData.get("align").toLowerCase();
			horizontalAlignment =
			                      alignment.equals("left")
			                                              ? SWT.LEFT
			                                              : alignment.equals("right")
			                                                                         ? SWT.RIGHT
			                                                                         : alignment.equals("center")
			                                                                                                     ? SWT.CENTER
			                                                                                                     : SWT.FILL;
		}
		setupCommonControlData(dataElement, projectOptionData);
		projectOptionData.setLabelAlignment(horizontalAlignment);
	}

	private void updateIndentInfo(ProjectOptionData projectOptionData, Map<String, String> controlData) {
		if (controlData.containsKey("v-indent")) {
			projectOptionData.setVerticalIndent(Integer.parseInt(controlData.get("v-indent")));
		}
		if (controlData.containsKey("h-indent")) {
			projectOptionData.setHorizontalIndent(Integer.parseInt(controlData.get("h-indent")));
		}
	}

	private void updateIndentInfo(ProjectOptionDataGroup projectOptionDataGroup, Map<String, String> controlData) {
		if (controlData.containsKey("v-indent")) {
			projectOptionDataGroup.setVerticalIndent(Integer.parseInt(controlData.get("v-indent")));
		}
		if (controlData.containsKey("h-indent")) {
			projectOptionDataGroup.setHorizontalIndent(Integer.parseInt(controlData.get("h-indent")));
		}
	}

	private void updateWithTypeWorkspaceInfo(OMElement dataElement, ProjectOptionData projectOptionData)
	                                                                                                    throws CoreException {
		Map<String, String> controlData = getControlData(dataElement);
		if (controlData.containsKey("filterClass")) {
			ViewerFilter workspaceFilter = null;
			workspaceFilter = (ViewerFilter) createExecutable(controlData.get("filterClass"));
			projectOptionData.setWorkspaceFilter(workspaceFilter);
		}
		setupCommonControlData(dataElement, projectOptionData);
	}

	private void updateWithTypeListInfo(OMElement dataElement, ProjectOptionData projectOptionData)
	                                                                                               throws CoreException {
		Map<String, String> controlData = getControlData(dataElement);
		AbstractListDataProvider dataProviderClass = null;
		boolean multiSelect = false;
		boolean editable = false;
		boolean selectAllbtn = false;
		if (controlData.containsKey("class")) {
			dataProviderClass = (AbstractListDataProvider) createExecutable(controlData.get("class"));
		}
		if (controlData.containsKey("select")) {
			multiSelect = !controlData.get("select").toLowerCase().equals("single");
		}
		if (controlData.containsKey("modify")) {
			editable = controlData.get("modify").toLowerCase().equals("editable");
		}
		if (controlData.containsKey("selectAllbtn")) {
			selectAllbtn = controlData.get("selectAllbtn").toLowerCase().equals("true");
		}

		setupCommonControlData(dataElement, projectOptionData);
		projectOptionData.setListDataProvider(dataProviderClass);
		projectOptionData.setListEditable(editable);
		projectOptionData.setListMultiSelect(multiSelect);
		projectOptionData.setSelectAllbtn(selectAllbtn);
	}

	@SuppressWarnings("restriction")
	private Object createExecutable(String className) throws CoreException {
		return ((org.eclipse.core.internal.registry.ExtensionRegistry) Platform.getExtensionRegistry()).createExecutableExtension((RegistryContributor) getConfigElement().getContributor(),
		                                                                                                                          className,
		                                                                                                                          null);
	}

	protected String serialize() {
		return null;// throw new NotImplementedException();
	}

	protected String getDefaultName() {
		return null;
	}

	public ProjectOption getProjectOption(String id) {
		for (ProjectOption projectOption : getProjectOptions()) {
			if (projectOption.getId().equals(id)) {
				return projectOption;
			}
		}
		return null;
	}

	public ProjectOptionInfo getProjectOptionInfo(String id) {
		for (ProjectOptionInfo optionInfo : getProjectOptionInfo()) {
			if (optionInfo.getOptionId().equals(id)) {
				return optionInfo;
			}
		}
		return null;
	}

	public List<ProjectOptionInfo> getProjectOptionInfo() {
		if (projectOptionInfo == null) {
			projectOptionInfo = new ArrayList<ProjectOptionInfo>();
		}
		return projectOptionInfo;
	}

	public void setConfigElement(IConfigurationElement configElement) {
		this.configElement = configElement;
	}

	public IConfigurationElement getConfigElement() {
		return configElement;
	}
}
