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

package org.wso2.developerstudio.eclipse.registry.base.util;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class Utils {
	public static final String READ = "Read";
	public static final String WRITE = "Write";
	public static final String DELETE = "Delete";
	public static final String AUTHORIZE = "Authorize";

	public static void getFolderFileCount(File path,
			ResourceCounter resourceCount) {
		if (!path.exists())
			return;
		if (path.isFile()) {
			resourceCount.fileCount += 1;
			return;
		} else
			resourceCount.folderCount += 1;
		File[] files = path.listFiles();
		for (File file : files) {
			getFolderFileCount(file, resourceCount);
		}
	}

	public static class ResourceCounter {
		public int folderCount = 0;
		public int fileCount = 0;
	}
	
	public static boolean isValidServerURL(String serverURL){
		try {
		   HttpURLConnection.setFollowRedirects(false);
		   URL url = new URL(serverURL);
		   int port = url.getPort();
		   if (port==-1){
			   port=(url.getProtocol().equalsIgnoreCase("http")?80:443);
		   }
		   Socket socket = new Socket(url.getHost(),port);
		   socket.getInputStream();
		   if (socket.isConnected()){
			   return true;
		   }else{
			   return false;
		   }
//		   HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		   con.setRequestMethod("HEAD");
//		   return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
	    }catch (Exception e) {
	    	return false;
	    }
	}
}
