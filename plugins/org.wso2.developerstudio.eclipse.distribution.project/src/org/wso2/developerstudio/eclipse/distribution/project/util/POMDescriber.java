/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.XMLContentDescriber;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class POMDescriber extends XMLContentDescriber {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public int describe(InputStream input, IContentDescription description)
			throws IOException {
		try {
			MavenProject mavenPrj = MavenUtils.getMavenProject(input);
			if ("carbon/application".equals(mavenPrj.getModel().getPackaging())) {
				return VALID;
			}
		} catch (Exception e) {
			log.warn(e);
		}
		return INVALID;
	}
	
}
