/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class DataserviceUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static File getDataserviceSchemaPath() {
		URL resource =
		               Platform.getBundle(Activator.PLUGIN_ID)
		                       .getResource("schema/DataService.xsd");
		IPath path = Activator.getDefault().getStateLocation();
		IPath libFolder = path.append("schema");
		String[] paths = resource.getFile().split("/");
		IPath library = libFolder.append(paths[paths.length - 1]);
		File libraryFile = new File(library.toOSString());
		if (libraryFile.exists())
			return libraryFile;
		try {
			writeToFile(libraryFile, resource.openStream());
		} catch (IOException e) {
			log.error(e);
			return null;
		}
		return libraryFile;
	}

	private static void writeToFile(File file, InputStream stream) throws IOException {
		file.getParentFile().mkdirs();
		OutputStream out = new FileOutputStream(file);
		byte buf[] = new byte[1024];
		int len;
		while ((len = stream.read(buf)) > 0)
			out.write(buf, 0, len);
		out.close();
		stream.close();
	}
}
