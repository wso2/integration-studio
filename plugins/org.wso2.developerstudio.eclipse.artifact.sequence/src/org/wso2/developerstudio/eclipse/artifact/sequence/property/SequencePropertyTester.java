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

package org.wso2.developerstudio.eclipse.artifact.sequence.property;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.wso2.developerstudio.eclipse.artifact.sequence.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class SequencePropertyTester extends PropertyTester{
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public boolean test(Object obj, String arg1, Object[] arg2, Object arg3) {
		if(obj instanceof IFile){
			try {
				File file = ((IFile)obj).getLocation().toFile();
				String content = FileUtils.getContentAsString(file);
				if(content.contains("<sequence")){
					return true;
				}
			} catch (IOException e) {
				log.error("I/O error has occurred", e);
			}
		}
		return false;
	}

}
