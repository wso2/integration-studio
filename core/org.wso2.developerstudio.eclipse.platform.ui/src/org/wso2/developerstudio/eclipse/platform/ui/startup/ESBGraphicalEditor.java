package org.wso2.developerstudio.eclipse.platform.ui.startup;

import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;

public class ESBGraphicalEditor {

	private static Openable openable;

	public static void setOpenable(Openable openable) {
		ESBGraphicalEditor.openable = openable;
	}

	public static Openable getOpenable() {
		return openable;
	}
	
}
