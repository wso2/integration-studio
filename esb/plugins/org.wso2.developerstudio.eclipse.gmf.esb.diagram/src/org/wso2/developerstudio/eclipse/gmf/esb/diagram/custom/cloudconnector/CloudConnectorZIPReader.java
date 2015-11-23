/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/*
 * This class is used to retrieve data from Cloud Connector ZIP file.
 * 
 */
public class CloudConnectorZIPReader {	
	private ZipFile zipFile;
	
	public ZipFile getZipFile() {
		return zipFile;
	}
	public void setZipFile(ZipFile zipFile) {
		this.zipFile = zipFile;
	}
	private CloudConnectorZIPReader(File file) throws ZipException, IOException{
		zipFile=new ZipFile(file);
	}
	/*
	 * static method for creating an instance of this class 
	 */
	public static CloudConnectorZIPReader getInstance(File file) throws ZipException, IOException{
		return new CloudConnectorZIPReader(file);
	}
	
	public InputStream getFileContentInZIP(String name) throws IOException{
		return zipFile.getInputStream(zipFile.getEntry(name));
	}
}
