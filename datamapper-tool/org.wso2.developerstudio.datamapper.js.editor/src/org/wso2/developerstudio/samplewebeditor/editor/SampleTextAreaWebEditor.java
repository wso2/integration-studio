/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.samplewebeditor.editor;

import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;

public class SampleTextAreaWebEditor extends AbstractWebBasedEditor{

	public SampleTextAreaWebEditor() {
		super();
	}
	public SampleTextAreaWebEditor(MultiPageEditorPart multiPageEditor) {
		super(multiPageEditor);
	}

	/**
	 * IMPORATNT: Return the exact unique app ID you passed to extension point while adding webapp
	 * to embedded tomcat in plugin.xml.
	 * When loading the editor, Web editor framework will talk to embedded tomcat to 
	 * get the URL for this app by passing the unique ID of the app.
	 * Hence, if it can't find an app with this ID, editor will not be initialized and will
	 * throw an AppNotFoundException
	 */
	@Override
	public String getWebAppID() {
		return "DatamapperEditorApp";
	}

	
	@Override
	public String getEditorName() {
		return "Datamapper Editor";
	}

	@Override
	public String getEditorTitleToolTip() {
		return "Datamapper Editor";
	}

}