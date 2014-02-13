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

package org.wso2.maven.registry.utils;

import org.wso2.maven.registry.GeneralProjectArtifact;
import org.wso2.maven.registry.RegistryArtifact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneralProjectMavenUtils {
	
	private static List<String> excludeList=new ArrayList<String>();

	static {
		excludeList.add(".svn");
	}
	

	public static List<RegistryArtifact> retrieveArtifacts(File path){
		return retrieveArtifacts(new File(path,"artifact.xml"), new ArrayList<RegistryArtifact>());
	}
	
	private static List<RegistryArtifact> retrieveArtifacts(File path, List<RegistryArtifact> artifacts){
		if (path.exists()){
			if (path.isFile()){
				GeneralProjectArtifact artifact = new GeneralProjectArtifact();
				try {
					artifact.fromFile(path);
					for (RegistryArtifact esbArtifact : artifact.getAllESBArtifacts()) {
						if (esbArtifact.getVersion()!=null && esbArtifact.getType()!=null){
							artifacts.add(esbArtifact);
						}
                    }
				} catch (Exception e) {
					//not an artifact
				}
			}else{
				File[] files = path.listFiles();
				for (File file : files) {
					if (!excludeList.contains(file.getName())) {
	                    retrieveArtifacts(file, artifacts);
                    }
				}
			}
		}
		return artifacts;
	}

}
