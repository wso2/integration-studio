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

package org.wso2.developerstudio.eclipse.platform.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String KERNEL_SAMPLES_GIT = "https://github.com/wso2/tooling-templates.git";
	public static final String PREFERENCES_PLUGIN_ID = "org.wso2.developerstudio.eclipse.platform.ui";

	public static final String DEFAULT_RELEASE_SITE = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.0.0/releases/";
	public static final String DEFAULT_UPDATE_SITE = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.0.0/updates/";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */

	public void initializeDefaultPreferences() {

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(UpdateCheckerPreferencePage.PLUGIN_TEMPLATE_URL,
				KERNEL_SAMPLES_GIT);
		store.setDefault(UpdateCheckerPreferencePage.RELESE_SITE_URL,
				DEFAULT_RELEASE_SITE);
		store.setDefault(UpdateCheckerPreferencePage.UPDATE_SITE_URL,
				DEFAULT_UPDATE_SITE);
		store.setDefault(UpdateCheckerPreferencePage.UPDATE_INTAVAL, "Weekly");
		store.setDefault(UpdateCheckerPreferencePage.ENABLE_AUTOMATIC_UPDATES,
				true);
		store.setDefault(UpdateCheckerPreferencePage.SHOW_HIDDEN_FEATURES,
				false);
	}

}
