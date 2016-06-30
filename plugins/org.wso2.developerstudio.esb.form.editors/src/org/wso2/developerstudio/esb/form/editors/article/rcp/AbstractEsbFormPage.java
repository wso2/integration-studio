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

import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;

public abstract class AbstractEsbFormPage extends FormPage {

	protected EsbNode esbNode;
	
	
	
	public AbstractEsbFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	public EsbNode getEsbNode() {
		return esbNode;
	}

	public void setEsbNode(EsbNode esbNode) {
		this.esbNode = esbNode;
	}

}
