package org.wso2.developerstudio.eclipse.webui.core.window.function;

import org.wso2.developerstudio.eclipse.webui.core.window.WebWindow;

public class ResizeWindowFunction extends AbstractWebWindowFunction  {

	public ResizeWindowFunction(WebWindow window) {
		super(window, FunctionNames.RESIZE_SHELL_CALLBACK);
	}
	
	@Override
	public Object function(Object[] arguments) {
		int width = Integer.parseInt((String) arguments[0]);
		int height = Integer.parseInt((String) arguments[1]);
		webWindow.getShell().layout(true);
		webWindow.getShell().setSize(width, height);
		webWindow.getShell().redraw();
		return Boolean.TRUE.toString();
	}

}
