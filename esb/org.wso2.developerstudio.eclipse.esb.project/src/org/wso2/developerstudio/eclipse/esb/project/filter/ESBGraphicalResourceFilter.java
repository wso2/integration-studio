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

package org.wso2.developerstudio.eclipse.esb.project.filter;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

/**
 * Viewer filter to hide ESB graphical resource files
 *
 */
public class ESBGraphicalResourceFilter extends ViewerFilter {
	private static final String GRAPHICAL_SYNAPSE_PATH = "src/main/graphical-synapse-config";
	/*FIXME: Remove hard-coded paths*/

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IFolder) {
			try {
				IFolder folder = (IFolder) element;
				if (folder.getProject().hasNature(Constants.ESB_PROJECT_NATURE)) {
					if (folder.getProjectRelativePath().toString()
							.startsWith(GRAPHICAL_SYNAPSE_PATH)) {
						return false;
					}
				}
			} catch (Exception e) {/* ignore */
			}
		}
		return true;
	}

}
