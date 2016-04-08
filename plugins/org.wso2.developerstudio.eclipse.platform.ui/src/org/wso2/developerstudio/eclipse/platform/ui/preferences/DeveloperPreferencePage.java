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

package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.platform.ui.WorkbenchToolkit;

public class DeveloperPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String PLUGIN_TEMPLATE_URL = "PLUGIN_TEMPLATE_URL";
	public static final String SHOW_HIDDEN_FEATURES = "SHOW_HIDDEN_FEATURES";    
	public static final String PREFERENCES_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";
    private IPreferenceStore preferenceStore;

    public DeveloperPreferencePage() {
            super(GRID);
    }

    public void createFieldEditors() {
		addField(new StringFieldEditor(PLUGIN_TEMPLATE_URL, "Plug-in template location:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(SHOW_HIDDEN_FEATURES, "Show hidden features (for plugin developers)",
				getFieldEditorParent()));
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */

    @Override
    public void init(IWorkbench arg0) {
            preferenceStore = WorkbenchToolkit.getPreferenceStore();
            setPreferenceStore(preferenceStore);
        	preferenceStore.setDefault(PLUGIN_TEMPLATE_URL, PreferenceInitializer.KERNEL_SAMPLES_GIT);
        	preferenceStore.setDefault(SHOW_HIDDEN_FEATURES, false);
            setDescription("WSO2 Developer Studio Custom Capp Preference.");
    }

}