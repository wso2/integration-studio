/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.project.refactor;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

/***
 * This class is used to test whether the selected project is a WSO2 project or
 * not.
 * Currently we test only based on maven pom file.
 * But we need to extend this to check for a common Eclipse project nature as
 * indicated in
 * {@link <a href="https://wso2.org/jira/browse/TOOLS-1029">TOOLS-1029</a>}
 * 
 */
public class ArtifactProjectRenameParticipantPropertyTester extends PropertyTester {

	public boolean test(Object arg0, String arg1, Object[] arg2, Object arg3) {
		IProject projectToBeRenamed = (IProject) arg0;
		if (projectToBeRenamed.isOpen()) {
			IFile pomFile = projectToBeRenamed.getFile("pom.xml");
			// TODO: Add other validations including adding an unique WSO2
			// nature so that we can
			// identify
			if (pomFile.exists()) {
				return true;
			}
		}
		return false;
	}

}
