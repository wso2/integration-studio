package org.wso2.developerstudio.eclipse.templates.dashboard.handlers;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;

public class DocumentationViewerHandler extends AbstractHandler {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String WSO2_EI_DOCUMENTATION = "https://ei.docs.wso2.com/en/latest/micro-integrator/develop/WSO2-Integration-Studio/";

    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(WSO2_EI_DOCUMENTATION));
        } catch (PartInitException | MalformedURLException e) {
            log.error("Could not load the WSO2 Documentation.", e);
        }
        return true;
    }

}
