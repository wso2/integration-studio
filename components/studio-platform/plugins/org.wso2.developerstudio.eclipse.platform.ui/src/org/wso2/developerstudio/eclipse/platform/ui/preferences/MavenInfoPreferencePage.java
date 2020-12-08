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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.controls.LabelFieldEditor;

public class MavenInfoPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final String UPDATE_POLICY_LABEL = "Update Policy";
	private static final String CHECKSUM_POLICY_LABEL = "Checksum Policy";
	private static final String EXCLUDE_WSO2_REPOSITORY_LABEL = "Disable WSO2 Maven Repository";
	private static final String DISABLE_WSO2_REPOSITORY = "DISABLE_WSO2_REPOSITORY";
	private static final String SNAPSHOTS_UPDATE_POLICY = "SNAPSHOTS_UPDATE_POLICY";
	private static final String SNAPSHOTS_CHECKSUM_POLICY = "SNAPSHOTS_CHECKSUM_POLICY";
	private static final String SNAPSHOTS_ENABLED = "SNAPSHOTS_ENABLED";
	private static final String RELEASES_UPDATE_POLICY = "RELEASES_UPDATE_POLICY";
	private static final String RELEASES_CHECKSUM_POLICY = "RELEASES_CHECKSUM_POLICY";
	private static final String RELEASES_ENABLED = "RELEASES_ENABLED";
	private static final String GLOBAL_REPOSITORY_ID = "GLOBAL_REPOSITORY_ID";
	private static final String GLOBAL_REPOSITORY_URL = "GLOBAL_REPOSITORY_URL";
	private static final String GLOBAL_PARENT_MAVEN_VERSION = "GLOBAL_MAVEN_VERSION";
	private static final String GLOBAL_PARENT_MAVEN_ARTIFACTID = "GLOBAL_MAVEN_ARTIFACTID";
	private static final String GLOBAL_PARENT_MAVEN_GROUP_ID = "GLOBAL_MAVEN_GROUPID";
	private static final String GLOBAL_MAVEN_VERSION = "MAVEN_VERSION";
	private static final String GLOBAL_MAVEN_GROUP_ID = "MAVEN_GROUPID";
	private IPreferenceStore preferenceStore;

	public MavenInfoPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench arg0) {
		preferenceStore = PlatformUI.getPreferenceStore();
		setPreferenceStore(preferenceStore);
		setDescription("WSO2 Developer Studio Maven Information Preferences.");
	}

	@Override
	protected void createFieldEditors() {
		addEmptyField();

		addField(new LabelFieldEditor("Custom Maven Parent Information", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_PARENT_MAVEN_GROUP_ID, "Custom Parent GroupId", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_PARENT_MAVEN_ARTIFACTID, "Custom Parent ArtifactId",
		                               getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_PARENT_MAVEN_VERSION, "Custom Parent Version", getFieldEditorParent()));

		addEmptyField();

		addField(new LabelFieldEditor("Custom Global Maven Information", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_MAVEN_GROUP_ID, "Custom GroupId", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_MAVEN_VERSION, "Custom Version", getFieldEditorParent()));

		addEmptyField();

		addField(new LabelFieldEditor("Enable/Disable WSO2 Maven Repository", getFieldEditorParent()));
		
		addField(new BooleanFieldEditor(DISABLE_WSO2_REPOSITORY, EXCLUDE_WSO2_REPOSITORY_LABEL, getFieldEditorParent()));
		
		addEmptyField();

		addField(new LabelFieldEditor("Custom Maven Repository Information", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_REPOSITORY_URL, "Custom Repository URL", getFieldEditorParent()));

		addField(new StringFieldEditor(GLOBAL_REPOSITORY_ID, "Custom Repository ID", getFieldEditorParent()));

		addEmptyField();
		
		addField(new LabelFieldEditor("Releases", getFieldEditorParent()));

		addField(new BooleanFieldEditor(RELEASES_ENABLED, "Enabled", getFieldEditorParent()));

		String[][] a = { { "Ignore", "Ignore" }, { "fail", "fail" }, { "warn", "warn" } };

		addField(new ComboFieldEditor(RELEASES_CHECKSUM_POLICY, CHECKSUM_POLICY_LABEL, a, getFieldEditorParent()));

		String[][] b = { { "always", "always" }, { "daily", "daily" }, { "never", "never" } };

		addField(new ComboFieldEditor(RELEASES_UPDATE_POLICY, UPDATE_POLICY_LABEL, b, getFieldEditorParent()));

		addEmptyField();
		
		addField(new LabelFieldEditor("Snapshots", getFieldEditorParent()));

		addField(new BooleanFieldEditor(SNAPSHOTS_ENABLED, "Enabled", getFieldEditorParent()));

		addField(new ComboFieldEditor(SNAPSHOTS_CHECKSUM_POLICY, CHECKSUM_POLICY_LABEL, a, getFieldEditorParent()));

		addField(new ComboFieldEditor(SNAPSHOTS_UPDATE_POLICY, UPDATE_POLICY_LABEL, b, getFieldEditorParent()));

	}

	private void addEmptyField() {
		addField(new LabelFieldEditor("", getFieldEditorParent()));
	}

}
