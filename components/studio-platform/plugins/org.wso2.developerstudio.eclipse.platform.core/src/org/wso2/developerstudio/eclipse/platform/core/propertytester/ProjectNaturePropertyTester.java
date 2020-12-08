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

package org.wso2.developerstudio.eclipse.platform.core.propertytester;

import org.eclipse.core.internal.propertytester.ResourcePropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IPackageFragment;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

/**
 * A property tester for project-nature property of resources/package-fragments
 * 
 * e.g.
 * 
 * <pre>
 * <adapt type="org.eclipse.jdt.core.IPackageFragment">
 * <test property="org.wso2.developerstudio.projectNature"
 * 	value="org.wso2.developerstudio.eclipse.jaxrs.project.nature" />
 * </adapt>
 * </pre>
 *
 * @since 2.2.0
 */
public class ProjectNaturePropertyTester extends ResourcePropertyTester {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IResource) {
			return super.test(receiver, property, args, expectedValue);
		} else if (receiver instanceof IPackageFragment) {
			IPackageFragment packageFragment = (IPackageFragment) receiver;
			try {
				if (packageFragment.getJavaProject().getProject().hasNature(expectedValue.toString())) {
					return true;
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return false;
	}

}
