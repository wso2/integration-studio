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

package org.wso2.maven.esb.utils;

import org.wso2.maven.esb.ESBArtifact;
import org.wso2.maven.esb.ESBProjectArtifact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ESBMavenUtils {
	
	private static List<String> excludeList=new ArrayList<String>();

	static {
		excludeList.add(".svn");
	}
	

	public static List<ESBArtifact> retrieveArtifacts(File path){
		return retrieveArtifacts(new File(path, "artifact.xml"), new ArrayList<ESBArtifact>());
	}
	
	private static List<ESBArtifact> retrieveArtifacts(File path, List<ESBArtifact> artifacts){
		if (path.exists()){
			if (path.isFile()){
				ESBProjectArtifact artifact = new ESBProjectArtifact();
				try {
					artifact.fromFile(path);
					for (ESBArtifact esbArtifact : artifact.getAllESBArtifacts()) {
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
