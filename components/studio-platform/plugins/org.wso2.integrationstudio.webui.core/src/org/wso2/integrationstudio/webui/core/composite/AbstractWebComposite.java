package org.wso2.integrationstudio.webui.core.composite;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.webui.core.WebUICorePlugin;

public abstract class AbstractWebComposite extends Composite {

	protected Browser browser;
	
	protected static IIntegrationStudioLog log = Logger
			.getLog(WebUICorePlugin.PLUGIN_ID);

	public AbstractWebComposite(Composite parent, int style) {
		super(parent, style);
	}

}
