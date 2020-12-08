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

package org.wso2.developerstudio.eclipse.samples.contributor;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public abstract class AbstractSampleContributor implements IDeveloperStudioSampleContributor {
	static String AXIS2_SAMPLE_TYPE="axis2";
	static String BPEL_SAMPLE_TYPE="bpel";
	static String DS_SAMPLE_TYPE="ds";
	static String DSVALIDATOR_SAMPLE_TYPE="dsvalidator";
	static String GADGET_SAMPLE_TYPE="gadget";
	static String PROXY_SAMPLE_TYPE="proxy";
	
	public void addSampleTo(IProject project) throws Exception {
    	ITemporaryFileTag sampleTempTag = FileUtils.createNewTempTag();
	    File resourceFile = getSampleResourceFile();
	    File tempDir = FileUtils.createTempDirectory();
	    File target = project.getLocation().toFile();
	    File projectTempLocation = new File(tempDir, project.getName());
	   
	    ArchiveManipulator archiveManipulator = new ArchiveManipulator();
	    archiveManipulator.extract(resourceFile, tempDir);
	    File[] listFiles = tempDir.listFiles();
	    String sampleName = listFiles[0].getName();
	    File sampleProjectTempLocation = new File(tempDir, sampleName);
	   
	    File projectDesc = new File(sampleProjectTempLocation,".project");
	    if(!sampleName.equals(project.getName())){
	    	if (projectDesc.exists() && projectDesc.isFile()){
	        	String parameterValue = project.getName();
	        	updateWithParameterData(projectDesc, parameterValue);
	        }
	    }
        
	    FileUtils.copyDirectoryContents(sampleProjectTempLocation, projectTempLocation);
        FileUtils.copyDirectoryContents(projectTempLocation, target);
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		project.close(new NullProgressMonitor());
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		project.open(new NullProgressMonitor());
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		sampleTempTag.clearAndEnd();
    }
	
	 public String getCopyResourceContentProjectName(String projectType){
			if(projectType.equals(AXIS2_SAMPLE_TYPE)){
				return "AccountServiceSampleProject";
			}else if(projectType.equals(BPEL_SAMPLE_TYPE)){
				return "HelloWorldWorkFlow" ;
			}else if(projectType.equals(DS_SAMPLE_TYPE)){
				return "EmployeeDataService";
			}else if(projectType.equals(DSVALIDATOR_SAMPLE_TYPE)){
				return "CustomDataserviceValidatorSample";
			}else if(projectType.equals(GADGET_SAMPLE_TYPE)){
				return "AcmeProductGadget";
			}else if(projectType.equals(PROXY_SAMPLE_TYPE)){
				return "SimpleStockQuoteESBSample";
			}else{
				return null;
			}
	    }

    public String getCopyResourceContentType(String sampleName){
		if(sampleName.contains("AccountServiceSampleProject")){
			return AXIS2_SAMPLE_TYPE;
		}else if(sampleName.contains("HelloWorldWorkFlow")){
			return BPEL_SAMPLE_TYPE;
		}else if(sampleName.contains("EmployeeDataService")){
			return DS_SAMPLE_TYPE;
		}else if(sampleName.contains("CustomDataserviceValidatorSample")){
			return DSVALIDATOR_SAMPLE_TYPE;
		}else if(sampleName.equals("AcmeProductGadget")){
			return GADGET_SAMPLE_TYPE;
		}else if(sampleName.contains("SimpleStockQuoteESBSample")){
			return PROXY_SAMPLE_TYPE;
		}else{
			return null;
		}
    }
    
    
	protected void updateWithParameterData(File projectDesc, String parameterValue)
            throws IOException {
	    String content = FileUtils.getContentAsString(projectDesc);
	    content = MessageFormat.format(content, parameterValue);
	    projectDesc.delete();
	    FileUtils.writeContent(projectDesc, content);
    }
    
	protected abstract File getSampleResourceFile() throws IOException;

    public void addSampleTo(File location) {
	    
    }

    public void addSampleTo(IFolder workspaceLocation) {
	    
    }

    public void createSample(Shell shell) {
	    
    }

    public boolean isCustomCreateSample() {
	    return false;
    }
    
    public String getProjectName() {
    	return null;
    }
    
    public void setProjectName(String projectName) {
    	
    }
    
}
