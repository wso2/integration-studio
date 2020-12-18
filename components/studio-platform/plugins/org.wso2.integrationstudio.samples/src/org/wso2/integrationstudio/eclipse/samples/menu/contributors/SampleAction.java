/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.samples.menu.contributors;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.samples.Activator;
import org.wso2.integrationstudio.samples.contributor.IIntegrationStudioSampleContributor;
import org.wso2.integrationstudio.utils.data.ITemporaryFileTag;
import org.wso2.integrationstudio.utils.file.FileUtils;

public abstract class SampleAction extends Action {
	private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private IIntegrationStudioSampleContributor contributor;
	private Shell shell;
	
	public SampleAction(Shell shell,IIntegrationStudioSampleContributor contributor) {
		super(contributor.getCaption(),contributor.getImage());
		setToolTipText(contributor.getToolTip());
		setContributor(contributor);
		setShell(shell);
    }

	public void setContributor(IIntegrationStudioSampleContributor contributor) {
	    this.contributor = contributor;
    }

	public IIntegrationStudioSampleContributor getContributor() {
	    return contributor;
    }
	
	public void run() {
		ITemporaryFileTag tempTag = FileUtils.createNewTempTag();
	    if (getContributor().isCustomCreateSample()){
	    	try {
	            getContributor().createSample(getShell());
            } catch (Exception e) {
	            log.error(e);
            }
	    }else{
	    	execute();
	    }
	    tempTag.clearAndEnd();
	}
	
	public abstract void execute();

	public void setShell(Shell shell) {
	    this.shell = shell;
    }

	public Shell getShell() {
	    return shell;
    }
}
