package org.wso2.developerstudio.humantaskeditor.editors;

import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;

public class EditorContentFunction implements AbstractEditorFunctionExecutor {
	private static String text;

	@Override
	public Object executeFunction(String functionName, Object[] parameters) {
		if (functionName.equals("settext")) {
			EditorContentFunction.setText((String) parameters[1]);
			return null;
		} else if (functionName.equals("gettext")) {
			return EditorContentFunction.getText();
		} else
			return null;

	}

	public static String getText() {
		return text;
	}

	public static void setText(String text) {
		EditorContentFunction.text = text;
	}

}
