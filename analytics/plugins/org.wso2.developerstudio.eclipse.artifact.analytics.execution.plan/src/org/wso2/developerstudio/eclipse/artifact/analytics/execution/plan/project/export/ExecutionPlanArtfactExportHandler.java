/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.execution.plan.project.export;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecutionPlanArtfactExportHandler extends ProjectArtifactHandler{

    public List<IResource> exportArtifact(IProject project) throws Exception {
    	List<IResource> exportResources = new ArrayList<IResource>();
			 File[] siddhiqlfiles = FileUtils.getAllMatchingFiles(project.getLocation()
					.toString(), null, AnalyticsConstants.EXTENTION_EXECUTION_PLAN,
					   new ArrayList<File>());
			 for(File siddhiqlfile : siddhiqlfiles) {
				if(isExecution_plan(siddhiqlfile)) {
					String siddhiqlFileLocation = siddhiqlfile.toString()
					.replaceAll(
							"^" + project.getLocation().toString()
									+ File.separator, "");
					IFile siddhiqlFileRef = project.getFile(siddhiqlFileLocation);
					exportResources.add((IResource) siddhiqlFileRef);
				}
			 }
		return exportResources;
    }
    
    private boolean isExecution_plan(File siddhiqlFile) throws IOException{
		
		FileReader fileReader = new FileReader(siddhiqlFile);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();
		String originalName = FilenameUtils.getBaseName(siddhiqlFile.getAbsolutePath());
		String regExecutionplan = "\\@(Plan:name)\\('("+originalName+")'\\)";
		Pattern patternExecutionplan = Pattern.compile(regExecutionplan);
		while (line != null){
			Matcher matcherExecutionplan = patternExecutionplan.matcher(line);
			if (matcherExecutionplan.find()) {
				fileReader.close();
				reader.close();
				return true;
			}
		line = reader.readLine();
		}

		fileReader.close();
		reader.close();
		return false;
		
	}

}
