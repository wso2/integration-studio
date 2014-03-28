package dataMapper.diagram.custom.action;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "dataMapper.diagram.custom.action.messages"; //$NON-NLS-1$
	public static String LoadInputSchemaAction_EmptySelection;
	public static String LoadInputSchemaAction_InputSchemaDialog;
	public static String LoadInputSchemaAction_LoadFromFile;
	public static String LoadInputSchemaAction_SchemaTypeInput;
	public static String LoadOutputSchemaAction_EmptySelection;
	public static String LoadOutputSchemaAction_LoadOutputSchemaFromFile;
	public static String LoadOutputSchemaAction_OutputSchemaDialog;
	public static String LoadOutputSchemaAction_SchemaTypeOutput;
	public static String SchemaKeyEditorDialog_EmbeddedResources;
	public static String SchemaKeyEditorDialog_ErrorMsgHeader;
	public static String SchemaKeyEditorDialog_ErrorOpeningFile;
	public static String SchemaKeyEditorDialog_ErrorRegistryBrowser;
	public static String SchemaKeyEditorDialog_ErrorRegistryURL;
	public static String SchemaKeyEditorDialog_InputSchemaFile;
	public static String SchemaKeyEditorDialog_NewResource;
	public static String SchemaKeyEditorDialog_RegistryBrowser;
	public static String SchemaKeyEditorDialog_ResourceKey;
	public static String SchemaKeyEditorDialog_SchemaKeyEditorDialogMessage;
	public static String SchemaKeyEditorDialog_SelectRegistryResource;
	public static String SchemaKeyEditorDialog_WorkspaceElementProviders;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
