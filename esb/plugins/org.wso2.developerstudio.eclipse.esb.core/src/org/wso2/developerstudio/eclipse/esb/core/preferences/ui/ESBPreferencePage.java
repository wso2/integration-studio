/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.esb.core.preferences.ui;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.core.preferences.*;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.esb.core.utils.EsbVersionUtils;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseUtils;

public class ESBPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public ESBPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Enterprise Service Bus Tools Settings");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		/*
		 * String[][] namespaceComboData = getSynapseNamespaceComboData();
		 * addField(new ComboFieldEditor(PreferenceConstants.PREF_NAMESPACE,
		 * "Default namespace",namespaceComboData, getFieldEditorParent()));
		 */

		String[][] esbVersionComboData = getEsbVersionComboData();
		addField(new ComboFieldEditor(PreferenceConstants.PREF_ESBVERSION,
				"Esb Version", esbVersionComboData, getFieldEditorParent()));

	}

//	private String[][] getSynapseNamespaceComboData() {
//		String[] synapseNamespaces = SynapseUtils.getSynapseNamespaces();
//		String[][] namespaceComboData = new String[synapseNamespaces.length][2];
//		int i = 0;
//		for (String namespace : synapseNamespaces) {
//			namespaceComboData[i][0] = namespace;
//			namespaceComboData[i][1] = namespace;
//			i++;
//		}
//		return namespaceComboData;
//	}

	private String[][] getEsbVersionComboData() {
		String[] esbVersions = EsbVersionUtils.getEsbVersions();
		String[][] esbVersionComboData = new String[esbVersions.length][2];
		int i = 0;
		for (String version : esbVersions) {
			esbVersionComboData[i][0] = version;
			esbVersionComboData[i][1] = version;
			i++;
		}
		return esbVersionComboData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}