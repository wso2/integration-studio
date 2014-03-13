package dataMapper.diagram.custom.startup;

import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.platform.ui.startup.DataMapperEditor;

import dataMapper.diagram.custom.util.DataMapperEditorStartupUtils;

public class DataMapperEditorStartup implements IStartup{

	public void earlyStartup() {
		DataMapperEditorStartupUtils editorStartupUtils = new DataMapperEditorStartupUtils();
		DataMapperEditor.setOpenable(editorStartupUtils);
	}
}
