package org.wso2.integrationstudio.templates.dashboard.handlers;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.templates.dashboard.Activator;

public class DocumentationViewerHandler extends AbstractHandler {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String WSO2_EI_DOCUMENTATION = "https://apim.docs.wso2.com/en/latest/integrate/develop/wso2-integration-studio/";

    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(WSO2_EI_DOCUMENTATION));
        } catch (PartInitException | MalformedURLException e) {
            log.error("Could not load the WSO2 Documentation.", e);
        }
        return true;
    }

}
