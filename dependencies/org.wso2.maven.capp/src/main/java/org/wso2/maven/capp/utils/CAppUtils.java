package org.wso2.maven.capp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.wso2.maven.capp.model.Artifact;

public class CAppUtils {
	public static final String PROPERTY_CAPP_TYPE = "CApp.type";
	private static List<String> excludeList=new ArrayList<String>();

	static {
		excludeList.add(".svn");
	}

	public static List<Artifact> retrieveArtifacts(File path){
		return retrieveArtifacts(path, new ArrayList<Artifact>());
	}
	
	public static List<Artifact> retrieveArtifacts(File path, List<Artifact> artifacts){
		if (path.exists()){
			if (path.isFile()){
				Artifact artifact = new Artifact();
				try {
					artifact.fromFile(path);
					if (artifact.getVersion()!=null && artifact.getType()!=null){
						artifact.setSuperArtifact(artifact.getType().equalsIgnoreCase("carbon/application"));
						artifacts.add(artifact);
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
