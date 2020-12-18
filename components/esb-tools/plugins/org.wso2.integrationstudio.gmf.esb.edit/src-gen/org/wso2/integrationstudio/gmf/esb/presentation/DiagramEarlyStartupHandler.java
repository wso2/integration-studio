package org.wso2.integrationstudio.gmf.esb.presentation;

import org.eclipse.ui.IStartup;
import org.wso2.integrationstudio.gmf.esb.presentation.EEFPropertyViewUtil;

public class DiagramEarlyStartupHandler implements IStartup {

    @Override
    public void earlyStartup() {
        EEFPropertyViewUtil.loadConnectorSchemas();
    }

}
