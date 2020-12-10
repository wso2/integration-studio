package org.wso2.integrationstudio.datamapper.diagram.custom.startup;

import org.eclipse.ui.IStartup;
import org.wso2.integrationstudio.datamapper.diagram.custom.util.DataMapperEditorStartupUtils;
import org.wso2.integrationstudio.eclipse.platform.ui.startup.DataMapperEditor;

public class DataMapperEditorStartup implements IStartup{

	public void earlyStartup() {
		DataMapperEditorStartupUtils editorStartupUtils = new DataMapperEditorStartupUtils();
		DataMapperEditor.setOpenable(editorStartupUtils);
	}
}
