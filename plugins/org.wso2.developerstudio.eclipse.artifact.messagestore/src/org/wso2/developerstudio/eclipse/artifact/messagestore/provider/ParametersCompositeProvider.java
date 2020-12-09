/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messagestore.provider;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.artifact.messagestore.ui.wizard.CustomParametersComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.ICompositeProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;

public class ParametersCompositeProvider implements ICompositeProvider  {


	public AbstractComposite createComposite(Composite parent,
			ProjectDataModel model, ProjectOptionData optionData,
			WizardPage wizardPage) {
		return new CustomParametersComposite(parent, SWT.None,model,optionData,wizardPage);
	}

}
