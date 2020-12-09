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
package org.wso2.developerstudio.datamapper.diagram.custom.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractConfigureOperatorDialog extends TitleAreaDialog{

	GridData dataPropertyConfigText;
	
	public AbstractConfigureOperatorDialog(Shell parentShell) {
		super(parentShell);
		init();
	}
	
	protected void init(){
		dataPropertyConfigText = new GridData();
		dataPropertyConfigText.grabExcessHorizontalSpace = true;
		dataPropertyConfigText.horizontalAlignment = GridData.FILL;
	}

}
