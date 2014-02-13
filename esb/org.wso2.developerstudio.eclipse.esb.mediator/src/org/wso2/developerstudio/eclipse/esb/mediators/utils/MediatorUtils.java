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

package org.wso2.developerstudio.eclipse.esb.mediators.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.esb.mediators.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class MediatorUtils {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static List<File> getDependencyPath(){
		List<URL> urlList = new ArrayList<URL>();
		URL libFolderResource = Platform.getBundle(Activator.PLUGIN_ID).getResource("lib");
		try {
			String libFolderPath = FileLocator.toFileURL(libFolderResource).getPath();
			File libDir = new File(libFolderPath);
			if(libDir.isDirectory()){
				File[] list = libDir.listFiles();
				for (File libFile : list) {
					if(libFile.getPath().endsWith(".jar")){
						URI abc = libFile.toURI();
						URL libURL = abc.toURL();
						urlList.add(libURL);
					}
				}
			}
		} catch (IOException e) {
			log.error(e);
		} 

		IPath path = Activator.getDefault().getStateLocation();
		IPath libFolder = path.append("lib");
		List<File> libraryFileList = new ArrayList<File>();
		for (URL resource : urlList) {
			String[] paths = resource.getFile().split("/");
			IPath library = libFolder.append(paths[paths.length-1]);
			File libraryFile = new File(library.toOSString());
			try {
		        writeToFile(libraryFile, resource.openStream());
	        } catch (IOException e) {
		        log.error(e);
		        return null;
	        }
	        if(!libraryFileList.contains(libraryFile)){
	        	libraryFileList.add(libraryFile);
	        }
		}
		
		return libraryFileList;
	}
	public static File getSynapseLibraryPath(){
		URL resource = Platform.getBundle(Activator.PLUGIN_ID).getResource("lib/org.apache.synapse.synapse-core-1.4.0.wso2v1.jar");
		IPath path = Activator.getDefault().getStateLocation();
		IPath libFolder = path.append("lib");
		String[] paths = resource.getFile().split("/");
		IPath library = libFolder.append(paths[paths.length-1]);
		File libraryFile = new File(library.toOSString());
		if (libraryFile.exists()){
			 return libraryFile;
		}
		try {
	        writeToFile(libraryFile, resource.openStream());
        } catch (IOException e) {
	        log.error(e);
	        return null;
        }
		
		return libraryFile;
	}
	
	private static void writeToFile(File file, InputStream stream) throws IOException{
		file.getParentFile().mkdirs();
	    OutputStream out=new FileOutputStream(file);
	    byte buf[]=new byte[1024];
	    int len;
	    while((len=stream.read(buf))>0)
	    	out.write(buf,0,len);
	    out.close();
	    stream.close();
	}
}
