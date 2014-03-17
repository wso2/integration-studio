package org.wso2.developerstudio.eclipse.platform.ui.startup;

import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;

public class DataMapperEditor {
	private static Openable openable;

	public static void setOpenable(Openable openable) {
		DataMapperEditor.openable = openable;
	}

	public static Openable getOpenable() {
		return openable;
	}
}
