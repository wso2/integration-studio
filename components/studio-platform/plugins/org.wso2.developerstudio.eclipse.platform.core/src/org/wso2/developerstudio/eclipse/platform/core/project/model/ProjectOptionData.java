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

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.ICompositeProvider;

public class ProjectOptionData {
	private String modelProperty;
	private String caption;
	private String filter;
	private String group;
	private AbstractFieldController fieldController;
	private ProjectOptionDataType type;
	private String defaultValue;

	// indent information
	private Integer verticalIndent;
	private Integer horizontalIndent;

	// For lists
	private boolean listMultiSelect = false;
	private boolean listEditable = false;
	private boolean selectAllbtn = false;
	private AbstractListDataProvider listDataProvider;

	// For links
	private int linkAlignment = SWT.LEFT;
	private SelectionListener linkClickedListener;

	// For workspace
	private ViewerFilter workspaceFilter;

	// For labels
	private int labelAlignment = SWT.LEFT;

	// For registry
	private int registyResourceSelectionType;
	private String registyPathBindingProperty;

	// for textboxes
	private boolean textMultiline;
	private boolean addListnner;
	private String toolTip;
	private int height = 0;

	// for composite
	private ICompositeProvider iCompositeProvider;

	public String getModelProperty() {
		return modelProperty;
	}

	public void setModelProperty(String modelProperty) {
		this.modelProperty = modelProperty;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public AbstractFieldController getFieldController() {
		return fieldController;
	}

	public void setFieldController(AbstractFieldController fieldController) {
		this.fieldController = fieldController;
	}

	public ProjectOptionDataType getType() {
		return type;
	}

	public void setType(ProjectOptionDataType type) {
		this.type = type;
	}

	public void setListMultiSelect(boolean listMultiSelect) {
		this.listMultiSelect = listMultiSelect;
	}

	public boolean isListMultiSelect() {
		return listMultiSelect;
	}

	public void setListEditable(boolean listEditable) {
		this.listEditable = listEditable;
	}

	public boolean isListEditable() {
		return listEditable;
	}

	public void setSelectAllbtn(boolean selectAllbtn) {
		this.selectAllbtn = selectAllbtn;
	}

	public boolean isSelectAllbtn() {
		return selectAllbtn;
	}

	public void setTextMultiline(boolean textMultiline) {
		this.textMultiline = textMultiline;
	}

	public void setTextboxHeight(int height) {
		this.height = height;
	}

	public void setAddListnner(boolean addListnner) {
		this.addListnner = addListnner;
	}

	public boolean isAddListnner() {
		return addListnner;
	}

	public boolean isTextMultiline() {
		return textMultiline;
	}

	public void setListDataProvider(AbstractListDataProvider listDataProvider) {
		this.listDataProvider = listDataProvider;
	}

	public void setCompositeProvider(ICompositeProvider iCompositeProvider) {
		this.iCompositeProvider = iCompositeProvider;
	}

	public ICompositeProvider getCompositeProvider() {
		return iCompositeProvider;
	}

	public AbstractListDataProvider getListDataProvider() {
		return listDataProvider;
	}

	public void setLinkClickedListener(SelectionListener linkClickedListener) {
		this.linkClickedListener = linkClickedListener;
	}

	public SelectionListener getLinkClickedListener() {
		return linkClickedListener;
	}

	public void setLinkAlignment(int linkAlignment) {
		this.linkAlignment = linkAlignment;
	}

	public int getLinkAlignment() {
		return linkAlignment;
	}

	public void setWorkspaceFilter(ViewerFilter workspaceFilter) {
		this.workspaceFilter = workspaceFilter;
	}

	public ViewerFilter getWorkspaceFilter() {
		return workspaceFilter;
	}

	public void setLabelAlignment(int labelAlignment) {
		this.labelAlignment = labelAlignment;
	}

	public int getLabelAlignment() {
		return labelAlignment;
	}

	public void setVerticalIndent(Integer verticalIndent) {
		this.verticalIndent = verticalIndent;
	}

	public Integer getVerticalIndent() {
		return verticalIndent;
	}

	public void setHorizontalIndent(Integer horizontalIndent) {
		this.horizontalIndent = horizontalIndent;
	}

	public Integer getHorizontalIndent() {
		return horizontalIndent;
	}

	/**
	 * registry options
	 * public static final int SELECTED_NONE = 1;
	 * public static final int SELECTED_REGISTRY = 2;
	 * public static final int SELECTED_REGISTRY_PATH = 4;
	 * public static final int SELECTED_REGISTRY_RESOURCE = 8;
	 */
	public void setRegistyResourceSelectionType(int registyResourceSelectionType) {
		this.registyResourceSelectionType = registyResourceSelectionType;
	}

	public int getRegistyResourceSelectionType() {
		return registyResourceSelectionType;
	}

	public void setRegistyPathBindingProperty(String registyPathBindingProperty) {
		this.registyPathBindingProperty = registyPathBindingProperty;
	}

	public String getRegistyPathBindingProperty() {
		return registyPathBindingProperty;
	}

	/**
	 * @param toolTip
	 *            the toolTip to set
	 */
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	/**
	 * @return the toolTip
	 */
	public String getToolTip() {
		return toolTip;
	}

	public int getTextboxHeight() {
		return height;
	}

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
