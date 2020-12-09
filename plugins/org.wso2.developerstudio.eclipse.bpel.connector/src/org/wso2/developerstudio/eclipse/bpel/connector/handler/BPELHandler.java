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

package org.wso2.developerstudio.eclipse.bpel.connector.handler;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.developerstudio.eclipse.bpel.core.handler.IBPELHandler;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.bpel.connector.utils.BPELConnectorUtils;

public class BPELHandler implements IBPELHandler{
	
	public IProject createNewBPELProject(Shell shell){
		return BPELConnectorUtils.createNewBPELProject(shell);
	}
	
	public List<IProject> getBPELWorkflowProjects(){
		return BPELConnectorUtils.getBPELWorkflowProjects();
	}
	
	public File createArchive(File location) throws Exception{
		return BPELConnectorUtils.createArchive(location);
	}
	
	
}
