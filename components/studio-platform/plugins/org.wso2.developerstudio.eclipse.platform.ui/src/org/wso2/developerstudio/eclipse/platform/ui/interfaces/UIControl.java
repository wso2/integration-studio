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

package org.wso2.developerstudio.eclipse.platform.ui.interfaces;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public interface UIControl {

	/**
	 * 
	 * @param container
	 * @param columns
	 * @param verticalIndent
	 * @param horizontalIndent
	 * @param isTextReadonly
	 * @param shell
	 * @param label
	 * @param filter
	 * @param fileButtonCaption
	 * @param selectedOption
	 *            public static final int SELECTED_NONE = 1;
	 *            public static final int SELECTED_REGISTRY = 2;
	 *            public static final int SELECTED_REGISTRY_PATH = 4;
	 *            public static final int SELECTED_REGISTRY_RESOURCE = 8;
	 * @param model
	 * @param pathBindingProperty
	 * @return
	 */
	public IFieldControlData createUIField(String id, Composite container, int columns, Integer verticalIndent,
	                                       Integer horizontalIndent, boolean isTextReadonly, final Shell shell,
	                                       final String label, String fileButtonCaption, int selectedOption,
	                                       ProjectDataModel model, String pathBindingProperty);

	public IFieldControlData addRegistryBrowseButton(Composite container, Shell shell, String label,
	                                                 String buttonCaption, Text txtValue, int selectedOption,
	                                                 ProjectDataModel model, String pathBindingProperty);
}
