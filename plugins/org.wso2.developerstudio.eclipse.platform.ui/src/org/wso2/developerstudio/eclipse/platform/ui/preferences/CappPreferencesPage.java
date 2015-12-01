package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class CappPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {


       public static final String CUSTOM_SERVER_ROLES = "CUSTOM_SERVER_ROLES";
       public static final String PREFERENCES_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";
       private IPreferenceStore preferenceStore;

       public CappPreferencesPage() {
               super(GRID);
       }

       public void createFieldEditors() {

               addField(new StringFieldEditor(CUSTOM_SERVER_ROLES, "Custom server role:", getFieldEditorParent()));
       }

       /* (non-Javadoc)
        * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
        */

       @Override
       public void init(IWorkbench arg0) {
               preferenceStore = Activator.getDefault().getPreferenceStore();
               setPreferenceStore(preferenceStore);
               setDescription("WSO2 Developer Studio Custom Capp Preference.");
       }

}
