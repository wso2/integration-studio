/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver.base.internal;

import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.ui.internal.GenericServerRuntimeWizardFragment;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.TaskModel;

@SuppressWarnings("restriction")
public class CarbonRuntimeWizardFragment extends GenericServerRuntimeWizardFragment {

	public IRuntimeWorkingCopy runtime;

	public boolean isComplete() {
		runtime = (IRuntimeWorkingCopy) getTaskModel().getObject(TaskModel.TASK_RUNTIME);

		if (runtime != null) {
			GenericServerRuntime gRuntime =
			                                (GenericServerRuntime) runtime.loadAdapter(GenericServerRuntime.class,
			                                                                           new NullProgressMonitor());

			Map properties = gRuntime.getServerInstanceProperties();
			String serverName = (String) properties.get("server.name");
			if (serverName != null) {
				runtime.setName(serverName);
			}
		}
		return super.isComplete();
	}
}
