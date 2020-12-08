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

package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

public class CappPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {


       public static final String CUSTOM_SERVER_ROLES = "CUSTOM_SERVER_ROLES";
       public static final String PREFERENCES_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";
       private IPreferenceStore preferenceStore;

       public CappPreferencesPage() {
               super(GRID);
       }

       public void createFieldEditors() {

               addField(new StringFieldEditor(CUSTOM_SERVER_ROLES, "Custom Server Roles:", getFieldEditorParent()));
       }

       /* (non-Javadoc)
        * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
        */

       @Override
       public void init(IWorkbench arg0) {
               preferenceStore = PlatformUI.getPreferenceStore();
               setPreferenceStore(preferenceStore);
               setDescription("WSO2 Developer Studio Custom Capp Preference.");
       }

}
