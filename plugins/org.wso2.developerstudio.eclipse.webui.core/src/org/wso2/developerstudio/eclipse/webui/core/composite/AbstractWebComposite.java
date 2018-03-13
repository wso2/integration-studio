package org.wso2.developerstudio.eclipse.webui.core.composite;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.webui.core.WebUICorePlugin;

public abstract class AbstractWebComposite extends Composite {

	protected Browser browser;
	
	protected static IDeveloperStudioLog log = Logger
			.getLog(WebUICorePlugin.PLUGIN_ID);

	public AbstractWebComposite(Composite parent, int style) {
		super(parent, style);
	}

}
