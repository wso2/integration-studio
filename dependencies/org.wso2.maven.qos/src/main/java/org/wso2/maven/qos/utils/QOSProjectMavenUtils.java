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

package org.wso2.maven.qos.utils;

import org.wso2.maven.qos.QOSProjectArtifact;
import org.wso2.maven.qos.QOSArtifact;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QOSProjectMavenUtils {
	
	private static List<String> excludeList=new ArrayList<String>();

	static {
		excludeList.add(".svn");
	}
	

	public static List<QOSArtifact> retrieveArtifacts(File path){
		return retrieveArtifacts(new File(path,"artifact.xml"), new ArrayList<QOSArtifact>());
	}
	
	private static List<QOSArtifact> retrieveArtifacts(File path, List<QOSArtifact> artifacts){
		if (path.exists()){
			if (path.isFile()){
				QOSProjectArtifact artifact = new QOSProjectArtifact();
				try {
					artifact.fromFile(path);
					for (QOSArtifact esbArtifact : artifact.getAllServiceMetaArtifacts()) {
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
