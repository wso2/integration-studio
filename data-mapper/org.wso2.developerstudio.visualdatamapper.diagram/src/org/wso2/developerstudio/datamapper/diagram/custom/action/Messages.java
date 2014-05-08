/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.datamapper.diagram.custom.action;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.datamapper.diagram.custom.action.messages"; //$NON-NLS-1$
	public static String CreateNewConfigurationDialog_DefaultConfigName;
	public static String CreateNewConfigurationDialog_DialogHeaderLoadingCAppProjects;
	public static String CreateNewConfigurationDialog_DialogHeaderResourceCreation;
	public static String CreateNewConfigurationDialog_DialogHeaderTemplateCreation;
	public static String CreateNewConfigurationDialog_DialogMessage;
	public static String CreateNewConfigurationDialog_LinkCreateNewProject;
	public static String CreateNewConfigurationDialog_TxtFileName;
	public static String CreateNewConfigurationDialog_TxtProject;
	public static String CreateNewConfigurationDialog_TxtRegistryPath;
	public static String DataMapperConfigurationDialog_Configuration;
	public static String DataMapperConfigurationDialog_ConfigurationName;
	public static String DataMapperConfigurationDialog_CreateNewConfiguration;
	public static String DataMapperConfigurationDialog_CreateNewProject;
	public static String DataMapperConfigurationDialog_DefaultConfigName;
	public static String DataMapperConfigurationDialog_DialogHeaderResourceCreation;
	public static String DataMapperConfigurationDialog_DialogHeaderTemplateCreation;
	public static String DataMapperConfigurationDialog_DialogMessage;
	public static String DataMapperConfigurationDialog_DialogTitle;
	public static String DataMapperConfigurationDialog_ErrorLoadingCAppProjects;
	public static String DataMapperConfigurationDialog_MsgLoadingCAppProjects;
	public static String DataMapperConfigurationDialog_SaveInProject;
	public static String DataMapperConfigurationDialog_UseExisting;
	public static String GENERAL_PROJECT_NATURE;
	public static String LoadInputSchemaAction_EmptySelection;
	public static String LoadInputSchemaAction_InputSchemaDialog;
	public static String LoadInputSchemaAction_LoadFromFile;
	public static String LoadInputSchemaAction_SchemaTypeInput;
	public static String LoadOutputSchemaAction_EmptySelection;
	public static String LoadOutputSchemaAction_LoadOutputSchemaFromFile;
	public static String LoadOutputSchemaAction_OutputSchemaDialog;
	public static String LoadOutputSchemaAction_SchemaTypeOutput;
	public static String SchemaFromJsonAction_errorReadingJsonFromFile;
	public static String SchemaFromJsonAction_menuTitle;
	public static String SchemaFromJsonAction_sampleJsonFile;
	public static String SchemaKeyEditorDialog_EmbeddedResources;
	public static String SchemaKeyEditorDialog_ErrorMsgHeader;
	public static String SchemaKeyEditorDialog_ErrorOpeningFile;
	public static String SchemaKeyEditorDialog_ErrorRegistryBrowser;
	public static String SchemaKeyEditorDialog_ErrorRegistryURL;
	public static String SchemaKeyEditorDialog_InputSchemaFile;
	public static String SchemaKeyEditorDialog_NewResource;
	public static String SchemaKeyEditorDialog_ReasonOpeningFile;
	public static String SchemaKeyEditorDialog_ReasonRegistryBrowser;
	public static String SchemaKeyEditorDialog_ReasonRegistryURL;
	public static String SchemaKeyEditorDialog_RegistryBrowser;
	public static String SchemaKeyEditorDialog_ResourceKey;
	public static String SchemaKeyEditorDialog_SchemaKeyEditorDialogMessage;
	public static String SchemaKeyEditorDialog_SelectRegistryResource;
	public static String SchemaKeyEditorDialog_WorkspaceElementProviders;
	public static String Configure_Split_Operator_Action_Id;
	public static String Add_Remove_Split_Branches;
	public static String Configure_Split_Operator;
	public static String Configure_Concat_Operator_Action_Id;
	public static String Add_Remove_Concat_Branches;
	public static String AddNewFieldAction_addNewField;
	public static String AddNewRecordAction_addNewRecord;
	public static String AddNewRecordsListAction_addNewRecordsList;
	public static String AddNewRootRecordAction_addNewRoot;
	public static String AddNewRootRecordAction_errorAddChild;
	public static String AddNewRootRecordAction_errorHeader;
	public static String Configure_Concat_Operator;
	
	public static String ExportSchemaAction_errorSavingFile;
	public static String ExportSchemaAction_errorWrongEdipart;
	public static String ExportSchemaAction_fileDialogHeader;
	public static String ExportSchemaAction_menuTitle;
	public static String ExportSchemaAction_warnNotSavedToFile;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
